package advancewars.units;

import java.awt.Canvas;

import soldier.core.UnitGroup;
import soldier.units.LightTank;

public class UnitLightTank extends Units{
	protected UnitGroup lightTankGroup;
	public static final int RENDERING_SIZE = 32; 
	
	public UnitLightTank(Canvas c,String name) {
		super(c,"images/Tank-"+name+".png",RENDERING_SIZE);
		lightTankGroup = new UnitGroup("LightTank",name);
	}
	
	public UnitGroup getUnitGroup() {
		return lightTankGroup;
	}
	
	public void createArmy(int nb_unit){
		for(int i = 0 ; i < nb_unit ; i ++){
			lightTankGroup.addUnit(new LightTank());
		}
	}
}
