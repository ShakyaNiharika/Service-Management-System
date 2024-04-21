package assignment;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class appointment extends Application {
	  @Override
	    public void start(Stage primaryStage) {
	        // Create a Pane for the header section
	        Pane headerPane = new Pane();
	        headerPane.setStyle("-fx-background-color: lightblue;");
	        headerPane.setPrefHeight(80);
	        headerPane.setPrefWidth(1000);
	        
	        // Create a Pane for the side bar 
	        Pane sidePane = new Pane();
	        sidePane.setStyle("-fx-background-color: lightblue;");
	        sidePane.setPrefHeight(580);
	        sidePane.setPrefWidth(256);
	        sidePane.setLayoutY(80);
	        
	        

	        // Create a Label for the header
	        Label head = new Label("Welcome To Service Management System");
	        head.setFont(new Font("Verdana", 24));
	        head.setTextFill(Color.BLACK);
	        head.setLayoutX(20);
	        head.setLayoutY(22);
	        
	        //Label for the sidebar
	        Label dashboard = new Label("Dashboard");
	        dashboard.setFont(new Font("Verdana", 18));
	        dashboard.setTextFill(Color.BLACK);
	        dashboard.setLayoutX(70);
	        dashboard.setLayoutY(210);
	        
	        //Label for the sideBar
	        Label profile = new Label("My Profile");
	        profile.setFont(new Font("Verdana", 18));
	        profile.setTextFill(Color.BLACK);
	        profile.setLayoutX(70);
	        profile.setLayoutY(260);
	        
	        //Label for the sideBar
	        Label appointment = new Label("My Appointment");
	        appointment.setFont(new Font("Verdana", 18));
	        appointment.setTextFill(Color.BLACK);
	        appointment.setLayoutX(70);
	        appointment.setLayoutY(310);

	        //Label for the sideBar
	        Label reschedule = new Label("Reschedule Services");
	        reschedule.setFont(new Font("Verdana", 18));
	        reschedule.setTextFill(Color.BLACK);
	        reschedule.setLayoutX(70);
	        reschedule.setLayoutY(360);
	        
	        //Label for My Appointments
	        Label title = new Label("My Appointments");
	        title.setFont(new Font("Verdana", 22));
	        title.setTextFill(Color.BLACK);
	        title.setLayoutX(315);
	        title.setLayoutY(70);
	        
	        //Label for Service Name
	        Label service = new Label("Service Name:");
	        service.setFont(new Font("bold", 18));
	        service.setTextFill(Color.BLACK);
	        service.setLayoutX(320);
	        service.setLayoutY(120);
	        
	        //Text Label
	        TextField serviceField = new TextField();
	        serviceField.setLayoutX(440);
	        serviceField.setLayoutY(120);
	        serviceField.setPrefWidth(260);
	        serviceField.setPrefHeight(30);
	        
	      //Label for Service Name
	        Label date = new Label("Date:");
	        date.setFont(new Font("bold", 18));
	        date.setTextFill(Color.BLACK);
	        date.setLayoutX(380);
	        date.setLayoutY(180);
	        
	        //Text Label
	        DatePicker datePicker = new DatePicker();
	        datePicker.setLayoutX(440);
	        datePicker.setLayoutY(180);
	        datePicker.setPrefWidth(260);
	        datePicker.setPrefHeight(30);
	        
	        //Label for time
	        Label time = new Label("Time:");
	        time.setFont(new Font("bold", 18));
	        time.setTextFill(Color.BLACK);
	        time.setLayoutX(380);
	        time.setLayoutY(180);
	        
	        
	        // Add the Label to the headerPane
	        headerPane.getChildren().addAll(head);
	        sidePane.getChildren().addAll(dashboard,profile,appointment,reschedule,title,service,serviceField,datePicker,date);
//	        mainPane.getChildren().addAll();
	      

	        // Add the headerPane and contentPane to a VBox
	        // VBox rootPane = new VBox(headerPane, contentPane);

	        // Or, you can use a Pane directly if you don't need vertical stacking
	        Pane rootPane = new Pane(headerPane,sidePane);

	        // Create a Scene with the root Pane
	        Scene scene = new Scene(rootPane);

	        // Set the scene to the stage
	        primaryStage.setTitle("MyWindow");
	        primaryStage.setWidth(1000);
	        primaryStage.setHeight(680);
	        primaryStage.setX(100);
	        primaryStage.setY(20);
	        primaryStage.setScene(scene);
	        primaryStage.show();
	    }

	    public static void main(String[] args) {
	        launch(args);
	    }
}

