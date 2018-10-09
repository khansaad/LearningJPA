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

@SpringBootApplication
public class JpaApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	PersonJdbcDao dao;
	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//
		logger.info("All users -> {}",dao.findAll());
//		logger.info("User id 100 -> {}",dao.findById(100));
//		logger.info("User name DAAS -> {}",dao.findByName("DAAS"));
//		logger.info("User location NowLuck -> {}",dao.findByLocation("NOWfgLUCK"));
//		logger.info("deleting User id 100 -> No. of rows Deleted - {}",dao.deleteById((100)));
		logger.info("inserting User id 103 -> No. of rows inserted - {}",
				dao.insert(new Person(103,"SADA","NUCKLOW",new Date())));
		logger.info("updating User id 101 -> No. of rows updated - {}",
				dao.update(new Person(101,"SADA","NUCKLOW",new Date())));
	}
}
