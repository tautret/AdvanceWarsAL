package advancewars.StrategyKeyboard;

import java.awt.Point;
import java.awt.event.KeyEvent;

import advancewars.Cursor;
import advancewars.Selection;
import advancewars.Selection.STATE;
import advancewars.Tour;
import gameframework.core.ObservableValue;
import gameframework.moves_rules.MoveStrategyKeyboard;

public class MoveCursorKeyboard extends MoveStrategyKeyboard {
	private Selection s;
	private Cursor c;
	private Tour t = new Tour("Red");
	private final ObservableValue<Integer> day;
	private boolean ok = true;
	
	public MoveCursorKeyboard(Selection s,Cursor c,ObservableValue<Integer> day) {
		this.s = s;
		this.c = c;
		this.day = day;
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
				s.unselect();
				t.newTour(day);
				s.newTour(t);
				break;
			case KeyEvent.VK_W:
				if (ok){
					if (s.get_current_state() == Selection.STATE.WAITING){
						s.selectItem((Point)c.getPosition().clone(),t);
					}
					else if (s.get_current_state() == STATE.READY){
						s.set_state(STATE.GO);
					}
					else{
						s.unselect();
					}
				}
				ok = false;
				break;
			case KeyEvent.VK_X:
				s.unselect();
				break;
			}
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e){
		ok = true;
	}
}
