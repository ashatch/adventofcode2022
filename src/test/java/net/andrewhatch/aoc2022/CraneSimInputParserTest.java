package net.andrewhatch.aoc2022;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class CraneSimInputParserTest {
  @Test
  void crateStack() {
    assertThat(new CraneSimInputParser().crateStack(List.of(
        "    [D]    ",
        "[N] [C]    ",
        "[Z] [M] [P]"
    ))).isEqualTo(List.of(
        Map.of(2, "D"),
        Map.of(1, "N", 2, "C"),
        Map.of(1, "Z", 2, "M", 3, "P")
    ));
  }

  @Test
  void cargo() {
    CraneSimInputParser parser = new CraneSimInputParser();
    List<Map<Integer, String>> crateStack = parser.crateStack(List.of(
        "    [D]    ",
        "[N] [C]    ",
        "[Z] [M] [P]"
    ));
    final Cargo cargo = parser.crateStackToCargo(crateStack);

    assertThat(cargo.crates()).isEqualTo(
        Map.of(
            1, List.of("Z", "N"),
            2, List.of("M", "C", "D"),
            3, List.of("P")
        )
    );
  }

  @Test
  void parseInstructionLine() {
    final CraneSimInputParser parser = new CraneSimInputParser();
    final Instruction instruction = parser.parseInstructionLine("move 1 from 7 to 6");
    assertThat(instruction).isEqualTo(new Instruction(7, 6, 1));
  }
}
