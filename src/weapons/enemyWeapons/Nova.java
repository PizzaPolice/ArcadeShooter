package weapons.enemyWeapons;

import entities.Bullet;
import java.util.ArrayList;
import processing.core.PApplet;
import types.Weapon;

public class Nova extends Weapon{

	public Nova(PApplet p){
		super(p);
		cooldown = 40;
	}

	public ArrayList<Bullet> shoot(float xPos, float yPos) {
		ArrayList<Bullet> bullets = new ArrayList<Bullet>();
		if (checkCooldown()){
			Bullet b1 = new Bullet(xPos, yPos, 0, 5, 0, 0, 7, 7, 1, "EnemyPellet", parent);
			Bullet b2 = new Bullet(xPos, yPos, 3, 5, 0, 0, 7, 7, 1, "EnemyPellet", parent);
			Bullet b3 = new Bullet(xPos, yPos, -3, 5, 0, 0, 7, 7, 1, "EnemyPellet", parent);
			bullets.add(b1);
			bullets.add(b2);
			bullets.add(b3);
			lastShot = parent.frameCount;
		}
		return bullets;
	}

	public String getName(){
		return "EnemyShotgun";
	}
}