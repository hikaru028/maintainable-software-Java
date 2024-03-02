package kalah.board.components;

import kalah.player.Player;

/**
 * Each board pit has a certain number of seeds and an owner which is a player.
 */
public class Pit {
    private Player owner;
    private int numberOfSeeds;

    public Pit(Player owner, int numberOfSeeds) {
        this.owner = owner;
        this.numberOfSeeds = numberOfSeeds;
    }

    public int getNumberOfSeeds() {
        return numberOfSeeds;
    }

    public void setNumberOfSeeds(int numberOfSeeds) {
        this.numberOfSeeds = numberOfSeeds;
    }

    public Player getOwner() {
        return owner;
    }

    public void addSeedToHouse() {
        numberOfSeeds++;
    }

    public void addSeedsToStore(int seeds) {
        numberOfSeeds += seeds;
    }

    public void removeSeeds() { // To eliminate all seeds in a house
        numberOfSeeds = 0;
    }

    /**
     * To check if the pit is owned by a given player
     * @param currentPlayer - the player to check ownership against
     * @return - True if the pit is owned by the current player, false otherwise
     */
    public boolean isOwnedBy(Player currentPlayer) {
        return this.owner.equals(currentPlayer);
    }
}