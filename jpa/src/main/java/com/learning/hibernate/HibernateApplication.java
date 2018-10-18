package com.learning.hibernate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learning.hibernate.entity.Course;
import com.learning.hibernate.repository.CourseRepo;
import com.learning.hibernate.repository.StudentRepo;


@SpringBootApplication
public class HibernateApplication implements CommandLineRunner{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private StudentRepo studentRepo;
	
	
	public static void main(String[] args) {
		SpringApplication.run(HibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		studentRepo.saveStudentWithPassport();
		
//		courseRepo.playwithEM();
		
//		Course course = courseRepo.findById(100L);
//		
//		logger.info("Course 100 -> {}",course);
//		
//		courseRepo.save(new Course("Fourth course"));
		//logger.info("Updated Course 100 -> {}",course);
		//courseRepo.deleteById(100L);
	}
}
