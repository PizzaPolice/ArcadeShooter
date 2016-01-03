package enemy;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;
import entities.Bullet;

//Enemy - a bullet with health
public class Enemy extends Bullet{
	protected float health;
	
	public Enemy(float xPos, float yPos, float xVel, float yVel, float xAcc, float yAcc, int width, int height, int hp, String name, PApplet p){
		super(xPos, yPos, xVel, yVel, xAcc, yAcc, width, height, 1, name, p);
		health = hp;
		p.imageMode(PConstants.CENTER);
	}
	
	public ArrayList<Bullet> deathrattle(){
		return new ArrayList<Bullet>();
	}
	
	//Getting hit by a bullet decrements hp by the bullet's damage
	//Checks if the position has hit this object before
	public boolean hit(Bullet b){
		if (b.hit(this)){
			return true;
		}
		health -= b.getDamage();
		if (health <= 0){
			super.cull();
		}
		return false;
	}
}
