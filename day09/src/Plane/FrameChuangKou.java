package Plane;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;

public class FrameChuangKou {
    public static void main(String[] args) {
        JFrame my = new JFrame("飞机大战");
        my.setSize(400,650);
        my.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyJP p = new MyJP();
        my.add(p);
        my.setVisible(true);
    }
}
class MyJP extends JPanel{
    public void paint(Graphics g){
        super.paint(g);
        Font font=new Font("宋体",3,30);
        g.setFont(font);
        Color c=new Color(241, 123, 118);
        g.setColor(c);
//        g.setColor(Color.pink);

        g.drawString("HJHOILJ",40,150);
        paintPlane(g);
        xDP(g);
        heroP(g);
    }
    private void paintPlane(Graphics g){
        BufferedImage img=null;
        try {
            img= ImageIO.read(MyJP.class.getResourceAsStream("pict/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
//        g.drawImage(img,0,0,60,60,this);
        g.drawImage(img,0 ,0,this);
    }
    private void xDP(Graphics g){
        BufferedImage img=null;
        try {
            img= ImageIO.read(MyJP.class.getResourceAsStream("pict/airplane.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
//        g.drawImage(img,0,0,60,60,this);
        g.drawImage(img,(int)(Math.random()*310)+50 ,0,this);
//        g.drawImage(Main.background,0 ,0,this);
    }
    private void heroP(Graphics g){
        BufferedImage img=null;
        try {
            img= ImageIO.read(MyJP.class.getResourceAsStream("pict/hero1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
//        g.drawImage(img,0,0,60,60,this);
        g.drawImage(img,151 ,476,this);
    }
}