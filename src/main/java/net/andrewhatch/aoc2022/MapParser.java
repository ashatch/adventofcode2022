package net.andrewhatch.aoc2022;

import java.util.List;

public class MapParser {
  public List<Integer> parseLine(final String line) {
    return line.chars()
        .mapToObj(c -> String.valueOf((char)c))
        .map(Integer::parseInt)
        .toList();
  }

  public List<List<Integer>> parse(List<String> input) {
    return input.stream()
        .map(this::parseLine).toList();
  }
}
