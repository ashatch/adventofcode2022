package net.andrewhatch.aoc2022;

public enum GameState {
  Win(6),
  Lose(3),
  Draw(0);

  private final int value;

  GameState(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}
