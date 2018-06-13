import acm.graphics.*;
import acm.program.*;

public class drawPeaceSymbol4 extends GraphicsProgram {
	private static final double PI = 3.14;
	public void run() {
		drawPeaceSymbol(100, 100, 50);
		
	}
	
	
	private void drawPeaceSymbol(double x, double y, double r) {
		double angle = Math.toRadians(45); //0.7853981634;
		double sinX = Math.sin(angle) * r * 2;
		double cosY = Math.cos(angle) * r * 2;
		GOval circle = new GOval(x, y, x + 2 * r, y + 2 * r);
		add(circle);
		GLine centerLine = new GLine(x +  2 * r, y, x + 2 * r,  (y + 4 * r));
		add(centerLine);
		GLine leftLine = new GLine(x + 2 * r, y + 2 * r,  (x + 2 * r) - sinX, (y + 2 * r) + cosY);
		add(leftLine);
		GLine rightLine = new GLine(x + 2 * r, y + 2 * r, (x + 2 * r) + sinX, (y + 2 * r) + cosY);
		add(rightLine);
		
	}

}
