package com.axelor.store;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.axelor.pojo.Cname;
import com.axelor.pojo.Mobile;
import com.axelor.pojo.User;

public class StoreData {
	
		

		public static void main(String args[]) {
			
			StoreData data = new StoreData();
			
			
			
			Configuration cfg = new Configuration();
			cfg.addAnnotatedClass(User.class);
			cfg.addAnnotatedClass(Cname.class);
			cfg.addAnnotatedClass(Mobile.class);
			cfg.configure("hibernate.cfg.xml");

			cfg.configure();
			
			StandardServiceRegistryBuilder ssr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
    		SessionFactory sessionFactory = cfg.buildSessionFactory(ssr.build());
    		
    		Session session = sessionFactory.openSession();
    	//	Transaction transaction = session.beginTransaction();
			
    		data.addObject(session);
//    		transaction.commit();
    		System.out.println("Saved Successfully");
    		
    		data.readObject(session);
    		
    		
    		  sessionFactory.close();  
   		   		session.close();    
   		   
    		
    		
		}

		private void readObject(Session session) {
			// TODO Auto-generated method stub
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the name of the contact you want to see");
			String name = sc.nextLine();
			
			System.out.println("Reading Records");
			
			
			
			
		}

		private void addObject(Session session) {
			// TODO Auto-generated method stub
			Transaction transaction = session.beginTransaction();
			
			User user = new User();
			Cname cN = new Cname();
			Mobile mobile = new Mobile();
			
			String uName;
			int password;
			String cName;
			int mNumber;
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter your name ");
			uName = sc.nextLine();
			
			System.out.println("Enter the contact name");

			cName = sc.nextLine();
			
			System.out.println("Enter your password");
			password = sc.nextInt();
			

			
			
			
			
			System.out.println("Enter the phone nuber of your contact");
			
			mNumber = sc.nextInt();
			
			mobile.setmNumber(mNumber);
			mobile.setCname(cN);
			
			cN.setCname(cName);
			cN.getMobile().add(mobile);
			
			user.setName(uName);
			user.setPassword(password);
			user.getCname().add(cN);
			
			
			//session.save(mobile);
			//session.save(cN);
			session.save(user);
			transaction.commit();
			
			
			
			
			
		}
	
	
	
}
