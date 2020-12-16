package view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.scene.paint.Color;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.spacing
 */

/**
 *
 * @author prash
 */
public class ObjectManager implements Serializable{
    public static final long serialVersionUID = -7767775405697318957L;
    int k = 2;
    public int points = 1;
    private Ball ball;
    transient private List pList;
    public ArrayList<CollidableObject> arr ;
    Random rand = new Random();
    private final int CIRCLE = 0;
    private final int SQUARE = 1;

    public ArrayList<CollidableObject> getArr() {
        return arr;
    }
    private final int CROSS = 2;
    private final int TRIANGLE = 3;
    private final int CONCENTRIC_CIRCLE = 4;
    private final int ADJACENT_CIRCLE = 5;
    private final int LINE = 6;
    private final int TRIANGLE_CIRCLE = 7;
    public static final int SCREEN_WIDTH = 475;
    public static final int SCREEN_HEIGHT = 660;
    public static final int SPACING = 120;






    public ObjectManager(Ball ball, List pList){
        arr =  new ArrayList<>();

        this.ball = ball;
        this.pList = pList;

    }

    public void construct(List pList){
        this.pList = pList;
        for(int i = 0; i < arr.size(); i++){
            arr.get(i).construct(pList);
            if((ColorChanger.class.isInstance(arr.get(i)))){
                ColorChanger o1 = (ColorChanger) arr.get(i);
                if(o1.isAlreadyCollided()) arr.get(i).remove(pList);

            }

        }
        if(old_color.equals("RED")) old = Color.RED;
        else if(old_color.equals("GREEN")) old = Color.GREEN;
        else if(old_color.equals("BLUE")) old = Color.BLUE;
        else old = Color.YELLOW;

    }
    String old_color;
    transient Color old = Color.RED;
    public void createObstacle(){

        if(arr.isEmpty()){
            //Circle c = new Circle(225, 200, 100, 2, p);
            //arr.add(c);
            //k = k * - 1;
            //ball.getXPosition() - 50 - 6
            //ball.getXPosition() + 90 + 6
//            Circle c1 = new Circle(ball.getXPosition(), 300, 70, 1.5 , pList, 90);
//           Circle c2 = new Circle(ball.getXPosition(), 300 - 70 - 90 - 12, 90, - 1.5, pList, 180);
//           Circle c3 = new Circle(ball.getXPosition(), c2.getY_position() - 90 - 90 - 12, 90,  1.5, pList, 90);

            //Circle c1 = new Circle(225, 200, 57.80 - 24, 1, p, 90);

//            Star s = new Star(ball.getXPosition(), (Math.min(c1.getBounds()[0], c2.getBounds()[0], c3.getBounds()[0]) - 10) - 30, pList); 
//              Star s1 = new Star(c1.getX_position(), c1.getY_position(), pList);
//              Star s2 = new Star(c2.getX_position(), c2.getY_position(), pList);
//              Star s3 = new Star(c3.getX_position(), c3.getY_position(), pList);


            //arr.add(t1);


            Circle c1 = new Circle(ball.getXPosition() - 80 - 6.5, 300, 80, 1.5 , pList, 0);
            Circle c2 = new Circle(ball.getXPosition() + 80 + 6.5, 300, 80, - 1.5, pList, 90);
            arr.add(c1);
            arr.add(c2);
            Star s1 = new Star(ball.getXPosition(), Math.min(c1.getBounds()[0], c2.getBounds()[0]) - 10, pList);
            arr.add(s1);
//            arr.add(c3);
//            arr.add(s1); arr.add(s2); arr.add(s3);
        }
//       else {
//           Random rand = new Random();
//           int random = rand.nextInt(2);
//           CollidableObject last = arr.get(arr.size() - 1);
//           if(random == 0){   
//              Triangle t1 = new Triangle(ball.getXPosition(), last.getBounds()[0] - 200, 100, 1.5, pList);
//              k = k * - 1;
//              Star s = new Star(ball.getXPosition(), t1.getY_position() - 10, pList); 
//                arr.add(t1);
//                arr.add(s);
//           }
//           else{
//                Circle c1 = new Circle(225 - 70 - 6, last.getBounds()[0] - 200, 70, k, pList, 0);
//                Circle c2 = new Circle(225 + 120 + 6, last.getBounds()[0] - 200, 120, -k, pList, 270);
//                 Star s = new Star(ball.getXPosition() (Math.min(c1.getBounds()[0], c2.getBounds()[0]) - 30), pList); 
//                arr.add(c1);
//                arr.add(c2);
//                arr.add(s);
//           }
//           
//           
//           

        else
        {
            int col = rand.nextInt(3);
            //Color p = null;
            ArrayList<Color> color = new ArrayList<Color>();

            if(! old.equals(Color.BLUE)) color.add(Color.BLUE);
            if(! old.equals(Color.RED)) color.add(Color.RED);
            if(! old.equals(Color.YELLOW)) color.add(Color.YELLOW);
            if(! old.equals(Color.GREEN)) color.add(Color.GREEN);

            int obj = rand.nextInt(6);
            CollidableObject last1 = arr.get(arr.size() - 1);
            old = color.get(col);
            if(old.equals(Color.GREEN)) old_color = "GREEN";
            else if(old.equals(Color.BLUE)) old_color = "BLUE";
            else if(old.equals(Color.RED)) old_color = "RED";
            else old_color = "YELLOW";

            ColorChanger cChanger = new ColorChanger(ball.getXPosition(), last1.getBounds()[0] - SPACING, color.get(col), pList);

            arr.add(cChanger);
            if(obj == CIRCLE){

                Circle c1 = null, c2 = null, c3 = null, c4 = null;
                // CollidableObject last1 = arr.get(arr.size() - 1);
                int num = Math.min(10, rand.nextInt((int) (Math.ceil(this.points / 5.000))) + 1) ;
                //System.out.println(num);
                int orient = 0;
                if(cChanger.getColor().equals(Color.RED) || cChanger.getColor().equals(Color.GREEN)){
                    orient = 90;
                    // System.out.println("le");
                }
                double radius = Math.max(50, 100 - rand.nextInt(points) * 4);
                if(num >= 1) radius = radius + 15;
                int k = rand.nextInt(2);
                if(k == 0) k = -1;
                else k = 1;
                double speed = Math.min(3, points / 10.00000 + 0.9877 );
                if(num >= 1) {
                    c1 = new Circle(ball.getXPosition(), cChanger.getY_position() - 100 - radius, radius, k * speed, pList, orient);
                    Star s1 = new Star(c1.getX_position(), c1.getY_position(), pList);
                    arr.add(s1);
                    arr.add(c1);
                }
                if(num >= 2){
                    c2 = new Circle(ball.getXPosition(), c1.getY_position() - 2 * radius - 12, radius, -k * speed, pList, 90 + orient);
                    Star s1 = new Star(c2.getX_position(), c2.getY_position(), pList);
                    arr.add(s1);
                    arr.add(c2);
                }
                if(num >= 3){
                    c3 = new Circle(ball.getXPosition(), c2.getY_position() - 2 * radius - 12, radius, k * speed, pList, orient);
                    Star s1 = new Star(c3.getX_position(), c3.getY_position(), pList);
                    arr.add(s1);
                    arr.add(c3);
                }
                if(num >= 4) {
                    c4 = new Circle(ball.getXPosition(), c3.getY_position() - 2 * radius - 12, radius, -k * speed, pList, 90 + orient);
                    Star s1 = new Star(c4.getX_position(), c4.getY_position(), pList);
                    arr.add(s1);
                    arr.add(c4);
                }
                points = points + 1;
            }

            else if(obj == SQUARE){

                Square s = null;
                double length = 2 * Math.max(30, 100 - rand.nextInt(points + 1) * 5);

                k = rand.nextInt(2);
                if(k == 0) k = -1;
                else k = 1;
                double speed = Math.min(3, points / 10.00000 + 0.9877 );
                s = new Square(cChanger.getX_position(), cChanger.getY_position()  - 100 - length / Math.sqrt(2 ), length,  k * speed, pList);
                Star s1 = new Star(s.getX_position(), s.getY_position(),pList);
                arr.add(s1);
                arr.add(s);
                points = points + 1;

            }
            else if(obj == CROSS){
                Cross c = null;
                double length = 1.2 * Math.max(30, 100 - rand.nextInt(points + 1) * 5);
                double speed = Math.min(3, points / 10.00000 + 0.9877 );
                k = rand.nextInt(2);
                if(k == 0 && points > 10) k = -1;
                else k = 1;
                int num = rand.nextInt(2);

                c = new Cross(ball.getXPosition(), cChanger.getY_position() - length - 70, length, k * speed, pList, num );
                Star s1 = new Star(c.getX_position(), c.getY_position(),pList);
                arr.add(s1);
                arr.add(c);
                points++;
            }
            else if(obj == TRIANGLE){
                Triangle tri = null;
                String cols =  cChanger.getColorS();


                double length = 1.6 * Math.max(60, 100 - rand.nextInt(points + 1) * 5);
                double speed = Math.min(3, points / 10.00000 + 0.9877 );
                k = rand.nextInt(2);
                if(k == 0) k = -1;
                else k = 1;
                tri = new Triangle(ball.getXPosition(), cChanger.getY_position() - 60 - length, length, k * speed, pList, cols);
                Star s1 = new Star(tri.getX_position(), tri.getY_position(),pList);
                arr.add(s1);
                arr.add(tri);
                points++;
            }
            else if(obj == ADJACENT_CIRCLE){
                int num = Math.min(6, rand.nextInt((int)(Math.ceil(points / 10.00)))) + 1;

                double radius1 = rand.nextInt(40) + 60 ;
                double radius2 = rand.nextInt(40) + 60;
                double y = cChanger.getY_position() - 60 - Math.max(radius1, radius2);
                int orient = 0;
                if(cChanger.getColor().equals(Color.YELLOW) || cChanger.getColor().equals(Color.BLUE)){
                    orient = 90;


                }
                // System.out.println(orient + " " + cChanger.getColor());
                for(int i = 0; i < num; i++){

                    double speed = Math.min(4, points / 10.00000 + 0.98);
                    speed = Math.max(speed, 1.2);
                    if(points > 10)  k = rand.nextInt(2);
                    else k = rand.nextInt(1);
                    if(k == 0) k = -1;
                    else k = 1;
                    if(k == 1) speed = Math.min(2, speed);
                    Circle c1 = new Circle(ball.getXPosition() - radius1 - 6.5, y, radius1,  - k * speed, pList, orient);
                    Circle c2 = new Circle(ball.getXPosition() + radius2 + 6.5, y, radius2,   k * speed, pList, orient + 90);
                    Star s = new Star(ball.getXPosition(), Math.min(c1.getBounds()[0], Math.abs(c2.getBounds()[0])) - 30, pList);
                    arr.add(s); arr.add(c1); arr.add(c2);
                    //System.out.println(c2.getY_position());
                    radius1 = rand.nextInt(40) + 40 ;
                    radius2 = rand.nextInt(40) + 40;
                    y = s.getY_position() - Math.max(radius1, radius2) - 20;
                }
                points ++;

            }
            else if(obj == CONCENTRIC_CIRCLE){
                int num = rand.nextInt(2);
                if(points < 7 ) num = 0;
                int orient = 0;
                if(cChanger.getColor().equals(Color.YELLOW) || cChanger.getColor().equals(Color.BLUE)){
                    orient = 90;


                }

                Circle c1 = null; Circle c2 = null; Circle c3 = null;

                double radius = 1.5 * Math.max(60, 100 - rand.nextInt(points + 1) * 5);
                double speed = Math.min(3, points / 10.00000 + 0.9877 );
                k = rand.nextInt(2);
                if(k == 0) k = -1;
                else k = 1;
                c1 = new Circle(ball.getXPosition(), cChanger.getY_position() - radius - 60, radius, k * speed, pList, orient);
                Star s = new Star(ball.getXPosition(), c1.getY_position(), pList);
                arr.add(s);
                if(num == 0){

                    c2 = new Circle(ball.getXPosition(), cChanger.getY_position() - radius - 60, radius - 15, -k * speed, pList, orient + 90);

                    arr.add(c2); arr.add(c1);

                }
                else{

                    c2 = new Circle(ball.getXPosition(), cChanger.getY_position() - radius - 60, radius - 15, k * speed, pList, orient);
                    c3 = new Circle(ball.getXPosition(), cChanger.getY_position() - radius - 60, radius - 30, k * speed, pList, orient);
                    int sk = rand.nextInt(3);
                    if(sk == 0 ){
                        c1.setRot_speed(c1.getRot_speed() * -1);
                        c1.setOrientation(c1.getOrientation() + 90);
                    }
                    else if(sk == 1){
                        c2.setRot_speed(c2.getRot_speed() * -1);
                        c2.setOrientation(c2.getOrientation() + 90);
                    }
                    else{
                        c3.setRot_speed(c3.getRot_speed() * -1);
                        c3.setOrientation(c3.getOrientation() + 90);
                    }
                    arr.add(c3); arr.add(c2); arr.add(c1);
                }

                points++;
            }

            else if(obj == LINE){

                double speed = Math.min(3, points / 10.00000 + 0.9877 );
                Lines l = new Lines(ball.getXPosition(), cChanger.getY_position() - SPACING,60, speed, pList);
                Star s = new Star(l.getX_position(), l.getY_position(), pList);
                arr.add(s); arr.add(l);
            }

        }
    }










