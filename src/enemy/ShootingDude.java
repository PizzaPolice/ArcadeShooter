package enemy;

import processing.core.PApplet;
import weapons.enemyWeapons.Springfield;

public class ShootingDude extends ShootingEnemy
{
	public ShootingDude(float xPos, float yPos, float xVel, float yVel, float xAcc, float yAcc, int width, int height, int hp, PApplet p) 
	{
		super(xPos, yPos, xVel, yVel, xAcc, yAcc, width, height, hp, "ShootingDude", new Springfield(p), p);
	}
}
