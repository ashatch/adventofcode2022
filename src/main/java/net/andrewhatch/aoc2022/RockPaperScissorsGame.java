package net.andrewhatch.aoc2022;

public record RockPaperScissorsGame(GameMove a, GameMove b) {
  public long score() {
    return b.getValue() + this.getValue();
  }

  public long getValue() {
    if (a.equals(b)) {
      return 3;
    }
    if (a.equals(GameMove.Rock) && b.equals(GameMove.Paper)) {
      return 6;
    }
    if (a.equals(GameMove.Paper) && b.equals(GameMove.Scissors)) {
      return 6;
    }
    if (a.equals(GameMove.Scissors) && b.equals(GameMove.Rock)) {
      return 6;
    }
    return 0;
  }
}
