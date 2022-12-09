package net.andrewhatch.aoc2022;

import java.util.*;

public class RopeSim {
  long positionCount = 0;
  Position headPosition = new Position(0, 0);
  Position tailPosition = new Position(0, 0);

  private Map<Integer, Set<Integer>> visitedPlaces = new HashMap<>();

  public RopeSim() {
    addPlaceVisited(headPosition);
  }

  private void addPlaceVisited(Position position) {
    visitedPlaces.putIfAbsent(position.getY(), new HashSet<>());
    visitedPlaces.get(position.getY()).add(position.getX());
  }

  public long visitedPlacesCount() {
    return visitedPlaces.keySet()
        .stream()
        .map(visitedPlaces::get)
        .map(x -> (long) x.size())
        .reduce(0L, Long::sum);
  }

  public void step(List<Movement> movements) {
    movements.forEach(this::step);
  }

  public void step(Movement movement) {
    for (int i = 0; i < movement.steps(); i++) {
      switch (movement.direction()) {
        case U -> headPosition.incY();
        case D -> headPosition.decY();
        case L -> headPosition.decX();
        case R -> headPosition.incX();
      }
      updateTailPosition();
    }
  }

  private void checkRight() {
    if (headPosition.getX() > tailPosition.getX() && headPosition.getX() - tailPosition.getX() > 1) {
      tailPosition.incX();
      if (headPosition.getY() != tailPosition.getY()) {
        tailPosition.setY(headPosition.getY());
      }
      addPlaceVisited(tailPosition);
    }
  }
  private void checkLeft() {
    if (headPosition.getX() < tailPosition.getX() && tailPosition.getX() - headPosition.getX() > 1) {
      tailPosition.decX();
      if (headPosition.getY() != tailPosition.getY()) {
        tailPosition.setY(headPosition.getY());
      }
      addPlaceVisited(tailPosition);
    }
  }

  private void checkUp() {
    if (headPosition.getY() > tailPosition.getY() && headPosition.getY() - tailPosition.getY() > 1) {
      tailPosition.incY();
      if (headPosition.getX() != tailPosition.getX()) {
        tailPosition.setX(headPosition.getX());
      }
      addPlaceVisited(tailPosition);
    }
  }

  private void checkDown() {
    if (headPosition.getY() < tailPosition.getY() && tailPosition.getY() - headPosition.getY() > 1) {
      tailPosition.decY();
      if (headPosition.getX() != tailPosition.getX()) {
        tailPosition.setX(headPosition.getX());
      }
      addPlaceVisited(tailPosition);
    }
  }

  private void updateTailPosition() {
    checkLeft();
    checkRight();
    checkUp();
    checkDown();
  }

  public Position getHeadPosition() {
    return headPosition;
  }

  public Position getTailPosition() {
    return tailPosition;
  }
}
