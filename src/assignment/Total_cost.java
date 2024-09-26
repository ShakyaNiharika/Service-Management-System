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
//import assignment.totalCost.TotalCostCalculator;
import javafx.scene.control.Alert;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import assignment.NewCustomer;

public class Total_cost extends Application {
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
        //Button for the sideBar
        Button report=new Button();
        report.setText("Report");
        report.setFont(new Font("Verdana", 18));
        report.setTextFill(Color.BLACK);
        report.setLayoutX(50);
        report.setLayoutY(410);
        report.setStyle("-fx-background-color:#CBD5E1; -fx-text-fill: black;");
       
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
        
        Label HeadTotal = new Label("View Report");
        HeadTotal.setLayoutX(480);
        HeadTotal.setLayoutY(52);
        HeadTotal.setFont(new Font("Verdana", 28)); 
        HeadTotal.setTextFill(Color.BLACK);
        
        TableView<NewBookingWithTotalCost> table1 = new TableView<NewBookingWithTotalCost>();
        table1.setPrefWidth(580);
        table1.setPrefHeight(350);
        table1.setLayoutX(380);
        table1.setLayoutY(115);

        // Table Columns
        TableColumn<NewBookingWithTotalCost, Integer> booking_id = new TableColumn<>("SN");
        booking_id.setCellValueFactory(new PropertyValueFactory<>("booking_id"));
        booking_id.setMinWidth(8);
      
     // TableColumn for service name
        TableColumn<NewBookingWithTotalCost, String> service_name = new TableColumn<>("Service Name");
        service_name.setCellValueFactory(data -> {
            // Access the NewService object from the NewBooking
            NewService service = data.getValue().getServices();
            // Return the service name
            return new SimpleStringProperty(service.getService_name());
        });
        service_name.setMinWidth(100);

        TableColumn<NewBookingWithTotalCost, String> estimated_hour = new TableColumn<>("Estimated Hour");
        estimated_hour.setCellValueFactory(new PropertyValueFactory<>("estimated_hour"));
        estimated_hour.setMinWidth(100);

        TableColumn<NewBookingWithTotalCost, String> price = new TableColumn<>("Price");
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        price.setMinWidth(100);
        
        TableColumn<NewBookingWithTotalCost, Float> total_cost = new TableColumn<>("Total Cost");
        total_cost.setCellValueFactory(cellData -> {
            NewBooking booking = cellData.getValue();
            Float estimatedHour = booking.getEstimated_hour();
            Float priceValue = booking.getPrice();
            return new SimpleFloatProperty(estimatedHour * priceValue).asObject();
        });
        total_cost.setMinWidth(100);
        	
        table1.getColumns().addAll(booking_id, service_name, estimated_hour, price, total_cost);

        // Call the allRecords() method on the instance
        List<NewBookingWithTotalCost> bookings = new ArrayList<NewBookingWithTotalCost>();
        bookings = allRecords();
           // set bookings to table1
           for (NewBookingWithTotalCost booking : bookings) {
               table1.getItems().add(booking);
           }
           //Total revenue
           Label lblrevenue = new Label("Total revenue");
           lblrevenue.setLayoutX(380);
           lblrevenue.setLayoutY(505);
           lblrevenue.setFont(new Font("Verdana", 14)); 
           lblrevenue.setTextFill(Color.BLACK);	
	        
	        TextField revenueField = new TextField();
	        revenueField.setLayoutX(530);
	        revenueField.setLayoutY(500);
	        revenueField.setPrefWidth(220);
	        revenueField.setPrefHeight(30);
	        
	        // Calculate total revenue
	        float totalRevenue = calculateTotalRevenue();
	        revenueField.setText(String.valueOf(totalRevenue));
       
        headerPane.getChildren().addAll(head);
        sidePane.getChildren().addAll(addServices,user,manageServices,assignCustomer,btnviewStaff,
        		report,btnLogout,HeadTotal,table1,lblrevenue,revenueField);
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
	public List<NewBookingWithTotalCost> allRecords() {
	    List<NewBookingWithTotalCost> bookings = new ArrayList<>();
	    String DRIVER = "com.mysql.cj.jdbc.Driver";
	    String HOST = "localhost";
	    int PORT = 3306;
	    String DATABASE = "assignment";
	    String DBUSER = "root";
	    String DBPASS = "niharika@123";
	    String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;
	    String sql = "SELECT b.booking_id, s.service_name, b.estimated_hour, b.price, b.total_cost " +
	             "FROM bookings b " +
	             "JOIN Services s ON b.service_id = s.service_id " +
	             "WHERE  b.status = 'completed'";



	    try {
	        Class.forName(DRIVER);
	        Connection conn = DriverManager.getConnection(URL, DBUSER, DBPASS);
	        PreparedStatement pstat = conn.prepareStatement(sql);
	        ResultSet rs = pstat.executeQuery();
	        while (rs.next()) {
	            int booking_id = rs.getInt("booking_id");
	            String service_name = rs.getString("service_name");
	            Float estimated_hour = rs.getFloat("estimated_hour");
	            Float price = rs.getFloat("price");
	            
	            // Calculate total cost by multiplying price and estimated hour
	            Float total_cost = price * estimated_hour;

	            NewService service = new NewService(0, service_name, null, 0.0);
	            bookings.add(new NewBookingWithTotalCost(booking_id, service, estimated_hour, null, null, price, total_cost));
	        }

	        rs.close();
	        pstat.close();
	        conn.close();
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	    return bookings;
	};
	
	public float calculateTotalRevenue() {
	    String DRIVER = "com.mysql.cj.jdbc.Driver";
	    String HOST = "localhost";
	    int PORT = 3306;
	    String DATABASE = "assignment";
	    String DBUSER = "root";
	    String DBPASS = "niharika@123";
	    String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;
	    String sql = "SELECT SUM(b.total_cost) AS total_revenue " +
	                 "FROM bookings b " +
	                 "JOIN Services s ON b.service_id = s.service_id " +
	                 "WHERE b.status = 'completed'";
	    
	    float totalRevenue = 0;

	    try {
	        Class.forName(DRIVER);
	        Connection conn = DriverManager.getConnection(URL, DBUSER, DBPASS);
	        PreparedStatement pstat = conn.prepareStatement(sql);
	        ResultSet rs = pstat.executeQuery();
	        if (rs.next()) {
	            totalRevenue = rs.getFloat("total_revenue");
	        }

	        rs.close();
	        pstat.close();
	        conn.close();
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	    
	    return totalRevenue;
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

