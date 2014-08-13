package unsynch;

/**
 * A runnable that transfers money from an account to other accounts in a bank
 * @author michaelnwani
 *
 */
public class TransferRunnable implements Runnable
{
	private Bank bank;
	private int fromAccount;
	private double maxAmount;
	private int DELAY = 10;
	
	/**
	 * Constructs a transfer runnable.
	 * @param b the bank between whose account money is transferred
	 * @param from the account to transfer money from
	 * @param max the maximum amount of money in each transfer
	 */
	public TransferRunnable(Bank b, int from, double max)
	{
		bank = b;
		fromAccount = from;
		maxAmount = max;
	}
	
	public void run() //the thread will always execute the run method's 'task' (all the code in here).
	{
		try
		{
			while (true)
			{
				int toAccount = (int) (bank.size() * Math.random());
				double amount = maxAmount * Math.random();
				bank.transfer(fromAccount, toAccount, amount);
				Thread.sleep((int) (DELAY * Math.random())); //output is most likely weird because we're sleeping select threads for a random duration of time. Also, synchronization is weird.
			}
		}
		catch (InterruptedException e)
		{
			//
		}
	}
}