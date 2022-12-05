package net.andrewhatch.aoc2022;

import java.util.ArrayList;
import java.util.List;

public class CargoCrane {
  private final Cargo cargo;
  private final List<Instruction> instructions;
  private int currentInstruction;

  public CargoCrane(final Cargo cargo, final List<Instruction> instructions) {
    this.cargo = cargo;
    this.instructions = instructions;
    this.currentInstruction = 0;
  }

  public boolean hasNextInstruction() {
    return instructions.size() > currentInstruction;
  }

  public void execute9000() {
    final Instruction instruction = instructions.get(currentInstruction);

    final List<String> from = cargo.crates().get(instruction.from());
    final List<String> to = cargo.crates().get(instruction.to());

    for (int i = 0; i < instruction.count(); i++) {
      String crate = from.remove(from.size() - 1);
      to.add(crate);
    }

    currentInstruction++;
  }

  public void execute9001() {
    final Instruction instruction = instructions.get(currentInstruction);

    final List<String> from = cargo.crates().get(instruction.from());
    final List<String> to = cargo.crates().get(instruction.to());

    final List<String> moving = new ArrayList<>();
    for (int i = 0; i < instruction.count(); i++) {
      String crate = from.remove(from.size() - 1);
      moving.add(0, crate);
    }

    moving.forEach(to::add);

    currentInstruction++;
  }

  public String topOfStack() {
    return this.cargo.topOfStack();
  }
}
