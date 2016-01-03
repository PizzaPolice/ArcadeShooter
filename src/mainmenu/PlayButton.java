package mainmenu;

import game.Game;
import processing.core.PFont;

public class PlayButton extends Button{
	public PlayButton(float xPos, float yPos, PFont f, Mainmenu p){
		super(xPos, yPos, f, "Play", p);
	}
	
	public void effect(){
		Game.main(new String[] {});
		parent.frame.setVisible(false);
	}
}
