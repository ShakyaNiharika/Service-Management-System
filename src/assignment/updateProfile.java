package assignment;

import assignment.Gvar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import assignment.NewCustomer;

public class updateProfile extends Application {
	
	int customer_id=Gvar.id;
	
	  @Override
	    public void start(Stage primaryStage) {
		//Pane for background color
	        Pane pane = new Pane();
//	        pane.setStyle("-fx-background-color: #F3D5F6;");
	        pane.setPrefHeight(1000);
	        pane.setPrefWidth(1180);
	        
	        // Create a Pane for the header section
	        Pane headerPane = new Pane();
	        headerPane.setStyle("-fx-background-color: #CBD5E1;");
	        headerPane.setPrefHeight(90);
	        headerPane.setPrefWidth(1100);
	        
	        // Create a Pane for the content section
	        Pane sidePane = new Pane();
	        sidePane.setStyle("-fx-background-color: #CBD5E1;");
	        sidePane.setPrefHeight(620);
	        sidePane.setPrefWidth(278);
	        sidePane.setLayoutY(80);

	        ImageView user = new ImageView(new Image(getClass().getResourceAsStream("userphoto.jpg")));
	        user.setFitWidth(180); // Adjust image width as needed
	        user.setFitHeight(140);
	        user.setPreserveRatio(true);
	        user.setLayoutX(40);
	        user.setLayoutY(50);
	        // Create a Label for the header
	        Label head = new Label("Welcome To Service Management System");
	        head.setFont(new Font("Verdana", 24));
	        head.setTextFill(Color.BLACK);
	        head.setLayoutX(20);
	        head.setLayoutY(22);
	        
	        Label userName = new Label("Username: Reshma");
	        userName.setFont(new Font("Verdana", 24));
	        userName.setTextFill(Color.BLACK);
	        userName.setLayoutX(790);
	        userName.setLayoutY(22);
	        
	       
	        Button dashboard=new Button();
	        dashboard.setText("Dashboard");
	        dashboard.setFont(new Font("Verdana", 18));
	        dashboard.setTextFill(Color.BLACK);
	        dashboard.setLayoutX(60);
	        dashboard.setLayoutY(210);
	        dashboard.setStyle("-fx-background-color:#CBD5E1; -fx-text-fill: black;");
	        
	        dashboard.setOnAction(event -> {
	            // Open the dashboard page
	        	((Stage) dashboard.getScene().getWindow()).close();
	            customerDashboard nextdashboard = new customerDashboard();
	            try {
	            	nextdashboard.start(new Stage());
	            } catch (Exception e) {
	                e.printStackTrace();
	            }});
	       
	        //Button for the My Profile
		    Button profile=new Button();
	        profile.setText("My Profile");
	        profile.setFont(new Font("Verdana", 18));
	        profile.setTextFill(Color.BLACK);
	        profile.setLayoutX(60);
	        profile.setLayoutY(260);
	        profile.setStyle("-fx-background-color:#CBD5E1; -fx-text-fill: black;");
	       
	        
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
	            customer_history nexthistory = new customer_history();
	            try {
	            	nexthistory.start(new Stage());
	            } catch (Exception e) {
	                e.printStackTrace();
	            }});
	       

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
//	       
	        
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
	            // Open the login page
	        	((Stage) btnLogout.getScene().getWindow()).close();
	            firstWindow nextloginPage = new firstWindow();
	            try {
	            	nextloginPage.start(new Stage());
	            } catch (Exception e) {
	                e.printStackTrace();
	            }});
	        
	        //Main Content
	        Label my_profile = new Label("My Profile");
	        my_profile.setFont(new Font("Verdana", 24));
	        my_profile.setTextFill(Color.BLACK);
	        my_profile.setLayoutX(320);
	        my_profile.setLayoutY(60);
	        
	       
	        //Label for User_name
	        Label lblusername = new Label("Username");
	        lblusername.setLayoutX(350);
	        lblusername.setLayoutY(126);
	        lblusername.setFont(new Font("bold", 15)); 
	        lblusername.setTextFill(Color.BLACK);
	        
	      //TextField for user_name
	        TextField usernameField = new TextField();
	        usernameField.setLayoutX(460);
	        usernameField.setLayoutY(126);
	        usernameField.setPrefWidth(260);
	        usernameField.setPrefHeight(30);
	        
	      //Label for password
	        Label lblpassword = new Label("Password");
	        lblpassword.setLayoutX(360);
	        lblpassword.setLayoutY(180);
	        lblpassword.setFont(new Font("bold", 15)); 
	        lblpassword.setTextFill(Color.BLACK);
	        
	        //TextField for password
	        TextField passwordField = new TextField();
	        passwordField.setLayoutX(460);
	        passwordField.setLayoutY(180);
	        passwordField.setPrefWidth(260);
	        passwordField.setPrefHeight(30);
	        
	        //Label for address
	        Label lbladdress = new Label("Address");
	        lbladdress.setLayoutX(360);
	        lbladdress.setLayoutY(238);
	        lbladdress.setFont(new Font("bold", 15)); 
	        lbladdress.setTextFill(Color.BLACK);
	        
	        //TextField for address
	        TextField addressField = new TextField();
	        addressField.setLayoutX(460);
	        addressField.setLayoutY(238);
	        addressField.setPrefWidth(260);
	        addressField.setPrefHeight(30);
	        
	        //Label for phone_number
	        Label lblphone = new Label("Phone Number");
	        lblphone.setLayoutX(330);
	        lblphone.setLayoutY(296);
	        lblphone.setFont(new Font("bold", 15)); 
	        lblphone.setTextFill(Color.BLACK);
	        
	        //TextField for phone_number
	        TextField phoneField = new TextField();
	        phoneField.setLayoutX(460);
	        phoneField.setLayoutY(296);
	        phoneField.setPrefWidth(260);
	        phoneField.setPrefHeight(30);
	        
	        //Label for email_address
	        Label lblemail = new Label("Email Address");
	        lblemail.setLayoutX(330);
	        lblemail.setLayoutY(360);
	        lblemail.setFont(new Font("bold", 15)); 
	        lblemail.setTextFill(Color.BLACK);
	        
	        //TextField for email_address
	        TextField emailField = new TextField();
	        emailField.setLayoutX(460);
	        emailField.setLayoutY(360);
	        emailField.setPrefWidth(260);
	        emailField.setPrefHeight(30);
	        
	        Label lbldate_of_birth = new Label("Date Of Birth");
	        lbldate_of_birth.setLayoutX(330);
	        lbldate_of_birth.setLayoutY(418);
	        lbldate_of_birth.setFont(new Font("bold", 15)); 
	        lbldate_of_birth.setTextFill(Color.BLACK);
	        
	        //TextField for date_of_birth
	        DatePicker datePicker = new DatePicker();
	        datePicker.setLayoutX(460);
	        datePicker.setLayoutY(418);
	        datePicker.setPrefWidth(260);
	        datePicker.setPrefHeight(30);
	        
	      //Label for gender
	        Label lblgender = new Label("Gender");
	        lblgender.setLayoutX(360);
	        lblgender.setLayoutY(480);
	        lblgender.setFont(new Font("bold", 15)); 
	        lblgender.setTextFill(Color.BLACK);
	        
	        RadioButton r1= new RadioButton("Male");
	        r1.setLayoutX(460);
	        r1.setLayoutY(480);
	        RadioButton r2= new RadioButton("Female");
	        r2.setLayoutX(540);
	        r2.setLayoutY(480);
	        RadioButton r3= new RadioButton("Others");
	        r3.setLayoutX(630);
	        r3.setLayoutY(480);
	        
	        ToggleGroup group=new ToggleGroup();
	        r1.setToggleGroup(group);
	        r2.setToggleGroup(group);
	        r3.setToggleGroup(group);
	        
	        Button btnUpdate=new Button();
	        btnUpdate.setText("Update");
	        btnUpdate.setLayoutX(460);
	        btnUpdate.setLayoutY(520);
	        btnUpdate.setPrefWidth(260);
	        btnUpdate.setPrefHeight(30);
	        btnUpdate.setStyle("-fx-background-color:#285884; -fx-text-fill: white;");
	        
	        btnUpdate.setOnAction(event -> {
	        	
	            // Create a new NewCustomer object with the data entered by the user
	                 // Set customer_id to 0 or any default value, as it might be auto-generated by the database
	        
	        	String username = usernameField.getText(); 
	        	String pass_word = passwordField.getText();
                String address=addressField.getText(); 
                String phone_number=phoneField.getText(); 
                String email_address=emailField.getText(); 
                LocalDate date_of_birth=datePicker.getValue(); 
	                String gender="Other";
	                if(r1.isSelected()==true) {
	    				gender="Male";
	    			}
	                else if(r2.isSelected()==true) {
	                	gender="Female";
	                }
	                else {
	                	gender="Other";
	                }
	            
	            // Call the updateRecord method to insert the record into the database
	                NewCustomer person=new NewCustomer(username,pass_word,address,phone_number,email_address,date_of_birth,gender);
	                boolean isSuccess = updateRecord(person);
	            // Check if the record was successfully inserted
	            if (isSuccess) {
	                // Show a success message or perform any other actions
	            	showAlert("Success","Profile updated successfully!");
	                System.out.println("Record updated successfully!");
	            } else {
	                // Show an error message or perform any other actions
	            	showAlert("Error","Failed to update record!");
	                System.out.println("Failed to update record!");
	            }
	        });
	        
	                // Customer ID is entered, proceed with search
	                
	                NewCustomer person = searchRecord(customer_id);
	                if (person != null) {
	                    // Display all values
	                    usernameField.setText(person.getUsername());
	                    passwordField.setText(person.getPass_word());
	                    addressField.setText(person.getAddress());
	                    phoneField.setText(person.getPhone_number());
	                    emailField.setText(person.getEmail_address());
	                    datePicker.setValue(person.getDate_of_birth());

	                    // Gender
	                    if (person.getGender().equals("Male")) {
	                        r1.setSelected(true);
	                    } else {
	                        r2.setSelected(true);
	                    }

	                    
	                } 
	             // Create an ImageView to display the image
	                ImageView profileImageView = new ImageView(new Image(getClass().getResourceAsStream("profilee.jpg")));
	                profileImageView.setFitWidth(280); // Adjust image width as needed
	                profileImageView.setFitHeight(200);
	                profileImageView.setPreserveRatio(true);
	                profileImageView.setLayoutX(800);
	                profileImageView.setLayoutY(140);
	        // Add the Label to the headerPane
	        headerPane.getChildren().addAll(head,userName);
	        sidePane.getChildren().addAll(dashboard,user,profile,appointment,reschedule,
	        		btnLogout,my_profile,lblusername,usernameField,lblpassword,passwordField,lbladdress,addressField,
	        		lbldate_of_birth,datePicker,lblphone,phoneField,lblemail,emailField,lblgender,r1,r2,r3,btnUpdate,profileImageView);

	        // Add the headerPane and contentPane to a VBox
	        // VBox rootPane = new VBox(headerPane, contentPane);

	        // Or, you can use a Pane directly if you don't need vertical stacking
	        Pane rootPane = new Pane(pane,headerPane, sidePane);

	        // Create a Scene with the root Pane
	        Scene scene = new Scene(rootPane);

	        // Set the scene to the stage
	        primaryStage.setTitle("MyWindow");
	        primaryStage.setWidth(1100);
	        primaryStage.setHeight(730);
	        primaryStage.setX(100);
	        primaryStage.setY(20);
	        primaryStage.setScene(scene);
	        primaryStage.show();
	    }
	  public boolean updateRecord(NewCustomer person) {
			//pid, fullName, updateRecordaddress, gender, ageGroup, reading, playing, other, login_id, pass_word
			boolean result = false;
			String DRIVER ="com.mysql.cj.jdbc.Driver";
			String HOST ="localhost";
			int PORT=3306;
			String DATABASE ="assignment";
			String DBUSER="root";
			String DBPASS="niharika@123";
			String URL = "jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE;
			String sql="UPDATE customers  SET username=?,pass_word=?, address=?, phone_number=?, email_address=?,date_of_birth=?, gender=? WHERE customer_id=?";
			try {
				Class.forName(DRIVER); //loading driver
				Connection conn = DriverManager.getConnection(URL, DBUSER, DBPASS);//connection with database server
				PreparedStatement pstat = conn.prepareStatement(sql);			
				pstat.setString(1, person.getUsername());
				pstat.setString(2, person.getPass_word());
				pstat.setString(3, person.getAddress());
				pstat.setString(4, person.getPhone_number());
				pstat.setString(5, person.getEmail_address());
				pstat.setDate(6, java.sql.Date.valueOf(person.getDate_of_birth()));
				pstat.setString(7, person.getGender());
				pstat.setInt(8, person.getCustomer_id());
				
				int rowsUpdated = pstat.executeUpdate(); // Update Record
		        if (rowsUpdated > 0) {
		            result = true;
		        }
				pstat.close();
				conn.close();
				result=true;
			}
			catch(Exception ex) {
				System.out.println("Error : "+ex.getMessage());
			}
			return result;
		}
	  
	  public NewCustomer searchRecord(int customer_id) {
			//pid, fullName, address, gender, ageGroup, reading, playing, other, login_id, pass_word
			NewCustomer person = null;
			String DRIVER ="com.mysql.cj.jdbc.Driver";
			String HOST ="localhost";
			int PORT=3306;
			String DATABASE ="assignment";
			String DBUSER="root";
			String DBPASS="niharika@123";
			String URL = "jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE;
			String sql="SELECT * FROM customers WHERE customer_id=?";
			try {
				Class.forName(DRIVER); //loading driver
				Connection conn = DriverManager.getConnection(URL, DBUSER, DBPASS);//connection with database server
				PreparedStatement pstat = conn.prepareStatement(sql);
				pstat.setInt(1, customer_id);			
				ResultSet rs = pstat.executeQuery();
				while(rs.next()) {
					String username = rs.getString("username");
					String password = rs.getString("pass_word");
					String address = rs.getString("address");
					String phone_number=rs.getString("phone_number");
					String email_address = rs.getString("email_address");
					String dateOfBirthStr = rs.getString("date_of_birth");
					LocalDate date_of_birth = LocalDate.parse(dateOfBirthStr);
					String gender = rs.getString("gender");
					person = new NewCustomer(customer_id, username, password, address, phone_number, email_address, date_of_birth, gender);				
				}
				pstat.close();
				conn.close();			
			}
			catch(Exception ex) {
				System.out.println("Error : "+ex.getMessage());
			}
			return person;
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

