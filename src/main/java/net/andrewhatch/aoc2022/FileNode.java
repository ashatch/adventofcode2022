package net.andrewhatch.aoc2022;

import java.util.Collections;
import java.util.List;

public class FileNode implements FilesystemNode {
  private final long size;
  private final String name;

  public FileNode(String name, long size) {
    this.name = name;
    this.size = size;
  }

  public String getName() {
    return this.name;
  }

  @Override
  public List<FilesystemNode> getChildren() {
    return Collections.emptyList();
  }

  @Override
  public long getSize() {
    return size;
  }

  @Override
  public String toString() {
    return "FileNode{" +
        "size=" + size +
        ", name='" + name + '\'' +
        '}';
  }
}
