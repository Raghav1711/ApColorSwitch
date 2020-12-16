package view;

import java.util.List;
import java.util.Random;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.util.Duration;

public class Square extends Obstacle{

    transient private Timeline tm;
    private double leng;
    private double rot_speed;
    private double orientationx = 0;
    private double arclen =0;
    //private double orientationy = 0;
    transient  Line l1, l2, l3, l4;

    private final double THICKNESS = 10;

    public Square(double x_pos, double y_pos, double radius, double speed, List aList) {
        super(x_pos, y_pos);
        this.leng = radius;
        Random r= new Random();
        int randNo=r.nextInt(40);
        this.leng+=randNo;
        this.rot_speed = speed;
//        Line l1=new Line();
        l1=new Line(x_pos - (leng/2),y_pos + (leng/2),x_pos + (leng/2),y_pos + (leng/2));
        //l1=new Line( x_pos , y_pos , x_pos ,y_pos + leng);
        l1.setFill(javafx.scene.paint.Color.TRANSPARENT);
        l1.setStroke(javafx.scene.paint.Color.GREEN);
        l1.setStrokeWidth(12);
        l1.setStrokeLineCap(StrokeLineCap.ROUND);

        l2=new Line(x_pos + (leng/2),y_pos - (leng/2),x_pos + (leng/2),y_pos + (leng/2));
        //l2=new Line(x_pos ,y_pos ,x_pos + leng,y_pos);
        l2.setFill(javafx.scene.paint.Color.TRANSPARENT);
        l2.setStroke(javafx.scene.paint.Color.BLUE);
        l2.setStrokeWidth(12);
        l2.setStrokeLineCap(StrokeLineCap.ROUND);

        l3=new Line(x_pos - (leng/2),y_pos - (leng/2),x_pos + (leng/2),y_pos - (leng/2));
//        l3=new Line(x_pos ,y_pos - leng,x_pos ,y_pos);
        l3.setFill(javafx.scene.paint.Color.TRANSPARENT);
        l3.setStroke(javafx.scene.paint.Color.RED);
        l3.setStrokeWidth(12);
        l3.setStrokeLineCap(StrokeLineCap.ROUND);

        l4=new Line(x_pos - (leng/2),y_pos - (leng/2),x_pos - (leng/2),y_pos + (leng/2));
        // l4=new Line(x_pos - leng ,y_pos ,x_pos ,y_pos );
        l4.setFill(javafx.scene.paint.Color.TRANSPARENT);
        l4.setStroke(javafx.scene.paint.Color.YELLOW);
        l4.setStrokeWidth(12);
        l4.setStrokeLineCap(StrokeLineCap.ROUND);

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
        this.orientationx = (this.orientationx + rot_speed) % 360;
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

    }

