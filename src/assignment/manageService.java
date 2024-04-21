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

public class manageService extends Application {
	@Override
	public void start(Stage PrimaryStage ) throws Exception {
		// TODO Auto-generated method stub
		//Pane for background color
        Pane pane = new Pane();
//        pane.setStyle("-fx-background-color: #F3D5F6;");
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
        head.setFont(new Font("Verdana", 24));
        head.setTextFill(Color.BLACK);
        head.setLayoutX(20);
        head.setLayoutY(22);
        
        //image of dashboard
        ImageView homeimg = new ImageView(new Image(getClass().getResourceAsStream("home.png")));
        homeimg.setFitWidth(80); // Adjust image width as needed
        homeimg.setFitHeight(80);
        homeimg.setPreserveRatio(true);
        homeimg.setLayoutX(15);
        homeimg.setLayoutY(182);
        
        Button addServices=new Button();
        addServices.setText("Add Services");
        addServices.setFont(new Font("Verdana", 20));
        addServices.setTextFill(Color.BLACK);
        addServices.setLayoutX(50);
        addServices.setLayoutY(210);
        addServices.setStyle("-fx-background-color:#CBD5E1; -fx-text-fill: black;");
        
        addServices.setOnAction(event -> {
	    	adminDashboard nextmanageServices = new adminDashboard();
            try {
            	((Stage) addServices.getScene().getWindow()).close();
            	nextmanageServices.start(new Stage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        
        Button manageServices=new Button();
        manageServices.setText("Manage Services");
        manageServices.setFont(new Font("Verdana", 20));
        manageServices.setTextFill(Color.BLACK);
        manageServices.setLayoutX(50);
        manageServices.setLayoutY(260);
        manageServices.setStyle("-fx-background-color:#CBD5E1; -fx-text-fill: black;");
       
      //When Manage Services is clicked
        manageServices.setOnAction(event -> {
	    	manageService nextmanageServices = new manageService();
            try {
            	((Stage) manageServices.getScene().getWindow()).close();
            	nextmanageServices.start(new Stage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
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
        
//        //Button for the My Profile
//	    Button btnadd=new Button();
//	    btnadd.setText("Add Customer");
//	    btnadd.setFont(new Font("Verdana", 18));
//	    btnadd.setTextFill(Color.BLACK);
//	    btnadd.setLayoutX(50);
//	    btnadd.setLayoutY(260);
//	    btnadd.setStyle("-fx-background-color:#CBD5E1; -fx-text-fill: black;");
//	    
//	    //When Add Customer is clicked
//	    btnadd.setOnAction(event -> {
//	    	addCustomer nextGUI = new addCustomer();
//            try {
//            	((Stage) btnadd.getScene().getWindow()).close();
//                nextGUI.start(new Stage());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
//	    
//	    Button assignCustomer=new Button();
//	    assignCustomer.setText("Assign customers");
//	    assignCustomer.setFont(new Font("Verdana", 18));
//	    assignCustomer.setTextFill(Color.BLACK);
//	    assignCustomer.setLayoutX(50);
//	    assignCustomer.setLayoutY(310);
//	    assignCustomer.setStyle("-fx-background-color:#CBD5E1; -fx-text-fill: black;");
//	    
//	    assignCustomer.setOnAction(event -> {
//            // Open the Update profile page
//
//        	((Stage) assignCustomer.getScene().getWindow()).close();
//            assignCustomer nextAssignCustomer = new assignCustomer();
//            try {
//            	nextAssignCustomer.start(new Stage());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }});
//        
//        //Button for the sideBar
//        Button appointment=new Button();
//        appointment.setText("Arrange Appointments");
//        appointment.setFont(new Font("Verdana", 18));
//        appointment.setTextFill(Color.BLACK);
//        appointment.setLayoutX(50);
//        appointment.setLayoutY(360);
//        appointment.setStyle("-fx-background-color:#CBD5E1; -fx-text-fill: black;");
//       
//
////        //Button for the sideBar
////        Button reschedule=new Button();
////        reschedule.setText("Reschedule Services");
////        reschedule.setFont(new Font("Verdana", 18));
////        reschedule.setTextFill(Color.BLACK);
////        reschedule.setLayoutX(60);
////        reschedule.setLayoutY(360);
////        reschedule.setStyle("-fx-background-color:#CBD5E1; -fx-text-fill: black;");
//       
//        
        //Button for logout
        Button btnLogout=new Button();
        btnLogout.setText("Logout");
        btnLogout.setFont(new Font("Verdana", 20));
//        btnLogout.setLayoutX(1);
        btnLogout.setLayoutY(560);
        btnLogout.setPrefWidth(260);
        btnLogout.setPrefHeight(40);
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
        
        Label topic = new Label("Manage Services");
        topic.setFont(new Font("Verdana", 24));
        topic.setTextFill(Color.BLACK);
        topic.setLayoutX(360);
        topic.setLayoutY(40);
        
        //Main content
        TableView<NewService> table1= new TableView<NewService>();
		table1.setPrefWidth(660);
		table1.setPrefHeight(250);
		table1.setLayoutX(360);
		table1.setLayoutY(85);
		
		//Table Columns
		TableColumn<NewService, Integer> service_id = new TableColumn<>("SN");
		service_id.setCellValueFactory(new PropertyValueFactory<>("service_id"));
		service_id.setMinWidth(50);
		
		TableColumn<NewService, String> service_name = new TableColumn<>("Service Name");
		service_name.setCellValueFactory(new PropertyValueFactory<>("service_name"));
		service_name.setMinWidth(100);
		
		TableColumn<NewService, String> description = new TableColumn<>("Description");
		description.setCellValueFactory(new PropertyValueFactory<>("description"));
		description.setMinWidth(280);
		
		TableColumn<NewService, String> price = new TableColumn<>("Price");
		price.setCellValueFactory(new PropertyValueFactory<>("price"));
		price.setMinWidth(100);
		
		table1.getColumns().addAll(service_id, service_name,description, price);
		
		//set data
				List<NewService> persons = new ArrayList<NewService>();
				persons = allRecords();
				//set persons to tabl1
				for(NewService person: persons) {
					table1.getItems().add(person);
				}
				
				Label lblserviceId = new Label("Service ID");
				lblserviceId.setLayoutX(310);
				lblserviceId.setLayoutY(370);
				lblserviceId.setFont(new Font("Verdana", 12)); 
				lblserviceId.setTextFill(Color.BLACK);	
				 
			        TextField serviceIdField = new TextField();
			        serviceIdField.setLayoutX(410);
			        serviceIdField.setLayoutY(360);
			        serviceIdField.setPrefWidth(220);
			        serviceIdField.setPrefHeight(30);
			        
			        Label lblservicename = new Label("Service Name");
			        lblservicename.setLayoutX(700);
			        lblservicename.setLayoutY(370);
			        lblservicename.setFont(new Font("Verdana", 14)); 
			        lblservicename.setTextFill(Color.BLACK);	
			        
			        TextField serviceField = new TextField();
			        serviceField.setLayoutX(800);
			        serviceField.setLayoutY(360);
			        serviceField.setPrefWidth(220);
			        serviceField.setPrefHeight(30);
			        
			        Label lbldescription = new Label("Description");
			        lbldescription.setLayoutX(310);
			        lbldescription.setLayoutY(400);
			        lbldescription.setFont(new Font("Verdana", 16)); 
			        lbldescription.setTextFill(Color.BLACK);	
			        
			        TextField descriptionField = new TextField();
			        descriptionField.setLayoutX(410);
			        descriptionField.setLayoutY(400);
			        descriptionField.setPrefWidth(220);
			        descriptionField.setPrefHeight(30);
			        
			        Label lblPrice = new Label("Price");
			        lblPrice.setLayoutX(700);
			        lblPrice.setLayoutY(410);
			        lblPrice.setFont(new Font("Verdana", 14)); 
			        lblPrice.setTextFill(Color.BLACK);	
			        
			        TextField priceField = new TextField();
			        priceField.setLayoutX(800);
			        priceField.setLayoutY(400);
			        priceField.setPrefWidth(220);
			        priceField.setPrefHeight(30);
			        
			        Button btnSearch=new Button();
			        btnSearch.setText("Search");
			        btnSearch.setLayoutX(500);
			        btnSearch.setLayoutY(480);
			        btnSearch.setPrefWidth(100);
			        btnSearch.setPrefHeight(40);
			        btnSearch.setStyle("-fx-background-color:#285884; -fx-text-fill: white;");
			       
			        btnSearch.setOnAction((event) -> {
			            // Check if service ID is entered
			            if (serviceIdField.getText().isEmpty()) {
			                showAlert("Error", "Please enter the service ID.");
			            } else {
			                try {
			                    int Service_id = Integer.parseInt(serviceIdField.getText());
			                    NewService person = searchRecord(Service_id);
			                    if (person != null) {
			                        // Display service details
			                        serviceField.setText(person.getService_name());
			                        descriptionField.setText(person.getDescription());
			                        priceField.setText(String.valueOf(person.getPrice()));
			                        System.out.println("Record found");
			                    } else {
			                        showAlert("Error", "Record not found");
			                    }
			                } catch (NumberFormatException e) {
			                    showAlert("Error", "Invalid service ID format.");
			                }
			            }
			        });
			        
			        Button btnUpdate=new Button();
			        btnUpdate.setText("Update");
			        btnUpdate.setLayoutX(650);
			        btnUpdate.setLayoutY(480);
			        btnUpdate.setPrefWidth(100);
			        btnUpdate.setPrefHeight(40);
			        btnUpdate.setStyle("-fx-background-color:#285884; -fx-text-fill: white;");
			        
			        btnUpdate.setOnAction((event) -> {
			            // Check if customer ID is entered
			            if (serviceField.getText().isEmpty()) {
			                showAlert("Error", "Please select the customer ID to update.");
			            } else {
			                // Reading values from UI
			                int Service_id = Integer.parseInt(serviceIdField.getText()); // string->int
			                String Service_name = serviceField.getText();
			                String Description = descriptionField.getText();
			                double Price = Double.parseDouble(priceField.getText());
			               
			                NewService person = new NewService(Service_id, Service_name, Description, Price);
			                boolean res = updateRecord(person); // call method
			                if (res) {
			                    showAlert("Success", "Record updated successfully!");
			                    System.out.println("Record Saved");
			                 // Fefress the page
			                	((Stage) btnUpdate.getScene().getWindow()).close();
			                    manageService nextManageService = new manageService();
			                    try {
			                    	nextManageService.start(new Stage());
			                    } catch (Exception e) {
			                        e.printStackTrace();
			                }} else {
			                	  showAlert("Error", "Failed to update the record.");
			                      System.out.println("Error: Failed to update the record.");
			                }
			            }
			        });
			        

        
        headerPane.getChildren().addAll(head);
        sidePane.getChildren().addAll(homeimg,user,addServices,manageServices,assignCustomer,btnviewStaff,
        		btnLogout,topic,table1,lblserviceId,serviceIdField,lblservicename,serviceField,lbldescription,descriptionField,lblPrice,priceField,btnSearch,btnUpdate);
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
	public ArrayList<NewService> allRecords() {
	    ArrayList<NewService> services = new ArrayList<>();
	    
	    String DRIVER = "com.mysql.cj.jdbc.Driver";
	    String HOST = "localhost";
	    int PORT = 3306;
	    String DATABASE = "assignment";
	    String DBUSER = "root";
	    String DBPASS = "niharika@123";
	    String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;
	    String sql = "SELECT * FROM services";

	    try {
	        Class.forName(DRIVER);
	        Connection conn = DriverManager.getConnection(URL, DBUSER, DBPASS);
	        PreparedStatement pstat = conn.prepareStatement(sql);

	        ResultSet rs = pstat.executeQuery();
	        while (rs.next()) {
	            int service_id = rs.getInt("service_id");
	            String service_name = rs.getString("service_name");
	            String description = rs.getString("description");
	            double price = rs.getDouble("price");

	            NewService service = new NewService(service_id, service_name, description, price);
	            services.add(service);
	            System.out.println(service);
	        }

	        // Close resources
	        rs.close();
	        pstat.close();
	        conn.close();
	    } catch (Exception ex) {
	        System.out.println("Error: " + ex.getMessage());
	    }
	    
	    return services;
	}

	public NewService searchRecord(int service_id) {
		//pid, fullName, address, gender, ageGroup, reading, playing, other, login_id, pass_word
		NewService person = null;
		String DRIVER ="com.mysql.cj.jdbc.Driver";
		String HOST ="localhost";
		int PORT=3306;
		String DATABASE ="assignment";
		String DBUSER="root";
		String DBPASS="niharika@123";
		String URL = "jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE;
		String sql="SELECT * FROM services WHERE service_id=?";
		try {
			Class.forName(DRIVER); //loading driver
			Connection conn = DriverManager.getConnection(URL, DBUSER, DBPASS);//connection with database server
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setInt(1, service_id);			
			ResultSet rs = pstat.executeQuery();
			while(rs.next()) {
				String service_name = rs.getString("service_name");
				String description = rs.getString("description");
				double price = rs.getDouble("price");
				
				 person = new NewService(service_id, service_name, description, price);				
			}
			pstat.close();
			conn.close();			
		}
		catch(Exception ex) {
			System.out.println("Error : "+ex.getMessage());
		}
		return person;
	}
	public boolean updateRecord(NewService person) {
		//pid, fullName, address, gender, ageGroup, reading, playing, other, login_id, pass_word
		boolean result = false;
		String DRIVER ="com.mysql.cj.jdbc.Driver";
		String HOST ="localhost";
		int PORT=3306;
		String DATABASE ="assignment";
		String DBUSER="root";
		String DBPASS="niharika@123";
		String URL = "jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE;
		String sql="UPDATE services  SET service_name=?, description=?, price=?WHERE service_id=?";
		try {
			Class.forName(DRIVER); //loading driver
			Connection conn = DriverManager.getConnection(URL, DBUSER, DBPASS);//connection with database server
			PreparedStatement pstat = conn.prepareStatement(sql);			
			pstat.setString(1, person.getService_name());
			pstat.setString(2, person.getDescription());
			pstat.setDouble(3, person.getPrice());
			pstat.setInt(4, person.getService_id());
			
			pstat.executeUpdate();//Update Record
			pstat.close();
			conn.close();
			result=true;
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

