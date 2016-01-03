package enemy;

import processing.core.PApplet;
import weapons.enemyWeapons.EnemySpraygun;

public class SprayerDude extends ShootingEnemy {
	public SprayerDude(float xPos, float yPos, float xVel, float yVel, float xAcc, float yAcc, int width, int height, int hp,  PApplet p)
	{
		super(xPos, yPos, xVel, yVel, xAcc, yAcc, width, height, hp, "SprayerDude", new EnemySpraygun(p), p);
	}
}
