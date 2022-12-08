package net.andrewhatch.aoc2022;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TreeTopMapperTest {
  final MapParser parser = new MapParser();
  final TreeTopMapper mapper = new TreeTopMapper();

  @Test
  void partOneSampleInputTest() {
    final List<String> input = List.of(
        "30373",
        "25512",
        "65332",
        "33549",
        "35390"
    );
    final List<List<Integer>> treetopMap = parser.parse(input);
    long visibleCount = mapper.visibilityCount(treetopMap);
    assertThat(visibleCount).isEqualTo(21);
  }

  @Test
  void partTwoSampleInputTest() {
    final List<String> input = List.of(
        "30373",
        "25512",
        "65332",
        "33549",
        "35390"
    );
    final List<List<Integer>> treetopMap = parser.parse(input);
    long measure = mapper.maxScenicMeasure(treetopMap);
    assertThat(measure).isEqualTo(8);
  }


  @Test
  void partTwoPuzzleInputTest() {
    final List<List<Integer>> treetopMap = parser.parse(InputReader.readPuzzleInput());
    long measure = mapper.maxScenicMeasure(treetopMap);
    assertThat(measure).isEqualTo(480000L);
  }


  @Test
  void partOnePuzzleInputTest() {
    final List<String> input = InputReader.readPuzzleInput();
    final List<List<Integer>> treetopMap = parser.parse(input);
    long visibleCount = mapper.visibilityCount(treetopMap);
    assertThat(visibleCount).isEqualTo(1807L);
  }

  @Test
  void edgesVisible() {
    final List<String> input = List.of(
        "30373",
        "25512",
        "65332",
        "33549",
        "35390"
    );
    final List<List<Integer>> treetopMap = parser.parse(input);
    assertThat(mapper.treeIsVisibleAt(treetopMap, 0, 0)).isTrue();
    assertThat(mapper.treeIsVisibleAt(treetopMap, 1, 0)).isTrue();
    assertThat(mapper.treeIsVisibleAt(treetopMap, 4, 0)).isTrue();
    assertThat(mapper.treeIsVisibleAt(treetopMap, 4, 1)).isTrue();
    assertThat(mapper.treeIsVisibleAt(treetopMap, 4, 4)).isTrue();
    assertThat(mapper.treeIsVisibleAt(treetopMap, 3, 4)).isTrue();
    assertThat(mapper.treeIsVisibleAt(treetopMap, 0, 4)).isTrue();
    assertThat(mapper.treeIsVisibleAt(treetopMap, 3, 1)).isFalse();
  }

  @Test
  void scenicMeasureTest() {
    final List<String> input = List.of(
        "30373",
        "25512",
        "65332",
        "33549",
        "35390"
    );
    final List<List<Integer>> treetopMap = parser.parse(input);
    assertThat(mapper.measureLookingLeft(treetopMap, 2, 3)).isEqualTo(2);
    assertThat(mapper.measureLookingRight(treetopMap, 2, 3)).isEqualTo(2);
    assertThat(mapper.measureLookingUp(treetopMap, 2, 3)).isEqualTo(2);
    assertThat(mapper.measureLookingDown(treetopMap, 2, 3)).isEqualTo(1);
    assertThat(mapper.scenicMeasure(treetopMap, 2, 3)).isEqualTo(8);
    assertThat(mapper.scenicMeasure(treetopMap, 2, 1)).isEqualTo(4);
  }
}
