package cs544.assignment2;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import cs544.assignment2.Book;

public class AppBook {
	private static final SessionFactory sessionFactory;
	private static final ServiceRegistry serviceRegistry;
	static{
		Configuration configuration=new Configuration();
		configuration.configure();
		serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory=configuration.buildSessionFactory(serviceRegistry);
	}

	public static void main(String [] args){
		Session session=null;
		Transaction tx=null;
		int aId=0,bId=0,cId;
		try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
          //  List<Book> books=new ArrayList();
        //   Date d=new Date();
        //   d.setYear(1998);
         Calendar n=Calendar.getInstance();
         n.set(1998, 12, 31);
         
            Book a=new Book("Tell me your Dreams","9789792247251","Sidney Sheldon",1000,n.getTime());
            n.set(1978, 12, 31);
            Book b=new Book("48 Laws of Power","75676764765785","Robert Greene",1500,n.getTime());
            n.set(2089, 12, 56);
            Book c=new Book("Why Men dont Listen and Women cant read Maps","3624732646","Allan and Barbarra Pease",2000,n.getTime());
        session.persist(a);

		session.persist(b);
		session.persist(c);
		 aId=a.getId();
		 bId=b.getId();
		 cId=c.getId();
		System.out.println("************************************Stage 1 Complete*******************************************");
		tx.commit();
		
		}
		catch (HibernateException e) {
            if (tx != null) {
                System.err.println("Rolling back: " + e.getMessage());
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
		//session.close();
		try {
            session = sessionFactory.openSession();
          //  tx = session.beginTransaction();
            @SuppressWarnings("unused")
			List<Book> booklist=session.createQuery("from Book").list();
            for(Book b:booklist){
            	System.out.println(b.toString());
            }
          //  tx.
    		System.out.println("************************************Stage 2 Complete*******************************************");

                        
		}
		catch (HibernateException e) {
            if (tx != null) {
                System.err.println("Rolling back: " + e.getMessage());
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
		try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
          //  Book b=(Book)session.createQuery("from Book where id=1");
          //  Class<Book> b=new Class(null);
            Book b=new Book();
            session.load(b, aId);
            b.setPrice(2400);
            b.setTitle("Hello World");
            session.saveOrUpdate(b);
            b=new Book();
            session.load(b, bId);
            session.delete(b);
        //    session.get(Book, 1);
            tx.commit();
    		System.out.println("************************************Stage 3 Complete*******************************************");

		}
		catch (HibernateException e) {
            if (tx != null) {
                System.err.println("Rolling back: " + e.getMessage());
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
		try {
            session = sessionFactory.openSession();
          //  tx = session.beginTransaction();
            @SuppressWarnings("unused")
			List<Book> booklist=session.createQuery("from Book").list();
            
            for(Book b:booklist){
            	System.out.println(b.toString());
            }
          //  tx.
    		System.out.println("************************************Stage 4 Complete*******************************************");
    		//Book m=session.createQuery("from Book where id=2").get

                        
		}
		catch (HibernateException e) {
            if (tx != null) {
                System.err.println("Rolling back: " + e.getMessage());
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
		
}

}
