package view;

//import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.util.Duration;

public class Lines extends Obstacle{

    private Timeline tm;
    private double leng;
    private double rot_speed;
    private double orientationx = 0;
    private double orientation2 = 0;
    private double arclen =0;
    //private double orientationy = 0;
    Line l1, l2, l3, l4, l5, l6, l7, l8 ;
    int k1,k2;

    private final double THICKNESS = 10;

    public Lines(double x_pos, double y_pos, double radius, double speed, List aList) {
        super(x_pos, y_pos);
        this.leng = radius;
        Random r= new Random();
//        int randNo=r.nextInt(40);
//        this.leng+=randNo;
        this.rot_speed = speed;
//        Line l1=new Line();
        this.orientationx=x_position - (2*leng);
        this.orientation2=x_position + (2*leng);
         k1=1;
         k2=-1;
        l1=new Line(x_pos - (leng)*4 ,y_pos - (leng),x_pos - (leng*4) ,y_pos + (leng));
        //l1=new Line( x_pos , y_pos , x_pos ,y_pos + leng);
        l1.setFill(javafx.scene.paint.Color.TRANSPARENT);
        l1.setStroke(javafx.scene.paint.Color.GREEN);
        l1.setStrokeWidth(12);
        l1.setStrokeLineCap(StrokeLineCap.ROUND);

        l2=new Line(x_pos - 3*(leng) ,y_pos - (leng),x_pos - 3*(leng) ,y_pos + (leng) );
        //l2=new Line(x_pos ,y_pos ,x_pos + leng,y_pos);
        l2.setFill(javafx.scene.paint.Color.TRANSPARENT);
        l2.setStroke(javafx.scene.paint.Color.BLUE);
        l2.setStrokeWidth(12);
        l2.setStrokeLineCap(StrokeLineCap.ROUND);

        l3=new Line(x_pos - (leng)*2 ,y_pos - (leng),x_pos - (leng)*2 ,y_pos + (leng));
//        l3=new Line(x_pos ,y_pos - leng,x_pos ,y_pos);
        l3.setFill(javafx.scene.paint.Color.TRANSPARENT);
        l3.setStroke(javafx.scene.paint.Color.RED);
        l3.setStrokeWidth(12);
        l3.setStrokeLineCap(StrokeLineCap.ROUND);

        l4=new Line(x_pos - (leng) ,y_pos - (leng),x_pos - (leng) ,y_pos + (leng));
        // l4=new Line(x_pos - leng ,y_pos ,x_pos ,y_pos );
        l4.setFill(javafx.scene.paint.Color.TRANSPARENT);
        l4.setStroke(javafx.scene.paint.Color.YELLOW);
        l4.setStrokeWidth(12);
        l4.setStrokeLineCap(StrokeLineCap.ROUND);
        //l4.setStyle("-fx-border-radius: 30;");

        l5=new Line(x_pos + (leng) ,y_pos - (leng),x_pos + (leng),y_pos + (leng));
        //l1=new Line( x_pos , y_pos , x_pos ,y_pos + leng);
        l5.setFill(javafx.scene.paint.Color.TRANSPARENT);
        l5.setStroke(javafx.scene.paint.Color.YELLOW);
        l5.setStrokeWidth(12);
        l5.setStrokeLineCap(StrokeLineCap.ROUND);

        l6=new Line(x_pos + (leng)*2 ,y_pos - (leng),x_pos + (leng)*2,y_pos + (leng) );
        //l1=new Line( x_pos , y_pos , x_pos ,y_pos + leng);
        l6.setFill(javafx.scene.paint.Color.TRANSPARENT);
        l6.setStroke(javafx.scene.paint.Color.RED);
        l6.setStrokeWidth(12);
        l6.setStrokeLineCap(StrokeLineCap.ROUND);

        l7=new Line(x_pos + 3*(leng) ,y_pos - (leng),x_pos + 3*(leng),y_pos + (leng));
        //l1=new Line( x_pos , y_pos , x_pos ,y_pos + leng);
        l7.setFill(javafx.scene.paint.Color.TRANSPARENT);
        l7.setStroke(javafx.scene.paint.Color.BLUE);
        l7.setStrokeWidth(12);
        l7.setStrokeLineCap(StrokeLineCap.ROUND);

        l8=new Line(x_pos + (leng*4) ,y_pos - (leng),x_pos + (leng*4),y_pos + (leng));
        //l1=new Line( x_pos , y_pos , x_pos ,y_pos + leng);
        l8.setFill(javafx.scene.paint.Color.TRANSPARENT);
        l8.setStroke(javafx.scene.paint.Color.GREEN);
        l8.setStrokeWidth(12);
        l8.setStrokeLineCap(StrokeLineCap.ROUND);

//        Rectangle r=new Rectangle(0,0,5,5);
//        r.

//          a1 = new Arc(x_position, y_position,  radius, radius, 0, 90);
//        a1.setFill(javafx.scene.paint.Color.TRANSPARENT);
//        a1.setStroke(javafx.scene.paint.Color.GREEN);
//        a1.setStrokeWidth(12);
//
//        a2 = new Arc(x_position, y_position,  radius, radius, 90, 90);
//        a2.setFill(javafx.scene.paint.Color.TRANSPARENT);
//        a2.setStroke(javafx.scene.paint.Color.BLUE);
//        a2.setStrokeWidth(12);
//
//        a3 = new Arc(x_position, y_position,  radius, radius, 180, 90);
//        a3.setFill(javafx.scene.paint.Color.TRANSPARENT);
//        a3.setStroke(javafx.scene.paint.Color.RED);
//        a3.setStrokeWidth(12);
//
//        a4 = new Arc(x_position, y_position,  radius, radius, 270, 90);
//        a4.setFill(javafx.scene.paint.Color.TRANSPARENT);
//        a4.setStroke(javafx.scene.paint.Color.YELLOW);
//        a4.setStrokeWidth(12);
        aList.add(2, l1);
        aList.add(2, l2);
        aList.add(2, l3);
        aList.add(2, l4);
        aList.add(2, l5);
        aList.add(2, l6);
        aList.add(2, l7);
        aList.add(2, l8);
        setupTimeline(aList);
    }

