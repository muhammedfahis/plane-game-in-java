package dispaly.Plane.manager;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import dispaly.Plane.Display;
import dispaly.Plane.bullets.Bullet;
import dispaly.Plane.enemy.Enemy;
import dispaly.Plane.entity.Player;
import dispaly.Plane.graphics.LoadImage;
import dispaly.Plane.setup.SetUp;

public class GameManager implements KeyListener{
	private Player player;
	public static ArrayList<Bullet>bullet;
	private ArrayList<Enemy>enemies;
	private long current;
	private long delay;
	private int health;
	private int score;
	private boolean start;

	
	
	
	
	
	
	
	
	public GameManager() {
		
		
	}
	
	public void init() {
		Display.frame.addKeyListener(this);
		player=new Player((SetUp.Gamewidth/2)+50,(SetUp.GameHeight-60)+50);
		player.init();
		bullet=new ArrayList<Bullet>();
		enemies=new ArrayList<Enemy>();
		current=System.nanoTime();
		delay=800;
		health= player.gethealth();
		score=0;
		
		
		
		
	}
	public void tick() {
		if(start) {
		player.tick();
		for(int i=0;i<bullet.size();i++) {
			bullet.get(i).tick();
		}
		
		long breaks=(System.nanoTime()-current)/1000000;
		if(breaks>delay) {
		
		for(int i=0;i<2;i++) {
			Random rand=new Random();
			int randx=rand.nextInt(450);
			int randy=rand.nextInt(450);
			if(health>0) {
			enemies.add(new Enemy(randx, -randy));}
		}
		current=System.nanoTime();
		}
		//enemies
		for(int i=0;i<enemies.size();i++) {
			enemies.get(i).tick();
		}
		}
		
	}
	
	public void render(Graphics graphics) {
		if(start) {
		player.render(graphics);
		
		for(int i=0;i<bullet.size();i++) {
			bullet.get(i).render(graphics); 
		}
		for(int i=0;i<bullet.size();i++) {
			if(bullet.get(i).getY()<=50) {
				bullet.remove(i);
				i--;
			}
		}
		
		//enemies
		for(int i=0;i<enemies.size();i++) {
			
			if(!(enemies.get(i).getx()<=50 || enemies.get(i).getx()>=450-50 || enemies.get(i).gety()>=450-50)) {
			if(enemies.get(i).gety()>=50) {
				enemies.get(i).render(graphics);
			
				
			
		
	
	
		}}}
			
			
			for(int i=0; i<enemies.size();i++) {
				
				int ex=enemies.get(i).getx();
				int ey=enemies.get(i).gety();
				
				
				
				//collision of enemy and player
				/* if(r1.x <r2.x + width &&
				  r1.x + width >r2.x &&
				  r1.y <r2.y +width &&
				  r1.y +width > r2.y)
				 */
				
				
				// r1=player
				//r2=enemy
				
				int px=player.getx();
				int py=player.gety();
				
				if(px <ex +50 && px+60>ex && py<ey +50 && py +60 >ey) {
					enemies.remove(i);
					i--;
					health--;
					System.out.println(health);
					if(health<=0) {
						enemies.removeAll(enemies);
						player.sethealth(0);
						start=false;
					}
				}
				
				
				for(int j=0;j<bullet.size();j++) {
					int bx=bullet.get(j).getx();
					int by=bullet.get(j).getY(); 
					
					
					
					//collision of enemy and player
					/* if(r1.x <r2.x + width &&
					  r1.x + width >r2.x &&
					  r1.y <r2.y +width &&
					  r1.y +width > r2.y)
					 */
					
					//r1= enemies
					
					//r2= bullets
				if(ex <bx+6 && ex +50 >bx && ey <by +6 && ey +50 >by) {
					enemies.remove(i);
					i--;
					bullet.remove(j);
					j--;
					score+=5;
					
				}
			}
		
		
	}
			graphics.setColor(Color.blue);
			graphics.setFont(new Font("arial",Font.BOLD,40));
			graphics.drawString("Score :"+score, 70, 500);
	}
	
	else {
		graphics.setFont(new Font("arial",Font.PLAIN,33));
		graphics.drawString("press enter to start", 100, (SetUp.GameHeight/2)+50);
	}}


	public void keyPressed(KeyEvent e) {
		int source= e.getKeyCode();
		if(source==KeyEvent.VK_ENTER) {
			start=true;
			init();
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
