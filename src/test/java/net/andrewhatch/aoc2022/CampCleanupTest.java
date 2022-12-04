package net.andrewhatch.aoc2022;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CampCleanupTest {
  final CampCleanup subject = new CampCleanup();

  @Test
  void pairParserTest() {
    final AssignmentPair pair = subject.assignmentPairParser("2-4,6-8");
    assertThat(pair.fullyOverlaps()).isFalse();
  }

  @Test
  void partOneExampleTest() {
    long count = subject.countFullyOverlapping(List.of(
        "2-4,6-8",
        "2-3,4-5",
        "5-7,7-9",
        "2-8,3-7",
        "6-6,4-6",
        "2-6,4-8"
    ));

    assertThat(count).isEqualTo(2L);
  }

  @Test
  void partTwoExampleTest() {
    long count = subject.countOverlapping(List.of(
        "2-4,6-8",
        "2-3,4-5",
        "5-7,7-9",
        "2-8,3-7",
        "6-6,4-6",
        "2-6,4-8"
    ));

    assertThat(count).isEqualTo(4L);
  }

  @Test
  void partOnePuzzleTest() {
    long count = subject.countFullyOverlapping(InputReader.readPuzzleInput());
    assertThat(count).isEqualTo(542L);
  }

  @Test
  void partTwoPuzzleTest() {
    long count = subject.countOverlapping(InputReader.readPuzzleInput());
    assertThat(count).isEqualTo(900L);
  }
}
