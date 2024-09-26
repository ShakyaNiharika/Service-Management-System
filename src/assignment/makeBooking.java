package assignment;
import assignment.Gvar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class makeBooking extends Application{
	int customer_id=Gvar.id;
	 @Override
	    public void start(Stage primaryStage) {
		 Pane pane = new Pane();
		 	//Main Content
		 	Label head = new Label("Make Appointment");
	        head.setFont(new Font("Verdana", 24));
	        head.setTextFill(Color.BLACK);
	        head.setLayoutX(100);
	        head.setLayoutY(20);
	        
	        Label service_name = new Label("Service Name:");
	        service_name.setFont(new Font("Verdana", 14));
	        service_name.setTextFill(Color.BLACK);
	        service_name.setLayoutX(40);
	        service_name.setLayoutY(80);
	       
	        ComboBox<String> comboBox = new ComboBox<>();
	        comboBox.setLayoutX(180);
	        comboBox.setLayoutY(80);
	        comboBox.setPrefWidth(180);
	        comboBox.setPrefHeight(20);
	        
	        Label estimated_hrs = new Label("Estimated hours:");
	        estimated_hrs.setFont(new Font("Verdana", 14));
	        estimated_hrs.setTextFill(Color.BLACK);
	        estimated_hrs.setLayoutX(35);
	        estimated_hrs.setLayoutY(130);
	        
	        TextField estimatedField = new TextField();
	        estimatedField.setLayoutX(180);
	        estimatedField.setLayoutY(130);
	        estimatedField.setPrefWidth(180);
	        estimatedField.setPrefHeight(20);
	        
	      //Label for date
	        Label lbldate= new Label(" Appointment Date:");
	        lbldate.setLayoutX(15);
	        lbldate.setLayoutY(175);
	        lbldate.setFont(new Font("Verdana", 15)); 
	        lbldate.setTextFill(Color.BLACK);
	        
	      //TextField for booking date
	        DatePicker datePicker = new DatePicker();
	        datePicker.setLayoutX(180);
	        datePicker.setLayoutY(175);
	        datePicker.setPrefWidth(180);
	        datePicker.setPrefHeight(20);
	        
	      //Label for time
	        Label lbltime = new Label(" Appointment Time:");
	        lbltime.setLayoutX(15);
	        lbltime.setLayoutY(226);
	        lbltime.setFont(new Font("Verdana", 15)); 
	        lbltime.setTextFill(Color.BLACK);
	        
	        TextField timeField = new TextField();
	        timeField.setLayoutX(180);
	        timeField.setLayoutY(226);
	        timeField.setPrefWidth(180);
	        timeField.setPrefHeight(20);
	        
	      //Label for time
	        Label lblprice = new Label("Price:");
	        lblprice.setLayoutX(85);
	        lblprice.setLayoutY(272);
	        lblprice.setFont(new Font("Verdana", 15)); 
	        lblprice.setTextFill(Color.BLACK);
	        
	        TextField totalField = new TextField();
	        totalField.setLayoutX(180);
	        totalField.setLayoutY(272);
	        totalField.setPrefWidth(180);
	        totalField.setPrefHeight(20);
	      
	        Button btnMakeBooking=new Button();
	        btnMakeBooking.setText("Make Apooitment");
	        btnMakeBooking.setLayoutX(180);
	        btnMakeBooking.setLayoutY(320);
	        btnMakeBooking.setPrefWidth(180);
	        btnMakeBooking.setPrefHeight(20);
	        btnMakeBooking.setStyle("-fx-background-color:#285884; -fx-text-fill: white;");
	        
	        btnMakeBooking.setOnAction(event -> {
	            // Check if any of the fields is empty
	            if (comboBox.getValue() == null || estimatedField.getText().isEmpty() || 
	                datePicker.getValue() == null || timeField.getText().isEmpty() || 
	                totalField.getText().isEmpty()) {
	                showAlert("Error", "Please fill in all the fields.");
	            } else {
	                // All fields are filled, proceed to make booking
	                String Service_name = comboBox.getValue();
	                Float estimated_hour = Float.parseFloat(estimatedField.getText());
	                LocalDate datepicker = datePicker.getValue();
	                String Time = timeField.getText();
	                float price = Float.parseFloat(totalField.getText());
	                NewService service = new NewService(0, Service_name, null,0.0);
	                NewBooking person = new NewBooking(0, service, estimated_hour, datepicker, Time, price);

	                boolean res = makeBooking(person); // Call method
	                if (res) {
	                    showAlert("Success", "Booking made successfully!");
	                    ((Stage) btnMakeBooking.getScene().getWindow()).close();
	                    customerDashboard nextcustomerDashboard = new customerDashboard();
	                    try {
	                        nextcustomerDashboard.start(new Stage());
	                    } catch (Exception e) {
	                        e.printStackTrace();
	                    }
	                } else {
	                    showAlert("Error", "Failed to book service.");
	                }
	            }
	        });

	        
		 // Set the scene to the stage
		 Scene scene = new Scene(pane);
			primaryStage.setScene(scene);		
			primaryStage.setTitle("Make Booking");
			primaryStage.setWidth(490);
			primaryStage.setHeight(450);
			primaryStage.setResizable(false);
			
			pane.getChildren().addAll(head,service_name,comboBox,estimated_hrs,estimatedField,lbldate,datePicker,lbltime,timeField,lblprice,totalField,btnMakeBooking);
			primaryStage.show();
			populateServiceComboBox(comboBox);
	 }
	 
	 //To display services in comboBox
	 public void populateServiceComboBox(ComboBox<String> comboBox) {
	        String DRIVER = "com.mysql.cj.jdbc.Driver";
	        String HOST = "localhost";
	        int PORT = 3306;
	        String DATABASE = "assignment";
	        String DBUSER = "root";
	        String DBPASS = "niharika@123";
	        String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;

	        try {
	            Class.forName(DRIVER); //loading driver
	            Connection conn = DriverManager.getConnection(URL, DBUSER, DBPASS);//connection with database server
	            PreparedStatement pstat = conn.prepareStatement("SELECT service_name FROM services");
	            ResultSet rs = pstat.executeQuery();

	            while (rs.next()) {
	                comboBox.getItems().add(rs.getString("service_name"));
	            }

	            pstat.close();
	            conn.close();
	        } catch (Exception ex) {
	            System.out.println("Error : " + ex.getMessage());
	        }
	    }
	 public boolean makeBooking(NewBooking booking) {
		    boolean result = false;
		    String DRIVER = "com.mysql.cj.jdbc.Driver";
		    String HOST = "localhost";
		    int PORT = 3306;
		    String DATABASE = "assignment";
		    String DBUSER = "root";
		    String DBPASS = "niharika@123";
		    String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;
		    String serviceQuery = "SELECT service_id FROM services WHERE service_name = ?";
		    String bookingQuery = "INSERT INTO bookings (service_id, estimated_hour, booking_date, booking_time, price, customer_id) VALUES (?, ?, ?, ?, ?,?)";

		    try {
		        Class.forName(DRIVER); //loading driver
		        Connection conn = DriverManager.getConnection(URL, DBUSER, DBPASS);//connection with database server
		        
		        // Retrieve service_id based on the selected service_name
		        PreparedStatement serviceStatement = conn.prepareStatement(serviceQuery);
		        serviceStatement.setString(1, booking.getServices().getService_name());
		        ResultSet serviceResultSet = serviceStatement.executeQuery();
		        
		        int serviceId = 0;
		        if (serviceResultSet.next()) {
		            serviceId = serviceResultSet.getInt("service_id");
		        }
		        
		        // Insert booking information into bookings table
		        PreparedStatement bookingStatement = conn.prepareStatement(bookingQuery);
		        bookingStatement.setInt(1, serviceId);
		        bookingStatement.setFloat(2, booking.getEstimated_hour());
		        bookingStatement.setDate(3, java.sql.Date.valueOf(booking.getBooking_date()));
		        bookingStatement.setString(4, booking.getBooking_time());
		        bookingStatement.setFloat(5, booking.getPrice());
		        bookingStatement.setFloat(6, customer_id);
//		        bookingStatement.setFloat(7, booking.getTotal_cost());
		        
		        int rowsAffected = bookingStatement.executeUpdate(); //Insert Record
		        if (rowsAffected > 0) {
		            System.out.println("Booking made successfully.");
		            result = true;
		        } else {
		            System.out.println("Failed to make booking.");
		        }
		        
		        // Close resources
		        serviceResultSet.close();
		        serviceStatement.close();
		        bookingStatement.close();
		        conn.close();
		    } catch (Exception ex) {
		        System.out.println("Error : " + ex.getMessage());
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
