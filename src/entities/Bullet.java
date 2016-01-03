package entities;

import java.util.ArrayList;

import cache.Cache;
import collision.CollisionDetector;
import processing.core.*;
/*
 * Bullet - the base class for most objects in the game
 * Bullets are essentially vectors with a hitbox
 */
public class Bullet extends VectorEntity
{
	protected int width; //width of the hitbox
	protected int height; //height of the hitbox
	protected float lastX; //the previous x-position
	protected float lastY; //the previous y-position
	protected PImage sprite; //the current image
	protected int damage; //the damage this does against Enemies

	/*
	 * Many things extend bullet, even non-lethal objects
	 * Damage is only used for calculations against enemies, so it can be given
	 * an arbitrary value if this bullet is not a bullet coming from your player
	 */
	public Bullet(float xPos, float yPos, float xVel, float yVel, float xAcc, float yAcc, int width, int height, int damage, PApplet p){
		super (xPos,yPos,xVel,yVel,xAcc, yAcc,p);
		this.height = height;
		this.width = width;
		lastX = 0;
		lastY = 0;
		sprite = null;
		this.damage = damage;
		parent.ellipseMode(PConstants.CENTER);
	}
	
	public Bullet(float xPos, float yPos, float xVel, float yVel, float xAcc, float yAcc, int width, int height, int damage, String name, PApplet p){
		super (xPos,yPos,xVel,yVel,xAcc, yAcc,p);
		this.height = height;
		this.width = width;
		lastX = 0;
		lastY = 0;
		sprite = Cache.getPImage(name);
		parent.imageMode(PConstants.CENTER);
		this.damage = damage;
	}

	public void render()
	{
		if (sprite == null){
			parent.ellipse(x, y, width, height);
		} else {
			parent.image(sprite, x, y, width, height);
		}

	}
	
	public int getDamage(){
		return damage;
	}
	
	public int getWidth(){
		return width;
	}

	public int getHeight(){
		return height;
	}

	public float getLastX(){
		return lastX;
	}
	
	public float getLastY(){
		return lastY;
	}
	
	/*
	 * Effect is one way to tell if a bullet does anything besides harm you
	 * Return true if the bullet is not intended to kill (ie. in powerups)
	 * Return false if the bullet has no purpose other than to kill
	 */
	public boolean effect(Player p){
		return false;
	}
	
	public boolean collision(Bullet b){
		return CollisionDetector.collision(b, x, y, width, height);
	}
	
	/*
	 * Returns true if the bullet has collided with this object before
	 * Returns false if the bullet has not passed through this object yet
	 */
	public boolean hit(Bullet b){
		return false;
	}
	
	/*
	 * Return an empty list of bullets to simplify code
	 */
	public ArrayList<Bullet> shoot(){
		return new ArrayList<Bullet>();
	}
	
	public void update()
	{
		lastX = x;
		lastY = y;
		super.update();
		if (y > parent.height || y < 0)
		{
			super.cull();
		}

	}
}
