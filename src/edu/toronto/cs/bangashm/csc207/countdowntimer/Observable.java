package edu.toronto.cs.bangashm.csc207.countdowntimer;

import java.util.ArrayList;
/**
 * Implementation of an Observable from the Observer/Observable design pattern. 
 * See https://www.oodesign.com/observer-pattern.html 
 *
 * @author arsala
 *
 */
public class Observable {
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	
	public void attach(Observer o) {
		observers.add(o);
	}
	
	public void detach(Observer o) {
		observers.remove(o);
	}
	
	public void notifyObservers() {
		for(Observer o:observers) {
			o.update(this);
		}
	}
	
}
