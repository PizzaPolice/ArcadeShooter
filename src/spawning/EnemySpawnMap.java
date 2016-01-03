package spawning;

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

import enemy.*;
import processing.core.PApplet;

public class EnemySpawnMap {
	private PApplet parent;
	private String[][] map;
	private int currentEnemy;

	public EnemySpawnMap(String filename, PApplet p){
		parent = p;
		map = parse(filename);
	}
	
	public String[][] parse (String filename){
		ArrayList<String[]> temp = new ArrayList<String[]>();
		try{
			Scanner csv = new Scanner(new File(filename));
			csv.nextLine();
			while (csv.hasNextLine()){
				temp.add(csv.nextLine().split(","));
			}
			String[][] data = temp.toArray(new String[temp.size()][]);
			csv.close();
			return data;
		} catch (IOException e){
			return null;
		}

	}

	public ArrayList<Enemy> readMap(){
		ArrayList<Enemy> enemies = new ArrayList<Enemy>();
		while (currentEnemy < map.length && Integer.parseInt(map[currentEnemy][1]) == parent.frameCount){
			enemies.add(createEnemy(map[currentEnemy]));
			currentEnemy++;
		}
		return enemies;
	}

	public boolean isEmpty(){
		return currentEnemy >= map.length;
	}
	
	private Enemy createEnemy(String[] info) {
		float xPos = Float.parseFloat(info[2]);
		float yPos = Float.parseFloat(info[3]);
		float xVel = Float.parseFloat(info[4]);
		float yVel = Float.parseFloat(info[5]);
		float xAcc = Float.parseFloat(info[6]);
		float yAcc = Float.parseFloat(info[7]);
		info[0] = info[0].toLowerCase();
		switch(info[0])
		{
		case ("asteroid"):
		{
			return new Asteroid(parent.width*xPos,parent.height*yPos,xVel,yVel,xAcc,yAcc,60,60,50,parent);
		}
		case("shotgundude"):
		{
			return new ShotgunDude(parent.width*xPos,parent.height*yPos,xVel,yVel,xAcc,yAcc,40,30,15,parent);
		}
		case ("shootingdude"):
		{
			return new ShootingDude(parent.width*xPos,parent.height*yPos,xVel,yVel,xAcc,yAcc,40,40,15,parent);
		}
		case ("sprayerdude"):
		{
			return new SprayerDude(parent.width*xPos,parent.height*yPos,xVel,yVel,xAcc,yAcc,25,25,25,parent);
		}
		case ("sprinklerdude"):
		{
			return new SprinklerDude(parent.width*xPos,parent.height*yPos,xVel,yVel,xAcc,yAcc,50,50,15,parent);
		}
		case("grenadier"):
		{
			return new Grenadier(parent.width * xPos, parent.height * yPos, xVel, yVel, xAcc, yAcc, 100, 100, 45, parent);
		}
		default:
			return null;
		}
	}

}

