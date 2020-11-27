package bulletAttributes;

import newFrame.Direction;

import java.awt.*;

public class BulletAttributes {

    //炮弹的宽度和高度
    private static int WIDTH=5, HEIGHT=5;
    private int x, y;

    //炮弹的速度
    private static final int SPEED=10;
    private Direction dir;

    public BulletAttributes(int x, int y, Direction dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
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


    public void paint(Graphics g){
        Color cr = g.getColor();
        g.setColor(Color.red);
        g.fillOval(x,y,WIDTH,HEIGHT);
        g.setColor(cr);

        move();
    }

    private void move() {
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
}
