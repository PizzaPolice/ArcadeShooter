package entities.powerup;

import entities.Player;
import processing.core.PApplet;

public class SpeedPowerup extends Powerup{
	public SpeedPowerup(PApplet p){
		super((float)Math.random() * p.width, 0, 0, 2, 0, 0, 20, 20, "Speed", p);
	}
	
	public boolean effect(Player p){
		p.changeSpeed(5);
		return true;
	}
}
