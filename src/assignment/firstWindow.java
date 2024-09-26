package assignment;

import assignment.Gvar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.layout.Pane;
//import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;

public class firstWindow extends Application {

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
            profileImageView.setFitWidth(340); // Adjust image width as needed
            profileImageView.setFitHeight(330);
            profileImageView.setPreserveRatio(true);
            profileImageView.setLayoutX(65);
            profileImageView.setLayoutY(160);
            
         // Creating a Label
	        Label txtfield = new Label("Service Management System");
	        txtfield.setLayoutX(60);
	        txtfield.setLayoutY(100);
	        txtfield.setFont(new Font("Verdana", 24)); 
	        txtfield.setTextFill(Color.BLACK);
            
	        // Create an ImageView to display the image
	        ImageView signInImageView = new ImageView(new Image(getClass().getResourceAsStream("logo.jpg")));
	        signInImageView.setFitWidth(70); // Adjust image width as needed
	        signInImageView.setFitHeight(80);
	        signInImageView.setPreserveRatio(true);
	        signInImageView.setLayoutX(175);
	        signInImageView.setLayoutY(40);
	        
	        // Creating a Label
	        Label lbllogin = new Label("Login");
	        lbllogin.setLayoutX(180);
	        lbllogin.setLayoutY(120);
	        lbllogin.setFont(new Font("Verdana", 24)); 
	        lbllogin.setTextFill(Color.BLACK);
	        
	        ComboBox cmbType=new ComboBox();
	        cmbType.setLayoutX(265);
	        cmbType.setLayoutY(200);
			List lstType = new ArrayList();
			lstType.add("Customer"); 
			lstType.add("Staff"); 
			lstType.add("Admin"); 
			cmbType.getItems().addAll(lstType);
			cmbType.setPromptText("Choose the user");
			
