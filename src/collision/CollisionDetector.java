package collision;

import entities.Bullet;

public final class CollisionDetector {
	public static boolean collision(Bullet b, float x, float y){
		return collision(b, x, y, 0, 0);
	}
	
	public static boolean collision(Bullet b, float x, float y, int hitboxWidth, int hitboxHeight){
		float bulletWidth = b.getWidth() / 2.0f * .8f;
		float bulletHeight = b.getHeight() / 2.0f * .8f;
		float bulletX = b.getXPosition();
		float bulletY = b.getYPosition();
		float oldBulletX = b.getLastX();
		float oldBulletY = b.getLastY();
		boolean inXRange = rangesOverlap(Math.min(oldBulletX - bulletWidth, bulletX - bulletWidth), 
				Math.max(oldBulletX + bulletWidth, bulletX + bulletWidth), x - hitboxWidth, x + hitboxWidth);
		boolean inYRange = rangesOverlap(Math.min(oldBulletY - bulletHeight, bulletY - bulletHeight), 
				Math.max(oldBulletY + bulletHeight, bulletY + bulletHeight), y - hitboxHeight, y + hitboxHeight);
		return inXRange && inYRange;
	}
	
	public static boolean rangesOverlap(float lowerbound1, float upperbound1, float lowerbound2, float upperbound2){
		return upperbound2 >= lowerbound1 && lowerbound2 <= upperbound1;
	}
}
