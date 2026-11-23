Generic Stack and Queue in Arrays -- six Beamer decks
=====================================================

generic-0-concepts    generic-stack-queue-concepts.tex   ADT recap (Set, Stack, Queue), generic types,
                                                         circular array for stack and queue, LIFO vs FIFO
                                                         vs membership, cost of operations, applications,
                                                         the Java API classes (HashSet, ArrayDeque, Stack,
                                                         LinkedList, PriorityQueue)
generic-1-freshman    generic-stack-queue-freshman.tex   install, IntStack and IntQueue step by step on a
                                                         circular array, tracing on paper, an interactive
                                                         stack/queue calculator, five common mistakes with
                                                         their real error messages, compiler errors
generic-2-sophomore   generic-stack-queue-sophomore.tex  interface StackADT<T>, QueueADT<T>, SetADT<T> +
                                                         generic ArrayStack<T>, ArrayQueue<T>, ArraySet<T>,
                                                         iterator, generic arrays, growing/shrinking,
                                                         loitering, tests (and JUnit), Deque methods,
                                                         java.util.Stack vs ArrayDeque
generic-3-junior      generic-stack-queue-junior.tex     linked vs array-backed, boxing, a benchmark, bytes
                                                         per element, cache locality, copies and the
                                                         potential method, when to pick Set vs Stack vs
                                                         Queue, BFS/DFS, expression evaluation, undo,
                                                         producer/consumer, deduplication pipelines
generic-4-senior      generic-stack-queue-senior.tex     ArrayDeque internals (javap), power-of-two
                                                         arithmetic, ring buffers, HashSet/TreeSet
                                                         internals (HashMap, red-black tree), legacy
                                                         java.util.Stack, SequencedCollection, memory
                                                         ordering, lock-free queues/stacks, API lessons
generic-5-examples    generic-stack-queue-examples.tex   real programs: IntStack, IntQueue,
                                                         ArrayStack<T>, ArrayQueue<T>, ArraySet<T>,
                                                         remove duplicates, common elements, reverse a
                                                         string, queue from two stacks, bracket matcher,
                                                         RPN calculator, undo, BFS, printer simulation,
                                                         ArrayDeque, PriorityQueue

hblib/ is shared: ../../hblib/hblibPresentation.sty, hblibCodeoutput.sty,
hblibDatastructures.sty.  The stack/queue decks use
\hStack{...}{...}{top}{elements}{...}{...} and
\hQueueArray{capacity}{head}{tail}{size}{elements}
from hblibDatastructures.sty: \hQueueArray draws the queue in the circular
array in QUEUE order, so a wrapped queue is shown correctly (the older
\hQueue draws elements from index 0 only).  The set decks use plain
\{...\} notation in text, not a picture.

Building a deck (Windows: Command Prompt; macOS: Terminal)
---------------------------------------------------------
  cd generic-0-concepts
  pdflatex generic-stack-queue-concepts.tex       (twice, for i/N and the outline)
  pdflatex generic-stack-queue-concepts.tex

Same pattern for the other five directories, substituting the file name.

The decks follow the ordering of the CIS112 PPTX
"Generic: Stack and Queue" (v2025-03-22):
   1  Introduction                 ADTs and generic types
   2  Set in Java API              HashSet / TreeSet / LinkedHashSet, key methods
   3  Stack in Java API            java.util.Stack (push/pop/peek/isEmpty)
   4  Queue in Java API            Queue interface, ArrayDeque / LinkedList,
                                   add/offer, remove/poll, element/peek
   5  Exercises                    remove duplicates, common elements,
                                   reverse a string, queue from two stacks
   6  References                   Oracle, GeeksforGeeks, Bloch, Schildt

The six decks cover that outline at six depths.  The concepts deck is the
closest to the PPTX itself; the freshman and sophomore decks turn the API
calls into array-based implementations (that is the "in arrays" part of the
suite title); the junior, senior and examples decks widen the topic.

Programs and their outputs
--------------------------
Every output on the slides is REAL (JDK 24 in this build):
  codeoutput/<Name>.java     a program; classes without main() (IntStack,
                             IntQueue, ArrayStack, ArrayQueue, ArraySet,
                             StackADT, QueueADT, SetADT, ...) are only compiled
  codeoutput/<Name>.in       its keyboard input, .args its arguments,
                             .jvmargs its JVM options
  codeoutput/<Name>.sh       a terminal session, run in a copy of
                             codeoutput/<Name>/
  codeoutput/<Name>.txt      what it printed, regenerated by:
                             bash run_examples.sh  [Name.java]
                             (macOS: Terminal; Windows: Git Bash)

The set/stack/queue programs that print a HashSet or an ArrayDeque are
run once per build.  HashSet order is NOT printed as a guarantee: the
slides say "in some order" and use LinkedHashSet where a fixed order is
needed in the output.  ArrayDeque prints from the front, so those outputs
are stable.

Timings (the benchmark in the junior deck), the number of arrays before
OutOfMemoryError, and the BFS times change from run to run.  The slides
only claim what held in every run; the junior deck says "one run on this
machine" where it shows a table of times.  JUnit and JMH listings are
marked "Not run here".

The four exercises of the PPTX (remove duplicates, common elements,
reverse a string, queue from two stacks) appear as full programs in
generic-5-examples, with their real outputs, and as short listings in
generic-1-freshman and generic-2-sophomore.
