package edu.toronto.cs.bangashm.csc207.countdowntimer;

import javafx.scene.control.Label;

/**
 * This label observes the CountdownModel and updates its text on every
 * observer notification.
 * 
 * @author arsala
 */
public class CountdownLabel extends Label implements Observer {

	public CountdownLabel() {
		setText(CountdownTimerModel.INITIAL_COUNT + " s");
	}

	@Override
	public void update(Observable o) {
		CountdownTimerModel model = (CountdownTimerModel) o;
		int secondsLeft = model.getSecondsLeft();
		if (secondsLeft > 0) {
			setText(secondsLeft + " s");
		} else {
			setText("Countdown complete");
		}
	}

}
