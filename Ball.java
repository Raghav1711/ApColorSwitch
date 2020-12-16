package view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

/**
 *
 * @author prash
 */
public class Ball implements Serializable{
    public static final long serialVersionUID =2094505223247207589L;

    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */

    private double x_position;
    private double y_position;
    private String col;
    private double y_speed ;
    private transient Ellipse e;
    public double  dummyx;
    public double dummyy;


    private final double radius = 9f;

    public static final float GRAVITY =  0.275f;

    public Ball(List pList){

        col = "RED";
        y_speed = 0;
        x_position = 1275/2;
        y_position = 490;
        e = new Ellipse(x_position, y_position, radius, radius);
        e.setFill(javafx.scene.paint.Color.RED);
        pList.add(e);
    }

    public void construct(List pList){
        //this.setColor("GREEN");
        Color p = null;
        if(col.equals("RED")) p = Color.RED;
        else if(col.equals("GREEN")) p = Color.GREEN;
        else if(col.equals("BLUE")) p = Color.BLUE;
        else p = Color.YELLOW;
        e = new Ellipse(x_position, y_position, radius, radius);
        e.setFill(p);
        pList.add(e);
    }

    public Ellipse getDiagram(){
        return e;
    }

    public double getXPosition() {
        return x_position;
    }
    public double getRadius() {
        return radius;
    }

    public void setXPosition(double x_position) {
        this.x_position = x_position;
    }

    public double getYPosition() {
        return y_position;
    }

    public void setYPosition(double y_position) {
        this.y_position = y_position;
    }

    public Color getColor() {
        if(col.equals("BLUE")) return(Color.BLUE);
        else if(col.equals("RED")) return(Color.RED);
        else if(col.equals("GREEN")) return(Color.GREEN);
        return(Color.YELLOW);


    }

//    public void setColor(Color color) {
//        this.col = color;
//    }

    public double getYSpeed() {
        return y_speed;
    }

    public void setYSpeed(double y_speed) {
        this.y_speed = y_speed;
    }

    public void update(){
        if(col.equals("BLUE")) e.setFill(Color.BLUE);
        else if(col.equals("RED")) e.setFill(Color.RED);
        else if(col.equals("GREEN")) e.setFill(Color.GREEN);
        else if(col.equals("YELLOW")) e.setFill(Color.YELLOW);

        if( y_position >= 650){
            y_speed = 0;
            y_position = 650;
        }
        else{
            y_speed = y_speed + GRAVITY;
            dummyy = dummyy + y_speed;
        }
        if(dummyy > 330){
            y_position = dummyy;
        }
        if(dummyy <= 330 && y_speed > 0){
            dummyy = y_position;
        }
        e.setCenterX(x_position);
        e.setCenterY(y_position);
    }


    /*public void draw(Graphics g){
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int x = (int) (x_position - ((int) radius / 2));
        int y = (int) (y_position - ((int) radius / 2));

        g.setColor(col);
        g.fillOval( x ,  y, (int) radius, (int) radius);

    }*/

    public void jump(){
        y_speed = -6;
        dummyy = dummyy + y_speed;

    }
    public void jumpLite(){
        y_speed = -2;
        dummyy = dummyy + y_speed;

    }

    void setColor(String color) {
        this.col = color;
    }

}
