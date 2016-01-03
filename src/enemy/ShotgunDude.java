package enemy;

import processing.core.PApplet;
import weapons.enemyWeapons.Nova;

public class ShotgunDude extends ShootingEnemy{
	public ShotgunDude(float xPos, float yPos, float xVel, float yVel, float xAcc, float yAcc, 
			int width, int height, int hp, PApplet p)
	{
		super(xPos, yPos, xVel, yVel, xAcc, yAcc, width, height, hp, "ShotgunDude", new Nova(p),p);
	}
}
