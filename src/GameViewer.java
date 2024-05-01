import javax.swing.*;
import java.awt.*;
public class GameViewer extends JFrame {
    private Game g;
    private Image background;
    private Image instructions;
    private Image playScreen;
    private Image otherScreen;
    public static int WINDOW_WIDTH = 1285;
    public static int WINDOW_HEIGHT = 800;

    public GameViewer(Game game) {
        this.g = game;
        this.background = new ImageIcon("Resources/background.png").getImage();
        this.instructions = new ImageIcon("Resources/instructions.png").getImage();
        this.playScreen = new ImageIcon("Resources/playScreen.png").getImage();
        this.otherScreen = new ImageIcon("Resources/otherScreen.png").getImage();


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
        else if (this.g.getState().equals("play")) {
            playScreen(g);
        }
    }

    // Menu screen
    public void menuScreen(Graphics g) {
        g.drawImage(otherScreen, 0, 0, this);
        g.setColor(Color.white);
        g.setFont(new Font("Serif", Font.BOLD, 60));
        g.drawString("NEON ROCKET", 400, 200);
        g.setFont(new Font("Serif", Font.BOLD, 40));
        g.drawString("Game Instructions (press i)", 400, 300);
        g.drawString("Play (press p)", 400, 400);
        g.drawString("Level (press l)", 400, 500);
    }

    // Instruction screen
    public void instructionsScreen(Graphics g) {
        g.drawImage(instructions, 0, 0, this);
    }

    public void playScreen(Graphics g) {
        g.drawImage(playScreen, 0, 0, this);
        this.g.getRocket().draw(g);
//        g.draw(g);
    }
}
