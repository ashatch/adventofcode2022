package net.andrewhatch.aoc2022;

public class Noop implements Instruction {

  boolean isComplete = false;

  @Override
  public boolean isComplete() {
    return isComplete;
  }

  @Override
  public void start(Registers registers) {
    // do nothing
  }

  @Override
  public void end(Registers registers) {
    this.isComplete = true;
  }

  @Override
  public String toString() {
    return "Noop{" +
        '}';
  }
}
