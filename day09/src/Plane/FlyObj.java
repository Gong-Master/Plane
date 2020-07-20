package Plane;

import java.awt.image.BufferedImage;

public abstract class FlyObj {

    private int x;
    private int y;
    private BufferedImage img;
    private int height;
    private int weight;
    private int life=1;

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    protected FlyObj(int x, int y, BufferedImage img,int life) {
        this.x = x;
        this.y = y;
        this.img = img;
        this.weight = img.getWidth();
        this.height = img.getHeight();
        this.life=life;
    }

    public abstract void move();

    public abstract void baozha();

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void minusLife() {
        this.life--;
    }

    public boolean shootByBu(Zidan b){
        if (b.getX() > this.getX() - b.getWeight() && b.getX() < this.getX() + this.getWeight()
                && b.getY() > this.getY() - b.getHeight() && b.getY() < this.getY() + this.getHeight()) {
            return true;
        }else
            return false;
    }

}