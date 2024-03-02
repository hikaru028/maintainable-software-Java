package kalah.move.computer.moveOptions;

import kalah.board.BoardConstants;
import kalah.board.components.Pit;

public class FirstLegalMoveOption implements MoveOption {
    private final int startHouseIndex = BoardConstants.P2_START_HOUSE_INDEX.getValue(); // 7
    private final int endHouseIndex = BoardConstants.P2_END_HOUSE_INDEX.getValue(); // 12

    @Override
    public DecisionMaker getMoveOption(Pit[] pits) {
        DecisionMaker decision = null;

        for (int i = startHouseIndex; i <= endHouseIndex; i++) {
            if (pits[i].getNumberOfSeeds() > 0) {
                decision = new DecisionMaker(i, "because it is the first legal move");
                break;
            }
        }
        return decision;
    }
}
