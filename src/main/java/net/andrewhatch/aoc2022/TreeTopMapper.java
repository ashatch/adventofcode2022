package net.andrewhatch.aoc2022;

import java.util.List;

public class TreeTopMapper {

  public long maxScenicMeasure(List<List<Integer>> map) {
    int height = map.size();
    int width = map.get(0).size();

    long maxScenicMeasure = 0;
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        long measure = scenicMeasure(map, x, y);
        if (measure > maxScenicMeasure) {
          maxScenicMeasure = measure;
        }
      }
    }
    return maxScenicMeasure;
  }

  public long scenicMeasure(List<List<Integer>> map, int x, int y) {
    long lookingUp = measureLookingUp(map, x, y);
    long lookingDown = measureLookingDown(map, x, y);
    long lookingRight = measureLookingRight(map, x, y);
    long lookingLeft = measureLookingLeft(map, x, y);

    return lookingUp * lookingDown * lookingLeft * lookingRight;
  }

  public long measureLookingUp(List<List<Integer>> map, int x, int y) {
    long treeHeight = map.get(y).get(x);
    long measureFromTop = 0L;
    for (int i = y - 1; i >= 0; i--) {
      if (map.get(i).get(x) < treeHeight) {
        measureFromTop++;
      } else {
        return measureFromTop + 1;
      }
    }
    return measureFromTop;
  }

  public long measureLookingDown(List<List<Integer>> map, int x, int y) {
    int height = map.size();
    long treeHeight = map.get(y).get(x);

    long measureFromBottom = 0L;
    for (int i = y + 1; i < height; i++) {
      if (map.get(i).get(x) < treeHeight) {
        measureFromBottom++;
      } else {
        return measureFromBottom + 1;
      }
    }

    return measureFromBottom;
  }

  public long measureLookingRight(List<List<Integer>> map, int x, int y) {
    int width = map.get(0).size();
    long treeHeight = map.get(y).get(x);
    long measureToRight = 0L;
    for (int i = x + 1; i < width; i++) {
      if (map.get(y).get(i) < treeHeight) {
        measureToRight++;
      } else {
        return measureToRight + 1;
      }
    }
    return measureToRight;
  }

  public long measureLookingLeft(List<List<Integer>> map, int x, int y) {
    long treeHeight = map.get(y).get(x);
    long measureToLeft = 0L;
    for (int i = x - 1; i >= 0; i--) {
      if (map.get(y).get(i) < treeHeight) {
        measureToLeft++;
      } else {
        return measureToLeft + 1;
      }
    }
    return measureToLeft;
  }

  public long visibilityCount(List<List<Integer>> map) {
    int height = map.size();
    int width = map.get(0).size();

    long visibilityCount = 0;
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        if (treeIsVisibleAt(map, x, y)) {
          visibilityCount++;
        }
      }
    }

    return visibilityCount;
  }

  public boolean treeIsVisibleAt(List<List<Integer>> map, int x, int y) {
    int height = map.size();
    int width = map.get(0).size();

    if (x == 0 || y == 0 || x == width - 1 || y == height - 1) {
      return true;
    }

    long treeHeight = map.get(y).get(x);

    boolean visibleToRight = true;
    for (int i = x + 1; i < width; i++) {
      if (map.get(y).get(i) > treeHeight - 1) {
        visibleToRight = false;
      }
    }
    boolean visibleToLeft = true;
    for (int i = x - 1; i >= 0; i--) {
      if (map.get(y).get(i) > treeHeight - 1) {
        visibleToLeft = false;
      }
    }
    boolean visibleFromBottom = true;
    for (int i = y + 1; i < height; i++) {
      if (map.get(i).get(x) > treeHeight - 1) {
        visibleFromBottom = false;
      }
    }
    boolean visibleFromTop = true;
    for (int i = y - 1; i >= 0; i--) {
      if (map.get(i).get(x) > treeHeight - 1) {
        visibleFromTop = false;
      }
    }

    return visibleToLeft || visibleToRight || visibleFromTop || visibleFromBottom;
  }
}
