package thread;

class Printer {
    private int nextThread = 1;
    
    //Take a Thread 
    public synchronized void print(Thread thread) {
    //Get Thread #
        int threadNumber = Integer.parseInt(thread.getName());
    //While Thread is ! up next wait its turn
        while (threadNumber != nextThread) {
            try {
                wait();
            } catch (InterruptedException e) {  	
            }
        }
    //When is turn print #, increase next thread, and notify existing threads
        System.out.println("Thread #" + threadNumber);
        nextThread++; 
        notifyAll(); 
    }
}

class Module2 extends Thread {
    private Printer printer;
    
    public Module2(Printer printer, int number) {
        this.printer = printer;
        this.setName(String.valueOf(number));
    }

    public void run() {
        printer.print(this);
    }
}


