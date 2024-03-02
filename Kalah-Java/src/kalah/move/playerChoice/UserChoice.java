package kalah.move.playerChoice;

import com.qualitascorpus.testsupport.IO;
import kalah.game.controllers.GameOption;
import kalah.player.Player;
import kalah.utils.scanner.UserInputScanner;

/**
 * Implementation of PlayerChoice for a human player. This class provides
 * a mechanism for fetching and displaying game options for human players
 * and reading their input from the given IO interface.
 */
public class UserChoice implements PlayerChoice {
    private IO io;
    private Player p1;
    private Player p2;
    private UserInputScanner inputScanner;

    public UserChoice(IO io, Player p1, Player p2) {
        this.io = io;
        this.p1 = p1;
        this.p2 = p2;
        this.inputScanner = new UserInputScanner(io);
    }

    @Override
    public int getPlayerChoice(Player currentPlayer) {
        io.println("Player " + currentPlayer.getPlayerName());
        io.println("    (1-6) - house number for move");
        for (GameOption option : GameOption.values()) {
            io.println("    " + option.getOption() + " - " + option.getDescription());
        }

        return inputScanner.readUserInput(currentPlayer, p1, p2);
    }
}
