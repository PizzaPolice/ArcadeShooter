package weapons.enemyWeapons;

import java.util.ArrayList;

import entities.Bullet;
import processing.core.PApplet;
import types.Weapon;

public class Grenade extends Weapon{
	public Grenade(PApplet p){
		super(p);
		cooldown = 60;
	}
	
	public ArrayList<Bullet> shoot(float xPos, float yPos){
		ArrayList<Bullet> bullets = new ArrayList<Bullet>();
		if (checkCooldown()){
			for (int i = 0; i < 360; i += 3){
				float angle = i * PApplet.PI / 180;
				bullets.add(new Bullet(xPos, yPos, 2 * PApplet.cos(angle), 
						2 * PApplet.sin(angle), 0, 0, 15, 15, 1, "Plasma", parent));
			}
			lastShot = parent.frameCount;
		}
		return bullets;
	}
	
	public String getName(){
		return "Grenade";
	}
}
