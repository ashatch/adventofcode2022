package net.andrewhatch.aoc2022;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RucksackAnalysisTest {
  final RucksackAnalysis r = new RucksackAnalysis();

  @Test
  void rucksackExampleTest() {
    assertThat(r.sumOfPriorities(List.of(
        "vJrwpWtwJgWrhcsFMMfFFhFp",
        "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
        "PmmdzqPrVvPwwTWBwg",
        "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
        "ttgJtRGJQctTZtZT",
        "CrZsJsPPZsGzwwsLwLmpwMDw"
    ))).isEqualTo(157L);
  }

  @Test
  void rucksackInputTest() {
    assertThat(r.sumOfPriorities(InputReader.readPuzzleInput())).isEqualTo(7826L);
  }

  @Test
  void findCommon() {
    assertThat(r.itemsInBothCompartments(r.toRucksack("vJrwpWtwJgWrhcsFMMfFFhFp"))).isEqualTo(List.of("p"));
    assertThat(r.itemsInBothCompartments(r.toRucksack("jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL"))).isEqualTo(List.of("L"));
  }

  @Test
  void toRucksack() {
    assertThat(r.toRucksack("vJrwpWtwJgWrhcsFMMfFFhFp")).isEqualTo(new RucksackAnalysis.Rucksack(
        List.of("v", "J", "r", "w", "p", "W", "t", "w", "J", "g", "W", "r"),
        List.of("h", "c", "s", "F", "M", "M", "f", "F", "F", "h", "F", "p")
    ));
  }

  @Test
  void priority() {
    assertThat(r.priority("a")).isEqualTo(1);
    assertThat(r.priority("z")).isEqualTo(26);
    assertThat(r.priority("A")).isEqualTo(27);
    assertThat(r.priority("Z")).isEqualTo(52);
  }
}
