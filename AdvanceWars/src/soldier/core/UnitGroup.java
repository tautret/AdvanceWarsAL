/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Universit� Bordeaux.
 */
package soldier.core;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import observer_util.ObservableAbstract;

public class UnitGroup extends ObservableAbstract<Unit> 
                       implements Unit {

	private Set<Unit> units;
	private String name;
	private String camp;


	public UnitGroup(String name, String camp) {
		this.name = name;
		this.camp = camp;
		units = new TreeSet<Unit>(new Comparator<Unit>() {
			@Override
			public int compare(Unit o1, Unit o2) {
				if (o1.getName().compareTo(o2.getName()) == 0)
					return o1.hashCode() - o2.hashCode();
				else
					return o1.getName().compareTo(o2.getName());
			}
		});
	}

	@Override
	public void addUnit(Unit au) {
		units.add(au);
	}

	@Override
	public void removeUnit(Unit au) {
		units.remove(au);
	}

	@Override
	public String getName() {
		return name;
	}
	

	public String getCamp() {
		return camp;
	}
	
	@Override
	public float getHealthPoints() {
		float sum = 0.f;
		for (Unit u : units)
			sum += u.getHealthPoints();
		return sum;
	}

	@Override
	public boolean alive() {
		return getHealthPoints() > 0.f;
	}

	@Override
	public void heal() {
		for (Unit u : units)
			u.heal();
	}

	@Override
	public float parry(float force) {
		float f = 0.f;
		System.out.println(force);
		Iterator<Unit> it = subUnits();
		while (force > 0.f && it.hasNext()) {
			Unit u = it.next();
			if (!u.alive())
				continue;
			force = u.parry(force);
		}
		notifyObservers(this);
		return f;
	}

	@Override
	public float strike() {
		float sum = 0;
		for (Unit u : units) {
			if (u.alive())
				sum += u.strike();
		}
		return sum;
	}
	
	public int getNbSoldat(){
		int sum = 0;
		for(Unit u : units){
			if(u.alive())
				sum++;
		}
		return sum;
	}

	@Override
	public Iterator<Unit> subUnits() {
		return units.iterator();
	}

	@Override
	public void accept(UnitVisitor v) {
		v.visit(this);
	}

	@Override
	public Iterator<Weapon> getWeapons() {
		if (units.isEmpty())
			return Collections.emptyIterator();
		return new Iterator<Weapon>() {
			Iterator<Unit> itUnit = subUnits();
			Iterator<Weapon> curIt = itUnit.next().getWeapons();

			@Override
			public boolean hasNext() {
				while (!curIt.hasNext() && itUnit.hasNext())
					curIt = itUnit.next().getWeapons();
				return curIt.hasNext();
			}

			@Override
			public Weapon next() {
				return curIt.next();
			}
		};
	}

	@Override
	public void addEquipment(Weapon w) {
		Iterator<Unit> it = subUnits();
		while (it.hasNext()) {
			Unit u = it.next();
			try {
				u.addEquipment(w);
				w = w.clone();
			} catch (BreakingRuleException b) {
				System.out.println("Impossible to add " + w.getName() + " to " + u.getName());
			}
		}
	}

	@Override
	public void removeEquipment(Weapon w) {
		for (Iterator<Unit> it = subUnits(); it.hasNext(); it.next()
				.removeEquipment(w)) {
		}
	}

	@Override
	public int getMaxDeplacement() {
		Iterator<Unit> it = subUnits();
		int max=Integer.MAX_VALUE;
		while (it.hasNext()){
			Unit u = it.next();
			max = Integer.min(max, u.getMaxDeplacement());
		}
		return max;
	}

	@Override
	public void setMaxDeplacement(int value) {
		Iterator<Unit> it = subUnits();
		while (it.hasNext()){
			Unit u = it.next();
			u.setMaxDeplacement(value);
		}
	}

	@Override
	public int getDeplacementTurn() {
		Iterator<Unit> it = subUnits();
		while (it.hasNext()){
			Unit u = it.next();
			return u.getDeplacementTurn();
		}
		return 0;
	}

	@Override
	public int getMinRangeAttack() {
		Iterator<Unit> it = subUnits();
		while (it.hasNext()){
			Unit u = it.next();
			return u.getMinRangeAttack();
		}
		return 0;
	}

	@Override
	public int getMaxRangeAttack() {
		Iterator<Unit> it = subUnits();
		while (it.hasNext()){
			Unit u = it.next();
			return u.getMaxRangeAttack();
		}
		return 0;
	}
 
}
