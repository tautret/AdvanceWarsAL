package advancewars.units;

import java.awt.Canvas;

import soldier.core.UnitGroup;
import soldier.units.Jeep;

public class UnitJeep extends Units{
	protected UnitGroup jeepGroup;
	public static final int RENDERING_SIZE = 32;

	public UnitJeep(Canvas c,String name) {
		super(c,"images/Jeep-"+name+".png",RENDERING_SIZE);
		jeepGroup = new UnitGroup("Jeep",name);
	}
	
	public UnitGroup getUnitGroup() {
		return jeepGroup;
	}
	
	public void createArmy(int nb_unit){
		for(int i = 0 ; i < nb_unit ; i ++){
			jeepGroup.addUnit(new Jeep());
		}
	}
}
