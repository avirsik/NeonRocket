import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Rocket {
    private GameViewer gv;
    private int xCoor;
    private int yCoor;
    private double dx;
    private double dy;
    private Image rocketImage;
    private String state;
    private int tiltAngle;

    // Constructors
    public Rocket(int x, int y) {
        this.xCoor = x;
        this.yCoor = y;
        dx = 0;
        dy = 0;
        tiltAngle = 0;
        this.rocketImage = new ImageIcon("Resources/rocketImage.png").getImage();
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
    public boolean isHittingSomething(int xStart, int yStart) {
        File file = new File("Resources/landingPlatform.png"); // Provide the path to your image file
        int width = 0;
        int height = 0;
        try {
            BufferedImage image = ImageIO.read(file);
            width = xStart + image.getWidth();
            height = yStart + image.getHeight();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        if (xCoor > xStart && xCoor < height && yCoor > yStart && yCoor < width) {
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
