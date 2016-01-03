package weapons.playerWeapons;

import entities.Bullet;
import java.util.ArrayList;
import processing.core.PApplet;
import types.Weapon;

public class M1014 extends Weapon{
	
	public M1014(PApplet p){
		super(p);
		cooldown = 5;
	}

	public ArrayList<Bullet> shoot(float xPos, float yPos) {
		ArrayList<Bullet> bullets = new ArrayList<Bullet>();
		if (checkCooldown()){
			Bullet b1 = new Bullet(xPos, yPos, 0, -10, 0, 0, 5, 5, 2, "Pellet", parent);
			Bullet b2 = new Bullet(xPos, yPos, 2, -10, 0, 0, 5, 5, 2, "Pellet", parent);
			Bullet b3 = new Bullet(xPos, yPos, -2, -10, 0, 0, 5, 5, 2, "Pellet", parent);
			bullets.add(b1);
			bullets.add(b2);
			bullets.add(b3);
			lastShot = parent.frameCount;
		}
		return bullets;
	}

	public String getName(){
		return "M1014";
	}
}
