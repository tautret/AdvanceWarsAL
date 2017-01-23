package advancewars.StrategyKeyboard;

import java.awt.Point;
import java.awt.event.KeyEvent;

import advancewars.Cursor;
import advancewars.Selection;
import gameframework.moves_rules.MoveStrategyKeyboard;

public class MoveCursorKeyboard extends MoveStrategyKeyboard {
	private Selection s;
	private Cursor c;

	public MoveCursorKeyboard(Selection s,Cursor c) {
		this.s = s;
		this.c = c;
	}

	@Override
	public void keyPressed(KeyEvent event) {
		int keycode = event.getKeyCode();
		if (speedVector.getDirection().equals(new Point(0, 0))) {
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
				s.selectItem((Point)c.getPosition().clone());
				break;
			case KeyEvent.VK_X:
				s.unselect();
				break;
			}
		}
	}
}
