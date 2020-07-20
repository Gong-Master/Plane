package Plane;

public class Zidan extends FlyObj{

    public Zidan(int x,int y){
        super(x,y,Main.chaozidan,1);
    }
    public Zidan(int x,int y,int i){
        super(x,y,Main.chaojizidan,1);
    }


    private int speed=7;
    @Override
    public void move() {
        setY(getY()-getSpeed());
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
