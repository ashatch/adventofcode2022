package net.andrewhatch.aoc2022;

import org.junit.jupiter.api.Test;

import java.util.List;

import static net.andrewhatch.aoc2022.Direction.*;
import static org.assertj.core.api.Assertions.assertThat;

class RopeSimTest {
  @Test
  void moveUpInStepsOfOne() {
    final RopeSim ropeSim = new RopeSim();
    assertThat(ropeSim.getHeadPosition()).isEqualTo(new Position(0, 0));
    assertThat(ropeSim.getTailPosition()).isEqualTo(new Position(0, 0));
    assertThat(ropeSim.visitedPlacesCount()).isEqualTo(1L);

    ropeSim.step(new Movement(U, 1));
    assertThat(ropeSim.getHeadPosition()).isEqualTo(new Position(0, 1));
    assertThat(ropeSim.getTailPosition()).isEqualTo(new Position(0, 0));
    assertThat(ropeSim.visitedPlacesCount()).isEqualTo(1L);

    ropeSim.step(new Movement(U, 1));
    assertThat(ropeSim.getHeadPosition()).isEqualTo(new Position(0, 2));
    assertThat(ropeSim.getTailPosition()).isEqualTo(new Position(0, 1));
    assertThat(ropeSim.visitedPlacesCount()).isEqualTo(2L);

    ropeSim.step(new Movement(U, 1));
    assertThat(ropeSim.getHeadPosition()).isEqualTo(new Position(0, 3));
    assertThat(ropeSim.getTailPosition()).isEqualTo(new Position(0, 2));
    assertThat(ropeSim.visitedPlacesCount()).isEqualTo(3L);
  }

  @Test
  void moveDownInStepsOfOne() {
    final RopeSim ropeSim = new RopeSim();
    assertThat(ropeSim.getHeadPosition()).isEqualTo(new Position(0, 0));
    assertThat(ropeSim.getTailPosition()).isEqualTo(new Position(0, 0));
    assertThat(ropeSim.visitedPlacesCount()).isEqualTo(1L);

    ropeSim.step(new Movement(D, 1));
    assertThat(ropeSim.getHeadPosition()).isEqualTo(new Position(0, -1));
    assertThat(ropeSim.getTailPosition()).isEqualTo(new Position(0, 0));
    assertThat(ropeSim.visitedPlacesCount()).isEqualTo(1L);

    ropeSim.step(new Movement(D, 1));
    assertThat(ropeSim.getHeadPosition()).isEqualTo(new Position(0, -2));
    assertThat(ropeSim.getTailPosition()).isEqualTo(new Position(0, -1));
    assertThat(ropeSim.visitedPlacesCount()).isEqualTo(2L);

    ropeSim.step(new Movement(D, 1));
    assertThat(ropeSim.getHeadPosition()).isEqualTo(new Position(0, -3));
    assertThat(ropeSim.getTailPosition()).isEqualTo(new Position(0, -2));
    assertThat(ropeSim.visitedPlacesCount()).isEqualTo(3L);
  }

  @Test
  void moveRightInStepsOfOne() {
    final RopeSim ropeSim = new RopeSim();
    assertThat(ropeSim.getHeadPosition()).isEqualTo(new Position(0, 0));
    assertThat(ropeSim.getTailPosition()).isEqualTo(new Position(0, 0));
    assertThat(ropeSim.visitedPlacesCount()).isEqualTo(1L);

    ropeSim.step(new Movement(R, 1));
    assertThat(ropeSim.getHeadPosition()).isEqualTo(new Position(1, 0));
    assertThat(ropeSim.getTailPosition()).isEqualTo(new Position(0, 0));
    assertThat(ropeSim.visitedPlacesCount()).isEqualTo(1L);

    ropeSim.step(new Movement(R, 1));
    assertThat(ropeSim.getHeadPosition()).isEqualTo(new Position(2, 0));
    assertThat(ropeSim.getTailPosition()).isEqualTo(new Position(1, 0));
    assertThat(ropeSim.visitedPlacesCount()).isEqualTo(2L);

    ropeSim.step(new Movement(R, 1));
    assertThat(ropeSim.getHeadPosition()).isEqualTo(new Position(3, 0));
    assertThat(ropeSim.getTailPosition()).isEqualTo(new Position(2, 0));
    assertThat(ropeSim.visitedPlacesCount()).isEqualTo(3L);
  }

