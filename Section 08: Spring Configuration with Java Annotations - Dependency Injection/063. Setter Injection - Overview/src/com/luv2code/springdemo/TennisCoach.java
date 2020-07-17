package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	
	private FortuneService fortuneService;
	
	/*
	@Autowired
	public TennisCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	*/
	
	//define default constructor
	public TennisCoach() {
		System.out.println(">>TennisCoach: inside default constructor");
	}
	
	//define a setter method
	@Autowired
	public void setFortuneService(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
		System.out.println(">> TennisCoach: inside setFortuneService() method");
		
	}
	
	@Override
	public String getDailyWorkout() {
		
		return "Practice your backhand volley annotation2";
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
