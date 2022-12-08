package net.andrewhatch.aoc2022;

import com.google.common.graph.Traverser;

import java.util.stream.StreamSupport;

public class DirFinder {

  public long findDirectoryToDelete(final DirectoryNode filesystemRoot) {
    long fileSystemSize = 70000000;
    long requiredUnused = 30000000;
    long usedSpace = filesystemRoot.getSize();

    long remainingSpace = fileSystemSize - usedSpace;
    long amountToDelete = requiredUnused - remainingSpace;

    return this.smallestOfMatchingSize(filesystemRoot, amountToDelete);
  }

  public long smallestOfMatchingSize(DirectoryNode from, long atLeast) {
    final Iterable<FilesystemNode> iterable = Traverser.forTree(FilesystemNode::getChildren)
        .depthFirstPreOrder(from);

    return StreamSupport.stream(iterable.spliterator(), false)
        .filter(node -> node instanceof DirectoryNode)
        .map(node -> (DirectoryNode) node)
        .filter(dir -> dir.getSize() > atLeast)
        .map(DirectoryNode::getSize)
        .sorted()
        .findFirst()
        .orElseThrow(() -> new RuntimeException("No such dir"));
  }

  public long sumOfMatchingSizes(DirectoryNode from, long atMost) {
    final Iterable<FilesystemNode> iterable = Traverser.forTree(FilesystemNode::getChildren)
        .depthFirstPreOrder(from);

    return StreamSupport.stream(iterable.spliterator(), false)
        .filter(node -> node instanceof DirectoryNode)
        .map(node -> (DirectoryNode) node)
        .filter(dir -> dir.getSize() < atMost)
        .map(DirectoryNode::getSize)
        .reduce(0L, Long::sum);
  }
  public long sumOfMatchingSizes(DirectoryNode from) {
    return this.sumOfMatchingSizes(from, 100000);
  }
}
