package ladder.domain;

public class LadderFactory {

    private static final int MINIMUM_LADDER_HEIGHT = 1;
    private final int ladderHeight;

    public LadderFactory(int ladderHeight) {
        validateLadderHeight(ladderHeight);
        this.ladderHeight = ladderHeight;
    }

    private void validateLadderHeight(int ladderHeight) {
        if (ladderHeight < MINIMUM_LADDER_HEIGHT) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_LADDER_HEIGHT);
        }
    }
}
