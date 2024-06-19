
package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class lab2Q1 extends Application {
 
  private TextField tfSpeedVechical = new TextField();
  private TextField tfSpeedLimit = new TextField();
  private TextField tfTotalFine = new TextField();
  private Button btCalculate = new Button("Calculate");

 
  
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {

    // Create UI
    GridPane gridPane = new GridPane();
    // create radio buttons
    RadioButton rb1 = new RadioButton("Car");
    RadioButton rb2 = new RadioButton("Bike");
    
    ToggleGroup toggle = new ToggleGroup();
    rb1.setToggleGroup(toggle);
    rb2.setToggleGroup(toggle);
    
 
	
    //create UI
    gridPane.setHgap(5);
    gridPane.setVgap(5);
    gridPane.add(new Label("Vechical Type (click either one below) :"), 0, 0);
    gridPane.add(rb1, 0, 1);
    gridPane.add(rb2, 1, 1);
    gridPane.add(new Label("Speed of vechical( in km/j ):"), 0, 2);
    gridPane.add(tfSpeedVechical, 1, 2);
    gridPane.add(new Label("Speed Limit( in km/j ):"), 0, 3);
    gridPane.add(tfSpeedLimit, 1, 3);
    gridPane.add(new Label("Total Fine Payment:"), 0, 4);
    gridPane.add(tfTotalFine, 1, 4);
    gridPane.add(btCalculate, 1, 5);
 
    // Set properties for UI
    gridPane.setAlignment(Pos.CENTER);
    tfSpeedVechical.setAlignment(Pos.BOTTOM_RIGHT);
    tfSpeedLimit.setAlignment(Pos.BOTTOM_RIGHT);
    tfTotalFine.setAlignment(Pos.BOTTOM_RIGHT);
    tfTotalFine.setEditable(false);
    GridPane.setHalignment(btCalculate, HPos.RIGHT);
    gridPane.setStyle(" -fx-background-color:pink; ");
  
 // Process events
    btCalculate.setOnAction((ActionEvent e) -> {
        double speedVechical,speedLimit,TotalFine=0;
         speedVechical= Double.parseDouble(tfSpeedVechical.getText());
         speedLimit= Double.parseDouble(tfSpeedLimit.getText());

         if( speedVechical <= speedLimit)
         TotalFine = 0;
         
         else if(speedVechical > speedLimit && rb1.isSelected())
         TotalFine = (speedVechical-speedLimit)*(speedVechical-speedLimit)*0.5;
         
         else if(speedVechical > speedLimit && rb2.isSelected())
         TotalFine = (speedVechical - speedLimit) + 30; 

     // Display the fine to be paid 
     tfTotalFine.setText(String.format("RM %.2f", TotalFine));
        } );
 
    // Create a scene and place it in the stage
    Scene scene = new Scene(gridPane, 400, 250);
    primaryStage.setTitle("Fine Calculator"); // Set title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }
  
 
 
  
  // The main method 
  public static void main(String[] args) {
    launch(args);
  
}}
  
