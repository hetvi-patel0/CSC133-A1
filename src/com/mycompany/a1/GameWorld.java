package com.mycompany.a1;

import java.util.ArrayList;
import java.util.Random;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

public class GameWorld {

	Game g;
	private int Countlife = 3;
	private int GameWorldHeight = 1000;
	private int GameWorldWidth = 1000;
	private int BlackColor = ColorUtil.BLACK;
	private int RedColor = ColorUtil.rgb(255,0,0);
	private int GreenColor = ColorUtil.GREEN;
	private int BlueColor = ColorUtil.BLUE;
	private int timer = 0;
	private ArrayList<GameObject> WalkItobjects;
	private int FlagCount;
	private int FoodStationCount;
	private int SpiderCount;
	private boolean GameOver;
	Random rand = new Random();
	
	public GameWorld() {
		
	}
	
	public void init() {
		WalkItobjects = new ArrayList<GameObject>();
		FlagCount = 0;
		FoodStationCount = 0;
		SpiderCount = 0;
		GameOver = false;
		timer = 0;
		Countlife = 0;
		addObjects();
	}
	
	
	
	public void addObjects() {
		
		//add new flags
		for(int i=1;i<5;i++)
		{
			WalkItobjects.add(new Flag(FlagCount, BlueColor, i));
			FlagCount++;
		}
		
		//add new foodstation
		for(int i=0;i<3;i++)
		{
			WalkItobjects.add(new FoodStation(GreenColor));
			FoodStationCount++;
		}
		
		//add new ant
		WalkItobjects.add(new Ant(RedColor));
		
		//add new spider
		for(int i=0;i<SpiderCount;i++)
		{
			WalkItobjects.add(new Spider(BlackColor));
			SpiderCount++;
		}
		
	}
	
	public void addFoodStation()
	{
		WalkItobjects.add(new FoodStation(GreenColor));
		FoodStationCount++;
	}
	
	public void accelerate() {
		System.out.println("Ant accelerates..increases speed!\n");
		for(int i=0;i<WalkItobjects.size();i++)
		{
			if(WalkItobjects.get(i) instanceof Ant)
			{
				((Ant)WalkItobjects.get(i)).antaccelerate();
			}
		}
	}

	public void brake() {
		System.out.println("Ant brakes.. decreases speed!\n");
		for(int i=0;i<WalkItobjects.size();i++)
		{
			if(WalkItobjects.get(i) instanceof Ant)
			{
				((Ant)WalkItobjects.get(i)).antbrake();
			}
		}
	}

	public void steerLeft() {
		System.out.println("Ant has truned left!\n");
		for(int i=0;i<WalkItobjects.size();i++)
		{
			if(WalkItobjects.get(i) instanceof Ant)
			{
				((Ant)WalkItobjects.get(i)).steerleft();
			}
		}
	}

	public void steerRight() {
		System.out.println("Ant has truned right!\n");
		for(int i=0;i<WalkItobjects.size();i++)
		{
			if(WalkItobjects.get(i) instanceof Ant)
			{
				((Ant)WalkItobjects.get(i)).steerright();
			}
		}
	}

	public void CollideFlag(int num) {
		System.out.println("There has been an ant collision with the flag!\n");
		for(int i=0;i<WalkItobjects.size();i++)
		{
			if((num-1)==((Ant)WalkItobjects.get(i)).getLastFlagReached())
			{
				System.out.println("The Ant has reached the next flag\n");
				((Ant)WalkItobjects.get(i)).newFlagReached();
			}
		}
	}

	public void CollideFoodStation() {
		System.out.println("There has been an ant collision with the food station\n");
		for(int i=0;i<WalkItobjects.size();i++)
		{
			if(WalkItobjects.get(i) instanceof Ant)
			{
				for(int j=0;j<WalkItobjects.size();j++)
				{
					if(WalkItobjects.get(j) instanceof FoodStation)
					{
						int TempFood = ((FoodStation)WalkItobjects.get(j)).getCapacity();
						if(TempFood>0)
						{
							((Ant)WalkItobjects.get(i)).addFoodLevel(TempFood);
							((FoodStation)WalkItobjects.get(j)).emptycapacity();
							addFoodStation();
						}
					}
				}
			}
		}
	}

