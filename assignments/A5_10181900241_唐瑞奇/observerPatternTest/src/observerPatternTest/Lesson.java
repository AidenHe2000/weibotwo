package observerPatternTest;

import java.util.ArrayList;
import java.util.List;

public class Lesson {
	private String name;
	private List<Observer> observers
	   = new ArrayList<Observer>();
	private boolean state;
	
	public Lesson(String name) {
		this.name = name;
	}

	public boolean getState() {
	   return state;
	}

	public void setState(boolean state) {
	   this.state = state;
	   notifyAllObservers();
	}

	public void attach(Observer observer){
	   observers.add(observer);
	}

	public void notifyAllObservers(){
	   for (Observer observer : observers) {
	      observer.update();
	   }
	}
}