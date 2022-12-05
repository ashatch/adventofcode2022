package net.andrewhatch.aoc2022;

import java.util.*;
import java.util.stream.Collectors;

public class CraneSimInputParser {
  public CargoCrane parse(List<String> lines) {
    final Cargo cargo = crateStackToCargo(crateStack(lines));
    final List<Instruction> instructions = getInstructions(lines);
    return new CargoCrane(cargo, instructions);
  }

  public List<Instruction> getInstructions(final List<String> lines) {
    return lines.stream()
        .filter(x -> x.startsWith("move"))
        .map(this::parseInstructionLine)
        .collect(Collectors.toList());
  }

  public Instruction parseInstructionLine(String str) {
    final String[] parts = str.split(" ");
    final int count = Integer.parseInt(parts[1]);
    final int from = Integer.parseInt(parts[3]);
    final int to = Integer.parseInt(parts[5]);
    return new Instruction(from, to, count);
  }

  public Cargo crateStackToCargo(List<Map<Integer, String>> crateStack) {
    final Map<Integer, List<String>> crates = new HashMap<>();
    final ListIterator<Map<Integer, String>> listIterator = crateStack.listIterator(crateStack.size());
    while (listIterator.hasPrevious()) {
      Map<Integer, String> cs = listIterator.previous();
      cs.keySet().forEach(index -> {
        final String crateLetter = cs.get(index);
        crates.putIfAbsent(index, new ArrayList<>());
        crates.get(index).add(crateLetter);
      });
    }

    return new Cargo(crates);
  }

  public List<Map<Integer, String>> crateStack(List<String> lines) {
    return lines.stream()
        .takeWhile(x -> (x.startsWith(" ") || x.startsWith("[")) && (!x.startsWith(" 1")))
        .map(line -> {
          Map<Integer, String> stackLine = new HashMap<>();
          for (int i = 1, idx = 1; i < line.length(); i += 4, idx += 1) {
            final String crateLetter = line.substring(i, i + 1);
            if (!crateLetter.trim().isEmpty()) {
              stackLine.put(idx, crateLetter);
            }
          }
          return stackLine;
        }).toList();
  }
}
