package entities;

import processing.core.PApplet;
import types.Entity;

public abstract class NPC implements Entity{
	protected boolean cull;
	protected PApplet parent;
	public NPC(PApplet p)
	{
		parent = p;
		cull = false;
	}
	
	public boolean checkIfCull()
	{
		return cull;
	}

	public void cull()
	{
		cull = true;
	}
	
	public abstract void update();
}
