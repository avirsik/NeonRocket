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
    private int tiltAngle;

    // Constructors
    public Rocket(int x, int y) {
        this.rocketImage = new ImageIcon("Resources/rocketImage.png").getImage();
        this.xCoor = x;
        this.yCoor = y;
        dx = 0;
        dy = 0;
        this.width = rocketImage.getWidth(observer);
        this.height = rocketImage.getHeight(observer);
        tiltAngle = 0;
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
//    public boolean isHittingSomething(int xStart, int yStart) {
//        File file = new File("Resources/landingPlatform.png"); // Provide the path to your image file
//        int width = 0;
//        int height = 0;
//        try {
//            BufferedImage image = ImageIO.read(file);
//            width = xStart + image.getWidth();
//            height = yStart + image.getHeight();
//
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
//        if (xCoor > xStart && xCoor < height && yCoor > yStart && yCoor < width) {
//            return true;
//        }
//        return false;
//    }

    public boolean isHittingsomething(Obstacle o) {
        if (xCoor > o.getX() && xCoor < (o.getX() + o.getWidth()) && yCoor > o.getY() && yCoor < (o.getY() + o.getHeight())) {
            return true;
        }
        else if (xCoor + this.width > o.getX() && xCoor < (o.getX() + o.getWidth()) && yCoor + this.height > o.getY() && yCoor < (o.getY() + o.getHeight())) {
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
