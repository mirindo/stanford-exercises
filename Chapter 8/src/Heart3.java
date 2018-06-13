import acm.graphics.*;
import acm.program.*;

public class Heart3 extends GraphicsProgram {
	public void run() {	
		
		double centerWidth = getWidth() / 2;
		double centerHeight = getHeight() / 2;
		
		GHeart3 heart = new GHeart3(100);
		

		add(heart, centerWidth, centerHeight);
	}
}
