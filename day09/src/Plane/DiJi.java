package Plane;

import java.awt.image.BufferedImage;

public class DiJi extends FlyObj implements DiRenLei{
    private int speed=4;
    private int score=10;

    public DiJi() {
        super((int)(Math.random()*(Main.WIDTH-Main.airplane.getWidth())),-Main.airplane.getHeight(),Main.airplane,1);
//        super((int)(Math.random()*(Main.WIDTH-Main.airplane.getWidth())),Main.airplane.getHeight(),Main.airplane);
        super.bao= new BufferedImage[]{Main.airplane_ember0,Main.airplane_ember1,Main.airplane_ember2,Main.airplane_ember3};
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

    @Override
    public int getScore() {
        return score;
    }
}
