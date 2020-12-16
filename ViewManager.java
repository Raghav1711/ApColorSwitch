 package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
//import view.ViewManager;
import Model.ColorSwitchButton;
import Model.ColorSwitchSubscene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.image.Image;

//import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ViewManager extends Application{
    private static final int WIDTH=800;
    private static final int HEIGHT=600;
    private AnchorPane mainPane;
    private Scene mainScene;
    private Stage mainStage;
    private final static int MENU_BUTTONS_START_X=100;
    private final static int MENU_BUTTONS_START_Y=150;
    private ColorSwitchSubscene creditsSubScene;
    private ColorSwitchSubscene helpSubScene;
    private ColorSwitchSubscene scoreSubScene;
    private ColorSwitchSubscene startSubScene;
    private ColorSwitchSubscene sceneToHide;
    private ArrayList<Game> glist;

    List<ColorSwitchButton> menubuttons;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws EOFException {

        File file = new File("listData");
        if(file.length()>0)
        {
            glist=deSerialize();
        }
        else {
            glist = new ArrayList<Game>();
        }
        FXMLController.glist=this.glist;
        menubuttons=new ArrayList<>();
        mainPane=new AnchorPane();
        mainScene=new Scene(mainPane,WIDTH,HEIGHT);
        mainStage=new Stage();
        mainStage.setScene(mainScene);
        //createButton();
        //createBackground();

        //ViewManager manager =new ViewManager();
//        primaryStage=mainStage;
//        primaryStage.show();
        ColorSwitchButton startButton =new ColorSwitchButton("PLAY");
        addMenuButton(startButton);
        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                //showSubScene(startSubScene);     SHOWWWWWWWWWWW SUBSCENEEEEEEEEEEEEEEE COMMENTEDDDDDD
                System.out.println("before constuctor");
                PlayerNameScreen playerName=new PlayerNameScreen(mainStage);
               //MainScreen mainScreen=new MainScreen();         1111111
                playerName.createNewGame(mainStage);
                System.out.println("after constuctor");
               //mainScreen.createNewGame(mainStage);          2222222
                //   mainStage.hide();
//                System.out.println(tempStage.toString());
                //prim
               // primaryStage.hide();

                //tempStage.show();

            }
        });

        createButton();
        createBackground();

        //ViewManager manager =new ViewManager();
        primaryStage=mainStage;
        primaryStage.show();
//        createBackground();
//
//        //ViewManager manager =new ViewManager();
//        primaryStage=mainStage;
//        primaryStage.show();
    }

