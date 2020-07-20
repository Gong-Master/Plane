package Plane;

import java.awt.image.BufferedImage;

public class BigDJ extends FlyObj implements DiRenLei{
    private int speed=3;
    private int score=45;

    public BigDJ() {
        super((int)(Math.random()*(Main.WIDTH-Main.bigplane.getWidth())),-Main.bigplane.getHeight(), Main.bigplane,4);
//        super((int)(Math.random()*(Main.WIDTH-Main.bigplane.getWidth())),Main.bigplane.getHeight(), Main.bigplane);
        super.bao= new BufferedImage[]{Main.bigplane_ember0,Main.bigplane_ember1,Main.bigplane_ember2,Main.bigplane_ember3};
    }

    @Override
    public void move() {
        setY(getY()+getSpeed());
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
