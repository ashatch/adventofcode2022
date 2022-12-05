package net.andrewhatch.aoc2022;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public record Cargo(Map<Integer, List<String>> crates) {
  String topOfStack() {
    return crates.keySet().stream().sorted()
        .map(this::topOfCrateStack)
        .collect(Collectors.joining(""));
  }

  private String topOfCrateStack(int number) {
    List<String> crates = this.crates.get(number);
    if (crates.isEmpty()) {
      return " ";
    }
    return crates.get(crates.size() - 1);
  }
}
