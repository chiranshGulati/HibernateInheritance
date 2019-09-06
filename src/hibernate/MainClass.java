package hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainClass {

	public static void main(String[] args) {
		Employee e= new Employee();
		//e.setId(101);
		e.setName("emp-1");
		e.setSalary(2000);
		//database
		
		System.out.println("#1");
		Configuration cfg=new Configuration();
		System.out.println("#2");
		SessionFactory factory= cfg.configure().buildSessionFactory();  //
		System.out.println("#3");
		Session session=factory.openSession(); //connection
		System.out.println("#4");
		Transaction t= session.beginTransaction();
		
		/* data base code*/
		session.save(e);
		System.out.println("#5----Employee save ");
		t.commit();
		System.out.println("Session.get Command");
		Employee e2=(Employee)session.get(Employee.class, new Integer(1));
		System.out.println(e2.getId());
		System.out.println(e2.getName());
		System.out.println(e2.getSalary());
		System.out.println("#6");
		
		
		System.out.println("Session.update command");
		Employee e3= new Employee();
		//e.setId(101);
		e3.setId(2);
		e3.setName("emp-1");
		e3.setSalary(4000);
		session.saveOrUpdate(e3);
		
		
		session.delete(e3);
		session.close();
		// TODO Auto-generated method stub

	}

} 
