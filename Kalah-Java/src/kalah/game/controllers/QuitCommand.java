package kalah.game.controllers;

import kalah.game.Game;

public class QuitCommand implements GameCommand {
    private Game game;

    public QuitCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.quitGame();
    }
}
