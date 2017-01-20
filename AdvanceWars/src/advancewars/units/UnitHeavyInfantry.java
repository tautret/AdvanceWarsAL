package advancewars.units;

import java.awt.Canvas;

import soldier.core.UnitGroup;
import soldier.units.LightInfantry;

public class UnitHeavyInfantry extends Units{
	protected UnitGroup heavyInfantryGroup;
	public static final int RENDERING_SIZE = 32;

	public UnitHeavyInfantry(Canvas c,String name) {
		super(c,"images/Bazooka-"+name+".png", RENDERING_SIZE+3);
		heavyInfantryGroup = new UnitGroup("HeavyInfantry");
	}
	
	public UnitGroup getUnitGroup() {
		return heavyInfantryGroup;
	}
	
	public void createArmy(int nb_unit){
		for(int i = 0 ; i < nb_unit ; i ++){
			heavyInfantryGroup.addUnit(new LightInfantry());
		}
	}
}
