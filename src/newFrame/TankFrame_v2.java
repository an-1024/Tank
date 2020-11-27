package newFrame;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame_v2 extends Frame {

    int x=200, y=200;

    public TankFrame_v2() throws HeadlessException {
        //设置窗体大小
        setSize(800,600);
        //禁止改变大小
        setResizable(false);
        //设置窗体title
        setTitle("Tank.exe");
        setVisible(true);


        //设置关闭关比窗口功能
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });


        //按键设置
        this.addKeyListener(new MyKeyListener());

    }

    @Override
    public void paint(Graphics g) {
        System.out.println("paint");
        g.fillRect(x,y,50,50);
//        x+=20;
//        y+=20;

    }

    public static void main(String[] args) {
        TankFrame_v2 frame = new TankFrame_v2();
    }

    class MyKeyListener extends KeyAdapter{

        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("key pressed");
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:
                    bL=true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bU=true;
                    break;
                case KeyEvent.VK_UP:
                    bR=true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD=true;
                    break;

            }
//            x+=200;
//            repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("key released");
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:
                    bL=false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bU=false;
                    break;
                case KeyEvent.VK_UP:
                    bR=false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD=false;
                    break;

            }
        }
    }
}
