package view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author prash
 */
public class FXMLController implements Initializable {

    @FXML
    private Button resumeBt;
    @FXML
    private Button restartBt;
    @FXML
    private Button saveBt;
    @FXML
    private Button exitBt;
    public static Scene scene;
    public static Game g;
    public static ArrayList<Game> glist;
    /**
     * Initializes the controller class.
     * @param
     */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void hover(MouseEvent event) {

        resumeBt.setAlignment(Pos.TOP_RIGHT);


    }

    @FXML
    private void hoverExit(MouseEvent event) {
        resumeBt.setAlignment(Pos.CENTER);

    }

    @FXML
    private void startGame(ActionEvent event) {
        Stage w = (Stage) resumeBt.getScene().getWindow();
        w.setScene(FXMLController.scene);
        g.game_state = 1;
        g.setupTimeline();
    }

    @FXML
    private void saveGame(MouseEvent event) {
        System.out.println("Saving...");
        glist.add(g);
        // Save file
        try
        {
            //g.game_state = 3;
            FileOutputStream fos = new FileOutputStream("listData",false);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            for(int i = 0; i < g.object_manager.arr.size(); i ++){
//                try{
//                    oos.writeObject(g.object_manager.arr.get(i));
//                }
//                catch (Exception e){
//                    System.out.println(g.object_manager.arr.get(i).getClass() + " " + i);
//
//                  throw e;
//                }
//            }
            oos.writeObject(glist);
            oos.close();
            fos.close();
            System.out.println("Saved !");
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }


}