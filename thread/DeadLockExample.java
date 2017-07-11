package thread;

public class DeadLockExample {
	public static void main(String[] args) {
		Thread tx = new Thread(new ThreadX());
		Thread ty = new Thread(new ThreadY());
		tx.start();
		ty.start();

	}
}

class ThreadX implements Runnable {

	@Override
	public void run() {
		synchronized (String.class) {
			System.out.println(Thread.currentThread().getName() + " aquires the Lock 1");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " waiting for Lock2");
			synchronized (Object.class) {
				System.out.println(Thread.currentThread().getName() + " aquires the Lock 1 & Lock2");
			}
		}
	}

}

class ThreadY implements Runnable {

	@Override
	public void run() {
		synchronized (Object.class) {
			System.out.println(Thread.currentThread().getName() + " aquires the Lock 2");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " waiting for Lock1");

			synchronized (String.class) {
				System.out.println(Thread.currentThread().getName() + " aquires the Lock 1 & Lock2");
			}
		}
	}

}
