package kalah.move.user.controllers;

public class CommandResult {
    private boolean hasValue;
    private int value;

    public CommandResult(int value) {
        this.hasValue = true;
        this.value = value;
    }

    public CommandResult() {
        this.hasValue = false;
    }

    public boolean hasValue() {
        return hasValue;
    }

    public int getValue() {
        if (!hasValue) {
            throw new IllegalStateException("No value present");
        }
        return value;
    }
}
