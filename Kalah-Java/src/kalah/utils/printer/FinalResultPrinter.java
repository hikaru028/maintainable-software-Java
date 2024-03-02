package kalah.utils.printer;

import com.qualitascorpus.testsupport.IO;
import kalah.board.Board;
import kalah.player.Player;

public class FinalResultPrinter {
    private IO io;
    private Board board;
    private WinnerPrinter winnerPrinter;

    public FinalResultPrinter(IO io, Board board) {
        this.io = io;
        this.board = board;
        this.winnerPrinter = new WinnerPrinter(io);
    }

    public void printFinalResult(Player player1, Player player2) {
        int ScoreP1 = board.getTotalSeeds(player1);
        int ScoreP2 = board.getTotalSeeds(player2);
        io.println("\tplayer 1:" + ScoreP1);
        io.println("\tplayer 2:" + ScoreP2);
        winnerPrinter.printWinner(ScoreP1, ScoreP2);
    }
}
