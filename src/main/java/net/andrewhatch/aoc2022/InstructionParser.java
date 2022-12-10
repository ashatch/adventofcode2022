package net.andrewhatch.aoc2022;

import java.util.List;
import java.util.Optional;

public class InstructionParser {
  public List<Instruction> parse(List<String> input) {
    return input.stream()
        .map(this::parse)
        .filter(Optional::isPresent)
        .map(Optional::get)
        .toList();
  }

  public Optional<Instruction> parse(String input) {
    if (input.startsWith("addx")) {
      String[] parts = input.split(" ");
      int param = Integer.parseInt(parts[1]);
      return Optional.of(new AddX(param));
    }
    if (input.startsWith("noop")) {
      return Optional.of(new Noop());
    }

    return Optional.empty();
  }
}
