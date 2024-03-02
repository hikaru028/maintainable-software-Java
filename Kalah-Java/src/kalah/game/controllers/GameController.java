package kalah.game.controllers;

public class GameController {
    private GameCommand command;

    public GameController(GameCommand command) {
        this.command = command;
    }

    public void runGameCommand() {
        command.execute();
    }
}
