package dispaly.Plane.setup;

import java.awt.Graphics;


import java.awt.image.BufferStrategy;

import dispaly.Plane.Display;
import dispaly.Plane.graphics.LoadImage;
import dispaly.Plane.manager.GameManager;

public class SetUp implements Runnable {
	
	
	private String title ;
	private int width;
	private int hight;
	private Thread thread;
	private boolean running;
	private Display display;
	private BufferStrategy buffer;
	private Graphics graphics;
    private int y;
    private GameManager manager;
    public static int Gamewidth = 400;
    public static int GameHeight = 400;
	
	public SetUp(String title,int width,int hight) {
		
		this.title=title;
		this.width=width;
		this.hight=hight;
	}
		
		public void init() {
			display=new Display( title, width,hight);
			LoadImage.init();
			
			manager=new GameManager();
			
			Gamewidth=400;
			GameHeight=400;
			manager.init();
			
			
		
	}
		
		public synchronized void  start () {
			if(running) 
				return ;
				running=true;
			
			if(thread==null) {
			thread= new Thread(this);
			thread.start();
		
			
			
		}}
		
		public synchronized void stop() {
			if(!(running)) 
				return ;
			running=false;
				
			
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
	}

		
		
		public void tick() {
			manager.tick();
			
			
			
		}
		
		
		public void render() {
			buffer= display.getCanvas().getBufferStrategy();
			if(buffer==null) {
				display.getCanvas().createBufferStrategy(3);
				return;
			}
			graphics=buffer.getDrawGraphics();
			graphics.clearRect(0,0, width, hight);
			//draw
			
		  
		    
		    graphics.drawImage(LoadImage.image,50, 50, Gamewidth, GameHeight,null);
		    manager.render(graphics);
			
			//end
			
			buffer.show();
			graphics.dispose();
			
			
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			init();
			
			
			int fps=50;
			double  timePerTick=1000000000/fps;
			double delta=0;
			long current=System.nanoTime();
			while(running) {
				
				
				delta=delta+(System.nanoTime()-current)/timePerTick;
				current=System.nanoTime();
			if(delta>=1) {
			tick(); 
			
			
		render();
		delta--;

		}}}} 
