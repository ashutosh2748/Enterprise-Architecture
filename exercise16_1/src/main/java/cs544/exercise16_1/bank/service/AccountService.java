package cs544.exercise16_1.bank.service;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;

//import cs544.exercise16_1.bank.dao.AccountDAO;
import cs544.exercise16_1.bank.dao.HibernateDAO;
import cs544.exercise16_1.bank.dao.HibernateUtil;
import cs544.exercise16_1.bank.dao.IAccountDAO;
import cs544.exercise16_1.bank.domain.Account;
import cs544.exercise16_1.bank.domain.Customer;
import cs544.exercise16_1.bank.jms.IJMSSender;
import cs544.exercise16_1.bank.jms.JMSSender;
import cs544.exercise16_1.bank.logging.ILogger;
import cs544.exercise16_1.bank.logging.Logger;





public class AccountService implements IAccountService {
	private IAccountDAO accountDAO;
	private ICurrencyConverter currencyConverter;
	private IJMSSender jmsSender;
	private ILogger logger;
	
	public AccountService(){
		accountDAO=new HibernateDAO();
		currencyConverter= new CurrencyConverter();
		jmsSender =  new JMSSender();
		logger = new Logger();
	}

	public Account createAccount(long accountNumber, String customerName) {
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		org.hibernate.Transaction tx=session.beginTransaction();
		Account account = new Account(accountNumber);
		Customer customer = new Customer(customerName);
		account.setCustomer(customer);
		accountDAO.saveAccount(account);
		logger.log("createAccount with parameters accountNumber= "+accountNumber+" , customerName= "+customerName);
		tx.commit();
		return account;
	}

	public void deposit(long accountNumber, double amount) {
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		org.hibernate.Transaction tx=session.beginTransaction();
		Account account = accountDAO.loadAccount(accountNumber);
		account.deposit(amount);
		accountDAO.updateAccount(account);
		logger.log("deposit with parameters accountNumber= "+accountNumber+" , amount= "+amount);
		if (amount > 10000){
			jmsSender.sendJMSMessage("Deposit of $ "+amount+" to account with accountNumber= "+accountNumber);
		}
		tx.commit();
	}

	public Account getAccount(long accountNumber) {
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		org.hibernate.Transaction tx=session.beginTransaction();
		Account account = accountDAO.loadAccount(accountNumber);
		tx.commit();
		return account;
	}

	public Collection<Account> getAllAccounts() {
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		org.hibernate.Transaction tx=session.beginTransaction();
		
		Collection<Account> accounts= accountDAO.getAccounts();
		
		tx.commit();

		return accounts;
	}

	public void withdraw(long accountNumber, double amount) {
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		org.hibernate.Transaction tx=session.beginTransaction();
		Account account = accountDAO.loadAccount(accountNumber);
		account.withdraw(amount);
		accountDAO.updateAccount(account);
		logger.log("withdraw with parameters accountNumber= "+accountNumber+" , amount= "+amount);
		tx.commit();

	}

	public void depositEuros(long accountNumber, double amount) {
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		org.hibernate.Transaction tx=session.beginTransaction();
		Account account = accountDAO.loadAccount(accountNumber);
		double amountDollars = currencyConverter.euroToDollars(amount);
		account.deposit(amountDollars);
		accountDAO.updateAccount(account);
		logger.log("depositEuros with parameters accountNumber= "+accountNumber+" , amount= "+amount);
		if (amountDollars > 10000){
			jmsSender.sendJMSMessage("Deposit of $ "+amount+" to account with accountNumber= "+accountNumber);
		}
		tx.commit();

	}

	public void withdrawEuros(long accountNumber, double amount) {
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		org.hibernate.Transaction tx=session.beginTransaction();
		Account account = accountDAO.loadAccount(accountNumber);
		double amountDollars = currencyConverter.euroToDollars(amount);
		account.withdraw(amountDollars);
		accountDAO.updateAccount(account);
		logger.log("withdrawEuros with parameters accountNumber= "+accountNumber+" , amount= "+amount);
		tx.commit();

	}

	public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		org.hibernate.Transaction tx=session.beginTransaction();
		Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
		Account toAccount = accountDAO.loadAccount(toAccountNumber);
		fromAccount.transferFunds(toAccount, amount, description);
		accountDAO.updateAccount(fromAccount);
		accountDAO.updateAccount(toAccount);
		logger.log("transferFunds with parameters fromAccountNumber= "+fromAccountNumber+" , toAccountNumber= "+toAccountNumber+" , amount= "+amount+" , description= "+description);
		if (amount > 10000){
			jmsSender.sendJMSMessage("TransferFunds of $ "+amount+" from account with accountNumber= "+fromAccount+" to account with accountNumber= "+toAccount);
			
		}
		tx.commit();

	}
}
