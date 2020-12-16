package view;


import java.util.List;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
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
class Circle extends Obstacle {
    public static final long serialVersionUID = 6914063406698668622L;
    transient  private Timeline tm;
    private double radius;
    private double rot_speed;
    private double orientation = 0;
    transient Arc a1, a2, a3, a4;


    private final double THICKNESS = 20;

    public Circle(double x_pos, double y_pos, double radius, double speed, List pList, double o) {

        super(x_pos, y_pos);
        this. radius = radius;
        this.rot_speed = speed;
        this.orientation = o;
        a1 = new Arc(x_position, y_position,  radius, radius, 0, 90);
        //System.out.println(a1.getBoundsInParent().toString());
        a1.setFill(javafx.scene.paint.Color.TRANSPARENT);
        a1.setStroke(javafx.scene.paint.Color.GREEN);
        a1.setStrokeWidth(12);

        a2 = new Arc(x_position, y_position,  radius, radius, 90, 90);
        a2.setFill(javafx.scene.paint.Color.TRANSPARENT);
        a2.setStroke(javafx.scene.paint.Color.BLUE);
        a2.setStrokeWidth(12);

        a3 = new Arc(x_position, y_position,  radius, radius, 180, 90);
        a3.setFill(javafx.scene.paint.Color.TRANSPARENT);
        a3.setStroke(javafx.scene.paint.Color.RED);
        a3.setStrokeWidth(12);

        a4 = new Arc(x_position, y_position,  radius, radius, 270, 90);
        a4.setFill(javafx.scene.paint.Color.TRANSPARENT);
        a4.setStroke(javafx.scene.paint.Color.YELLOW);
        a4.setStrokeWidth(12);
        pList.add(2, a1);
        pList.add(2, a2);
        pList.add(2, a3);
        pList.add(2, a4);
        setupTimeline(pList);
    }
    public void construct(List pList){
        a1 = new Arc(x_position, y_position,  radius, radius, 0, 90);
        //System.out.println(a1.getBoundsInParent().toString());
        a1.setFill(javafx.scene.paint.Color.TRANSPARENT);
        a1.setStroke(javafx.scene.paint.Color.GREEN);
        a1.setStrokeWidth(12);

        a2 = new Arc(x_position, y_position,  radius, radius, 90, 90);
        a2.setFill(javafx.scene.paint.Color.TRANSPARENT);
        a2.setStroke(javafx.scene.paint.Color.BLUE);
        a2.setStrokeWidth(12);

        a3 = new Arc(x_position, y_position,  radius, radius, 180, 90);
        a3.setFill(javafx.scene.paint.Color.TRANSPARENT);
        a3.setStroke(javafx.scene.paint.Color.RED);
        a3.setStrokeWidth(12);

        a4 = new Arc(x_position, y_position,  radius, radius, 270, 90);
        a4.setFill(javafx.scene.paint.Color.TRANSPARENT);
        a4.setStroke(javafx.scene.paint.Color.YELLOW);
        a4.setStrokeWidth(12);
        pList.add(2, a1);
        pList.add(2, a2);
        pList.add(2, a3);
        pList.add(2, a4);
        setupTimeline(pList);
    }

    public void setOrientation(double o){
        this.orientation = o;
    }
    public double getOrientation(){
        return orientation;
    }



    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRot_speed() {
        return rot_speed;
    }

    public void setRot_speed(double rot_speed) {
        this.rot_speed = rot_speed;
    }

    public double getX_position() {
        return x_position;
    }

    public void setX_position(double x_position) {
        this.x_position = x_position;
    }

    public double getY_position() {
        return y_position;
    }

    public void setY_position(double y_position) {
        this.y_position = y_position;
    }

    @Override
    public void updateOrientation() {
        //System.out.println(y_position);
        this.orientation = (this.orientation + rot_speed) % 360;


        //a1.setStartAngle(orientation);
        /*a2.setStartAngle(a1.getStartAngle() + 90);
        a3.setStartAngle(a2.getStartAngle() + 90);
        a4.setStartAngle(a3.getStartAngle() + 90);
        a1.setCenterY(y_position);
        a2.setCenterY(y_position);
        a3.setCenterY(y_position);
        a4.setCenterY(y_position);*/

    }
    @Override
    public void remove(List pList){

        pList.remove(a1);
        pList.remove(a2);
        pList.remove(a3);
        pList.remove(a4);

    }

    public void setupTimeline(List pList){
        tm = new Timeline(new KeyFrame(Duration.millis(16), e ->{



            if(isOutOfScreen()){
                pList.remove(a1);
                pList.remove(a2);
                pList.remove(a3);
                pList.remove(a4);
                //System.out.println(true);
                tm.stop();
            }
            a1.setStartAngle(orientation);
            a2.setStartAngle(a1.getStartAngle() + 90);
            a3.setStartAngle(a2.getStartAngle() + 90);
            a4.setStartAngle(a3.getStartAngle() + 90);
            a1.setCenterY(y_position);
            a2.setCenterY(y_position);
            a3.setCenterY(y_position);
            a4.setCenterY(y_position);
        }));

        tm.setCycleCount(Animation.INDEFINITE);
        tm.play();
        // }

    }

