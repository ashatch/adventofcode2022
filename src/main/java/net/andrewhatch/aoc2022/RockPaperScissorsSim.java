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
    final GameMove opponentMove = gameMove(parts[0].trim());
    final GameState gameState = gameState(parts[1].trim());
    final GameMove myMove = whatsMyMove(opponentMove, gameState);
    return new RockPaperScissorsGame(opponentMove, myMove);
  }

  private GameMove whatsMyMove(
      final GameMove opponentMove,
      final GameState gameState
  ) {
    return switch (gameState) {
      case Draw -> opponentMove.drawAgainst();
      case Win -> opponentMove.winAgainst();
      case Lose -> opponentMove.loseAgainst();
    };
  }

  public GameMove gameMove(final String str) {
    return switch (str) {
      case "A" -> GameMove.Rock;
      case "B" -> GameMove.Paper;
      case "C" -> GameMove.Scissors;
      default -> null;
    };
  }

  public GameState gameState(final String str) {
    return switch (str) {
      case "Y" -> GameState.Draw;
      case "Z" -> GameState.Win;
      default -> GameState.Lose;
    };
  }
}
