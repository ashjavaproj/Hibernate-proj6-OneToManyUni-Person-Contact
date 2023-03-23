package com.dtd.test;

import java.util.Scanner;

import org.hibernate.Session;
import com.dtd.model.ContactDetails;
import com.dtd.model.Person;
import com.dtd.utility.HibernateUtil;

public class Main {
	
	static Scanner sc=new Scanner(System.in);
	
	public static void InsertPerson_ContactInfo()
	{
		Session session=HibernateUtil.getSessionFactory().openSession();
		ContactDetails sim1=new ContactDetails();
		System.out.println("Enter Sim 1 Details");
		System.out.print(" Mobile no = ");
		sim1.setMobileno(sc.nextLong());
		System.out.println("Operater Name = ");
		sim1.setOperatorName(sc.next());
		
		ContactDetails sim2=new ContactDetails();
		System.out.println("Enter Sim 2 Details");
		System.out.print(" Mobile no = ");
		sim2.setMobileno(sc.nextLong());
		System.out.println("Operater Name = ");
		sim2.setOperatorName(sc.next());
		
		Person person=new Person();
		System.out.print("Enter Person Name = ");
		person.setPersonName(sc.next());
		System.out.print("Enter Person Address = ");
		person.setPersonAddress(sc.next());
		person.getContactDetails().add(sim1);
		person.getContactDetails().add(sim2);
		
		session.save(person);
		session.beginTransaction().commit();
		
	}
	
	public static void displayPerson_ContactInfo()
   {
	  // SessionFactory sessionFactoey=HibernateUtil.getSessionFactory();
	 //  Session session=sessionFactoey.openSession();
	   
	   			//OR
	   
	   Session session=HibernateUtil.getSessionFactory().openSession();
	   System.out.println("Enter Person Id U want to display Records");
	      Person person=session.get(Person.class, sc.nextInt());
	      System.out.println("ID            :- "+person.getPersonId());
	      System.out.println("Name          :- "+person.getPersonName());
	      System.out.println("Address       :- "+person.getPersonAddress());
	      
	      person.getContactDetails().forEach(c->{
	      System.out.println("Contact Id    :- "+c.getContactId());
	      System.out.println("Mobile No     :- "+c.getMobileno());
	      System.out.println("Operator Name :- "+c.getOperatorName());
	    	    System.out.println();
	    	  
	      });      
	      
   }
   public static void updatePerson()
   {
	   Session session=HibernateUtil.getSessionFactory().openSession();
	   System.out.println("Enter Person Id U want to Update Records");
	      Person person=session.get(Person.class, sc.nextInt());
	      	 System.out.println(" 1=Person Name");
	    	 System.out.println(" 2=Person Addresss");
	    	 System.out.println(" 3=Contact no");
	    	 System.out.println(" 4=Operater Name");
	    	 System.out.print("Enter choice for Update Records = ");
	    	 
	    	 switch(sc.nextInt())
	    	 {
	    	 case 1:
	    		 System.out.print("Enter New Person Name = ");
	    		 person.setPersonName(sc.next());
	    		 break;
	    	 
	    	 case 2:
	    		 System.out.print("Enter New Person Address = ");
	    		 person.setPersonAddress(sc.next());
	    		 break;
	    	
	    	/* case 3: 
	    		 System.out.print("Enter for which sim ?");
	    		 person.getContactDetails().remove(sc.nextInt());
	    		 System.out.println("Enter new Sim ");
	    		 person.getContactDetails().add(sc.nextLong());
	    		 break;
	    	
	    	 case 4:
	    		 System.out.print("Enter New Operator Name = ");
	    		 person.getContactDetails().add(sc.next());
	    		 break;*/
	    	 }
	    	 session.update(person);
	    	 session.beginTransaction().commit();
	    	 System.out.println("**** SuccessFully Udated ****");
	    	 System.out.println("------------------------------------------");

   }
   public static void deletePerson()
   {
	   Session session=HibernateUtil.getSessionFactory().openSession();
	   System.out.println("Enter Person Id u want To update Record ");
	   Person person=session.get(Person.class,sc.nextInt());
	  // person.setContactDetails(null);
	   session.delete(person);
	   session.beginTransaction().commit();
	   System.out.println("**** Record Successfully Deleted ****");
   	
   }
   		public static void main(String[] args) {
	
   			Scanner sc=new Scanner(System.in);
   			while(true)
   			{
			System.out.println();
			System.out.println("*********EMPLOYEE DETAILS *******");
				System.out.println("1=Insert Records ");
				System.out.println("2=Display Records ");
				System.out.println("3=Update  Records");
				System.out.println("4=Delete  Records ");
				System.out.println("5=Exit ");
				System.out.print("Enter Choice : ");
				
				switch(sc.nextInt())
				{
				case 1:	Main.InsertPerson_ContactInfo();
				break;
				
				case 2: Main.displayPerson_ContactInfo();
				break;
				
				case 3: Main.updatePerson();
		
				break;
				
				case 4: Main.deletePerson();
			
				break;
				
				case 5: System.exit(0);
				break;
				
				}
			}
			}
			}



