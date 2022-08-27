package com.viva903.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("thatSillyCoach")
@Component
@Scope("prototype")
public class TennisCoach implements Coach
, DisposableBean 
{

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

	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("TennisCoach : inside method doMyStartupStuff");
	}

	@PreDestroy
	public void doMyCleanUpStuff() {
		System.out.println("TennisCoach : inside method doMyCleanUpStuff");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("This is DisposableBeans for prototype beans : Destroy Method");
	}

}
