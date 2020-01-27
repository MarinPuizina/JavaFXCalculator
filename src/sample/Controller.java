package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private Label result;
    private long numberOne = 0;
    private String operator = "";
    private boolean start = true;
    private Model model = new Model();

    @FXML
    public void processNumbers(ActionEvent actionEvent) {

        if(start) {
            result.setText("");
            start = false;
        }

        String value = ((Button)actionEvent.getSource()).getText();
        result.setText(result.getText() + value);

    }

    @FXML
    public void processOperators(ActionEvent actionEvent) {

        String value = ((Button)actionEvent.getSource()).getText();

        if(!value.equals("=")) {

            if(!operator.isEmpty())
                return;

            operator = value;
            numberOne = Long.parseLong(result.getText());
            result.setText("");

        } else {

            if(operator.isEmpty())
                return;

            long numberTwo = Long.parseLong(result.getText());
            float output = model.calculate(numberOne, numberTwo, operator);
            result.setText(String.valueOf(output));

            operator = "";
            start = true;

        }

    }

}
