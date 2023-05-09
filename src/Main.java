import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.util.ArrayList;

public class Main extends Application {
    static Basket basket;


    @Override
    public void init() throws Exception {
    super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        showProgram(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static ArrayList<Item> getItems(){

        ArrayList<Item> list = new ArrayList<>();

        list.add(new Item("Kraker ",0.5,"images/kraker.jpeg"));
        list.add(new Item("Cips ",1,"images/cips.jpg"));
        list.add(new Item("Kola ",1.4,"images/kola.jpg"));
        list.add(new Item("Dondurma ",1.5,"images/dondurma.jpg"));
        list.add(new Item("Peynir ",3.6,"images/peynir.jpg"));
        list.add(new Item("Yumurta ",10,"images/yumurta.jpg"));
        list.add(new Item("Tavuk ",15,"images/tavuk.jpg"));
        list.add(new Item("Et ",20,"images/et.jpg"));
        list.add(new Item("Susam ",0.3,"images/susam.jpg"));
        list.add(new Item("Çiğ Köfte ",5,"images/cigkofte.jpg"));

        return list;
    }

    public static void addingItemToBasketMain(Item item){
        Item temp = new Item(item.getName(),item.getPrice(), item.imageURLtemp);

        basket.addToBasket(temp);
    }

    public static void showProgram(Stage primaryStage){
        LoginScreen.loginScreen(primaryStage);
    }
    protected static Button getContinueWithPayOption(Stage primaryStage) {
    Button button = new Button("continue with payment");
    button.setOnAction(e->{

        Payment payment = new Payment(primaryStage,basket);
        payment.show();
    });
    button.setAlignment(Pos.CENTER_RIGHT);
    return button;
    }
}
