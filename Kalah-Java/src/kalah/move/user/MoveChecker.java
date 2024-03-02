package kalah.move.user;

import com.qualitascorpus.testsupport.IO;
import kalah.board.Board;
import kalah.board.components.Pit;
import kalah.game.Game;
import kalah.move.user.controllers.*;
import kalah.player.Player;

public class MoveChecker {
    private IO io;
    private Board board;
    private Pit[] pits;
    private Game game;
    private LastSeedChecker lastSeedChecker;
    private MoveCommandHandler moveCommandHandler;
    private SeedConveyor seedConveyor;
    private SeedTaker seedTaker;

    public MoveChecker(IO io, Board board, Pit[] pits, Game game) {
        this.io = io;
        this.board = board;
        this.pits = pits;
        this.game = game;
        this.lastSeedChecker = new LastSeedChecker(pits);
        this.moveCommandHandler = new MoveCommandHandler();
        this.seedConveyor = new SeedConveyor(pits);
        this.seedTaker  = new SeedTaker(pits, board);
    }

    /**
     * To validate and execute the move for the given player and house
     * @param currentPlayer - The player who is currently making the move
     * @param houseNumber - The index of the house where the seeds are picked up from
     * @return true if all the houses are empty, false if a house is empty or last seed is sown in the player's own store
     */
    public boolean canMakeMove(Player currentPlayer, int houseNumber) {
        Pit pit = pits[houseNumber - 1];

        int remainingSeed = pit.getNumberOfSeeds();
        boolean isOpponentTurn = true;

        if (!pit.isOwnedBy(currentPlayer) || remainingSeed == 0) {
            io.println("House is empty. Move again.");
            game.startGame();
        } else {
            pit.removeSeeds(); // Remove all seeds from the house selected

            ConveySeedCommand conveySeedCommand = new ConveySeedCommand(seedConveyor, currentPlayer, houseNumber, remainingSeed);
            moveCommandHandler.setCommand(conveySeedCommand);
            CommandResult result = moveCommandHandler.executeCommand();

            if (result.hasValue()) {
                int lastHouseIndex = result.getValue();
                isOpponentTurn = checkNextTurn(currentPlayer, lastHouseIndex);
            }
        }
        return isOpponentTurn;
    }

    private boolean checkNextTurn(Player currentPlayer, int lastHouseIndex) {
        boolean isOpponentTurn = true;
        int oppositeHouseIndex = board.getOppositeHouseIndex(lastHouseIndex);
        boolean isAdditionalMove = lastSeedChecker.isAdditionalMove(currentPlayer, lastHouseIndex);
        boolean canCapture = lastSeedChecker.canCaptureSeeds(currentPlayer, lastHouseIndex, oppositeHouseIndex);

        if (isAdditionalMove) {
            isOpponentTurn = false;
        }

        if (canCapture) {
            CaptureSeedCommand captureSeedCommand = new CaptureSeedCommand(seedTaker, currentPlayer, lastHouseIndex);
            moveCommandHandler.setCommand(captureSeedCommand);
            moveCommandHandler.executeCommand();
        }
        return isOpponentTurn;
    }
}
