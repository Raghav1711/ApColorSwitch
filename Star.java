package  view;
import java.util.List;

import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class Star extends CollidableObject {
    public static final long serialVersionUID = 2183088692239610903L;

    double size = 15;

    transient  ImageView star;
    private final static String STAR_IMAGE ="view/resources/Star_Img1.png";
    transient List pList;

    public Star(double x_pos, double y_pos, List pList) {
        super(x_pos, y_pos);
        star=new ImageView(STAR_IMAGE);
        star.setLayoutX(x_pos - size);
        star.setLayoutY(y_pos - size - 10);
        //size=star.getFitHeight()/2;





        pList.add(2,star);
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

//    @Override
//    public void draw(Graphics g) {
//
//    }


    @Override
    public double[] getBounds() {
        double[] ak = {y_position - size - 2, y_position + size + 2};
        return ak;
    }



    @Override
    public void remove(List pList) {
        pList.remove(star);

    }

    @Override
    public void updateObject() {
        if(isOutOfScreen()){
            remove(pList);
        }
        updatePosition();
        star.setLayoutY(y_position - 10);
    }
//    public Paint getColor(){
//        return c;
//    }

    @Override
    public void construct(List pList) {
        this.pList = pList;
        star=new ImageView(STAR_IMAGE);
        star.setLayoutX(this.x_position - size);
        star.setLayoutY(this.y_position - size - 10);
        //size=star.getFitHeight()/2;





        pList.add(2,star);

    }


}