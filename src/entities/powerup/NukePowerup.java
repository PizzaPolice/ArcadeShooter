package entities.powerup;

import entities.Player;
import processing.core.PApplet;

public class NukePowerup extends Powerup{
	public NukePowerup(PApplet p){
		super((float)Math.random() * p.width, 0, 0, 2, 0, 0, 20, 20, "Nuke", p);
	}
	
	public boolean effect(Player p){
		p.addNuke();
		return super.effect(p);
	}
}
