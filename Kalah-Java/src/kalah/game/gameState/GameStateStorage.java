package kalah.game.gameState;

import java.util.ArrayList;
import java.util.List;
import kalah.board.components.Pit;
import kalah.player.Player;

/**
 * Manages and stores multiple game state snapshots.
 * This class allows saving and retrieving game state snapshots,
 * typically used for save/load game functionalities.
 */
public class GameStateStorage {
    private List<GameStateSnapshot> snapshots = new ArrayList<>();

    public void saveSnapshot(Player currentPlayer, Pit[] pits) {
        int[] currentPitsState = new int[pits.length];

        for (int i = 0; i < pits.length; i++) {
            currentPitsState[i] = pits[i].getNumberOfSeeds();
        }
        GameStateSnapshot snapshot = new GameStateSnapshot(currentPitsState, currentPlayer);
        this.snapshots.add(snapshot);
    }

    public GameStateSnapshot restoreSnapshot() {
        if(!snapshots.isEmpty()) {
            return snapshots.get(snapshots.size() - 1);
        }
        return null;
    }

    public void clearSnapshot() {
        snapshots.clear();
    }
}