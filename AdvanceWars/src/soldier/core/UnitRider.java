/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Universit� Bordeaux.
 */
package soldier.core;

public abstract class UnitRider extends UnitSimple {

	public UnitRider(String name, BehaviorSoldier behavior, int minRangeAttack, int maxRangeAttack, int deplacementTurn, int maxDeplacement) {
		super(name, behavior,minRangeAttack,maxRangeAttack,deplacementTurn,maxDeplacement);
	}

	@Override
	public void accept(UnitVisitor v) {
		v.visit(this);
	}
}
