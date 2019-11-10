package edu.toronto.cs.bangashm.csc207.countdowntimer;

/**
 * Implementation of an Observer from the Observer/Observable 
 * See https://www.oodesign.com/observer-pattern.html 
 *
 * @author arsala
 *
 */
public interface Observer {
	public void update(Observable o);
}
