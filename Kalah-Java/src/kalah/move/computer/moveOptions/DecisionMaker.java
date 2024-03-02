package kalah.move.computer.moveOptions;

/**
 * This class encapsulate the decision made by a computer player regarding which house to choose
 * for making a move and the reason for that decision.
 */
public class DecisionMaker {
    private final int houseIndex;
    private final String reason;

    public DecisionMaker(int houseIndex, String reason) {
        this.houseIndex = houseIndex;
        this.reason = reason;
    }

    public int getHouseIndex() {
        return houseIndex;
    }

    public String getReason() {
        return reason;
    }
}
