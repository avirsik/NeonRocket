import javax.swing.*;
import java.awt.*;

public class Rocket {
    private GameViewer gv;
    private int xCoor;
    private int yCoor;
    private double dx;
    private double dy;
    private Image rocketImage;
    // Constructors
    public Rocket(int x, int y) {
        this.xCoor = x;
        this.yCoor = y;
        dx = 0;
        dy = 0;
        this.rocketImage = new ImageIcon("Resources/rocketImage.png").getImage();
    }

    public void draw(Graphics g) {
        g.drawImage(rocketImage, xCoor, yCoor, gv);
    }

    // Makes the rocket disappear if it hits a wall
//    public void isHittingWall() {
//        if (xCoor > 1285 || xCoor < 0 || yCoor > 600 || yCoor < 0) {
//
//        }
//    }

    public void move() {
        xCoor+=dx;
        yCoor+=dy;
    }
}
