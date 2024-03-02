package kalah.player;

/**
 * This class initialises a new player with the given name and
 * returns the name of this player
 */
public class Player {
    private String playerName;

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }
}
