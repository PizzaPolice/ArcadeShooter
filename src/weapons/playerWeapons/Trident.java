package weapons.playerWeapons;

import java.util.ArrayList;

import processing.core.PApplet;
import entities.Bullet;
import types.Weapon;

public class Trident extends Weapon{
	public Trident(PApplet p){
		super(p);
		cooldown = 4;
	}
	
	public ArrayList<Bullet> shoot(float xPos, float yPos){
		ArrayList<Bullet> bullets = new ArrayList<Bullet>();
		if (checkCooldown()){
			Bullet b1 = new Bullet(xPos - 10, yPos, 0,-10, 0, 0, 4, 20, 2, "Line", parent);
			Bullet b2 = new Bullet(xPos    , yPos, 0,-10, 0, 0, 4, 20, 2, "Line", parent);
			Bullet b3 = new Bullet(xPos + 10, yPos, 0,-10, 0, 0, 4, 20, 2, "Line", parent);
			
			bullets.add(b1);
			bullets.add(b2);
			bullets.add(b3);

			lastShot = parent.frameCount;
		}
		return bullets;
	}
	
	public String getName(){
		return "Trident";
	}

}
