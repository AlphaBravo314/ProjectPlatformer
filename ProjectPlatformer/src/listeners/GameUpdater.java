package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import system.MainOperator;

public class GameUpdater implements ActionListener {

	public static MainOperator window;

	public GameUpdater() {
		window = MainOperator.window;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		updateLogic();
		updateDraw();
	}

	private void updateLogic() {
		window.getActiveScreen().updateLogic();
	}

	private void updateDraw() {
		window.getActiveScreen().updateDraw();
	}
}
