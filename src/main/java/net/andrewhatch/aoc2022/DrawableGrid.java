package net.andrewhatch.aoc2022;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class DrawableGrid {

  final Map<Integer, Map<Integer, Character>> grid = new HashMap();
  private int minY;
  private int minX;
  private final char background;

  public DrawableGrid(int minY, int minX, char background) {
    this.minY = minY;
    this.minX = minX;
    this.background = background;
  }

  public void put(char c, int x, int y) {
    grid.putIfAbsent(y, new HashMap<>());
    Map<Integer, Character> xRow = grid.get(y);
    xRow.put(x, c);
  }

  public String toString() {
    int top = grid.keySet().stream()
        .min(Comparator.naturalOrder())
        .orElse(0);

    int bottom = grid.keySet().stream()
        .max(Comparator.naturalOrder())
        .orElse(0);

    int left = grid.keySet()
        .stream().map(y -> grid.get(y).keySet().stream().min(Comparator.naturalOrder()).orElse(0))
        .min(Comparator.naturalOrder())
        .orElse(0);

    int right = grid.keySet()
        .stream().map(y -> grid.get(y).keySet().stream().max(Comparator.naturalOrder()).orElse(0))
        .max(Comparator.naturalOrder())
        .orElse(0);

    if (minY < top) {
      top = minY;
    }

    if (minX < left) {
      left = minX;
    }

    final StringBuilder sb = new StringBuilder();
    for (int y = bottom; y >= top; y--) {
      Map<Integer, Character> row = grid.getOrDefault(y, new HashMap<>());
      StringBuilder rowChars = new StringBuilder();
      for (int i = left; i <= right; i++) {
        Character character = row.get(i);
        if (character == null) {
          rowChars.append(background);
        } else {
          rowChars.append(character);
        }
      }
      sb.append(rowChars);
      sb.append("\n");
    }

    return sb.toString();
  }

  public static void main(String[] arg) {
    DrawableGrid drawableGrid = new DrawableGrid(-3, -5, '.');
    drawableGrid.put('*', -1, -1);
    drawableGrid.put('*', 5, 3);
    System.out.println(drawableGrid);
  }
}
