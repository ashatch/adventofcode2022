package net.andrewhatch.aoc2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class InputReader {
  public static List<String> readPuzzleInput() {
    try (final InputStream resource = InputReader.class.getResourceAsStream("/input.txt")) {
      return new BufferedReader(new InputStreamReader(resource, StandardCharsets.UTF_8))
          .lines()
          .collect(Collectors.toList());

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
