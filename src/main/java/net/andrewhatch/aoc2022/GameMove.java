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

  public GameMove winAgainst() {
    return switch (this) {
      case Rock -> GameMove.Paper;
      case Paper -> GameMove.Scissors;
      case Scissors -> GameMove.Rock;
    };
  }

  public GameMove drawAgainst() {
    return this;
  }

  public GameMove loseAgainst() {
    return switch (this) {
      case Rock -> GameMove.Scissors;
      case Paper -> GameMove.Rock;
      case Scissors -> GameMove.Paper;
    };
  }
}

