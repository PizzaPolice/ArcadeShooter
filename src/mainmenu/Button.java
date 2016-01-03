package mainmenu;

import collision.CollisionDetector;
import processing.core.PConstants;
import processing.core.PFont;

public abstract class Button {
	protected Mainmenu parent;
	protected float x;
	protected float y;
	protected int normalColor;
	protected int highlightColor;
	protected int width;
	protected int height;
	protected PFont font;
	protected String text;
	
	public Button(float xPos, float yPos, PFont f, String label, Mainmenu p){
		parent = p;
		x = xPos;
		y = yPos;
		text = label;
		normalColor = p.color(0);
		highlightColor = p.color(0, 128, 0);
		width = 400;
		height = 50;
		font = f;
		p.textAlign(PConstants.CENTER, PConstants.CENTER);
		p.rectMode(PConstants.CENTER);
	}
	
	public void render(){
		parent.rect(x, y, width + 10, height + 10);
		if (mouseInButton()){
			parent.fill(highlightColor);
		} else {
			parent.fill(normalColor);
		}
		parent.rect(x, y, width, height);
		parent.fill(parent.color(255));
		parent.textFont(font, 36);
		parent.text(text, x, y);
	}
	
	public boolean mouseInButton(){
		return CollisionDetector.rangesOverlap(parent.mouseX, parent.mouseX, x - width / 2.0f, x + width / 2.0f) && 
				CollisionDetector.rangesOverlap(parent.mouseY, parent.mouseY, y - height / 2.0f, y + height / 2.0f);
	}
	
	public abstract void effect();
}
