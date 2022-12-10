package net.andrewhatch.aoc2022;

public interface Instruction {
  boolean isComplete();

  void start(Registers registers);

  void end(Registers registers);
}
