package net.andrewhatch.aoc2022;

public record AssignmentPair(Assignment first, Assignment second) {
  public boolean fullyOverlaps() {
    return first.fullyOverlaps(second) || second.fullyOverlaps(first);
  }

  public boolean overlaps() {
    return first.overlaps(second) || second.overlaps(first);
  }
}
