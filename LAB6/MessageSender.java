package lab002;

public class MessageSender {

    // synchronized method to send a message
    public synchronized void sendMessage(String msg) {
        for (int i = 0; i < msg.length(); i++) {
            System.out.print(msg.charAt(i));
            try {
                Thread.sleep(50); // small delay to simulate work and possible mixing
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(); // move to next line after full message
    }

    public static void main(String[] args) {
        MessageSender sender = new MessageSender();

        Thread t1 = new Thread(() -> {
            sender.sendMessage("Hello from Thread 1");
        });

        Thread t2 = new Thread(() -> {
            sender.sendMessage("Greetings from Thread 2");
        });

        t1.start();
        t2.start();
    }
}
