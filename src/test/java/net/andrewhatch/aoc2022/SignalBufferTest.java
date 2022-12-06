package net.andrewhatch.aoc2022;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SignalBufferTest {
  @Test
  void signalBufferTest() {
    final SignalBuffer<String> buf = new SignalBuffer<>(4);
    buf.add("a");
    assertThat(buf.data()).isEqualTo(List.of("a"));
    buf.add("b");
    assertThat(buf.data()).isEqualTo(List.of("a", "b"));
    buf.add("c");
    assertThat(buf.data()).isEqualTo(List.of("a", "b", "c"));
    buf.add("d");
    assertThat(buf.data()).isEqualTo(List.of("a", "b", "c", "d"));
    buf.add("e");
    assertThat(buf.data()).isEqualTo(List.of("b", "c", "d", "e"));
  }
}
