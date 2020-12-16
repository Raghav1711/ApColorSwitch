package view;

import java.util.List;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author prash
 */
public class ColorChanger extends CollidableObject {
    public static final long serialVersionUID  = 681814708766537396L;
    double size = 15;
    transient  Paint c;
    transient Arc a1, a2, a3, a4;
    transient List pList;
    private boolean is_collided = false;
    String color;

    public ColorChanger(double x_pos, double y_pos, Paint c, List pList) {
        super(x_pos, y_pos);
        this.c = c;
        if(c.equals(Color.RED)) color = "RED";
        else if(c.equals(Color.BLUE)) color = "BLUE";
        else if(c.equals(Color.YELLOW)) color = "YELLOW";
        else color = "GREEN";
        a1 = new Arc(x_position, y_position,  size, size, 0, 90);
        a1.setType(ArcType.ROUND);
        a1.setFill(javafx.scene.paint.Color.RED);

        a2 = new Arc(x_position, y_position,  size, size, 90, 90);
        a2.setType(ArcType.ROUND);
        a2.setFill(javafx.scene.paint.Color.YELLOW);

        a3 = new Arc(x_position, y_position,  size, size, 180, 90);
        a3.setType(ArcType.ROUND);
        a3.setFill(javafx.scene.paint.Color.BLUE);

        a4 = new Arc(x_position, y_position,  size, size, 270, 90);
        a4.setType(ArcType.ROUND);
        a4.setFill(javafx.scene.paint.Color.GREEN);


        this.pList = pList;
        pList.add(2, a1);
        pList.add(2, a2);
        pList.add(2, a3);
        pList.add(2, a4);

    }
    public void setCollided(boolean b){
        is_collided = b;
    }
    public boolean isAlreadyCollided(){
        return is_collided;
    }

    @Override
    public void updatePosition() {
        y_position = y_position - y_speed;


    }


    @Override
    public boolean isColllisionOccured(Color c, Ball b) {

        if(b.getYPosition() > getBounds()[0] && b.getYPosition() < getBounds()[1]){
            return true;
        }
        return false;
    }


    @Override
    public double[] getBounds() {
        double[] ak = {y_position - size - 2, y_position + size + 2};
        return ak;
    }

    @Override
    public void remove(List pList) {
        pList.remove(a1);
        pList.remove(a2);
        pList.remove(a3);
        pList.remove(a4);
    }

    @Override
    public void updateObject() {
        if(isOutOfScreen()){
            remove(pList);
        }
        updatePosition();
        a1.setCenterY(y_position);
        a2.setCenterY(y_position);
        a3.setCenterY(y_position);
        a4.setCenterY(y_position);
    }
    public Color getColor(){
        return (Color) c;
    }
    public String getColorS(){
        return color;
    }

    @Override
    public void construct(List pList) {
        this.pList = pList;
        //color = "BLUE";
        //this.c = Color.BLUE;
        if(color.equals("RED")) c = Color.RED;
        else if(color.equals("GREEN")) c = Color.GREEN;
        else if(color.equals("BLUE")) c = Color.BLUE;
        else c = Color.YELLOW;

        a1 = new Arc(x_position, y_position,  size, size, 0, 90);
        a1.setType(ArcType.ROUND);
        a1.setFill(javafx.scene.paint.Color.RED);

        a2 = new Arc(x_position, y_position,  size, size, 90, 90);
        a2.setType(ArcType.ROUND);
        a2.setFill(javafx.scene.paint.Color.YELLOW);

        a3 = new Arc(x_position, y_position,  size, size, 180, 90);
        a3.setType(ArcType.ROUND);
        a3.setFill(javafx.scene.paint.Color.BLUE);

        a4 = new Arc(x_position, y_position,  size, size, 270, 90);
        a4.setType(ArcType.ROUND);
        a4.setFill(javafx.scene.paint.Color.GREEN);


        this.pList = pList;
        pList.add(2, a1);
        pList.add(2, a2);
        pList.add(2, a3);
        pList.add(2, a4);

    }


}
