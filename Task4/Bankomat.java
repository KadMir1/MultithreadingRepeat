package Task4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bankomat {
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        new Employee("Олег", lock);
        new Employee("Тимур", lock);
        new Employee("Елена", lock);
        Thread.sleep(5000);
        new Employee("Артём", lock);
        new Employee("Инна", lock);

    }
}

class Employee extends Thread {
    String name;
    private Lock lock;

    public Employee(String name, Lock lock) {
        this.name = name;
        this.lock = lock;
        this.start();
    }

    @Override
    public void run() {
       if(lock.tryLock()) {
         try {
             System.out.println(name + " пользуется банкоматом");
             Thread.sleep(2000);
             System.out.println(name + " завершил(а) свои дела");
         } catch (InterruptedException e){
            e.printStackTrace();                
         } finally {
             lock.unlock();
         }
       } else {
           System.out.println(name + " не хочет ждать очереди");
       }
    }
}