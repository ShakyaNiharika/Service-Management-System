
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

public class viewStaff extends Application {
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
//	    
	    Button assignCustomer=new Button();
	    assignCustomer.setText("View Customers");
	    assignCustomer.setFont(new Font("Verdana", 18));
	    assignCustomer.setTextFill(Color.BLACK);
	    assignCustomer.setLayoutX(50);
	    assignCustomer.setLayoutY(310);
	    assignCustomer.setStyle("-fx-background-color:#CBD5E1; -fx-text-fill: black;");
	    
	    assignCustomer.setOnAction(event -> {
           //Navigate to other page
        	((Stage) assignCustomer.getScene().getWindow()).close();
            adminViewCustomer nextAssignCustomer = new adminViewCustomer();
            try {
            	nextAssignCustomer.start(new Stage());
            } catch (Exception e) {
                e.printStackTrace();
            }});
//        
//        //Button for the sideBar
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
        
        //Main content
        Label lblHeadManageCus = new Label("View Staff");
        lblHeadManageCus.setLayoutX(360);
        lblHeadManageCus.setLayoutY(52);
        lblHeadManageCus.setFont(new Font("Verdana", 20)); 
        lblHeadManageCus.setTextFill(Color.BLACK);
        
        TableView<NewStaff> table1= new TableView<NewStaff>();
		table1.setPrefWidth(800);
		table1.setPrefHeight(250);
		table1.setLayoutX(280);
		table1.setLayoutY(85);
		
		//Table Columns
		
		TableColumn<NewStaff, Integer> staff_id = new TableColumn<>("SN");
		staff_id.setCellValueFactory(new PropertyValueFactory<>("staff_id"));
		staff_id.setMinWidth(8);
		
		TableColumn<NewStaff, String> username = new TableColumn<>("Username");
		username.setCellValueFactory(new PropertyValueFactory<>("username"));
		username.setMinWidth(100);
		
		TableColumn<NewStaff, String> password = new TableColumn<>("Password");
		password.setCellValueFactory(new PropertyValueFactory<>("pass_word"));
		password.setMinWidth(100);
		
		TableColumn<NewStaff, String> colAddress = new TableColumn<>("Address");
		colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
		colAddress.setMinWidth(100);
		
		TableColumn<NewStaff, String> phone_number = new TableColumn<>("Phone_number");
		phone_number.setCellValueFactory(new PropertyValueFactory<>("phone_number"));
		phone_number.setMinWidth(100);
		
		TableColumn<NewStaff, String> email = new TableColumn<>("Email Address");
		email.setCellValueFactory(new PropertyValueFactory<>("email_address"));
		email.setMinWidth(140);
		
		TableColumn<NewStaff, Integer> join_date = new TableColumn<>("Join Date");
		join_date.setCellValueFactory(new PropertyValueFactory<>("join_date"));
		join_date.setMinWidth(110);
		
		TableColumn<NewStaff, Integer> gender = new TableColumn<>("Gender");
		gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
		gender.setMinWidth(60);
		
		table1.getColumns().addAll(staff_id, username,password, colAddress, phone_number, email, join_date, gender);
		
