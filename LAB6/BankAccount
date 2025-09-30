package lab002;


public class BankAccount {
	    private int balance = 1000;

	    public synchronized void withdraw(int amount, String person) {
	        if (balance >= amount) {
	            System.out.println(person + " is about to withdraw " + amount);
	            try {
	                Thread.sleep(100);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	            balance -= amount;
	            System.out.println(person + " completed withdrawal. Remaining balance: " + balance);
	        } else {
	            System.out.println(person + " tried to withdraw " + amount + " but insufficient balance.");
	        }
	    }

	    public static void main(String[] args) {
	        BankAccount account = new BankAccount();

	        Thread person1 = new Thread(() -> {
	            account.withdraw(700, "Person1");
	        });

	        Thread person2 = new Thread(() -> {
	            account.withdraw(700, "Person2");
	        });

	        person1.start();
	        person2.start();
	    }
	}
