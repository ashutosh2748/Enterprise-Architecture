package cs544.exercise16_1.bank.dao;

import java.util.*;

import javax.persistence.ElementCollection;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import cs544.exercise16_1.bank.domain.Account;

public class HibernateDAO implements IAccountDAO {

	Collection<Account> accountlist ;
	SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
	
public HibernateDAO(){
	
}
	public void saveAccount(Account account) {
		
		
		sessionFactory.getCurrentSession().save(account);
	}

	public void updateAccount(Account account) {
		
		
		
		sessionFactory.getCurrentSession().update(account);

	}

	public Account loadAccount(long accountnumber) {
		
		Transaction tx=sessionFactory.getCurrentSession().getTransaction();
		accountlist=sessionFactory.getCurrentSession().createQuery("from Account").list();
		
		for (Account account : accountlist) {
			if (account.getAccountnumber() == accountnumber) {
				return account;
			}
		}
		return null;

	}

	public Collection<Account> getAccounts() {
		
		
		Transaction tx=sessionFactory.getCurrentSession().getTransaction();

		accountlist=sessionFactory.getCurrentSession().createQuery("from Account").list();
		Hibernate.initialize(accountlist);
		for(Account ac:accountlist){
			Hibernate.initialize(ac.getCustomer());
			Hibernate.initialize(ac.getEntryList());
		}
		
		return accountlist;
		
	}

}
