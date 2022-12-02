package net.andrewhatch.aoc2022;

public enum GameMove {
  Rock(1),
  Paper(2),
  Scissors(3);

  private final int value;

  GameMove(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}
