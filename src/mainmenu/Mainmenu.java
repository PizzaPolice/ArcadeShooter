package mainmenu;

import java.util.ArrayList;
import background.Background;
import processing.core.PApplet;
import processing.core.PFont;

public class Mainmenu extends PApplet{
	
	private Background background;
	private ArrayList<Button> buttons = new ArrayList<Button>();
	private PFont titleFont;
	
	public static void main(String[] args){
		PApplet.main(new String[] { "--present", "mainmenu.Mainmenu" });
	}
	
	public void setup(){
		size(displayWidth / 2, displayHeight);
		frameRate(60);
		background = new Background(this);
		titleFont = createFont("Georgia",50,true);
		Button playButton = new PlayButton(width / 2.0f, height / 2.0f, titleFont, this);
		buttons.add(playButton);
		Button trippyButton = new TrippyButton(width / 2.0f, height / 1.5f, titleFont, this);
		buttons.add(trippyButton);
		Button quitButton = new QuitButton(width / 2.0f, 5.0f * height / 6, titleFont, this);
		buttons.add(quitButton);
		textAlign(CENTER, CENTER);
		
	}
	
	public void draw(){
		background.render();
		textFont(titleFont, 52);
		fill(255);
		text("SPACE GAME", width * .5f, height * .2f);
		for (Button b : buttons){
			b.render();
		}
		
	}
	
	public void keyPressed(){
		if (key == 'p' || key == 'P'){
			buttons.get(0).effect();
		}
		if (key == 'q' || key == 'Q'){
			buttons.get(2).effect();
		}
	}
	
	public void mouseClicked(){
		for (Button b : buttons){
			if (b.mouseInButton()){
				b.effect();
			}
		}
	}
	
}
