package com.viva903.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		
//		read spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
//		get the bean from spring container
//		Coach theCoach = context.getBean("thatSillyCoach", Coach.class);
		TennisCoach theTennisCoach = context.getBean("tennisCoach", TennisCoach.class);
//		Coach theBadmintonCoach = context.getBean("badmintonCoach", Coach.class);
		
//		call a method on the bean
//		System.out.println(theTennisCoach.getDailyWorkout());
		System.out.println(theTennisCoach.getDailyFortune());
//		System.out.println(theTennisCoach.getEmailAddress());
//		System.out.println(theTennisCoach.getTeam());
		
		
//		System.out.println(theBadmintonCoach.getDailyWorkout());
		
//		close the context
		context.close();
		
	}

}
