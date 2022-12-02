package net.andrewhatch.aoc2022;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RockPaperScissorsSimTest {
  final RockPaperScissorsSim sim = new RockPaperScissorsSim();

  @Test
  void exampleTest() {
    assertThat(sim.score(List.of(
        "A Y",
        "B X",
        "C Z"
    ))).isEqualTo(15L);
  }

  @Test
  void puzzleInputTest() {
    assertThat(sim.score(InputReader.readPuzzleInput())).isEqualTo(11906L);
  }
}
