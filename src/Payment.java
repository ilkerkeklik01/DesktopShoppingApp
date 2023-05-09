import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;

public  class Payment extends Stage implements Visible {

    public Payment(Stage primaryStage, Basket basket){
        initModality(Modality.APPLICATION_MODAL);
        initOwner(primaryStage);

        HBox hBox = new HBox();

        VBox vbox = new VBox();
        hBox.getChildren().add(vbox);
        MyPaymentForm myPaymentForm = new MyPaymentForm();
        hBox.getChildren().add(myPaymentForm);

        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(10);

        Text title = new Text("Payment Page");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 16));

        ListView<Item> itemList = new ListView<>();
        itemList.setItems(basket.getBasketItems());

        Label totalPriceLabel = new Label(String.format("Total Cost: $%.2f",basket.totalPriceProperty().get()));

        basket.getBasketItems().addListener((ListChangeListener.Change<? extends Item> change) -> {
            itemList.setItems(basket.getBasketItems());
        });



        basket.totalPriceProperty().addListener((ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) -> {
            totalPriceLabel.setText(String.format("Total Cost: $%.2f",newValue));
        });



        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> this.close());

        vbox.getChildren().addAll(title, itemList, totalPriceLabel, closeButton);

        Scene scene = new Scene(hBox, 600, 600);
        this.setScene(scene);




    }


}
