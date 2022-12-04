package net.andrewhatch.aoc2022;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CampCleanup {

  public long countFullyOverlapping(List<String> input) {
    return input.stream()
        .map(this::assignmentPairParser)
        .map(AssignmentPair::fullyOverlaps)
        .filter(x -> x)
        .count();
  }

  public long countOverlapping(List<String> input) {
    return input.stream()
        .map(this::assignmentPairParser)
        .map(AssignmentPair::overlaps)
        .filter(x -> x)
        .count();
  }

  public AssignmentPair assignmentPairParser(String str) {
    String[] pair = str.split(",");
    List<Long> firstRange = Arrays.stream(pair[0].split("-"))
        .map(Long::parseLong)
        .collect(Collectors.toList());

    List<Long> secondRange = Arrays.stream(pair[1].split("-"))
        .map(Long::parseLong)
        .toList();


    return new AssignmentPair(
        new Assignment(firstRange.get(0), firstRange.get(1)),
        new Assignment(secondRange.get(0), secondRange.get(1))
    );
  }
}
