package net.andrewhatch.aoc2022;

import java.util.List;
import java.util.Set;

public class Cpu {
  private final Registers registers;
  private final Crt crt;

  private long sumSignalStrength = 0L;
  private Set<Integer> signalStrengthClocks;
  private List<Instruction> instructions;
  int programCounter = 0;
  private Instruction currentInstruction;

  public Cpu(final Registers registers, final Crt crt) {
    this.registers = registers;
    this.crt = crt;
  }

  public void executeInstructions(List<Instruction> instructions) {
    this.instructions = instructions;
    boolean done = false;
    int clock = 0;

    this.crt.setSpritePosition(this.registers.getRegisterX());

    while (!done) {
      clock++;
      fetchInstruction();
      if (this.currentInstruction != null) {
        this.currentInstruction.start(registers);

        this.crt.drawSpriteAtPos(clock);
        System.out.println(this.crt);

        if (this.signalStrengthClocks.contains(clock)) {
          long signalStrength = (long) clock * this.registers.getRegisterX();
          this.sumSignalStrength += signalStrength;
        }

        this.currentInstruction.end(registers);
        this.crt.setSpritePosition(this.registers.getRegisterX());
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

  public Crt getCrt() {
    return crt;
  }
}
