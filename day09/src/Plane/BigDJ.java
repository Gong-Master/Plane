package Plane;

import java.awt.image.BufferedImage;

public class BigDJ extends FlyObj implements DiRenLei{
    private int speed=3;
    private int score=45;

    protected BigDJ() {
        super((int)(Math.random()*(Main.WIDTH-Main.bigplane.getWidth())),-Main.bigplane.getHeight(), Main.bigplane,4);
//        super((int)(Math.random()*(Main.WIDTH-Main.bigplane.getWidth())),Main.bigplane.getHeight(), Main.bigplane);
    }

    @Override
    public void move() {
        setY(getY()+getSpeed());
    }


    private BufferedImage[] BigDJs={Main.bigplane_ember0,Main.bigplane_ember0,
            Main.bigplane_ember0,Main.bigplane_ember0,Main.bigplane_ember0,
            Main.bigplane_ember0,Main.bigplane_ember0,Main.bigplane_ember0};
    private int count=0;
    @Override
    public void baozha() {
        count++;
        setImg(BigDJs[count%8]);
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
