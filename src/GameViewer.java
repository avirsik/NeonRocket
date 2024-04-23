import javax.swing.*;
import java.awt.*;
public class GameViewer extends JFrame {
    private Game g;
    private Image background;
    private int WINDOW_WIDTH = 1000;
    private int WINDOW_HEIGHT = 900;

    public GameViewer(Game game) {
        this.g = game;
        this.background = new ImageIcon("Resources/background.png").getImage();


        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Game Viewer");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public void paint(Graphics g) {
        if (getState().equals("menu")) {
            menuScreen(g);
        }
    }

    public void menuScreen(Graphics g) {
        g.drawImage(background, 0, 0, this);
    }

}
