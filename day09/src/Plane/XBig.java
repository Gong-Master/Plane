package Plane;

import java.awt.image.BufferedImage;

public class XBig extends FlyObj implements DiRenLei,JiangLi{
    private int speed=2;
    private int score=100;

    protected XBig() {
        super((int)(Math.random()*(Main.WIDTH-Main.extraplane_n1.getWidth())),-Main.extraplane_n1.getHeight(), Main.extraplane_n1,7);
    }

    private BufferedImage[] XBigp={Main.extraplane_n1,Main.extraplane_n1,
            Main.extraplane_n1,Main.extraplane_n1,Main.extraplane_n1,Main.extraplane_n1,
            Main.extraplane_n1,Main.extraplane_n1,Main.extraplane_n2,
            Main.extraplane_n2,Main.extraplane_n2,Main.extraplane_n2,Main.extraplane_n2,
            Main.extraplane_n2,Main.extraplane_n2,Main.extraplane_n2};
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


    @Override
    public void baozha() {
        count++;
        setImg(XBigp[count%8]);
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
