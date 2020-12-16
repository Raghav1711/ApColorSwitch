package view;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;
import javafx.scene.shape.Line;
import javafx.scene.shape.*;
import javafx.util.Duration;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author prash
 */
public class Triangle extends Obstacle{
    public static final long serialVersionUID = -2535082734714709639L;
    transient  private Timeline tm;
    private double length;
    private double rot_speed;



    public void setY_position(double y_position) {
        this.y_position = y_position;
    }
    double orientation1 = 90;
    private double orientation = (orientation1 + 90 + 60) % 360;
    transient Line l1, l2, l3;
    private final int THICKNESS = 12;
    transient Shape s1;
    String color = "";


    public Triangle(double x_pos, double y_pos, double length, double speed, List pList, String col) {
        super(x_pos, y_pos);
        this.color = col;
        Color p1 = null;
        if(col.equals("RED")) p1 = Color.RED;
        else if(col.equals("BLUE")) p1 = Color.BLUE;
        else if(col.equals("YELLOW")) p1 = Color.YELLOW;
        else p1 = Color.GREEN;
        Paint p2 = null; Paint p3 = null;
        ArrayList<Color> temp = new ArrayList<Color>();
        temp.add(Color.RED); temp.add(Color.GREEN); temp.add(Color.BLUE); temp.add(Color.YELLOW);
        temp.remove(p1);
        Random rand = new Random();
        temp.remove(rand.nextInt(3));
        p2 = temp.get(0); p3 = temp.get(1);
        this.length = length;
        double o = this.orientation;
        this.rot_speed = speed;
        l1 = new Line((length - 20) * Math.cos(Math.toRadians(o)) + x_pos, (length - 20) * Math.sin(Math.toRadians(o)) + y_pos,(length - 20) * Math.cos(Math.toRadians((o - 120) % 360)) + x_pos, (length - 20) * Math.sin(Math.toRadians(o - 120 % 360)) + y_pos);
        l2 = new Line(length * Math.cos(Math.toRadians(o - 120) % 360) + x_pos, (length) * Math.sin(Math.toRadians(o - 120) % 360) + y_pos, (length) * Math.cos(Math.toRadians((120 + o) % 360)) + x_pos, (length) * Math.sin(Math.toRadians(120 + o) % 360) + y_pos);
        l3 = new Line(length * Math.cos(Math.toRadians(o) % 360) + x_pos, length * Math.sin(Math.toRadians(o) % 360) + y_pos,length * Math.cos(Math.toRadians((120 + o) % 360)) + x_pos, length * Math.sin(Math.toRadians(120 + o) % 360) + y_pos);

        Paint p = p1;
        l1.setFill(javafx.scene.paint.Color.TRANSPARENT);
        l1.setStroke(p1);
        l1.setStrokeWidth(THICKNESS);
        l2.setFill(javafx.scene.paint.Color.TRANSPARENT);
        l2.setStroke(p2);
        l2.setStrokeWidth(THICKNESS);
        l3.setFill(javafx.scene.paint.Color.TRANSPARENT);
        l3.setStroke(p3);
        l3.setStrokeWidth(THICKNESS);
        s1 = Shape.intersect(l1, l2);
        l1.setStrokeLineCap(StrokeLineCap.ROUND);
        l2.setStrokeLineCap(StrokeLineCap.ROUND);
        l3.setStrokeLineCap(StrokeLineCap.ROUND);
        s1.setStrokeLineCap(StrokeLineCap.ROUND);
        //l1.setStyle("-fx-background-radius: 50px;  -fx-border-radius: 50px; -fx-border-width: 5px;  -fx-border-color: black;");
//         -fx-background-radius: 50px;
//
//    -fx-border-radius: 50px;
//    -fx-border-width: 5px;
//    -fx-border-color: black;
        pList.add(2, l1);
        pList.add(2, l3);
        pList.add(2, l2);
        pList.add(s1);


        //pList.add(2, e1);
        setupTimeline(pList);
    }

