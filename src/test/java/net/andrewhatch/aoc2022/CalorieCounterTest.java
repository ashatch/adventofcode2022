package net.andrewhatch.aoc2022;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CalorieCounterTest {
  final CalorieCounter counter = new CalorieCounter();

  @Test
  void calorieTest() {
    Assertions.assertThat(counter.highestCaloriesCarriedByOneElf(List.of(
        "1",
        "",
        "1",
        "2",
        "3",
        ""
    ))).isEqualTo(6L);
  }

  @Test
  void caloriePuzzlePartOneTest() {
    final List<String> puzzleInput = InputReader.readPuzzleInput();
    Assertions.assertThat(counter.highestCaloriesCarriedByOneElf(puzzleInput))
        .isEqualTo(68923L);
  }

  @Test
  void caloriePuzzlePartTwoTest() {
    final List<String> puzzleInput = InputReader.readPuzzleInput();
    Assertions.assertThat(counter.sumTopThreeCaloriesCarriedByElves(puzzleInput))
        .isEqualTo(200044L);
  }
}
