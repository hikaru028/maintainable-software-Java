package kalah.move.user.controllers;

import kalah.player.Player;

public class ConveySeedCommand implements MoveCommand {
    private SeedConveyor seedConveyor;
    private Player currentPlayer;
    private int houseNumber;
    private int remainingSeed;

    public ConveySeedCommand(SeedConveyor seedConveyor, Player currentPlayer, int houseNumber, int remainingSeed) {
        this.seedConveyor = seedConveyor;
        this.currentPlayer = currentPlayer;
        this.houseNumber = houseNumber;
        this.remainingSeed = remainingSeed;
    }

    @Override
    public CommandResult execute() {
        int lastHouseIndex = seedConveyor.placeSeedInEachPit(currentPlayer, houseNumber, remainingSeed);
        return new CommandResult(lastHouseIndex);
    }
}
