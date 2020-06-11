package dispaly.Plane.enemy;

import java.awt.Color;
import java.awt.Graphics;

import dispaly.Plane.graphics.LoadImage;

public class Enemy {
	public int x;
	public int y;
	
	
	
	
	
	public Enemy(int x, int y) {
		this.x=x;
		this.y=y;
		
		
		
	}
	public void tick() {
		y+=1;
		
		
		
	}
	
	public void render(Graphics graphics) {
		
		graphics.drawImage(LoadImage.enemy,x, y, 50, 50,null);
		
	}
	public int getx() {
		return x;
	}
	public int gety() {
		return y;
	}

}
