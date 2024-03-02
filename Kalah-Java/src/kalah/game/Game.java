package kalah.game;

import com.qualitascorpus.testsupport.IO;
import kalah.board.Board;
import kalah.board.components.Pit;
import kalah.player.Player;
import kalah.game.gameState.GameStateStorage;
import kalah.game.gameState.GameStateSnapshot;
import kalah.game.controllers.SelectedCommandHandler;
import kalah.utils.printer.GameOverPrinter;
import kalah.utils.printer.FinalResultPrinter;
import kalah.move.playerChoice.UserChoice;
import kalah.move.playerChoice.PlayerChoice;
import kalah.move.playerChoice.ComputerChoice;
import kalah.move.user.MoveChecker;

/**
 * This class represents a single game of Kalah
 * and handles game logic, player turns, and game state, providing the main game loop.
 */
public class Game {
    private static final int COMPUTER_GAME_OPTION = 2; // Number of "user vs computer with the horizontal board"
    private int gameOption = 3; // Default number of "user vs user with the Horizontal board"
    private boolean isRunning = true;
    private IO io;
    private Board board;
    private Pit[] pits;
    private Player p1;
    private Player p2;
    private Player currentPlayer;
    private GameStateStorage stateStorage;
    private GameOverPrinter gameOverPrinter;
    private FinalResultPrinter finalResultPrinter;
    private PlayerChoice playerChoice;
    private SelectedCommandHandler commandHandler;
    private MoveChecker moveChecker;

    public Game(IO io) {
        initialiseConstructor(io);
    }

    public Game(IO io, int gameOption) {
        this.gameOption = gameOption;
        initialiseConstructor(io);
    }

    private void initialiseConstructor(IO io) {
        this.io = io;
        this.p1 = new Player("P1");
        this.p2 = new Player("P2");
        this.currentPlayer = p1;
        this.board = new Board(io, p1, p2);
        this.pits = board.getPits();
        this.stateStorage = new GameStateStorage();
        this.commandHandler = new SelectedCommandHandler();
        this.finalResultPrinter = new FinalResultPrinter(io, board);
        this.gameOverPrinter = new GameOverPrinter(io, board);
    }

    /**
     * To Represent the main game loop and keep the game running until end conditions are met.
     */
    public void startGame() {
        while (isRunning) {
            if (!board.areAllHousesEmptyByCurrentPlayer(currentPlayer)) {
                board.getBoard(gameOption);

                if (currentPlayer == p2 && gameOption == COMPUTER_GAME_OPTION) {
                    this.playerChoice = new ComputerChoice(io, pits); // gameOption is 2
                } else {
                    this.playerChoice = new UserChoice(io, p1, p2); // gameOption is 1 or 3
                }

                int playerChoice = this.playerChoice.getPlayerChoice(currentPlayer);

                if (playerChoice < 0) {
                    commandHandler.handlePlayerChoice(this, playerChoice);
                } else {
                    this.moveChecker = new MoveChecker(io,board, pits, this);
                    boolean isOpponentTurn = moveChecker.canMakeMove(currentPlayer, playerChoice);
                    switchPlayer(isOpponentTurn);
                }
            } else {
                endGame();
                break;
            }
        }
    }

    public void restartGame() {
        stateStorage.clearSnapshot();
        board.initialisePits(p1, p2);
        currentPlayer = p1;
        startGame();
    }

    public void saveGame() {
        stateStorage.saveSnapshot(currentPlayer, pits);
    }

    public void loadGame() {
        GameStateSnapshot stateSnapshot = stateStorage.restoreSnapshot();

        if (stateSnapshot != null) {
            int[] savedPitsState = stateSnapshot.getPitsState();
            for (int i = 0; i < savedPitsState.length; i++) {
                pits[i].setNumberOfSeeds(savedPitsState[i]);
            }
            currentPlayer = stateSnapshot.getCurrentPlayer();
            stateStorage.clearSnapshot();
        } else {
            io.println("No saved game");
        }
    }

    public void quitGame() {
        gameOverPrinter.printGameOver(gameOption);
        isRunning = false;
    }

    private void endGame() {
        board.getBoard(gameOption);
        gameOverPrinter.printGameOver(gameOption);
        finalResultPrinter.printFinalResult(p1, p2);
        isRunning = false;
    }

    private void switchPlayer(boolean isOpponentTurn) {
        if (isOpponentTurn) {
            currentPlayer = (currentPlayer == p1) ? p2 : p1;
        }
    }
}