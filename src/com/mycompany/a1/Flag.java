package com.mycompany.a1;

import com.codename1.charts.models.*;
import com.codename1.charts.util.ColorUtil;

public class Flag extends Fixed {

	private int sequenceNumber;
	
	//Constructor
	public Flag(){
		super();
		setSequenceNumber(0);
	}
	
	// Constructor with given color
	public Flag(int newcolor, int newseq){
		super(newcolor);
		setSequenceNumber(newseq);
	}
	
	// Constructor with given size and color
	public Flag(int newsize, int newcolor, int newseq){
		super(newsize, newcolor);
		setSequenceNumber(newseq);
	}
	
	//Constructor with given size, color and location
	public Flag(int newsize, Point newlocation, int newcolor) {
		super(newsize, newlocation, newcolor);
		setSequenceNumber(0);
	}
	
	public int getSequenceNumber() {
		return sequenceNumber;
	}
	
	public void setSequenceNumber(int newsequenceNumber) {
		sequenceNumber = newsequenceNumber;
	}
	
	public String toString()
	{
		//print flag
		String flagstring = "Flag: ";
		//print loc
		String parentDesc = super.toString();
		String myDesc = " seqNum=" + getSequenceNumber();
		
		return flagstring + parentDesc + myDesc;
	}
	
	public void setColor()
	{
		//flags can not change their color
	}
}
