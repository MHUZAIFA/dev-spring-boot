package com.practice.springcorepractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
@SpringBootApplication
enables
1. Autoconfiguration
2. Component Scanning
3. Additional Configuration

is Composed of following annotations
1. @EnableAutoConfiguration
2. @ComponentScan - scans components and recursively scans sub packages
3. @Configuration - register extra beans with @Bean or import other configuration classes

SpringApplication > SpringcorepracticeApplication:
Behind the scenes
1. Creates application context
2. Registers all beans
3. Starts embedded tomcat server
and more...
*/

@SpringBootApplication(
		scanBasePackages = {
				"com.practice.springcorepractice",
				"com.practice.util"
		}
)
public class SpringcorepracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcorepracticeApplication.class, args);
	}

}
