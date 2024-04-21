package assignment;

import javafx.application.Application;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
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

public class totalCost extends Application {
	@Override
	public void start(Stage PrimaryStage ) throws Exception {
		// TODO Auto-generated method stub
		//Pane for background color
        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: #FFFFFF");
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
        
       //Main Content
        Label lblHeadManageCus = new Label("Assign Customer");
        lblHeadManageCus.setLayoutX(360);
        lblHeadManageCus.setLayoutY(45);
        lblHeadManageCus.setFont(new Font("Verdana", 20)); 
        lblHeadManageCus.setTextFill(Color.BLACK);
        
        TableView<NewBooking> table1 = new TableView<NewBooking>();
        table1.setPrefWidth(500);
        table1.setPrefHeight(350);
        table1.setLayoutX(400);
        table1.setLayoutY(85);

        // Table Columns
        TableColumn<NewBooking, Integer> booking_id = new TableColumn<>("SN");
        booking_id.setCellValueFactory(new PropertyValueFactory<>("booking_id"));
        booking_id.setMinWidth(8);
        
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

        TableColumn<NewBooking, String> price = new TableColumn<>("Price");
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        price.setMinWidth(100);
        
        TableColumn<NewBooking, Float> total_cost = new TableColumn<>("Total Cost");
        total_cost.setCellValueFactory(cellData -> {
            NewBooking booking = cellData.getValue();
            float totalCost = TotalCostCalculator.calculateTotalCost(booking.getBooking_id());
            return new SimpleFloatProperty(totalCost).asObject();
        });
        total_cost.setMinWidth(100);




//        TableColumn<NewBooking, String> status = new TableColumn<>("Status");
//        status.setCellValueFactory(data -> {
//            if (data.getValue() instanceof NewBookingWithStatus) {
//                NewBookingWithStatus bookingWithStatus = (NewBookingWithStatus) data.getValue();
//                return new SimpleStringProperty(bookingWithStatus.getStatus());
//            } else {
//                return new SimpleStringProperty("Status Not Available");
//            }
//        });
//        status.setMinWidth(100);

        table1.getColumns().addAll(booking_id, service_name, estimated_hour,  price, total_cost);

        // set data
        TotalCostCalculator costCalculator = new TotalCostCalculator();

     // Call the allRecords() method on the instance
     List<NewBookingWithTotalCost> bookings = costCalculator.allRecords();
        // set bookings to table1
        for (NewBooking booking : bookings) {
            table1.getItems().add(booking);
        }
        
        
        headerPane.getChildren().addAll(head);
        sidePane.getChildren().addAll(homeimg,user,addServices,manageServices,
        		btnLogout,lblHeadManageCus,table1);
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
	public class TotalCostCalculator {

	    // Method to calculate the total cost for a given order_id
	    public static float calculateTotalCost(int booking_id) {
	        // Database connection parameters
	        String url = "jdbc:mysql://localhost:3306/your_database";
	        String DRIVER = "com.mysql.cj.jdbc.Driver";
		    String HOST = "localhost";
		    int PORT = 3306;
		    String DATABASE = "assignment";
		    String DBUSER = "root";
		    String DBPASS = "niharika@123";
		    String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;
	        // SQL query to calculate total cost
	        String sql = "SELECT SUM(price * estimated_hour) AS total_cost " +
	                     "FROM bookings " +
	                     "WHERE booking_id = ?";

	        try (
	            // Establish database connection
	            Connection conn = DriverManager.getConnection(url, DBUSER, DBPASS);
	            // Create PreparedStatement to execute the SQL query
	            PreparedStatement stmt = conn.prepareStatement(sql);
	        ) {
	            // Set the order_id parameter in the query
	            stmt.setInt(1, booking_id);

	            // Execute the query
	            try (ResultSet rs = stmt.executeQuery()) {
	                if (rs.next()) {
	                    // Retrieve the total_cost value from the result set
	                    float totalCost = rs.getFloat("total_cost");
	                    return totalCost;
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        // Return 0 if total cost calculation fails or no result found
	        return 0;
	    }
	public List<NewBookingWithTotalCost> allRecords() {
	    List<NewBookingWithTotalCost> bookings = new ArrayList<>();
	    String DRIVER = "com.mysql.cj.jdbc.Driver";
	    String HOST = "localhost";
	    int PORT = 3306;
	    String DATABASE = "assignment";
	    String DBUSER = "root";
	    String DBPASS = "niharika@123";
	    String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;
	    String sql = "SELECT s.service_name, b.estimated_hour, b.price,b.total_cost " +
	                 "FROM bookings b " +
	                 "JOIN Services s ON b.service_id = s.service_id";

	    try {
	        Class.forName(DRIVER);
	        Connection conn = DriverManager.getConnection(URL, DBUSER, DBPASS);
	        PreparedStatement pstat = conn.prepareStatement(sql);
	        ResultSet rs = pstat.executeQuery();
	        while (rs.next()) {
	            String service_name = rs.getString("service_name");
	            Float estimated_hour = rs.getFloat("estimated_hour");
	            Float price = rs.getFloat("price");
	            Float total_cost = rs.getFloat("total_cost");
	            NewService service = new NewService(0, service_name, null, 0.0);
	            bookings.add(new NewBookingWithTotalCost(0, service, estimated_hour, null, null, price, total_cost));
	        }
	        rs.close();
	        pstat.close();
	        conn.close();
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	    return bookings;
	};

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
}}


