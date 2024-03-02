package kalah.utils.scanner;

import com.qualitascorpus.testsupport.IO;
import kalah.board.BoardConstants;
import kalah.player.Player;
import kalah.game.controllers.GameOption;

public class UserInputScanner {
    private final int houses = BoardConstants.HOUSES.getValue(); // 6
    private final int p2StartHouseIndex = BoardConstants.P2_START_HOUSE_INDEX.getValue(); // 7
    private IO io;

    public UserInputScanner(IO io) {
        this.io = io;
    }

    public int readUserInput(Player currentPlayer, Player p1, Player p2) {
        while (true) {
            int userInput = 0;
            String input = io.readFromKeyboard("Choice:").toLowerCase();

            // To check whether the input blank
            if (input.trim().isEmpty()) {
                io.println("Input cannot be blank! Please enter a valid choice.");
                continue;
            }

            switch (input) {
                case "n":
                    userInput = GameOption.NEW_GAME.getCommandNumber();
                    break;
                case "s":
                    userInput = GameOption.SAVE_GAME.getCommandNumber();
                    break;
                case "l":
                    userInput = GameOption.LOAD_GAME.getCommandNumber();
                    break;
                case "q":
                    userInput = GameOption.QUIT_GAME.getCommandNumber();
                    break;
                default:
                    try {
                        int choice = Integer.parseInt(input);
                        if (choice >= 0 && choice <= houses) {
                            if (currentPlayer.equals(p1)) {
                                userInput = choice;
                            } else if (currentPlayer.equals(p2)) {
                                userInput = choice + p2StartHouseIndex;
                            } else {
                                io.println("Invalid input! Please enter a valid choice.");
                                continue;
                            }
                        } 
                    } catch (NumberFormatException e) {
                        io.println("Invalid input! Please enter a valid choice.");
                        continue;
                    }
            }
            return userInput;
        }
    }
}