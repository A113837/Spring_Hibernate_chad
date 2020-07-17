package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class PingPongCoach implements Coach {
	
	public PingPongCoach() {
		System.out.println(">>PingpongCoadh: Inside Pingpong Constructor ");
	}

	@Override
	public String getDailyWorkout() {
		
		return "Practice your pingpong smash today yo!";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}

}
