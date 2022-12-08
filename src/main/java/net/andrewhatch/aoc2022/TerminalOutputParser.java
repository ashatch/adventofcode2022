package net.andrewhatch.aoc2022;

import java.util.List;

public class TerminalOutputParser {
  private DirectoryNode root = new DirectoryNode("/", null);
  private DirectoryNode currentDirectory;
  private enum Mode {
    LISTING,
    WAITING_COMMAND
  }

  private Mode currentMode = Mode.WAITING_COMMAND;

  public DirectoryNode parse(List<String> lines) {
    lines.forEach(this::processLine);
    return this.root;
  }

  private void processLine(String line) {
    if (line.startsWith("$ cd ")) {
      String operand = line.split(" ")[2];
      if ("/".equals(operand)) {
        currentDirectory = root;
      } else if ("..".equals(operand)) {
        this.currentDirectory = currentDirectory.getParent();
      } else {
        this.currentDirectory = currentDirectory.getDir(operand);
      }
    } else if (line.startsWith("$ ls")) {
    } else {
      if (line.startsWith("dir ")) {
        String name = line.split(" ")[1];
        this.currentDirectory.addDirectory(name);
      } else {
        String[] parts = line.split(" ");
        long size = Long.parseLong(parts[0]);
        String name = parts[1];
        this.currentDirectory.addFile(new FileNode(name, size));
      }
    }
  }
}
