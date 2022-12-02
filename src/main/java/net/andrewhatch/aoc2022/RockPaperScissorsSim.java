package net.andrewhatch.aoc2022;

import java.util.List;

public class RockPaperScissorsSim {
  public long score(List<String> lines) {
    return lines.stream()
        .map(this::game)
        .map(RockPaperScissorsGame::score)
        .reduce(0L, Long::sum);
  }

  public RockPaperScissorsGame game(final String line) {
    final String[] parts = line.split(" ");
    return new RockPaperScissorsGame(gameMove(parts[0].trim()), gameMove(parts[1].trim()));
  }

  public GameMove gameMove(final String str) {
    switch(str) {
      case "A":
      case "X": {
        return GameMove.Rock;
      }
      case "B":
      case "Y": {
        return GameMove.Paper;
      }
      case "C":
      case "Z": {
        return GameMove.Scissors;
      }
    }
    return null;
  }
}
