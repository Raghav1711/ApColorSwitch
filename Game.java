package view;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.Serializable;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.StageStyle;


class Game implements Serializable{
    public static final long serialVersionUID = -2612304023252692176L;
    private String player;
    public ObjectManager object_manager;
    transient boolean iTsKeyPressed;
    public Ball ball;
    transient public Thread thread;
    transient Pane r;

    public static final int SCREEN_WIDTH = 475;
    public static final int SCREEN_HEIGHT = 660;
    transient List<Node> pList;
    private final int PAUSE_STATE = 0;
    private final int PLAY_STATE = 1;
    private final int OVER_STATE = 2;
    private final int START_STATE = 3;
    public int game_state = START_STATE;
    private Circle circle;
    transient MainScreen m;
    transient GridPane gridPane1;
    transient GridPane gridPane2;
    private final static String BACKGROUND_IMAGE2 = "view/resources/backline3.png";
    private final static String BACKGROUND_IMAGE = "view/resources/bLine.jpg";
    String BGGG;


    public Game(String player, MainScreen m,String BGGG){
        r = new Pane();
        this.BGGG=BGGG;
        pList = Collections.synchronizedList(r.getChildren());
        FXMLController.g = this;
        createBackground();
        this.player = player;
        ball = new Ball(pList);
        object_manager = new ObjectManager(ball, pList);


        this.setupTimeline();
        this.m = m;
    }
    public void construct(MainScreen m){

        object_manager.setYSpeed(0);
        game_state = 3;
        System.out.println(game_state);
        r = new Pane();

        this.pList = Collections.synchronizedList(r.getChildren());
        createBackground();
        ball.construct(pList);
        object_manager.construct(pList);
        // System.out.println("abcdf");
        FXMLController.g = this;
        setupTimeline();
        //this.game_state = PLAY_STATE;

        this.m = m;
    }

    public List<Node> getPList(){
        return pList;

    }
    public Pane getPane(){
        return r;
    }



