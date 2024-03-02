package kalah.game.controllers;

import kalah.game.Game;

public class RestartCommand implements GameCommand {
    private Game game;

    public RestartCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.restartGame();
    }
}
