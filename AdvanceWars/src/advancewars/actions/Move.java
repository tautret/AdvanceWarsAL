package advancewars.actions;

import java.awt.Canvas;

import advancewars.scenary.Scenary;
import soldier.weapon.ScenaryShield;

public class Move extends Scenary implements Action{

	public Move(Canvas defaultCanvas, int xx, int yy) {
		super(defaultCanvas, xx, yy, "images/move.png",new ScenaryShield(0));
	}

	@Override
	public void execute() {

	}
	
	@Override
    public int hashCode() {
        return this.getPosition().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
       if (obj instanceof Scenary){
    	   Scenary ge = ((Scenary)obj);
    	   return ge.getPos().equals(this.getPosition());
       }
       return false;
    }

}
