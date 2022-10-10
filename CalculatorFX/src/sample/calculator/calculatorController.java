package sample.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class calculatorController {

    private String prevNumber = "";
    private String currentNumber = "";
    private String calculationSymbol = "";
    private double calculatedNumber;

    @FXML
    private TextField textField;
    // Action Event for buttons "/" "*" "-" "+" and "=" //
    @FXML
    void divideAction(ActionEvent event){
        calculationSetup("/");
    }

    @FXML
    void multiplicationAction (ActionEvent event){
        calculationSetup("*");
    }

    @FXML
    void minusAction (ActionEvent event){
        calculationSetup("-");
    }

    @FXML
    void plusAction (ActionEvent event){
        calculationSetup("+");
    }

    @FXML
    void calculateAction(ActionEvent event) {
        calculate();
    }
    // Calculation Setup and possibility to calulation w/o equal sign //
    public void calculationSetup (String calculation){
        if(prevNumber.equals("")) {
            this.calculationSymbol = calculation;
            prevNumber = currentNumber;
            currentNumber = "";
        }
        else{
            calculate();
            prevNumber = String.valueOf(calculatedNumber);
            currentNumber = "";
            this.calculationSymbol = calculation;
        }
    }
    // Calculator logic //
    public void calculate()
    {
        double firstNumberDouble = Double.parseDouble(prevNumber);
        double secondNumberDouble = Double.parseDouble(currentNumber);

        switch (calculationSymbol){
            case "/" -> {
                calculatedNumber = firstNumberDouble / secondNumberDouble;
                textField.setText(String.valueOf(calculatedNumber));
                currentNumber = String.valueOf(calculatedNumber);
                prevNumber = "";
            }
            case "*" -> {
                calculatedNumber = firstNumberDouble * secondNumberDouble;
                textField.setText(String.valueOf(calculatedNumber));
                currentNumber = String.valueOf(calculatedNumber);
                prevNumber = "";
            }
            case "-" -> {
                calculatedNumber = firstNumberDouble - secondNumberDouble;
                textField.setText(String.valueOf(calculatedNumber));
                currentNumber = String.valueOf(calculatedNumber);
                prevNumber = "";
            }
            case "+" -> {
                calculatedNumber = firstNumberDouble + secondNumberDouble;
                textField.setText(String.valueOf(calculatedNumber));
                currentNumber = String.valueOf(calculatedNumber);
                prevNumber = "";
            }
        }
    }
    // Refresh textField //
    public void updateTextField(){
        textField.setText(currentNumber);
    }
    // Save number from button to memory //
    public void addNumber (String number){
        currentNumber += number;
        updateTextField();
    }
    // Action Event for buttons 0-9 and C //
    @FXML
    void clearAction(ActionEvent event){
        currentNumber = "";
        prevNumber = "";
        textField.setText("");
    }

    @FXML
    void button1Clicked(ActionEvent event){
        addNumber("1");
    }

    @FXML
    void button2Clicked(ActionEvent event){
        addNumber("2");
    }

    @FXML
    void button3Clicked(ActionEvent event){
        addNumber("3");
    }

    @FXML
    void button4Clicked(ActionEvent event){
        addNumber("4");
    }

    @FXML
    void button5Clicked(ActionEvent event){
        addNumber("5");
    }

    @FXML
    void button6Clicked(ActionEvent event){
        addNumber("6");
    }

    @FXML
    void button7Clicked(ActionEvent event){
        addNumber("7");
    }

    @FXML
    void button8Clicked(ActionEvent event){
        addNumber("8");
    }

    @FXML
    void button9Clicked(ActionEvent event){
        addNumber("9");
    }

    @FXML
    void button0Clicked(ActionEvent event){
        if(!currentNumber.equals(""))
        addNumber("0");
    }
}
