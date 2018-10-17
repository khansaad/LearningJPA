package com.learning.jpa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.learning.jpa.entity.Person;


@Repository
@Transactional
public class PersonJpaRepository {

	//connect to db
	@PersistenceContext
	EntityManager entityManager;
	
	public List<Person> findAll(){
		
		TypedQuery<Person> namedQuery =  entityManager.createNamedQuery("find_all_persons", Person.class);
		return namedQuery.getResultList();
		//return jdbcTemplate.query("select * from person", new PersonRowMapper());
	}
	public Person findById(int id){
		return entityManager.find(Person.class, id);
	}
	
	public Person update(Person person){
		return entityManager.merge(person);
	}
	
	public Person insert(Person person){
		return entityManager.merge(person);
	}
	
	public void delete(int id){
		
		Person person = findById(id);
		entityManager.remove(person);		
	}
}
