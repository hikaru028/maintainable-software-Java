package kalah.game.controllers;

import kalah.game.Game;

public class LoadCommand implements GameCommand {
    private Game game;

    public LoadCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.loadGame();
    }
}