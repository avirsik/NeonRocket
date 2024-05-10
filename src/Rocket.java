import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
public class Rocket {
    private GameViewer gv;
    private int xCoor;
    private int yCoor;
    private double dx;
    private double dy;
    private int width;
    private int height;
    private Image rocketImage;
    private ImageObserver observer;
    private String state;

    // Constructors
    public Rocket(int x, int y) {
        this.rocketImage = new ImageIcon("Resources/rocketImage.png").getImage();
        this.xCoor = x;
        this.yCoor = y;
        dx = 0;
        dy = 0;
        this.width = rocketImage.getWidth(observer);
        this.height = rocketImage.getHeight(observer);
    }

    public void draw(Graphics g) {
        g.drawImage(rocketImage, xCoor, yCoor, gv);
    }

    // Makes the rocket disappear if it hits a wall
    public boolean isHittingWall() {
        // Subtracts the width and height of the rocket to make it more accurate
        if (xCoor > gv.WINDOW_WIDTH-50 || xCoor < 0 || yCoor > gv.WINDOW_HEIGHT-180 || yCoor < 0) {
            return true;
        }
        return false;
    }

    public boolean isHittingSomething(Obstacle o) {
        if (xCoor > o.getX() && xCoor < (o.getX() + o.getWidth()) && yCoor > o.getY() && yCoor < (o.getY() + o.getHeight())) {
            return true;
        }
        if ((xCoor + this.width) > o.getX() && xCoor < (o.getX() + o.getWidth()) && (yCoor + this.height) > o.getY() && yCoor < (o.getY() + o.getHeight())) {
            return true;
        }

        return false;
    }

    public boolean isHittingPlatform() {
        if (xCoor > 900 && xCoor < 1093 && (yCoor + height) >= 725) {
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
}
