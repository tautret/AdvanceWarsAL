package advancewars.StrategyKeyboard;

import java.awt.Point;
import java.awt.event.KeyEvent;

import gameframework.moves_rules.MoveStrategyKeyboard;

public class MoveCursorKeyboard extends MoveStrategyKeyboard {

	public MoveCursorKeyboard() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void keyPressed(KeyEvent event) {
		int keycode = event.getKeyCode();
		switch (keycode) {
		case KeyEvent.VK_RIGHT:
			speedVector.setDirection(new Point(1, 0));
			break;
		case KeyEvent.VK_LEFT:
			speedVector.setDirection(new Point(-1, 0));
			break;
		case KeyEvent.VK_UP:
			speedVector.setDirection(new Point(0, -1));
			break;
		case KeyEvent.VK_DOWN:
			speedVector.setDirection(new Point(0, 1));
			break;
		case KeyEvent.VK_E:
			break;
		case KeyEvent.VK_W:
			break;
		case KeyEvent.VK_X:
			break;
		}
	}
}