    @Override
    public boolean isColllisionOccured(Color c, Ball b) {
        //return true;
        //System.out.println(c.toString());



        Color[] bottom = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};
        //System.out.println(orientation);

        Color colb = null;
        if(x_position == b.getXPosition()){
            if(orientation <  0) colb = bottom[3 + (int) orientation / 90];

            else colb = bottom[(int) orientation / 90];
            Color colt =null;
            if(orientation <  0) colt = bottom[(5 + (int) orientation / 90) % 4];
            else colt = bottom[((int) orientation / 90 + 2) % 4];
            if(b.getYPosition() <= y_position + radius + 7 && b.getYPosition() > y_position + radius - THICKNESS - 7){
                if(colb.equals(c)) return false;
                else return true;
            }
            else if(b.getYPosition() > y_position - radius - 7 && b.getYPosition() < y_position - radius + THICKNESS + 7 ){
                if(colt.equals(c)) return false;
                else return true;
            }

        }
        else{
            double a1 = Math.sqrt(Math.pow(b.getXPosition() - x_position, 2) + Math.pow(b.getYPosition() - y_position, 2));
            double a2 = radius + b.getRadius();
            //System.out.println("Hello");
            if(a1 - a2 < 0){

                // System.out.println(a1 - a2);
                // Color[] cr = {Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE};

                Color col = null;
                if(this.rot_speed < 0){
                    if(b.getXPosition() > x_position){
                        Color[] cr = {Color.GREEN, Color.BLUE, Color.RED, Color.YELLOW};
                        int ind = (int) ((-1 * (int)this.orientation) / 90);
                        col = cr[ind];
                    }
                    else if(b.getXPosition() < x_position){
                        Color[] cl = {Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE};
                        int ind = (int) ((-1 * (int) this.orientation) / 90);
                        col = cl[ind];
                    }
                }
                else{
                    if(b.getXPosition() > x_position){
                        Color[] ar = {Color.YELLOW, Color.RED, Color.BLUE, Color.GREEN};
                        int ind = (int) ((int) this.orientation / 90);
                        col = ar[ind];
                    }
                    else if(b.getXPosition() < x_position){
                        Color[] al = {Color.BLUE, Color.GREEN, Color.YELLOW, Color.RED};
                        int ind = (int) ((int) (this.orientation) / 90);
                        col = al[ind];
                    }
                }
                //System.out.println(col.toString() + " " + orientation + " " +  (int)this.orientation / 90);
                if(col.equals(b.getColor())) return false;
                else return true;
            }
        }



        return false;


    }



    //
//    public void draw(Graphics gr){
//        double x = x_position - radius;
//        double y = y_position - radius;
//        //Ellipse2D outer = new Ellipse2D.Double(x, y, 2*radius, 2*radius);
//       // Ellipse2D inner = new Ellipse2D.Double(x + THICKNESS, y + THICKNESS, 2*(radius - THICKNESS), 2*(radius - THICKNESS)  );
//        //Area area = new Area(outer);
//        //area.subtract(new Area(inner));
//        Graphics2D g = (Graphics2D) gr;
//        g.setRenderingHint(
//            RenderingHints.KEY_ANTIALIASING,
//            RenderingHints.VALUE_ANTIALIAS_ON);
//        g.setColor(javafx.scene.paint.Color.RED);
//        g.fillArc((int) (x), (int) y, (int) (2*radius) , (int) (2*radius), (int) this.orientation, 90);
//        g.setColor(Color.green);
//        g.fillArc((int) (x), (int) y, (int) (2*radius) , (int) (2*radius), (int) this.orientation + 90, 90);
//        g.setColor(Color.blue);
//        g.fillArc((int) (x), (int) y, (int) (2*radius) , (int) (2*radius), (int) this.orientation + 180, 90);
//        g.setColor(Color.yellow);
//        g.fillArc((int) (x), (int) y, (int) (2*radius) , (int) (2*radius), (int) this.orientation + 270, 90);
//        g.setColor(Color.black);
//        g.fillOval((int)(x + THICKNESS), (int)(y + THICKNESS), (int) 2*(int) (radius - THICKNESS), (int) (radius - THICKNESS)*(int) 2);
//       // g.setColor(Color.black);
//      // g.fillOval((int) x_position, (int) y_position, 5, 5);
// 
//    }
    @Override
    public double[] getBounds(){
        double[] ak = {y_position - radius - 2, y_position + radius + 2};
        return ak;
    }

    @Override
    public void updatePosition() {
        y_position = y_position - y_speed;
        //a1.setCenterY(y_position);
        //a2.setCenterY(y_position);
        //a3.setCenterY(y_position);
        //a4.setCenterY(y_position);
    }




}
