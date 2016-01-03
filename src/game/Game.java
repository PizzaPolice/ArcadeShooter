package game;

import java.util.ArrayList;

import mainmenu.Mainmenu;
import background.Background;
import entities.*;
import processing.core.*;
import random.Random;
import spawning.EnemySpawnMap;

//The world and the loop - where all the magic happens
public class Game extends PApplet 
{  
	private ArrayList<Bullet> npcList = new ArrayList<Bullet>(); //list of enemies and powerups
	private ArrayList<Bullet> playerBullets = new ArrayList<Bullet>(); //list of bullets that cannot kill the player but can kill objects in npcList
	private ArrayList<Bullet> enemyBullets = new ArrayList<Bullet>(); //list of bullets that can kill the player but cannot kill objects in npcList
	private Background background; //a simple background to accompany the game
	private EnemySpawnMap map; //the map being read currently
	private PFont font; //the font used for all text stuffs
	private Player p1; //You!
	private boolean endGame = false; //true if the game is over
	private static int bestTime = 0; //highest frameCount you've gotten to
	private boolean paused = false; //true if the game is purposefully not running

	public static void main(String args[]) 
	{
		PApplet.main(new String[] { "--present", "game.Game" }); //how to start processing as a java application and not as an applet
	}

	public void setup(){
		size(displayWidth / 2, displayHeight); //initialize this first so everything that needs a PApplet doesn't get null
		frameRate(60);
		p1 = new Player(this);
		background = new Background(this);
		map = new EnemySpawnMap("src/res/maps/InsaneMode.csv", this);
		font = createFont("Georgia",50,true);
	}

	public void draw(){
		drawBackground(); //draw background first so you can then draw on top of it
		spawnCarePackage(); //temporary
		update();
		checkCollision();
		render();
		npcList.addAll(map.readMap()); //spawn new enemies
		checkEndGame(); //check if the game has ended
		bestTime = Math.max(bestTime, frameCount);
		drawTimes();
	}

	private void update(){
		addBullets();
		update(npcList);
		update(playerBullets);
		update(enemyBullets);
	}

	private void update(ArrayList<Bullet> bullets){
		int index = 0;
		while (index < bullets.size()){
			Bullet b = bullets.get(index);
			if (b == null || b.checkIfCull()){
				bullets.remove(index);
			} else {
				b.update();
				index++;
			}
		}
	}

	private void checkCollision(){
		for (Bullet enemy : npcList){
			if (p1.collision(enemy)){ //if you smash into an enemy
				endGame = true;
			}
			for (Bullet b2 : playerBullets){ //if a bullet smashes into an enemy
				if (enemy.collision(b2)){
					enemy.hit(b2);
					b2.cull();
				}
			}
		}
		for (Bullet b : enemyBullets){
			if (p1.collision(b)){ //if you smash into a...
				if (b.effect(p1)){ //powerup
					b.cull();
				} else { //bullet
					endGame = true;
				}
			}
		}
	}

	public void render(){
		render(npcList);
		render(playerBullets);
		render(enemyBullets);
		p1.render();
	}

	private void render(ArrayList<Bullet> bullets){
		for (Bullet b : bullets){
			if (!b.checkIfCull()){
				b.render();
			}
		}
	}

	private void addBullets(){
		playerBullets.addAll(p1.shoot());
		for (Bullet e : npcList){
			enemyBullets.addAll(e.shoot());
		}
	}

	private void checkEndGame(){
		if (endGame){
			noLoop();
			textAlign(CENTER, CENTER);
			textFont(font, 36);
			fill(255);
			text("You died! \n Press \'r\' to try again", width / 2, height / 3);
		}
	}

	public void keyPressed(){
		if (key == 'w' || key == 'W' || keyCode == UP){
			p1.moveOn(0);
		}
		if (key == 'd' || key == 'D' || keyCode == RIGHT){
			p1.moveOn(1);
		}
		if (key == 's' || key == 'S' || keyCode == DOWN){
			p1.moveOn(2);
		}
		if (key == 'a' || key == 'A' || keyCode == LEFT){
			p1.moveOn(3);
		}
		if (key == ' ' && !background.isNuked() && p1.useNuke()){
			nuke();
		}
		if (key == 'r' || key == 'R') {
			noLoop();
			main(new String[] {});
			frame.setVisible(false);
		}
		if (keyCode == SHIFT){
			p1.fireOn();
		}
		if (keyCode == 20){
			p1.switchAutoFire();
		}
		if (key == ESC){
			if (!paused && !endGame){
				paused = true;
				noLoop();
				rectMode(CENTER);
				textAlign(CENTER, CENTER);
				fill(255);
				rect(width * .5f, height * .2f, 200, 125);
				fill(0, 128, 0);
				rect(width * .5f, height * .2f, 194, 119);
				textFont(font, 20);
				fill(255);
				text("PAUSED \n \'M\' for Main Menu \n \'Q\' to quit", width * .5f, height * .2f, 194, 119);
				key = 0;
			} else if (!endGame){
				paused = false;
				loop();
				key = 0;
			}
		}
		if ((key == 'm' || key == 'M') && paused){
			Mainmenu.main(new String[] {});
			frame.setVisible(false);
		}
		if ((key == 'q' || key == 'Q') && paused){
			exit();
		}
	}

	public void keyReleased(){
		if (key == 'w' || key == 'W' ||  keyCode == UP){
			p1.moveOff(0);
		}
		if (key == 'd' || key == 'D' || keyCode == RIGHT){
			p1.moveOff(1);
		}
		if (key == 's' || key == 'S' || keyCode == DOWN){
			p1.moveOff(2);
		}
		if (key == 'a' || key == 'A' || keyCode == LEFT){
			p1.moveOff(3);
		}
		if (keyCode == SHIFT){
			p1.fireOff();
		}
	}

	private void drawTimes(){
		textAlign(CORNER, CORNER);
		fill(255);
		textFont(font, 16);
		text("Score: " + frameCount, .025f * width, .025f * height);
		text("Best Score: " + bestTime, .025f * width, .05f * height);
		text("Nukes: " + p1.getNukes(), .025f * width, .975f * height);
	}

	private void nuke(){
		background.nuke();
		npcList.clear();
		enemyBullets.clear();
		playerBullets.clear();
	}

	private void drawBackground(){
		background.render();
	}

	private void spawnCarePackage(){
		if (frameCount % 60 == 0){
			enemyBullets.add(Random.randPowerup(this));
			//enemyBullets.add(new WeaponPowerup(Random.randWeapon(this), this));
			//enemyBullets.add(Random.randCivilPowerup(this));
		}
	}

	public Player getPlayer(){
		return p1;
	}

}