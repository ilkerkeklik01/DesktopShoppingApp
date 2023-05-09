import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;


public abstract class HomeScreen {

    protected static void homeScreen(Stage primaryStage){
        BorderPane root  = new BorderPane();

        root.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY,null)));

        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        ArrayList<Item> items = new ArrayList<>(Main.getItems());

        for(int i = 0;i<5;i++){
            gridPane.add(items.get(i),i,0);
        }
        for(int i = 5;i<10;i++){
            gridPane.add(items.get(i),i-5,1);
        }

        root.setCenter(gridPane);
        gridPane.setAlignment(Pos.CENTER);

        Main.basket = new Basket();

        VBox rightVBox = new VBox();
        rightVBox.setAlignment(Pos.CENTER);
        rightVBox.getChildren().add(Main.basket);
        rightVBox.getChildren().add(Main.getContinueWithPayOption(primaryStage));


        root.setRight(rightVBox);


        Scene scene = new Scene(root,1400,800);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Shopping FX Project");
        primaryStage.show();


    }

}
