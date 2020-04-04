package com.udacity.jwdnd.course1.cloudstorage;

import com.baeldung.mybatis.spring.Notes;
import com.baeldung.mybatis.spring.NotesMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class CloudStorageApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudStorageApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx){
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}

			System.out.println("NEW DATA");

			Notes n = new Notes();
			n.setNotedescription("Mi descripcion1");
			n.setNoteid(1);
			n.setNotetitle("titulo1");

		};
	}




}
