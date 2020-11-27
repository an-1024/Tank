package newFrame;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame {
    public static void main(String[] args) {
        //显示窗口
        Frame f = new Frame();
        //设置窗体大小
        f.setSize(800,600);
        //禁止改变大小
        f.setResizable(false);
        //设置窗体title
        f.setTitle("Tank.exe");
        f.setVisible(true);


        //设置关闭关比窗口功能
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
