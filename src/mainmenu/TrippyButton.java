package mainmenu;

import cache.Cache;
import processing.core.PFont;

public class TrippyButton extends Button{
	public TrippyButton(float xPos, float yPos, PFont f, Mainmenu p){
		super(xPos, yPos, f, "???", p);
	}
	
	public void effect(){
		Cache.kevin = !Cache.kevin;
	}
}
