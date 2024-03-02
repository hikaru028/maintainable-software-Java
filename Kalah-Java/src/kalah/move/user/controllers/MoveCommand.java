package kalah.move.user.controllers;

/**
 * Interface for handling different types of moves
 */
public interface MoveCommand {
    CommandResult execute();
}
