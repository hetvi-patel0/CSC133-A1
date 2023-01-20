package com.mycompany.a1;

import com.codename1.charts.models.Point;

public abstract class Fixed extends GameObject{
	
	public Fixed(){
		super();
	}
	
	// Constructor with given color
	public Fixed(int newcolor){
		super(newcolor);
	}
	
	// Constructor with given size and color
	public Fixed(int newsize, int newcolor){
		super(newsize, newcolor);
	}
	
	//Constructor with given size , color and location
	public Fixed(int newsize, Point newlocation, int newcolor) {
		super(newsize, newlocation, newcolor);
	}
	
	public void setLocation()
	{
		//fixed objects cannot move
	}
	
	public void move(){
		//fixed objects cannot move
	}
}
