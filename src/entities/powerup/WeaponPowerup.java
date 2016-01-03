package entities.powerup;

import entities.Player;
import processing.core.PApplet;
import types.Weapon;

public class WeaponPowerup extends Powerup{
	private Weapon weapon;
	
	public WeaponPowerup(Weapon w, PApplet p){
		super((float)Math.random() * p.width, 0, 0, 2, 0, 0, 20, 20, w.getName(), p);
		weapon = w;
	}
	
	public boolean effect(Player p){
		p.changeGun(weapon);
		return super.effect(p);
	}
}