    int  c = 0;
    transient public Timeline tm = null;
    public void setupTimeline(){

        tm = new Timeline(new KeyFrame(Duration.millis(17), (ActionEvent e) ->{

            try {

                // System.out.println(game_state);
                if(game_state == PLAY_STATE || game_state == START_STATE){
                    //long start = System.nanoTime();


                    update();
//                     c = c + 1;
//                     long end = System.nanoTime();
//                    System.out.println((end - start) / 1000000.0 + "  " + c);

                }
                //System.out.println("Helo");
                else if(game_state == OVER_STATE){
                    tm.stop();
                    try {
                        showGameOverMenu();
                    } catch (IOException ex) {
                        Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                else tm.stop();

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
        }));

        tm.setCycleCount(Animation.INDEFINITE);
        tm.play();
    }


    int points_1  = 0;
    public void update() throws ClassNotFoundException{

        if(game_state == PLAY_STATE){
            if(ball.dummyy < 330){
                object_manager.setYSpeed(ball.getYSpeed());
            }
            else{
                object_manager.setYSpeed(0);
            }
            //   System.out.println("yet");

            ball.update();
            moveBackground();

        }

        object_manager.update();



        CollidableObject o = (CollidableObject)object_manager.getCollidableObject();
        if(Obstacle.class.isInstance(o)) game_state = OVER_STATE;
        else if(ColorChanger.class.isInstance(o)){

            ColorChanger o1 = (ColorChanger) o;
            o1.setCollided(true);
            Color p = (Color) o1.getColor();
            String p1 = "";
            if(p.equals(Color.BLUE)) p1 = "BLUE";
            else if(p.equals(Color.RED)) p1 = "RED";
            else if(p.equals(Color.GREEN)) p1 = "GREEN";
            else  p1 = "YELLOW";


            ball.setColor(p1);
            o1.remove(pList);
            // object_manager.getArr().remove(o1);

        }

        else if(Star.class.isInstance(o)){
            System.out.println("true");

            Star o1 = (Star) o;
            if(object_manager.getArr().contains(o)){
                System.out.println(++points_1);
                object_manager.getArr().remove(o);
//
            }
            o1.remove(pList);



        }
    }

    private void createBackground() {


        gridPane1 = new GridPane();
        gridPane2 = new GridPane();
        if(BGGG.equals("2")) {


            System.out.println("BBBBBBBBBBBBBBBBBBBB");
            System.out.println("BGGG   "+BGGG);
            //System.out.println(BGGG);
            for (int i = 0; i < 12; i++) {
//            String b=BACKGROUND_IMAGE;
//            if(BGGG%2==1) {
//                 b=BACKGROUND_IMAGE;
//            }
//
//            else {
//                b=BACKGROUND_IMAGE2;
//            }
                //if(i%3!=1)
                //{
                ImageView backgroundImage1 = new ImageView(BACKGROUND_IMAGE2);
                ImageView backgroundImage2 = new ImageView(BACKGROUND_IMAGE2);
                GridPane.setConstraints(backgroundImage1, i % 3, i / 3);
                GridPane.setConstraints(backgroundImage2, i % 3, i / 3);
                //}
                gridPane1.getChildren().add(backgroundImage1);
                gridPane2.getChildren().add(backgroundImage2);
            }
        }
        else {

//            gridPane1 = new GridPane();
//            gridPane2 = new GridPane();
            System.out.println("VVVVVVVVVVVVVVVVVV");
            System.out.println("BGGG   "+BGGG);
            //System.out.println(BGGG%2==1);
            for (int i = 0; i < 12; i++) {
//            String b=BACKGROUND_IMAGE;
//            if(BGGG%2==1) {
//                 b=BACKGROUND_IMAGE;
//            }
//
//            else {
//                b=BACKGROUND_IMAGE2;
//            }
                //if(i%3!=1)
                //{
                ImageView backgroundImage1 = new ImageView(BACKGROUND_IMAGE);
                ImageView backgroundImage2 = new ImageView(BACKGROUND_IMAGE);
                GridPane.setConstraints(backgroundImage1, i % 3, i / 3);
                GridPane.setConstraints(backgroundImage2, i % 3, i / 3);
                //}
                gridPane1.getChildren().add(backgroundImage1);
                gridPane2.getChildren().add(backgroundImage2);
            }
        }

        gridPane2.setLayoutY(-1024);
        //this.r.getChildren().addAll(gridPane1, gridPane2);
        this.pList.add(0,gridPane1);
        this.pList.add(0,gridPane2);
    }

    private void moveBackground()
    {
        gridPane1.setLayoutY(gridPane1.getLayoutY() +0.5);
        gridPane2.setLayoutY(gridPane2.getLayoutY() +0.5);

        if(gridPane1.getLayoutY() >= 1024)
        {
            gridPane1.setLayoutY(-1024);
        }

        if(gridPane2.getLayoutY() >= 1024)
        {
            gridPane2.setLayoutY(-1024);
        }
    }

    public void showGameOverMenu() throws IOException{
        Pane pause = FXMLLoader.load(getClass().getResource("FXML_1.fxml"));
        pause.setStyle("-fx-background-image: url(\"Color_switch_1.jpg\"); -fx-background: transparent; -fx-background-color: transparent; -fx-border-color: #ffff00; ");
        m.getMainStage().getScene().getRoot().setEffect(new javafx.scene.effect.GaussianBlur());
        FXML_1Controller.stage1 = m.getMainStage();


        Stage popupStage = new Stage(StageStyle.TRANSPARENT);
        FXML_1Controller.stage2 = popupStage;
        popupStage.initOwner(m.getMainStage());
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.setScene(new Scene(pause, Color.TRANSPARENT));
        popupStage.show();
    }






//    public void keyPressed(KeyEvent e) {
//      /* if (e.getKeyCode() == KeyEvent.VK_W) {
//            if(ball.getYPosition() < 330){
//                object_manager.setYSpeed(-(10));
//                ball.setYSpeed(0);
//        }
//            else{
//                ball.jump();
//                System.out.println("DOM");
//            }
//	}*/
//      if (e.getKeyCode() == KeyEvent.VK_W){
//            ball.jump();
//      }




       /* else if(e.getKeyCode() == KeyEvent.VK_S){
            ball.setYSpeed(-10);
        }*/

    // }




    /*public void run() {
        int fps = 60;
		long msPerFrame = 1000 * 1000000 / fps;
		long lastTime = 0;
		long elapsed;

		int msSleep;
		int nanoSleep;

		long endProcessGame;
		long lag = 0;

		while (game_state == PLAY_STATE) {
            try {
                update();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
			repaint();
			endProcessGame = System.nanoTime();
			elapsed = (lastTime + msPerFrame - System.nanoTime());
			msSleep = (int) (elapsed / 1000000);
			nanoSleep = (int) (elapsed % 1000000);
			if (msSleep <= 0) {
				lastTime = System.nanoTime();
				continue;
			}
			try {
				Thread.sleep(msSleep, nanoSleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			lastTime = System.nanoTime();
		}
                JOptionPane.showMessageDialog(null, "Game Over");




	}

*/



}
