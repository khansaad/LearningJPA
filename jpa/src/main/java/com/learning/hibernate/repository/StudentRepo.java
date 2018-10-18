package com.learning.hibernate.repository;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.learning.hibernate.entity.Passport;
import com.learning.hibernate.entity.Student;

@Repository
@Transactional
public class StudentRepo {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	EntityManager em;
	
	public Student findById(Long id) {
		
		return em.find(Student.class, id);		
	} 
	
	public void deleteById(Long id) {
		
		Student student = findById(id);
		em.remove(student);		
	}
	
	public Student save(Student student) {
		
		if(student.getId()==null)
			em.persist(student);
		else
			em.merge(student);
		
		return em.merge(student);		
	}
	
	public void saveStudentWithPassport() {
		
		Passport passport = new Passport("Z1234");
		em.persist(passport);
		
		Student student = new Student("sada");
		student.setPassport(passport);
		em.persist(student);
	}
	
}
