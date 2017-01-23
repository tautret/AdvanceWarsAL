package advancewars;

import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import advancewars.scenary.Scenary;
import advancewars.units.Units;
import gameframework.core.DrawableImage;
import gameframework.core.GameEntity;
import observer_util.Observer;
import soldier.core.UnitGroup;

public class MyPanel extends JPanel implements Observer<GameEntity>{
	//Unit Panel
	private JPanel unit = new JPanel();
	private final static TitledBorder unitBorder = BorderFactory.createTitledBorder("Unité");
	private final static ImageIcon heart = new ImageIcon("images/heart.png");
	private final static ImageIcon gas = new ImageIcon("images/gasoil.png");
	private final static ImageIcon ammo = new ImageIcon("images/ammo.png");

	private JLabel UnitArea = new JLabel();
	private JLabel unitName = new JLabel();
	private JLabel unitLife = new JLabel();
	private JLabel unitAmmo = new JLabel();
	private JLabel unitGas = new JLabel();
	
	//Scenary Panel
	private JPanel land = new JPanel();
	private final static TitledBorder landBorder = BorderFactory.createTitledBorder("Terrain");
	private JLabel landArea = new JLabel();
	private JLabel landName = new JLabel();
	private JLabel defenseBonusText = new JLabel("Defense Bonus:");
	private JLabel defenseBonusValue = new JLabel("0");
	private DrawableImage landImg = null;
	public MyPanel() {
		super();
		this.setLayout(new GridLayout(2,1));
		
		unit.setLayout(new GridLayout(4, 1));
		unit.setBorder(unitBorder);
		
		unitLife.setIcon(new ImageIcon(heart.getImage().getScaledInstance(16, 16, 1)));
		unitAmmo.setIcon(new ImageIcon(ammo.getImage().getScaledInstance(16, 16, 1)));
		unitGas.setIcon(new ImageIcon(gas.getImage().getScaledInstance(16, 16, 1)));
		JPanel tmp = new JPanel();
		tmp.add(UnitArea);
		tmp.add(unitName);
		unit.add(tmp);
		unit.add(unitLife);
		unit.add(unitAmmo);
		unit.add(unitGas);
		unit.setVisible(false);
		land.setLayout(new GridLayout(2, 2));
		land.setBorder(landBorder);
		land.add(landArea);
		land.add(landName);
		land.add(defenseBonusText);
		land.add(defenseBonusValue);
		land.setVisible(false);
		this.add(unit);
		this.add(land);
		
	}
	
	@Override
	public void update(GameEntity ge) {
		unit.setVisible(false);
		if (ge instanceof Scenary){
			land.setVisible(true);
			Scenary s = (Scenary) ge;
			landImg = s .getImage();
			String name = s.getClass().getName();
			landName.setText(name.substring(name.lastIndexOf(".")+1));
			landArea.setIcon(new ImageIcon(landImg.getImage().getScaledInstance(landArea.getHeight(),landArea.getHeight(), 1)));
			defenseBonusValue.setText(""+s.getBehavior().getValue());
			
		}
		else if (ge instanceof Units){
			Units u = (Units) ge;
			UnitGroup g = u.getUnitGroup();
			unit.setVisible(true);
			String name = u.getClass().getName();
			unitName.setText(name.substring(name.lastIndexOf("Unit")+4));
			unitLife.setText(""+g.getHealthPoints());
			unitGas.setText(u.getUnitGroup().getMaxDeplacement()+"");
			unitAmmo.setText(g.getMinRangeAttack()+" - "+g.getMaxRangeAttack());
		}else{
			unit.setVisible(false);
			land.setVisible(false);
		}
	}

}
