package net.andrewhatch.aoc2022;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RucksackAnalysis {
  public long sumOfPriorities(final List<String> lines) {
    return lines.stream()
        .map(this::toRucksack)
        .map(this::itemsInBothCompartments)
        .map(this::priorities)
        .reduce(0L, Long::sum);
  }

  public List<String> itemsInBothCompartments(final Rucksack rucksack) {
    final Set<String> first = new HashSet<>(rucksack.firstCompartment);
    final Set<String> second = new HashSet<>(rucksack.secondCompartment);

    first.retainAll(second);

    return new ArrayList<>(first);
  }

  public Rucksack toRucksack(final String line) {
    List<String> firstCompartment = line.substring(0, line.length() / 2).chars()
        .mapToObj(c -> String.valueOf((char) c))
        .collect(Collectors.toList());

    List<String> secondCompartment = line.substring(line.length() / 2).chars()
        .mapToObj(c -> String.valueOf((char) c))
        .collect(Collectors.toList());

    return new Rucksack(firstCompartment, secondCompartment);
  }

  public long priorities(final List<String> stringList) {
    return stringList
        .stream().map(this::priority)
        .reduce(0L, Long::sum);
  }

  public long priority(final String str) {
    return str.chars()
        .map(x -> {
          if (x > 96) {
            return x - 96;
          } else {
            return x - 38;
          }
        })
        .sum();
  }

  public record Rucksack(List<String> firstCompartment, List<String> secondCompartment) {
  }
}
