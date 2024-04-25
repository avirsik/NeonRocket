import javax.swing.*;
import java.awt.*;
public class GameViewer extends JFrame {
    private Game g;
    private Image background;
    private Image instructions;
    private int WINDOW_WIDTH = 1285;
    private int WINDOW_HEIGHT = 600;

    public GameViewer(Game game) {
        this.g = game;
        this.background = new ImageIcon("Resources/background.png").getImage();
        this.instructions = new ImageIcon("Resources/instructions.png").getImage();


        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Game Viewer");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public void paint(Graphics g) {
        if (this.g.getState().equals("menu")) {
            menuScreen(g);
        }
        else if (this.g.getState().equals("instructions")) {
            instructionsScreen(g);
        }
    }

    // Menu screen
    public void menuScreen(Graphics g) {
        g.drawImage(background, 0, 0, this);
        g.setColor(Color.white);
//        g.drawString("                                                                NEON ROCKET\n\n\n                                                                Game Instructions\n                                                                (press i)\n\n                                                                Play\n                                                                (press p)\n\n" +
//                "                                                                Level\n" +
//                "                                                                (press l)");
    }

    // Instruction screen
    public void instructionsScreen(Graphics g) {
        g.drawImage(instructions, 0, 0, this);
    }
}
