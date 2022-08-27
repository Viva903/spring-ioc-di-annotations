package com.viva903.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationScopeDemoApp {

	public static void main(String[] args) {
//		load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

//		retrieve bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		
//		check if they are the same bean -> coming from singleton
		boolean result = (theCoach == alphaCoach);
		System.out.println("\nPointing to the same object : " + result);
		System.out.println("\nMemory Location for theCoach : " + theCoach);
		System.out.println("\nMemory Location for theCoach : " + alphaCoach + "\n");
		
		System.out.println(theCoach.getDailyFortune());
//		close the context 
		context.close();

	}

}


