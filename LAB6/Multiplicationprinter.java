package lab002;

public class MultiplicationTable {
    
    public synchronized void printTable(int number) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " x " + i + " = " + (number * i));
            try {
                Thread.sleep(100); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MultiplicationTable table = new MultiplicationTable();

        Thread t1 = new Thread(() -> {
            table.printTable(5);
        }, "Thread-1");

        Thread t2 = new Thread(() -> {
            table.printTable(5);
        }, "Thread-2");

        t1.start();
        t2.start();
    }
}
