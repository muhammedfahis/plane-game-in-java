package dispaly.Plane.bullets;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet {
	
	private int x;
	private int y;
	private int speed;
	
	
	
	
	
	public Bullet(int x,int y) {
		this.x=x;
		this.y=y;
		speed=10;
		
		
		
		
	}
	public int getY() {
		return y;
	}
	public int getx() {
		return x;
	}

	

	public void tick() {
		y-=speed;
		
		
		
	}
	
	
	public void render(Graphics graphics) {
		graphics.setColor(Color.blue);
		graphics.fillRect(x, y, 6, 10);
		
		
	}

}
