package com.learning.hibernate.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.learning.hibernate.HibernateApplication;
import com.learning.hibernate.entity.Course;
import com.learning.hibernate.entity.Passport;
import com.learning.hibernate.entity.Student;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=HibernateApplication.class)
public class StudentRepoTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentRepo stuentRepo;
	
	@Autowired
	EntityManager em;
	
	@Test
	@Transactional
	public void retrieveStudentAndPassportDetails() {
		
		Student student = em.find(Student.class, 201L);
		logger.info("student -> {}", student);
		logger.info("passport -> {}",student.getPassport());
	}
	
}
