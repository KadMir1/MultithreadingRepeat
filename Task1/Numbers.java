package Task1;

public class Numbers {
    //Задача
    //Вызывать 2 потока. Один поток выводит "1", а второй "2"

    synchronized void print(int a, String s) throws InterruptedException {
        for(int i = 0; i < a; i++) {
            Thread.sleep(i*100);
            System.out.println(s);
        }
        System.out.println("Конец " + s);
    }
    

}