package weapons.enemyWeapons;

import entities.Bullet;
import java.util.ArrayList;
import processing.core.PApplet;
import types.Weapon;

public class Springfield extends Weapon{
	public Springfield(PApplet p){
		super(p);
		cooldown = 15;
	}

	public ArrayList<Bullet> shoot(float xPos, float yPos) {
		ArrayList<Bullet> bullets = new ArrayList<Bullet>();
		if (checkCooldown()){
			bullets.add(new Bullet(xPos, yPos, 0, 3, 0, .1f, 10, 10, 1, "EnemyShot", parent));
			lastShot = parent.frameCount;
		}
		return bullets;
	}

	public String getName() {
		return "Springfield";
	}
}
