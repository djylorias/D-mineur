package main.java.MVC;

import java.util.ArrayList;
import java.util.List;

/**
 * Representing a model for a view
 * @since 0.6
 */
public abstract class Subject {

	private List<Observer> observers = new ArrayList<>();

	protected void notifyObservers() {
		for(Observer obs : observers) obs.update(this);
	}

	protected void notifyObservers(Object data) {
		for(Observer obs : observers) obs.update(this, data);
	}

	public void attach(Observer observer) {
		observers.add(observer);
	}

	public void detach(Observer observer) {
		observers.remove(observer);
	}
}
