package net.andrewhatch.aoc2022;

public class AddX implements Instruction {
  private final int value;
  private int workDone = 0;

  public AddX(int value) {
    this.value = value;
  }

  @Override
  public boolean isComplete() {
    return workDone == 2;
  }

  @Override
  public void start(Registers registers) {
  }

  @Override
  public void end(Registers registers) {
    workDone++;
    if (workDone == 2) {
      registers.setRegisterX(registers.getRegisterX() + this.value);
    }
  }

  @Override
  public String toString() {
    return "AddX{" +
        "value=" + value +
        '}';
  }
}
