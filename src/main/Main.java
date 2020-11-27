package main;

import newFrame.TankFrame_v2;

public class Main {
    public static void main(String[] args) throws Exception{
        TankFrame_v2 t2 = new TankFrame_v2();

        while(true){
            Thread.sleep(88);
            t2.repaint();
        }
    }
}
