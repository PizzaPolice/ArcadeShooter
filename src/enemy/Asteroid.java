package enemy;

import entities.Bullet;
import processing.core.PApplet;

public class Asteroid extends Enemy{
	public Asteroid (float xPos, float yPos, float xVel, float yVel, float xAcc, float yAcc, 
			int width, int height, int hp, PApplet p)
	{
		super(xPos,yPos,xVel,yVel,xAcc,yAcc,width,height,hp,"Asteroid",p);
	}
	
	public boolean hit(Bullet b){
		if (b.hit(this)){
			return true;
		}
		health -= Math.max(b.getDamage() - 1.0f, .5f);
		if (health <= 0){
			super.cull();
		}
		return false;
	}
}
