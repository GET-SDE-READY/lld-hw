package Design_Patterns.Creational.Singleton.Logger;

public class Main {

	public static void main(String[] args) {

		Logger logger1 = Logger.getInstance();
		Logger logger2 = Logger.getInstance();
		Logger logger3 = Logger.getInstance();

		TransactonsImpl t1 = new TransactonsImpl();
		TransactonsImpl t2 = new TransactonsImpl();
		TransactonsImpl t3 = new TransactonsImpl();

		t1.logDeposit("0001", 80.5);
		t2.logWithdraw("0002", 100);
		t1.logTransfer("0001", "0003", 40);
		t3.logDeposit("0004", 56.74);
		t2.logWithdraw("0005", 30);

	}

}
