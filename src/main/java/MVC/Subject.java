package main.java.MVC;

/**
 * Representing a model for a view
 * @since 0.6
 */
public abstract class Subject {

	protected void notifyObservers() {
	}

	protected void notifyObservers(Object data) {
	}

	public void attach(Observer observer) {
	}

	public void detach(Observer observer) {
	}
}
