package assignment;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import assignment.NewCustomer;
import javafx.scene.control.Alert;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import assignment.NewCustomer;

public class adminDashboard extends Application {
	@Override
	public void start(Stage PrimaryStage ) throws Exception {
		// TODO Auto-generated method stub
		//Pane for background color
        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: #E6E7E8;");
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
        Label head = new Label("Admin Dashboard");
        head.setFont(new Font("Verdana", 28));
        head.setTextFill(Color.BLACK);
        head.setLayoutX(40);
        head.setLayoutY(22);
        
      
        Button addServices=new Button();
        addServices.setText("Add Services");
        addServices.setFont(new Font("Verdana", 20));
        addServices.setTextFill(Color.BLACK);
        addServices.setLayoutX(50);
        addServices.setLayoutY(210);
        addServices.setStyle("-fx-background-color:#CBD5E1; -fx-text-fill: black;");
        
        addServices.setOnAction(event -> {
            // Open the Update profile page

        	((Stage) addServices.getScene().getWindow()).close();
            adminDashboard nextdashboard = new adminDashboard();
            try {
            	nextdashboard.start(new Stage());
            } catch (Exception e) {
                e.printStackTrace();
            }});
        
        Button manageServices=new Button();
        manageServices.setText("Manage Services");
        manageServices.setFont(new Font("Verdana", 20));
        manageServices.setTextFill(Color.BLACK);
        manageServices.setLayoutX(50);
        manageServices.setLayoutY(260);
        manageServices.setStyle("-fx-background-color:#CBD5E1; -fx-text-fill: black;");
       
      //Navigate to login page
        manageServices.setOnAction(event -> {
            // Open the Update profile page

        	((Stage) manageServices.getScene().getWindow()).close();
            manageService nextManageCustomer = new manageService();
            try {
            	nextManageCustomer.start(new Stage());
            } catch (Exception e) {
                e.printStackTrace();
            }});
       
	    Button assignCustomer=new Button();
	    assignCustomer.setText("View Customers");
	    assignCustomer.setFont(new Font("Verdana", 18));
	    assignCustomer.setTextFill(Color.BLACK);
	    assignCustomer.setLayoutX(50);
	    assignCustomer.setLayoutY(310);
	    assignCustomer.setStyle("-fx-background-color:#CBD5E1; -fx-text-fill: black;");
	    
	    assignCustomer.setOnAction(event -> {
            // Open the Update profile page

        	((Stage) assignCustomer.getScene().getWindow()).close();
             adminViewCustomer nextAssignCustomer = new adminViewCustomer();
            try {
            	nextAssignCustomer.start(new Stage());
            } catch (Exception e) {
                e.printStackTrace();
            }});
//        
	    Button btnviewStaff=new Button();
        btnviewStaff.setText("View Staff");
        btnviewStaff.setFont(new Font("Verdana", 18));
        btnviewStaff.setTextFill(Color.BLACK);
        btnviewStaff.setLayoutX(50);
        btnviewStaff.setLayoutY(360);
        btnviewStaff.setStyle("-fx-background-color:#CBD5E1; -fx-text-fill: black;");
//       
      //Navigate to view staff
        btnviewStaff.setOnAction(event -> {
            // Open the Update profile page

        	((Stage) btnviewStaff.getScene().getWindow()).close();
            viewStaff nextViewStaff = new viewStaff();
            try {
            	nextViewStaff.start(new Stage());
            } catch (Exception e) {
                e.printStackTrace();
            }});
//       //Button for the sideBar
        Button report=new Button();
        report.setText("Report");
        report.setFont(new Font("Verdana", 18));
        report.setTextFill(Color.BLACK);
        report.setLayoutX(50);
        report.setLayoutY(410);
        report.setStyle("-fx-background-color:#CBD5E1; -fx-text-fill: black;");
       
        //Navigate to view staff
        report.setOnAction(event -> {
            // Open the Update profile page

        	((Stage) report.getScene().getWindow()).close();
            Total_cost nextreport = new Total_cost();
            try {
            	nextreport.start(new Stage());
            } catch (Exception e) {
                e.printStackTrace();
            }});
        
        //Button for logout
        Button btnLogout=new Button();
        btnLogout.setText("Logout");
        btnLogout.setFont(new Font("Verdana", 20));
//        btnLogout.setLayoutX(1);
        btnLogout.setLayoutY(560);
        btnLogout.setPrefWidth(260);
        btnLogout.setPrefHeight(60);
        btnLogout.setStyle("-fx-background-color:#CBD5E1; -fx-text-fill: black;");
        
      //Navigate to login pagelogoutpage
        btnLogout.setOnAction(event -> {
        	((Stage) btnLogout.getScene().getWindow()).close();
            staffLogin nextLoginPage = new staffLogin();
            try {
            	nextLoginPage.start(new Stage());
            } catch (Exception e) {
                e.printStackTrace();
        }});
        
       
        //Main content
        Label HeadAddService = new Label("Add Services");
        HeadAddService.setLayoutX(360);
        HeadAddService.setLayoutY(52);
        HeadAddService.setFont(new Font("Verdana", 24)); 
        HeadAddService.setTextFill(Color.BLACK);
        
     // Create an ImageView to display the image
        ImageView addServiceImageView = new ImageView(new Image(getClass().getResourceAsStream("addService.jpg")));
        addServiceImageView.setFitWidth(280); // Adjust image width as needed
        addServiceImageView.setFitHeight(200);
        addServiceImageView.setPreserveRatio(true);
        addServiceImageView.setLayoutX(800);
        addServiceImageView.setLayoutY(140);
        
        //Add services
        Label service_name = new Label("Service Name:");
        service_name.setFont(new Font("Verdana", 16));
        service_name.setTextFill(Color.BLACK);
        service_name.setLayoutX(380);
        service_name.setLayoutY(120);
        
        TextField serviceField = new TextField();
        serviceField.setLayoutX(520);
        serviceField.setLayoutY(115);
        serviceField.setPrefWidth(220);
        serviceField.setPrefHeight(34);
        
        Label description= new Label("Description:");
        description.setFont(new Font("Verdana", 16));
        description.setTextFill(Color.BLACK);
        description.setLayoutX(380);
        description.setLayoutY(178);
        
        TextField descriptionField = new TextField();
        descriptionField.setLayoutX(520);
        descriptionField.setLayoutY(178);
        descriptionField.setPrefWidth(220);
        descriptionField.setPrefHeight(80);
        
      //Label for date_of_birth
        Label lblPrice = new Label("Price:");
        lblPrice.setLayoutX(380);
        lblPrice.setLayoutY(280);
        lblPrice.setFont(new Font("Verdana", 18)); 
        
        TextField PriceField = new TextField();
        PriceField.setLayoutX(520);
        PriceField.setLayoutY(280);
        PriceField.setPrefWidth(220);
        PriceField.setPrefHeight(34);
       
        Button btnAddServices=new Button();
        btnAddServices.setText("Add Services");
        btnAddServices.setLayoutX(520);
        btnAddServices.setLayoutY(340);
        btnAddServices.setPrefWidth(220);
        btnAddServices.setPrefHeight(30);
        btnAddServices.setStyle("-fx-background-color:#285884; -fx-text-fill: white;");
        
        btnAddServices.setOnAction(event -> {
            String Service_name = serviceField.getText();
            String Description = descriptionField.getText();
            String price = PriceField.getText();
            
            NewService person = new NewService(0, Service_name, Description, Double.parseDouble(price));
			
			boolean res = insertRecord(person); //call method
			if(res) {
				showAlert("Success", "Service added successfully!");
			}
			else {
				showAlert("Error", "Failed to add service.");
			}
            
        });
        headerPane.getChildren().addAll(head);
        sidePane.getChildren().addAll(addServices,user,manageServices,assignCustomer,btnviewStaff,
        		report,btnLogout,HeadAddService,addServiceImageView,service_name,serviceField,description,descriptionField,lblPrice,PriceField,btnAddServices);
//        pane.getChildren().add(table1);
        Pane rootPane = new Pane(pane,headerPane, sidePane);
        // Create a Scene with the root Pane
        Scene scene = new Scene(rootPane);
        
        
        
        PrimaryStage.setTitle("MyWindow");
        PrimaryStage.setWidth(1100);
        PrimaryStage.setHeight(730);
        PrimaryStage.setX(100);
        PrimaryStage.setY(20);
        PrimaryStage.setScene(scene);
        PrimaryStage.show();
	}
	public boolean insertRecord(NewService person) {
		//pid, fullName, address, gender, ageGroup, reading, playing, other, login_id, pass_word
		boolean result = false;
		String DRIVER ="com.mysql.cj.jdbc.Driver";
		String HOST ="localhost";
		int PORT=3306;
		String DATABASE ="assignment";
		String DBUSER="root";
		String DBPASS="niharika@123";
		String URL = "jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE;
		String sql = "INSERT INTO services (service_name, description, price) VALUES (?, ?, ?)";


		try {
			Class.forName(DRIVER); //loading driver
			Connection conn = DriverManager.getConnection(URL, DBUSER, DBPASS);//connection with database server
			PreparedStatement pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, person.getService_name());
			pstat.setString(2, person.getDescription());
			pstat.setDouble(3, person.getPrice());
			
			
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

