package view;


import java.awt.Graphics;
import java.io.Serializable;
import java.util.List;
import javafx.scene.paint.Color;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author prash
 */
abstract class CollidableObject implements Serializable {
    public static final long serialVersionUID =  -8888771516181359012L;
    protected double x_position;
    protected double y_position;
    protected double y_speed = 0;

    public CollidableObject(double x_pos, double y_pos){
        this.x_position = x_pos;
        this.y_position = y_pos;

    }

    public double getX_position() {
        return x_position;
    }

    public double getY_position() {
        return y_position;
    }

    public boolean isOutOfScreen(){

        if(y_position > 900){
            return true;
        }
        return false;
    }
    public abstract void updatePosition();


    public abstract void updateObject();


    public abstract boolean isColllisionOccured(Color c, Ball b);
    public void setYSpeed(double s){
        this.y_speed = s;
    }
    //public abstract void draw(Graphics g);
    public abstract double[] getBounds();
    public abstract void remove(List pList);

    public abstract void construct(List pList);
}





abstract class Obstacle extends CollidableObject {

    public Obstacle(double x_pos, double y_pos) {
        super(x_pos, y_pos);
    }
    public abstract void updateOrientation();
    @Override
    public void updateObject(){
        updateOrientation();
        updatePosition();
    }

}

