package dispaly.Plane;

import java.awt.Canvas;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {
	
	private String title;
	private int hight;
	private int width;
	public static JFrame frame;
	private Canvas canvas;
	
	 public Display(String title,int width,int hight){
		this.title=title;
		this.hight=hight;
		this.width=width;
		CreateDispaly();
		
	 }
		public void CreateDispaly() {
			frame=new JFrame(title);
			frame.setSize(width,hight);
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
			frame.setResizable(false);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			canvas=new Canvas();
			canvas.setFocusable(false);
			canvas.setPreferredSize(new Dimension(width,hight));
			canvas.setBackground(new Color(212,154,140));
			
			frame.add(canvas);
			frame.pack();
			
			
		}
		public Canvas getCanvas() {
			return canvas;
		}
		
		
	

	
		
	}


