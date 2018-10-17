package com.learning.hibernate.repository;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.learning.hibernate.entity.Course;

@Repository
@Transactional
public class CourseRepo {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	EntityManager em;
	
	public Course findById(Long id) {
		
		return em.find(Course.class, id);		
	} 
	
	public void deleteById(Long id) {
		
		Course course = findById(id);
		em.remove(course);		
	}
	
	public Course save(Course course) {
		
		if(course.getId()==null)
			em.persist(course);
		else
			em.merge(course);
		
		return em.merge(course);		
	}
	/**
	 * EM keeps track of the whole method and even if we miss the persist call,
	 * it will save all the modifications done before or after it.
	 * flush() -> updates the changes upto the preceding line to DB 
	 * detach(entity) -> changes in the entity passed into this won't be tracked by EM so it won't reflect in DB
	 * clear()->it will clear all the changes tracked by EM
	 * refresh(entity) -> gives the data from DB and all changes made after that will be lost.
	 */
	public void playwithEM() {
		
		Course course1 = new Course("New Test course");
		em.persist(course1);
		
		Course course2 = findById(100L);
		course2.setName("New Test course - updated");
		
		
		/*Course course2 = new Course("2nd New Test course");
		em.persist(course2);
		
		em.flush();
		
		//em.clear();
		//em.detach(course2);
		
		course1.setName("New Test course - updated");//this will also get executed and reflected even though persist is written before this.			
		course2.setName("2nd New Test course - updated");
		
		em.refresh(course1);
		em.flush();		*/
	}
}
