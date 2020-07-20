package Plane;

import java.awt.image.BufferedImage;

public class XBig extends FlyObj implements DiRenLei,JiangLi{
    private int speed=2;
    private int score=100;

    public XBig() {
        super((int)(Math.random()*(Main.WIDTH-Main.extraplane_n1.getWidth())),-Main.extraplane_n1.getHeight(), Main.extraplane_n1,7);
        super.bao= new BufferedImage[]{Main.extraplane_ember0,Main.extraplane_ember1 ,Main.extraplane_ember2,Main.extraplane_ember3,Main.extraplane_ember4,Main.extraplane_ember5};
    }

    private int count=0;
    @Override
    public void move() {
        count++;
        if(count%28<14) {
            setImg(Main.extraplane_n1);
        }else
            setImg(Main.extraplane_n2);
        setY(getY()+getSpeed());
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public int getScore() {
        return score;
    }
}
