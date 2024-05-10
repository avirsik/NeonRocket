import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;


public class Game implements KeyListener, ActionListener {
    private GameViewer gv;
    private Rocket r;
    private String state;
    private int starCount;
    private ArrayList<Obstacle> asteroids;
    private ArrayList<Obstacle> stars;

    public static final double GRAVITY = 0.5;

    public Game() {
        // Initalizing instance variables
        this.state = "menu";
        starCount = 0;
        this.gv = new GameViewer(this);
        r = new Rocket(175, 600);

        asteroids = new ArrayList<Obstacle>();
        stars = new ArrayList<Obstacle>();

        setLevel1();

        Timer clock = new Timer(30, this);
        clock.start();

        gv.addKeyListener(this);

        gv.repaint();
    }

    public String getState() {
        return this.state;
    }

    public Rocket getRocket() {
        return this.r;
    }
    public ArrayList<Obstacle> getAsteroids() {
        return this.asteroids;
    }
    public ArrayList<Obstacle> getStars() {
        return this.stars;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_M:
                state = "menu";
                break;
            case KeyEvent.VK_I:
                state = "instructions";
                break;
            case KeyEvent.VK_P:
                state = "level1";
                setLevel1();
                break;
            case KeyEvent.VK_LEFT:
                r.setDX(-20);
                r.setDY(-7);
                break;
            case KeyEvent.VK_RIGHT:
                r.setDX(20);
                r.setDY(-7);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        r.setDX(0);
        r.setDY(0);
    }

    // This method is called every time increment
    // It checks to see if it is hitting the walls or stars or launchpad and repaints the window
    public void actionPerformed(ActionEvent e) {
        // If the rocket is hitting a wall, reset the rocket
        if (r.isHittingWall()) {
            r.reset();
        }
        // Check to see if it is hitting the landing platform
        if (r.isHittingPlatform()) {
            state = "levelComplete";
        }
        // Check to see if it is hitting any of the stars
        for (int i = 0; i < stars.size(); i++) {
            if (r.isHittingSomething(stars.get(i))) {
                starCount++;
                // Get rid of stars
                stars.remove(stars.get(i));
            }
        }
//
//        // Check to see if it is hitting the asteroids
        for (int i = 0; i < asteroids.size(); i++) {
            if (r.isHittingSomething(asteroids.get(i))) {
                r.reset();
            }
        }

        // Update rocket's dx and dy values
        r.move();
        // Repaint window and rocket's location on the window
        gv.repaint();
    }

    public void setLevel1() {
        asteroids.add(new Obstacle(1, 400, 300));
        asteroids.add(new Obstacle(2, 700, 500));
        asteroids.add(new Obstacle(3, 800, 300));

        stars.add(new Obstacle(700, 370));
        stars.add(new Obstacle(1000, 100));
        stars.add(new Obstacle(350, 200));
    }

    public static void main(String[] args) {
        Game g = new Game();
    }

}
