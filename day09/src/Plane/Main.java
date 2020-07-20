package Plane;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TimerTask;

public class Main extends JPanel{
    static BufferedImage hero0;
    static BufferedImage bee;
    static BufferedImage airplane;
    static BufferedImage bigplane;
    static BufferedImage bullet;
    static BufferedImage airplane_ember0;
    static BufferedImage airplane_ember1;
    static BufferedImage airplane_ember2;
    static BufferedImage airplane_ember3;
    static BufferedImage background;
    static BufferedImage bee_ember0;
    static BufferedImage bee_ember1;
    static BufferedImage bee_ember2;
    static BufferedImage bee_ember3;
    static BufferedImage bigplane_ember0;
    static BufferedImage bigplane_ember1;
    static BufferedImage bigplane_ember2;
    static BufferedImage bigplane_ember3;
    static BufferedImage extraplane_ember0;
    static BufferedImage extraplane_ember1;
    static BufferedImage extraplane_ember2;
    static BufferedImage extraplane_ember3;
    static BufferedImage extraplane_ember4;
    static BufferedImage extraplane_ember5;
    static BufferedImage extraplane_hit;
    static BufferedImage extraplane_n1;
    static BufferedImage extraplane_n2;
    static BufferedImage gameover;
    static BufferedImage hero_ember0;
    static BufferedImage hero_ember1;
    static BufferedImage hero_ember2;
    static BufferedImage hero_ember3;
    static BufferedImage hero1;
    static BufferedImage pause;
    static BufferedImage start;
    static BufferedImage chaozidan;
    static BufferedImage chaojizidan;
    static BufferedImage xiaobee;
    static {
        try {
            xiaobee= ImageIO.read(Main.class.getResourceAsStream("pict/xiaobee.png"));
            chaozidan= ImageIO.read(Main.class.getResourceAsStream("pict/chaozidan.png"));
            chaojizidan= ImageIO.read(Main.class.getResourceAsStream("pict/chaojizidan.png"));
            hero0= ImageIO.read(Main.class.getResourceAsStream("pict/hero0.png"));
            bee= ImageIO.read(Main.class.getResourceAsStream("pict/bee.png"));
            airplane= ImageIO.read(Main.class.getResourceAsStream("pict/airplane.png"));
            bigplane= ImageIO.read(Main.class.getResourceAsStream("pict/bigplane.png"));
            bullet= ImageIO.read(Main.class.getResourceAsStream("pict/bullet.png"));
            airplane_ember0= ImageIO.read(Main.class.getResourceAsStream("pict/airplane_ember0.png"));
            airplane_ember1= ImageIO.read(Main.class.getResourceAsStream("pict/airplane_ember1.png"));
            airplane_ember2= ImageIO.read(Main.class.getResourceAsStream("pict/airplane_ember2.png"));
            airplane_ember3= ImageIO.read(Main.class.getResourceAsStream("pict/airplane_ember3.png"));
            background= ImageIO.read(Main.class.getResourceAsStream("pict/background.png"));
            bee_ember0= ImageIO.read(Main.class.getResourceAsStream("pict/bee_ember0.png"));
            bee_ember1= ImageIO.read(Main.class.getResourceAsStream("pict/bee_ember1.png"));
            bee_ember2= ImageIO.read(Main.class.getResourceAsStream("pict/bee_ember2.png"));
            bee_ember3= ImageIO.read(Main.class.getResourceAsStream("pict/bee_ember3.png"));
            bigplane_ember0= ImageIO.read(Main.class.getResourceAsStream("pict/bigplane_ember0.png"));
            bigplane_ember1= ImageIO.read(Main.class.getResourceAsStream("pict/bigplane_ember1.png"));
            bigplane_ember2= ImageIO.read(Main.class.getResourceAsStream("pict/bigplane_ember2.png"));
            bigplane_ember3= ImageIO.read(Main.class.getResourceAsStream("pict/bigplane_ember3.png"));
            extraplane_ember0= ImageIO.read(Main.class.getResourceAsStream("pict/extraplane_ember0.png"));
            extraplane_ember1= ImageIO.read(Main.class.getResourceAsStream("pict/extraplane_ember1.png"));
            extraplane_ember2= ImageIO.read(Main.class.getResourceAsStream("pict/extraplane_ember2.png"));
            extraplane_ember3= ImageIO.read(Main.class.getResourceAsStream("pict/extraplane_ember3.png"));
            extraplane_ember4= ImageIO.read(Main.class.getResourceAsStream("pict/extraplane_ember4.png"));
            extraplane_ember5= ImageIO.read(Main.class.getResourceAsStream("pict/extraplane_ember5.png"));
            extraplane_hit= ImageIO.read(Main.class.getResourceAsStream("pict/extraplane_hit.png"));
            extraplane_n1= ImageIO.read(Main.class.getResourceAsStream("pict/extraplane_n1.png"));
            extraplane_n2= ImageIO.read(Main.class.getResourceAsStream("pict/extraplane_n2.png"));
            gameover= ImageIO.read(Main.class.getResourceAsStream("pict/gameover.png"));
            hero_ember0= ImageIO.read(Main.class.getResourceAsStream("pict/hero_ember0.png"));
            hero_ember1= ImageIO.read(Main.class.getResourceAsStream("pict/hero_ember1.png"));
            hero_ember2= ImageIO.read(Main.class.getResourceAsStream("pict/hero_ember2.png"));
            hero_ember3= ImageIO.read(Main.class.getResourceAsStream("pict/hero_ember3.png"));
            hero1= ImageIO.read(Main.class.getResourceAsStream("pict/hero1.png"));
            pause= ImageIO.read(Main.class.getResourceAsStream("pict/pause.png"));
            start= ImageIO.read(Main.class.getResourceAsStream("pict/start.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //非整合：
//    private ArrayList<Zidan> bullets=new ArrayList<Zidan>();
//    private ArrayList<DiJi> dijis=new ArrayList<DiJi>();
//    private ArrayList<BigDJ> bigdj=new ArrayList<BigDJ>();
//    private ArrayList<Bee> bees=new ArrayList<Bee>();

    private Hero h=new Hero();

    //整合：
    private ArrayList<FlyObj> flyings = new ArrayList<>();
    private ArrayList<Zidan> bulletList =new ArrayList<>();
    private ArrayList<BaoZha> baozhas =new ArrayList<>();

    //游戏状态:
    public final int START=0;
    public final int RUNING=1;
    public final int ZANTING=2;
    public final int GAME_OVER=3;

    private int state=START;


    private int flyingcount=0;
    private void creatFlyingObj(){
        flyingcount++;
        if(flyingcount%20==0){
            int ran=(int)(Math.random()*30);
            FlyObj fly;
            if(ran <1){
                fly=new Bee();
            }else if(ran < 7){
                fly=new BigDJ();
            }else if(ran>28){
                fly=new XBig();
            } else {
                fly=new DiJi();
            }
            flyings.add(fly);
        }
    }

    private static int bullcount=0;
    private void shoutAction() {
        bullcount++;
        if(bullcount%12==0) {
            Zidan[] bs = h.shoot();
            bulletList.addAll(Arrays.asList(bs));
//            for(int i=0;i<bs.length;i++){
//                bulletList.add(bs[i]);
//            }

//            bulletList.add(h.shoot()[0]);
        }
    }

    //非整合计时：
//    int time=0;

    private void paintBullets(Graphics g){
        for(int i=0;i<bulletList.size();i++){
            Zidan fly=bulletList.get(i);
            g.drawImage(fly.getImg(),fly.getX(),fly.getY(),this);
        }
    }

    private void paintFlyings(Graphics g){
        for(int i=0;i<flyings.size();i++){
            FlyObj fly=flyings.get(i);
            g.drawImage(fly.getImg(),fly.getX(),fly.getY(),this);
        }
    }

    private void paintEmber(Graphics g){
        for(int i=0;i<baozhas.size();i++){
            BaoZha fly=baozhas.get(i);
            g.drawImage(fly.getImg(),fly.getX(),fly.getY(),this);
        }
    }

    private void paintScore(Graphics g) {
        Font font=new Font("微软雅黑",3,25);
        g.setFont(font);
        Color c=new Color(241, 123, 118);
        g.setColor(c);
        g.drawString("分数:" + h.getScore(), 10, 30);
        g.drawString("生命值:" + h.getLife(), 10, 60);
    }
    //绘图：
    public void paint(Graphics g){

        super.paint(g);
        //背景图+分数生命值
        g.drawImage(Main.background, 0, 0, this);

        //整合版：
        paintScore(g);
        paintFlyings(g);
        paintBullets(g);
        paintEmber(g);
        g.drawImage(h.getImg(), h.getX(), h.getY(), this);

//        非整合计时器：

//        time++;
//        if (time == 10000) {
//            time = 0;
//        }

        //英雄机
//        h.move();
//        g.drawImage(h.getImg(), h.getX(), h.getY(), this);

        //绘画测试：
//        g.drawImage(h1.getImg(),h1.getX(),h1.getY(),this);

//        BigDJ bdj=new BigDJ();
//        g.drawImage(bdj.getImg(),bdj.getX(),bdj.getY(),this);
//        bdj.move();

//        Bee mifeng=new Bee();
//        g.drawImage(mifeng.getImg(),mifeng.getX(),mifeng.getY(),this);
//        mifeng.move();

//        DiJi dj=new DiJi();
//        g.drawImage(dj.getImg(),dj.getX(),dj.getY(),this);
//        dj.move();

        //非整合子弹创建存储：
//        if (time % 20 == 0) {
//                //创建子弹对象设置坐标
//            Zidan bullet = new Zidan(h.getX() + h.getWeight() / 2 - Main.bullet.getWidth() / 2, h.getY() - Main.bullet.getHeight());
//                //存取子弹
//            this.bullets.add(bullet);
////       -------------------         bullet.move();
//            System.out.println(time);
//
////            Zidan zd = new Zidan(h1.getX() + h1.getWeight() / 2 - Main.bullet.getWidth() / 2, h1.getY() - Main.bullet.getHeight());
////        System.out.println("子弹：X："+zd.getX()+" Y："+zd.getY());
////            g.drawImage(zd.getImg(), zd.getX(), zd.getY(), this);
////            zd.move();
////        System.out.println("子弹：X："+zd.getX()+" Y："+zd.getY());
//        }
//        for (int i = 0; i < bullets.size(); i++) {
//            g.drawImage(this.bullets.get(i).getImg(), this.bullets.get(i).getX(), this.bullets.get(i).getY(), this);
//            this.bullets.get(i).move();
//            if (this.bullets.get(i).getY() < 0) {
//                this.bullets.remove(i);
//            }
//        }

        //非整合小敌机：
//        if ((int)(Math.random()*1000) < 7) {
//            //创建小敌机对象设置坐标
//            DiJi bullet1 = new DiJi();
//            //存取敌机
//            this.dijis.add(bullet1);
////       --------     bullet.move();
//            System.out.println(time);
//        }
//
//        //非整合小敌机绘制和碰撞：
//        for (int i = 0; i < dijis.size(); i++) {
//            g.drawImage(this.dijis.get(i).getImg(), this.dijis.get(i).getX(), this.dijis.get(i).getY(), this);
//            this.dijis.get(i).move();
//            if (this.dijis.get(i).getY() > Main.HEIGHT) {
//                this.dijis.remove(i);
//                i--;
//            }else {
//                for (int j = 0; j < bullets.size(); j++) {
//                    if (bullets.get(j).getX() > this.dijis.get(i).getX() - this.bullets.get(j).getWeight() && bullets.get(j).getX() < this.dijis.get(i).getX() + this.dijis.get(i).getWeight() &&
//                            bullets.get(j).getY() > this.dijis.get(i).getY() - bullets.get(j).getHeight() && bullets.get(j).getY() < this.dijis.get(i).getY() + this.dijis.get(i).getHeight()) {
//                        this.dijis.remove(i);
//                        bullets.remove(j);
//                        i--;
//                        h.setScore(h.getScore()+10);
//                        break;
//                    }
//                }
//
//            }
//        }

        //非整合大敌机：
//        if ((int)(Math.random()*1000) < 4) {
//            //创建大敌机对象设置坐标
//            BigDJ bullet = new BigDJ();
//            //存取大敌机
//            this.bigdj.add(bullet);
////      ---------       bullet.move();
//            System.out.println(time);
//        }
//        for (int i = 0; i < bigdj.size(); i++) {
//            g.drawImage(this.bigdj.get(i).getImg(), this.bigdj.get(i).getX(), this.bigdj.get(i).getY(), this);
//            this.bigdj.get(i).move();
//            if (this.bigdj.get(i).getY() > Main.HEIGHT) {
//                this.bigdj.remove(i);
//            }
//        }

        //非整合小蜜蜂：
//        if ((int)(Math.random()*1000) == 1) {
//            //创建小蜜蜂对象设置坐标
//            Bee bullet = new Bee();
//            //存取小蜜蜂
//            this.bees.add(bullet);
////      ----------          bullet.move();
//            System.out.println(time);
//        }
//        for (int i = 0; i < bees.size(); i++) {
//            g.drawImage(this.bees.get(i).getImg(), this.bees.get(i).getX(), this.bees.get(i).getY(), this);
//            this.bees.get(i).move();
//            if (this.bees.get(i).getY() > Main.HEIGHT) {
//                this.bees.remove(i);
//            }
//        }

        if(state==GAME_OVER){
            g.drawImage(Main.gameover, 0, 0, this);
            h.setX(Main.WIDTH/2-Main.hero0.getWidth()/2);
            h.setY(Main.HEIGHT-Main.hero0.getHeight()-30);
        }


        if(state==ZANTING){
            g.drawImage(Main.pause, 0, 0, this);
        }
        if(state==START){
            h.setLife(3);
            h.setLeixing(0);
            h.setScore(0);
            g.drawImage(Main.start, 0, 0, this);
            for(int i=0;i<bulletList.size();i++){
                bulletList.remove(i);
                i--;
            }
            for(int i=0;i<flyings.size();i++){
                flyings.remove(i);
                i--;
            }
        }

    }

    public static final int WIDTH=400;
    public static final int HEIGHT=700;
    //主方法
    public static void main(String[] args){
        JFrame window =new JFrame("飞机大战");
        window.setSize(WIDTH,HEIGHT);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Main main =new Main();
        window.addMouseMotionListener(main.adapter);
        window.addMouseListener(main.adapter);
        window.add(main);
        window.setVisible(true);
        main.action();
    }


    //计时器：
    public void action(){
        java.util.Timer timer=new java.util.Timer();
        timer.schedule(new TimerTask(){
            @Override
            public void run() {
                //PANDUAN
                if(state==RUNING) {
                    creatFlyingObj();
                    FlyingObjSteps();
                    h.move();
                    shoutAction();
//                BulletSteps();
                    OutOfBountsAction();
                    ZiDiPeng();
                    HeDiPeng();

                    baoZhaAction();

                }
                repaint();
            }


        },2000,15);
//        while (true){
//            repaint(200);
//        }
    }

    private void FlyingObjSteps(){
        for(int i=0;i<flyings.size();i++){
            FlyObj fly=flyings.get(i);
            fly.move();
        }
        for (FlyObj fly : bulletList) {
            fly.move();
        }
    }
    private void BulletSteps(){

    }

    private void OutOfBountsAction(){
        for(int i=0;i<flyings.size();i++){
            FlyObj fly=flyings.get(i);
            if(fly.getY()>Main.HEIGHT){
                flyings.remove(i);
                i--;
            }
        }
        for(int i=0;i<bulletList.size();i++){
            FlyObj b=bulletList.get(i);
            if(b.getY()<=-b.getHeight()){
                bulletList.remove(i);
                i--;
            }
        }
    }

    private void baoZhaAction(){
        for(int i=0;i<baozhas.size();i++){
            if(baozhas.get(i).ember()){
                baozhas.remove(i);
                i--;
            }
        }
    }

    private void ZiDiPeng() {
        for (int i = 0; i < bulletList.size(); i++) {
            for (int j = 0; j <flyings .size(); j++) {
                Zidan b = bulletList.get(i);
                FlyObj fly = flyings.get(j);
                if (fly.shootByBu(b)) {
                    fly.minusLife();
                    if(fly.getLife()==0){
                        if(fly instanceof DiRenLei){
                            h.addScore(((DiRenLei) fly).getScore());
                        }
                        if(fly instanceof JiangLi){
                            int a=(int)(Math.random()*2);
                            if(a==1){
                                h.addLife();
                            }else{
                                h.setLeixing(1);
                                h.setCountzidan(0);
                            }
                        }
                        baozhas.add(new BaoZha(fly));
                        flyings.remove(j);

                    }
                    bulletList.remove(i);
                    i--;
                    break;
                }
            }
        }
    }

    private void HeDiPeng() {
        for (int i = 0; i < flyings.size(); i++) {
            if (h.shootByFly(flyings.get(i))) {
                baozhas.add(new BaoZha(flyings.get(i)));
                this.flyings.remove(i);
                h.minusLife();
                baozhas.add(new BaoZha(h));
                if (h.getLife() == 0) {
                    state = GAME_OVER;
                }
                break;
            }
        }
    }


    MouseAdapter adapter =new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if(state==START){
                state=RUNING;
            }else if(state==GAME_OVER){
                state=START;
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if(state==ZANTING){
                state=RUNING;
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(state==RUNING){
                state=ZANTING;
            }
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            if(state==RUNING){
                h.setX(e.getX()-h.getWeight()/2);
                h.setY(e.getY()-h.getHeight()/2);
            }
        }
    };

}
