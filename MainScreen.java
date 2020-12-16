package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

//import javax.swing.JFrame;
//import javax.print.attribute.standard.Media;

//import javax.swing.text.html.ImageView;

//import javax.swing.text.html.ImageView;

//public static final int SCREEN_WIDTH = 475;
// public static final int SCREEN_HEIGHT = 660;



public class MainScreen {
    Stage primary2Stage;
    Stage mainstage;
    Pane root;
    MediaPlayer mediaPlayer;
    Media media;
    String BGG;
    Game g;
    String player;


    public MainScreen(String name, Stage menuStage,String BGG,String player) throws EOFException {


         primary2Stage=menuStage;
         System.out.println(primary2Stage==null);
         System.out.println("cvhbjnkb v");
         //root = new Pane();
         //createBackground();
        this.BGG=BGG;
        this.player=player;

//        Game g =  new Game(name,this,BGG);
        g =deSerialize();
        g.construct(this);
        root=g.getPane();
        Label lab =new Label("Pts:0");
        lab.setFont(Font.font("Cambria", 48));
        lab.setPrefSize(150,50);
        lab.setLayoutY(20);
        lab.setLayoutX(1200-225);
        lab.setTextFill(Color.WHITE);
        root.getChildren().add(lab);
        //root.setStyle("-fx-background-color #000000;");
        root.setStyle("-fx-background-color: rgba(1, 1, 1, 1);");   //commmmeeented
        Scene scene = new Scene(root, 1275   , 660);
        FXMLController.scene=scene;
        primary2Stage.setTitle("Color Switch Game!");
        primary2Stage.setScene(scene);
        String path = "C:/Users/Asus/Downloads/Blinding.mp3";
        //Media media = new Media(new File(path).toURI().toString());
        media = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(media);

        //by setting this property to true, the audio will be played
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.setAutoPlay(true);


        //primary2Stage.show();





        scene.setOnKeyPressed(e -> {

            Pane pause = null;
            try {
                pause = FXMLLoader.load(getClass()
                        .getResource("FXML.fxml"));
                //background: rgba(76, 175, 80, 0.3);
                // pause.setStyle("-fx-background: transparent; -fx-background-color: transparent; ");
            } catch (IOException ex) {
                Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (e.getCode() == KeyCode.E) {
                if(g.game_state == 1) g.ball.jump();
                else if(g.game_state == 3){
                    g.game_state = 1;
                    g.ball.jumpLite();
                    //g.ball.jump();
                }
            }else if (e.getCode() == KeyCode.ESCAPE) {
                g.game_state = 0;
                //  root.setEffect(new GaussianBlur());

                // Color_switch.jpg  -fx-background-image
                pause.setStyle("-fx-background-color: transparent; -fx-background-image: url('view/resources/Color_switch.jpg');");
                // pause.setStyle("-fx-background: transparent; -fx-background-color: transparent; ");
//                Stage popupStage = new Stage(StageStyle.TRANSPARENT);
//                popupStage.initOwner(primary2Stage);
//                popupStage.initModality(Modality.APPLICATION_MODAL);

                primary2Stage.setScene(new Scene(pause));
                //primary2Stage.setX(primary2Stage.getWidth()/2);
                //primary2Stage.getScene().getRoot().setEffect(new GaussianBlur());
                //primary2Stage.setWidth(1024);

                //FXMLController f = new FXMLController(root, g, popupStage);
//            popupStage.setX(scene.getX());
//            popupStage.setY(scene.getY());
//            popupStage.show();
                //pause.get
//
//            }
            }
        });


        }

        public Game getGame()
        {
            return g;
        }


    public void createNewGame(Stage mainstage)
    {
        this.mainstage=mainstage;
        this.mainstage.close();
        //createBackground();
        mediaPlayer.setAutoPlay(true);
         primary2Stage.show();

    }

    public Stage getMainStage()
    {
        return primary2Stage;
    }

//    public Game deSerialize() throws EOFException {
//        ArrayList<Game> namesList = new ArrayList<Game>();
//
//        Game g = null;
//        try
//        {
//
//            FileInputStream fis = new FileInputStream("listData");
//            File file = new File("listData_1");
//            System.out.println(file.length() + " bytes");
//
//
//            ObjectInputStream ois = new ObjectInputStream(fis);
//
//            g = (Game) ois.readObject();
//
//
//
//            ois.close();
//            fis.close();
//            System.out.println("Deserialized !");
//            return g;
//        }
//        catch (IOException ioe)
//        {
//            //System.out.println("EMPTY FILE");
//            ioe.printStackTrace();
//        }
//        catch (ClassNotFoundException c)
//        {
//            System.out.println("Class not found");
//            c.printStackTrace();
//            //return;
//        }
//        return g;
//    }

}
