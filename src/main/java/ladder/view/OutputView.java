package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.PlayersGroup;

import java.util.List;

public class OutputView {

    private static final int LOOP_ZERO = 0;
    private static final int BLANK_BOUNDARY = 0;
    private static final int NAME_CHUNK_LENGTH = 5;

    private OutputView() {
    }

    public static void printPlayerNames(PlayersGroup playersGroup) {
        List<String> playerNames = playersGroup.getPlayerNames();
        StringBuilder stringBuilder = new StringBuilder();
        playerNames.forEach(playerName -> appendEachPlayerName(playerName, stringBuilder));
        System.out.println(stringBuilder.toString());
    }

    private static void appendEachPlayerName(String playerName, StringBuilder stringBuilder) {
        if (stringBuilder.length() == BLANK_BOUNDARY) {
            stringBuilder.append(playerName);
            appendBlank(playerName, stringBuilder);
        }
        if (stringBuilder.length() > BLANK_BOUNDARY) {
            appendBlank(playerName, stringBuilder);
            stringBuilder.append(playerName);
        }
        stringBuilder.append(ViewMessages.BLANK);
    }

    private static void appendBlank(String playerName, StringBuilder stringBuilder) {
        int blankLength = NAME_CHUNK_LENGTH - playerName.length();
        for (int i = LOOP_ZERO; i < blankLength; i++) {
            stringBuilder.append(ViewMessages.BLANK);
        }
    }

    public static void printLadder(Ladder ladder) {
        int ladderHeight = ladder.getLadderHeight();

    }
}
