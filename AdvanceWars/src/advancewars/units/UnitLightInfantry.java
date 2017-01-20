package advancewars.units;

import java.awt.Canvas;

import soldier.core.UnitGroup;
import soldier.units.LightInfantry;

public class UnitLightInfantry extends Units{
	protected UnitGroup lightInfantryGroup;
	public static final int RENDERING_SIZE = 32;
	
	public UnitLightInfantry(Canvas c,String name) {
		super(c,"images/Soldier-"+name+".png",RENDERING_SIZE);
		lightInfantryGroup = new UnitGroup("LightInfantry");
	}
	
	public UnitGroup getUnitGroup() {
		return lightInfantryGroup;
	}
	
	public void createArmy(int nb_unit){
		for(int i = 0 ; i < nb_unit ; i ++){
			lightInfantryGroup.addUnit(new LightInfantry());
		}
	}
}
