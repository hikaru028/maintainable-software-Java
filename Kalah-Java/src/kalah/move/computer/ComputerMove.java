package kalah.move.computer;

import java.util.List;
import kalah.board.components.Pit;
import kalah.move.computer.moveOptions.*;

/**
 * Represents the computer's decision-making process for selecting a move
 * based on various strategies (options)
 */
public class ComputerMove {
    private Pit[] pits;
    private List<MoveOption> moveOptionList;

    public ComputerMove(Pit[] pits) {
        this.pits = pits;
        this.moveOptionList = MoveOptionCreator.getMoveOptionList();
    }

    public DecisionMaker getHouseIndexAndReason() {
        DecisionMaker finalDecision = null;

        for (MoveOption option : moveOptionList) {
            DecisionMaker currentDecision = option.getMoveOption(pits);
            if (currentDecision != null) {
                finalDecision = currentDecision;
            }
        }
        return finalDecision;
    }
}