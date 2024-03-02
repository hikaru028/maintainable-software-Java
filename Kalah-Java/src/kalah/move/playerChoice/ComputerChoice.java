package kalah.move.playerChoice;

import com.qualitascorpus.testsupport.IO;
import kalah.board.components.Pit;
import kalah.board.BoardConstants;
import kalah.move.computer.ComputerMove;
import kalah.move.computer.moveOptions.DecisionMaker;
import kalah.player.Player;

/**
 * Implementation of PlayerChoice for the computer player. This class encapsulates
 * the computer's decision-making process, obtaining a choice based on set strategies.
 */
public class ComputerChoice implements PlayerChoice {
    private final int p2StartHouseIndex = BoardConstants.P2_START_HOUSE_INDEX.getValue(); // 7
    private IO io;
    private Pit[] pits;

    public ComputerChoice(IO io, Pit[] pits) {
        this.io = io;
        this.pits = pits;
    }

    @Override
    public int getPlayerChoice(Player currentPlayer) {
        ComputerMove computerMove = new ComputerMove(pits);
        DecisionMaker decision = computerMove.getHouseIndexAndReason();
        int houseNumber = decision.getHouseIndex() + 1; // It needs to add 1 here to adjust user's input number
        String reason = decision.getReason();

        io.println("Player " + currentPlayer.getPlayerName() + " (Robot) chooses house #" + (houseNumber - p2StartHouseIndex) + " " + reason);
        return houseNumber;
    }
}
