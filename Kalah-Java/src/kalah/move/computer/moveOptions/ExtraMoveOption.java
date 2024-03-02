package kalah.move.computer.moveOptions;

import kalah.board.BoardConstants;
import kalah.board.components.Pit;

public class ExtraMoveOption implements MoveOption {
    private final int startHouseIndex = BoardConstants.P2_START_HOUSE_INDEX.getValue(); // 7
    private final int endHouseIndex = BoardConstants.P2_END_HOUSE_INDEX.getValue(); // 12
    private final int p2StoreIndex = BoardConstants.P2_STORE_INDEX.getValue(); // 13

    @Override
    public DecisionMaker getMoveOption(Pit[] pits) {
        DecisionMaker decision = null;

        for (int i = startHouseIndex; i <= endHouseIndex; i++) {
            if (pits[i].getNumberOfSeeds() > 0 && canLeadToExtraMove(pits, i)) {
                decision = new DecisionMaker(i, "because it leads to an extra move");
                break;
            }
        }
        return decision;
    }

    private boolean canLeadToExtraMove(Pit[] pits, int lastSownHouse) {
        int expectedEndPosition = lastSownHouse + pits[lastSownHouse].getNumberOfSeeds();
        return expectedEndPosition == p2StoreIndex;
    }
}