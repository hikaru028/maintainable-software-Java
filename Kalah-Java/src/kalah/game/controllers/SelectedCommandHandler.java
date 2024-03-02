package kalah.game.controllers;

import kalah.game.Game;

/**
 * Handles player's special command choices like restarting, saving, loading, and quitting.
 */
public class SelectedCommandHandler {
    private final int restartNumber = -1;
    private final int saveNumber = -2;
    private final int loadNumber = -3;
    private final int quitNumber = -4;
    GameController gameController;

    /**
     * Executes the action associated with the player's special choice.
     *
     * @param game - The game instance
     * @param playerChoice - The choice made by the player
     */
    public void handlePlayerChoice(Game game, int playerChoice) {
        GameCommand command;

        switch (playerChoice) {
            case restartNumber:
                command = new RestartCommand(game);
                break;
            case saveNumber:
                command = new SaveCommand(game);
                break;
            case loadNumber:
                command = new LoadCommand(game);
                break;
            case quitNumber:
                command = new QuitCommand(game);
                break;
            default:
                command = null;
                break;
        }

        if (command != null) {
            gameController = new GameController(command);
            gameController.runGameCommand();
        }
    }
}
