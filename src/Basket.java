import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class Basket extends VBox implements Visible {

    private  ObservableList<Item> basketItems;
    private DoubleProperty totalPrice = new SimpleDoubleProperty(0.0);


    public Basket(){

        basketItems = FXCollections.observableArrayList();

        setSpacing(10);
        setAlignment(Pos.TOP_RIGHT);



        this.getChildren().add(getTotalPriceLabel());
    }

    public  void addToBasket(Item item){

        if(basketItems.size()>20){
            System.out.println("Cannot add more than 20 items!");
            return;
        }
        this.setAlignment(Pos.CENTER);
        basketItems.add(item);
        totalPrice.set(totalPrice.get()+item.getPrice());

        this.getChildren().remove(this.getChildren().size()-1);
        this.getChildren().add(new Label(item.toString()));
        this.getChildren().add(getTotalPriceLabel());

    }

    public DoubleProperty totalPriceProperty(){
        return totalPrice;
    }
    public  double getTotalPrice(){
        return totalPrice.get();
    }

    private  Label getTotalPriceLabel(){

        Label label = new Label();

        Text text = new Text(String.format("Total Cost: $ %.2f",getTotalPrice()));
        text.setFont(Font.font("Arial", FontWeight.BOLD,25));
        text.setTextAlignment(TextAlignment.CENTER);

        label.setGraphic(text);


        return label;
    }

    public ObservableList<Item> getBasketItems() {
        return basketItems;
    }


}
