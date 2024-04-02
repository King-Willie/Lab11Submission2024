package thread;

class CubbyHole {
	private int seq;
	private boolean available = false;
	private int maxProduct = 10;
	private int currentProduct = 0;

	public synchronized int get() {
		while (!available || currentProduct == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		available = false;
		currentProduct--;
		notify();
		return seq;
	}

	public synchronized void put(int value) {
		while (available || currentProduct >= maxProduct) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		seq = value;
		available = true;
		currentProduct++;
		notify();
		
	}
}