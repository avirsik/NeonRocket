import javax.swing.*;
import java.awt.*;

public class Obstacle {
    private GameViewer gv;
    private int width;
    private int height;
    private int x;
    private int y;
    private boolean isStar;
    private Image image;


    public Obstacle(int number, int x, int y) {
        image = new ImageIcon("Resources/asteroid" + number + ".png").getImage();
        this.isStar = false;
        this.x = x;
        this.y = y;
    }

    public Obstacle(int x, int y) {
        this.image = new ImageIcon("Resources/star.png").getImage();
        this.isStar = true;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void draw(Graphics g) {
        g.drawImage(this.image, x, y, gv);
    }

}
