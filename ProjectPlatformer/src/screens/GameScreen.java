package screens;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import objects.Enemy;
import objects.Platform;
import objects.Player;
import objects.Upgrade;
import system.MainOperator;
import listeners.GameScreenListener;

@SuppressWarnings("serial")
public class GameScreen extends Screen {

	public Player player;
	public ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	public ArrayList<Platform> platforms = new ArrayList<Platform>();
	public ArrayList<Upgrade> upgrades = new ArrayList<Upgrade>();

	public int screenX = 0;
	public int screenY = 0;

	public void addPlayer(Player p) {
		player = p;
	}

	public void addEnemy(Enemy e) {
		enemies.add(e);
	}

	public void addPlatform(Platform p) {
		System.out.println(platforms);
		platforms.add(p);
	}

	public void addUpgrade(Upgrade u) {
		upgrades.add(u);
	}

	@Override
	public void updateLogic() {
		if (player != null)
			player.updateMove();
	}

	@Override
	public void updateDraw() {
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		if (player != null)
			player.updateDraw(g);
		if (enemies.size() != 0)
			for (Enemy e : enemies)
				e.updateDraw(g);
		if (platforms.size() != 0)
			for (Platform plat : platforms)
				plat.updateDraw(g);
		if (upgrades.size() != 0)
			for (Upgrade u : upgrades)
				u.updateDraw(g);
	}

	@Override
	public void addListeners() {
		GameScreenListener gsl = new GameScreenListener(this);
		System.out.println("Adding " + gsl.getClass());
		MainOperator.window.addKeyListener(gsl);
		MainOperator.window.addMouseListener(gsl);

	}

	@Override
	public String getName() {
		return "gamescreen";
	}

	@Override
	public void handleMousePressedInput(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleMouseReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleKeyPressedInput(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			player.move(-10, 0);
			break;
		case KeyEvent.VK_RIGHT:
			player.move(10, 0);
			break;
		}
	}

	@Override
	public void handleKeyReleasedInput(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			player.move(0, 0);
			break;
		case KeyEvent.VK_RIGHT:
			player.move(0, 0);
			break;
		}

	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}

	public void setEnemies(ArrayList<Enemy> enemies) {
		this.enemies = enemies;
	}

	public ArrayList<Platform> getPlatforms() {
		return platforms;
	}

	public void setPlatforms(ArrayList<Platform> platforms) {
		this.platforms = platforms;
	}

	public ArrayList<Upgrade> getUpgrades() {
		return upgrades;
	}

	public void setUpgrades(ArrayList<Upgrade> upgrades) {
		this.upgrades = upgrades;
	}

	public int getScreenX() {
		return screenX;
	}

	public void setScreenX(int screenX) {
		this.screenX = screenX;
	}

	public int getScreenY() {
		return screenY;
	}

	public void setScreenY(int screenY) {
		this.screenY = screenY;
	}

}
