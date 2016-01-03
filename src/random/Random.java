package random;

import cache.Cache;
import processing.core.PApplet;
import processing.core.PImage;
import types.Weapon;
import weapons.playerWeapons.*;
import weapons.enemyWeapons.*;
import entities.powerup.*;

public class Random {
	public static Weapon randWeapon(PApplet p){
		switch((int)(Math.random() * 8)){
		case 0:
			return new M1014(p);
		case 1:
			return new M2(p);
		case 2:
			return new LineGun(p);
		case 3:
			return new AA12(p);
		case 4:
			return new M134(p);
		case 5:
			return new M107(p);
		case 6:	
			return new Trident(p);
		default:
			return new M1911(p);
		}
	}

	public static Powerup randCivilPowerup(PApplet p){
		switch((int)(Math.random() * 1)){
		case 0:
			return new SpeedPowerup(p);
		case 1:
			return new NukePowerup(p);
		default:
			return null;

		}
	}

	public static Powerup randPowerup(PApplet p){
		if (Math.random() < .5){
			return new WeaponPowerup(randWeapon(p), p);
		} else {
			return randCivilPowerup(p);
		}
	}

	public static Weapon randEnemyWeapon(PApplet p){
		switch((int)(Math.random() * 2)){
		case 0:
			return new Nova(p);
		case 1:
			return new Springfield(p);
		default:
			return new Nova(p);
		}
	}
	
	public static PImage randKBullet(){
		switch((int)(Math.random() * 7)){
		case 0:
			return Cache.getPImage("RedBullet");
		case 1:
			return Cache.getPImage("OrangeBullet");
		case 2:
			return Cache.getPImage("YellowBullet");
		case 3:
			return Cache.getPImage("GreenBullet");
		case 4:
			return Cache.getPImage("BlueBullet");
		case 5:
			return Cache.getPImage("PurpleBullet");
		default:
			return Cache.getPImage("PinkBullet");
		}
	}
}
