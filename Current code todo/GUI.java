import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
 
public class GUI extends Application {
	 GridPane grid;
	 Text scenetitle;
	 Scene scene;
	 Text actiontarget;
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Property Charge Management System");
        primaryStage.setHeight(500);
        primaryStage.setWidth(500);
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        scenetitle = new Text("Welcome to the Property Charge Management System.\nPlease click the button to continue. ");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 18));
        grid.add(scenetitle, 0, 0, 2, 1);
        
        Button enterApp = new Button("Enter Application");
        enterApp.setPrefSize(150, 20);
        HBox enterBtn = new HBox(10);
        enterBtn.setAlignment(Pos.CENTER);
        enterBtn.getChildren().add(enterApp);
        grid.add(enterBtn, 1, 1);
        
        actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        enterApp.setOnAction(new EventHandler<ActionEvent>() {
        	@Override public void handle(ActionEvent e) {
        		((Node)(e.getSource())).getScene().getWindow().hide();
                mainPage();
            }
        });
        scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void mainPage() {
    	Stage mainPage = new Stage();
        mainPage.setTitle("Property Charge Management System");
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        scenetitle = new Text("Please Choose an Option");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userLogin = new Label("User:");
        grid.add(userLogin, 0, 1);
        Label adminLogin= new Label("Admin:");
        grid.add(adminLogin, 0, 3);
        Label addUser= new Label("Add user:");
        grid.add(addUser, 0, 5);

        Button userSign = new Button("Sign in");
        userSign.setPrefSize(60, 20);
        HBox user = new HBox(10);
        user.setAlignment(Pos.CENTER);
        user.getChildren().add(userSign);
        grid.add(user, 1, 1);
        
        Button adminSign = new Button("Sign in");
        adminSign.setPrefSize(60, 20);
        HBox admin= new HBox(10);
        admin.setAlignment(Pos.CENTER);
        admin.getChildren().add(adminSign);
        grid.add(admin, 1, 3);
        
        Button addSign = new Button("Add");
        addSign.setPrefSize(60, 20);
        HBox add = new HBox(10);
        add.setAlignment(Pos.CENTER);
        add.getChildren().add(addSign);
        grid.add(add, 1, 5);
        
        grid.add(actiontarget, 1, 6);
        userSign.setOnAction(new EventHandler<ActionEvent>() {
        	@Override public void handle(ActionEvent e) {
        		((Node)(e.getSource())).getScene().getWindow().hide();
                userLogin();
            }
        });
        adminSign.setOnAction(new EventHandler<ActionEvent>() {
        	@Override public void handle(ActionEvent e) {
        		((Node)(e.getSource())).getScene().getWindow().hide();
                //adminLogin();
            }
        });
        addSign.setOnAction(new EventHandler<ActionEvent>() {
        	@Override public void handle(ActionEvent e) {
        		((Node)(e.getSource())).getScene().getWindow().hide();
                //addPage();
            }
        });
        scene = new Scene(grid, 300, 275);
        mainPage.setScene(scene);
        mainPage.show();
    }
    
    public void userLogin() {
    	Stage loginstage = new Stage();
        loginstage.setTitle("Property Charge Management System");
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        scenetitle = new Text("Enter name:");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userLogin = new Label("Name:");
        grid.add(userLogin, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Button userSign = new Button("Sign in");
        userSign.setPrefSize(60, 20);
        HBox sign = new HBox(10);
        sign.setAlignment(Pos.CENTER);
        sign.getChildren().add(userSign);
        grid.add(sign, 1, 3);   
        
        actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        userSign.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent e) {
                if (e.getSource() == userSign){
                	if(userTextField.getText().matches("Wiki")){
                		userScreen();
                		((Node)(e.getSource())).getScene().getWindow().hide();
                	}else{
                		actiontarget.setText("user doesn't exist");
                		((Node)(e.getSource())).getScene().getWindow().hide();
                		mainPage();
                	}
                }
            }
        });
        scene = new Scene(grid, 300, 275);
        loginstage.setScene(scene);
        loginstage.show();
    }
    
    public void userScreen(){
    	Stage userScreen = new Stage();
    	userScreen.setHeight(500);
        userScreen.setWidth(500);
        userScreen.setTitle("Property Charge Management System");
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(1, 1, 25, 25));
        scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 10));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label properties = new Label("View all Properties");
        grid.add(properties, 0, 1);

        Button propsbtn  = new Button("View");
        propsbtn.setPrefSize(60, 20);
        HBox propshb = new HBox(10);
        propshb.setAlignment(Pos.CENTER);
        propshb.getChildren().add(propsbtn);
        grid.add(propshb, 1, 1);   
        
        propsbtn.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent e) {
            	((Node)(e.getSource())).getScene().getWindow().hide();
                //getProperties();
            }
        });
        Label property = new Label("View a property");
        grid.add(property, 0, 3);

        Button propbtn  = new Button("View");
        propbtn.setPrefSize(60, 20);
        HBox prophb = new HBox(10);
        prophb.setAlignment(Pos.CENTER);
        prophb.getChildren().add(propbtn);
        grid.add(prophb, 1, 3);   
        
        propbtn.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent e) {
            	((Node)(e.getSource())).getScene().getWindow().hide();
                //getProperty();
            }
        });
        Label payTax = new Label("Pay a tax");
        grid.add(payTax, 0, 5);

        Button taxbtn  = new Button("Pay Tax");
        taxbtn.setPrefSize(60, 20);
        HBox taxhb = new HBox(10);
        taxhb.setAlignment(Pos.CENTER);
        taxhb.getChildren().add(taxbtn);
        grid.add(taxhb, 1, 5);   
        
        taxbtn.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent e) {
            	((Node)(e.getSource())).getScene().getWindow().hide();
                //payTax();
            }
        });
        Label addProp = new Label("Add");
        grid.add(addProp, 0, 5);

        Button addPropbtn  = new Button("Add");
        addPropbtn.setPrefSize(60, 20);
        HBox addProphb = new HBox(10);
        addProphb.setAlignment(Pos.CENTER);
        addProphb.getChildren().add(addPropbtn);
        grid.add(addProphb, 1, 5);   
        
        addPropbtn.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent e) {
            	((Node)(e.getSource())).getScene().getWindow().hide();
                //addProperty();
            }
        });
        scene = new Scene(grid, 300, 275);
        userScreen.setScene(scene);
        userScreen.show();
    }
    
 }