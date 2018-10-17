package com.learning.hibernate.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.learning.hibernate.HibernateApplication;
import com.learning.hibernate.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=HibernateApplication.class)
public class JPQLTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;
	
	@Test
	public void jpql_basic() {		
		//Query query = em.createQuery("Select c from Course c");
		Query query = em.createNamedQuery("query_get_all_courses");
		List<Course> resultList = query.getResultList();
		logger.info("Select c from Course c -> {}",resultList);
	}
	
	@Test
	public void jpql_typed() {
		
		TypedQuery<Course> query = em.createQuery("Select c from Course c",Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("Select c from Course c -> {}",resultList);
	}
	
	@Test
	public void jpql_where() {
		
		//TypedQuery<Course> query = em.createQuery("Select c from Course c where name like 'first%'",Course.class);
		TypedQuery<Course> query = em.createNamedQuery("query_get_specific_course",Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("Select c from Course c where name like 'first%' -> {}",resultList);
	}
}
