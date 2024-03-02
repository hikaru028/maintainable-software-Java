package kalah.move.user.controllers;

import kalah.board.BoardConstants;
import kalah.board.components.Pit;
import kalah.player.Player;

public class SeedConveyor {
    private final int totalPits = BoardConstants.TOTAL_PITS.getValue(); // 14
    private final int p1StoreIndex = BoardConstants.P1_STORE_INDEX.getValue(); // 6
    private final int p2StoreIndex = BoardConstants.P2_STORE_INDEX.getValue(); // 12
    private Pit[] pits;

    public SeedConveyor(Pit[] pits) {
        this.pits = pits;
    }

    public int placeSeedInEachPit(Player currentPlayer, int houseNumber, int remainingSeed) {
        int lastHouseIndex = 0;

        for (int i = 0; i < remainingSeed; i++) {
            houseNumber = (houseNumber % totalPits);
            if (houseNumber == p1StoreIndex && currentPlayer.equals(pits[p2StoreIndex].getOwner())) {
                houseNumber = (houseNumber + 1) % totalPits;
            } else if (houseNumber == p2StoreIndex && currentPlayer.equals(pits[p1StoreIndex].getOwner())) {
                houseNumber = (houseNumber + 1) % totalPits;
            }
            pits[houseNumber].addSeedToHouse();
            houseNumber++;
            lastHouseIndex = houseNumber - 1;
        }
        return lastHouseIndex;
    }
}
