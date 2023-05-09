import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class MyPaymentForm extends PaymentForm {

    @Override
    public void completePayment(String cardNumber, String cvv, String name, String surname, String dueDate) {
        boolean isValid = validateNumber(cardNumber);
        if (isValid){
            System.out.println("Payment Completed!");
            getInformationAlert().show();

        }
        else{
            getWarningAlert().show();
        }


    }

    private static boolean validateNumber(String number) {

        //omitting blanks
        String actualNumber = "";

        for(int i = 0;i<number.length();i++) {
            if(number.charAt(i)!= ' ') {
                actualNumber +=number.charAt(i);
            }
        }

        int length = actualNumber.length();

//use array for summing even digits
        int[] seconds = new int[length/2];

        for (int i=length-2,a=length/2-1; i>=0 ; i -= 2,a--) {

            seconds[a] = actualNumber.charAt(i)-'0';

        }


        //summing even ones
        int sumSeconds=0;
        for (int i=0; i<seconds.length;i++) {
            if (seconds[i]*2<10) {
                seconds[i]= seconds[i]*2;
            }
            else if(seconds[i]*2>=10) {
                seconds[i] = seconds[i]*2 -9;
            }

            sumSeconds += seconds[i];
        }
        //find d number
        String dNumber = "";

        for (int i =0; i<length;i++) {
            if (length%2==0) {
                if(i%2==0) {
                    dNumber += actualNumber.charAt(i);
                }else {
                    dNumber += "_";
                }
            }else {
                if(i%2==0) {
                    dNumber += "_";
                }else {
                    dNumber += actualNumber.charAt(i);;
                }
            }
        }

        //find l number
        String lNumber = "";
        for (int i = 0; i<length;i++) {
            int a = i/2;
            if (length%2==0) {
                if(i%2==0) {
                    lNumber += ""+seconds[a];
                }else {
                    lNumber+= actualNumber.charAt(i);
                }
            }else {
                if(i%2==0) {
                    lNumber += actualNumber.charAt(i);
                }else {
                    lNumber +=""+seconds[a];
                }
            }
        }
        //summing odds
        int[] odds = new int[(length+1)/2];
        for (int i=length-1,a=odds.length-1;i>=0;i-=2,a--) {
            odds[a] = actualNumber.charAt(i)-'0';

        }
        int sumodds = 0;
        for(int i =0;i<odds.length;i++) {
            sumodds+=odds[i];
        }
        //print d and l numbers
        /*
        System.out.println("DNumber: "+dNumber);
        System.out.println("LNumber: "+lNumber);


         */
        //check the validity
        if((sumodds+sumSeconds)%10==0) {
            return true;
        }else {
            return false;
        }
    }

    private static Alert getInformationAlert(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("Payment");
        alert.setContentText("Payment is completed!\nThe program will restart!");
        alert.showAndWait();

        if(alert.getResult()== ButtonType.OK){

            try{
                //Restarting the program
                Main.showProgram(new Stage());
                Stage stage = (Stage) Main.basket.getScene().getWindow();
                stage.close();

            }catch (Exception e){

            }


        }

        return alert;
    }
    private static Alert getWarningAlert(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("Credit Card");
        alert.setContentText("Invalid credit card number!");

        alert.showAndWait();
        return alert;
    }
}
