package net.andrewhatch.aoc2022;

import java.util.List;

public interface FilesystemNode {
  List<FilesystemNode> getChildren();
  long getSize();
}
