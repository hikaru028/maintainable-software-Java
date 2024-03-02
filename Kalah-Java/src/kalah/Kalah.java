package kalah;

import com.qualitascorpus.testsupport.IO;
import com.qualitascorpus.testsupport.MockIO;
import kalah.game.Game;

/**
 * This class is the main entry point for a Kalah application
 * using the test infrastructure.
 *
 *  @author Hikaru Suzuki
 *  @version 1.2
 *  @since 04/08/2023
 *
 *  Modification history:
 *  * - 25/08/2023: Added vertical orientation & the computer player ("best first move") option
 *  * - 29/09/2023: Added 'New Game' and 'Save/Load Game' features and used the Command and Memento Design Patterns
 */
public class Kalah {
	public static void main(String[] args) {
		new Kalah().play(new MockIO());
	}

	public void play(IO io) {
		Game game = new Game(io);
		game.startGame();
	}

	public void play(IO io, boolean vertical, boolean bmf) {
		// DO NOT CHANGE. Only here for backwards compatibility
		play(io);
	}
}
