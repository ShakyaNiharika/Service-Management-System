package prj1;

import javafx.application.Application;

import javafx.scene.Group;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.TextField; // Import TextField

import javafx.stage.Stage;
import javafx.scene.control.CheckBox;


//import javafx.scene.image.Image;
public class mainWindow extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Group group = new Group();
        Scene scene = new Scene(group);

        primaryStage.setTitle("MyWindow2");
        primaryStage.setWidth(350);
        primaryStage.setHeight(250);
        primaryStage.setX(20);
        primaryStage.setY(20);
        primaryStage.setScene(scene);

        // Creating a Label

        Label lblPID = new Label("Enter your pid:");

        lblPID.setLayoutX(20);

        lblPID.setLayoutY(20);


        // Creating a TextField

        TextField PIDField = new TextField(); //PIDField is  the name given to the field 

        PIDField.setLayoutX(150);

        PIDField.setLayoutY(20);
        
        Button btnSave=new Button();
        btnSave.setText("Save");
        
        CheckBox c1 = new CheckBox("Reading");
        CheckBox c2 = new CheckBox("Playing");
        
        Button btn1= new Button("Check");
        btn1.setOnAction(event)->{
        	String choice1 = null;
        	String choice2 = null;
        	if(c1.isSelected()==true) {
        		choice2=checkBox2.getText();
        		
        	}
        	System.out.println("Your Choices");
        	if(choice1!=null) {
        		System.out.println(choice1);
        	}
        	if(choice2!=null) {
        		System.out.println(choice1);
        	}
        	if(choice2!)
        }
        Button btn2 = new Button("Close");
        

        // Adding the Label and TextField to the Group

//        group.getChildren().addAll(lblPID, PIDField);//add on group
//        group.getChildren().addAll(btnSave);
        group.getChildren().addAll(c1);
        group.getChildren().addAll(c2);
        group.getChildren().addAll(btn1);
        group.getChildren().addAll(btn2);
        
//

//         Setting the icon of the stage (assuming the iconImage variable is defined)

//         Image iconImage = new Image("file:icon.png");
//
//         primaryStage.getIcons().add(iconImage);



        primaryStage.show();

    }



    public static void main(String[] args) {

        launch(args);

    }

}