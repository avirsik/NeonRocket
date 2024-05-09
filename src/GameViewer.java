import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class GameViewer extends JFrame {
    private Game g;
    private Image instructions;
    private Image otherScreen;
    private Image logo;
    private Image launchpad;
    private Image platform;
    private Image landingPlatform;
    private Image levelCompleteScreen;
    private Image levelCompleteLogo;
    private Image leftArrow;
    private Image rightArrow;
    private Image star;
    private Image asteroid1;


    //    private Image asteroid1;
//    private Image asteroid2;
//    private Image star;
//    private Image asteroid3;
    public static int WINDOW_WIDTH = 1285;
    public static int WINDOW_HEIGHT = 800;

    public GameViewer(Game game) {
        this.g = game;
        this.instructions = new ImageIcon("Resources/instructions.png").getImage();
        this.otherScreen = new ImageIcon("Resources/otherScreen.png").getImage();
        this.logo = new ImageIcon("Resources/logo.png").getImage();
        this.launchpad = new ImageIcon("Resources/launchpad.png").getImage();
        this.platform = new ImageIcon("Resources/platform.png").getImage();
        this.landingPlatform = new ImageIcon("Resources/landingPlatform.png").getImage();
        this.levelCompleteScreen = new ImageIcon("Resources/levelCompleteScreen.png").getImage();
        this.levelCompleteLogo = new ImageIcon("Resources/levelCompleteLogo.png").getImage();
        this.leftArrow = new ImageIcon("Resources/leftArrow.png").getImage();
        this.rightArrow = new ImageIcon("Resources/rightArrow.png").getImage();
        this.star = new ImageIcon("Resources/star.png").getImage();
        this.asteroid1 = new ImageIcon("Resources/asteroid1.png").getImage();


//        this.asteroid1 = new ImageIcon("Resources/asteroid1.png").getImage()
//        this.asteroid2 = new ImageIcon("Resources/asteroid2.png").getImage();
//        this.asteroid3 = new ImageIcon("Resources/asteroid3.png").getImage();
//        this.star = new ImageIcon("Resources/star.png").getImage();

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
        else if (this.g.getState().equals("level1")) {
            level1Screen(g);
        }
        else if (this.g.getState().equals("level2")) {
            level2Screen(g);
        }
        else if (this.g.getState().equals("levelComplete")) {
            levelWonScreen(g);
        }
    }

    // Menu screen
    public void menuScreen(Graphics g) {
        g.drawImage(otherScreen, 0, 0, this);
        g.drawImage(logo, 290, 100, this);

        g.setColor(Color.white);
        g.setFont(new Font("Serif", Font.ITALIC, 50));
        g.drawString("PLAY (p)", 570, 500);
        g.setFont(new Font("Serif", Font.ITALIC, 35));
        g.drawString("Game Instructions (i)", 490, 600);
//        g.drawString("Level (l)", 580, 700);
    }

    // Prints instructions screen
    public void instructionsScreen(Graphics g) {
        g.drawImage(instructions, 0, 0, this);
        g.setFont(new Font("Courier", Font.BOLD, 60));
        g.setColor(Color.white);
        g.drawString("HOW TO PLAY", 450, 180);

        g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        g.drawString("Use the LEFT arrow key to boost the rocket up", 110, 280);
        g.drawString("and to the left and use the RIGHT arrow key to", 110, 320);
        g.drawString("boost the rocket up and to the right.", 145, 360);
        g.drawImage(leftArrow, 270, 380, this);
        g.drawImage(rightArrow, 370, 380, this);

        g.drawString("Collect as many STARS as you can!", 730, 280);
        g.drawImage(star, 900, 350, this);

        g.drawString("Avoid hitting obstacles including the WALLS", 130, 550);
        g.drawString("and ASTEROIDS", 280, 580);
        g.drawImage(asteroid1, 350, 610, this);

        g.drawString("Land on the gold LAUNCH PAD to complete", 710, 550);
        g.drawString("the level", 900, 590);
        g.drawImage(landingPlatform, 880, 700, this);
        g.drawImage(launchpad, 820, 580, this);

        g.setColor(Color.yellow);
        g.setFont(new Font("TimesRoman", Font.ITALIC, 20));
        g.drawString("PRESS 'P' TO START!", 565, 685);
    }


    public void level1Screen(Graphics g) {
        g.drawImage(otherScreen, 0, 0, this);
        this.g.getRocket().draw(g);
        g.drawImage(launchpad, 130, 575, this);
        g.drawImage(platform, 130, 725, this);
        g.drawImage(landingPlatform, 900, 725, this);

//        g.drawImage(asteroid1, 300, 300, this);
//        g.drawImage(asteroid2, 500, 500, this);
//        g.drawImage(asteroid3, 800, 300, this);
//        g.drawImage(star, 500, 370, this);
//        g.drawImage(star, 1000, 100, this);
//        g.drawImage(star, 350, 200, this);

        g.setFont(new Font("Courier", Font.ITALIC, 30));
        g.setColor(Color.white);
        g.drawString("Level 1", 1160, 70);

        for (int i = 0; i < this.g.getAsteroids().size(); i++) {
            this.g.getAsteroids().get(i).draw(g);
        }
        for (int i = 0; i < this.g.getStars().size(); i++) {
            this.g.getStars().get(i).draw(g);
        }
    }

    public void level2Screen(Graphics g) {
        g.drawImage(otherScreen, 0, 0, this);
        this.g.getRocket().draw(g);
        g.drawImage(launchpad, 130, 575, this);
        g.drawImage(platform, 130, 725, this);
        g.drawImage(landingPlatform, 900, 725, this);
    }

    public void hitAsteroidScreen(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("Serif", Font.ITALIC, 50));
        g.drawString("You Hit an Asteroid!", 570, 500);
        g.setFont(new Font("Serif", Font.ITALIC, 30));
        g.drawString("('c' to continue)", 570, 500);
    }

    public void levelWonScreen(Graphics g) {
        g.drawImage(levelCompleteScreen, 0, 0, this);
        g.drawImage(levelCompleteLogo, 200, 140, this);
        g.setColor(Color.white);
        g.setFont(new Font("Serif", Font.ITALIC, 60));
        g.drawString("Congratulations!", 440, 450);
        g.setFont(new Font("Serif", Font.PLAIN, 40));
        g.drawString("You completed the level! Press 'm' to exit.", 310, 530);
    }
}
