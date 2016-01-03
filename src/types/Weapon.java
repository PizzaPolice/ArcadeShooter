package types;

import entities.Bullet;
import java.util.ArrayList;
import processing.core.PApplet;

// The weapon class is the base of everything that spawns non-enemy, non-powerup bullets
public abstract class Weapon {	
	protected PApplet parent; //The PApplet used to draw bullets
	protected int lastShot; //The last frame a volley was successfuly fired
	protected int cooldown; //The minimum time (in frames) allowed between shots
	
	
	public Weapon(PApplet p){
		parent = p;
		lastShot = 0;
	}
	
	//Returns a full list of Bullets spawned around the given x-position and y-position
	//Returns an empty list if the weapon is still on cooldown
	public abstract ArrayList<Bullet> shoot(float xPos, float yPos);

	//Returns the name of the weapon (oftentimes the name of the class)
	//Mainly used to grab the image associated with the weapon
	public abstract String getName();
	
	//Checks if cooldown frames have passed since the last shot successfully fired
	public boolean checkCooldown(){
		return parent.frameCount - lastShot >= cooldown;
	}
}
