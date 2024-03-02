package kalah.move.user.controllers;

import kalah.player.Player;

public class CaptureSeedCommand implements MoveCommand {
    private int lastHouseIndex;
    private SeedTaker seedTaker;
    private Player currentPlayer;

    public CaptureSeedCommand(SeedTaker seedTaker, Player currentPlayer, int lastHouseIndex) {
        this.seedTaker = seedTaker;
        this.currentPlayer = currentPlayer;
        this.lastHouseIndex = lastHouseIndex;
    }

    @Override
    public CommandResult execute() {
        seedTaker.captureSeeds(currentPlayer, lastHouseIndex);
        return new CommandResult();
    }
}
