package objects;

import java.awt.Color;
import java.awt.Graphics;

import screens.GameScreen;
import system.MainOperator;

public class Platform extends GameObject {

	public Platform(double x, double y, double vx, double vy, double width,
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
		defaultDraw(g, Color.BLACK);
		return true;
	}

	// Use this to create the player!
	public static Platform createPlatform(double x, double y, double vx,
			double vy, double width, double height) {
		if (!(MainOperator.window.getActiveScreen() instanceof GameScreen))
			return null;
		Platform plat = new Platform(x, y, vx, vy, width, height);
		((GameScreen) MainOperator.window.getActiveScreen()).addPlatform(plat);
		return plat;
	}

}
