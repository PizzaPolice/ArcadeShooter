package enemy;

import processing.core.PApplet;
import weapons.enemyWeapons.Grenade;

public class Grenadier extends ShootingEnemy{
	public Grenadier(float xPos, float yPos, float xVel, float yVel, float xAcc, float yAcc, 
			int width, int height, int hp, PApplet p){
		super(xPos, yPos, xVel, yVel, xAcc, yAcc, width, height, hp, "Grenadier", new Grenade(p),p);
	}
}
