package advancewars.actions;

import java.awt.Canvas;

import advancewars.scenary.Scenary;
import advancewars.units.Units;
import gameframework.core.GameUniverse;
import soldier.core.Weapon;
import soldier.weapon.ScenaryShield;

public class Attack extends Scenary implements Action {
	private GameUniverse universe;
	private Units u1;
	private Units u2;
	private Scenary s1;
	private Scenary s2;

	public Attack(Canvas defaultCanvas, int xx, int yy,Units u1, Units u2,Scenary s1, Scenary s2, GameUniverse universe) {
		super(defaultCanvas, xx, yy, "images/attack.png",new ScenaryShield(0));
		this.u1 = u1;
		this.u2 = u2;
		this.s1 = s1;
		this.s2 = s2;
		this.universe = universe;
	}

	@Override
	public void execute() {
		Weapon w1 = s1.getBehavior();
		Weapon w2 = s2.getBehavior();
		if(u2.getUnitGroup().getNbSoldat() >= u1.getUnitGroup().getNbSoldat()){
			//u1.getUnitGroup().addEquipment(w1);
			//u2.getUnitGroup().addEquipment(w2);
			u2.getUnitGroup().parry(u1.getUnitGroup().strike());
			u1.getUnitGroup().parry(u2.getUnitGroup().strike());
			//u1.getUnitGroup().removeEquipment(w1);
			//u2.getUnitGroup().removeEquipment(w2);
		} else {
			//u2.getUnitGroup().addEquipment(w2);
			u2.getUnitGroup().parry(u1.getUnitGroup().strike());
			//u2.getUnitGroup().removeEquipment(w2);
		}
		if(!u2.getUnitGroup().alive()){
			universe.removeGameEntity(u2);
		}
			u1.setDisable(true);
	}

}