//    public Stage getMainStage()
//    {
//        return mainStage;
//    }

    private void showSubScene(ColorSwitchSubscene subScene)
    {
        if(sceneToHide != null)
        {
            sceneToHide.moveSubScene();
        }
        subScene.moveSubScene();
        sceneToHide=subScene;
    }

    private void addMenuButton(ColorSwitchButton button)
    {
        button.setLayoutX(MENU_BUTTONS_START_X);
        button.setLayoutY(MENU_BUTTONS_START_Y + menubuttons.size() * 100);
        menubuttons.add(button);
        mainPane.getChildren().add(button);
    }

    private void createButton()
    {
//        Button button =new Button();
//        button.setLayoutX(100);
//        button.setLayoutY(100);
//        mainPane.getChildren().add(button);
//
//        button.setOnMouseEntered(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent mouseEvent) {
//                System.out.println("Mouse");
//            }
//        });

//        ColorSwitchButton button =new ColorSwitchButton("Click here");
//        mainPane.getChildren().add(button);

        //createStartButton();
        createCreditsButton();
        createScoresButton();
        createHelpButton();
        createExitButton();
        createLogo();
        createSubScenes();
//        ColorSwitchSubscene subScene= new ColorSwitchSubscene();
//        subScene.setLayoutX(200);
//        subScene.setLayoutY(100);
//        mainPane.getChildren().add(subScene);

    }

    public ArrayList<Game> deSerialize() throws EOFException {
        ArrayList<Game> namesList = new ArrayList<Game>();

        Game g = null;
        try
        {

            FileInputStream fis = new FileInputStream("listData");
            File file = new File("listData_1");
            System.out.println(file.length() + " bytes");


            ObjectInputStream ois = new ObjectInputStream(fis);

            namesList = (ArrayList<Game>) ois.readObject();



            ois.close();
            fis.close();
            System.out.println("Deserialized !");
            return namesList;
        }
        catch (IOException ioe)
        {
            //System.out.println("EMPTY FILE");
            ioe.printStackTrace();
        }
        catch (ClassNotFoundException c)
        {
            System.out.println("Class not found");
            c.printStackTrace();
            //return;
        }
        return namesList;
    }

    private void createSubScenes()
    {
        ListView listView = new ListView();
        listView.setPrefSize(570,300);
        listView.setLayoutX(15);
        listView.setLayoutY(15);

        listView.getItems().add("Item 1");
        listView.getItems().add("Item 2");
        listView.getItems().add("Item 3");


        //HBox hbox = new HBox(listView);


        creditsSubScene=new ColorSwitchSubscene();
        mainPane.getChildren().add(creditsSubScene);
        ColorSwitchButton loadButton1 =new ColorSwitchButton("Load");
        loadButton1.setLayoutX(50);
        loadButton1.setLayoutY(325);
        Pane tempPane= creditsSubScene.getRootPane();

        tempPane.getChildren().add(listView);
        tempPane.getChildren().add(loadButton1);


        ColorSwitchButton loadButton2 =new ColorSwitchButton("Delete");
        loadButton2.setLayoutX(350);
        loadButton2.setLayoutY(325);
        loadButton2.setPrefSize(180,0);
        //Pane tempPane2= creditsSubScene.getRootPane();
        tempPane.getChildren().add(loadButton2);

//        ColorSwitchButton loadButton3 =new ColorSwitchButton("Load Game-3");
//        loadButton3.setLayoutX(200);
//        loadButton3.setLayoutY(275);
//        tempPane.getChildren().add(loadButton3);

        helpSubScene=new ColorSwitchSubscene();
        mainPane.getChildren().add(helpSubScene);
        Label label =new Label("Your goal is to collect maximum stars\n while surviving the obstacles. \nYou can pass through the \nobstacles only when the color \nof the ball matches the color of \n the obstacle.");
        //label.setTextAlignment(TextAlignment.CENTER);
//        label.setTranslateX(150);
//        label.setTranslateY(25);
       // label.relocate
        Pane tempPane2= helpSubScene.getRootPane();
        tempPane2.getChildren().add(label);
        label.setTextFill(Color.web("Yellow"));
        label.setFont(new Font("Arial", 32));

        label.relocate(35,55);
       // tempPane2.getChildren.add(label);

        scoreSubScene=new ColorSwitchSubscene();
        mainPane.getChildren().add(scoreSubScene);

        TableView tab = new TableView();
        tab.setPrefSize(600,400);

        TableColumn nameColumn = new TableColumn("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameColumn.getStyleClass().add("Times New Roman,100");
        nameColumn.setMinWidth(450);


        TableColumn pointsColumn = new TableColumn("Points");
        pointsColumn.setCellValueFactory(new PropertyValueFactory<>("points"));
        pointsColumn.setMinWidth(150);

        tab.getColumns().addAll(nameColumn, pointsColumn);
        scoreSubScene.getRootPane().getChildren().add(tab);
        Player a=new Player("AA",200);
        tab.getItems().add(a);
        System.out.println(tab.getColumns().size());

        startSubScene=new ColorSwitchSubscene();
        mainPane.getChildren().add(startSubScene);
    }

    private void createStartButton()
    {
//        ColorSwitchButton startButton =new ColorSwitchButton("PLAY");
//        addMenuButton(startButton);
//        startButton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//
//                //showSubScene(startSubScene);     SHOWWWWWWWWWWW SUBSCENEEEEEEEEEEEEEEE COMMENTEDDDDDD
//                MainScreen mainScreen=new MainScreen();
//               Stage tempStage;
//                tempStage=mainScreen.getMainStage();
//             //   mainStage.hide();
////                System.out.println(tempStage.toString());
//                //prim
//                tempStage.show();
//
//            }
//        });
    }

    private void createScoresButton()
    {
        ColorSwitchButton scoresButton =new ColorSwitchButton("SCORES");
        addMenuButton(scoresButton);
        scoresButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                showSubScene(scoreSubScene);
            }
        });
    }

    private void createHelpButton()
    {
        ColorSwitchButton helpButton =new ColorSwitchButton("HELP");
        addMenuButton(helpButton);
        helpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                showSubScene(helpSubScene);
            }
        });
    }

    private void createCreditsButton()
    {
        ColorSwitchButton creditsButton =new ColorSwitchButton("LOAD GAMES");
        addMenuButton(creditsButton);

        creditsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                showSubScene(creditsSubScene);
            }
        });
    }

    private void createExitButton()
    {
        ColorSwitchButton exitButton =new ColorSwitchButton("EXIT");
        addMenuButton(exitButton);

        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                mainStage.close();
            }
        });
    }

    private void createBackground()
    {
        Image backgroundimage=new Image("view/resources/neonBlue.png",256,256,false,true);
        BackgroundImage background= new BackgroundImage(backgroundimage, BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,null);
        mainPane.setBackground(new Background(background));
    }

    private void createLogo()
    {
        ImageView logo =new ImageView("view/resources/Color.png");
        logo.setLayoutX(550);
        logo.setLayoutY(15);
        logo.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                logo.setEffect(new DropShadow());
            }
        });

        logo.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                logo.setEffect(null);
            }
        });
        mainPane.getChildren().add(logo);
    }
}
