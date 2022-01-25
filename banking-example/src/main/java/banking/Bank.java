package banking;

import java.util.LinkedHashMap;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {
	private LinkedHashMap<Long, Account> accounts;

	public Bank() {
		accounts = new LinkedHashMap<Long, Account>();
	}

	private Account getAccount(Long accountNumber) {
		return accounts.get(accountNumber);
	}

	public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
		Long accountNumber = Long.valueOf(accounts.size()) + 1;
		CommercialAccount account = new CommercialAccount(company, accountNumber, pin, startingDeposit);
		accounts.put(accountNumber, account);
		return accountNumber;
	}

	public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
		Long accountNumber = Long.valueOf(accounts.size()) + 1;
		ConsumerAccount account = new ConsumerAccount(person, accountNumber, pin, startingDeposit);
		accounts.put(accountNumber, account);
		return accountNumber;
	}

	public boolean authenticateUser(Long accountNumber, int pin) {
		return getAccount(accountNumber).validatePin(pin);
	}

	public double getBalance(Long accountNumber) {
		return getAccount(accountNumber).getBalance();
	}

	public void credit(Long accountNumber, double amount) {
		getAccount(accountNumber).creditAccount(amount);
	}

	public boolean debit(Long accountNumber, double amount) {
		return getAccount(accountNumber).debitAccount(amount);
	}
}
