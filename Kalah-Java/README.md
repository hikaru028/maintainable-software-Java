# KalahStandardStarter

The starter kit for the "load-save-new" version of Kalah.

## README Contents

1. Functional requirements
2. Repository Contents
3. Test Infrastructure
4. Makefile

## Functional
This is needed to support the new features required. The prompt now looks like this:
<pre>
Player P1
    (1-6) - house number for move
    n - New game
    s - Save game
    l - Load game
    q - Quit
Choice:
</pre>
The new features do not affect the rules or presentation of the game.

As has been the case in the past, the details of how the implementation should
behave are given in the test specification files.

### New Game

At any point, either player can restart the game. When this happens, it is as if nothing has happened before this point. So it doesn't matter which player restarts it, P1 will have the first move, and no saves (see below) have taken place.

### Load/Save Game

At any point, either player can save the current state of the game. This will record the state of the board and whose turn it is. At some later point, either player can load the saved game. The game will then proceed from that point. The game can be saved multiple times, but the load will only restore from the most recent save. If a player restarts the game, any saved game is lost.
