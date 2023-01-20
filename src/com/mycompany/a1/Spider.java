package com.mycompany.a1;

import java.util.Random;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

public class Spider extends Movable{

	// Constructor
	public Spider(){
		super();
	}
		
	// Constructor with given color
	public Spider(int newcolor){
		super(newcolor);
	}
		
	//Constructor with given size, color and location
	public Spider(int newsize, Point newlocation, int newcolor) {
		super();
	}
	
	public void changeHeading()
	{
		setHeading(randomInt(0,5));
	}
	
	public boolean checkOutOfBound()
	{
		if(getLocation().getX() > 1000 || getLocation().getY() > 1000) 
		{
			return true;
		}
		return false;
	}
	
	public String toString()
	{
		String spiderstring = "Spider: ";
		String parentDesc = super.toString();
		String myDesc = " heading=" + this.getHeading() + " speed=" + this.getSpeed();
		
		return spiderstring + parentDesc + myDesc;
	}
}
