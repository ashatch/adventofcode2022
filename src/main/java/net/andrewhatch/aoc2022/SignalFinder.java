package net.andrewhatch.aoc2022;

import java.util.HashSet;
import java.util.List;

public class SignalFinder {

  public long findStartOfMessage(String data) {
    return find(data, 14);
  }

  public long findStartOfPacket(String data) {
    return find(data, 4);
  }

  public long find(String data, int bufferSize) {
    final SignalBuffer<Character> signalBuffer = new SignalBuffer<>(bufferSize);
    char[] charArray = data.toCharArray();
    for (int i = 0; i < charArray.length; i++) {
      final char c = charArray[i];
      signalBuffer.add(c);
      if (allDifferent(signalBuffer.data(), bufferSize)) {
        return i + 1;
      }
    }
    return 0L;
  }

  private boolean allDifferent(List<Character> data, int minimum) {
    if (data.size() < minimum) {
      return false;
    }
    return new HashSet<>(data).size() == data.size();
  }
}
