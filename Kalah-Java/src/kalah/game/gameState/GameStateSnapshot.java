package kalah.game.gameState;

import kalah.player.Player;

/**
 * Represents a snapshot of the game's state at a given moment.
 * This class captures the current player and the state of all pits in the game.
 */
public class GameStateSnapshot {
    private int[] currentPitsState;
    private Player currentPlayer;

    public GameStateSnapshot(int[] currentPitsState, Player currentPlayer) {
        this.currentPitsState = currentPitsState;
        this.currentPlayer = currentPlayer;
    }

    public int[] getPitsState() {
        return currentPitsState;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
}