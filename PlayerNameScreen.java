package view;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.EOFException;

public class PlayerNameScreen {

    Stage primary3Stage;
    Stage main2stage;
    String name;
    String a;
    int BG;
    private final static String BACKGROUND_IMAGE = "view/resources/bLine.jpg";
    private final static String BACKGROUND_IMAGE_2 = "view/resources/backline3.png";


        public PlayerNameScreen(Stage menuStage) {
            primary3Stage=new Stage();

            primary3Stage.setTitle("New Player");
            Stage popUp=new Stage(StageStyle.TRANSPARENT);
            Image image = new Image("view/resources/Name.png");
            BackgroundImage backgroundimage = new BackgroundImage(image,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.DEFAULT,
                    BackgroundSize.DEFAULT);

            Background background = new Background(backgroundimage);

            Label labelfirst= new Label("Enter your UserName");
            labelfirst.setFont(Font.font("Cambria", 24));
            labelfirst.setTextFill(Color.web("#0076a3"));
            Label label= new Label();

            Label labelfirst2= new Label("Select Background");
            labelfirst2.setFont(Font.font("Cambria", 24));
            labelfirst2.setTextFill(Color.web("#0076a3"));

            ImageView backgroundImage1 = new ImageView(BACKGROUND_IMAGE);
            backgroundImage1 .setFitHeight(80);

            ImageView backgroundImage2 = new ImageView(BACKGROUND_IMAGE_2);
            backgroundImage2 .setFitHeight(180);
            //view.setPreserveRatio(true);
//            TextField text2= new TextField();
//            //String a =text2.getText();
//            BG=Integer.parseInt(text2.getText());
//            //BG=(int)text2.getText();
//            text2.setPrefWidth(200);
//            text2.setMaxWidth(200);

            Button button= new Button("Submit");
            button.setStyle("-fx-border-color: #ff0000; -fx-border-width: 5px;");
            TextField text= new TextField();
//            name=text.getText();
            text.setPrefWidth(200);
            text.setMaxWidth(200);

            TextField text2= new TextField();
            //String a =text2.getText();
            //BG=Integer.parseInt(text2.getText());
            //BG=(int)text2.getText();
            //int foo;
            try {
//                a=text2.getText();
//                BG=Integer.parseInt(a);
            }
            catch (NumberFormatException e)
            {
                BG = 1;
            }
            text2.setPrefWidth(200);
            text2.setMaxWidth(200);
            button.setOnAction(e ->
                    {

                        //label.setText("The name you entered is " + text.getText());   print name commmmmentedddddddddd
                        name=text.getText();
                        a=text2.getText();
                        MainScreen mainScreen= null;
                        try {
                            mainScreen = new MainScreen(name,menuStage,a,name);
                        } catch (EOFException ex) {
                            ex.printStackTrace();
                        }
                        mainScreen.createNewGame(primary3Stage);
                        popUp.close();
                    }
            );

            VBox layout= new VBox(8);
            layout.setBackground(background);

            layout.getChildren().addAll(labelfirst, text, labelfirst2,text2,backgroundImage1, backgroundImage2 , button, label);
            layout.setAlignment(Pos.CENTER);
            layout.setSpacing(25);


            Scene scene1= new Scene(layout, 500, 500);

             popUp.initOwner(primary3Stage);
             popUp.initModality(Modality.APPLICATION_MODAL);
             popUp.setScene(scene1);
            primary3Stage.setScene(scene1);

            primary3Stage.show();
        }

    public void createNewGame(Stage mainstage)
    {
        this.main2stage=mainstage;
        //this.main2stage.hide();
        primary3Stage.show();
    }


}
