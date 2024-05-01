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
    public boolean isHittingWall() {
        if (xCoor > gv.WINDOW_WIDTH || xCoor < 0 || yCoor > gv.WINDOW_HEIGHT || yCoor < 0) {
            return true;
        }
        return false;
    }

    public void move() {
        xCoor+=dx;
        yCoor+=dy;
    }

    public void setDX(double dx) {
        this.dx = dx;
    }
    public void setDY(double dy){
        this.dy = dy;
    }
}
