package com.projet.ecommerce;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.projet.model.Role;
import com.projet.service.AccountService;




@SpringBootApplication
@EnableJpaRepositories("com.projet.repository")
@ComponentScan(basePackages = { "com.projet.*" })
@EntityScan("com.projet.model")
public class EcommerceStarterApplication{

	public static void main(String[] args) {
		SpringApplication.run(EcommerceStarterApplication.class, args);
	}
	@Bean
	CommandLineRunner start(AccountService accountService){
		return args ->{
			accountService.save(new Role(null,"USER"));
			accountService.save(new Role(null,"ADMIN"));
			Stream.of("user1","user2","user3","admin").forEach(un->{
				accountService.saveUser(un, "1234", "1234");
			});
};
		
	
		}
	@Bean
	BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder() ;
	}
}