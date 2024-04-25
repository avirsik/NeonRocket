import java.util.Scanner;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game implements KeyListener {
    private GameViewer gv;
    private String state;
    private Scanner s = new Scanner(System.in);

    public Game() {
        // Initalizing instance variables
        this.gv = new GameViewer(this);
        this.state = "menu";
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
                break;
        }
        gv.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
