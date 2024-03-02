package kalah.move.user.controllers;

import kalah.board.components.Pit;
import kalah.board.Board;
import kalah.player.Player;

public class SeedTaker {
    private Pit[] pits;
    private Board board;

    public SeedTaker(Pit[] pits, Board board) {
        this.pits = pits;
        this.board = board;
    }

    /**
     * To Capture the seeds from the opposite house and moves them to the current player's store.
     * When the last seed of a player's turn lands in one of their own houses and the house is empty but the
     * opposite house has seeds, this method captures all seeds from the opposite house along with the last seed
     * from the current player's house and adds them to the current player's store.
     *
     * @param currentPlayer - The player who is currently making the move
     * @param lastHouseIndex - The index of the house where the last seed was sown
     */
    public void captureSeeds(Player currentPlayer, int lastHouseIndex) {
        int oppositeHouseIndex = board.getOppositeHouseIndex(lastHouseIndex);
        int ownStoreIndex = board.getOwnStoreIndex(currentPlayer);

        pits[ownStoreIndex].addSeedsToStore(pits[oppositeHouseIndex].getNumberOfSeeds() + 1);
        pits[oppositeHouseIndex].removeSeeds();
        pits[lastHouseIndex].removeSeeds();
    }
}
