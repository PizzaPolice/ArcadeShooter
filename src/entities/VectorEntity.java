package entities;
import processing.core.*;
/*
 * VectorEntity is essentially 3 parametric equations from math
 * One pair for position, another for velocity, another for acceleration
 */
public abstract class  VectorEntity extends NPC {
	
	protected float x;
	protected float y;
	protected float xVelocity;
	protected float yVelocity;
	protected float xAcceleration;
	protected float yAcceleration;
	

	public VectorEntity(float xPos, float yPos, float xVel, float yVel, PApplet p)
	{
		this(xPos, yPos, xVel, yVel, 0.0f, 0.0f, p);
	}
	
	public VectorEntity(float xPos, float yPos, float xVel, float yVel, float xAcc, float yAcc, PApplet p){
		super(p);
		x = xPos;
		y = yPos;
		xVelocity = xVel;
		yVelocity = yVel;
		xAcceleration = xAcc;
		yAcceleration = yAcc;
	}
	
	public void update()
	{
		x = x + xVelocity;
		y = y + yVelocity;
		xVelocity = xVelocity + xAcceleration;
		yVelocity = yVelocity + yAcceleration;
	}
	
	public void setXPos(float xPos)
	{
		x = xPos;
	}
	
	public void setYPos(float yPos)
	{
		y = yPos;
	}
	
	public void setYVelocity(float yVel)
	{
		yVelocity = yVel;
	}
	
	public void setXVelocity(float xVel)
	{
		xVelocity = xVel;
	}
	
	public void setXAcceleration(float xAcc)
	{
		xAcceleration = xAcc;	
	}
	
	public void setYAcceleration(float yAcc)
	{
		yAcceleration = yAcc;
	}
	
	public PApplet getPApplet(){
		return parent;
	}
	
	public float getXPosition()
	{
		return x;
	}
	
	public float getYPosition()
	{
		return y;
	}
	
	public float getXVelocity()
	{
		return xVelocity;
	}
	
	public float getYVelocity()
	{
		return yVelocity;
	}
	
	public float getXAcceleration()
	{
		return xAcceleration;
	}
	
	public float getYAcceleration()
	{
		return yAcceleration;
	}
}