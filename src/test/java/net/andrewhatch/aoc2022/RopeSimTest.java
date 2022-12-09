package net.andrewhatch.aoc2022;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RopeSimTest {
  @Test
  void partTwoSampleStepTest() {
    final RopeSim ropeSim = new RopeSim();
    final MotionSeriesParser parser = new MotionSeriesParser();
    final List<Movement> movements = parser.parse(List.of(
        "R 5",
        "U 8",
        "L 8",
        "D 3",
        "R 17",
        "D 10",
        "L 25",
        "U 20"
    ));
    ropeSim.step(new Movement(Direction.R, 5));
    ropeSim.step(new Movement(Direction.U, 8));
  }
  @Test
  void partTwoSampleTest() {
    final RopeSim ropeSim = new RopeSim();
    final MotionSeriesParser parser = new MotionSeriesParser();
    final List<Movement> movements = parser.parse(List.of(
        "R 5",
        "U 8",
        "L 8",
        "D 3",
        "R 17",
        "D 10",
        "L 25",
        "U 20"
    ));
    ropeSim.step(movements);

    assertThat(ropeSim.visitedPlacesCount()).isEqualTo(36L);
  }

  @Test
  void partTwoInputTest() {
    final RopeSim ropeSim = new RopeSim();
    final MotionSeriesParser parser = new MotionSeriesParser();
    final List<Movement> movements = parser.parse(InputReader.readPuzzleInput());
    ropeSim.step(movements);

    assertThat(ropeSim.visitedPlacesCount()).isEqualTo(2352L);
  }
}