		//set data
				List<NewStaff> persons = new ArrayList<NewStaff>();
				persons = allRecords();
				//set persons to tabl1
				for(NewStaff person: persons) {
					table1.getItems().add(person);
				}

//				 Label lblcusId = new Label("Customer ID");
//				 lblcusId.setLayoutX(310);
//				 lblcusId.setLayoutY(370);
//				 lblcusId.setFont(new Font("Verdana", 12)); 
//				 lblcusId.setTextFill(Color.BLACK);	
//				 
//			        TextField customerField = new TextField();
//			        customerField.setLayoutX(410);
//			        customerField.setLayoutY(360);
//			        customerField.setPrefWidth(220);
//			        customerField.setPrefHeight(30);
//			        
//			        Label lblusername = new Label("Username");
//			        lblusername.setLayoutX(700);
//			        lblusername.setLayoutY(370);
//			        lblusername.setFont(new Font("Verdana", 14)); 
//			        lblusername.setTextFill(Color.BLACK);	
//			        
//			        TextField UsernameField = new TextField();
//			        UsernameField.setLayoutX(800);
//			        UsernameField.setLayoutY(360);
//			        UsernameField.setPrefWidth(220);
//			        UsernameField.setPrefHeight(30);
//			        
//			        Label lblpassword = new Label("Password");
//			        lblpassword.setLayoutX(310);
//			        lblpassword.setLayoutY(400);
//			        lblpassword.setFont(new Font("Verdana", 16)); 
//			        lblpassword.setTextFill(Color.BLACK);	
//			        
//			        TextField passwordField = new TextField();
//			        passwordField.setLayoutX(410);
//			        passwordField.setLayoutY(400);
//			        passwordField.setPrefWidth(220);
//			        passwordField.setPrefHeight(30);
//			        
//			        Label lbladdress = new Label("Address");
//			        lbladdress.setLayoutX(700);
//			        lbladdress.setLayoutY(410);
//			        lbladdress.setFont(new Font("Verdana", 14)); 
//			        lbladdress.setTextFill(Color.BLACK);	
//			        
//			        TextField addressField = new TextField();
//			        addressField.setLayoutX(800);
//			        addressField.setLayoutY(400);
//			        addressField.setPrefWidth(220);
//			        addressField.setPrefHeight(30);
//			        
//			        Label lblphone = new Label("Phone Number");
//			        lblphone.setLayoutX(295);
//			        lblphone.setLayoutY(440);
//			        lblphone.setFont(new Font("Verdana", 14)); 
//			        lblphone.setTextFill(Color.BLACK);	
//			        
//			        TextField phoneField = new TextField();
//			        phoneField.setLayoutX(410);
//			        phoneField.setLayoutY(440);
//			        phoneField.setPrefWidth(220);
//			        phoneField.setPrefHeight(30);
//			        
//			        Label lblemail = new Label("Email Address");
//			        lblemail.setLayoutX(700);
//			        lblemail.setLayoutY(440);
//			        lblemail.setFont(new Font("Verdana", 12)); 
//			        lblemail.setTextFill(Color.BLACK);	
//			        
//			        TextField emailField = new TextField();
//			        emailField.setLayoutX(800);
//			        emailField.setLayoutY(440);
//			        emailField.setPrefWidth(220);
//			        emailField.setPrefHeight(30);
//			        
//			        Label lbldate = new Label("Join Date");
//			        lbldate.setLayoutX(295);
//			        lbldate.setLayoutY(480);
//			        lbldate.setFont(new Font("Verdana", 14)); 
//			        lbldate.setTextFill(Color.BLACK);	
//			        
//			        DatePicker date_of_birthField = new DatePicker();
//			        date_of_birthField.setLayoutX(410);
//			        date_of_birthField.setLayoutY(480);
//			        date_of_birthField.setPrefWidth(220);
//			        date_of_birthField.setPrefHeight(30);
//			        
//			        Label lblgender = new Label("Gender");
//			        lblgender.setLayoutX(700);
//			        lblgender.setLayoutY(480);
//			        lblgender.setFont(new Font("Verdana", 14)); 
//			        lblgender.setTextFill(Color.BLACK);
//			        
//			        RadioButton r1= new RadioButton("Male");
//			        r1.setLayoutX(800);
//			        r1.setLayoutY(480);
//			        r1.setUserData("Male");
//			        
//			        RadioButton r2= new RadioButton("Female");
//			        r2.setLayoutX(870);
//			        r2.setLayoutY(480);
//			        r2.setUserData("Female");
//			        
//			        RadioButton r3= new RadioButton("Others");
//			        r3.setLayoutX(950);
//			        r3.setLayoutY(480);
//			        r3.setUserData("Others");
//			        
//			        ToggleGroup group=new ToggleGroup();
//			        r1.setToggleGroup(group);
//			        r2.setToggleGroup(group);
//			        r3.setToggleGroup(group);
			        
//			        Button btnSearch=new Button();
//			        btnSearch.setText("Search");
//			        btnSearch.setLayoutX(480);
//			        btnSearch.setLayoutY(530);
//			        btnSearch.setPrefWidth(100);
//			        btnSearch.setPrefHeight(40);
////			        btnSearch.setStyle("-fx-background-color:#285884; -fx-text-fill: white;");
//			        btnSearch.setOnAction((event) -> {
//			            // Check if customer ID is entered
//			            if (customerField.getText().isEmpty()) {
//			                showAlert("Error", "Please enter the customer ID.");
//			            } else {
//			                // Customer ID is entered, proceed with search
//			                int customer_id = Integer.parseInt(customerField.getText());
//			                NewCustomer person = searchRecord(customer_id);
//			                if (person != null) {
//			                    // Display all values
//			                    UsernameField.setText(person.getUsername());
//			                    passwordField.setText(person.getPass_word());
//			                    addressField.setText(person.getAddress());
//			                    phoneField.setText(person.getPhone_number());
//			                    emailField.setText(person.getEmail_address());
//			                    date_of_birthField.setValue(person.getDate_of_birth());
//
//			                    // Gender
//			                    if (person.getGender().equals("Male")) {
//			                        r1.setSelected(true);
//			                    } else {
//			                        r2.setSelected(true);
//			                    }
//
//			                    showAlert("Success", "Record found");
//			                } else {
//			                    showAlert("Error", "Record not found");
//			                }
//			            }
//			        });
//
//			        
//			        Button btnUpdate=new Button();
//			        btnUpdate.setText("Update");
//			        btnUpdate.setLayoutX(590);
//			        btnUpdate.setLayoutY(530);
//			        btnUpdate.setPrefWidth(100);
//			        btnUpdate.setPrefHeight(40);
//			        
//			       
//			        btnUpdate.setOnAction((event) -> {
//			            // Check if customer ID is entered
//			            if (customerField.getText().isEmpty()) {
//			                showAlert("Error", "Please select the customer ID to update.");
//			            } else {
//			                // Reading values from UI
//			                int customer_id = Integer.parseInt(customerField.getText()); // string->int
//			                String Username = UsernameField.getText();
//			                String Password = passwordField.getText();
//			                String address = addressField.getText();
//			                String phone = phoneField.getText();
//			                String email_address = emailField.getText();
//			                LocalDate Date_of_birth = date_of_birthField.getValue(); // Convert string to LocalDate
//			                String Gender = "Female";
//			                if (r1.isSelected()) {
//			                    Gender = "Male";
//			                }
//
//			                NewStaff person = new NewStaff(customer_id, Username, Password, address, phone, email_address, join_date, Gender);
//			                boolean res = updateRecord(person); // call method
//			                if (res) {
//			                    showAlert("Success", "Record updated successfully!");
//			                    System.out.println("Record Saved");
//			                 // Fefress the page
//			                	((Stage) btnUpdate.getScene().getWindow()).close();
//			                    viewStaff OpenStaffDashboard = new viewStaff();
//			                    try {
//			                    	OpenStaffDashboard.start(new Stage());
//			                    } catch (Exception e) {
//			                        e.printStackTrace();
//			                }} else {
//			                	  showAlert("Error", "Failed to update the record.");
//			                      System.out.println("Error: Failed to update the record.");
//			                }
//			            }
//			        });

			        
			        
			        
        headerPane.getChildren().addAll(head);
        sidePane.getChildren().addAll(user,addServices,manageServices,assignCustomer,btnviewStaff,btnLogout,
        		lblHeadManageCus,table1);
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
	public ArrayList allRecords() {
		//pid, fullName, address, gender, ageGroup, reading, playing, other, login_id, pass_word
		
		ArrayList<NewStaff> persons = new ArrayList<NewStaff>();
		
		String DRIVER ="com.mysql.cj.jdbc.Driver";
		String HOST ="localhost";
		int PORT=3306;
		String DATABASE ="assignment";
		String DBUSER="root";
		String DBPASS="niharika@123";
		String URL = "jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE;
		String sql="SELECT * FROM staffs";
		
		try {
			Class.forName(DRIVER); //loading driver
			Connection conn = DriverManager.getConnection(URL, DBUSER, DBPASS);//connection with database server
			PreparedStatement pstat = conn.prepareStatement(sql);
			
			ResultSet rs = pstat.executeQuery();
			while(rs.next()) {
				int staff_id = rs.getInt("staff_id");
				String username = rs.getString("username");
				String pass_word = rs.getString("pass_word");
				String address = rs.getString("address");
				String phone_number=rs.getString("phone_number");
				String email_address = rs.getString("email_address");
				String dateOfBirthStr = rs.getString("join_date");
				LocalDate join_date = LocalDate.parse(dateOfBirthStr);
				String gender = rs.getString("gender");
				
				NewStaff person = new NewStaff(staff_id, username,pass_word,address,phone_number,email_address,join_date, gender);				
				persons.add(person);
				System.out.println(person);
			}
			pstat.close();
			conn.close();			
		}
		catch(Exception ex) {
			System.out.println("Error : "+ex.getMessage());
		}
		return persons;
	}
//	
//	public NewCustomer searchRecord(int customer_id) {
//		//pid, fullName, address, gender, ageGroup, reading, playing, other, login_id, pass_word
//		NewCustomer person = null;
//		String DRIVER ="com.mysql.cj.jdbc.Driver";
//		String HOST ="localhost";
//		int PORT=3306;
//		String DATABASE ="assignment";
//		String DBUSER="root";
//		String DBPASS="niharika@123";
//		String URL = "jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE;
//		String sql="SELECT * FROM customers WHERE customer_id=?";
//		try {
//			Class.forName(DRIVER); //loading driver
//			Connection conn = DriverManager.getConnection(URL, DBUSER, DBPASS);//connection with database server
//			PreparedStatement pstat = conn.prepareStatement(sql);
//			pstat.setInt(1, customer_id);			
//			ResultSet rs = pstat.executeQuery();
//			while(rs.next()) {
//				String username = rs.getString("username");
//				String password = rs.getString("pass_word");
//				String address = rs.getString("address");
//				String phone_number=rs.getString("phone_number");
//				String email_address = rs.getString("email_address");
//				String dateOfBirthStr = rs.getString("date_of_birth");
//				LocalDate date_of_birth = LocalDate.parse(dateOfBirthStr);
//				String gender = rs.getString("gender");
//				person = new NewCustomer(customer_id, username, password, address, phone_number, email_address, date_of_birth, gender);				
//			}
//			pstat.close();
//			conn.close();			
//		}
//		catch(Exception ex) {
//			System.out.println("Error : "+ex.getMessage());
//		}
//		return person;
//	}
//		public boolean updateRecord(NewCustomer person) {
//			//pid, fullName, address, gender, ageGroup, reading, playing, other, login_id, pass_word
//			boolean result = false;
//			String DRIVER ="com.mysql.cj.jdbc.Driver";
//			String HOST ="localhost";
//			int PORT=3306;
//			String DATABASE ="assignment";
//			String DBUSER="root";
//			String DBPASS="niharika@123";
//			String URL = "jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE;
//			String sql="UPDATE customers  SET username=?, pass_word=?, address=?, phone_number=?, email_address=?, date_of_birth=?, gender=? WHERE customer_id=?";
//			try {
//				Class.forName(DRIVER); //loading driver
//				Connection conn = DriverManager.getConnection(URL, DBUSER, DBPASS);//connection with database server
//				PreparedStatement pstat = conn.prepareStatement(sql);			
//				pstat.setString(1, person.getUsername());
//				pstat.setString(2, person.getPass_word());
//				pstat.setString(3, person.getAddress());
//				pstat.setString(4, person.getPhone_number());
//				pstat.setString(5, person.getEmail_address());
//				LocalDate dateOfBirth = person.getDate_of_birth();
//				String dateOfBirthStr = dateOfBirth.toString();
//				pstat.setString(6, dateOfBirthStr); 
//				pstat.setString(7, person.getGender());
//				pstat.setInt(8, person.getCustomer_id());
//				
//				pstat.executeUpdate();//Update Record
//				pstat.close();
//				conn.close();
//				result=true;
//			}
//			catch(Exception ex) {
//				System.out.println("Error : "+ex.getMessage());
//			}
//			return result;
//		}
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

