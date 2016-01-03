package weapons.playerWeapons;

import entities.Bullet;
import java.util.ArrayList;
import processing.core.PApplet;
import types.Weapon;

public class M2 extends Weapon{
	
	public M2(PApplet p){
		super(p);
		cooldown = 2;
	}
	
	public ArrayList<Bullet> shoot(float xPos, float yPos){
		ArrayList<Bullet> bullets = new ArrayList<Bullet>();
		if (checkCooldown()){
			Bullet b1 = new Bullet(xPos, yPos, (float)Math.random() - .5f, -12, 0, 0, 3, 8, 3, "Bullet", parent);
			bullets.add(b1);
			lastShot = parent.frameCount;
		}
		return bullets;
	}

	public String getName(){
		return "M2";
	}
}