    public void setupTimeline(List aList){
        tm = new Timeline(new KeyFrame(Duration.millis(16), e ->{
            if(isOutOfScreen()){
                aList.remove(l1);
                aList.remove(l2);
                aList.remove(l3);
                aList.remove(l4);
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
            // this.orientationx = (this.orientationx + rot_speed) % 360;
            arclen=(this.orientationx * Math.PI) ;

            l1.setStartY( y_position + (leng * 1/(Math.sqrt(2)) *Math.cos(Math.toRadians(45 - this.orientationx)) ));
            l1.setStartX(  x_position - (leng * 1/(Math.sqrt(2)) *Math.sin(Math.toRadians(45 - this.orientationx)) ));
            l1.setEndX(x_position + (leng * 1/(Math.sqrt(2)) *Math.sin(Math.toRadians(45 + this.orientationx)) ));
            l1.setEndY(y_position + (leng * 1/(Math.sqrt(2)) *Math.cos(Math.toRadians(45 + this.orientationx)) ));

            // roght
            l2.setStartY(y_position - (leng * 1/(Math.sqrt(2)) *Math.sin(Math.toRadians(45 + this.orientationx)) ));
            l2.setStartX(x_position + (leng * 1/(Math.sqrt(2)) *Math.cos(Math.toRadians(45 + this.orientationx)) ));
            l2.setEndX(x_position + (leng * 1/(Math.sqrt(2)) *Math.cos(Math.toRadians(45 - this.orientationx)) ));
            l2.setEndY(y_position + (leng * 1/(Math.sqrt(2)) *Math.sin(Math.toRadians(45 - this.orientationx)) ));

            l3.setStartY(y_position - (leng * 1/(Math.sqrt(2)) *Math.cos(Math.toRadians(45 + this.orientationx)) ));
            l3.setStartX(x_position - (leng * 1/(Math.sqrt(2)) *Math.sin(Math.toRadians(45 + this.orientationx)) ));
            l3.setEndX(x_position + (leng * 1/(Math.sqrt(2)) *Math.sin(Math.toRadians(45 - this.orientationx)) ));
            l3.setEndY(y_position - (leng * 1/(Math.sqrt(2)) *Math.cos(Math.toRadians(45 - this.orientationx)) ));

            l4.setStartY(y_position - (leng * 1/(Math.sqrt(2)) *Math.sin(Math.toRadians(45 - this.orientationx)) ));
            l4.setStartX(x_position - (leng * 1/(Math.sqrt(2)) *Math.cos(Math.toRadians(45 - this.orientationx)) ));
            l4.setEndX(x_position - (leng * 1/(Math.sqrt(2)) *Math.cos(Math.toRadians(45 + this.orientationx)) ));
            l4.setEndY(y_position + (leng * 1/(Math.sqrt(2)) *Math.sin(Math.toRadians(45 + this.orientationx)) ));

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



//        Color[] bottom = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};
//        //System.out.println(orientation);
//
//        Color colb = null;
//        if(orientationx <  0) colb = bottom[3 + (int) orientationx / 90];
//        else colb = bottom[(int) orientationx / 90];
//        Color colt =null;
//        if(orientationx <  0) colt = bottom[(5 + (int) orientationx / 90) % 4];
//        else colt = bottom[((int) orientationx / 90 + 2) % 4];
//        if(b.getYPosition() <= y_position + leng + 7 && b.getYPosition() > y_position + leng - THICKNESS - 7){
//            if(colb.equals(c)) return false;
//            else return true;
//        }
//        else if(b.getYPosition() > y_position - leng - 7 && b.getYPosition() < y_position - leng + THICKNESS + 7 ){
//            if(colt.equals(c)) return false;
//            else return true;
//        }
//        return false;


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
        double[] ak = {y_position - leng / Math.sqrt(2) - 2, y_position + leng / Math.sqrt(2) + 2};
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

    @Override
    public void construct(List pList) {
        l1=new Line(x_position - (leng/2),y_position + (leng/2),x_position + (leng/2),y_position + (leng/2));
        //l1=new Line( x_pos , y_pos , x_pos ,y_pos + leng);
        l1.setFill(javafx.scene.paint.Color.TRANSPARENT);
        l1.setStroke(javafx.scene.paint.Color.GREEN);
        l1.setStrokeWidth(12);
        l1.setStrokeLineCap(StrokeLineCap.ROUND);

        l2=new Line(x_position + (leng/2),y_position - (leng/2),x_position + (leng/2),y_position + (leng/2));
        //l2=new Line(x_pos ,y_pos ,x_pos + leng,y_pos);
        l2.setFill(javafx.scene.paint.Color.TRANSPARENT);
        l2.setStroke(javafx.scene.paint.Color.BLUE);
        l2.setStrokeWidth(12);
        l2.setStrokeLineCap(StrokeLineCap.ROUND);

        l3=new Line(x_position - (leng/2),y_position - (leng/2),x_position + (leng/2),y_position - (leng/2));
//        l3=new Line(x_pos ,y_pos - leng,x_pos ,y_pos);
        l3.setFill(javafx.scene.paint.Color.TRANSPARENT);
        l3.setStroke(javafx.scene.paint.Color.RED);
        l3.setStrokeWidth(12);
        l3.setStrokeLineCap(StrokeLineCap.ROUND);

        l4=new Line(x_position - (leng/2),y_position - (leng/2),x_position - (leng/2),y_position + (leng/2));
        // l4=new Line(x_pos - leng ,y_pos ,x_pos ,y_pos );
        l4.setFill(javafx.scene.paint.Color.TRANSPARENT);
        l4.setStroke(javafx.scene.paint.Color.YELLOW);
        l4.setStrokeWidth(12);
        l4.setStrokeLineCap(StrokeLineCap.ROUND);

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
        pList.add(2, l1);
        pList.add(2, l2);
        pList.add(2, l3);
        pList.add(2, l4);
        setupTimeline(pList);
    }
}