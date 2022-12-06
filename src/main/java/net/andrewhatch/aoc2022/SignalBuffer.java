package net.andrewhatch.aoc2022;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SignalBuffer<T> {
  private final ArrayList<T> data;
  private final int bufferSize;

  public SignalBuffer(int bufferSize) {
    this.bufferSize = bufferSize;
    this.data = new ArrayList<T>();
  }

  public void add(final T item) {
    data.add(item);
    if (data.size() > bufferSize) {
      data.remove(0);
    }
  }

  public List<T> data() {
    return Collections.unmodifiableList(data);
  }
}
