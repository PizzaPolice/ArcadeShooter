package weapons.enemyWeapons;

import entities.Bullet;
import java.util.ArrayList;
import processing.core.PApplet;
import types.Weapon;

public class EnemySpraygun extends Weapon{
	public EnemySpraygun(PApplet p){
		super(p);
		cooldown = 15;
	}

	public ArrayList<Bullet> shoot(float xPos, float yPos) {
		ArrayList<Bullet> bullets = new ArrayList<Bullet>();
		if (checkCooldown()){		
			Bullet b1 = new Bullet(xPos, yPos, 0,5, 0, 0, 5, 5, 1, "EnemyShot", parent);
			Bullet b2 = new Bullet(xPos, yPos, 2,5, 0, 0, 5, 5, 1, "EnemyShot", parent);
			Bullet b3 = new Bullet(xPos, yPos,-2,5, 0, 0, 5, 5, 1, "EnemyShot", parent);
			Bullet b4 = new Bullet(xPos, yPos,-4,5, 0, 0, 5, 5, 1, "EnemyShot", parent);
			Bullet b5 = new Bullet(xPos, yPos, 4,5, 0, 0, 5, 5, 1, "EnemyShot", parent);
			Bullet b6 = new Bullet(xPos, yPos,-6,5, 0, 0, 5, 5, 1, "EnemyShot", parent);
			Bullet b7 = new Bullet(xPos, yPos, 6,5, 0, 0, 5, 5, 1, "EnemyShot", parent);
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
		return "Spraygun";
	}
}

