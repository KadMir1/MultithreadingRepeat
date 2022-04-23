package Task3;

public class SynchronizedBlock {
    public static void main(String[] args) {
        MyRunnableImpl runnable = new MyRunnableImpl();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Counter {
    volatile static int count = 0;
}

class MyRunnableImpl implements Runnable {
    
    private void doWork1() {
        System.out.println("Ура!!!");
    }

    private void doWork2() {
        doWork1();
        synchronized(this) {
            Counter.count++;
            System.out.println(Counter.count);
        }
    }

    @Override
    public void run() {
        for(int i = 0; i < 3; i++) {
            doWork2();
        }
        
    }
}