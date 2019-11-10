package edu.toronto.cs.bangashm.csc207.countdowntimer;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.util.Duration;

/**
 * This class stores the state of our Countdown Timer. 
 * 
 * Observer views are able to attach to this model and get 
 * notified when the state of the countdown timer changes. 
 * 
 * @author arsala
 *
 */
public class CountdownTimerModel extends Observable {

	public static final int INITIAL_COUNT = 5;
	private int secondsLeft = INITIAL_COUNT;

	Timeline countdownTimeline = new Timeline();

	/**
	 * When the countdownTimeline ticks, it fires an event. 
	 * We handle this event by counting down the seconds left. 
	 */
	EventHandler countdownEventHandler = new EventHandler() {

		@Override
		public void handle(Event e) {
			secondsLeft--;
			notifyObservers();
			if (secondsLeft <= 0) {
				countdownTimeline.stop();
			}
		}

	};


	public CountdownTimerModel() {
		countdownTimeline.setCycleCount(Timeline.INDEFINITE);
		/*
		 * Timelines use keyframes to represent iterations of time slices. Our time slice 
		 * is 1s long and has a handler for the tick event that gets fired every second. 
		 */
		KeyFrame perSecondKeyFrame = new KeyFrame(Duration.seconds(1), countdownEventHandler);
		countdownTimeline.getKeyFrames().add(perSecondKeyFrame);
	}

	public void startTimer() {
		System.out.println("Starting Timer");
		countdownTimeline.play();
	}
	
	public void pauseTimer() {
		System.out.println("Pausing Timer");
		countdownTimeline.pause();
	}

	public void resetTimer() {
		System.out.println("Resetting Timer");
		countdownTimeline.stop();
		secondsLeft = INITIAL_COUNT;
		notifyObservers();
	}

	public int getSecondsLeft() {
		return secondsLeft;
	}
}
