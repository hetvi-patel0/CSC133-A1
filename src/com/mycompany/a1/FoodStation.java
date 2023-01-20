package com.mycompany.a1;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

public class FoodStation extends Fixed{

	private int capacity;
	
	// Constructor
	public FoodStation(){
		super();
		capacity = getSize();		
	}
		
	// Constructor with given color
	public FoodStation(int newcolor){
		super(newcolor);
		capacity = getSize();
	}
		
	//Constructor with given size, color and location
	public FoodStation(int newsize, Point newlocation, int newcolor) {
		super(newsize, newlocation, newcolor);
		capacity = newsize;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public void setCapacity(int newcapacity) {
		capacity = newcapacity;
	}
	
	public String toString() {
		//print food station
		String foodStationstring = "FoodStation: ";
		//print location
		String parentDesc = super.toString();
		String myDesc = " capacity=" + getCapacity();
		
		return foodStationstring + parentDesc + myDesc;
	}
	public void emptycapacity()
	{
		setCapacity(0);
		int LightGreen = ColorUtil.GREEN;
		setColor(LightGreen);
	}
}
