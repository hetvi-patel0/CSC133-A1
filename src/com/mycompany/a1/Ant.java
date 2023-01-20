package com.mycompany.a1;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

public class Ant extends Movable implements ISteerable{

	private int maximumSpeed;
	private int foodLevel;
	private int foodConsumptionRate;
	private int healthLevel;
	private int lastFlagReached;
	private boolean die;
	
	//Constructor
	public Ant()
	{
		super();
		setHeading(0);
		maximumSpeed = 50;
		foodLevel = 30;
		foodConsumptionRate = 2;
		healthLevel = 10;
		lastFlagReached = 1;
		die = false;
	}
	
	//Constructor with given color
	public Ant(int newcolor)
	{
		super(newcolor);
		maximumSpeed = 50;
		foodLevel = 30;
		foodConsumptionRate = 2;
		healthLevel = 10;
		lastFlagReached = 1;
		die = false;
	}
	
	//Constructor with given size, color and location
	public Ant(int newsize, Point newlocation, int newcolor) {
		super(newsize, newlocation, newcolor,0,10);
		maximumSpeed = 50;
		foodLevel = 30;
		foodConsumptionRate = 2;
		healthLevel = 10;
		lastFlagReached = 1;
		die = false;
	}

	public int getMaximumSpeed() {
		return maximumSpeed;
	}
	
	public int getFoodLevel() {
		return foodLevel;
	}
	
	public int getFoodConsumptionRate() {
		return foodConsumptionRate;
	}
	
	public int getHealthLevel() {
		return healthLevel;
	}
	
	public int getLastFlagReached() {
		return lastFlagReached;
	}
	
	public void addFoodLevel(int addfood)
	{
		foodLevel += addfood;
	}
	
	public void dropFoodLevel()
	{
		foodLevel -= foodConsumptionRate;
	}
	
	public void lostHealth()
	{
		healthLevel --;
		while(getSpeed()>(getMaximumSpeed()*getHealthLevel()/10)) {
			antbrake();
		}
	}
	
	public void newFlagReached()
	{
		lastFlagReached++;
	}
	
	public void checkFoodLevel()
	{
		if(getFoodLevel()<=0)
		{
			setSpeed(0);
			die = true;
		}
	}
	
	public void checkHealthLevel()
	{
		if(getHealthLevel()<=0)
		{
			setSpeed(0);
			die = true;
		}
	}
	
	public void antaccelerate()
	{
		if(!die)
		{
			if(getSpeed()<(getMaximumSpeed()*getHealthLevel()/10))
			{
				setSpeed(getSpeed()+1);
			}
		}
		else
		{
			System.out.println("Acceleration not possible at this point!");
		}
	}
	
	public void antbrake()
	{
		if(!die)
		{
			if(getSpeed()>0)
			{
				setSpeed(getSpeed()-1);
			}
		}
	}
	
	public boolean checkDie()
	{
		return die;
	}
	
	public String toString() {
		String antstring = "Ant: ";
		String parentDesc = super.toString();
		String myDesc = " heading=" + this.getHeading() + " speed=" + this.getSpeed()
		 + " maxSpeed=" + this.getMaximumSpeed() + 
				" foodConsumptionRate=" + this.getFoodConsumptionRate();
		
		return antstring + parentDesc + myDesc;
	}

	public void steerright() {
		setHeading(getHeading()-5);
	}

	public void steerleft() {
		setHeading(getHeading()+5);
	}
}