    public double getLeng() {
        return leng;
    }

    public void setLeng(double radius) {
        this.leng = radius;
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
//        this.orientationx = (this.orientationx + rot_speed) % 360;               commmmmmmmmmmm
//        arclen=(this.orientationx * Math.PI) ;                                   commmmmmmmmmm
        //this.orientationy = ((this.orientationy + rot_speed)* Math.PI) % 360;

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
    public void remove(List aList){

        aList.remove(l1);
        aList.remove(l2);
        aList.remove(l3);
        aList.remove(l4);
        aList.remove(l5);
        aList.remove(l6);
        aList.remove(l7);
        aList.remove(l8);

    }

    @Override
    public void construct(List pList) {

    }

    public void setupTimeline(List aList){
        tm = new Timeline(new KeyFrame(Duration.millis(16), e ->{
            if(isOutOfScreen()){
                aList.remove(l1);
                aList.remove(l2);
                aList.remove(l3);
                aList.remove(l4);
                aList.remove(l5);
                aList.remove(l6);
                aList.remove(l7);
                aList.remove(l8);
                System.out.println(true);
                tm.stop();
            }
            // a1.setStartAngle(orientation);
            double angcos= Math.toRadians(orientationx);
//            if(orientationx <=90) {
//                l1.setEndX(l1.getEndX() + (leng * (Math.cos(angcos))));
//                l1.setEndY(l1.getEndY() + (leng * (Math.sin(angcos))));
//            }
//            else if(orientationx <=180) {
//                l1.setEndX(l1.getEndX() + (leng * (Math.cos(angcos))));
//                l1.setStartY(l1.getStartY() + (leng * (Math.sin(angcos))));
//            }
//            else if(orientationx <=270) {
//                l1.setStartX(l1.getStartX() + (leng * (Math.cos(angcos))));
//                l1.setStartY(l1.getStartY() + (leng * (Math.sin(angcos))));
//            }
//            else if(orientationx <=360) {
//                l1.setStartX(l1.getStartX() + (leng * (Math.cos(angcos))));
//                l1.setEndY(l1.getEndY() + (leng * (Math.sin(angcos))));
//            }

//            tm.getKeyFrames().addAll(
//
//            )
//            RotateTransition rt = new RotateTransition(Duration.millis(3000), l2);
//            rt.setByAngle(180);
//            rt.setCycleCount(4);
//            rt.setAutoReverse(true);

            //rt.play();
            //this.orientationx = (this.orientationx + rot_speed) % 360;

            //this.orientationx=x_position;
            double boundl1=this.orientationx-(4*leng);
            double boundr1= this.orientationx+(leng);
            double boundl2=this.orientationx-(4*leng);
            double boundr2= this.orientationx+(leng);
            if((this.orientationx<(x_position - 4*leng)) ||  (this.orientationx>(x_position + leng)) )
            {

                k1*=-1;
                this.orientationx = this.orientationx +(k1*(rot_speed+5));
            }

            if((this.orientation2>(x_position + 4*leng)) ||  (this.orientation2<(x_position - leng)) )
            {

                k2*=-1;
                this.orientation2 = this.orientation2 +(k2*(rot_speed+5));
            }
            //System.out.println(this.orientationx);
            this.orientationx = this.orientationx +(k1*rot_speed);
            this.orientation2=this.orientation2 +(k2*rot_speed);
            arclen=(this.orientationx * Math.PI) ;

            l1.setStartY( y_position - leng);
            l1.setStartX(orientationx);
            l1.setEndX(  orientationx);
            l1.setEndY(y_position + leng);

            // roght
            l2.setStartY(y_position - leng );
            l2.setStartX(orientationx + leng);
            l2.setEndX(orientationx + leng);
            l2.setEndY(y_position + leng);

            l3.setStartY(y_position - leng);
            l3.setStartX(orientationx + 2*leng);
            l3.setEndX(orientationx + 2*leng);
            l3.setEndY(y_position + leng);

            l4.setStartY(y_position - leng);
           l4.setStartX(orientationx + 3*(leng));
            l4.setEndX(orientationx + 3*(leng));
            l4.setEndY(y_position + leng);

            l5.setStartY( y_position - leng);
            l5.setStartX(orientation2 - 3*(leng));
            l5.setEndX(orientation2 - 3*(leng));
            l5.setEndY(y_position + leng);

            l6.setStartY( y_position - leng);
            l6.setStartX(orientation2 - 2*leng);
            l6.setEndX(orientation2 - 2*leng);
            l6.setEndY(y_position + leng);

            l7.setStartY( y_position - leng);
            l7.setStartX( orientation2 - leng);
            l7.setEndX(orientation2 - leng);
            l7.setEndY(y_position + leng);

            l8.setStartY( y_position - leng);
            l8.setStartX(orientation2);
            l8.setEndX(orientation2);
            l8.setEndY(y_position + leng);

//            l2.setEndX(l1.getEndX()+leng);
//            l2.setStartY(l1.getEndY()-leng);
//
//            l3.setStartX(l2.getEndX()-leng);
//            l3.setStartY(l2.getEndY()-leng);
//
//            l4.setStartX(l3.getStartX()-leng);
//            l4.setStartY(l3.getStartY()+leng);



//            a2.setStartAngle(a1.getStartAngle() + 90);
//            a3.setStartAngle(a2.getStartAngle() + 90);
//            a4.setStartAngle(a3.getStartAngle() + 90);
//            l1.setStartY(y_position);
//            l1.setStartX(x_position);
//            l2.setStartY(y_position);
//            l3.setEndY(y_position);
//            l4.setEndY(y_position);

//            a1.setCenterY(y_position);
//            a2.setCenterY(y_position);
//            a3.setCenterY(y_position);
//            a4.setCenterY(y_position);
        }));

        tm.setCycleCount(Animation.INDEFINITE);
        tm.play();
        // }

    }

    @Override
    public boolean isColllisionOccured(Color c, Ball b) {
        //return true;
        //System.out.println(c.toString());



        if(Shape.intersect(l1, b.getDiagram()).getBoundsInLocal().getHeight() > 0){

            if(!l1.getStroke().equals(b.getDiagram().getFill())) return true;

        }
        if(Shape.intersect(l2, b.getDiagram()).getBoundsInLocal().getHeight() > 0){
            if( !l2.getStroke().equals(b.getDiagram().getFill())) return true;

        }
        if(Shape.intersect(l3, b.getDiagram()).getBoundsInLocal().getHeight() > 0){

            if(! l3.getStroke().equals(b.getDiagram().getFill())) return true;
        }
        if(Shape.intersect(l4, b.getDiagram()).getBoundsInLocal().getHeight() > 0){

            if(! l4.getStroke().equals(b.getDiagram().getFill())) return true;
        }
        return false;

    }




//    @Override
//    public void draw(Graphics gr){
//        // # double x = x_position - radius;
//        // # double y = y_position - radius;
//
//
//        //Ellipse2D outer = new Ellipse2D.Double(x, y, 2*radius, 2*radius);
//        // Ellipse2D inner = new Ellipse2D.Double(x + THICKNESS, y + THICKNESS, 2*(radius - THICKNESS), 2*(radius - THICKNESS)  );
//        //Area area = new Area(outer);
//        //area.subtract(new Area(inner));
//        Graphics2D g = (Graphics2D) gr;
//        g.setRenderingHint(
//                RenderingHints.KEY_ANTIALIASING,
//                RenderingHints.VALUE_ANTIALIAS_ON);
//        g.setColor(Color.red);
////    #    g.fillArc((int) (x), (int) y, (int) (2*radius) , (int) (2*radius), (int) this.orientation, 90);
////    #    g.setColor(Color.green);
////    #    g.fillArc((int) (x), (int) y, (int) (2*radius) , (int) (2*radius), (int) this.orientation + 90, 90);
////    #    g.setColor(Color.blue);
////    #    g.fillArc((int) (x), (int) y, (int) (2*radius) , (int) (2*radius), (int) this.orientation + 180, 90);
////    #    g.setColor(Color.yellow);
////    #    g.fillArc((int) (x), (int) y, (int) (2*radius) , (int) (2*radius), (int) this.orientation + 270, 90);
////    #    g.setColor(Color.black);
////    #    g.fillOval((int)(x + THICKNESS), (int)(y + THICKNESS), (int) 2*(int) (radius - THICKNESS), (int) (radius - THICKNESS)*(int) 2);
////        // g.setColor(Color.black);
//        // g.fillOval((int) x_position, (int) y_position, 5, 5);
//
//    }
    @Override
    public double[] getBounds(){
        double[] ak = {y_position - leng - 2, y_position + leng + 2};
        // double [] ak =null; //#
        return ak;
    }

    @Override
    public void updatePosition() {
        y_position = y_position - y_speed;
//        a1.setCenterY(y_position);
//        a2.setCenterY(y_position);
//        a3.setCenterY(y_position);
//        a4.setCenterY(y_position);
    }
}
