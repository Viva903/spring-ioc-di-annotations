package com.viva903.springdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.viva903.springdemo")
@PropertySource("classpath:mylogger.properties")
@PropertySource("classpath:sport.properties")
public class SportConfig {
	@Bean
	public MyLoggerConfig myLoggerConfig(@Value("${root.logger.level}") String rootLoggerLevel,
			@Value("${printed.logger.level}") String printedLoggerLevel) {

		MyLoggerConfig myLoggerConfig = new MyLoggerConfig(rootLoggerLevel, printedLoggerLevel);

		return myLoggerConfig;
	}
	
//	define bean for our sad fortune service
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
//	define bean for our swim coach AND inject dependency 
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
	
	@Bean
	public FortuneService boxingFortuneService() {
		return new BoxingFortuneService();
	}
	
	@Bean
	public Coach boxingCoach() {
		return new BoxingCoach(boxingFortuneService());
	}
	
}
