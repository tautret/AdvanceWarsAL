package advancewars;

import gameframework.core.ObservableValue;

public class Tour {
	
	private String tour;
	
	public String getTour() {
		return tour;
	}

	public void setTour(String tour) {
		this.tour = tour;
	}

	public Tour(String tour) {
		this.tour = tour;
	}
	
	public void newTour(ObservableValue<Integer> day){
		if(this.tour.equals("Blue")){
			this.tour = "Redtmp";
		} else if(this.tour.equals("Redtmp")){
			this.tour = "Red";
			day.setValue(day.getValue() + 1);
		} else if(this.tour.equals("Red")){
			this.tour = "Bluetmp";
		} else if(this.tour.equals("Bluetmp"))
		{
			this.tour = "Blue";
			day.setValue(day.getValue() + 1);
		}
	}

}
