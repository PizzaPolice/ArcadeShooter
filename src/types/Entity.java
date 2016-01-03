package types;

public interface Entity {
	//All objects can be..
	public void render(); //rendered (drawn) onto the screen
	public void update(); //have their state changed as a result of time
	public void cull(); //be removed from the game world
	public boolean checkIfCull(); //be checked if they need to be removed from the game world
}
