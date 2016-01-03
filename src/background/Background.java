package background;

import java.util.ArrayList;

import cache.Cache;
import entities.Bullet;
import processing.core.PApplet;

public class Background {
	private PApplet parent;
	private ArrayList<Bullet> stars = new ArrayList<Bullet>();
	private boolean nuked;
	private int color = 0;

	public Background(PApplet p){
		parent = p;
		parent.background(0, 0, 0);
	}

	public void render(){
		if (Cache.kevin){
			//return;
		}
		if (color > 0){
			color -= 4;
		} else {
			nuked = false;
		}
		parent.background(color, color, color);	
		drawStars();
		if (parent.frameCount % 10 == 0){
			makeStar();
		}
		
	}

	public void makeStar(){
		float xPos = (float)Math.random() * parent.width;
		float yVel = (float)Math.random() * 15 + 5;
		stars.add(new Bullet(xPos, 0, 0, yVel, 0, 0, 2, 2, 0, parent));
	}

	public void nuke(){
		color = 255;
		nuked = true;
	}

	public boolean isNuked(){
		return nuked;
	}

	private void drawStars(){
		int index = 0;
		while (index < stars.size()){
			Bullet star = stars.get(index);
			if (star == null || star.checkIfCull()){
				star = null;
				stars.remove(index);
			} else {
				star.update();
				star.render();
				index++;
			}	
		}
	}
}
