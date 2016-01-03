package enemy;

import processing.core.PApplet;

public abstract class Boss extends ShootingEnemy{
	public Boss(float xPos, float yPos, float xVel, float yVel, float xAcc, float yAcc, int width, int height, int hp, String name, PApplet p) 
	{
		super(xPos, yPos, xVel, yVel, xAcc, yAcc, width, height, hp, name, null, p);
	}
}