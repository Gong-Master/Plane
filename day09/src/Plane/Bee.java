package Plane;

import java.awt.image.BufferedImage;

public class Bee extends FlyObj implements JiangLi{

    private int life=1;
    private boolean b=true;
    public Bee(){
        super((int)(Math.random()*(Main.WIDTH-Main.bee.getWidth())),-Main.bee.getHeight(),Main.xiaobee,1);
//        super((int)(Math.random()*(Main.WIDTH-Main.bee.getWidth())),Main.bee.getHeight(),Main.bee);
        super.bao= new BufferedImage[]{Main.bee_ember0,Main.bee_ember1,Main.bee_ember2,Main.bee_ember3};
    }

    @Override
    public void move() {
        if(getX()+2>Main.WIDTH-getWeight()){
            b=false;
        }
        if(getX()-5<0){
            b=true;
        }
        if(b) {
            setX(getX() + 2);
            setY(getY() + 3);
        }else{
            setX(getX() - 2);
            setY(getY() + 3);
        }
    }

}
