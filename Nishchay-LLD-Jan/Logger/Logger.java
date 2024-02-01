package Design_Patterns.Creational.Singleton.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {

	private static Logger logger = null;
	private final static String logfile = "/Users/kumarnishchay/iCloud Drive (Archive)/Desktop/LLD_questions/LLD/src/Design_Patterns/Creational/Singleton/demo_log1.txt";
	private static PrintWriter writer = null;

	private Logger() {

	}

	public static Logger getInstance() {
		if (logger == null) {
			logger = new Logger();
		}
		return logger;

	}

	public static PrintWriter getInstanceWriter() {
		if (writer == null) {
			FileWriter fw = null;
			try {
				fw = new FileWriter(logfile);
				writer = new PrintWriter(fw, true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return writer;

	}

//	public void logWithdraw(String account, double amount) {
//		writer.println("WITHDRAW (" + account + "): " + amount + "$");
//	}
//
//	public void logDeposit(String account, double amount) {
//		writer.println("DEPOSIT (" + account + "): " + amount + "$");
//	}
//
//	public void logTransfer(String fromAccount, String toAccount, double amount) {
//		writer.println("TRANSFER (" + fromAccount + "->" + toAccount + "):" + amount + "$");
//	}

}
