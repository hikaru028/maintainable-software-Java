package kalah.move.user;

import kalah.board.BoardConstants;
import kalah.player.Player;
import kalah.board.components.Pit;

public class LastSeedChecker {
    private final int p1StoreIndex = BoardConstants.P1_STORE_INDEX.getValue(); // 6
    private final int p2StoreIndex = BoardConstants.P2_STORE_INDEX.getValue(); // 13
    private Pit[] pits;

    public LastSeedChecker(Pit[] pits) {
        this.pits = pits;
    }

    public boolean isAdditionalMove(Player currentPlayer, int lastHouseIndex) {
        return lastHouseIndex == (currentPlayer.equals(pits[p1StoreIndex].getOwner()) ? p1StoreIndex : p2StoreIndex);
    }

    public boolean canCaptureSeeds(Player currentPlayer, int lastHouseIndex, int oppositeHouseIndex) {
        return lastHouseIndex != p1StoreIndex &&
                lastHouseIndex != p2StoreIndex &&
                pits[lastHouseIndex].getNumberOfSeeds() == 1 &&
                pits[lastHouseIndex].isOwnedBy(currentPlayer) &&
                pits[oppositeHouseIndex].getNumberOfSeeds() > 0;
    }
}
