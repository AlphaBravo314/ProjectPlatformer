package objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import screens.GameScreen;
import system.MainOperator;

public abstract class GameObject {
	
	private double x;
	private double y;
	
	private double vx;
	private double vy;
	
	private double width;
	private double height;
	
	protected double mass;

	protected BufferedImage img;
	
	public boolean toBeRemoved = false;
	/*
	 * Abstracts
	 */

	public abstract boolean updateMove();

	public abstract boolean updateDraw(Graphics g);
	
	public abstract void updateState();
	
	protected GameObject(double x, double y, double vx, double vy,
			double width, double height, BufferedImage img) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.vx = vx;
		this.vy = vy;
		this.img = img;
	}
	
	/*
	 * Can be instantiated with or without an image
	 */
	
	public GameObject(double x, double y, double vx, double vy,
			BufferedImage img) {
		this(x, y, vx, vy, img.getWidth(), img.getHeight(), img);
	}
	
	public GameObject(double x, double y, BufferedImage img) {
		this(x, y, 0, 0, img.getWidth(), img.getHeight(), img);
	}

	public GameObject(double x, double y, double vx, double vy, double width,
			double height) {
		this(x, y, vx, vy, width, height, null);
	}

	public GameObject(double x, double y, double width, double height) {
		this(x, y, 0, 0, width, height, null);
	}
	
	/*
	 * Publics
	 */

	public boolean intersects(GameObject go) {
		if (this.x >= go.x && this.x <= go.x + go.width && this.y >= go.y
				&& this.y <= go.y + go.height) {
			return true;
		} else {
			return false;
		}
	}
	
	public void remove(){
		toBeRemoved = true;
	}
	
	/*
	 * Protecteds
	 */

	protected void defaultMove() {
		this.x += this.vx;
		this.y += this.vy;
	}

	protected void defaultDraw(Graphics g, Color color) {
		g.setColor(color);
		g.fillRect(
				(int) (((GameScreen) (MainOperator.activeScreen)).screenX + x),
				(int) (((GameScreen) (MainOperator.activeScreen)).screenY + y),
				(int) width, (int) height);
		System.out
				.println((int) (((GameScreen) (MainOperator.activeScreen)).screenX - x));
		System.out
				.println((int) (((GameScreen) (MainOperator.activeScreen)).screenY - y));
		System.out.println();
	}

	protected void defaultDraw(Graphics g, BufferedImage img) {
		g.drawImage(img,
				(int) (((GameScreen) (MainOperator.activeScreen)).screenX + x),
				(int) (((GameScreen) (MainOperator.activeScreen)).screenY + y),
				(int) width, (int) height, null);
	}
	
	/*
	 * Getters and Setters
	 */
	
	public double getLeftX(){
		return x;
	}
	public double getRightX() {
		return x + width;
	}
	
	public void setLeftX(int x){
		this. x = x;
	}
	public void setRightX(int x) {
		this.x = x - this.width;
	}
	
	public double getTopY(){
		return y;
	}
	public double getBottomY() {
		return y + height;
	}
	
	public void setTopY(int y){
		this.y = y;
	}
	public void setBottomY(int y) {
		this.y = y - height;
	}
	
	public double getVx() {
		return vx;
	}

	public void setVx(double vx) {
		this.vx = vx;
	}

	public double getVy() {
		return vy;
	}

	public void setVy(double vy) {
		this.vy = vy;
	}
	
	public double getWidth() {
		return width;
	}
	
	public double getHeight() {
		return height;
	}
	
	public BufferedImage getImg() {
		return img;
	}
	
	public double getMass() {
		return mass;
	}
	
	
	
	
	
}
