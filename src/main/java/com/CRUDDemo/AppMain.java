package com.CRUDDemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class AppMain 
{
    public static void main( String[] args )
    {
        SpringApplication.run(AppMain.class, args);
        System.out.println( "Spring is running" );
        
    }
    
    @Bean
    CommandLineRunner runner(UserRepository repository) {
    	return args ->{
    		repository.save(new User("Jamal","Bourne","JamalBourne@aol.com", "3015555555"));
    		repository.save(new User("Justin","Bourne","JustinDaKid@yahoo.com","4102330316"));
    	};
    }
}
