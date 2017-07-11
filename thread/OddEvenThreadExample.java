package thread;

public class OddEvenThreadExample {
	public static void main(String[] args) {
		PrintOddEven resouce = new PrintOddEven();
		Thread t1 = new Thread(new OddThread(resouce));
		Thread t2 = new Thread(new EvenThread(resouce));
		t1.setName("OddThread");
		t2.setName("EvenThread");
		t1.start();
		t2.start();

	}

}

class OddThread implements Runnable {
	PrintOddEven obj;

	public OddThread(PrintOddEven obj) {
		this.obj = obj;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 20; i = i + 2) {
			try {
				obj.printOdd(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

class EvenThread implements Runnable {
	PrintOddEven obj;

	public EvenThread(PrintOddEven obj) {
		this.obj = obj;
	}

	@Override
	public void run() {
		for (int i = 2; i <= 20; i = i + 2) {
			try {
				obj.printEven(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

class PrintOddEven {
	boolean isEvenPrinted = true;

	public void printOdd(int num) throws InterruptedException {
		synchronized (this) {
			if (!isEvenPrinted)
				wait();
			System.out.println(Thread.currentThread().getName() + "  : " + num);
			isEvenPrinted = false;
			notify();

		}
	}

	public void printEven(int num) throws InterruptedException {
		synchronized (this) {
			if (isEvenPrinted)
				wait();

			System.out.println(Thread.currentThread().getName() + " : " + num);
			isEvenPrinted = true;
			notify();

		}
	}
}
