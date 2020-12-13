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
 
public class App extends Application {
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
                adminLogin();
            }
        });
        addSign.setOnAction(new EventHandler<ActionEvent>() {
        	@Override public void handle(ActionEvent e) {
        		((Node)(e.getSource())).getScene().getWindow().hide();
                addPage();
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


    public void adminLogin() {
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

        Label adminLogin = new Label("Name:");
        grid.add(adminLogin, 0, 1);

        TextField adminTextField = new TextField();
        grid.add(adminTextField, 1, 1);

        Button adminSign = new Button("Sign in");
        adminSign.setPrefSize(60, 20);
        HBox sign = new HBox(10);
        sign.setAlignment(Pos.CENTER);
        sign.getChildren().add(adminSign);
        grid.add(sign, 1, 3);   
        
        actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        adminSign.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent e) {
                if (e.getSource() == adminSign){
                	if(adminTextField.getText().matches("Wiki")){
                		adminScreen();
                		((Node)(e.getSource())).getScene().getWindow().hide();
                	}else{
                		actiontarget.setText("admin doesn't exist");
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


    public void adminScreen(){
    	Stage adminScreen = new Stage();
    	adminScreen.setHeight(700);
        adminScreen.setWidth(500);
        adminScreen.setTitle("Property Charge Management System");
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(1, 1, 25, 25));
        scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 10));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label propertyView = new Label("View a Property's tax info");
        grid.add(propertyView, 0, 1);

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
                singlePropertyScreen();
            }
        });
        Label ownerView = new Label("View tax info of an owner");
        grid.add(ownerView, 0, 3);

        Button ownbtn  = new Button("View");
        ownbtn.setPrefSize(60, 20);
        HBox ownhb = new HBox(10);
        ownhb.setAlignment(Pos.CENTER);
        ownhb.getChildren().add(ownbtn);
        grid.add(ownhb, 1, 3);   
        
        ownbtn.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent e) {
            	((Node)(e.getSource())).getScene().getWindow().hide();
                ownerViewScreen();
            }
        });
        Label overDueYear = new Label("See overdue tax year");
        grid.add(overDueYear, 0, 5);

        Button overduebtn  = new Button("Enter Year");
        overduebtn.setPrefSize(60, 20);
        HBox overduehb = new HBox(10);
        overduehb.setAlignment(Pos.CENTER);
        overduehb.getChildren().add(overduebtn);
        grid.add(overduehb, 1, 5);   
        
        overduebtn.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent e) {
            	((Node)(e.getSource())).getScene().getWindow().hide();
                overdueViewScreen();
            }
        });

        Label statView = new Label("See statistics of an area");
        grid.add(statView, 0, 7);

        Button statViewbtn  = new Button("View");
        statViewbtn.setPrefSize(60, 20);
        HBox statViewhb  = new HBox(10);
        statViewhb.setAlignment(Pos.CENTER);
        statViewhb.getChildren().add(statViewbtn);
        grid.add(statViewhb, 1, 7);   
        
        statViewbtn.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent e) {
            	((Node)(e.getSource())).getScene().getWindow().hide();
                statViewScreen();
            }
        });

        Label addAdmin = new Label("Add Admin");
        grid.add(addAdmin, 0, 9);

        Button addAdminbtn  = new Button("Add");
        addAdminbtn.setPrefSize(60, 20);
        HBox addAdminhb = new HBox(10);
        addAdminhb.setAlignment(Pos.CENTER);
        addAdminhb.getChildren().add(addAdminbtn);
        grid.add(addAdminhb, 1, 9);   
        
        addAdminbtn.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent e) {
            	((Node)(e.getSource())).getScene().getWindow().hide();
                addAdminScreen();
            }
        });

        Label addOwner = new Label("Add Owner");
        grid.add(addOwner, 0, 11);

        Button addOwnerbtn  = new Button("Add");
        addOwnerbtn.setPrefSize(60, 20);
        HBox addOwnerhb = new HBox(10);
        addOwnerhb.setAlignment(Pos.CENTER);
        addOwnerhb.getChildren().add(addOwnerbtn);
        grid.add(addOwnerhb, 1, 11);   
        
        addOwnerbtn.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent e) {
            	((Node)(e.getSource())).getScene().getWindow().hide();
                addUserScreen();
            }
        });

        Label removeOwner = new Label("Remove an Owner");
        grid.add(removeOwner, 0, 13);

        Button removeOwnerbtn  = new Button("Add");
        removeOwnerbtn.setPrefSize(60, 20);
        HBox removeOwnerhb = new HBox(10);
        removeOwnerhb.setAlignment(Pos.CENTER);
        removeOwnerhb.getChildren().add(removeOwnerbtn);
        grid.add(removeOwnerhb, 1, 13);   
        
        removeOwnerbtn.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent e) {
            	((Node)(e.getSource())).getScene().getWindow().hide();
                removeUserScreen();
            }
        });

        Button backbtn  = new Button("Back");
        backbtn.setPrefSize(60, 20);
        HBox backhb = new HBox(10);
        backhb.setAlignment(Pos.CENTER);
        backhb.getChildren().add(backbtn);
        grid.add(backhb, 0, 17);

        backbtn.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent e) {
                ((Node)(e.getSource())).getScene().getWindow().hide();
                adminLogin();
            }
        });

        scene = new Scene(grid, 300, 275);
        adminScreen.setScene(scene);
        adminScreen.show();
    }


    public void addPage(){
        Stage addstage = new Stage();
        addstage.setTitle("Property Charge Management System");
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        scenetitle = new Text("Enter name:");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label newLogin = new Label("Name:");
        grid.add(newLogin, 0, 1);

        TextField newTextField = new TextField();
        grid.add(newTextField, 1, 1);

        Button create = new Button("Create");
        create.setPrefSize(60, 20);
        HBox sign = new HBox(10);
        sign.setAlignment(Pos.CENTER);
        sign.getChildren().add(create);
        grid.add(sign, 1, 3);   
        
        actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        create.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent e) {
                if (e.getSource() == create){
                	if(newTextField.getText().matches("Wiki")){
                		actiontarget.setText("This user already exists");
                		((Node)(e.getSource())).getScene().getWindow().hide();
                        mainPage();
                	}else{
                        userScreen();
                		((Node)(e.getSource())).getScene().getWindow().hide();
                	}
                }
            }
        });
        scene = new Scene(grid, 300, 275);
        addstage.setScene(scene);
        addstage.show();
    }


    public void singlePropertyScreen(){
    	Stage singlePropertyScreen = new Stage();
    	singlePropertyScreen.setHeight(500);
        singlePropertyScreen.setWidth(500);
        singlePropertyScreen.setTitle("Property Charge Management System");
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(1, 1, 25, 25));
        scenetitle = new Text("View a single property");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 10));
        grid.add(scenetitle, 0, 0, 2, 1);
        

        Button viewbtn  = new Button("View");
        viewbtn.setPrefSize(60, 20);
        HBox viewhb = new HBox(10);
        viewhb.setAlignment(Pos.CENTER);
        viewhb.getChildren().add(viewbtn);
        grid.add(viewhb, 0, 1);

        viewbtn.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent e) {
                ((Node)(e.getSource())).getScene().getWindow().hide();
                pickProperties();
            }
        
        });


        Button backbtn  = new Button("Back");
        backbtn.setPrefSize(60, 20);
        HBox backhb = new HBox(10);
        backhb.setAlignment(Pos.CENTER);
        backhb.getChildren().add(backbtn);
        grid.add(backhb, 0, 17);

        backbtn.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent e) {
                ((Node)(e.getSource())).getScene().getWindow().hide();
                adminScreen();
            }
        
        });

        scene = new Scene(grid, 300, 275);
        singlePropertyScreen.setScene(scene);
        singlePropertyScreen.show();
    }

    public void ownerViewScreen(){
    	Stage ownerViewScreen = new Stage();
    	ownerViewScreen.setHeight(500);
        ownerViewScreen.setWidth(500);
        ownerViewScreen.setTitle("Property Charge Management System");
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(1, 1, 25, 25));
        scenetitle = new Text("View properties of an Owner");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 10));
        grid.add(scenetitle, 0, 0, 2, 1);
        
        Button firstbtn  = new Button("Shane");
        firstbtn.setPrefSize(60, 20);
        HBox firsthb = new HBox(10);
        firsthb.setAlignment(Pos.CENTER);
        firsthb.getChildren().add(firstbtn);
        grid.add(firsthb, 0, 1);

        firstbtn.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent e) {
                ((Node)(e.getSource())).getScene().getWindow().hide();
                shanesProperties();
            }
        
        });

        Button backbtn  = new Button("Back");
        backbtn.setPrefSize(60, 20);
        HBox backhb = new HBox(10);
        backhb.setAlignment(Pos.CENTER);
        backhb.getChildren().add(backbtn);
        grid.add(backhb, 0, 17);

        backbtn.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent e) {
                ((Node)(e.getSource())).getScene().getWindow().hide();
                adminScreen();
            }
        
        });

        scene = new Scene(grid, 300, 275);
        ownerViewScreen.setScene(scene);
        ownerViewScreen.show();
    }

    public void overdueViewScreen(){
    	Stage overdueViewScreen = new Stage();
    	overdueViewScreen.setHeight(500);
        overdueViewScreen.setWidth(500);
        overdueViewScreen.setTitle("Property Charge Management System");
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(1, 1, 25, 25));
        scenetitle = new Text("View overdue tax");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 10));
        grid.add(scenetitle, 0, 0, 2, 1);
        
        Button backbtn  = new Button("Back");
        backbtn.setPrefSize(60, 20);
        HBox backhb = new HBox(10);
        backhb.setAlignment(Pos.CENTER);
        backhb.getChildren().add(backbtn);
        grid.add(backhb, 0, 17);

        backbtn.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent e) {
                ((Node)(e.getSource())).getScene().getWindow().hide();
                adminScreen();
            }
        
        });

        scene = new Scene(grid, 300, 275);
        overdueViewScreen.setScene(scene);
        overdueViewScreen.show();
    }

    public void statViewScreen(){
    	Stage statViewScreen = new Stage();
    	statViewScreen.setHeight(500);
        statViewScreen.setWidth(500);
        statViewScreen.setTitle("Property Charge Management System");
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(1, 1, 25, 25));
        scenetitle = new Text("View statistics for a given area");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 10));
        grid.add(scenetitle, 0, 0, 2, 1);
        
        Button backbtn  = new Button("Back");
        backbtn.setPrefSize(60, 20);
        HBox backhb = new HBox(10);
        backhb.setAlignment(Pos.CENTER);
        backhb.getChildren().add(backbtn);
        grid.add(backhb, 0, 17);

        backbtn.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent e) {
                ((Node)(e.getSource())).getScene().getWindow().hide();
                adminScreen();
            }
        
        });

        scene = new Scene(grid, 300, 275);
        statViewScreen.setScene(scene);
        statViewScreen.show();
    }

    public void addAdminScreen(){
    	Stage addAdminScreen = new Stage();
    	addAdminScreen.setHeight(500);
        addAdminScreen.setWidth(500);
        addAdminScreen.setTitle("Property Charge Management System");
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(1, 1, 25, 25));
        scenetitle = new Text("Create a new Admin");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 10));
        grid.add(scenetitle, 0, 0, 2, 1);
        
        Button newbtn  = new Button("Create New");
        newbtn.setPrefSize(60, 20);
        HBox newhb = new HBox(10);
        newhb.setAlignment(Pos.CENTER);
        newhb.getChildren().add(newbtn);
        grid.add(newhb, 0, 1);

        newbtn.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent e) {
                ((Node)(e.getSource())).getScene().getWindow().hide();
                addNewAdminScreen();
            }
        
        });

        Button backbtn  = new Button("Back");
        backbtn.setPrefSize(60, 20);
        HBox backhb = new HBox(10);
        backhb.setAlignment(Pos.CENTER);
        backhb.getChildren().add(backbtn);
        grid.add(backhb, 0, 17);

        backbtn.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent e) {
                ((Node)(e.getSource())).getScene().getWindow().hide();
                adminScreen();
            }
        
        });

        scene = new Scene(grid, 300, 275);
        addAdminScreen.setScene(scene);
        addAdminScreen.show();
    }

    public void addUserScreen(){
    	Stage addUserScreen = new Stage();
    	addUserScreen.setHeight(500);
        addUserScreen.setWidth(500);
        addUserScreen.setTitle("Property Charge Management System");
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(1, 1, 25, 25));
        scenetitle = new Text("Create a new User");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 10));
        grid.add(scenetitle, 0, 0, 2, 1);
        
        Button backbtn  = new Button("Back");
        backbtn.setPrefSize(60, 20);
        HBox backhb = new HBox(10);
        backhb.setAlignment(Pos.CENTER);
        backhb.getChildren().add(backbtn);
        grid.add(backhb, 0, 17);

        backbtn.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent e) {
                ((Node)(e.getSource())).getScene().getWindow().hide();
                adminScreen();
            }
        
        });

        scene = new Scene(grid, 300, 275);
        addUserScreen.setScene(scene);
        addUserScreen.show();
    }

    public void removeUserScreen(){
    	Stage removeUserScreen = new Stage();
    	removeUserScreen.setHeight(500);
        removeUserScreen.setWidth(500);
        removeUserScreen.setTitle("Property Charge Management System");
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(1, 1, 25, 25));
        scenetitle = new Text("Remove a User");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 10));
        grid.add(scenetitle, 0, 0, 2, 1);
        

        Button remOwnerbtn  = new Button("Remove");
        remOwnerbtn.setPrefSize(60, 20);
        HBox remOwnerhb = new HBox(10);
        remOwnerhb.setAlignment(Pos.CENTER);
        remOwnerhb.getChildren().add(remOwnerbtn);
        grid.add(remOwnerhb, 0, 1);

        remOwnerbtn.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent e) {
                ((Node)(e.getSource())).getScene().getWindow().hide();
                removeOwnerScreen();
            }
        
        });


        Button backbtn  = new Button("Back");
        backbtn.setPrefSize(60, 20);
        HBox backhb = new HBox(10);
        backhb.setAlignment(Pos.CENTER);
        backhb.getChildren().add(backbtn);
        grid.add(backhb, 0, 17);

        backbtn.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent e) {
                ((Node)(e.getSource())).getScene().getWindow().hide();
                adminScreen();
            }
        
        });

        scene = new Scene(grid, 300, 275);
        removeUserScreen.setScene(scene);
        removeUserScreen.show();
    }

    public void pickProperties() {
        Stage pickProperties = new Stage();
        pickProperties.setHeight(500);
        pickProperties.setWidth(500);
        pickProperties.setTitle("Pick A Property");
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(1, 1, 25, 25));
        scenetitle = new Text("Pick a house");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 10));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label properties = new Label("14 Rose Street");
        grid.add(properties, 0, 1);

        Button pickbtn  = new Button("View");
        pickbtn.setPrefSize(60, 20);
        HBox pickhb = new HBox(10);
        pickhb.setAlignment(Pos.CENTER);
        pickhb.getChildren().add(pickbtn);
        grid.add(pickhb, 1, 1);

        pickbtn.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent e) {
                ((Node)(e.getSource())).getScene().getWindow().hide();
                //propertyInfo();
            }
        });
        Button backbtn  = new Button("Back");
        backbtn.setPrefSize(60, 20);
        HBox backhb = new HBox(10);
        backhb.setAlignment(Pos.CENTER);
        backhb.getChildren().add(backbtn);
        grid.add(backhb, 0, 2);

        backbtn.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent e) {
                ((Node)(e.getSource())).getScene().getWindow().hide();
                ownerViewScreen();
            }
        });
        scene = new Scene(grid, 300, 275);
        pickProperties.setScene(scene);
        pickProperties.show();
    }

    public void shanesProperties() {
        Stage shanesProperties = new Stage();
        shanesProperties.setHeight(500);
        shanesProperties.setWidth(500);
        shanesProperties.setTitle("Pick A Property");
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(1, 1, 25, 25));
        scenetitle = new Text("Pick a house");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 10));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label properties = new Label("14 Rose Street");
        grid.add(properties, 0, 1);

        Button pickbtn  = new Button("View");
        pickbtn.setPrefSize(60, 20);
        HBox pickhb = new HBox(10);
        pickhb.setAlignment(Pos.CENTER);
        pickhb.getChildren().add(pickbtn);
        grid.add(pickhb, 1, 1);

        pickbtn.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent e) {
                ((Node)(e.getSource())).getScene().getWindow().hide();
                propertyInfo();
            }
        });
        Button backbtn  = new Button("Back");
        backbtn.setPrefSize(60, 20);
        HBox backhb = new HBox(10);
        backhb.setAlignment(Pos.CENTER);
        backhb.getChildren().add(backbtn);
        grid.add(backhb, 0, 2);

        backbtn.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent e) {
                ((Node)(e.getSource())).getScene().getWindow().hide();
                ownerViewScreen();
            }
        });
        scene = new Scene(grid, 300, 275);
        shanesProperties.setScene(scene);
        shanesProperties.show();
    }

    
    public void propertyInfo() {
        Stage propertyInfo = new Stage();
        propertyInfo.setHeight(500);
        propertyInfo.setWidth(500);
        propertyInfo.setTitle("14 Rose Street");
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(1, 1, 25, 25));
        scenetitle = new Text("Pick a house");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 10));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label property = new Label("address,eircode,value,location,private/public,year");
        grid.add(property, 0, 1);

        Button backbtn  = new Button("Back");
        backbtn.setPrefSize(60, 20);
        HBox backhb = new HBox(10);
        backhb.setAlignment(Pos.CENTER);
        backhb.getChildren().add(backbtn);
        grid.add(backhb, 0, 2);

        backbtn.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent e) {
                ((Node)(e.getSource())).getScene().getWindow().hide();
                shanesProperties();
            }
        });

        scene = new Scene(grid, 300, 275);
        propertyInfo.setScene(scene);
        propertyInfo.show();
    }

    public void addNewAdminScreen() {
        Stage addAdmin = new Stage();
        addAdmin.setHeight(500);
        addAdmin.setWidth(500);
        addAdmin.setTitle("Create a new Admin");
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(1, 1, 25, 25));
        scenetitle = new Text("Enter the Admin you wish to create");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 10));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label property = new Label("Name: ");
        grid.add(property, 0, 1);

        TextField userToRemove = new TextField();
        grid.add(userToRemove, 1, 1);

        Button enterbtn  = new Button("Enter");
        enterbtn.setPrefSize(60, 20);
        HBox enterhb = new HBox(10);
        enterhb.setAlignment(Pos.CENTER);
        enterhb.getChildren().add(enterbtn);
        grid.add(enterhb, 0, 2);

        enterbtn.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent e) {
                ((Node)(e.getSource())).getScene().getWindow().hide();
                adminScreen();
            }
        });

        Button backbtn  = new Button("Back");
        backbtn.setPrefSize(60, 20);
        HBox backhb = new HBox(10);
        backhb.setAlignment(Pos.CENTER);
        backhb.getChildren().add(backbtn);
        grid.add(backhb, 1, 2);

        backbtn.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent e) {
                ((Node)(e.getSource())).getScene().getWindow().hide();
                adminScreen();
            }
        });

        scene = new Scene(grid, 300, 275);
        addAdmin.setScene(scene);
        addAdmin.show();
    }


    public void removeOwnerScreen() {
        Stage removeOwner = new Stage();
        removeOwner.setHeight(500);
        removeOwner.setWidth(500);
        removeOwner.setTitle("Remove a User");
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(1, 1, 25, 25));
        scenetitle = new Text("Enter the User name you wish to Remove");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 10));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label property = new Label("Name: ");
        grid.add(property, 0, 1);

        TextField userToRemove = new TextField();
        grid.add(userToRemove, 0, 2);

        Button enterbtn  = new Button("Enter");
        enterbtn.setPrefSize(60, 20);
        HBox enterhb = new HBox(10);
        enterhb.setAlignment(Pos.CENTER);
        enterhb.getChildren().add(enterbtn);
        grid.add(enterhb, 1, 2);

        enterbtn.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent e) {
                ((Node)(e.getSource())).getScene().getWindow().hide();
                adminScreen();
            }
        });

        Button backbtn  = new Button("Back");
        backbtn.setPrefSize(60, 20);
        HBox backhb = new HBox(10);
        backhb.setAlignment(Pos.CENTER);
        backhb.getChildren().add(backbtn);
        grid.add(backhb, 0, 3);

        backbtn.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent e) {
                ((Node)(e.getSource())).getScene().getWindow().hide();
                adminScreen();
            }
        });

        scene = new Scene(grid, 300, 275);
        removeOwner.setScene(scene);
        removeOwner.show();
    }

}
