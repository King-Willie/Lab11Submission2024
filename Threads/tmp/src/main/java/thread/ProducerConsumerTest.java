package thread;

/*
class ProducerConsumerTest {
	public static void main(String args[]) throws InterruptedException {
		CubbyHole c = new CubbyHole();
		Producer p1 = new Producer(c, 1);
		Consumer c1 = new Consumer(c, 1);
		p1.start();
		// just a stress
		Thread.sleep(500);
		c1.start();
	}
}
*/

public class ProducerConsumerTest {
    public static void main(String[] args) {
        Printer printer = new Printer();
        for (int i = 1; i <= 20; i++) {
            Module2 thread = new Module2(printer, i);
            thread.start();
        }
    }
}