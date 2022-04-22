package Task1;

public class Main {
    public static void main(String[] args) {
        
    Numbers numbers = new Numbers();

    Runnable first = () -> {
        try {
            numbers.print(10, "1");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    };

    Runnable second = () -> {
        try {
            numbers.print(10, "2");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    };

    Thread one = new Thread(first);
    Thread two = new Thread(second);

    one.start();
    two.start();
    System.out.println("Старт");
    }
}

