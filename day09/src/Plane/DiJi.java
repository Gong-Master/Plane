package Plane;

public class DiJi extends FlyObj implements DiRenLei{
    private int speed=4;
    private int score=10;

    protected DiJi() {
        super((int)(Math.random()*(Main.WIDTH-Main.airplane.getWidth())),-Main.airplane.getHeight(),Main.airplane,1);
//        super((int)(Math.random()*(Main.WIDTH-Main.airplane.getWidth())),Main.airplane.getHeight(),Main.airplane);

    }


    @Override
    public void move() {
        setY(getY()+getSpeed());
    }

    @Override
    public void baozha() {

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
