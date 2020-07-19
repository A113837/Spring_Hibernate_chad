package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("randomFortuneService")
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
	
	//define my init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println(">> TennisCoach: inside of doMyStartupStuff");
	}
	
	//define my destroy method
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println(">> TennisCoach: inside of doMyCleanupStuff");
	}

	
	  //define a setter method
	/*
	 * @Autowired public void doSomeCrazyStuff(FortuneService theFortuneService) {
	 * fortuneService = theFortuneService;
	 * System.out.println(">> TennisCoach: inside doSomeCrazyStuff() method");
	 * 
	 * }
	 */
	 
	
	@Override
	public String getDailyWorkout() {
		
		return "Practice your backhand volley annotation2";
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
