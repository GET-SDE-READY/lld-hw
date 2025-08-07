package Design_Patterns.Creational.Singleton.Logger;

public interface Transactions {

	public void logWithdraw(String account, double amount);

	public void logDeposit(String account, double amount);

	public void logTransfer(String fromAccount, String toAccount, double amount);

}
