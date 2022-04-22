package Task2;

//Задача
//Тренировка метода join().Добавляю в метод main(), поток класса Worker. 
public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Запуск метода main");
        Thread thread = new Thread(new Worker());
        thread.start();
        thread.join(4000);
        System.out.println("Метод main завершен");
    }    
}

class Worker implements Runnable {

    @Override
    public void run() {
        System.out.println("Начало работы");
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Конец работы");
    }
    
}


