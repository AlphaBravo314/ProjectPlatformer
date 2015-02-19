package system;

import objects.Platform;
import objects.Player;

public class Storyboard {

	public static void startLevel(int x) {
		switch (x) {
		case 1:
			Player.createPlayer(
					Config.WINDOW_SIZE.width / 2 - 25,
					Config.WINDOW_SIZE.height / 2 - 25 + Config.PLAYER_ADJUST_Y,
					0, 0, 50, 50);
			Platform.createPlatform(100, 100, 0, 0, 30, 30);
			break;
		default:
			break;
		}
	}
}
