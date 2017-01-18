package advancewars;

import javax.swing.JLabel;
import javax.swing.JPanel;

import observer_util.Observer;
import advancewars.scenary.Scenary;

public class MyPanel extends JPanel implements Observer<Scenary>{
	
	JLabel label = new JLabel();
	
	public MyPanel() {
		super();
		this.add(label);
	}

	@Override
	public void update(Scenary s) {
		label.setText(s.getClass().getName());
	}

}
