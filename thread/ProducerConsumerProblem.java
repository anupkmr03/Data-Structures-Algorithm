package thread;
import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerProblem {
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();

		Thread producer = new Thread(new Producer(queue));
		Thread consumer = new Thread(new Consumer(queue));
		producer.start();
		consumer.start();
	}

	static class Producer implements Runnable {

		Queue<Integer> queue;
		final int MAX;
		int i = 0;

		public Producer(Queue<Integer> queue) {
			this.queue = queue;
			this.MAX = 5;
		}

		@Override
		public void run() {
			while (true) {
				try {
					this.produce(i++);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		private void produce(int i) throws InterruptedException {
			synchronized (queue) {
				while (queue.size() == MAX) {
					System.out.println("Queue is full... waiting for consumer to consume.");
					queue.wait();
				}
			}

			synchronized (queue) {
				System.out.println("Producer #item " + i + " +++ ");
				queue.add(i);
				Thread.sleep(100);
				queue.notify();
			}
		}

	}

	static class Consumer implements Runnable {

		Queue<Integer> queue;

		public Consumer(Queue<Integer> queue) {
			this.queue = queue;
		}

		@Override
		public void run() {
			while (true) {
				try {
					this.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		public void consume() throws InterruptedException {
			synchronized (queue) {
				while (queue.isEmpty()) {
					System.out.println("Queue is empty... waiting for producer to produce.");
					queue.wait();
				}
			}
			synchronized (queue) {
				System.out.println("Consumer #item " + queue.poll()+" --- ");

				Thread.sleep(1000);
				queue.notify();
			}
		}
	}
}
