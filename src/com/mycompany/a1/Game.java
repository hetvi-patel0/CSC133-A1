package com.mycompany.a1;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import java.lang.String;


public class Game extends Form{
	private GameWorld gw;
	private boolean ConfirmExit = true;
	
	public Game()
	{
		gw = new GameWorld();
		gw.init();
		play();
	}
	
	private void play()
	{
		Label myLabel = new Label("Enter a Command:");
		this.addComponent(myLabel);
		final TextField myTextField = new TextField();
		this.addComponent(myTextField);
		this.show();
		
		myTextField.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent evt) {
				
			String sCommand=myTextField.getText().toString();
			myTextField.clear();
			if(sCommand.length() != 0)
				switch (sCommand.charAt(0)) {
					case 'a':
						gw.accelerate();
						break;
					case 'b':
						gw.brake();
						break;
					case 'l':
						gw.steerLeft();
						break;
					case 'r':
						gw.steerRight();
						break;
					case '1':
						gw.CollideFlag(1);
						break;
					case '2':
						gw.CollideFlag(2);
						break;
					case '3':
						gw.CollideFlag(3);
						break;
					case '4':
						gw.CollideFlag(4);
						break;
					case '5':
						gw.CollideFlag(5);
						break;
					case '6':
						gw.CollideFlag(6);
						break;
					case '7':
						gw.CollideFlag(7);
						break;
					case '8':
						gw.CollideFlag(8);
						break;
					case '9':
						gw.CollideFlag(9);
						break;
					case 'f':
						gw.CollideFoodStation();
						break;
					case 'g':
						gw.SpiderCollideAnt();
						break;
					case 't':
						gw.Clocktick();
						break;
					case 'd':
						gw.display();
						break;
					case 'm':
						gw.map();
						break;
					case 'x':
						gw.GameExit();
						break;
					default:
						System.out.println("Error! Invalid input. Try again");
						break;
						//add code to handle rest of the commands
				} //switch
			} //actionPerformed
			} //new ActionListener()
			); //addActionListener
			} //play
}