    public void update(){
        //System.out.println(arr.size());
        int c = 0;
        while(arr.size() < 25){

//            if(arr.size() > 0){
//                CollidableObject last = arr.get(arr.size() - 1);
//                ColorChanger cChanger = new ColorChanger(ball.getXPosition(), last.getBounds()[0] - 230, javafx.scene.paint.Color.BLUE, pList);
//               
//                arr.add(cChanger);
//            }
            createObstacle();
            //System.out.println(true);
        }
        //System.out.println(arr.size());
        for(int i = 0; i < arr.size(); i++){
            arr.get(i).updateObject();
            if(arr.get(i).isOutOfScreen()){
                //  arr.get(i).remove(p);
                arr.remove(i);

                //}
            }
        }

    }
    public void setYSpeed(double s){
        for(int i = 0; i < arr.size(); i++){
            arr.get(i).setYSpeed(s);
        }
    }

//    public void draw(Graphics g){
//         for(int i = 0; i < arr.size(); i++){
//            arr.get(i).draw(g);
//        }
//         
//    }

    public CollidableObject getCollidableObject(){
        for(int i = 0; i < arr.size(); i++){
            if(arr.get(i).isColllisionOccured(ball.getColor(), ball)){
                // System.out.println("true");

                return arr.get(i);
            }


        }
        //System.out.println("false");
        return null;
    }
}
