package com.viva903.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		
//		read spring configuration java file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
//		get the bean from spring container
//		Coach theCoach = context.getBean("thatSillyCoach", Coach.class);
//		TennisCoach theTennisCoach = context.getBean("tennisCoach", TennisCoach.class);
		SwimCoach theSwimCoach = context.getBean("swimCoach", SwimCoach.class);
//		Coach theBadmintonCoach = context.getBean("badmintonCoach", Coach.class);
		
//		call a method on the bean
//		System.out.println(theTennisCoach.getDailyWorkout());
//		System.out.println(theTennisCoach.getDailyFortune());
//		System.out.println(theTennisCoach.getEmailAddress());
//		System.out.println(theTennisCoach.getTeam());
		
		System.out.println(theSwimCoach.getDailyWorkout());
		System.out.println(theSwimCoach.getDailyFortune());
		System.out.println("email : " + theSwimCoach.getEmail());
		System.out.println("team : " + theSwimCoach.getTeam());//		System.out.println(theBadmintonCoach.getDailyWorkout());
		
//		close the context
		context.close();
		
	}

}
