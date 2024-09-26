package assignment;

import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import assignment.Gvar;
import java.security.Provider.Service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import assignment.Gvar;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
import assignment.NewBooking;

public class rescheduleBooking extends Application {

	int customer_id = Gvar.id;
	  @Override
	    public void start(Stage primaryStage) {
		
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
	        
	        Label lblHeadReschedule = new Label("Reschedule Booking");
	        lblHeadReschedule.setLayoutX(360);
	        lblHeadReschedule.setLayoutY(45);
	        lblHeadReschedule.setFont(new Font("Verdana", 30)); 
	        lblHeadReschedule.setTextFill(Color.BLACK);
	        
	        TableView<NewBooking> table1 = new TableView<NewBooking>();
	        table1.setPrefWidth(600);
	        table1.setPrefHeight(300);
	        table1.setLayoutX(400);
	        table1.setLayoutY(115);

	        // Table Columns
	        TableColumn<NewBooking, Integer> booking_id = new TableColumn<>("SN");
	        booking_id.setCellValueFactory(new PropertyValueFactory<>("booking_id"));
	        booking_id.setMinWidth(15);

	     // TableColumn for service name
	        TableColumn<NewBooking, String> service_name = new TableColumn<>("Service Name");
	        service_name.setCellValueFactory(data -> {
	            // Access the NewService object from the NewBooking
	            NewService service = data.getValue().getServices();
	            // Return the service name
	            return new SimpleStringProperty(service.getService_name());
	        });
	        service_name.setMinWidth(170);

	        TableColumn<NewBooking, Integer> booking_date = new TableColumn<>("Booking Date");
	        booking_date.setCellValueFactory(new PropertyValueFactory<>("booking_date"));
	        booking_date.setMinWidth(170);

	        TableColumn<NewBooking, String> booking_time = new TableColumn<>("Booking Time");
	        booking_time.setCellValueFactory(new PropertyValueFactory<>("booking_time"));
	        booking_time.setMinWidth(170);


	        // Add the status column to the TableView
	        table1.getColumns().addAll(booking_id, service_name,  booking_date, booking_time);

	        // Update the list type to NewBookingWithStatus
	        List<NewBooking> bookings = allRecords();
	        // Set bookings to table1
	        for (NewBooking booking : bookings) {
	            table1.getItems().add(booking);
	        }
	        
	      //Fileds to update the bookings
	        Label bookingID = new Label("Booking ID");
	        bookingID.setLayoutX(290);
	        bookingID.setLayoutY(450);
	        bookingID.setFont(new Font("Verdana", 14)); 
	        bookingID.setTextFill(Color.BLACK);	
	        
	        TextField bookingIDField = new TextField();
	        bookingIDField.setLayoutX(410);
	        bookingIDField.setLayoutY(450);
	        bookingIDField.setPrefWidth(220);
	        bookingIDField.setPrefHeight(30);
	        
	        Label serviceName = new Label("Service Name");
	        serviceName.setLayoutX(700);
	        serviceName.setLayoutY(460);
	        serviceName.setFont(new Font("Verdana", 14)); 
	        serviceName.setTextFill(Color.BLACK);	
	       
	        ComboBox<String> comboBoxForAssign = new ComboBox<>();
	        comboBoxForAssign.setLayoutX(800);
	        comboBoxForAssign.setLayoutY(450);
	        comboBoxForAssign.setPrefWidth(220);
	        comboBoxForAssign.setPrefHeight(30);
	        showServiceName(comboBoxForAssign);
	        
	        Label booingdate = new Label("Booking date");
	        booingdate.setLayoutX(295);
	        booingdate.setLayoutY(490);
	        booingdate.setFont(new Font("Verdana", 14)); 
	        booingdate.setTextFill(Color.BLACK);	
	        
	        DatePicker datePickerField = new DatePicker();
	        datePickerField.setLayoutX(410);
	        datePickerField.setLayoutY(490);
	        datePickerField.setPrefWidth(220);
	        datePickerField.setPrefHeight(30);
	        
	        Label bookingTime = new Label("Booking Time");
	        bookingTime.setLayoutX(685);
	        bookingTime.setLayoutY(490);
	        bookingTime.setFont(new Font("Verdana", 16)); 
	        bookingTime.setTextFill(Color.BLACK);	
	        
	        TextField bookingTimeField = new TextField();
	        bookingTimeField.setLayoutX(800);
	        bookingTimeField.setLayoutY(490);
	        bookingTimeField.setPrefWidth(220);
	        bookingTimeField.setPrefHeight(30);
	        
	        Button btnSearch=new Button();
	        btnSearch.setText("Search");
	        btnSearch.setLayoutX(500);
	        btnSearch.setLayoutY(550);
	        btnSearch.setPrefWidth(100);
	        btnSearch.setPrefHeight(40);
	        btnSearch.setStyle("-fx-background-color:#285884; -fx-text-fill: white;");
	       
	        btnSearch.setOnAction((event) -> {
	            // Check if booking ID is entered
	            if (bookingIDField.getText().isEmpty()) {
	                showAlert("Error", "Please enter the booking ID.");
	            } else {
	                try {
	                    int bookingId = Integer.parseInt(bookingIDField.getText());
	                    System.out.println("Searching for booking ID: " + bookingId);
	                    
	                    NewBooking booking = searchRecord(bookingId);
	                    if (booking != null) {
	                        // Display booking details
	                        datePickerField.setValue(booking.getBooking_date());
	                        bookingTimeField.setText(booking.getBooking_time());
	                        System.out.println("Booking record found: " + booking);
	                        showAlert("Success", "Booking found");
	                    } else {
	                        showAlert("Error", "Booking record not found");
	                        System.out.println("Booking record not found for ID: " + bookingId);
	                    }
	                } catch (NumberFormatException e) {
	                    showAlert("Error", "Invalid booking ID format.");
	                    System.out.println("Invalid booking ID format: " + bookingIDField.getText());
	                }
	            }
	        });

	        Button btnUpdate=new Button();
	        btnUpdate.setText("Update");
	        btnUpdate.setLayoutX(700);
	        btnUpdate.setLayoutY(550);
	        btnUpdate.setPrefWidth(100);
	        btnUpdate.setPrefHeight(40);
	        btnUpdate.setStyle("-fx-background-color:#285884; -fx-text-fill: white;");
	        btnUpdate.setOnAction((event) -> {
	            // Check if booking ID is entered
	            if (bookingIDField.getText().isEmpty()) {
	                showAlert("Error", "Please select the booking ID to update.");
	            } else {
	                try {
	                    // Reading values from UI
	                    int bookingId = Integer.parseInt(bookingIDField.getText());
	                    LocalDate bookingDate = datePickerField.getValue();
	                    String bookingTimeValue = bookingTimeField.getText(); // Rename the variable here
	                    
	                  
	                    
	                    // Creating a NewBooking instance
	                    NewBooking booking = new NewBooking(bookingId, bookingDate, bookingTimeValue);
	                    
	                    // Call the updateRecord method with the booking instance
	                    boolean res = updateRecord(booking);
	                    if (res) {
	                        showAlert("Success", "Appointment updated successfully!");
	                        System.out.println("Record Saved");
	                        // Refresh the page
	                        ((Stage) btnUpdate.getScene().getWindow()).close();
	                        rescheduleBooking here = new rescheduleBooking();
	                        here.start(new Stage());
	                    } else {
	                        showAlert("Error", "Failed to update the record.");
	                        System.out.println("Error: Failed to update the record.");
	                    }
	                } catch (NumberFormatException e) {
	                    showAlert("Error", "Invalid booking ID format.");
	                    System.out.println("Invalid booking ID format: " + bookingIDField.getText());
	                }
	            }
	        });




	        
	        // Add the Label to the headerPane
	        headerPane.getChildren().addAll(head,userName);
	        sidePane.getChildren().addAll(user,dashboard,lblHeadReschedule,profile,appointment,reschedule,btnLogout,table1,
	        		bookingID,bookingIDField,serviceName,comboBoxForAssign,booingdate,datePickerField,bookingTime,bookingTimeField,btnSearch,btnUpdate);
//	        servicesPane.getChildren().addAll(lblPlumbing,lblDisc,lblDiscPara,lblDuration,lblPrice,btnBooking);
	       

	        // Add the headerPane and contentPane to a VBox
	        // VBox rootPane = new VBox(headerPane, contentPane);

	        // Or, you can use a Pane directly if you don't need vertical stacking
	        Pane rootPane = new Pane(pane,headerPane, sidePane);

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
	  private List<NewBooking> allRecords() {
		    List<NewBooking> bookings = new ArrayList<>();
		    String DRIVER = "com.mysql.cj.jdbc.Driver";
		    String HOST = "localhost";
		    int PORT = 3306;
		    String DATABASE = "assignment";
		    String DBUSER = "root";
		    String DBPASS = "niharika@123";
		    String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;
		    String sql = "SELECT b.booking_id, s.service_name, b.booking_date, b.booking_time FROM bookings b JOIN Services s ON b.service_id = s.service_id WHERE b.customer_id = ?";
		    try {
		        Class.forName(DRIVER); // Loading driver
		        Connection conn = DriverManager.getConnection(URL, DBUSER, DBPASS); // Establishing connection with the database server
		        PreparedStatement pstat = conn.prepareStatement(sql);
		        pstat.setInt(1, customer_id);
		        ResultSet rs = pstat.executeQuery();
		        while (rs.next()) {
		            int booking_id = rs.getInt("booking_id");
		            String service_name = rs.getString("service_name");
		            String booking_date_str = rs.getString("booking_date");
		            LocalDate booking_date = LocalDate.parse(booking_date_str);
		            String booking_time = rs.getString("booking_time");
		            NewService service = new NewService(0, service_name, null, 0.0);
		            bookings.add(new NewBooking(booking_id, service, 0.0f, booking_date, booking_time, 0.0f));
		        }
		        rs.close();
		        pstat.close();
		        conn.close();
		    } catch (Exception ex) {
		        ex.printStackTrace();
		    }
		    return bookings;
		}
	  

		//To display service name in comboBox
		public void showServiceName(ComboBox<String> comboBox) {
		    String DRIVER = "com.mysql.cj.jdbc.Driver";
		    String HOST = "localhost";
		    int PORT = 3306;
		    String DATABASE = "assignment";
		    String DBUSER = "root";
		    String DBPASS = "niharika@123";
		    String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;

		    try {
		        // Establishing connection
		        Connection connection = DriverManager.getConnection(URL, DBUSER, DBPASS);  
		        // Creating statement
		        PreparedStatement statement = connection.prepareStatement("SELECT service_name FROM services");
		        
		        // Executing query
		        ResultSet resultSet = statement.executeQuery();
		        comboBox.getItems().clear();
		        
		        // Adding worker IDs to the ComboBox
		        while (resultSet.next()) {
		            comboBox.getItems().add(resultSet.getString("service_name"));
		        }
		        
		        // Closing resources
		        resultSet.close();
		        statement.close();
		        connection.close();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}

		public NewBooking searchRecord(int bookingId) {
		    NewBooking booking = null;
		    String DRIVER = "com.mysql.cj.jdbc.Driver";
		    String HOST = "localhost";
		    int PORT = 3306;
		    String DATABASE = "assignment";
		    String DBUSER = "root";
		    String DBPASS = "niharika@123";
		    String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;
		    String sql = "SELECT b.booking_id, s.service_name, b.booking_date, b.booking_time FROM bookings b JOIN Services s ON b.service_id = s.service_id WHERE b.booking_id = ?";
		    try {
		        Class.forName(DRIVER); // Loading driver
		        Connection conn = DriverManager.getConnection(URL, DBUSER, DBPASS); // Establishing connection with the database server
		        PreparedStatement pstat = conn.prepareStatement(sql);
		        pstat.setInt(1, bookingId);
		        ResultSet rs = pstat.executeQuery();
		        if (rs.next()) {
		            int booking_id = rs.getInt("booking_id");
		            String service_name = rs.getString("service_name");
		            String booking_date_str = rs.getString("booking_date");
		            LocalDate booking_date = LocalDate.parse(booking_date_str);
		            String booking_time = rs.getString("booking_time");
		            NewService service = new NewService(0, service_name, null, 0.0);
		            booking = new NewBooking(booking_id, service, 0.0f, booking_date, booking_time, 0.0f);
		        }
		        rs.close();
		        pstat.close();
		        conn.close();
		    } catch (Exception ex) {
		        ex.printStackTrace();
		    }
		    return booking;
		};
		
		public boolean updateRecord(NewBooking booking) {
		    boolean result = false;
		    String DRIVER = "com.mysql.cj.jdbc.Driver";
		    String HOST = "localhost";
		    int PORT = 3306;
		    String DATABASE = "assignment";
		    String DBUSER = "root";
		    String DBPASS = "niharika@123";
		    String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;
		    String sql = "UPDATE bookings SET booking_date=?, booking_time=? WHERE booking_id=?";
		    try {
		        Class.forName(DRIVER); // Loading driver
		        Connection conn = DriverManager.getConnection(URL, DBUSER, DBPASS); // Establishing connection with the database server
		        PreparedStatement pstat = conn.prepareStatement(sql);
		        
		        // Set the values for the PreparedStatement
		        pstat.setString(1, booking.getBooking_date().toString()); // Assuming booking_date is a LocalDate
		        pstat.setString(2, booking.getBooking_time());
		        pstat.setInt(3, booking.getBooking_id());

		        // Execute the update operation
		        int rowsAffected = pstat.executeUpdate();
		        if (rowsAffected > 0) {
		            result = true;
		        }

		        // Close resources
		        pstat.close();
		        conn.close();
		    } catch (Exception ex) {
		        ex.printStackTrace();
		    }
		    return result;
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

