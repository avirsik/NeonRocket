import java.util.Scanner;
public class Game {
    private GameViewer gv;
    private String state;
    private Scanner s = new Scanner(System.in);

    public Game() {
        // Initalizing instance variables
        this.gv = new GameViewer(this);
        this.state = "menu";

        gv.repaint();
        menu();
    }

    public void menu() {
        System.out.println("\n                                                                NEON ROCKET\n\n\n" +
                "                                                                Game Instructions\n" +
                "                                                                (press i)\n\n" +
                "                                                                Play\n" +
                "                                                                (press p)\n\n" +
                "                                                                Level\n" +
                "                                                                (press l)");
        // Print instructions
        String input = s.nextLine();
        if (input.equals("i")) {
            printInstructions();
            state = "instructions";
        }
        else if (input.equals("p")) {
            state = "play";
        }
        else if (input.equals("l")) {
            state = "level";
        }
    }

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
}