    @Override
    public void construct(List pList){
        Color p1 = null;
        // String col = "GREEN";
        if(color.equals("RED")) p1 = Color.RED;
        else if(color.equals("BLUE")) p1 = Color.BLUE;
        else if(color.equals("YELLOW")) p1 = Color.YELLOW;
        else p1 = Color.GREEN;
        Paint p2 = null; Paint p3 = null;
        ArrayList<Color> temp = new ArrayList<Color>();
        temp.add(Color.RED); temp.add(Color.GREEN); temp.add(Color.BLUE); temp.add(Color.YELLOW);
        temp.remove(p1);
        Random rand = new Random();
        temp.remove(rand.nextInt(3));
        p2 = temp.get(0); p3 = temp.get(1);
        double y_pos = y_position;
        double  x_pos = x_position;
        double o= orientation;
        l1 = new Line((length - 20) * Math.cos(Math.toRadians(orientation)) + x_position, (length - 20) * Math.sin(Math.toRadians(orientation)) + y_position,(length - 20) * Math.cos(Math.toRadians((o - 120) % 360)) + x_pos, (length - 20) * Math.sin(Math.toRadians(o - 120 % 360)) + y_pos);
        l2 = new Line(length * Math.cos(Math.toRadians(o - 120) % 360) + x_pos, (length) * Math.sin(Math.toRadians(o - 120) % 360) + y_pos, (length) * Math.cos(Math.toRadians((120 + o) % 360)) + x_pos, (length) * Math.sin(Math.toRadians(120 + o) % 360) + y_pos);
        l3 = new Line(length * Math.cos(Math.toRadians(o) % 360) + x_pos, length * Math.sin(Math.toRadians(o) % 360) + y_pos,length * Math.cos(Math.toRadians((120 + o) % 360)) + x_pos, length * Math.sin(Math.toRadians(120 + o) % 360) + y_pos);

        Paint p = p1;
        l1.setFill(javafx.scene.paint.Color.TRANSPARENT);
        l1.setStroke(p1);
        l1.setStrokeWidth(THICKNESS);
        l2.setFill(javafx.scene.paint.Color.TRANSPARENT);
        l2.setStroke(p2);
        l2.setStrokeWidth(THICKNESS);
        l3.setFill(javafx.scene.paint.Color.TRANSPARENT);
        l3.setStroke(p3);
        l3.setStrokeWidth(THICKNESS);
        s1 = Shape.intersect(l1, l2);
        l1.setStrokeLineCap(StrokeLineCap.ROUND);
        l2.setStrokeLineCap(StrokeLineCap.ROUND);
        l3.setStrokeLineCap(StrokeLineCap.ROUND);
        s1.setStrokeLineCap(StrokeLineCap.ROUND);
        //l1.setStyle("-fx-background-radius: 50px;  -fx-border-radius: 50px; -fx-border-width: 5px;  -fx-border-color: black;");
//         -fx-background-radius: 50px;
//
//    -fx-border-radius: 50px;
//    -fx-border-width: 5px;
//    -fx-border-color: black;
        pList.add(2, l1);
        pList.add(2, l3);
        pList.add(2, l2);
        pList.add(s1);


        //pList.add(2, e1);
        setupTimeline(pList);

    }

    public void setupTimeline(List pList){
        tm = new Timeline(new KeyFrame(Duration.millis(16), (ActionEvent e) ->{
            //System.out.println("hello");
            if(isOutOfScreen()){
                pList.remove(l1);
                pList.remove(l2);
                pList.remove(l3);
                pList.remove(s1);
                //pList.remove(a4);
                //System.out.println(true);
                tm.stop();
            }

            double aa = Math.pow(length - THICKNESS*Math.cos(Math.toRadians(orientation)), 2);
            double bb = Math.pow(THICKNESS * Math.sin(Math.toRadians(orientation)), 2);
            double x = Math.sqrt(aa + bb);
            double angle = Math.toDegrees((Math.atan((THICKNESS * Math.sin(Math.toRadians(orientation)) / (length - THICKNESS * Math.cos(Math.toRadians(orientation)))))));
            pList.remove(s1);

            s1 = Shape.intersect(l1, l2);
            s1.setFill(l2.getStroke());
            s1.setStroke(l2.getStroke());
            pList.add(s1);
            l1.setStartX((length) * Math.cos(Math.toRadians(this.orientation)) + x_position);
            // System.out.println(l1.getEndX());
            l1.setStartY((length) * Math.sin(Math.toRadians(orientation)) + y_position );
            l1.setEndX((length - 5) * Math.cos(Math.toRadians((orientation - 120) % 360)) + x_position );
            l1.setEndY((length - 5) * Math.sin(Math.toRadians((orientation - 120) % 360)) + y_position);

            l2.setStartX((length ) * Math.cos(Math.toRadians((this.orientation - 120) % 360)) + x_position);
            l2.setStartY((length )* Math.sin(Math.toRadians((orientation - 120) % 360)) + y_position);
            l2.setEndX((length) * Math.cos(Math.toRadians((120 + orientation) % 360)) + x_position);
            l2.setEndY((length) * Math.sin(Math.toRadians((120 + orientation) % 360)) + y_position);

            l3.setStartX(length * Math.cos(Math.toRadians((this.orientation) % 360)) + x_position);
            l3.setStartY(length * Math.sin(Math.toRadians((orientation ) % 360)) + y_position);
            l3.setEndX(length * Math.cos(Math.toRadians((120 + orientation) % 360)) + x_position);
            l3.setEndY(length * Math.sin(Math.toRadians((120 + orientation) % 360)) + y_position);

        }));

        tm.setCycleCount(Animation.INDEFINITE);
        tm.play();
        // }

    }

    @Override
    public void updateOrientation() {
        this.orientation1 = (orientation1 + rot_speed) % 360;
        this.orientation = (this.orientation1 + 90 + 60) % 360;
    }

    @Override
    public void updatePosition() {
        y_position = y_position - y_speed;
    }

    @Override
    public boolean isColllisionOccured(Color c, Ball b) {

        if(Shape.intersect(l1, b.getDiagram()).getBoundsInLocal().getHeight() > 0){

            if(!l1.getStroke().equals(b.getDiagram().getFill())) return true;

        }
        if(Shape.intersect(l2, b.getDiagram()).getBoundsInLocal().getHeight() > 0){
            if( !l2.getStroke().equals(b.getDiagram().getFill())) return true;

        }
        if(Shape.intersect(l3, b.getDiagram()).getBoundsInLocal().getHeight() > 0){

            if(! l3.getStroke().equals(b.getDiagram().getFill())) return true;
        }
        return false;

    }

    public void draw(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double[] getBounds() {
        double[] ak = {y_position - length  - 2, y_position + length + 2};
        return ak;
    }

    @Override
    public void remove(List pList) {
        pList.remove(l1);
        pList.remove(l2);
        pList.remove(l3);
        pList.remove(s1);

    }

}
