package newFrame;

import bulletAttributes.BulletAttributes;
import tankAttributes.TankAttributes;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame_v2 extends Frame {
    TankAttributes myTank = new TankAttributes(200,200, Direction.DOWN);
    BulletAttributes bullet = new BulletAttributes(300,300,Direction.DOWN);

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

    //将画笔传给tank自己，让它自己主导
    @Override
    public void paint(Graphics g) {
        myTank.paint(g);
        bullet.paint(g);
    }

    class MyKeyListener extends KeyAdapter{

        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:
                    bL=true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR=true;
                    break;
                case KeyEvent.VK_UP:
                    bU=true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD=true;
                    break;
                default:
                    break;

            }

            setMainTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:
                    bL=false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR=false;
                    break;
                case KeyEvent.VK_UP:
                    bU=false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD=false;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        private void setMainTankDir() {
            //在没有按键的时候，保持静止状态
            if(!bL && !bU && !bR && !bD){
                myTank.setMoving(false);
            }else {
                //设置tank的时候，开始移动
                myTank.setMoving(true);
                if (bL) {
                    myTank.setDir(Direction.LEFT);
                }
                if (bU) {
                    myTank.setDir(Direction.UP);
                }
                if (bR) {
                    myTank.setDir(Direction.RIGHT);
                }
                if (bD) {
                    myTank.setDir(Direction.DOWN);
                }
            }
        }
    }
}
