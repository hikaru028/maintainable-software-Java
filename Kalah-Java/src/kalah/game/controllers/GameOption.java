package kalah.game.controllers;

/**
 * Enumeration representing different game options like
 * starting a new game, saving, loading, and quitting.
 */
public enum GameOption {
    NEW_GAME('N', "New game", -1),
    SAVE_GAME('S', "Save game", -2),
    LOAD_GAME('L', "Load game", -3),
    QUIT_GAME('q', "Quit", -4);
    private final char option;
    private final String description;
    private final int commandNumber;

    GameOption(char option, String description, int commandNumber) {
        this.option = option;
        this.description = description;
        this.commandNumber = commandNumber;
    }

    public char getOption() {
        return option;
    }

    public String getDescription() {
        return description;
    }

    public int getCommandNumber() {
        return commandNumber;
    }
}
