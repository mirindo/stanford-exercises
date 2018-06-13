import java.awt.Color;

import acm.graphics.*;

public class GHeart3 extends GCompound {
	public GHeart3(double lineLength) {
		
		double odvensna = Math.sqrt(lineLength * lineLength + lineLength * lineLength);
		double strana = lineLength / 5;
		
		base = createBase(lineLength);
		
		base.setFilled(true);
		base.setFillColor(Color.RED);
		base.setColor(Color.RED);
		add(base);
		
		leftHalf = half(odvensna, 45);
		leftHalf.setFilled(true);
		leftHalf.setColor(Color.RED);
		leftHalf.setFillColor(Color.RED);
		add(leftHalf, -odvensna + strana , -odvensna + strana +1);
		
		rightHalf = half(odvensna, -45);
		rightHalf.setFilled(true);
		rightHalf.setColor(Color.RED);
		rightHalf.setFillColor(Color.RED);
		add(rightHalf, 0 - strana , -odvensna + strana +1);
	}
	
	private GPolygon createBase(double lineLength) {
		GPolygon poly = new GPolygon();
		poly.addVertex(0, -lineLength);
		poly.addVertex(-lineLength, 0);
		poly.addVertex(0, lineLength);
		poly.addVertex(lineLength, 0);
		return poly;
	}
	
	private GArc half(double lineLength, int coo) {
		GArc left = new GArc(lineLength, lineLength, coo, 180);
		return left;
	}
	
	private GPolygon base;
	private GArc leftHalf, rightHalf;
}
