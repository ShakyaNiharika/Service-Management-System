package assignment;

import assignment.Gvar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.security.Provider.Service;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.beans.property.SimpleStringProperty;


public class customer_history extends Application {
	
	int customer_id = Gvar.id;
	
    @Override
    public void start(Stage primaryStage) {
        // Pane for background color
        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: #E6E7E8;");
        pane.setPrefHeight(1000);
        pane.setPrefWidth(1180);

        // Create a Pane for the header section
        Pane headerPane = new Pane();
        headerPane.setStyle("-fx-background-color: #CBD5E1;");
        headerPane.setPrefHeight(80);
        headerPane.setPrefWidth(1200);

        // Create a Pane for the content section
        Pane sidePane = new Pane();
        sidePane.setStyle("-fx-background-color: #CBD5E1;");
        sidePane.setPrefHeight(620);
        sidePane.setPrefWidth(268);
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
        
        Label userName = new Label("Username: Nirmala");
        userName.setFont(new Font("Verdana", 24));
        userName.setTextFill(Color.BLACK);
        userName.setLayoutX(860);
        userName.setLayoutY(22);


        Button dashboard = new Button();
        dashboard.setText("Dashboard");
        dashboard.setFont(new Font("Verdana", 18));
        dashboard.setTextFill(Color.BLACK);
        dashboard.setLayoutX(60);
        dashboard.setLayoutY(210);
        dashboard.setStyle("-fx-background-color:#CBD5E1; -fx-text-fill: black;");
        //navigate to customer dashboard
        dashboard.setOnAction(event -> {
            // Open the Update profile page

        	((Stage) dashboard.getScene().getWindow()).close();
            customerDashboard nextDashboard = new customerDashboard();
            try {
            	nextDashboard.start(new Stage());
            } catch (Exception e) {
                e.printStackTrace();
            }});

        // Button for the My Profile
        Button profile = new Button();
        profile.setText("My Profile");
        profile.setFont(new Font("Verdana", 18));
        profile.setTextFill(Color.BLACK);
        profile.setLayoutX(60);
        profile.setLayoutY(260);
        profile.setStyle("-fx-background-color:#CBD5E1; -fx-text-fill: black;");
        profile.setOnAction(event -> {
            // Open the Update profile page
            ((Stage) profile.getScene().getWindow()).close();
            updateProfile nextUpdateProfile = new updateProfile();
            try {
                nextUpdateProfile.start(new Stage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Button for the sideBar
        Button appointment = new Button();
        appointment.setText("My Appointment");
        appointment.setFont(new Font("Verdana", 18));
        appointment.setTextFill(Color.BLACK);
        appointment.setLayoutX(60);
        appointment.setLayoutY(310);
        appointment.setStyle("-fx-background-color:#CBD5E1; -fx-text-fill: black;");

//        // Button for the sideBar
//        Button reschedule = new Button();
//        reschedule.setText("Reschedule Services");
//        reschedule.setFont(new Font("Verdana", 18));
//        reschedule.setTextFill(Color.BLACK);
//        reschedule.setLayoutX(60);
//        reschedule.setLayoutY(360);
//        reschedule.setStyle("-fx-background-color:#CBD5E1; -fx-text-fill: black;");
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

        // Button for logout
        Button btnLogout = new Button();
        btnLogout.setText("Logout");
        btnLogout.setFont(new Font("Verdana", 20));
        btnLogout.setLayoutY(560);
        btnLogout.setPrefWidth(260);
        btnLogout.setPrefHeight(40);
        btnLogout.setStyle("-fx-background-color:#CBD5E1; -fx-text-fill: black;");
        
        btnLogout.setOnAction(event -> {
            // Open the Update profile page

        	((Stage) btnLogout.getScene().getWindow()).close();
            firstWindow nextloginpage = new firstWindow();
            try {
            	nextloginpage.start(new Stage());
            } catch (Exception e) {
                e.printStackTrace();
            }});

        // Main Content
        Label lblHeadHistory = new Label("Appointment History");
        lblHeadHistory.setLayoutX(360);
        lblHeadHistory.setLayoutY(45);
        lblHeadHistory.setFont(new Font("Verdana", 30)); 
        lblHeadHistory.setTextFill(Color.BLACK);
        
        TableView<NewBooking> table1 = new TableView<NewBooking>();
        table1.setPrefWidth(800);
        table1.setPrefHeight(400);
        table1.setLayoutX(320);
        table1.setLayoutY(115);

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

        // Add the status column to the TableView
        table1.getColumns().addAll(booking_id, service_name, estimated_hour, booking_date, booking_time, price, status);

        // Update the list type to NewBookingWithStatus
        List<NewBookingWithStatus> bookings = allRecords();
        // Set bookings to table1
        for (NewBookingWithStatus booking : bookings) {
            table1.getItems().add(booking);
        }


        // Add the Label to the headerPane
        headerPane.getChildren().addAll(head,userName);
        sidePane.getChildren().addAll(user, dashboard, profile, appointment,reschedule, btnLogout,lblHeadHistory, table1);

        // Or, you can use a Pane directly if you don't need vertical stacking
        Pane rootPane = new Pane(pane, headerPane, sidePane);

        // Create a Scene with the root Pane
        Scene scene = new Scene(rootPane);

        // Set the scene to the stage
        primaryStage.setTitle("MyWindow");
        primaryStage.setWidth(1180);
        primaryStage.setHeight(740);
        primaryStage.setX(100);
        primaryStage.setY(20);
        primaryStage.setScene(scene);
        primaryStage.show();
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
        String sql = "SELECT b.booking_id, s.service_name, b.estimated_hour, b.booking_date, b.booking_time, b.price, b.status " +
                     "FROM bookings b " +
                     "JOIN Services s ON b.service_id = s.service_id " +
                     "WHERE customer_id=?;";

        try {
            Class.forName(DRIVER); // Loading driver
            Connection conn = DriverManager.getConnection(URL, DBUSER, DBPASS); // Establishing connection with the database server
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setInt(1, customer_id);
            ResultSet rs = pstat.executeQuery();
            while (rs.next()) {
                int booking_id = rs.getInt("booking_id");
                String service_name = rs.getString("service_name");
                Float estimated_hour = rs.getFloat("estimated_hour");
                String booking_date_str = rs.getString("booking_date");
                LocalDate booking_date = LocalDate.parse(booking_date_str);
                String booking_time = rs.getString("booking_time");
                Float price = rs.getFloat("price");
                String status = rs.getString("status"); // Fetch status from the database
                NewService service = new NewService(0, service_name, null, 0.0);
                // Create instances of NewBookingWithStatus
                bookings.add(new NewBookingWithStatus(booking_id, service_name, service, estimated_hour, booking_date, booking_time, price, status));
            }
            rs.close();
            pstat.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return bookings;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
