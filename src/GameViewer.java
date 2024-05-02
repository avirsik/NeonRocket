import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class GameViewer extends JFrame {
    private Game g;
    private Image background;
    private Image instructions;
    private Image playScreen;
    private Image otherScreen;
    private Image logo;
    private Image launchpad;
    private Image platform;
    private Image asteroid1;
    private Image landingPlatform;
    private Image asteroid2;
    public static int WINDOW_WIDTH = 1285;
    public static int WINDOW_HEIGHT = 800;

    public GameViewer(Game game) {
        this.g = game;
        this.background = new ImageIcon("Resources/background.png").getImage();
        this.instructions = new ImageIcon("Resources/instructions.png").getImage();
        this.playScreen = new ImageIcon("Resources/playScreen.png").getImage();
        this.otherScreen = new ImageIcon("Resources/otherScreen.png").getImage();
        this.logo = new ImageIcon("Resources/logo.png").getImage();
        this.launchpad = new ImageIcon("Resources/launchpad.png").getImage();
        this.platform = new ImageIcon("Resources/platform.png").getImage();
        this.asteroid1 = new ImageIcon("Resources/asteroid1.png").getImage();
        this.landingPlatform = new ImageIcon("Resources/landingPlatform.png").getImage();
        this.asteroid2 = new ImageIcon("Resources/asteroid2.png").getImage();


        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Game Viewer");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
        createBufferStrategy(2);
    }

    public void paint(Graphics g) {
        BufferStrategy bf = this.getBufferStrategy();
        if (bf == null)
            return;
        Graphics g2 = null;
        try {
            g2 = bf.getDrawGraphics();
            myPaint(g2);
        }
        finally {
            g2.dispose();
        }
        bf.show();
        Toolkit.getDefaultToolkit().sync();
    }

    public void myPaint(Graphics g) {
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
//        g.setColor(Color.blue);
//        g.setFont(new Font("Serif", Font.BOLD, 70));
//        g.drawString("NEON ROCKET", 390, 200);
        g.drawImage(logo, 430, 100, this);

        g.setColor(Color.white);
        g.setFont(new Font("Serif", Font.ITALIC, 45));
        g.drawString("PLAY (p)", 580, 500);
        g.setFont(new Font("Serif", Font.ITALIC, 35));
        g.drawString("Game Instructions (i)", 490, 600);
        g.drawString("Level (l)", 580, 700);
    }

    // Instructions screen
    public void instructionsScreen(Graphics g) {
        g.drawImage(instructions, 0, 0, this);
        g.setFont(new Font("Serif", Font.BOLD, 40));
        g.drawString("The rocket will start on a launchpad. Use the left and right arrow keys to boost the " +
                "rocket up and to the left or right. Try to hit as many stars as possible while avoiding obstacle" +
                "es. If an obstacle is hit, you will die. Land on the launch pad to complete the level.", 200, 300);
    }

    public void playScreen(Graphics g) {
        g.drawImage(otherScreen, 0, 0, this);
        this.g.getRocket().draw(g);
        g.drawImage(launchpad, 130, 575, this);
        g.drawImage(platform, 130, 725, this);
        g.drawImage(asteroid1, 300, 300, this);
        g.drawImage(landingPlatform, 900, 725, this);
        g.drawImage(asteroid2, 500, 500, this);
    }
}
