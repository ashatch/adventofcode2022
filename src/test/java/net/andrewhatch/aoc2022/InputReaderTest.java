package net.andrewhatch.aoc2022;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InputReaderTest {
  @Test
  void readsPuzzleInput() {
    assertThat(InputReader.readPuzzleInput()).hasSizeGreaterThan(0);
  }
}
