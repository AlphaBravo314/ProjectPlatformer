package objects;

import java.awt.Color;
import java.awt.Graphics;

import screens.GameScreen;
import system.Config;
import system.MainOperator;

public class Player extends Entity {

	public Player(double x, double y, double vx, double vy, double width,
			double height) {
		super(x, y, vx, vy, width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean updateMove() {
		if (x < 0) {
			x = 0;
			return false;
		} else if (x > MainOperator.window.getWidth() - width) {
			x = MainOperator.window.getWidth() - width;
			return false;
		} else if (y < 0) {
			y = 0;
			return false;
		} else if (y > MainOperator.window.getHeight() - height) {
			y = MainOperator.window.getHeight() - height;
			return false;
		}
		((GameScreen) MainOperator.activeScreen)
				.setScreenX((int) (((GameScreen) MainOperator.activeScreen)
						.getScreenX() - vx));
		((GameScreen) MainOperator.activeScreen)
				.setScreenY((int) (((GameScreen) MainOperator.activeScreen)
						.getScreenY() - vy));
		return true;
	}

	@Override
	public boolean updateDraw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect((int) x, (int) y, (int) width, (int) height);
		// g.fillRect(
		// (int) (((1 / 2) * Config.WINDOW_SIZE.getWidth()) - ((1 / 2) *
		// width)),
		// (int) (((1 / 2) * Config.WINDOW_SIZE.getHeight()) - ((1 / 2) *
		// height)),
		// (int) width, (int) height);
		return true;
	}

	public void move(double vx, double vy) {
		this.vx = vx;
		this.vy = vy;
	}

	// Use this to create the player!
	public static Player createPlayer(double x, double y, double vx, double vy,
			double width, double height) {
		if (!(MainOperator.window.getActiveScreen() instanceof GameScreen))
			return null;
		Player p = new Player(x, y, vx, vy, width, height);
		((GameScreen) MainOperator.window.getActiveScreen()).addPlayer(p);
		return p;
	}
}
