package Plane;

import javax.management.MBeanAttributeInfo;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class Hero extends FlyObj {

    private int score=0;
    private Zidan[] bullet;
    private int speed=8;
    private int leixing=0;
    private int countzidan=0;

    public Hero(){
        super(Main.WIDTH/2-Main.hero0.getWidth()/2,Main.HEIGHT-Main.hero0.getHeight()-30,Main.hero0,3);
        super.bao= new BufferedImage[]{Main.hero_ember0,Main.hero_ember1,Main.hero_ember2,Main.hero_ember3};
//    [Main.hero_ember0,Main.hero_ember1,Main.hero_ember2,Main.hero_ember3];
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

    public Zidan[] getBullet() {
        return bullet;
    }

    public void setBullet(Zidan[] bullet) {
        this.bullet = bullet;
    }

//    private BufferedImage[] herosImg={Main.hero1,Main.hero1,Main.hero1,Main.hero1,Main.hero0,Main.hero0,Main.hero0,Main.hero0};
    private int count=0;
    @Override
    public void move() {
        count++;
        if(count%20<10) {
            setImg(Main.hero1);
        }else
            setImg(Main.hero0);
//        setImg(herosImg[count%8]);
    }


    public void setCountzidan(int countzidan) {
        this.countzidan = countzidan;
    }

    public Zidan[] shoot(){
        Zidan[] buls;
        if(countzidan==80){
            leixing=0;
            countzidan=0;
        }
        if(leixing==0) {
            buls = new Zidan[1];
            buls[0] = new Zidan(getX() + getWeight() / 2 - Main.chaojizidan.getWidth() / 2, getY() - Main.chaojizidan.getHeight());
        }
        else{
            buls = new Zidan[2];
            buls[0] = new Zidan(getX() + getWeight() / 2 - getWeight() / 4 - Main.chaozidan.getWidth(), getY() ,1);
            buls[1] = new Zidan(getX() + getWeight() / 2 + getWeight() / 4, getY(),1);
            countzidan++;
        }
        return buls;
    }

    public boolean shootByFly(FlyObj fly){
        if (this.getX() > fly.getX() - this.getWeight() && this.getX() < fly.getX() + fly.getWeight() &&
                this.getY() > fly.getY() - this.getHeight() && this.getY() < fly.getY() + fly.getHeight()) {
            return true;
        }else
            return false;
    }

    public void addScore(int score){
        this.score+=score;
    }

    public void addLife() {
        this.setLife(this.getLife() + 1);
    }

    public void setLeixing(int leixing) {
        this.leixing = leixing;
    }
}
