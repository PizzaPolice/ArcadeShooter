package mainmenu;

import processing.core.PFont;

public class QuitButton extends Button{
	public QuitButton(float xPos, float yPos, PFont f, Mainmenu p){
		super(xPos, yPos, f, "Quit", p);
	}

	public void effect() {
		parent.exit();
	}
}
