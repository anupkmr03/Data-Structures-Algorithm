package thread;

public class FizzBuzzRunner {
	public static void main(String[] args) {
		int start = 1;
		int end = 20;
		FizzBuzzPrinter res = new FizzBuzzPrinter();
		Thread t1 = new Thread(new FizzBuzzThread(res, start, end));
		Thread t2 = new Thread(new FizzThread(res, start, end));
		Thread t3 = new Thread(new BuzzThread(res, start, end));
		Thread t4 = new Thread(new NumberThread(res, start, end));

		t1.start();
		t2.start();
		t3.start();
		t4.start();

	}
}

class FizzBuzzPrinter {

	boolean isFizzBuzzPrinted = true;
	boolean isFizzPrinted = true;
	boolean isBuzzPrinted = true;
	boolean isNumberPrinted = false;

	public synchronized void printFizzBuzz(int i) throws InterruptedException {
		if (!isFizzPrinted && !isBuzzPrinted && !isNumberPrinted)
			wait();

		if (i % 3 == 0 && i % 5 == 0) {
			System.out.println(Thread.currentThread().getName() + "FizzBuzz");
			isFizzPrinted = false;
			isBuzzPrinted = false;
			isNumberPrinted = false;
			isFizzBuzzPrinted = true;
			notifyAll();
		}
	}

	public synchronized void printFizz(int i) throws InterruptedException {
		if (!isFizzBuzzPrinted && !isBuzzPrinted && !isNumberPrinted)
			wait();

		if (i % 3 == 0) {
			System.out.println(Thread.currentThread().getName() + "Fizz");
			isFizzBuzzPrinted = false;
			isBuzzPrinted = false;
			isNumberPrinted = false;
			isFizzPrinted = true;
			notifyAll();
		}
	}

	public synchronized void printBuzz(int i) throws InterruptedException {
		if (!isFizzPrinted && !isFizzBuzzPrinted && !isNumberPrinted)
			wait();

		if (i % 5 == 0) {
			System.out.println(Thread.currentThread().getName() + "Buzz");
			isFizzBuzzPrinted = false;
			isFizzPrinted = false;
			isNumberPrinted = false;
			isBuzzPrinted = true;
			notifyAll();
		}
	}

	public synchronized void printNumber(int i) throws InterruptedException {

		if (!isFizzPrinted && !isBuzzPrinted && !isFizzBuzzPrinted)
			wait();

		if (i % 3 != 0 && i % 5 != 0) {
			System.out.println(Thread.currentThread().getName() + " " + i);
			isFizzBuzzPrinted = false;
			isFizzPrinted = false;
			isBuzzPrinted = false;
			isNumberPrinted = true;
			notifyAll();
		}
	}
}

class FizzBuzzThread implements Runnable {
	FizzBuzzPrinter printer;
	int start, end;

	public FizzBuzzThread(FizzBuzzPrinter printer, int start, int end) {
		this.printer = printer;
		this.start = start;
		this.end = end;
	}

	@Override
	public void run() {

		try {
			printer.printFizzBuzz(10); // random
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}

}

class FizzThread implements Runnable {
	FizzBuzzPrinter printer;
	int start, end;

	public FizzThread(FizzBuzzPrinter printer, int start, int end) {
		this.printer = printer;
		this.start = start;
		this.end = end;
	}

	@Override
	public void run() {
		for (int i = 1; i < 20; i++) {
			try {
				printer.printFizz(i);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}

class BuzzThread implements Runnable {
	FizzBuzzPrinter printer;
	int start, end;

	public BuzzThread(FizzBuzzPrinter printer, int start, int end) {
		this.printer = printer;
		this.start = start;
		this.end = end;
	}

	@Override
	public void run() {
		for (int i = 1; i < 20; i++) {
			try {
				printer.printBuzz(i);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}

class NumberThread implements Runnable {
	FizzBuzzPrinter printer;
	int start, end;

	public NumberThread(FizzBuzzPrinter printer, int start, int end) {
		this.printer = printer;
		this.start = start;
		this.end = end;
	}

	@Override
	public void run() {
		for (int i = 1; i < 20; i++) {
			try {
				printer.printNumber(i);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
