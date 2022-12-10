package net.andrewhatch.aoc2022;

import java.util.List;
import java.util.Set;

public class Cpu {
  private final Registers registers;

  private long sumSignalStrength = 0L;
  private Set<Integer> signalStrengthClocks;
  private List<Instruction> instructions;
  int programCounter = 0;
  private Instruction currentInstruction;

  public Cpu(final Registers registers) {
    this.registers = registers;
  }

  public void executeInstructions(List<Instruction> instructions) {
    this.instructions = instructions;
    boolean done = false;
    int clock = 0;
    while (!done) {
      clock++;
      fetchInstruction();
      if (this.currentInstruction != null) {
        this.currentInstruction.start(registers);

        if (this.signalStrengthClocks.contains(clock)) {
          long signalStrength = (long) clock * this.registers.getRegisterX();
          this.sumSignalStrength += signalStrength;
        }

        this.currentInstruction.end(registers);
      }

      if (programCounter == instructions.size() && currentInstruction.isComplete()) {
        done = true;
      }
    }
  }

  private void fetchInstruction() {
    if (this.currentInstruction == null || this.currentInstruction.isComplete()) {
      this.currentInstruction = this.instructions.get(this.programCounter);
      programCounter++;
    }
  }

  public Registers getRegisters() {
    return registers;
  }

  public long getSumSignalStrength() {
    return sumSignalStrength;
  }

  public void setSignalStrengthClocks(Set<Integer> integers) {
    this.signalStrengthClocks = integers;
  }
}
