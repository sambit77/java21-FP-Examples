import java.awt.*;
import java.util.*;
class Hal{

    public static void main(String[] args) throws Exception{
        Robot hal = new Robot();
        Random random = new Random();
        while(true){
            hal.delay(1000 * 60);
            Point point = MouseInfo.getPointerInfo().getLocation();
            int x = point.x;
            int y = point.y;
            hal.mouseMove(x,y);
        }
    }
}