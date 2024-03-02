package kalah.utils.printer.boardPrinter;

import com.qualitascorpus.testsupport.IO;
import kalah.board.components.Pit;
import kalah.board.BoardConstants;

public class HorizontalBoardPrinter implements BoardPrinter {
    private final int houses = BoardConstants.HOUSES.getValue(); // 6
    private final int p1StoreIndex = BoardConstants.P1_STORE_INDEX.getValue(); // 6
    private final int p2StoreIndex = BoardConstants.P2_STORE_INDEX.getValue(); // 13
    private final int p2EndHouseIndex = BoardConstants.P2_END_HOUSE_INDEX.getValue(); // 12
    private int twoDigit = 10;
    private IO io;
    private Pit[] pits;

    public HorizontalBoardPrinter(IO io, Pit[] pits) {
        this.io = io;
        this.pits = pits;
    }

    @Override
    public void printBoard() {
        String borderLine = "+----+-------+-------+-------+-------+-------+-------+----+";
        String centreLine = "|    |-------+-------+-------+-------+-------+-------|    |";

        io.println(borderLine);
        io.println(getTopSection()); // Player 2's pits line
        io.println(centreLine);
        io.println(getBottomSection()); // Player 1's pits line
        io.println(borderLine);
    }

    private String getTopSection() {
        String p2House = "";
        String p2Store = "";
        int p1CurrentScore = pits[p1StoreIndex].getNumberOfSeeds();

        for (int i = p2EndHouseIndex; i > houses; i--) {
            int p2NumberOfSeed = pits[i].getNumberOfSeeds();
            p2House += (" "+ (i - houses) + "[" + (p2NumberOfSeed >= twoDigit ? "" : " ") + p2NumberOfSeed + "] |");
        }
        p2Store = " " + (p1CurrentScore < twoDigit ? " " : "") + p1CurrentScore + " |";
        return "| P2 |" + p2House + p2Store;
    }

    private String getBottomSection() {
        String p1House = "";
        String p1Store = "";
        int p2CurrentScore = pits[p2StoreIndex].getNumberOfSeeds();

        for (int i = 0; i < houses; i++) {
            int p1NumberOfSeed = pits[i].getNumberOfSeeds();
            p1House += (" "+ (i + 1) + "[" + (p1NumberOfSeed >= twoDigit ? "" : " ") + p1NumberOfSeed + "] |");
        }
        p1Store = (p2CurrentScore < twoDigit ? "|  " : "| ") + p2CurrentScore + " |";
        return p1Store + p1House + " P1 |";
    }
}


