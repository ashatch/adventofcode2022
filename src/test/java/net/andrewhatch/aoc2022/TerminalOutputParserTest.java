package net.andrewhatch.aoc2022;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TerminalOutputParserTest {
  @Test
  void partOneExampleTest() {
    final List<String> terminalOutput = List.of(
        "$ cd /",
        "$ ls",
        "dir a",
        "14848514 b.txt",
        "8504156 c.dat",
        "dir d",
        "$ cd a",
        "$ ls",
        "dir e",
        "29116 f",
        "2557 g",
        "62596 h.lst",
        "$ cd e",
        "$ ls",
        "584 i",
        "$ cd ..",
        "$ cd ..",
        "$ cd d",
        "$ ls",
        "4060174 j",
        "8033020 d.log",
        "5626152 d.ext",
        "7214296 k"
    );
    final DirectoryNode filesystemRoot = new TerminalOutputParser()
        .parse(terminalOutput);

    long sum = new DirFinder().sumOfMatchingSizes(filesystemRoot);

    assertThat(sum).isEqualTo(95437L);
  }

  @Test
  void partOnePuzzleTest() {
    final DirectoryNode filesystemRoot = new TerminalOutputParser()
        .parse(InputReader.readPuzzleInput());

    long sum = new DirFinder().sumOfMatchingSizes(filesystemRoot);

    assertThat(sum).isEqualTo(1390824L);
  }

  @Test
  void partTwoSampleTest() {
    final List<String> terminalOutput = List.of(
        "$ cd /",
        "$ ls",
        "dir a",
        "14848514 b.txt",
        "8504156 c.dat",
        "dir d",
        "$ cd a",
        "$ ls",
        "dir e",
        "29116 f",
        "2557 g",
        "62596 h.lst",
        "$ cd e",
        "$ ls",
        "584 i",
        "$ cd ..",
        "$ cd ..",
        "$ cd d",
        "$ ls",
        "4060174 j",
        "8033020 d.log",
        "5626152 d.ext",
        "7214296 k"
    );
    final DirectoryNode filesystemRoot = new TerminalOutputParser()
        .parse(terminalOutput);


    long it = new DirFinder().findDirectoryToDelete(filesystemRoot);

    assertThat(it).isEqualTo(24933642L);
  }

  @Test
  void partTwoInputTest() {
    final DirectoryNode filesystemRoot = new TerminalOutputParser()
        .parse(InputReader.readPuzzleInput());


    long it = new DirFinder().findDirectoryToDelete(filesystemRoot);

    assertThat(it).isEqualTo(7490863L);
  }


}