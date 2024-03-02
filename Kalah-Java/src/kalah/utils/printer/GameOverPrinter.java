package kalah.utils.printer;

import com.qualitascorpus.testsupport.IO;
import kalah.board.Board;

public class GameOverPrinter {
    private IO io;
    private Board board;

    public GameOverPrinter(IO io, Board board) {
        this.io = io;
        this.board = board;
    }

    public void printGameOver(int gameOption) {
        io.println("Game over");
        board.getBoard(gameOption);
    }
}