			cmbType.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
			    if (newVal != null) {
			    	switch (newVal.toString()) {
			            case "Customer":
			            	 firstWindow nextGUI = new firstWindow();
				                try {
				                    nextGUI.start(new Stage());
				                } catch (Exception e) {
				                    e.printStackTrace();
				                }
			                break;
			            case "Staff":
			            	 staffLogin loginforstaff = new staffLogin();
			            	 Stage currentStage = (Stage) cmbType.getScene().getWindow();
				                try {
				                	loginforstaff.start(new Stage());
				                	currentStage.close();
				                } catch (Exception e) {
				                    e.printStackTrace();
				                }
			                break;
			            case "Admin":
			            	 adminLogin loginforadmin = new adminLogin();
			            	 Stage CurrentStage = (Stage) cmbType.getScene().getWindow();
				                try {
				                	loginforadmin.start(new Stage());
				                	CurrentStage.close();
				                } catch (Exception e) {
				                    e.printStackTrace();
				                }
			                break;
			            default:
			                break;
			        }
			    }
			});

			
	        //Creating Email
	        Label lblemail = new Label("Email:");
	        lblemail.setLayoutX(58);
	        lblemail.setLayoutY(200);
	        lblemail.setFont(new Font(20)); 
	        lblemail.setTextFill(Color.BLACK);
	        
	        //label for Password
	        Label lblpassword = new Label("Password:");
	        lblpassword.setLayoutX(58);
	        lblpassword.setLayoutY(290);
	        lblpassword.setFont(new Font(20)); 
	        lblpassword.setTextFill(Color.BLACK);

	        
	        //Text_field for email
	        TextField emailField = new TextField();
	        emailField.setLayoutX(56);
	        emailField.setLayoutY(240);
	        emailField.setPrefWidth(340);
	        emailField.setPrefHeight(40);
	        
	      //Text_field for password
	        TextField passwordField = new PasswordField();
	        passwordField.setLayoutX(56);
	        passwordField.setLayoutY(330);
	        passwordField.setPrefWidth(340);
	        passwordField.setPrefHeight(40);
	        
	      //Show password
	        CheckBox lblshow = new CheckBox("Show Password:");
	        lblshow.setLayoutX(270);
	        lblshow.setLayoutY(382);
	        lblshow.setStyle("-fx-font-size: 12px;");	       
	        lblshow.setTextFill(Color.BLACK);
	        lblshow.setOnAction(event -> {
	            if (lblshow.isSelected()) {
	                // Show password
	                passwordField.setPromptText(passwordField.getText());
	                passwordField.setText("");
	            } else {
	                // Hide password
	                passwordField.setText(passwordField.getPromptText());
	                passwordField.setPromptText("*");
	            }
	        });

	        
	        Button btnCus=new Button();
	        btnCus.setText("Log in as Customer");
	        btnCus.setLayoutX(56);
	        btnCus.setLayoutY(410);
	        btnCus.setPrefWidth(340);
	        btnCus.setPrefHeight(40);
	        btnCus.setStyle("-fx-background-color:#285884; -fx-text-fill: white;");
	        
	        btnCus.setOnAction(event -> {
	        	
	            String email_address = emailField.getText(); // Get the email address from the text field
	            String password = passwordField.getText(); // Get the password from the text field
	            
	            
	            int isSuccess = loginUser(email_address, password);
//	            Object user=loginUser( email_address,  password);
	            if (isSuccess>0) {
//	            	
	            	 showAlert("Success", "Login Successful");
	            	Gvar.id=isSuccess;
	                customerDashboard nextGUI = new customerDashboard();
	                try {
	                    nextGUI.start(new Stage());
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            } else {
	                // Show an error message using an Alert dialog
	                Alert alert = new Alert(Alert.AlertType.ERROR);
	                alert.setTitle("Login Failed");
	                alert.setHeaderText("Invalid Email or Password");
	                alert.setContentText("Please enter a valid email and password.");
	                alert.showAndWait();
	            }
	        });
	        //forget password
	        Label lblforget = new Label("Forget Password ?");
	        lblforget.setLayoutX(180);
	        lblforget.setLayoutY(475);
	        lblforget.setFont(new Font(13)); 
	        lblforget.setTextFill(Color.BLACK);
	        
	        //Button to create account
	        Button btnCreateRegis=new Button();
	        btnCreateRegis.setText("Create Account");
	        btnCreateRegis.setLayoutX(174);
	        btnCreateRegis.setLayoutY(510);
	        btnCreateRegis.setPrefWidth(120);
	        btnCreateRegis.setPrefHeight(30);
	        btnCreateRegis.setStyle("-fx-background-color:#CBD5E1; -fx-text-fill: #285884;");
	        
	        btnCreateRegis.setOnAction(event -> {
	            // Open the login page
	        	customerRegistration  nextGUI= new customerRegistration();
	        	try {
					nextGUI.start(new Stage());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        });
	        // Adding the Label and TextField to the Group

	        sidePane.getChildren().addAll(signInImageView,lbllogin,cmbType,lblemail, lblpassword, emailField, passwordField, btnCus,lblshow,lblforget,btnCreateRegis);
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
	  public int loginUser(String email, String password) {
			//pid, fullName, address, gender, ageGroup, reading, playing, other, login_id, pass_word
			int result = 0;
			String DRIVER ="com.mysql.cj.jdbc.Driver";
			String HOST ="localhost";
			int PORT=3306;
			String DATABASE ="assignment";
			String DBUSER="root";
			String DBPASS="niharika@123";
			String URL = "jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE;
			String sql="SELECT * FROM customers where email_address=? and pass_word=?";

			System.out.println(sql);
			try {
				Class.forName(DRIVER); //loading driver
				Connection conn = DriverManager.getConnection(URL, DBUSER, DBPASS);//connection with database server
				PreparedStatement pstat = conn.prepareStatement(sql);
				pstat.setString(1,email );
				pstat.setString(2, password);
				ResultSet rs = pstat.executeQuery();//Insert Record
				while(rs.next()) {
					int cid=rs.getInt("Customer_id");
					System.out.print(cid);
					result=cid;
				}
				pstat.close();
				conn.close();			
			}
			catch(Exception ex) {
				System.out.println("Error : "+ex.getMessage());
			}
			return result;
		};
		
	
		 private void showAlert(String title, String content) {
		        Alert alert = new Alert(AlertType.INFORMATION);
		        alert.setTitle(title);
		        alert.setHeaderText(null);
		        alert.setContentText(content);
		        alert.showAndWait();
		    }


    public static void main(String[] args) {
        launch(args);
    }
}
