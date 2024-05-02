import java.util.Scanner;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.*;
import javax.swing.*;


public class Game implements KeyListener, ActionListener {
    private GameViewer gv;
    private Rocket r;
    private String state;
    private Scanner s = new Scanner(System.in);

    public Game() {
        // Initalizing instance variables
        this.state = "play";
        this.gv = new GameViewer(this);
        r = new Rocket(175, 600);

        Timer clock = new Timer(30, this);
        clock.start();

        this.state = "menu";
//        this.state = "play";


        gv.addKeyListener(this);

        gv.repaint();
//        keyTyped();
//        menu();
    }

//    public void menu() {
//        System.out.println("\n                                                                NEON ROCKET\n\n\n" +
//                "                                                                Game Instructions\n" +
//                "                                                                (press i)\n\n" +
//                "                                                                Play\n" +
//                "                                                                (press p)\n\n" +
//                "                                                                Level\n" +
//                "                                                                (press l)");
//        // Print instructions
//        if (input.equals("i")) {
//            printInstructions();
//            state = "instructions";
//            gv.repaint();
//        }
//        // Plays game
//        else if (input.equals("p")) {
//            state = "play";
//        }
//        // Changes level
//        else if (input.equals("l")) {
//            state = "level";
//        }
//    }

    public String getState() {
        return this.state;
    }

    public Rocket getRocket() {
        return this.r;
    }

    public void printInstructions() {
        System.out.println("\n\nThe rocket will start on a launchpad. Use the left and right arrow keys to boost the " +
                "rocket up and to the left or right. Try to hit as many stars as possible while avoiding obstacl" +
                "es. If an obstacle is hit, you will die. Land on the launch pad to complete the level.");
    }
    public static void main(String[] args) {
        Game g = new Game();
    }

    @Override
    public void keyTyped(KeyEvent e) {


    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_I:
                state = "instructions";
                break;
            case KeyEvent.VK_P:
                state = "play";
                break;
            case KeyEvent.VK_L:
                state = "level";
                break;
            case KeyEvent.VK_LEFT:
                r.setDX(-20);
                break;
            case KeyEvent.VK_RIGHT:
                r.setDX(20);
                break;
            case KeyEvent.VK_UP:
                r.setDY(-20);
                break;
            case KeyEvent.VK_DOWN:
                r.setDY(20);
                break;
        }
        gv.repaint();
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
            r.setX(175);
            r.setY(600);
        }
        // Update rocket's dx and dy values
        r.move();
        // Repaint window and rocket's location on the window
        gv.repaint();
    }

}
