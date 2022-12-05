package net.andrewhatch.aoc2022;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CargoCraneTest {
  @Test
  void sampleInputTestPartOne() {
    final CargoCrane crane = new CraneSimInputParser().parse(List.of(
        "    [D]    ",
        "[N] [C]    ",
        "[Z] [M] [P]",
        " 1   2   3 ",
        "",
        "move 1 from 2 to 1",
        "move 3 from 1 to 3",
        "move 2 from 2 to 1",
        "move 1 from 1 to 2"
    ));

    while (crane.hasNextInstruction()) {
      crane.execute9000();
    }

    assertThat(crane.topOfStack()).isEqualTo("CMZ");
  }

  @Test
  void puzzleInputTestPartOne() {
    final CargoCrane crane = new CraneSimInputParser().parse(InputReader.readPuzzleInput());

    while (crane.hasNextInstruction()) {
      crane.execute9000();
    }

    assertThat(crane.topOfStack()).isEqualTo("HNSNMTLHQ");
  }

  @Test
  void sampleInputTestPartTwo() {
    final CargoCrane crane = new CraneSimInputParser().parse(List.of(
        "    [D]    ",
        "[N] [C]    ",
        "[Z] [M] [P]",
        " 1   2   3 ",
        "",
        "move 1 from 2 to 1",
        "move 3 from 1 to 3",
        "move 2 from 2 to 1",
        "move 1 from 1 to 2"
    ));

    while (crane.hasNextInstruction()) {
      crane.execute9001();
    }

    assertThat(crane.topOfStack()).isEqualTo("MCD");
  }

  @Test
  void puzzleInputTestPartTwo() {
    final CargoCrane crane = new CraneSimInputParser().parse(InputReader.readPuzzleInput());

    while (crane.hasNextInstruction()) {
      crane.execute9001();
    }

    assertThat(crane.topOfStack()).isEqualTo("RNLFDJMCT");
  }
}
