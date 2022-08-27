package com.viva903.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component("thatSillyCoach")
@Component
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("fileFortuneService")
	private FortuneService fortuneService;
	
	@Value("${foo.email}")
	private String emailAddress;
	
	@Value("${foo.team}")
	private String team;

	/*
	 * @Autowired public TennisCoach(@Qualifier("randomFortuneService")
	 * FortuneService fortuneService) { this.fortuneService = fortuneService; }
	 */

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public TennisCoach() {
		System.out.println("Inside Tennis Coach Construtor");
	}

	@Override
	public String getDailyWorkout() {
		return "Practise your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	/*
	 * @Autowired public void setFortuneService(@Qualifier("randomFortuneService")
	 * FortuneService fortuneService) { this.fortuneService = fortuneService;
	 * System.out.println("Inside Tennis Coach Setter for Fortune Service"); }
	 * 
	 * @Autowired
	 * 
	 * @Qualifier("randomFortuneService") public void
	 * doSomeCrazyStuff(FortuneService fortuneService) { this.fortuneService =
	 * fortuneService;
	 * System.out.println("Inside Tennis Coach method => doSomeCrazyStuff "); }
	 */

}
