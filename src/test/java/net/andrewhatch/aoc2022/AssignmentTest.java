package net.andrewhatch.aoc2022;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AssignmentTest {
  @Test
  void fullyOverlaps() {
    Assignment assignment = new Assignment(5, 10);
    assertThat(new Assignment(1, 2).fullyOverlaps(assignment)).isFalse();
    assertThat(new Assignment(1, 7).fullyOverlaps(assignment)).isFalse();
    assertThat(new Assignment(11, 20).fullyOverlaps(assignment)).isFalse();
    assertThat(new Assignment(8, 20).fullyOverlaps(assignment)).isFalse();
    assertThat(new Assignment(6, 9).fullyOverlaps(assignment)).isFalse();

    assertThat(new Assignment(4, 11).fullyOverlaps(assignment)).isTrue();
    assertThat(new Assignment(5, 10).fullyOverlaps(assignment)).isTrue();
  }

  @Test
  void overlaps() {
    Assignment assignment = new Assignment(5, 10);
    assertThat(new Assignment(1, 2).overlaps(assignment)).isFalse();
    assertThat(new Assignment(11, 12).overlaps(assignment)).isFalse();
    assertThat(new Assignment(1, 7).overlaps(assignment)).isTrue();
    assertThat(new Assignment(8, 12).overlaps(assignment)).isTrue();
  }
}
