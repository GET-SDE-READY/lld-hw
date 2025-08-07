package Design_Patterns.Creational.Singleton.Logger;

import java.io.PrintWriter;

public class TransactonsImpl implements Transactions {

	PrintWriter writer = Logger.getInstanceWriter();

	public void logWithdraw(String account, double amount) {
		writer.println("WITHDRAW (" + account + "): " + amount + "$");
	}

	public void logDeposit(String account, double amount) {
		writer.println("DEPOSIT (" + account + "): " + amount + "$");
	}

	public void logTransfer(String fromAccount, String toAccount, double amount) {
		writer.println("TRANSFER (" + fromAccount + "->" + toAccount + "):" + amount + "$");
	}

}
