package view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FXML_1Controller implements Initializable {

    @FXML
    private Button resumeBt;
    @FXML
    private Button exitBt;
    static Stage stage1;
    static Stage stage2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }


    @FXML
    private void resumeEntered(MouseEvent event) {
        //       System.out.println("hello");
        resumeBt.setTextFill(Color.YELLOW);
    }





    @FXML
    private void action(ActionEvent event) {
        System.out.println("hello");
    }

    @FXML
    private void mouseExited(MouseEvent event) {
        resumeBt.setTextFill(Color.WHITE);
    }

    @FXML
    private void exit(ActionEvent event) {
        stage1.close();
        stage2.close();
    }

}