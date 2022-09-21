package com.pro.wings;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.google.protobuf.Internal.ListAdapter;


public class TestHibernate {
	public static void main(String[] args) {
		
		Student std1 = new Student();
		std1.setId(2);
		std1.setFirstName("Raj");
		std1.setLastName("Patil");
		std1.setMarks(95);
		
		Configuration configuration = new Configuration();
		SessionFactory factory = configuration.configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(std1);
		
		Query<Student> query = session.createQuery("From Student", Student.class);
		List<Student> resultList = query.list();
		
		for(Student s : resultList)
			System.out.println(s);
		
		session.close();
		factory.close();
		
		
	}

}
