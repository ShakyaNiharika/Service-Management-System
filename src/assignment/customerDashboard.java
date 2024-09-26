package assignment;

import javafx.scene.control.ScrollPane;
import assignment.Gvar;
import java.security.Provider.Service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class customerDashboard extends Application {
	  @Override
	    public void start(Stage primaryStage) {
//		  String loggedInUserName = Gvar.username;
		//Pane for background color
	        Pane pane = new Pane();
	        pane.setStyle("-fx-background-color: #E6E7E8;");
	        pane.setPrefHeight(1000);
	        pane.setPrefWidth(1180);
	        
	        // Create a Pane for the header section
	        Pane headerPane = new Pane();
	        headerPane.setStyle("-fx-background-color: #CBD5E1;");
	        headerPane.setPrefHeight(80);
	        headerPane.setPrefWidth(1200);
	        
	        // Create a Pane for the content section
	        Pane sidePane = new Pane();
	        sidePane.setStyle("-fx-background-color: #CBD5E1;");
	        sidePane.setPrefHeight(620);
	        sidePane.setPrefWidth(268);
	        sidePane.setLayoutY(80);
	        
	        // Create a Pane for the available service
	        Pane servicesPane = new Pane();
	        servicesPane.setStyle("-fx-background-color: #CBD5E1;");
	        servicesPane.setPrefHeight(185);
	        servicesPane.setPrefWidth(245);
	        servicesPane.setLayoutX(320);
	        servicesPane.setLayoutY(425);
	        
	        // Create a Pane for the available service
	        Pane service_twoPane = new Pane();
	        service_twoPane.setStyle("-fx-background-color: #CBD5E1;");
	        service_twoPane.setPrefHeight(200);
	        service_twoPane.setPrefWidth(245);
	        service_twoPane.setLayoutX(590);
	        service_twoPane.setLayoutY(425);
	        
	        ///heree
	        
	        
	     // Create a Pane for the available service
	        Pane service_threePane = new Pane();
	        service_threePane.setStyle("-fx-background-color: #CBD5E1;");
	        service_threePane.setPrefHeight(360);
	        service_threePane.setPrefWidth(300);
	        service_threePane.setLayoutX(950);
	        service_threePane.setLayoutY(180);

	        // Create a Label for the header
	        Label head = new Label("Welcome To Service Management System");
	        head.setFont(new Font("Verdana", 24));
	        head.setTextFill(Color.BLACK);
	        head.setLayoutX(20);
	        head.setLayoutY(22);
	        
	        Label userName = new Label("Username: Reshma");
	        userName.setFont(new Font("Verdana", 24));
	        userName.setTextFill(Color.BLACK);
	        userName.setLayoutX(860);
	        userName.setLayoutY(22);
	        
	        
	       
//	        
	        //hereeeeee
//	        Label userOwnName = new Label("Customer ID: " + loginId);
//	        userOwnName.setFont(new Font("Verdana", 24));
//	        userOwnName.setTextFill(Color.BLACK);
//	        userOwnName.setLayoutX(400);
//	        userOwnName.setLayoutY(22);
	        
	        ImageView user = new ImageView(new Image(getClass().getResourceAsStream("userphoto.jpg")));
	        user.setFitWidth(180); // Adjust image width as needed
	        user.setFitHeight(140);
	        user.setPreserveRatio(true);
	        user.setLayoutX(40);
	        user.setLayoutY(50);
	        
	       
	        Button dashboard=new Button();
	        dashboard.setText("Dashboard");
	        dashboard.setFont(new Font("Verdana", 18));
	        dashboard.setTextFill(Color.BLACK);
	        dashboard.setLayoutX(60);
	        dashboard.setLayoutY(210);
	        dashboard.setStyle("-fx-background-color:#CBD5E1; -fx-text-fill: black;");
	       
	        //Button for the My Profile
		    Button profile=new Button();
	        profile.setText("My Profile");
	        profile.setFont(new Font("Verdana", 18));
	        profile.setTextFill(Color.BLACK);
	        profile.setLayoutX(60);
	        profile.setLayoutY(260);
	        profile.setStyle("-fx-background-color:#CBD5E1; -fx-text-fill: black;");
	        profile.setOnAction(event -> {
                // Open the Update profile page

	        	((Stage) profile.getScene().getWindow()).close();
                updateProfile nextUpdateProfile = new updateProfile();
                try {
                	nextUpdateProfile.start(new Stage());
                } catch (Exception e) {
                    e.printStackTrace();
                }});
	       
	        
	        //Button for the sideBar
	        Button appointment=new Button();
	        appointment.setText("My Appointment");
	        appointment.setFont(new Font("Verdana", 18));
	        appointment.setTextFill(Color.BLACK);
	        appointment.setLayoutX(60);
	        appointment.setLayoutY(310);
	        appointment.setStyle("-fx-background-color:#CBD5E1; -fx-text-fill: black;");
	        appointment.setOnAction(event -> {
	            // Open the Update profile page

	        	((Stage) appointment.getScene().getWindow()).close();
	            customer_history nextHistory = new customer_history();
	            try {
	            	nextHistory.start(new Stage());
	            } catch (Exception e) {
	                e.printStackTrace();
	            }});
	       

	        //Button for the sideBar
	        Button reschedule=new Button();
	        reschedule.setText("Reschedule Booking");
	        reschedule.setFont(new Font("Verdana", 18));
	        reschedule.setTextFill(Color.BLACK);
	        reschedule.setLayoutX(60);
	        reschedule.setLayoutY(360);
	        reschedule.setStyle("-fx-background-color:#CBD5E1; -fx-text-fill: black;");
	        reschedule.setOnAction(event -> {
	            // Open the Update profile page

	        	((Stage) reschedule.getScene().getWindow()).close();
	            rescheduleBooking nextReschedule = new rescheduleBooking();
	            try {
	            	nextReschedule.start(new Stage());
	            } catch (Exception e) {
	                e.printStackTrace();
	            }});
	       
	       
	        
	        //Button for logout
	        Button btnLogout=new Button();
	        btnLogout.setText("Logout");
	        btnLogout.setFont(new Font("Verdana", 20));
//	        btnLogout.setLayoutX(1);
	        btnLogout.setLayoutY(560);
	        btnLogout.setPrefWidth(260);
	        btnLogout.setPrefHeight(40);
	        btnLogout.setStyle("-fx-background-color:#CBD5E1; -fx-text-fill: black;");
	        
	        btnLogout.setOnAction(event -> {
	            // Open the Update profile page
	        	showAlert("Success", "Successfully logged out.");
	        	((Stage) btnLogout.getScene().getWindow()).close();
	            firstWindow nextlogout = new firstWindow();
	            try {
	            	nextlogout.start(new Stage());
	            } catch (Exception e) {
	                e.printStackTrace();
	            }});
	        
	        //Main Content
	      //Main Content
	     // Inside the method where you're setting up the scene for the second GUI
	     // Inside the method where you're setting up the scene for the second GUI
	        VBox servicesVBox = new VBox();
	        servicesVBox.setLayoutX(320);
	        servicesVBox.setLayoutY(180);

	        Label available_service = new Label("Available Services");
	        available_service.setFont(new Font("Verdana", 24));
	        available_service.setLayoutX(320);
	        available_service.setLayoutY(50);
	        available_service.setTextFill(Color.BLACK);
	        servicesVBox.getChildren().add(available_service);

	        // Call the method to retrieve services
	        List<NewService> services = retrieveServicesFromDatabase();



	        // Iterate over the services and create UI elements
	        for (NewService service : services) {
	            VBox serviceBox = new VBox();
	            serviceBox.setSpacing(20);

	            Label lblServiceName = new Label(service.getService_name());
	            lblServiceName.setFont(new Font("Verdana", 15));
	            lblServiceName.setTextFill(Color.BLACK);

	            Label lblDescription = new Label("Description: " + service.getDescription());
	            lblDescription.setFont(new Font("Verdana", 15));
	            lblDescription.setTextFill(Color.BLACK);

	            Label lblPrice = new Label("Price: Rs. " + service.getPrice());
	            lblPrice.setFont(new Font("Verdana", 15));
	            lblPrice.setTextFill(Color.BLACK);

	            Button btnBooking = new Button("Make Appointment");
	            btnBooking.setPrefWidth(140);
	            btnBooking.setStyle("-fx-background-color:#285884; -fx-text-fill: white;");

	            // Add event handling for the booking button if needed
	            btnBooking.setOnAction(event -> {
	                // Handle booking for this service
	                // You can access service.getServiceName(), service.getDescription(), and service.getPrice() here
	            	  // Open the Update profile page

	                makeBooking nextMakeBooking = new makeBooking();
	                try {
	                	nextMakeBooking.start(new Stage());
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            });
	            
	            Region spacing = new Region();
	            VBox.setVgrow(spacing, Priority.ALWAYS); 
	            serviceBox.getChildren().addAll(lblServiceName, lblDescription, lblPrice, btnBooking);
	            servicesVBox.getChildren().add(serviceBox);
	            
	            // Add padding below the Make Booking button
	            serviceBox.setPadding(new Insets(0, 0, 40, 0)); 
	            

	        }
	        
	        // Add servicesVBox to ScrollPane
	     // Adding the servicesVBox to a ScrollPane
	        ScrollPane scrollPane = new ScrollPane();
	        scrollPane.setContent(servicesVBox);
	        scrollPane.setFitToWidth(true);
	        // Add servicesVBox to your scene


	        // Add servicesVBox to your scene

	        // Electrician Service
	        VBox electricianBox = new VBox();
	        electricianBox.setSpacing(10);
	        Label lblElectrician = new Label("Electrician");
	        lblElectrician.setFont(new Font("Verdana", 15));
	        lblElectrician.setTextFill(Color.BLACK);

	        // Cleaning Service
	        VBox cleaningBox = new VBox();
	        cleaningBox.setSpacing(10);
	        Label lblCleaning = new Label("Cleaning");
	        lblCleaning.setFont(new Font("Verdana", 15));
	        lblCleaning.setTextFill(Color.BLACK);

//	        servicesVBox.getChildren().addAll(available_service, electricianBox, cleaningBox);


	        
	        // Add the Label to the headerPane
	        headerPane.getChildren().addAll(head,userName);
	        sidePane.getChildren().addAll(user,dashboard,profile,appointment,reschedule,btnLogout,available_service);
//	        servicesPane.getChildren().addAll(lblPlumbing,lblDisc,lblDiscPara,lblDuration,lblPrice,btnBooking);
	        service_twoPane.getChildren().addAll();

	        // Add the headerPane and contentPane to a VBox
	        // VBox rootPane = new VBox(headerPane, contentPane);

	        // Or, you can use a Pane directly if you don't need vertical stacking
	        Pane rootPane = new Pane(pane,headerPane, sidePane,servicesVBox);

	        // Create a Scene with the root Pane
	        Scene scene = new Scene(rootPane);

	        // Set the scene to the stage
	        primaryStage.setTitle("MyWindow");
	        primaryStage.setWidth(1180);
	        primaryStage.setHeight(740);
	        primaryStage.setX(100);
	        primaryStage.setY(20);
	        primaryStage.setScene(scene);
	        primaryStage.show();
	    }
	  private List<NewService> retrieveServicesFromDatabase() {
		    List<NewService> services = new ArrayList<>();
		    String DRIVER = "com.mysql.cj.jdbc.Driver";
		    String HOST = "localhost";
		    int PORT = 3306;
		    String DATABASE = "assignment";
		    String DBUSER = "root";
		    String DBPASS = "niharika@123";
		    String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;
		    String sql = "SELECT service_id, service_name, description, price FROM services";
		    try {
		        Class.forName(DRIVER); // Loading driver
		        Connection conn = DriverManager.getConnection(URL, DBUSER, DBPASS); // Establishing connection with the database server
		        PreparedStatement pstat = conn.prepareStatement(sql);
		        ResultSet rs = pstat.executeQuery();
		        while (rs.next()) {
		            int serviceId = rs.getInt("service_id");
		            String serviceName = rs.getString("service_name");
		            String description = rs.getString("description");
		            double price = rs.getDouble("price");
		            services.add(new NewService(serviceId, serviceName, description, price));
		        }
		        rs.close();
		        pstat.close();
		        conn.close();
		    } catch (Exception ex) {
		        ex.printStackTrace();
		    }
		    return services;
		}

	// Method to display an alert dialog
	    private void showAlert(String title, String message) {
	        Alert alert = new Alert(Alert.AlertType.INFORMATION);
	        alert.setTitle(title);
	        alert.setHeaderText(null);
	        alert.setContentText(message);
	        alert.showAndWait();
	    }

	    public static void main(String[] args) {
	        launch(args);
	    }
}
