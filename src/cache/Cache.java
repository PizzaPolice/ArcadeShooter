package cache;

import java.util.ArrayList;
import java.util.HashMap;

import processing.core.*;
import random.Random;

public final class Cache{
	public static boolean kevin = false;
	public static HashMap<String, PImage> images = initializeCache();
	public static HashMap<String, PImage> kevinImages = initializeKCache();
	public static ArrayList<String> bulletNames = initializeBulletNames();
	
	private static ArrayList<String> initializeBulletNames(){
		ArrayList<String> bulletNames = new ArrayList<String>();
		bulletNames.add("Bullet");
		bulletNames.add("Magnum");
		bulletNames.add("Line");
		bulletNames.add("Pellet");
		bulletNames.add("EnemyShot");
		bulletNames.add("EnemyPellet");
		bulletNames.add("Plasma");
		return bulletNames;
	}
	
	private static HashMap<String, PImage> initializeCache(){
		PApplet p = new PApplet();
		HashMap<String, PImage> images = new HashMap<String, PImage>();
		//Player and Enemies
		images.put("Player", resize(p.loadImage("src/res/sprites/Standard/Player/Player.png"), 25, 25));
		images.put("Asteroid", resize(p.loadImage("src/res/sprites/Standard/Enemies/Asteroid.png"), 60, 60));
		images.put("ShootingDude", resize(p.loadImage("src/res/sprites/Standard/Enemies/ShootingDude.png"), 40, 40));
		images.put("ShotgunDude", resize(p.loadImage("src/res/sprites/Standard/Enemies/ShotgunDude.png"), 40, 30));
		images.put("SprayerDude", resize(p.loadImage("src/res/sprites/Standard/Enemies/SprayerDude.png"), 25, 25));
		images.put("SprinklerDude", resize(p.loadImage("src/res/sprites/Standard/Enemies/SprinklerDude.png"), 50, 50));
		images.put("Grenadier", resize(p.loadImage("src/res/sprites/Standard/Enemies/Grenadier.png"), 100, 100));
		//Powerups and weapons
		images.put("AA12", p.loadImage("src/res/sprites/Standard/Powerup/AA12.png"));
		images.put("LineGun", p.loadImage("src/res/sprites/Standard/Powerup/LineGun.png"));
		images.put("M1014", p.loadImage("src/res/sprites/Standard/Powerup/M1014.png"));
		images.put("M107", p.loadImage("src/res/sprites/Standard/Powerup/M107.png"));
		images.put("M134", p.loadImage("src/res/sprites/Standard/Powerup/M134.png"));
		images.put("M1911", p.loadImage("src/res/sprites/Standard/Powerup/M1911.png"));
		images.put("M2", p.loadImage("src/res/sprites/Standard/Powerup/M2.png"));
		images.put("Trident", p.loadImage("src/res/sprites/Standard/Powerup/Trident.png"));
		images.put("Nuke", p.loadImage("src/res/sprites/Standard/Powerup/Nuke.png"));
		images.put("Speed", p.loadImage("src/res/sprites/Standard/Powerup/speedup.png"));
		//Bullets
		images.put("Bullet", p.loadImage("src/res/sprites/Standard/Bullets/Bullet.png"));
		images.put("Magnum", p.loadImage("src/res/sprites/Standard/Bullets/Magnum.png"));
		images.put("Line", p.loadImage("src/res/sprites/Standard/Bullets/Line.png"));
		images.put("Pellet", p.loadImage("src/res/sprites/Standard/Bullets/Pellet.png"));
		images.put("EnemyShot", p.loadImage("src/res/sprites/Standard/Bullets/EnemyShot.png"));
		images.put("EnemyPellet", p.loadImage("src/res/sprites/Standard/Bullets/EnemyPellet.png"));
		images.put("Plasma", p.loadImage("src/res/sprites/Standard/Bullets/Plasma.png"));
		return images;
	}

	private static HashMap<String, PImage> initializeKCache(){
		HashMap<String, PImage> kevinImages = new HashMap<String, PImage>();
		PApplet p = new PApplet();
		//Player and Enemies
		kevinImages.put("Player", resize(p.loadImage("src/res/sprites/Standard/Player/Player.png"), 25, 25));
		kevinImages.put("Asteroid", resize(p.loadImage("src/res/sprites/Kevin/Enemies/Asteroid.png"), 60, 60));
		kevinImages.put("ShootingDude", resize(p.loadImage("src/res/sprites/Kevin/Enemies/ShootingDude.png"), 40, 40));
		kevinImages.put("ShotgunDude", resize(p.loadImage("src/res/sprites/Kevin/Enemies/ShotgunDude.png"), 40, 30));
		kevinImages.put("SprayerDude", resize(p.loadImage("src/res/sprites/Kevin/Enemies/SprayerDude.png"), 25, 25));
		kevinImages.put("SprinklerDude", resize(p.loadImage("src/res/sprites/Kevin/Enemies/SprinklerDude.png"), 50, 50));
		kevinImages.put("Grenadier", resize(p.loadImage("src/res/sprites/Standard/Enemies/Grenadier.png"), 100, 100));
		//Powerups and weapons
		kevinImages.put("AA12", p.loadImage("src/res/sprites/Standard/Powerup/AA12.png"));
		kevinImages.put("LineGun", p.loadImage("src/res/sprites/Standard/Powerup/LineGun.png"));
		kevinImages.put("M1014", p.loadImage("src/res/sprites/Standard/Powerup/M1014.png"));
		kevinImages.put("M107", p.loadImage("src/res/sprites/Standard/Powerup/M107.png"));
		kevinImages.put("M134", p.loadImage("src/res/sprites/Standard/Powerup/M134.png"));
		kevinImages.put("M1911", p.loadImage("src/res/sprites/Standard/Powerup/M1911.png"));
		kevinImages.put("M2", p.loadImage("src/res/sprites/Standard/Powerup/M2.png"));
		kevinImages.put("Trident", p.loadImage("src/res/sprites/Standard/Powerup/Trident.png"));
		kevinImages.put("Nuke", p.loadImage("src/res/sprites/Standard/Powerup/Nuke.png"));
		kevinImages.put("Speed", p.loadImage("src/res/sprites/Standard/Powerup/speedup.png"));
		//Bullets
		kevinImages.put("RedBullet", p.loadImage("src/res/sprites/Kevin/Bullets/RedBullet.png"));
		kevinImages.put("OrangeBullet", p.loadImage("src/res/sprites/Kevin/Bullets/OrangeBullet.png"));
		kevinImages.put("YellowBullet", p.loadImage("src/res/sprites/Kevin/Bullets/YellowBullet.png"));
		kevinImages.put("GreenBullet", p.loadImage("src/res/sprites/Kevin/Bullets/GreenBullet.png"));
		kevinImages.put("BlueBullet", p.loadImage("src/res/sprites/Kevin/Bullets/BlueBullet.png"));
		kevinImages.put("VioletBullet", p.loadImage("src/res/sprites/Kevin/Bullets/VioletBullet.png"));
		kevinImages.put("PinkBullet", p.loadImage("src/res/sprites/Kevin/Bullets/PinkBullet.png"));
		return kevinImages;
	}
	
	private static PImage resize(PImage image, int width, int height){
		//PApplet p = new PApplet();
		if (image == null){
			PApplet.println("woops");
		}
		image.resize(width, height);
		return image;
	}
	
	public static PImage getPImage(String s){
		if (kevin){
			if (bulletNames.contains(s)){ //Kevin likes having every bullet be a random color
				return Random.randKBullet();
			}
			return kevinImages.get(s);
		} else {
			return images.get(s);
		}
	}
}
