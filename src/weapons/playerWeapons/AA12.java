package weapons.playerWeapons;

import java.util.ArrayList;

import entities.Bullet;
import processing.core.PApplet;
import types.Weapon;

public class AA12 extends Weapon{
	
	public AA12(PApplet p){
		super(p);
		cooldown = 9;
	}
	
	public ArrayList<Bullet> shoot(float xPos, float yPos){
		ArrayList<Bullet> bullets = new ArrayList<Bullet>();
		if (checkCooldown()){
			Bullet b1 = new Bullet(xPos, yPos, 1.5f, -10, 0, 0, 5, 5, 3, "Pellet", parent);
			Bullet b2 = new Bullet(xPos, yPos, 1, -10, 0, 0, 5, 5, 3, "Pellet", parent);
			Bullet b3 = new Bullet(xPos, yPos, .5f, -10, 0, 0, 5, 5, 3, "Pellet", parent);
			Bullet b4 = new Bullet(xPos, yPos, 0, -10, 0, 0, 5, 5, 3, "Pellet", parent);
			Bullet b5 = new Bullet(xPos, yPos, -.5f, -10, 0, 0, 5, 5, 3, "Pellet", parent);
			Bullet b6 = new Bullet(xPos, yPos, -1, -10, 0, 0, 5, 5, 3, "Pellet", parent);
			Bullet b7 = new Bullet(xPos, yPos, -1.5f, -10, 0, 0, 5, 5, 3, "Pellet", parent);
			bullets.add(b1);
			bullets.add(b2);
			bullets.add(b3);
			bullets.add(b4);
			bullets.add(b5);
			bullets.add(b6);
			bullets.add(b7);
			lastShot = parent.frameCount;
		}
		return bullets;
	}
	
	public String getName(){
		return "AA12";
	}
}
