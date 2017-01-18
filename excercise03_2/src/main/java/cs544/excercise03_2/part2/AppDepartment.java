package cs544.excercise03_2.part2;

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

public class AppDepartment {
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
        Book b=new Book();
       // b.setAuthor("")
        b.setAuthor("Ashutosh Ghimire");
        session.persist(b);
        Publisher p=new Publisher();
        p.setName("Oxford");
        //.name="Faculty";
        p.getBooks().add(b);
        p.getBooks().add(b);
       
        session.persist(p);

        //session.persist(a);

		//session.persist(b);
		//session.persist(c);
		// aId=a.getId();
		// bId=b.getId();
		// cId=c.getId();
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
			List<Publisher> publisher=session.createQuery("from publisher").list();
            for(Publisher b:publisher){
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
	System.exit(0);
		
}

}
