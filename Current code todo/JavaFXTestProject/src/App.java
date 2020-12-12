import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class App extends Application {

    String enteredName;
    Scene scene1;
    Stage primaryStage;
    String[] Owners = {"Patrick", "Admin"};
    String[] Pproperties = {"Property1", "Property2"};
    String[] properties = {"Property1", "Property2", "Property3"};
    BorderPane border;
    Button prop1;

    @Override
    public void start(Stage primaryStage) throws Exception {
        //BorderPane is the layout we will use
        border = new BorderPane();

        //CrTextFieldeate and prepare the spacing for the first menu. (Sign in)
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        border.setTop(hbox);

        //Create and prepare the spacing for the left side menu (Used also in second stage)
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(15, 12, 15, 12));
        vbox.setSpacing(10);
        border.setLeft(vbox);

        //Create the button for Sign in on the first Stage
        Button signIn = new Button();
        signIn.setText("Sign in");

        //Prepared the entered String for later use
        TextField userName = new TextField();

        //Proccessing event for sign in
        signIn.setOnAction(e -> {
            for(int i = 0; i < Owners.length; i++){
                if(userName.getText() == Owners[i]){
                    vbox.getChildren().addAll(prop1);
                    }
            
                }
            }

        );

        //Create the Text objects
        Text prompt = new Text("Enter Name: ");
        Text info = new Text("Please enter your name above to sign in.");


        //Add the objects to the appropriate areas
        hbox.getChildren().addAll(prompt, userName, signIn);
        vbox.getChildren().addAll(info);

        //Add the Tile
        primaryStage.setTitle("Property Charge Management System");

        //Prepare the first and second scene
        scene1 = new Scene(border, 750, 600);
        primaryStage.setScene(scene1);

        //Show the scene
        primaryStage.show();
    }
    
    public static void main(String[] args){
        launch(args);
    }

}
