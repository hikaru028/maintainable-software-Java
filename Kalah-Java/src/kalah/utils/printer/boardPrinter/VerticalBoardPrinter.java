package kalah.utils.printer.boardPrinter;

import com.qualitascorpus.testsupport.IO;
import kalah.board.components.Pit;
import kalah.board.BoardConstants;

public class VerticalBoardPrinter implements BoardPrinter {
    private final int houses = BoardConstants.HOUSES.getValue(); // 6
    private final int p1StoreIndex = BoardConstants.P1_STORE_INDEX.getValue(); // 6
    private final int p2StoreIndex = BoardConstants.P2_STORE_INDEX.getValue(); // 13
    private final int p2EndHouseIndex = BoardConstants.P2_END_HOUSE_INDEX.getValue(); // 12
    private int twoDigit = 10;
    private IO io;
    private Pit[] pits;

    public VerticalBoardPrinter(IO io, Pit[] pits) {
        this.io = io;
        this.pits = pits;
    }

    @Override
    public void printBoard() {
        String outsideLine = "+---------------+";
        String insideLine = "+-------+-------+";

        io.println(outsideLine);
        io.println(getP2Store());
        io.println(insideLine);
        displayHouseSection();
        io.println(insideLine);
        io.println(getP1Store());
        io.println(outsideLine);
    }

    private void displayHouseSection() {
        for (int i = 0; i < houses; i++) {
            int p1NumberOfSeed = pits[i].getNumberOfSeeds();
            int p2NumberOfSeed = pits[p2EndHouseIndex - i].getNumberOfSeeds();
            String p1House = (i + 1) + "[" + (p1NumberOfSeed >= twoDigit ? "" : " ") + p1NumberOfSeed + "]";
            String p2House = (houses - i) + "[" + (p2NumberOfSeed >= twoDigit ? "" : " ") + p2NumberOfSeed + "]";
            io.println("| " + p1House + " | " + p2House + " |");
        }
    }

    private String getP1Store() {
        String space = "|       |";
        int score = pits[p1StoreIndex].getNumberOfSeeds();
        String digitSpace = score < twoDigit ? " " : "";
        return "| P1 " + digitSpace + score + " " + space;
    }

    private String getP2Store() {
        String space = "|       |";
        int score = pits[p2StoreIndex].getNumberOfSeeds();
        String digitSpace = score < twoDigit ? " " : "";
        return space + " P2 " + digitSpace + score + " |";
    }
}
