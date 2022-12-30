package edu.educem.encuestabackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import edu.educem.encuestabackend.security.ApplicationProperties;

@SpringBootApplication
@EnableJpaAuditing
public class EncuestabackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EncuestabackendApplication.class, args);
		System.out.println("8''''8 #8'''88 #8'''8  #8'''8  #8  #8'''' #8'''8 #8''''8 #8'''88");
		System.out.println("8    ' #8    8 #8   8  #8   8  #8  #8     #8   8 #8    8 #8    8");
		System.out.println("8e     #8    8 #8eee8e #8eee8e #8e #8eeee #8e  8 #8e   8 #8    8");
		System.out.println("88     #8    8 #88   8 #88   8 #88 #88    #88  8 #88   8 #8    8");
		System.out.println("88   e #8    8 #88   8 #88   8 #88 #88    #88  8 #88   8 #8    8");
		System.out.println("88eee8 #8eeee8 #88   8 #88   8 #88 #88eee #88  8 #88eee8 #8eeee8");
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SpringApplicationContext springApplicationContext() {
		return new SpringApplicationContext();
	}

	@Bean(name = "AppProperties")
	public ApplicationProperties getApplicationProperties() {
		return new ApplicationProperties();
	}

}
