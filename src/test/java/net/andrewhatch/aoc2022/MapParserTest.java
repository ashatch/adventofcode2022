package net.andrewhatch.aoc2022;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class MapParserTest {
  @Test
  void parseMapTest() {
    final List<String> input = List.of(
        "30373",
        "25512",
        "65332",
        "33549",
        "35390"
    );

    List<List<Integer>> output = new MapParser().parse(input);

    Assertions.assertThat(output).isEqualTo(
        List.of(
            List.of(3, 0, 3, 7, 3),
            List.of(2, 5, 5, 1, 2),
            List.of(6, 5, 3, 3, 2),
            List.of(3, 3, 5, 4, 9),
            List.of(3, 5, 3, 9, 0)
        )
    );
  }

}