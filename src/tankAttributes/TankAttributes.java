package tankAttributes;

import bulletAttributes.BulletAttributes;
import newFrame.Direction;
import newFrame.TankFrame_v2;

import java.awt.*;

public class TankAttributes {
    private int x, y;
    //初始方向
    private Direction dir = Direction.DOWN;
    //移动速度
    private static final int SPEED=5;

    //初始状态
    private boolean moving = false;

    //如何让tank打出子弹
    private TankFrame_v2 tf = null;

    public TankAttributes(int x, int y, Direction dir, TankFrame_v2 tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

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

    public Direction getDir() {
        return dir;
    }

    public void setDir(Direction dir) {
        this.dir = dir;
    }

    public static int getSPEED() {
        return SPEED;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    //将画笔交给tank自己，因为只有tank最知道自己的属性，而不是由我们
    //将属性取出来赋值
    public void paint(Graphics g) {
        Color cr = g.getColor();
        g.setColor(Color.YELLOW);
        g.fillRect(x,y,50,50);
        g.setColor(cr);
        move();
    }

    private void move() {
        if(!moving){
            return;
        }
        switch(dir){
            case LEFT:
                x-=SPEED;
                break;
            case UP:
                y-=SPEED;
                break;
            case RIGHT:
                x+=SPEED;
                break;
            case DOWN:
                y+=SPEED;
                break;
            default:
                break;
        }
    }

    //再将子弹在tankFrame_v2中new出来，并显示
    public void fire() {
        tf.bullet = new BulletAttributes(this.x, this.y, this.dir);
    }
}
