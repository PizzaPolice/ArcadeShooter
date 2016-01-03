package enemy;

import java.util.ArrayList;

import processing.core.PApplet;
import types.Weapon;
import entities.Bullet;

//An enemy with a gun!
public abstract class ShootingEnemy extends Enemy{
	protected Weapon currentWeapon;

	public ShootingEnemy(float xPos, float yPos, float xVel, float yVel, float xAcc, float yAcc, int width, int height, int hp, String name,Weapon w, PApplet p){
		super(xPos, yPos, xVel, yVel, xAcc, yAcc, width, height, hp, name, p);
		currentWeapon = w;
	}

	public ArrayList<Bullet> shoot(){
		return currentWeapon.shoot(x, y);
	}
}
