package dispaly.Plane.entity;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import dispaly.Plane.Display;
import dispaly.Plane.bullets.Bullet;
import dispaly.Plane.graphics.LoadImage;
import dispaly.Plane.manager.GameManager;



public class Player implements KeyListener {
	private int x;
	private int y;
	private boolean left;
	private boolean right;
	private boolean fire;
	private long Current;
	private long delay;
	private int health;
	
	
	
	public Player(int x, int y) {
		this.x=x;
		this.y=y;
		
		
		
		
	}
	public void init() {
		Display.frame.addKeyListener(this);
		Current=System.nanoTime();
		delay=100;
		health=3;
		
		
		
		
	}
	public void tick() {
		if(!(health<=0)) {
		if(left) {
			if(x>=50) {
			
			x-=4;
			}}}
		if(right) {
			if(x<=450-60) {
			
			x+=4;
		}}
		if(fire) {
			
			long breaks =(System.nanoTime()-Current)/1000000;
			if(breaks> delay) {
			GameManager.bullet.add(new Bullet(x+30,y));
		}
			Current=System.nanoTime();
		}
		
		
		
		
		
		
	}

	public void render(Graphics graphics)	{
		if(!(health<=0)) {
		
		graphics.drawImage(LoadImage.player,x, y, 60, 60,null);
		
		
		
		}
	
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int source=e.getKeyCode();
		if(source==KeyEvent.VK_LEFT) {
			left=true;
		}
		if(source==KeyEvent.VK_RIGHT) {
			right=true;
		}
		if(source==KeyEvent.VK_B) {
			fire=true;
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		int source=e.getKeyCode();
		if(source==KeyEvent.VK_LEFT) {
			left=false;
			
		}
		if(source==KeyEvent.VK_RIGHT) {
			right=false;
		}
		if(source==KeyEvent.VK_B) {
			fire=false;
		}
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	public int getx() {
		return x;
	}
	public int gety() {
		return y;
	}
	public int gethealth() {
		return health;
	}
	public void sethealth(int health) {
		this.health=health;
	}

	
	
	
	
	
	
	
}
