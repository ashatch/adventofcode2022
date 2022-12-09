package net.andrewhatch.aoc2022;

import java.util.*;
import java.util.stream.IntStream;

public class RopeSim {
  private final Position headPosition;
  private final Position tailPosition;
  private final List<Position> knots = new ArrayList<>();

  private final Map<Integer, Set<Integer>> visitedPlaces = new HashMap<>();

  public RopeSim() {
    IntStream.range(0, 10).forEach((it) -> knots.add(new Position(0, 0)));
    headPosition = knots.get(0);
    tailPosition = knots.get(knots.size() - 1);
    addPlaceVisited(tailPosition);
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

  public void step(final List<Movement> movements) {
    movements.forEach(this::step);
  }

  public void step(final Movement movement) {
    for (int i = 0; i < movement.steps(); i++) {
      moveHead(movement);
      for (int x = 0; x < knots.size() - 1; x++) {
        Position nextKnot = knots.get(x + 1);
        updatePosition(knots.get(x), nextKnot);
      }
    }
  }

  private void moveHead(final Movement movement) {
      switch (movement.direction()) {
        case U -> headPosition.incY();
        case D -> headPosition.decY();
        case L -> headPosition.decX();
        case R -> headPosition.incX();
      }
  }

  private void checkRight(Position from, Position to) {
    if (from.getX() > to.getX() && from.getX() - to.getX() > 1) {
      to.incX();
      if (to.getY() < from.getY()) {
        to.incY();
      } else if (to.getY() > from.getY()) {
        to.decY();
      }
      if (to == tailPosition) {
        addPlaceVisited(to);
      }
    }
  }

  private void checkLeft(Position from, Position to) {
    if (from.getX() < to.getX() && to.getX() - from.getX() > 1) {
      to.decX();
      if (to.getY() < from.getY()) {
        to.incY();
      } else if (to.getY() > from.getY()) {
        to.decY();
      }
      if (to == tailPosition) {
        addPlaceVisited(to);
      }
    }
  }

  private void checkUp(Position from, Position to) {
    if (from.getY() > to.getY() && from.getY() - to.getY() > 1) {
      to.incY();
      if (to.getX() < from.getX()) {
        to.incX();
      } else if (to.getX() > from.getX()) {
        to.decX();
      }
      if (to == tailPosition) {
        addPlaceVisited(to);
      }
    }
  }

  private void checkDown(Position from, Position to) {
    if (from.getY() < to.getY() && to.getY() - from.getY() > 1) {
      to.decY();
      if (to.getX() < from.getX()) {
        to.incX();
      } else if (to.getX() > from.getX()) {
        to.decX();
      }
      if (to == tailPosition) {
        addPlaceVisited(to);
      }
    }
  }

  private void updatePosition(Position from, Position to) {
    checkLeft(from, to);
    checkRight(from, to);
    checkUp(from, to);
    checkDown(from, to);
  }

  public String toString() {
    final DrawableGrid grid = new DrawableGrid(0, -5, '.');
    for (int i = knots.size() - 1; i >= 0; i--) {
      char label = i == 0 ? 'H' : ("" + i).charAt(0);
      grid.put(label, knots.get(i).getX(), knots.get(i).getY());
    }
    return grid.toString();
  }
}
