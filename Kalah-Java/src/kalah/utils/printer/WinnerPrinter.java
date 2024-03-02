package kalah.utils.printer;

import com.qualitascorpus.testsupport.IO;

public class WinnerPrinter {
    private IO io;

    public WinnerPrinter (IO io) {
        this.io = io;
    }

    /**
     * To check and print the winner (or tie) of the game based on the scores.
     * @param ScoreP1 - the total number of seeds in the player 1's store
     * @param ScoreP2 - the total number of seeds in the player 2's store
     */
    public void printWinner(int ScoreP1, int ScoreP2) {
        switch (Integer.compare(ScoreP1, ScoreP2)) {
            case 1:
                io.println("Player 1 wins!");
                break;
            case -1:
                io.println("Player 2 wins!");
                break;
            case 0:
                io.println("A tie!");
                break;
        }
    }
}
