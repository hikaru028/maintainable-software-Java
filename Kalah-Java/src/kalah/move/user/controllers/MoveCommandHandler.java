package kalah.move.user.controllers;

public class MoveCommandHandler {
    private MoveCommand command;

    public void setCommand(MoveCommand command) {
        this.command = command;
    }

    public CommandResult executeCommand() {
        return command.execute();
    }
}
