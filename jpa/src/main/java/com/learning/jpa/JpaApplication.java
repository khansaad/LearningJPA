package com.learning.jpa;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learning.jpa.entity.Person;
import com.learning.jpa.jdbc.PersonJdbcDao;
import com.learning.jpa.repository.PersonJpaRepository;

//@SpringBootApplication
public class JpaApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	PersonJpaRepository personJpaRepository;
	 
	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//using hibernate
		
		logger.info("All users -> {}",personJpaRepository.findAll());
//		logger.info("updating User id 101 -> No. of rows updated - {}",personJpaRepository.update(new Person("SADA","NUCKLOW",new Date())));
		//logger.info("inserting User id 103 -> No. of rows inserted - {}",	personJpaRepository.insert(new Person("SADAA","LNUCKLOW",new Date())));		
		//personJpaRepository.delete((100));
		
		
		//using JDBC
		
		/*logger.info("All users -> {}",dao.findAll());
		logger.info("User id 100 -> {}",dao.findById(100));
		logger.info("User name DAAS -> {}",dao.findByName("DAAS"));
		logger.info("User location NowLuck -> {}",dao.findByLocation("NOWfgLUCK"));
		logger.info("deleting User id 100 -> No. of rows Deleted - {}",dao.deleteById((100)));
		logger.info("inserting User id 103 -> No. of rows inserted - {}",
				dao.insert(new Person(103,"SADA","NUCKLOW",new Date())));
		logger.info("updating User id 101 -> No. of rows updated - {}",
				dao.update(new Person(101,"SADA","NUCKLOW",new Date())));*/
	}
}
