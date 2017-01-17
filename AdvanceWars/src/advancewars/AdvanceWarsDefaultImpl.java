package advancewars;

import java.awt.Frame;

import javax.swing.JPanel;

import gameframework.core.GameDefaultImpl;

public class AdvanceWarsDefaultImpl extends GameDefaultImpl{
	
	private JPanel border;

	public AdvanceWarsDefaultImpl() {
		super();
	}
	
	@Override
	public void createGUI(){
		super.createGUI();
		((Frame)getCanvas().getParent()).setSize(1280, 720);
	}

}
