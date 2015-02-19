package objects;

import java.awt.Color;
import java.awt.Graphics;

public class Enemy extends Entity {

	public Enemy(double x, double y, double vx, double vy, double width,
			double height) {
		super(x, y, vx, vy, width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean updateMove() {
		defaultMove();
		return true;

	}

	@Override
	public boolean updateDraw(Graphics g) {
		defaultDraw(g, Color.RED);
		return true;
	}

}
