package weapons.playerWeapons;

import java.util.ArrayList;

import entities.Bullet;
import processing.core.PApplet;
import types.Weapon;

public class M134 extends Weapon{
	public M134(PApplet p){
		super(p);
		cooldown = 0;
	}
	
	public ArrayList<Bullet> shoot(float xPos, float yPos){
		ArrayList<Bullet> bullets = new ArrayList<Bullet>();
		if (checkCooldown()){
			Bullet b1 = new Bullet(xPos, yPos, (float)Math.random() - .5f, -11 - (float)Math.random(), 
					0, 0, 3, 8, 1, "Bullet", parent);
			Bullet b2 = new Bullet(xPos, yPos, (float)Math.random() - .5f, -11 - (float)Math.random(), 
					0, 0, 3, 8, 1, "Bullet", parent);
			bullets.add(b1);
			bullets.add(b2);
			lastShot = parent.frameCount;
		}
		return bullets;
	}
	
	public String getName(){
		return "M134";
	}
}
