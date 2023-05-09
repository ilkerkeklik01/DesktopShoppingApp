import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public abstract class LoginScreen {

    protected static void loginScreen(Stage primaryStage){
        Stage loginStage= new Stage();
        GridPane loginGridPane = new GridPane();
        loginGridPane.setHgap(5);
        loginGridPane.setVgap(5);
        Label usernameLabel = new Label("Username:");
        TextField usernameTextField = new TextField();
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        loginGridPane.addRow(0, usernameLabel, usernameTextField);
        loginGridPane.addRow(1, passwordLabel, passwordField);
        Button loginButton = new Button("Login");
        loginButton.setOnAction(event -> {
            if (usernameTextField.getText().equals("admin") && passwordField.getText().equals("password")) {
                // Remove the login screen and show the main program content
                loginStage.close();
                HomeScreen.homeScreen(primaryStage);

            }
        });
        loginGridPane.addRow(2, loginButton);

        Scene scene = new Scene(loginGridPane,500,500);
        loginStage.setScene(scene);
        loginStage.setTitle("Login");
        loginStage.show();


    }



}
