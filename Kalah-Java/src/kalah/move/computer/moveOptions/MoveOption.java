package kalah.move.computer.moveOptions;

import kalah.board.components.Pit;

/**
 * An interface that represents a strategy for choosing a move option
 * based on the current state of the game board.
 */
public interface MoveOption {
    DecisionMaker getMoveOption(Pit[] pits);
}