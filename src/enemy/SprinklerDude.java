package enemy;

import processing.core.PApplet;
import weapons.enemyWeapons.EnemySprinkler;

public class SprinklerDude extends ShootingEnemy{
	public SprinklerDude(float xPos, float yPos, float xVel, float yVel, float xAcc, float yAcc, int width, int height, int hp,  PApplet p)
	{
		super(xPos, yPos, xVel, yVel, xAcc, yAcc, width, height, hp, "SprinklerDude", new EnemySprinkler(p), p);
	}
}
