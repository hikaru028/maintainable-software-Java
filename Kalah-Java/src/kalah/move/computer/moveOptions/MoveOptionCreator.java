package kalah.move.computer.moveOptions;

import java.util.Arrays;
import java.util.List;

/**
 * This class creates a list of move options (MoveOption) in a specific order.
 * This order determines the computer's priorities when selecting a move.
 */
public class MoveOptionCreator {
    public static List<MoveOption> getMoveOptionList() {
        return Arrays.asList(
                new ExtraMoveOption(),
                new CaptureMoveOption(),
                new FirstLegalMoveOption()
        );
    }
}
