package com.learning.hibernate.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.learning.hibernate.HibernateApplication;
import com.learning.hibernate.entity.Course;
import com.learning.hibernate.entity.Review;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=HibernateApplication.class)
public class CourseRepoTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseRepo courseRepo;
	
	@Autowired
	EntityManager em;
	/*@Test
	public void findById_basic() {
		Course course = courseRepo.findById(101L);
		assertEquals("second course", course.getName());
	}
	@Test
	@DirtiesContext //Spring automatically resets the state back to original after this test
	public void deleteById_basic() {
		courseRepo.deleteById(100L);
		assertNull(courseRepo.findById(100L));
	}
	@Test
	@DirtiesContext
	public void save_basic() {
		
		//get a course
		Course course = courseRepo.findById(100L);
		assertEquals("first course", course.getName());

		//update details
		course.setName("first course - updated");
		courseRepo.save(course);
		
		// check the value
		Course course1 = courseRepo.findById(100L);
		assertEquals("first course - updated",course1.getName());	
		
	}
	
	@Test
	@DirtiesContext
	public void playwithEM_basic() {
		courseRepo.playwithEM();		
	}*/
	
	@Test
	@Transactional
	public void retrieveReviewsForCourse() {
		Course course = courseRepo.findById(100L);
		logger.info("{}",course.getReviews());		
	}
	@Test
	@Transactional
	public void retrieveCourseForReview() { 
		Review review = em.find(Review.class, 501L);
		logger.info("{}",review.getCourse());		
	}
}
