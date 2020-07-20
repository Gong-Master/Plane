package Plane;

import java.awt.image.BufferedImage;

public class BaoZha {
    private int index;
    private int x,y,i;
    private BufferedImage[] imgs;
    private BufferedImage img;

    public BaoZha(FlyObj obj){
        imgs=obj.bao;
        x=obj.getX();
        y=obj.getY();
        img=obj.getImg();
        i=0;
        index=0;
    }

    public boolean ember(){
        i++;
        if(i%10==0) {
            if(index==imgs.length) {
                return true;
            }
            img=imgs[index++];
        }
        return false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public BufferedImage getImg(){
        return img;
    }
}
