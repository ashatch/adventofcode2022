package net.andrewhatch.aoc2022;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MotionSeriesParserTest {
  @Test
  void parseTest() {
    final MotionSeriesParser parser = new MotionSeriesParser();
    List<Movement> movements = parser.parse(List.of(
        "R 4",
        "U 4",
        "L 3",
        "D 1",
        "R 4",
        "D 1",
        "L 5",
        "R 2"
    ));
    assertThat(movements).isEqualTo(List.of(
        new Movement(Direction.R, 4),
        new Movement(Direction.U, 4),
        new Movement(Direction.L, 3),
        new Movement(Direction.D, 1),
        new Movement(Direction.R, 4),
        new Movement(Direction.D, 1),
        new Movement(Direction.L, 5),
        new Movement(Direction.R, 2)
    ));
  }
}
