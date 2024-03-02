package kalah.move.computer.moveOptions;

import kalah.board.BoardConstants;
import kalah.board.components.Pit;

public class CaptureMoveOption implements MoveOption {
    private final int p2startHouseIndex = BoardConstants.P2_START_HOUSE_INDEX.getValue(); // 7
    private final int p2endHouseIndex = BoardConstants.P2_END_HOUSE_INDEX.getValue(); // 12
    private final int p1StoreIndex = BoardConstants.P1_STORE_INDEX.getValue(); // 6
    private final int p2StoreIndex = BoardConstants.P2_STORE_INDEX.getValue(); // 13

    @Override
    public DecisionMaker getMoveOption(Pit[] pits) {
        DecisionMaker decision = null;

        for (int i = p2startHouseIndex; i <= p2endHouseIndex; i++) {
            if (pits[i].getNumberOfSeeds() > 0 && canLeadToCapture(pits, i)) {
                decision = new DecisionMaker(i, "because it leads to a capture");
                break;
            }
        }
        return decision;
    }

    private boolean canLeadToCapture(Pit[] pits, int i) {
        boolean canLeadToCapture = false;
        int numberOfSeed = pits[i].getNumberOfSeeds();
        int lastHouseIndex = i + numberOfSeed;

        if (lastHouseIndex < p2StoreIndex) {
            int opponentHouseIndex = p2endHouseIndex - lastHouseIndex;
            canLeadToCapture = pits[lastHouseIndex].getNumberOfSeeds() == 0 && pits[opponentHouseIndex].getNumberOfSeeds() > 0;
        }

        if (lastHouseIndex > p2StoreIndex) {
            lastHouseIndex -= (p2StoreIndex + 1);
            if (lastHouseIndex >= p1StoreIndex) {
                lastHouseIndex++;  // To skip the player 1's store
                canLeadToCapture = pits[lastHouseIndex].getNumberOfSeeds() == 0;
            }
        }
        return canLeadToCapture;
    }
}
