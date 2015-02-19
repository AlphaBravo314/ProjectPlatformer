package listeners;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

import screens.Screen;

public abstract class ScreenListener implements KeyListener, MouseListener {

	protected String name;
	protected Screen screen;

	public ScreenListener(String name, Screen screen) {
		this.name = name;
		this.screen = screen;
	}

}
