package advancewars.actions;

import gameframework.core.GameUniverse;

import java.awt.Canvas;

import soldier.weapon.ScenaryShield;
import advancewars.scenary.Scenary;
import advancewars.units.Units;

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
		
		if(u2.getUnitGroup().getNbSoldat() >= u1.getUnitGroup().getNbSoldat()){
//			u1.getUnitGroup().addEquipment(s1.getBehavior());
//			u2.getUnitGroup().addEquipment(s2.getBehavior());
			u2.getUnitGroup().parry(u1.getUnitGroup().strike());
			u1.getUnitGroup().parry(u2.getUnitGroup().strike());
//			u1.getUnitGroup().removeEquipment(s1.getBehavior());
//			u2.getUnitGroup().removeEquipment(s2.getBehavior());
		} else {
//			u2.getUnitGroup().addEquipment(s2.getBehavior());
			u2.getUnitGroup().parry(u1.getUnitGroup().strike());
//			u2.getUnitGroup().removeEquipment(s2.getBehavior());
		}
		if(!u2.getUnitGroup().alive()){
			universe.removeGameEntity(u2);
		}
			u1.setDisable(true);
	}

}
