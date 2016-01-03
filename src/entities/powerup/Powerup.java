package entities.powerup;

import entities.Bullet;
import entities.Player;
import processing.core.PApplet;

public class Powerup extends Bullet{
	public Powerup(float xPos, float yPos, float xVel, float yVel, float xAcc, float yAcc, int width, int height, String name, PApplet p){
		super(xPos, yPos, xVel, yVel, xAcc, yAcc, width, height, 0, name, p);
	}
	
	public boolean effect(Player p){
		return true;
	}
}
