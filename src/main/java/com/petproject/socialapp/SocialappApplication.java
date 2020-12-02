package com.petproject.socialapp;

import com.petproject.socialapp.security.SprinngSecurityAuditorAware;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class SocialappApplication {

	@Bean
	public AuditorAware<String> auditorAware(){
		return new SprinngSecurityAuditorAware();
	}

	public static void main(String[] args) {
		SpringApplication.run(SocialappApplication.class, args);
	}

}
