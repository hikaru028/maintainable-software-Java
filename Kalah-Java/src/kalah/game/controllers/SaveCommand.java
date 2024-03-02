package kalah.game.controllers;

import kalah.game.Game;

public class SaveCommand implements GameCommand {
    private Game game;

    public SaveCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.saveGame();
    }
}