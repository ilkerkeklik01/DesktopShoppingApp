import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class Item extends VBox implements Visible{

    private String name;
    private double price;
    private Image image;

    public String imageURLtemp;

    public Item(String name, double price,String imageUrl) {
        imageURLtemp=imageUrl;
        this.name = name;
        this.price = price;
        this.setAlignment(Pos.CENTER);

        image = new Image(imageUrl);
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(150);
        imageView.setFitWidth(150);
        this.getChildren().addAll(imageView, new Label(name),new Label(String.format("$%.2f",price)));
        this.setSpacing(10);
        this.setAlignment(Pos.TOP_CENTER);

        Button button = new Button("Add to Basket");

        button.setOnAction(e -> Main.addingItemToBasketMain(this));

        this.getChildren().add(button);


    }



    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        double price = this.price;

        String str = this.name +" --> "+ (this.price);
        str = String.format("%s --> %.2f",this.name,this.price);
                return str;
    }

    public String getName() {
        return name;
    }

}
