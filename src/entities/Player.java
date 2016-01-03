package entities;

import java.util.ArrayList;

import cache.Cache;
import collision.CollisionDetector;
import types.Weapon;
import weapons.playerWeapons.*;
import processing.core.*;

public class Player{
	private PApplet parent;
	private float x;
	private float y;
	private float speed = 2.5f;
	private boolean[] currentMovement = new boolean[4];
	private PImage sprite;
	private Weapon gun;
	private boolean isFiring = false; 
	private boolean autofire = true;
	private int nukes = 1;
	
	public Player(PApplet p){
		parent = p;
		x = p.width / 2;
		y = p.height - p.height / 10;
		sprite = Cache.getPImage("Player");
		p.imageMode(PConstants.CENTER);
		gun = new M1911(p);
	}

	public void render(){
		move();
		if (sprite == null){
			parent.rect(x, y, 25, 25);
			return;
		}
		parent.image(sprite, x, y, 25, 25);
	}

	public float getX(){
		return x;
	}

	public float getY(){
		return y;
	}

	public void setX(float x){
		this.x = x;
	}

	public void setY(float y){
		this.y = y;
	}
	
	public void moveOn(int choice)
	{
		currentMovement[choice]= true;
	}

	public void moveOff(int choice)
	{
		currentMovement[choice] = false;
	}

	public void fireOn(){
		isFiring = true;
	}
	
	public void fireOff(){
		isFiring = false;
	}
	
	public void switchAutoFire(){
		autofire = !autofire;
	}
	
	public void move()
	{
		if (currentMovement[0] && y > 0){
			y -= speed; //move up
		}
		if (currentMovement[1] && x < parent.width){
			x += speed; //move right
		}
		if (currentMovement[2] && y < parent.height){
			y += speed; //move down
		}
		if (currentMovement[3] && x > 0){
			x -= speed; //move left
		}
	}

	public void changeGun(Weapon w){
		gun = w;
	}
	
	public void changeSpeed(int newSpeed){
		speed = newSpeed;
	}

	public void addNuke(){
		nukes++;
	}
	
	public ArrayList<Bullet> shoot(){
		if (isFiring || autofire){
			return gun.shoot(x, y);
		}
		return new ArrayList<Bullet>();
	}

	public boolean collision(Bullet b) {
		return CollisionDetector.collision(b, x, y);
	}
	
	public int getNukes(){
		return nukes;
	}
	
	public boolean useNuke(){
		if (nukes > 0){
			nukes--;
			return true;
		}
		return false;
	}
}