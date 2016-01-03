package weapons.playerWeapons;

import entities.Bullet;
import entities.SuperBullet;
import java.util.ArrayList;
import processing.core.PApplet;
import types.Weapon;

public class LineGun extends Weapon{
	public LineGun(PApplet p){
		super(p);
		cooldown = 60;
	}

	public ArrayList<Bullet> shoot(float xPos, float yPos) {
		ArrayList<Bullet> bullets = new ArrayList<Bullet>();
		if (checkCooldown()){
			bullets.add(new SuperBullet(xPos, yPos, 0, -5, 0, 0, 150, 5, 15, "Line", parent));
			lastShot = parent.frameCount;
		}
		return bullets;
	}
	
	public String getName(){
		return "LineGun";
	}
}
