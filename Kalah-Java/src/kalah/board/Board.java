package kalah.board;

import com.qualitascorpus.testsupport.IO;
import kalah.board.components.Pit;
import kalah.player.Player;
import kalah.utils.printer.boardPrinter.BoardPrinter;
import kalah.utils.printer.boardPrinter.HorizontalBoardPrinter;
import kalah.utils.printer.boardPrinter.VerticalBoardPrinter;

public class Board {
    private final int defaultSeeds = BoardConstants.DEFAULT_SEEDS.getValue(); // 4
    private final int houses = BoardConstants.HOUSES.getValue(); // 6
    private final int totalPits = BoardConstants.TOTAL_PITS.getValue(); // 14
    private final int p1StoreIndex = BoardConstants.P1_STORE_INDEX.getValue(); // 6
    private final int p2StoreIndex = BoardConstants.P2_STORE_INDEX.getValue(); // 13
    private final int p1StartHouseIndex = BoardConstants.P1_START_HOUSE_INDEX.getValue(); // 0
    private final int p2StartHouseIndex = BoardConstants.P2_START_HOUSE_INDEX.getValue(); // 7
    private IO io;
    private Pit[] pits;
    private BoardPrinter boardPrinter;

    public Board(IO io, Player player1, Player player2) {
        this.io = io;
        this.pits = new Pit[totalPits];
        initialisePits(player1, player2);
    }

    public void initialisePits(Player p1, Player p2) {
        for (int i = 0; i < houses; i++) {
            pits[i] = new Pit(p1, defaultSeeds);
            pits[i + 7] = new Pit(p2, defaultSeeds);
        }
        pits[p1StoreIndex] = new Pit(p1, 0);
        pits[p2StoreIndex] = new Pit(p2, 0);
    }

    public void getBoard(int gameOption) {
        if (gameOption == 1) {
            boardPrinter = new VerticalBoardPrinter(io, pits);
        } else {
            boardPrinter = new HorizontalBoardPrinter(io, pits);
        }
        boardPrinter.printBoard();
    }

    public Pit[] getPits() {
        return pits;
    }

    public int getOppositeHouseIndex(int houseIndex) {
        return (houses * 2) - houseIndex;
    }

    public int getOwnStoreIndex(Player currentPlayer) {
        return currentPlayer.equals(pits[p1StoreIndex].getOwner()) ? p1StoreIndex : p2StoreIndex;
    }

    public int getTotalSeeds(Player player) {
        int startHouseIndex = getOwnStoreIndex(player) == p1StoreIndex ? p1StartHouseIndex : p2StartHouseIndex;
        int endHouseIndex = getOwnStoreIndex(player) == p1StoreIndex ? p1StoreIndex : p2StoreIndex;
        int totalSeeds = pits[getOwnStoreIndex(player)].getNumberOfSeeds();

        for(int i = startHouseIndex; i < endHouseIndex; i++) {
            totalSeeds += pits[i].getNumberOfSeeds();
        }
        return totalSeeds;
    }

    /**
     * To check whether all the houses of the current player are empty
     * @param currentPlayer - the player whose houses need to be checked
     * @return true if all the houses are empty, false otherwise
     */
    public boolean areAllHousesEmptyByCurrentPlayer(Player currentPlayer) {
        boolean allEmpty = true;
        int start = currentPlayer.equals(pits[p1StoreIndex].getOwner()) ? p1StartHouseIndex : p2StartHouseIndex;
        int end = currentPlayer.equals(pits[p1StoreIndex].getOwner()) ? p1StoreIndex : p2StoreIndex;

        for(int i = start; i < end; i++) {
            if(pits[i].getNumberOfSeeds() != 0) {
                allEmpty = false;
            }
        }
        return allEmpty;
    }
}
