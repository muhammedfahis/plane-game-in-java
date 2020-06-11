package dispaly.Plane.graphics;

import java.awt.image.BufferedImage;


import java.io.IOException;

import javax.imageio.ImageIO;

public class LoadImage {
	
	public static BufferedImage image;
	public static BufferedImage entities;
	public static BufferedImage player,enemy;
	
	public static void init() {
		image=ImageLoader("/night.png");
		entities=ImageLoader("/airplane.png");
		crop();
	}
	
	public static BufferedImage ImageLoader(String path) {
		try {
			return ImageIO.read(LoadImage.class.getResource(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
	
		return null;
	
	
	}
	
	public static void crop() {
		enemy=entities.getSubimage(0, 0, 115, 95);
		player=entities.getSubimage(115, 0, 115, 95);
				
		
		
		
		
		
		
		
		
	}
}

