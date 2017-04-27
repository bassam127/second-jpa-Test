package com.bassam.manyToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class App {
	
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("person.jpa");
		EntityManager entitymanager = entityManagerFactory.createEntityManager();
		entitymanager.getTransaction().begin();
		University university=new University("KTH");
		Student student=new Student("Emma anderson");
		student.setUniversity(university);
		Student student1=new Student("klass Ericsson");
		student1.setUniversity(university);
		
		
		entitymanager.persist(university);
		entitymanager.persist(student);
		entitymanager.persist(student1);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		entityManagerFactory.close();

	}

}
