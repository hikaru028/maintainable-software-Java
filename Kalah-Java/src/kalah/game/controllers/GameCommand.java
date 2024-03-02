package kalah.game.controllers;

/**
 * This interface represents the contract for invoking the methods selected by a user.
 * Implementations of this interface should provide the method to run specific logic depending on the game's option.
 */
public interface GameCommand {
    void execute();
}
