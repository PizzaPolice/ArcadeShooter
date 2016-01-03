package weapons.playerWeapons;

import java.util.ArrayList;

import entities.Bullet;
import processing.core.PApplet;
import types.Weapon;

public class M107 extends Weapon{
	public M107(PApplet p){
		super(p);
		cooldown = 20;
	}
	
	public ArrayList<Bullet> shoot(float xPos, float yPos){
		ArrayList<Bullet> bullets = new ArrayList<Bullet>();
		if (checkCooldown()){
			Bullet b1 = new Bullet(xPos, yPos, 0, -50, 0, 0, 5, 25, 75, "Magnum", parent);
			bullets.add(b1);
			lastShot = parent.frameCount;
		}
		return bullets;
	}
	
	public String getName(){
		return "M107";
	}
}
