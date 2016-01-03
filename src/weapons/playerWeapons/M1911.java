package weapons.playerWeapons;

import java.util.ArrayList;

import entities.Bullet;
import processing.core.PApplet;
import types.Weapon;

public class M1911 extends Weapon{
	public M1911(PApplet p){
		super(p);
		cooldown = 10;
	}
	
	public ArrayList<Bullet> shoot(float xPos, float yPos){
		ArrayList<Bullet> bullets = new ArrayList<Bullet>();
		if (checkCooldown()){
			Bullet b1 = new Bullet(xPos, yPos, (float)Math.random() - .5f, -7, 0, 0, 10, 15, 5, 
					"Magnum", parent);
			bullets.add(b1);
			lastShot = parent.frameCount;
		}
		return bullets;
	}
	
	public String getName(){
		return "M1911";
	}
}