	public void SpiderCollideAnt() {
		System.out.println("There is an ant collision with a spider!\n");
		for(int i=0;i<WalkItobjects.size();i++)
		{
			if(WalkItobjects.get(i) instanceof Ant)
			{
				((Ant)WalkItobjects.get(i)).lostHealth();
				((Ant)WalkItobjects.get(i)).checkHealthLevel();
				if(((Ant)WalkItobjects.get(i)).checkDie())
				{
					decLifeCount();
					return;
				}
			}
		}
	}

	public void Clocktick() {
		timer++;
		System.out.println("The clock has ticked!\n");
		for(int i=0;i<WalkItobjects.size();i++)
		{
			if(WalkItobjects.get(i) instanceof Spider)
			{
				if(((Spider)WalkItobjects.get(i)).checkOutOfBound())
				{
					((Spider)WalkItobjects.get(i)).changeHeading();
					((Spider)WalkItobjects.get(i)).move();
				}
			}
			if(WalkItobjects.get(i) instanceof Ant)
			{
				((Ant)WalkItobjects.get(i)).dropFoodLevel();
				((Ant)WalkItobjects.get(i)).checkFoodLevel();
				((Ant)WalkItobjects.get(i)).checkHealthLevel();
				
				if(!((Ant)WalkItobjects.get(i)).checkDie())
				{
					for(int j=0;j<WalkItobjects.size();j++)
					{
						((Ant)WalkItobjects.get(i)).move();
					}
				}
				else
				{
					decLifeCount();
					return;
				}
			}
		}
		
	}

	public void display() {
		System.out.println("Lives: " + getCountlife());
		System.out.println("Time#: " + gettimer());
		for(int i=0;i<WalkItobjects.size();i++)
		{
			if(WalkItobjects.get(i) instanceof Ant)
			{
				System.out.println("Last Flag Number Reached: " + ((Ant)WalkItobjects.get(i)).getLastFlagReached());
				System.out.println("Food Level: " + ((Ant)WalkItobjects.get(i)).getFoodLevel());
				System.out.println("Health Level: " + ((Ant)WalkItobjects.get(i)).getHealthLevel() + "\n");
			}
		}
	}

	public void map() {
		for(int i=0;i<WalkItobjects.size();i++)
		{
			if(WalkItobjects.get(i) instanceof Flag)
			{
				System.out.println(((Flag)WalkItobjects.get(i)).toString());
			}
			if(WalkItobjects.get(i) instanceof Ant)
			{
				System.out.println(((Ant)WalkItobjects.get(i)).toString());
			}
			if(WalkItobjects.get(i) instanceof Spider)
			{
				System.out.println(((Spider)WalkItobjects.get(i)).toString());
			}
			if(WalkItobjects.get(i) instanceof FoodStation)
			{
				System.out.println(((FoodStation)WalkItobjects.get(i)).toString());
			}
		}
		System.out.println("\n");
	}
	
	public void decLifeCount()
	{
		Countlife--;
		System.out.println("You lost 1 life!");
		if(getCountlife()==0)
		{
			System.out.println("Game over, you failed!");
			GameExit();
		}
		init();
	}

	public int getCountlife() 
	{
		return Countlife;
	}
	
	public int gettimer()
	{
		return timer;
	}
	
	public void setCountlife(int newcountlife) 
	{
		Countlife = newcountlife;
	}
	
	public void settimer(int newtimer)
	{
		timer = newtimer;
	}
	
	public void GameExit() {
		System.out.println("Confirm if you want to exit (y/n): ");

		Label myLabel = new Label("Enter a Command:");
		final TextField myTextField = new TextField();
		
		myTextField.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent evt) {
				
			String sCommand=myTextField.getText().toString();
			myTextField.clear();
			if(sCommand.length() != 0)
			{
				switch (sCommand.charAt(0))
				{
					case 'y':
						System.exit(0);
						break;
					case 'n':
						System.out.println("Game continue!");
				}
			}
		}
	});
}

}
