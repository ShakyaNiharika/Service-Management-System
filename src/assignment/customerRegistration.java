package assignment;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import assignment.NewCustomer;

import java.time.LocalDate;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class customerRegistration extends Application {
	 @Override
	    public void start(Stage primaryStage) throws Exception {
			//Pane for background color
	        Pane pane = new Pane();
	        pane.setStyle("-fx-background-color: #E6E7E8;");
	        pane.setPrefHeight(1000);
	        pane.setPrefWidth(1000);
	        
	        
	        
	        // Create a Pane for login part
	        Pane sidePane = new Pane();
	        sidePane.setStyle("-fx-background-color: #CBD5E1;");
	        sidePane.setPrefHeight(580);
	        sidePane.setPrefWidth(450);
	        sidePane.setLayoutX(494);
	        sidePane.setLayoutY(30);
	        
	     // Create a Pane for picture part
	        Pane leftPane = new Pane();
	        leftPane.setStyle("-fx-background-color: #FDFEFE;");
	        leftPane.setPrefHeight(580);
	        leftPane.setPrefWidth(450);
	        leftPane.setLayoutX(44);
	        leftPane.setLayoutY(30);

	     // Create an ImageView to display the image
            ImageView profileImageView = new ImageView(new Image(getClass().getResourceAsStream("front.jpg")));
            profileImageView.setFitWidth(310); // Adjust image width as needed
            profileImageView.setFitHeight(300);
            profileImageView.setPreserveRatio(true);
            profileImageView.setLayoutX(70);
            profileImageView.setLayoutY(160);
            
         // Creating a Label
	        Label txtfield = new Label("Service Management System");
	        txtfield.setLayoutX(60);
	        txtfield.setLayoutY(100);
	        txtfield.setFont(new Font("Verdana", 24)); 
	        txtfield.setTextFill(Color.BLACK);
	        
	        //Label for heading
	        Label lblhead = new Label("User Registration for Service Management");
	        lblhead.setLayoutX(20);
	        lblhead.setLayoutY(20);
	        lblhead.setFont(new Font("Verdana", 16)); 
	        lblhead.setTextFill(Color.BLACK);
	        
	        //Label for User_name
	        Label lblusername = new Label("Username");
	        lblusername.setLayoutX(20);
	        lblusername.setLayoutY(60);
	        lblusername.setFont(new Font("bold", 15)); 
	        lblusername.setTextFill(Color.BLACK);
	        
	      //TextField for user_name
	        TextField usernameField = new TextField();
	        usernameField.setLayoutX(150);
	        usernameField.setLayoutY(60);
	        usernameField.setPrefWidth(260);
	        usernameField.setPrefHeight(30);
	        
	        //Label for password
	        Label lblpassword = new Label("Password");
	        lblpassword.setLayoutX(20);
	        lblpassword.setLayoutY(100);
	        lblpassword.setFont(new Font("bold", 15)); 
	        lblpassword.setTextFill(Color.BLACK);
	        
	        //TextField for password
	        TextField passwordField = new TextField();
	        passwordField.setLayoutX(150);
	        passwordField.setLayoutY(100);
	        passwordField.setPrefWidth(260);
	        passwordField.setPrefHeight(30);
	        
	      //Label for Confirmed password
	        Label lblconfirmedpassword = new Label("Verify Password");
	        lblconfirmedpassword.setLayoutX(20);
	        lblconfirmedpassword.setLayoutY(140);
	        lblconfirmedpassword.setFont(new Font("bold", 15)); 
	        lblconfirmedpassword.setTextFill(Color.BLACK);
	        
	        //TextField for Confirmed password
	        TextField confirmedpasswordField = new TextField();
	        confirmedpasswordField.setLayoutX(150);
	        confirmedpasswordField.setLayoutY(140);
	        confirmedpasswordField.setPrefWidth(260);
	        confirmedpasswordField.setPrefHeight(30);
	        
	        //Label for address
	        Label lbladdress = new Label("Address");
	        lbladdress.setLayoutX(20);
	        lbladdress.setLayoutY(180);
	        lbladdress.setFont(new Font("bold", 15)); 
	        lbladdress.setTextFill(Color.BLACK);
	        
	        //TextField for address
	        TextField addressField = new TextField();
	        addressField.setLayoutX(150);
	        addressField.setLayoutY(180);
	        addressField.setPrefWidth(260);
	        addressField.setPrefHeight(30);
	        
	        //Label for phone_number
	        Label lblphone = new Label("Phone Number");
	        lblphone.setLayoutX(20);
	        lblphone.setLayoutY(220);
	        lblphone.setFont(new Font("bold", 15)); 
	        lblphone.setTextFill(Color.BLACK);
	        
	        //TextField for phone_number
	        TextField phoneField = new TextField();
	        phoneField.setLayoutX(150);
	        phoneField.setLayoutY(220);
	        phoneField.setPrefWidth(260);
	        phoneField.setPrefHeight(30);
	        
	        //Label for email_address
	        Label lblemail = new Label("Email Address");
	        lblemail.setLayoutX(20);
	        lblemail.setLayoutY(260);
	        lblemail.setFont(new Font("bold", 15)); 
	        lblemail.setTextFill(Color.BLACK);
	        
	        //TextField for email_address
	        TextField emailField = new TextField();
	        emailField.setLayoutX(150);
	        emailField.setLayoutY(260);
	        emailField.setPrefWidth(260);
	        emailField.setPrefHeight(30);
	        
	        //Label for date_of_birth
	        Label lbldate_of_birth = new Label("Date Of Birth");
	        lbldate_of_birth.setLayoutX(20);
	        lbldate_of_birth.setLayoutY(300);
	        lbldate_of_birth.setFont(new Font("bold", 15)); 
	        lbldate_of_birth.setTextFill(Color.BLACK);
	        
	        //TextField for date_of_birth
	        DatePicker datePicker = new DatePicker();
	        datePicker.setLayoutX(150);
	        datePicker.setLayoutY(300);
	        datePicker.setPrefWidth(260);
	        datePicker.setPrefHeight(30);
	        
	        //Label for gender
	        Label lblgender = new Label("Gender");
	        lblgender.setLayoutX(20);
	        lblgender.setLayoutY(340);
	        lblgender.setFont(new Font("bold", 15)); 
	        lblgender.setTextFill(Color.BLACK);
	        
	        RadioButton r1= new RadioButton("Male");
	        r1.setLayoutX(150);
	        r1.setLayoutY(340);
	        r1.setUserData("Male");
	        
	        RadioButton r2= new RadioButton("Female");
	        r2.setLayoutX(250);
	        r2.setLayoutY(340);
	        r2.setUserData("Female");
	        
	        RadioButton r3= new RadioButton("Others");
	        r3.setLayoutX(350);
	        r3.setLayoutY(340);
	        r3.setUserData("Others");
	        
	        ToggleGroup group=new ToggleGroup();
	        r1.setToggleGroup(group);
	        r2.setToggleGroup(group);
	        r3.setToggleGroup(group);
	        
	        
	        //Signin Button
	        Button btnSignin=new Button();
	        btnSignin.setText("Sign In");
	        btnSignin.setLayoutX(150);
	        btnSignin.setLayoutY(390);
	        btnSignin.setPrefWidth(260);
	        btnSignin.setPrefHeight(30);
	        btnSignin.setStyle("-fx-background-color:#285884; -fx-text-fill: white;");
	        
//	        btnSignin.setOnAction(event -> {
//	            // Open the login page
//	        	firstWindow();
//	        });
	        
	        btnSignin.setOnAction(event -> {
	            String username = usernameField.getText();
	            String password = passwordField.getText();
	            String address = addressField.getText();
	            String phone_number = phoneField.getText();
	            String email_address = emailField.getText();
	            LocalDate date_of_birth = datePicker.getValue();
	            String gender = group.getSelectedToggle().getUserData().toString();

	            // Perform validation
	            if (password.length() < 6) {
	                showAlert("Password Error", "Password must be at least 6 characters long.");
	            } else if (!password.equals(confirmedpasswordField.getText())) {
	                showAlert("Password Error", "Passwords do not match.");
	            } else if (phone_number.length() < 10) {
	                showAlert("Phone Number Error", "Phone number must be at least 10 digits long.");
	            } else if (!email_address.contains("@") || !email_address.contains(".")) {
	                showAlert("Email Address Error", "Invalid email address.");
	            } else {
	                // Call the saveRecord method to insert the record into the database
	                NewCustomer customer = new NewCustomer(0,username, password, address, phone_number, email_address,
	                        date_of_birth, gender);
	                boolean isSuccess = saveRecord(customer);

	                // Check if the record was successfully inserted
	                if (isSuccess) {
	                    showAlert("Success", "Registered successfully!");
	                    firstWindow  nextGUI= new firstWindow();
	    	        	try {
	    					nextGUI.start(new Stage());
	    				} catch (Exception e) {
	    					// TODO Auto-generated catch block
	    					e.printStackTrace();
	    				}
	                } else {
	                    showAlert("Error", "Failed to insert record!");
	                }
	            }
	        });
	        

	        
       
	        sidePane.getChildren().addAll(lblhead,lblusername,usernameField,lblpassword,passwordField,lblconfirmedpassword,confirmedpasswordField,lbladdress,addressField,lblphone,phoneField,lblemail,emailField,lbldate_of_birth,datePicker,lblgender,r1,r2,r3,btnSignin);
	        leftPane.getChildren().addAll(profileImageView,txtfield);
	        
	        Pane rootPane = new Pane(pane, sidePane,leftPane);
	        Scene scene = new Scene(rootPane);
	        primaryStage.setTitle("MyWindow");
	        primaryStage.setWidth(1000);
	        primaryStage.setHeight(680);
	        primaryStage.setX(100);
	        primaryStage.setY(20);
	        primaryStage.setScene(scene);
	        primaryStage.show();
	 }
	 private void showAlert(String title, String content) {
	        Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle(title);
	        alert.setHeaderText(null);
	        alert.setContentText(content);
	        alert.showAndWait();
	    }
	 public boolean saveRecord(NewCustomer person) {
			//pid, fullName, address, gender, ageGroup, reading, playing, other, login_id, pass_word
			boolean result = false;
			String DRIVER ="com.mysql.cj.jdbc.Driver";
			String HOST ="localhost";
			int PORT=3306;
			String DATABASE ="assignment";
			String DBUSER="root";
			String DBPASS="niharika@123";
			String URL = "jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE;
			String sql = "INSERT INTO customers (username, pass_word, address, phone_number, email_address, date_of_birth, gender) VALUES (?, ?, ?, ?, ?, ?, ?)";

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
				
				int rowsAffected = pstat.executeUpdate();//Insert Record
				 if (rowsAffected > 0) {
			            System.out.println("Record inserted successfully.");
			            result = true;
			        } else {
			            System.out.println("Failed to insert record.");
			        }
				 pstat.close();
					conn.close();
			    } 
				
			
			catch(Exception ex) {
				System.out.println("Error : "+ex.getMessage());
			}
			return result;
		}
	 public static void main(String[] args) {
	        launch(args);
	    }
}
