package unsynch;

/**
 * This program shows data corruption when multiple threads access a data structure.
 * @author michaelnwani
 *
 */
public class UnsynchBankTest 
{
	public static final int NACCOUNTS = 100;
	public static final double INITIAL_BALANCE = 1000;
	
	public static void main(String... args)
	{
		Bank b = new Bank(NACCOUNTS, INITIAL_BALANCE);
		int i; //a thread is created per loop (+1 number), just as i is incremented per iteration
		for (i = 0; i < NACCOUNTS; i++)
		{
			TransferRunnable r = new TransferRunnable(b, i, INITIAL_BALANCE);
			Thread t = new Thread(r);
			t.start();
		}
	}
}
