import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public abstract class PaymentForm extends VBox {

    private TextField cardNumberField;
    private TextField cvvField;
    private TextField nameField;
    private TextField surnameField;
    private DatePicker dueDatePicker;

    private Label errorlabel;
    public PaymentForm() {
        this.setPadding(new Insets(10));
        this.setAlignment(Pos.TOP_CENTER);

        Label cardNumberLabel = new Label("Card Number:");
        cardNumberField = new TextField();
        this.getChildren().addAll(cardNumberLabel, cardNumberField);

        Label cvvLabel = new Label("CVV:");
        cvvField = new TextField();
        this.getChildren().addAll(cvvLabel, cvvField);

        Label nameLabel = new Label("Name:");
        nameField = new TextField();
        this.getChildren().addAll(nameLabel, nameField);

        Label surnameLabel = new Label("Surname:");
        surnameField = new TextField();
        this.getChildren().addAll(surnameLabel, surnameField);

        Label dueDateLabel = new Label("Due Date:");
        dueDatePicker = new DatePicker();
        this.getChildren().addAll(dueDateLabel, dueDatePicker);

        errorlabel = new Label();
        this.getChildren().add(errorlabel);

        Button payButton = new Button("Pay");
        payButton.setOnAction(e -> {

            String cardNumber="";
            String cvv ="";
            String name ="";
            String surname ="";
            String dueDate =null;

            try{
                cardNumber = getCardNumber();
                cvv = getCvv();
                name = getName();
                surname = getSurname();
                dueDate=getDueDate();




                if(cardNumber.equals("")||cvv.equals("")||name.equals("")||surname.equals("")){
                    throw new NullException("Any of fields could be null!!");
                }



                if(!containsOnlyDigits(cardNumber))
                    throw new Exception("Card number should contains only digits!");

                if(!containsOnlyDigits(cvv))
                    throw new Exception("CVV number should contains only digits!");
                if(!containsOnlyLetters(name))
                    throw new Exception("Name  should contains only letters!");
                if(!containsOnlyLetters(surname))
                    throw new Exception("Surname number should contains only letters!");

                if(dueDate==null){
                    throw new Exception("Due date cannot be blank!");
                }


                completePayment(cardNumber, cvv, name, surname, dueDate);

            }catch (Exception exception){
                errorlabel.setText(exception.getMessage());
                System.out.println(exception.getMessage());
            }


        });
        this.getChildren().add(payButton);
    }

    public abstract void completePayment(String cardNumber, String cvv, String name, String surname, String dueDate);
    public String getCardNumber() {
        return cardNumberField.getText();
    }

    public String getCvv() {
        return cvvField.getText();
    }

    public String getName() {
        return nameField.getText();
    }

    public String getSurname() {
        return surnameField.getText();
    }

    public String getDueDate() {
        String str="";
        try {
            str =dueDatePicker.getValue().toString();
        }catch (NullPointerException e){
            str =null;
        }
        return str;
    }

    private static boolean containsOnlyDigits(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
    private static boolean containsOnlyLetters(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }
}
