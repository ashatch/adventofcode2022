package net.andrewhatch.aoc2022;

public record Assignment(long start, long end) {
  public boolean fullyOverlaps(Assignment other) {
    return this.start <= other.start && this.end >= other.end;
  }

  public boolean overlaps(Assignment other) {
    return other.end >= this.start && other.start <= this.end;
  }
}
