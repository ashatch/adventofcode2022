package net.andrewhatch.aoc2022;

import com.google.common.graph.Traverser;

import java.util.*;
import java.util.stream.StreamSupport;

public class DirectoryNode implements FilesystemNode {
  private final String name;
  private final Map<String, DirectoryNode> directories = new HashMap<>();
  private final Map<String, FileNode> files = new HashMap<>();
  private final DirectoryNode parent;

  public DirectoryNode(final String name, final DirectoryNode parent) {
    this.name = name;
    this.parent = parent;
  }

  public void addDirectory(final String name) {
    if (!directories.containsKey(name)) {
      directories.put(name, new DirectoryNode(name, this));
    }
  }

  public DirectoryNode getDir(final String name) {
    return this.directories.get(name);
  }

  public void addFile(FileNode fileNode) {
    this.files.putIfAbsent(fileNode.getName(), fileNode);
  }

  public DirectoryNode getParent() {
    return this.parent;
  }

  @Override
  public List<FilesystemNode> getChildren() {
    final List<FilesystemNode> children = new ArrayList<>();
    children.addAll(directories.values());
    children.addAll(files.values());
    return children;
  }

  @Override
  public String toString() {
    return "DirectoryNode{" +
        "name='" + name + '\'' +
        '}';
  }

  @Override
  public long getSize() {
    long fileSizes = this.files.values().stream().map(FileNode::getSize).reduce(0L, Long::sum);
    long directorySizes = this.directories.values().stream().map(DirectoryNode::getSize).reduce(0L, Long::sum);
    return fileSizes + directorySizes;
  }
}
