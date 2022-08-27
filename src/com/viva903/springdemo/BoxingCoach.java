package com.viva903.springdemo;

public class BoxingCoach implements Coach {

	FortuneService fortuneService;
	
	public BoxingCoach(FortuneService theFortuneService) {
		this.fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {

		return "Hit the sandBag for 500 times";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
