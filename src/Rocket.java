import javax.swing.*;
import java.awt.*;

public class Rocket {
    private GameViewer gv;
    private int xCoor;
    private int yCoor;
    private double dx;
    private double dy;
    private Image rocketImage;
    private String state;
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
        // If it is not on the starting launchpad, implement gravity
        if (yCoor != 600) {
            dy += Game.GRAVITY;
        }
        // If
        if (yCoor >= 600 && xCoor >= 900) {
            state = "menu";
        }
    }

    public void reset() {
        xCoor = 175;
        yCoor = 600;
        dx = 0;
        dy = 0;
    }
    public void setDX(double dx) {
        this.dx = dx;
    }
    public void setDY(double dy){
        this.dy = dy;
    }
    public void setX(int x) {
        this.xCoor = x;
    }
    public void setY(int y) {
        this.yCoor = y;
    }
}
