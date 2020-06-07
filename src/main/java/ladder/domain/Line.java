package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Line {

    private static final int PLAYER_COUNTS_LIMIT = 1;
    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line drawLine(int playerCounts) {
        validatePlayerCounts(playerCounts);
        List<Point> points = drawLineWithStrategy(playerCounts, new RandomDrawingLineStrategy());
        return new Line(points);
    }

    private static void validatePlayerCounts(int playerCounts) {
        if (playerCounts < PLAYER_COUNTS_LIMIT) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_PLAYER_COUNTS);
        }
    }

    private static List<Point> drawLineWithStrategy(int playerCounts,
                                                    DrawingLineStrategy drawingLineStrategy) {
        return drawingLineStrategy.drawLine(playerCounts);
    }

    public List<Boolean> getLinePositions() {
        return points.stream()
                .map(Point::getIsOnPosition)
                .collect(Collectors.toList());
    }
}