  @Test
  void moveLeftInStepsOfOne() {
    final RopeSim ropeSim = new RopeSim();
    assertThat(ropeSim.getHeadPosition()).isEqualTo(new Position(0, 0));
    assertThat(ropeSim.getTailPosition()).isEqualTo(new Position(0, 0));
    assertThat(ropeSim.visitedPlacesCount()).isEqualTo(1L);

    ropeSim.step(new Movement(L, 1));
    assertThat(ropeSim.getHeadPosition()).isEqualTo(new Position(-1, 0));
    assertThat(ropeSim.getTailPosition()).isEqualTo(new Position(0, 0));
    assertThat(ropeSim.visitedPlacesCount()).isEqualTo(1L);

    ropeSim.step(new Movement(L, 1));
    assertThat(ropeSim.getHeadPosition()).isEqualTo(new Position(-2, 0));
    assertThat(ropeSim.getTailPosition()).isEqualTo(new Position(-1, 0));
    assertThat(ropeSim.visitedPlacesCount()).isEqualTo(2L);

    ropeSim.step(new Movement(L, 1));
    assertThat(ropeSim.getHeadPosition()).isEqualTo(new Position(-3, 0));
    assertThat(ropeSim.getTailPosition()).isEqualTo(new Position(-2, 0));
    assertThat(ropeSim.visitedPlacesCount()).isEqualTo(3L);
  }

  @Test
  void diagonalRightUpTest() {
    final RopeSim ropeSim = new RopeSim();
    assertThat(ropeSim.getHeadPosition()).isEqualTo(new Position(0, 0));
    assertThat(ropeSim.getTailPosition()).isEqualTo(new Position(0, 0));
    assertThat(ropeSim.visitedPlacesCount()).isEqualTo(1L);

    ropeSim.step(new Movement(R, 1));
    assertThat(ropeSim.getHeadPosition()).isEqualTo(new Position(1, 0));
    assertThat(ropeSim.getTailPosition()).isEqualTo(new Position(0, 0));
    assertThat(ropeSim.visitedPlacesCount()).isEqualTo(1L);

    ropeSim.step(new Movement(U, 1));
    assertThat(ropeSim.getHeadPosition()).isEqualTo(new Position(1, 1));
    assertThat(ropeSim.getTailPosition()).isEqualTo(new Position(0, 0));
    assertThat(ropeSim.visitedPlacesCount()).isEqualTo(1L);

    ropeSim.step(new Movement(U, 1));
    assertThat(ropeSim.getHeadPosition()).isEqualTo(new Position(1, 2));
    assertThat(ropeSim.getTailPosition()).isEqualTo(new Position(1, 1));
    assertThat(ropeSim.visitedPlacesCount()).isEqualTo(2L);
  }

  @Test
  void partOneSampleStepwiseTest() {
    final RopeSim ropeSim = new RopeSim();
    ropeSim.step(new Movement(R, 4));
    assertThat(ropeSim.getHeadPosition()).isEqualTo(new Position(4, 0));
    assertThat(ropeSim.getTailPosition()).isEqualTo(new Position(3, 0));
    assertThat(ropeSim.visitedPlacesCount()).isEqualTo(4L);

    ropeSim.step(new Movement(U, 4));
    assertThat(ropeSim.getHeadPosition()).isEqualTo(new Position(4, 4));
    assertThat(ropeSim.getTailPosition()).isEqualTo(new Position(4, 3));
    assertThat(ropeSim.visitedPlacesCount()).isEqualTo(7L);

    ropeSim.step(new Movement(L, 3));
    assertThat(ropeSim.getHeadPosition()).isEqualTo(new Position(1, 4));
    assertThat(ropeSim.getTailPosition()).isEqualTo(new Position(2, 4));
    assertThat(ropeSim.visitedPlacesCount()).isEqualTo(9L);
  }

  @Test
  void partOneSampleTest() {
    final RopeSim ropeSim = new RopeSim();
    final MotionSeriesParser parser = new MotionSeriesParser();
    final List<Movement> movements = parser.parse(List.of(
        "R 4",
        "U 4",
        "L 3",
        "D 1",
        "R 4",
        "D 1",
        "L 5",
        "R 2"
    ));
    ropeSim.step(movements);

    assertThat(ropeSim.visitedPlacesCount()).isEqualTo(13L);
  }

  @Test
  void partOneInputTest() {
    final RopeSim ropeSim = new RopeSim();
    final MotionSeriesParser parser = new MotionSeriesParser();
    final List<Movement> movements = parser.parse(InputReader.readPuzzleInput());
    ropeSim.step(movements);

    assertThat(ropeSim.visitedPlacesCount()).isEqualTo(5981L);
  }
}
