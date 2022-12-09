package net.andrewhatch.aoc2022;

import java.util.List;

public class MotionSeriesParser {
  public List<Movement> parse(final List<String> lines) {
    return lines.stream()
        .map(this::parseLine)
        .toList();
  }

  private Movement parseLine(final String line) {
    String[] parts = line.split(" ");
    final Direction dir = Direction.valueOf(parts[0]);
    final int steps = Integer.parseInt(parts[1]);
    return new Movement(dir, steps);
  }
}
