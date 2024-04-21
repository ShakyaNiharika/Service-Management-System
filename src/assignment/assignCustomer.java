package assignment;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import assignment.NewCustomer;

public class assignCustomer extends Application {
	@Override
	public void start(Stage PrimaryStage ) throws Exception {
		// TODO Auto-generated method stub
		Pane pane = new Pane();
      
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

        // Create a Label for the header
        Label head = new Label("Welcome To Service Management System");
        head.setFont(new Font("Verdana", 24));
        head.setTextFill(Color.BLACK);
        head.setLayoutX(20);
        head.setLayoutY(22);
        
        ImageView user = new ImageView(new Image(getClass().getResourceAsStream("userphoto.jpg")));
        user.setFitWidth(180); // Adjust image width as needed
        user.setFitHeight(140);
        user.setPreserveRatio(true);
        user.setLayoutX(40);
        user.setLayoutY(50);
        
        
        
      
        Button manageCustomer=new Button();
        manageCustomer.setText("Manage Customer");
        manageCustomer.setFont(new Font("Verdana", 20));
        manageCustomer.setTextFill(Color.BLACK);
        manageCustomer.setLayoutX(50);
        manageCustomer.setLayoutY(210);
        manageCustomer.setStyle("-fx-background-color:#CBD5E1; -fx-text-fill: black;");
        
        manageCustomer.setOnAction(event -> {
            // Open the Update profile page

        	((Stage) manageCustomer.getScene().getWindow()).close();
            StaffDashboard nextManageCustomer = new StaffDashboard();
            try {
            	nextManageCustomer.start(new Stage());
            } catch (Exception e) {
                e.printStackTrace();
            }});
       
        //Button for the My Profile
	    Button btnadd=new Button();
	    btnadd.setText("Add Customer");
	    btnadd.setFont(new Font("Verdana", 18));
	    btnadd.setTextFill(Color.BLACK);
	    btnadd.setLayoutX(50);
	    btnadd.setLayoutY(260);
	    btnadd.setStyle("-fx-background-color:#CBD5E1; -fx-text-fill: black;");
	    
	    //When Add Customer is clicked
	    btnadd.setOnAction(event -> {
	    	addCustomer nextGUI = new addCustomer();
            try {
            	((Stage) btnadd.getScene().getWindow()).close();
                nextGUI.start(new Stage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
	    
	    Button addCustomer=new Button();
	    addCustomer.setText("Assign customers");
	    addCustomer.setFont(new Font("Verdana", 18));
	    addCustomer.setTextFill(Color.BLACK);
	    addCustomer.setLayoutX(50);
	    addCustomer.setLayoutY(310);
	    addCustomer.setStyle("-fx-background-color:#CBD5E1; -fx-text-fill: black;");
        
//        //Button for the sideBar
//        Button appointment=new Button();
//        appointment.setText("Arrange Appointments");
//        appointment.setFont(new Font("Verdana", 18));
//        appointment.setTextFill(Color.BLACK);
//        appointment.setLayoutX(50);
//        appointment.setLayoutY(360);
//        appointment.setStyle("-fx-background-color:#CBD5E1; -fx-text-fill: black;");
       

//        //Button for the sideBar
//        Button reschedule=new Button();
//        reschedule.setText("Reschedule Services");
//        reschedule.setFont(new Font("Verdana", 18));
//        reschedule.setTextFill(Color.BLACK);
//        reschedule.setLayoutX(60);
//        reschedule.setLayoutY(360);
//        reschedule.setStyle("-fx-background-color:#CBD5E1; -fx-text-fill: black;");
       
        
        //Button for logout
        Button btnLogout=new Button();
        btnLogout.setText("Logout");
        btnLogout.setFont(new Font("Verdana", 20));
//        btnLogout.setLayoutX(1);
        btnLogout.setLayoutY(560);
        btnLogout.setPrefWidth(260);
        btnLogout.setPrefHeight(40);
        btnLogout.setStyle("-fx-background-color:#CBD5E1; -fx-text-fill: black;");
        
        btnLogout.setOnAction(event -> {
            // Open the Update profile page

        	((Stage) btnLogout.getScene().getWindow()).close();
            staffLogin nextStaffLogin = new staffLogin();
            try {
            	nextStaffLogin.start(new Stage());
            } catch (Exception e) {
                e.printStackTrace();
            }});
        
        //Main content
        Label lblHeadManageCus = new Label("Assign Customer");
        lblHeadManageCus.setLayoutX(360);
        lblHeadManageCus.setLayoutY(45);
        lblHeadManageCus.setFont(new Font("Verdana", 20)); 
        lblHeadManageCus.setTextFill(Color.BLACK);
        
        TableView<NewBooking> table1 = new TableView<NewBooking>();
        table1.setPrefWidth(800);
        table1.setPrefHeight(250);
        table1.setLayoutX(280);
        table1.setLayoutY(85);

        // Table Columns
        TableColumn<NewBooking, Integer> booking_id = new TableColumn<>("SN");
        booking_id.setCellValueFactory(new PropertyValueFactory<>("booking_id"));
        booking_id.setMinWidth(8);
        
     // TableColumn for customer name
        TableColumn<NewBooking, String> customer_name = new TableColumn<>("Customer Name");
        customer_name.setCellValueFactory(data -> {
            if (data.getValue() instanceof NewBookingWithStatus) {
                NewBookingWithStatus bookingWithStatus = (NewBookingWithStatus) data.getValue();
                return new SimpleStringProperty(bookingWithStatus.getCustomerName());
            } else {
                return new SimpleStringProperty("Customer Name Not Available");
            }
        });
        customer_name.setMinWidth(100);

     // TableColumn for service name
        TableColumn<NewBooking, String> service_name = new TableColumn<>("Service Name");
        service_name.setCellValueFactory(data -> {
            // Access the NewService object from the NewBooking
            NewService service = data.getValue().getServices();
            // Return the service name
            return new SimpleStringProperty(service.getService_name());
        });
        service_name.setMinWidth(100);

        TableColumn<NewBooking, String> estimated_hour = new TableColumn<>("Estimated Hour");
        estimated_hour.setCellValueFactory(new PropertyValueFactory<>("estimated_hour"));
        estimated_hour.setMinWidth(100);

        TableColumn<NewBooking, Integer> booking_date = new TableColumn<>("Booking Date");
        booking_date.setCellValueFactory(new PropertyValueFactory<>("booking_date"));
        booking_date.setMinWidth(110);

        TableColumn<NewBooking, String> booking_time = new TableColumn<>("Booking Time");
        booking_time.setCellValueFactory(new PropertyValueFactory<>("booking_time"));
        booking_time.setMinWidth(100);

        TableColumn<NewBooking, String> price = new TableColumn<>("Price");
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        price.setMinWidth(100);

        TableColumn<NewBooking, String> status = new TableColumn<>("Status");
        status.setCellValueFactory(data -> {
            if (data.getValue() instanceof NewBookingWithStatus) {
                NewBookingWithStatus bookingWithStatus = (NewBookingWithStatus) data.getValue();
                return new SimpleStringProperty(bookingWithStatus.getStatus());
            } else {
                return new SimpleStringProperty("Status Not Available");
            }
        });
        status.setMinWidth(100);

        table1.getColumns().addAll(booking_id, customer_name,service_name, estimated_hour, booking_date, booking_time, price, status);

        // set data
        List<NewBookingWithStatus> bookings = allRecords();
        // set bookings to table1
        for (NewBooking booking : bookings) {
            table1.getItems().add(booking);
        }
        
     


        //Fileds to assign the worker
        Label lblcustomer_name = new Label("Customer Name");
        lblcustomer_name.setLayoutX(290);
        lblcustomer_name.setLayoutY(400);
        lblcustomer_name.setFont(new Font("Verdana", 14)); 
        lblcustomer_name.setTextFill(Color.BLACK);	
        
        TextField customer_namedField = new TextField();
        customer_namedField.setLayoutX(410);
        customer_namedField.setLayoutY(400);
        customer_namedField.setPrefWidth(220);
        customer_namedField.setPrefHeight(30);
        
        Label lblbooking_id = new Label("Booking ID");
        lblbooking_id.setLayoutX(700);
        lblbooking_id.setLayoutY(410);
        lblbooking_id.setFont(new Font("Verdana", 14)); 
        lblbooking_id.setTextFill(Color.BLACK);	
        
        TextField booking_idField = new TextField();
        booking_idField.setLayoutX(800);
        booking_idField.setLayoutY(400);
        booking_idField.setPrefWidth(220);
        booking_idField.setPrefHeight(30);
        
        Label lblservice_name = new Label("Service Name");
        lblservice_name.setLayoutX(295);
        lblservice_name.setLayoutY(440);
        lblservice_name.setFont(new Font("Verdana", 14)); 
        lblservice_name.setTextFill(Color.BLACK);	
        
        TextField service_nameField = new TextField();
        service_nameField.setLayoutX(410);
        service_nameField.setLayoutY(440);
        service_nameField.setPrefWidth(220);
        service_nameField.setPrefHeight(30);
        
        Label lblstatus = new Label("Status");
        lblstatus.setLayoutX(700);
        lblstatus.setLayoutY(440);
        lblstatus.setFont(new Font("Verdana", 16)); 
        lblstatus.setTextFill(Color.BLACK);	
        
        TextField statusField = new TextField();
        statusField.setLayoutX(800);
        statusField.setLayoutY(440);
        statusField.setPrefWidth(220);
        statusField.setPrefHeight(30);
        
        Label lblassign = new Label("Assign Worker");
        lblassign.setLayoutX(295);
        lblassign.setLayoutY(480);
        lblassign.setFont(new Font("Verdana", 14)); 
        lblassign.setTextFill(Color.BLACK);
        
        ComboBox<String> comboBoxForAssign = new ComboBox<>();
        comboBoxForAssign.setLayoutX(410);
        comboBoxForAssign.setLayoutY(480);
        comboBoxForAssign.setPrefWidth(220);
        comboBoxForAssign.setPrefHeight(30);
        //callshowWorkerID
        showWorkerID(comboBoxForAssign);

       
     // Adding a listener to show in the textField
        table1.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                // Populate text fields with selected row's data
            	if (newSelection instanceof NewBookingWithStatus) {
                    NewBookingWithStatus selectedBooking = (NewBookingWithStatus) newSelection;
                    // Populate text fields with selected row's data
                    customer_namedField.setText(selectedBooking.getCustomerName());
                    booking_idField.setText(String.valueOf(selectedBooking.getBooking_id()));
                    service_nameField.setText(selectedBooking.getServices().getService_name());
                    statusField.setText(selectedBooking.getStatus());
            }}
        });
        
        
        
        Button btnAssign=new Button();
        btnAssign.setText("Assign Worker");
        btnAssign.setLayoutX(590);
        btnAssign.setLayoutY(530);
        btnAssign.setPrefWidth(100);
        btnAssign.setPrefHeight(40);
        btnAssign.setOnAction(event -> {
            // Check if both customer name and booking ID are entered
            if (customer_namedField.getText().isEmpty() || booking_idField.getText().isEmpty() || comboBoxForAssign.getValue() == null) {
                showAlert("Error", "Please select a booking and worker to assign.");
            } else {
                // Get the selected booking ID
                int bookingId = Integer.parseInt(booking_idField.getText());
                
                // Get the selected worker ID from the ComboBox
                String workerId = comboBoxForAssign.getValue();
                
                // Perform the status update and worker assignment directly
                boolean updateSuccess = updateRecord(bookingId, workerId);
                
                // Check if the update was successful
                if (updateSuccess) {
                    // Show a success message
                    showAlert("Success", "Status updated to 'completed' and worker assigned successfully!");
                    // Optionally, you can refresh the table here
                    ((Stage) btnAssign.getScene().getWindow()).close();
                    assignCustomer openAssignCustomer = new assignCustomer();
                    try {
                        openAssignCustomer.start(new Stage());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    // Show an error message if the update failed
                    showAlert("Error", "Failed to update status to 'completed' and assign worker in the database.");
                }
            }
        });


        
       
//        btnAssign.setOnAction((event) -> {
//            // Check if customer ID is entered
//            if (booking_idField.getText().isEmpty()) {
//                showAlert("Error", "Please select the customer ID to update.");
//            } else {
//                // Reading values from UI
//                int customer_id = Integer.parseInt(customerField.getText()); // string->int
//                String Username = UsernameField.getText();
//                String Password = passwordField.getText();
//                String address = addressField.getText();
//                String phone = phoneField.getText();
//                String email_address = emailField.getText();
//                LocalDate Date_of_birth = date_of_birthField.getValue(); // Convert string to LocalDate
//                String Gender = "Female";
//                if (r1.isSelected()) {
//                    Gender = "Male";
//                }
//
//                NewCustomer person = new NewCustomer(customer_id, Username, Password, address, phone, email_address, Date_of_birth, Gender);
//                boolean res = updateRecord(person); // call method
//                if (res) {
//                    showAlert("Success", "Record updated successfully!");
//                    System.out.println("Record Saved");
//                 // Fefress the page
//                	((Stage) btnUpdate.getScene().getWindow()).close();
//                    StaffDashboard OpenStaffDashboard = new StaffDashboard();
//                    try {
//                    	OpenStaffDashboard.start(new Stage());
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                }} else {
//                	  showAlert("Error", "Failed to update the record.");
//                      System.out.println("Error: Failed to update the record.");
//                }
//            }
//        });
        
        headerPane.getChildren().addAll(head);
        sidePane.getChildren().addAll(user,manageCustomer,btnadd,addCustomer,
        		btnLogout,lblHeadManageCus,table1,lblcustomer_name,customer_namedField,lblbooking_id,booking_idField,lblservice_name,service_nameField,lblstatus,statusField,lblassign,comboBoxForAssign,btnAssign);
//        pane.getChildren().add(table1);
        Pane rootPane = new Pane(headerPane, sidePane);
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
	
	private List<NewBookingWithStatus> allRecords() {
	    List<NewBookingWithStatus> bookings = new ArrayList<>();
	    String DRIVER = "com.mysql.cj.jdbc.Driver";
	    String HOST = "localhost";
	    int PORT = 3306;
	    String DATABASE = "assignment";
	    String DBUSER = "root";
	    String DBPASS = "niharika@123";
	    String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;
	    String sql = "SELECT b.booking_id, customers.username, s.service_name, b.estimated_hour, b.booking_date, b.booking_time, b.price, b.status FROM bookings b JOIN Services s ON b.service_id = s.service_id JOIN Customers ON b.customer_id = Customers.customer_id";

	    try {
	        Class.forName(DRIVER);
	        Connection conn = DriverManager.getConnection(URL, DBUSER, DBPASS);
	        PreparedStatement pstat = conn.prepareStatement(sql);
	        ResultSet rs = pstat.executeQuery();
	        while (rs.next()) {
	            int booking_id = rs.getInt("booking_id");
	            String username = rs.getString("username");
	            String service_name = rs.getString("service_name");
	            Float estimated_hour = rs.getFloat("estimated_hour");
	            String booking_date_str = rs.getString("booking_date");
	            LocalDate booking_date = LocalDate.parse(booking_date_str);
	            String booking_time = rs.getString("booking_time");
	            Float price = rs.getFloat("price");
	            String status = rs.getString("status");
	            NewService service = new NewService(0, service_name, null, 0.0);
	            bookings.add(new NewBookingWithStatus(booking_id, username, service, estimated_hour, booking_date, booking_time, price, status));
	        }
	        rs.close();
	        pstat.close();
	        conn.close();
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	    return bookings;
	}
	
	//To display workerID in comboBox
	public void showWorkerID(ComboBox<String> comboBox) {
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
	        PreparedStatement statement = connection.prepareStatement("SELECT worker_id FROM workers");
	        
	        // Executing query
	        ResultSet resultSet = statement.executeQuery();
	        comboBox.getItems().clear();
	        
	        // Adding worker IDs to the ComboBox
	        while (resultSet.next()) {
	            comboBox.getItems().add(resultSet.getString("worker_id"));
	        }
	        
	        // Closing resources
	        resultSet.close();
	        statement.close();
	        connection.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	public boolean updateRecord(int bookingId, String workerId) {
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
	        
	        // Creating and executing the update query
	        String updateQuery = "UPDATE bookings SET status = 'completed', worker_id = ? WHERE booking_id = ?";
	        PreparedStatement statement = connection.prepareStatement(updateQuery);
	        statement.setString(1, workerId);
	        statement.setInt(2, bookingId);
	        int rowsAffected = statement.executeUpdate();
	        
	        // Closing resources
	        statement.close();
	        connection.close();
	        
	        // Check if the update was successful
	        return rowsAffected > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false; // Return false if an exception occurred
	    }
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


