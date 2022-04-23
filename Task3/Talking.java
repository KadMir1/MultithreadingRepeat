package Task3;

public class Talking {

    static final Object lock = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new RunnbleImplMobile());
        Thread thread2 = new Thread(new RunnbleImplSkype());
        Thread thread3 = new Thread(new RunnbleImplDiscord());

        thread1.start();
        thread2.start();
        thread3.start();
    }

    
    void mobileCall() {
        synchronized(lock) {
            System.out.println("Мобильный разговор начался.");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Мобильный разговор закончился.");
        }
    }

    void skypeCall() {
        synchronized(lock) {
            System.out.println("Разговор по Skype начался.");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Разговор по Skype закончился.");
        }                                               
    }

    void discordCall() {
        synchronized(lock) {
            System.out.println("Разговор по Discord начался.");
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Разговор по Discord закончился.");
        }              
    }  
}

class RunnbleImplMobile implements Runnable {

    @Override
    public void run() {
        new Talking().mobileCall();    
    }  
}

class RunnbleImplSkype implements Runnable {

    @Override
    public void run() {
        new Talking().skypeCall();
    }   
}

class RunnbleImplDiscord implements Runnable {

    @Override
    public void run() {
        new Talking().discordCall();   
    }   
}
 