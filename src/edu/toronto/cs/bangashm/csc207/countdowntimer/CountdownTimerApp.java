package edu.toronto.cs.bangashm.csc207.countdowntimer;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * This application allows you to start, pause and reset a countdown timer.
 * 
 * The application uses MVC. The CountdownModel stores the state
 * 
 * @author arsala
 */
public class CountdownTimerApp extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	// Model
	CountdownTimerModel countdownModel;

	// Component views
	Button startTimerBtn = new Button("Start");
	Button resetTimerBtn = new Button("Reset");
	Button pauseTimerBtn = new Button("Pause");

	// Container views
	HBox buttonsContainer = new HBox();
	VBox root = new VBox();

	@Override
	public void start(Stage startStage) throws Exception {

		// Model
		countdownModel = new CountdownTimerModel();

		// View
		CountdownLabel countdownLabel = new CountdownLabel();
		countdownModel.attach(countdownLabel);

		// Controller
		setButtonControllers();

		// VIEW LAYOUT
		buttonsContainer.setPadding(new Insets(5));
		buttonsContainer.getChildren().addAll(startTimerBtn, resetTimerBtn, pauseTimerBtn);
		root.getChildren().addAll(buttonsContainer, countdownLabel);

		// VIEW SCENE
		Scene scene = new Scene(root, 200, 100);

		// VIEW STAGE
		startStage.setTitle("JavaFX Countdown Timer");
		startStage.setScene(scene);
		startStage.show();

	}

	private void setButtonControllers() {
		startTimerBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				countdownModel.startTimer();
			}

		});

		resetTimerBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				countdownModel.resetTimer();
			}

		});
		pauseTimerBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				countdownModel.pauseTimer();
			}

		});
	}

}
