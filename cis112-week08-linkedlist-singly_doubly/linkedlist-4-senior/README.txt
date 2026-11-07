Linked Lists -- Senior Level
============================
Twenty-five slides.  javap on LinkedList and ArrayList, why
sentinel nodes, Morris traversal in O(1) space, memory layout,
SequencedCollection, ConcurrentLinkedDeque, functional lists.

The two javap snapshots are captured on JDK 17+ and committed as
text; the class shape (first, last, size, modCount on LinkedList;
elementData, size on ArrayList) is stable.  Re-capture with
`javap -p java.util.LinkedList` if you upgrade.

Build:  pdflatex linkedlist-4-senior.tex   (twice)