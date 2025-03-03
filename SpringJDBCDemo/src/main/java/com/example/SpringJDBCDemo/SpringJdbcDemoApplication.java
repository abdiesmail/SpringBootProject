package com.example.SpringJDBCDemo;

import com.example.SpringJDBCDemo.Dao.AlienDao;
import com.example.SpringJDBCDemo.model.Alien;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJdbcDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcDemoApplication.class, args);

		Alien alien = context.getBean(Alien.class);

		alien.setId(103);
		alien.setName("Abdi");
		alien.setTech("Java");

		AlienDao alienDao = context.getBean(AlienDao.class);

		alienDao.save(alien);

		System.out.println(alienDao.read());
	}

}
