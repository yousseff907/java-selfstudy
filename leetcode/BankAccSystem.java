
import java.util.*;

/*
Design a banking system with:
- Account (base class with account number, balance)
- SavingsAccount (with interest rate)  
- CheckingAccount (with overdraft limit)
- Bank (manages multiple accounts)

Include methods for deposit, withdraw, transfer between accounts.
Handle insufficient funds and overdraft scenarios.
*/

abstract class Account
{
    protected String accountNumber;
    protected double balance;
    
    // Your design here
    public abstract boolean withdraw(double amount);
    public abstract void deposit(double amount);
}

class SavingsAccount extends Account
{
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate)
	{
		this.accountNumber = accountNumber;
		this.interestRate = interestRate;
		this.balance = balance + (balance * interestRate);
	}

	@Override
	public boolean withdraw(double amount)
	{
		if (amount < 0)
			return (false);

		else if (amount > balance)
			return (false);

		else
		{
			balance -= amount;
			System.out.println(amount + " has been withdrawn.");
			return (true);
		}
	}

	@Override
	public void deposit(double amount)
	{
		if (amount >= 0)
			balance += amount;
		else
			System.err.println("Amount cant be negative");
	}

}

class CheckingAccount extends Account
{
	private double overdraftLimit;

	public CheckingAccount(String accountNumber, double balance, double overdraftLimit)
	{
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.overdraftLimit = overdraftLimit;
	}

	@Override
	public boolean withdraw(double amount)
	{
		if (amount < 0)
			return (false);

		else if (amount > balance + overdraftLimit)
			return (false);

		else
		{
			balance -= amount;
			System.out.println(amount + " has been withdrawn.");
			return (true);
		}
	}

	@Override
	public void deposit(double amount)
	{
		if (amount >= 0)
			balance += amount;
		else
			System.err.println("Amount cant be negative");
	}

}

class Bank
{
    private Map<String, Account> accounts;
	private String name;

	public Bank(String name)
	{
		this.name = name;
		this.accounts = new HashMap<>();
	}

	public void addToBank(String accountNumber, Account account)
	{
		if (accounts.containsKey(accountNumber))
			throw new IllegalArgumentException("Error account number already present");
		else
			accounts.put(accountNumber, account);
	}

	public boolean transfer(String sender_number, double sending, String recipient)
	{
		if (!(accounts.containsKey(sender_number)) || !(accounts.containsKey(recipient)))
			return (false);

		else if (sending < 0)
			return (false);

		Account sender = accounts.get(sender_number);
		Account	recipientAccount = accounts.get(recipient);

		if (sender.balance < sending)
			return (false);

		else
		{
			recipientAccount.balance += sending;
			sender.balance -= sending;
			return (true);
		}
	}
}


// Main with test cases by Claude AI

public class BankAccSystem
{
	public static void showBalances(SavingsAccount savings, CheckingAccount checking)
	{
		System.out.println("Savings Balance: $" + savings.balance);
		System.out.println("Checking Balance: $" + checking.balance);
		System.out.println("---");
	}
	
	public static void main(String[] args)
	{
		Bank bank = new Bank("Test Bank");
		
		SavingsAccount savings = new SavingsAccount("SAV001", 1000.0, 0.02);
		CheckingAccount checking = new CheckingAccount("CHK001", 500.0, 200.0);

		bank.addToBank("SAV001", savings);
		bank.addToBank("CHK001", checking);
		
		System.out.println("=== Initial Balances ===");
		showBalances(savings, checking);

		System.out.println("=== Testing Deposits ===");
		savings.deposit(100);
		checking.deposit(50);
		showBalances(savings, checking);
		
		System.out.println("=== Testing Withdrawals ===");
		savings.withdraw(150);
		showBalances(savings, checking);
		
		checking.withdraw(600);
		showBalances(savings, checking);
		
		savings.withdraw(2000);
		showBalances(savings, checking);
		
		System.out.println("=== Testing Transfer ===");
		bank.transfer("SAV001", 100, "CHK001");
		showBalances(savings, checking);
		
		bank.transfer("CHK001", 50, "SAV001");
		showBalances(savings, checking);
		
		bank.transfer("INVALID", 100, "SAV001"); // Should fail
		showBalances(savings, checking);
		
		System.out.println("=== Testing Edge Cases ===");
		savings.deposit(-50);
		checking.withdraw(-100);
		showBalances(savings, checking);
	}
}