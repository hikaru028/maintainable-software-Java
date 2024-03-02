package kalah.board;

public enum BoardConstants {
    DEFAULT_SEEDS(4),
    HOUSES(6), // default number of houses each player has
    TOTAL_PITS(14),
    P1_STORE_INDEX(6),
    P2_STORE_INDEX(13),
    P1_START_HOUSE_INDEX(0),
    P2_START_HOUSE_INDEX(7), // also computer player side
    P2_END_HOUSE_INDEX(12); // also computer player side

    private final int value;

    BoardConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
