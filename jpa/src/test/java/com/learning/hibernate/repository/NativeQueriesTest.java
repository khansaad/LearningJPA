package com.learning.hibernate.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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

@RunWith(SpringRunner.class)
@SpringBootTest(classes=HibernateApplication.class)
public class NativeQueriesTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;
	
	@Test
	public void native_queries_basic() {		
		
		Query query = em.createNativeQuery("Select * from course",Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("Select * from Course  -> {}",resultList);
	}
	@Test
	public void native_queries_with_params() {		
		
		Query query = em.createNativeQuery("Select * from course where id = ?",Course.class);
		query.setParameter(1, 100L);
		List<Course> resultList = query.getResultList();
		logger.info("Select * from Course where id = ? -> {}",resultList);
	}
	
	@Test
	public void native_queries_with_named_params() {		
		
		Query query = em.createNativeQuery("Select * from course where id = :id",Course.class);
		query.setParameter("id", 100L);
		List<Course> resultList = query.getResultList();
		logger.info("Select * from Course where id = :id -> {}",resultList);
	}
	
	@Test
	@Transactional
	public void native_queries_to_update() {		
		
		Query query = em.createNativeQuery("Update Course set last_updated_date=sysdate() ",Course.class);
		int noOfRowsUpdated = query.executeUpdate();
		
		logger.info("noOfRowsUpdated -> {}",noOfRowsUpdated);
	}
//	@Test
//	public void jpql_typed() {
//		
//		TypedQuery<Course> query = em.createQuery("Select c from Course c",Course.class);
//		List<Course> resultList = query.getResultList();
//		logger.info("Select c from Course c -> {}",resultList);
//	}
//	
//	@Test
//	public void jpql_where() {
//		
//		//TypedQuery<Course> query = em.createQuery("Select c from Course c where name like 'first%'",Course.class);
//		TypedQuery<Course> query = em.createNamedQuery("query_get_specific_course",Course.class);
//		List<Course> resultList = query.getResultList();
//		logger.info("Select c from Course c where name like 'first%' -> {}",resultList);
//	}
}
