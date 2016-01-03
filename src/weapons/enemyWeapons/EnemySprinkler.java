package weapons.enemyWeapons;

import entities.Bullet;
import java.util.ArrayList;
import processing.core.PApplet;
import types.Weapon;

public class EnemySprinkler extends Weapon{

	public EnemySprinkler(PApplet p){
		super(p);
		cooldown = 120;
	}

	public ArrayList<Bullet> shoot(float xPos, float yPos){
		ArrayList<Bullet> bullets = new ArrayList<Bullet>();
		if (checkCooldown()){
			Bullet b1 = new Bullet(xPos, yPos,    0, -2, 0, .05f, 4, 24, 3, "EnemyShot", parent);
			Bullet b2 = new Bullet(xPos, yPos, 1.5f, -2, 0, .05f, 4, 24, 3, "EnemyShot", parent);
			Bullet b3 = new Bullet(xPos, yPos,-1.5f, -2, 0, .05f, 4, 24, 3, "EnemyShot", parent);
			Bullet b4 = new Bullet(xPos, yPos, .75f, -2, 0, .05f, 4, 24, 3, "EnemyShot", parent);
			Bullet b5 = new Bullet(xPos, yPos,-.75f, -2, 0, .05f, 4, 24, 3, "EnemyShot", parent);
			bullets.add(b1);
			bullets.add(b2);
			bullets.add(b3);
			bullets.add(b4);
			bullets.add(b5);
			lastShot = parent.frameCount;
		}
		return bullets;
	}

	public String getName() {

		return "EnemySprinkler";
	}
}
