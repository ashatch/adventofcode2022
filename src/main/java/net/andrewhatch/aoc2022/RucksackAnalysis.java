package net.andrewhatch.aoc2022;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class RucksackAnalysis {
  public long partOneRucksackPriorities(final List<String> lines) {
    return lines.stream()
        .map(this::toRucksack)
        .map(this::itemsInBothCompartments)
        .map(this::priorities)
        .reduce(0L, Long::sum);
  }

  public long partTwoRucksackPriorities(final List<String> lines) {
    return this.elfRucksacksInGroups(lines)
        .stream()
        .map(this::commonInRucksackGroup)
        .map(this::priorities)
        .reduce(0L, Long::sum);
  }

  public List<String> commonInRucksackGroup(List<String> group) {
    final List<HashSet<String>> sets = group.stream()
        .map(this::toRucksack)
        .map(Rucksack::contents)
        .map(HashSet::new)
        .toList();

    final Iterator<HashSet<String>> iterator = sets.iterator();
    final HashSet<String> result = new HashSet(iterator.next());
    while (iterator.hasNext()) {
      result.retainAll(iterator.next());
    }
    return new ArrayList(result);
  }

  public List<String> itemsInBothCompartments(final Rucksack rucksack) {
    final Set<String> first = new HashSet<>(rucksack.firstCompartment);
    final Set<String> second = new HashSet<>(rucksack.secondCompartment);

    first.retainAll(second);

    return new ArrayList<>(first);
  }

  private List<List<String>> elfRucksacksInGroups(final List<String> lines) {
    final int chunkSize = 3;
    final AtomicInteger counter = new AtomicInteger();
    final List<List<String>> result = new ArrayList<>();

    for (String line: lines) {
      if (counter.getAndIncrement() % chunkSize == 0) {
        result.add(new ArrayList<>());
      }
      result.get(result.size() - 1).add(line);
    }
    return result;
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
    public List<String> contents() {
      final ArrayList<String> contents = new ArrayList<>();
      contents.addAll(firstCompartment);
      contents.addAll(secondCompartment);
      return contents;
    }
  }
}
