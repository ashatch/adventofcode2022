package net.andrewhatch.aoc2022;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CalorieCounter {
  public long highestCaloriesCarriedByOneElf(final List<String> lines) {
    return snackCaloriesByElf(lines)
        .stream()
        .map(this::totalCaloriesCarriedByElf)
        .max(Comparator.naturalOrder())
        .orElse(0L);
  }

  public long sumTopThreeCaloriesCarriedByElves(final List<String> lines) {
    return snackCaloriesByElf(lines)
        .stream()
        .map(this::totalCaloriesCarriedByElf)
        .sorted(Comparator.reverseOrder())
        .limit(3)
        .reduce(0L, Long::sum);
  }

  private List<List<Long>> snackCaloriesByElf(final List<String> lines) {
    final List<List<Long>> snackCaloriesByElf = new ArrayList<>();
    final List<Long> snackCaloriesCurrentElf = new ArrayList<>();

    lines.stream()
        .map(String::trim)
        .forEach(line -> {
          if ("".equals(line)) {
            snackCaloriesByElf.add(List.copyOf(snackCaloriesCurrentElf));
            snackCaloriesCurrentElf.clear();
          } else {
            snackCaloriesCurrentElf.add(Long.parseLong(line.trim()));
          }
        });

    return snackCaloriesByElf;
  }

  private long totalCaloriesCarriedByElf(final List<Long> caloriesCarried) {
    return caloriesCarried.stream()
        .reduce(0L, Long::sum);
  }
}
