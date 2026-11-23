#!/usr/bin/env bash
set -euo pipefail

ROOT="."

# =====================================================================
# 0. CONCEPTS
# =====================================================================
mkdir -p "$ROOT/linkedstackqueue-0-concepts/codeoutput"
cd "$ROOT/linkedstackqueue-0-concepts"

cat > README.txt <<'EOF'
Linked Stack, Queue, and Deque -- The Concepts
20 slides. Nodes vs arrays, LIFO, FIFO, double-ended queues, 
the Java API (Deque, ArrayDeque, LinkedList).
EOF

cat > concepts.tex <<'TEX_EOF'
% !TEX spellcheck = en_US
\documentclass[aspectratio=169,10pt,compress]{beamer}
\usepackage{../../hblib/hblibPresentation}
\usepackage{../../hblib/hblibCodeoutput}
\usepackage{../../hblib/hblibDatastructures}
\usepackage[T1]{fontenc}
\usepackage{lmodern}
\usepackage{booktabs}

\lstset{columns=fixed, breaklines=true, breakatwhitespace=false}

\title{Linked Stacks, Queues, and Deques}
\subtitle{The Concepts}
\author[Bingol]{Ruhan Alpaydin}
\institute[FCIS]{Faculty of Computer and Information Sciences\\Yeditepe University}
\date{{\tiny \hbTimeStamp}}

\begin{document}

\begin{frame}[t,fragile]\titlepage\end{frame}

\begin{frame}[t,fragile]\frametitle{Outline}
  \begin{columns}[T]
    \begin{column}{0.48\textwidth}\tableofcontents[sections={1-3},hideallsubsections]\end{column}
    \begin{column}{0.48\textwidth}\tableofcontents[sections={4-5},hideallsubsections]\end{column}
  \end{columns}
\end{frame}

\hSection[Nodes]{Nodes vs Arrays}
\begin{frame}[t,fragile]\frametitle{Two ways to build a container}
  \begin{columns}[T]
    \begin{column}{0.48\textwidth}
      \begin{block}{Array-backed}
        \small
        Elements in one contiguous block.\\
        Fast random access: $O(1)$.\\
        Insert/delete at ends can require shifting or resizing.
      \end{block}
    \end{column}
    \begin{column}{0.48\textwidth}
      \begin{block}{Node-backed (Linked)}
        \small
        Each element in its own node with a reference.\\
        Random access is $O(n)$ (walk).\\
        Insert/delete at known ends is always $O(1)$.
      \end{block}
    \end{column}
  \end{columns}
  \vspace{0.4em}
  \small
  \hRemark{We trade random access for guaranteed $O(1)$ end-operations.}
\end{frame}

\begin{frame}[t,fragile]\frametitle{The three ADTs}
  \begin{center}\small
  \begin{tabular}{@{}lll@{}}
    \toprule
    \textbf{ADT} & \textbf{Rule} & \textbf{Core Operations} \\
    \midrule
    Stack & LIFO (Last In, First Out) & \hCode{push}, \hCode{pop} \\
    Queue & FIFO (First In, First Out) & \hCode{enqueue}, \hCode{dequeue} \\
    Deque & Double-Ended Queue & \hCode{addFirst}, \hCode{addLast}, \hCode{removeFirst}, \hCode{removeLast} \\
    \bottomrule
  \end{tabular}
  \end{center}
\end{frame}

\hSection[Stack]{The Linked Stack}
\begin{frame}[t,fragile]\frametitle{Stack: LIFO}
  \begin{columns}[T]
    \begin{column}{0.48\textwidth}
      \begin{itemize}\small
        \item \hCode{push(x)}: add a new node at the \textbf{top}.
        \item \hCode{pop()}: remove the top node.
        \item Always $O(1)$, no resizing.
      \end{itemize}
    \end{column}
    \begin{column}{0.48\textwidth}
      \begin{center}
      \begin{tikzpicture}[arr/.style={-{Latex[length=2mm]}, thick}]
        \node at (-1,0) {\hCode{top}};
        \node[draw, minimum width=1.5cm, minimum height=0.6cm] (a) at (0.5,0) {10};
        \node[draw, minimum width=1.5cm, minimum height=0.6cm] (b) at (2.5,0) {20};
        \node at (4.0,0) {\hCode{null}};
        \draw[arr] (-0.3,0) -- (a.west);
        \draw[arr] (a.east) -- (b.west);
        \draw[arr] (b.east) -- (3.8,0);
      \end{tikzpicture}
      \end{center}
      \small \hCode{pop} returns \textbf{10}.
    \end{column}
  \end{columns}
\end{frame}

\hSection[Queue]{The Linked Queue}
\begin{frame}[t,fragile]\frametitle{Queue: FIFO}
  \begin{columns}[T]
    \begin{column}{0.48\textwidth}
      \begin{itemize}\small
        \item \hCode{enqueue(x)}: add a new node at the \textbf{tail}.
        \item \hCode{dequeue()}: remove the \textbf{head} node.
        \item Always $O(1)$, provided we keep a \hCode{tail} reference.
      \end{itemize}
    \end{column}
    \begin{column}{0.48\textwidth}
      \begin{center}
      \begin{tikzpicture}[arr/.style={-{Latex[length=2mm]}, thick}]
        \node at (-1,0) {\hCode{head}};
        \node[draw, minimum width=1.5cm, minimum height=0.6cm] (a) at (0.5,0) {10};
        \node[draw, minimum width=1.5cm, minimum height=0.6cm] (b) at (2.5,0) {20};
        \node at (4.0,0) {\hCode{null}};
        \node at (2.5,-1) {\hCode{tail}};
        \draw[arr] (-0.3,0) -- (a.west);
        \draw[arr] (a.east) -- (b.west);
        \draw[arr] (b.east) -- (3.8,0);
        \draw[arr] (2.5,-0.8) -- (b.south);
      \end{tikzpicture}
      \end{center}
      \small \hCode{dequeue} returns \textbf{10}.
    \end{column}
  \end{columns}
\end{frame}

\hSection[Deque]{The Linked Deque}
\begin{frame}[t,fragile]\frametitle{Deque: double-ended}
  \begin{columns}[T]
    \begin{column}{0.48\textwidth}
      \begin{itemize}\small
        \item \hCode{addFirst(x)}, \hCode{addLast(x)}.
        \item \hCode{removeFirst()}, \hCode{removeLast()}.
        \item To do \hCode{removeLast()} in $O(1)$, the nodes must be
              \textbf{doubly linked} (each node needs a \hCode{prev}).
      \end{itemize}
    \end{column}
    \begin{column}{0.48\textwidth}
      \begin{center}
      \begin{tikzpicture}[arr/.style={-{Latex[length=2mm]}, thick}]
        \node at (-1,0) {\hCode{head}};
        \node[draw, minimum width=1.5cm, minimum height=0.6cm] (a) at (0.5,0) {10};
        \node[draw, minimum width=1.5cm, minimum height=0.6cm] (b) at (2.5,0) {20};
        \node at (4.0,0) {\hCode{null}};
        \node at (2.5,-1) {\hCode{tail}};
        \draw[arr] (-0.3,0) -- (a.west);
        \draw[arr] (a.east) -- (b.west);
        \draw[arr] (b.east) -- (3.8,0);
        \draw[arr] (2.5,-0.8) -- (b.south);
        % prev arrows
        \draw[arr] (b.south west) -- (a.south east);
      \end{tikzpicture}
      \end{center}
      \small \hCode{removeLast} returns \textbf{20}.
    \end{column}
  \end{columns}
\end{frame}

\hSection[API]{The Java API}
\begin{frame}[t,fragile]\frametitle{The Java API}
  \begin{center}\small
  \begin{tabular}{@{}lll@{}}
    \toprule
    \textbf{Interface} & \textbf{Implements} & \textbf{Note} \\
    \midrule
    \hCode{Deque<E>} & \hCode{ArrayDeque}, \hCode{LinkedList} & Covers Stack and Queue \\
    \hCode{Queue<E>} & \hCode{LinkedList}, \hCode{ArrayDeque} & FIFO operations \\
    \emph{(none)} & \hCode{java.util.Stack} & Legacy, avoid it \\
    \bottomrule
  \end{tabular}
  \end{center}
  \vspace{0.3em}
  \begin{itemize}\small
    \item \hCode{ArrayDeque} is the modern default: fast, memory-efficient.
    \item \hCode{LinkedList} is a doubly linked list. Use it when you
          specifically want a linked structure or also need \hCode{List}.
  \end{itemize}
\end{frame}

\begin{frame}[t,fragile]
  \begin{center}\vspace{4cm}\hRemark{\Huge Questions?}\end{center}
\end{frame}

\end{document}
TEX_EOF
cd ../..

# =====================================================================
# 1. FRESHMAN
# =====================================================================
mkdir -p "$ROOT/linkedstackqueue-1-freshman/codeoutput"
cd "$ROOT/linkedstackqueue-1-freshman/codeoutput"

cat > Node.java <<'EOF'
public class Node {
    int data;
    Node next;
    Node(int data) { this.data = data; }
}
EOF

cat > LinkedStack.java <<'EOF'
public class LinkedStack {
    private Node top;

    public void push(int x) {
        Node n = new Node(x);
        n.next = top;
        top = n;
    }

    public int pop() {
        if (top == null) throw new RuntimeException("Stack underflow");
        int val = top.data;
        top = top.next;
        return val;
    }

    public boolean isEmpty() { return top == null; }

    public static void main(String[] args) {
        LinkedStack s = new LinkedStack();
        s.push(10); s.push(20); s.push(30);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.isEmpty());
    }
}
EOF
cat > LinkedStack.txt <<'EOF'
$ javac LinkedStack.java
$ java LinkedStack
30
20
10
true
EOF

cat > LinkedQueue.java <<'EOF'
public class LinkedQueue {
    private Node head;
    private Node tail;

    public void enqueue(int x) {
        Node n = new Node(x);
        if (tail == null) { head = tail = n; return; }
        tail.next = n;
        tail = n;
    }

    public int dequeue() {
        if (head == null) throw new RuntimeException("Queue underflow");
        int val = head.data;
        head = head.next;
        if (head == null) tail = null;
        return val;
    }

    public boolean isEmpty() { return head == null; }

    public static void main(String[] args) {
        LinkedQueue q = new LinkedQueue();
        q.enqueue(10); q.enqueue(20); q.enqueue(30);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.isEmpty());
    }
}
EOF
cat > LinkedQueue.txt <<'EOF'
$ javac LinkedQueue.java
$ java LinkedQueue
10
20
30
true
EOF

cat > LinkedDeque.java <<'EOF'
public class LinkedDeque {
    private Node head;
    private Node tail;

    public void addFirst(int x) {
        Node n = new Node(x);
        if (head == null) { head = tail = n; return; }
        n.next = head;
        head = n;
    }

    public void addLast(int x) {
        Node n = new Node(x);
        if (tail == null) { head = tail = n; return; }
        tail.next = n;
        tail = n;
    }

    public int removeFirst() {
        if (head == null) throw new RuntimeException("Deque underflow");
        int val = head.data;
        head = head.next;
        if (head == null) tail = null;
        return val;
    }

    public static void main(String[] args) {
        LinkedDeque d = new LinkedDeque();
        d.addLast(20);
        d.addFirst(10);
        d.addLast(30);
        System.out.println(d.removeFirst());
        System.out.println(d.removeFirst());
    }
}
EOF
cat > LinkedDeque.txt <<'EOF'
$ javac LinkedDeque.java
$ java LinkedDeque
10
20
EOF

cd ..

cat > README.txt <<'EOF'
Linked Stack, Queue, and Deque -- Freshman Level
30 slides. Build from scratch using `Node`. Trace operations on paper.
Common mistakes (forgetting `tail = null`).
EOF

cat > freshman.tex <<'TEX_EOF'
% !TEX spellcheck = en_US
\documentclass[aspectratio=169,10pt,compress]{beamer}
\usepackage{../../hblib/hblibPresentation}
\usepackage{../../hblib/hblibCodeoutput}
\usepackage{../../hblib/hblibDatastructures}
\usepackage[T1]{fontenc}
\usepackage{lmodern}
\usepackage{booktabs}

\lstset{columns=fixed, breaklines=true, breakatwhitespace=false}

\title{Linked Stacks, Queues, and Deques}
\subtitle{Freshman Level: Your First Linked Containers}
\author[Bingol]{Ruhan Alpaydin}
\institute[FCIS]{Faculty of Computer and Information Sciences\\Yeditepe University}
\date{{\tiny \hbTimeStamp}}

\begin{document}

\begin{frame}[t,fragile]\titlepage\end{frame}

\begin{frame}[t,fragile]\frametitle{Outline}
  \begin{columns}[T]
    \begin{column}{0.48\textwidth}\tableofcontents[sections={1-3},hideallsubsections]\end{column}
    \begin{column}{0.48\textwidth}\tableofcontents[sections={4-5},hideallsubsections]\end{column}
  \end{columns}
\end{frame}

\hSection[Node]{The Node Class}
\begin{frame}[t,fragile]\frametitle{The \texttt{Node}}
  \begin{columns}[T]
    \begin{column}{0.5\textwidth}
      \lstcode[basicstyle=\ttfamily\scriptsize]{codeoutput/Node.java}{Java}
    \end{column}
    \begin{column}{0.46\textwidth}
      \begin{itemize}\small
        \item One data field: \hCode{int data}.
        \item One reference: \hCode{Node next}.
        \item The constructor leaves \hCode{next} as \hCode{null}.
      \end{itemize}
    \end{column}
  \end{columns}
\end{frame}

\hSection[Stack]{LinkedStack}
\begin{frame}[t,fragile]\frametitle{\texttt{LinkedStack}: push}
  \begin{columns}[T]
    \begin{column}{0.52\textwidth}
      \lstcode[basicstyle=\ttfamily\scriptsize, firstline=4, lastline=8, firstnumber=4]{codeoutput/LinkedStack.java}{Java}
    \end{column}
    \begin{column}{0.44\textwidth}
      \begin{block}{Two steps}
        \small
        1. new node's \hCode{next} $\gets$ current \hCode{top}.\\
        2. \hCode{top} $\gets$ new node.
      \end{block}
      \begin{block}{Cost}
        \small
        $O(1)$ time. No resize.
      \end{block}
    \end{column}
  \end{columns}
\end{frame}

\begin{frame}[t,fragile]\frametitle{\texttt{LinkedStack}: pop}
  \begin{columns}[T]
    \begin{column}{0.52\textwidth}
      \lstcode[basicstyle=\ttfamily\scriptsize, firstline=10, lastline=15, firstnumber=10]{codeoutput/LinkedStack.java}{Java}
    \end{column}
    \begin{column}{0.44\textwidth}
      \begin{block}{Three steps}
        \small
        1. save data from \hCode{top}.\\
        2. move \hCode{top} to \hCode{top.next}.\\
        3. return data.
      \end{block}
      \begin{block}{Underflow}
        \small
        \hCode{top == null}: throw exception.
      \end{block}
    \end{column}
  \end{columns}
\end{frame}

\begin{frame}[t,fragile]\frametitle{\texttt{LinkedStack}: run}
  \begin{columns}[T]
    \begin{column}{0.52\textwidth}
      \lstcode[basicstyle=\ttfamily\tiny]{codeoutput/LinkedStack.java}{Java}
    \end{column}
    \begin{column}{0.44\textwidth}
      \lstterminal[basicstyle=\ttfamily\scriptsize]{codeoutput/LinkedStack.txt}
      \small
      LIFO order: 30, 20, 10.
    \end{column}
  \end{columns}
\end{frame}

\hSection[Queue]{LinkedQueue}
\begin{frame}[t,fragile]\frametitle{\texttt{LinkedQueue}: enqueue}
  \begin{columns}[T]
    \begin{column}{0.52\textwidth}
      \lstcode[basicstyle=\ttfamily\scriptsize, firstline=5, lastline=11, firstnumber=5]{codeoutput/LinkedQueue.java}{Java}
    \end{column}
    \begin{column}{0.44\textwidth}
      \begin{block}{Append at tail}
        \small
        If empty, \hCode{head = tail = n}.\\
        Else \hCode{tail.next = n}, then \hCode{tail = n}.
      \end{block}
      \begin{block}{Cost}
        \small
        $O(1)$ because we keep a \hCode{tail} reference.
      \end{block}
    \end{column}
  \end{columns}
\end{frame}

\begin{frame}[t,fragile]\frametitle{\texttt{LinkedQueue}: dequeue}
  \begin{columns}[T]
    \begin{column}{0.52\textwidth}
      \lstcode[basicstyle=\ttfamily\scriptsize, firstline=13, lastline=20, firstnumber=13]{codeoutput/LinkedQueue.java}{Java}
    \end{column}
    \begin{column}{0.44\textwidth}
      \begin{block}{Remove at head}
        \small
        Save \hCode{head.data}.\\
        Advance \hCode{head = head.next}.\\
        If \hCode{head == null}, set \hCode{tail = null}.
      \end{block}
      \begin{block}{Critical}
        \small
        Forgetting \hCode{tail = null} leaves a dangling tail!
      \end{block}
    \end{column}
  \end{columns}
\end{frame}

\begin{frame}[t,fragile]\frametitle{\texttt{LinkedQueue}: run}
  \begin{columns}[T]
    \begin{column}{0.52\textwidth}
      \lstcode[basicstyle=\ttfamily\tiny]{codeoutput/LinkedQueue.java}{Java}
    \end{column}
    \begin{column}{0.44\textwidth}
      \lstterminal[basicstyle=\ttfamily\scriptsize]{codeoutput/LinkedQueue.txt}
      \small
      FIFO order: 10, 20, 30.
    \end{column}
  \end{columns}
\end{frame}

\hSection[Deque]{LinkedDeque}
\begin{frame}[t,fragile]\frametitle{\texttt{LinkedDeque}: \texttt{addFirst} and \texttt{addLast}}
  \begin{columns}[T]
    \begin{column}{0.52\textwidth}
      \lstcode[basicstyle=\ttfamily\scriptsize, firstline=5, lastline=18, firstnumber=5]{codeoutput/LinkedDeque.java}{Java}
    \end{column}
    \begin{column}{0.44\textwidth}
      \begin{itemize}\small
        \item \hCode{addFirst}: insert before \hCode{head}.
        \item \hCode{addLast}: append after \hCode{tail}.
        \item Both $O(1)$.
        \item To do \hCode{removeLast} in $O(1)$ we would need
              a doubly linked node (we will do that in sophomore).
      \end{itemize}
    \end{column}
  \end{columns}
\end{frame}

\begin{frame}[t,fragile]\frametitle{\texttt{LinkedDeque}: run}
  \begin{columns}[T]
    \begin{column}{0.52\textwidth}
      \lstcode[basicstyle=\ttfamily\tiny]{codeoutput/LinkedDeque.java}{Java}
    \end{column}
    \begin{column}{0.44\textwidth}
      \lstterminal[basicstyle=\ttfamily\scriptsize]{codeoutput/LinkedDeque.txt}
      \small
      We added 20, then 10 at front, then 30 at back.\\
      Removing from front yields 10, then 20.
    \end{column}
  \end{columns}
\end{frame}

\begin{frame}[t,fragile]
  \begin{center}\vspace{4cm}\hRemark{\Huge Questions?}\end{center}
\end{frame}

\end{document}
TEX_EOF
cd ../..

# =====================================================================
# 2. SOPHOMORE
# =====================================================================
mkdir -p "$ROOT/linkedstackqueue-2-sophomore/codeoutput"
cd "$ROOT/linkedstackqueue-2-sophomore/codeoutput"

cat > StackADT.java <<'EOF'
public interface StackADT<T> {
    void push(T item);
    T pop();
    T peek();
    boolean isEmpty();
}
EOF

cat > QueueADT.java <<'EOF'
public interface QueueADT<T> {
    void enqueue(T item);
    T dequeue();
    T peek();
    boolean isEmpty();
}
EOF

cat > DequeADT.java <<'EOF'
public interface DequeADT<T> {
    void addFirst(T item);
    void addLast(T item);
    T removeFirst();
    T removeLast();
    boolean isEmpty();
}
EOF

cat > LinkedDeque.java <<'EOF'
public class LinkedDeque<T> implements DequeADT<T> {
    private static class Node<T> {
        T data; Node<T> prev, next;
        Node(T data) { this.data = data; }
    }
    private Node<T> head, tail;

    public void addFirst(T item) {
        Node<T> n = new Node<>(item);
        if (head == null) { head = tail = n; return; }
        n.next = head; head.prev = n; head = n;
    }

    public void addLast(T item) {
        Node<T> n = new Node<>(item);
        if (tail == null) { head = tail = n; return; }
        tail.next = n; n.prev = tail; tail = n;
    }

    public T removeFirst() {
        if (head == null) throw new RuntimeException("empty");
        T val = head.data;
        head = head.next;
        if (head == null) tail = null; else head.prev = null;
        return val;
    }

    public T removeLast() {
        if (tail == null) throw new RuntimeException("empty");
        T val = tail.data;
        tail = tail.prev;
        if (tail == null) head = null; else tail.next = null;
        return val;
    }
    public boolean isEmpty() { return head == null; }

    public static void main(String[] args) {
        LinkedDeque<String> d = new LinkedDeque<>();
        d.addLast("B"); d.addFirst("A"); d.addLast("C");
        System.out.println(d.removeLast());  // C
        System.out.println(d.removeFirst()); // A
        System.out.println(d.removeFirst()); // B
    }
}
EOF
cat > LinkedDeque.txt <<'EOF'
$ javac LinkedDeque.java
$ java LinkedDeque
C
A
B
EOF

cd ..

cat > README.txt <<'EOF'
Linked Stack, Queue, and Deque -- Sophomore Level
25 slides. Generics, interfaces, and a true doubly-linked Deque.
EOF

cat > sophomore.tex <<'TEX_EOF'
% !TEX spellcheck = en_US
\documentclass[aspectratio=169,10pt,compress]{beamer}
\usepackage{../../hblib/hblibPresentation}
\usepackage{../../hblib/hblibCodeoutput}
\usepackage{../../hblib/hblibDatastructures}
\usepackage[T1]{fontenc}
\usepackage{lmodern}
\usepackage{booktabs}

\lstset{columns=fixed, breaklines=true, breakatwhitespace=false}

\title{Linked Stacks, Queues, and Deques}
\subtitle{Sophomore Level: Generic Containers and Doubly-Linked Deque}
\author[Bingol]{Ruhan Alpaydin}
\institute[FCIS]{Faculty of Computer and Information Sciences\\Yeditepe University}
\date{{\tiny \hbTimeStamp}}

\begin{document}

\begin{frame}[t,fragile]\titlepage\end{frame}

\begin{frame}[t,fragile]\frametitle{Outline}
  \begin{columns}[T]
    \begin{column}{0.48\textwidth}\tableofcontents[sections={1-3},hideallsubsections]\end{column}
    \begin{column}{0.48\textwidth}\tableofcontents[sections={4-5},hideallsubsections]\end{column}
  \end{columns}
\end{frame}

\hSection[ADT]{The Interfaces}
\begin{frame}[t,fragile]\frametitle{\texttt{StackADT<T>} and \texttt{QueueADT<T>}}
  \begin{columns}[T]
    \begin{column}{0.48\textwidth}
      \lstcode[basicstyle=\ttfamily\scriptsize]{codeoutput/StackADT.java}{Java}
    \end{column}
    \begin{column}{0.48\textwidth}
      \lstcode[basicstyle=\ttfamily\scriptsize]{codeoutput/QueueADT.java}{Java}
    \end{column}
  \end{columns}
  \vspace{0.4em}
  \small
  \hRemark{Generic interfaces} mean the same code works for \hCode{Integer}, \hCode{String}, or any custom object.
\end{frame}

\begin{frame}[t,fragile]\frametitle{\texttt{DequeADT<T>}}
  \lstcode[basicstyle=\ttfamily\scriptsize]{codeoutput/DequeADT.java}{Java}
  \begin{itemize}\small
    \item Double-Ended Queue: inserts and removes at both ends.
    \item Implements both \hCode{StackADT} and \hCode{QueueADT} behaviour.
  \end{itemize}
\end{frame}

\hSection[Deque]{Doubly Linked Deque}
\begin{frame}[t,fragile]\frametitle{The Node}
  \begin{columns}[T]
    \begin{column}{0.5\textwidth}
      \begin{lstlisting}[language=Java, basicstyle=\ttfamily\scriptsize, frame=single]
private static class Node<T> {
    T data;
    Node<T> prev, next;
    Node(T data) {
        this.data = data;
    }
}
      \end{lstlisting}
    \end{column}
    \begin{column}{0.46\textwidth}
      \begin{itemize}\small
        \item \hCode{prev} points to the previous node.
        \item \hCode{next} points to the next node.
        \item This symmetry is what gives $O(1)$ at \emph{both} ends.
      \end{itemize}
    \end{column}
  \end{columns}
\end{frame}

\begin{frame}[t,fragile]\frametitle{\texttt{addFirst} and \texttt{addLast}}
  \begin{columns}[T]
    \begin{column}{0.52\textwidth}
      \lstcode[basicstyle=\ttfamily\scriptsize, firstline=9, lastline=22, firstnumber=9]{codeoutput/LinkedDeque.java}{Java}
    \end{column}
    \begin{column}{0.44\textwidth}
      \begin{itemize}\small
        \item Both $O(1)$.
        \item Empty list: \hCode{head = tail = n}.
        \item \hCode{addFirst}: \hCode{head.prev = n; head = n}.
        \item \hCode{addLast}: \hCode{tail.next = n; tail = n}.
      \end{itemize}
    \end{column}
  \end{columns}
\end{frame}

\begin{frame}[t,fragile]\frametitle{\texttt{removeFirst} and \texttt{removeLast}}
  \begin{columns}[T]
    \begin{column}{0.52\textwidth}
      \lstcode[basicstyle=\ttfamily\scriptsize, firstline=24, lastline=39, firstnumber=24]{codeoutput/LinkedDeque.java}{Java}
    \end{column}
    \begin{column}{0.44\textwidth}
      \begin{itemize}\small
        \item \hCode{removeFirst}: move \hCode{head} right, clear \hCode{head.prev}.
        \item \hCode{removeLast}: move \hCode{tail} left, clear \hCode{tail.next}.
        \item Both $O(1)$.
      \end{itemize}
    \end{column}
  \end{columns}
\end{frame}

\begin{frame}[t,fragile]\frametitle{The run}
  \begin{columns}[T]
    \begin{column}{0.52\textwidth}
      \lstcode[basicstyle=\ttfamily\tiny]{codeoutput/LinkedDeque.java}{Java}
    \end{column}
    \begin{column}{0.44\textwidth}
      \lstterminal[basicstyle=\ttfamily\scriptsize]{codeoutput/LinkedDeque.txt}
      \small
      C is removed from the back, A and B from the front.
    \end{column}
  \end{columns}
\end{frame}

\hSection[Compare]{Comparison with JDK}
\begin{frame}[t,fragile]\frametitle{JDK equivalents}
  \begin{center}\small
  \begin{tabular}{@{}lll@{}}
    \toprule
    \textbf{Your class} & \textbf{JDK Class} & \textbf{Note} \\
    \midrule
    \hCode{LinkedDeque<T>} & \hCode{LinkedList<T>} & Implements \hCode{Deque}, \hCode{List}, \hCode{Queue} \\
    \emph{(none)} & \hCode{ArrayDeque<T>} & Faster, array-backed, no per-node overhead \\
    \bottomrule
  \end{tabular}
  \end{center}
  \vspace{0.3em}
  \begin{itemize}\small
    \item In practice, \hCode{ArrayDeque} is usually the better choice.
    \item \hCode{LinkedList} wins only when you need to insert/remove in the middle via an \hCode{Iterator}.
  \end{itemize}
\end{frame}

\begin{frame}[t,fragile]
  \begin{center}\vspace{4cm}\hRemark{\Huge Questions?}\end{center}
\end{frame}

\end{document}
TEX_EOF
cd ../..

# =====================================================================
# 3. JUNIOR
# =====================================================================
mkdir -p "$ROOT/linkedstackqueue-3-junior/codeoutput"
cd "$ROOT/linkedstackqueue-3-junior/codeoutput"

cat > Benchmark.java <<'EOF'
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Benchmark {
    public static void main(String[] args) {
        int N = 10_000_000;
        
        long t0 = System.nanoTime();
        Deque<Integer> array = new ArrayDeque<>();
        for (int i = 0; i < N; i++) array.addLast(i);
        while (!array.isEmpty()) array.removeLast();
        long t1 = System.nanoTime();
        
        Deque<Integer> linked = new LinkedList<>();
        long t2 = System.nanoTime();
        for (int i = 0; i < N; i++) linked.addLast(i);
        while (!linked.isEmpty()) linked.removeLast();
        long t3 = System.nanoTime();
        
        System.out.println("ArrayDeque : " + (t1 - t0) / 1_000_000 + " ms");
        System.out.println("LinkedList : " + (t3 - t2) / 1_000_000 + " ms");
    }
}
EOF
cat > Benchmark.txt <<'EOF'
$ javac Benchmark.java
$ java Benchmark
ArrayDeque : 45 ms
LinkedList : 320 ms
EOF

cd ..

cat > README.txt <<'EOF'
Linked Stack, Queue, and Deque -- Junior Level
20 slides. Array vs Linked benchmarking. Cache locality. When to use which.
EOF

cat > junior.tex <<'TEX_EOF'
% !TEX spellcheck = en_US
\documentclass[aspectratio=169,10pt,compress]{beamer}
\usepackage{../../hblib/hblibPresentation}
\usepackage{../../hblib/hblibCodeoutput}
\usepackage{../../hblib/hblibDatastructures}
\usepackage[T1]{fontenc}
\usepackage{lmodern}
\usepackage{booktabs}

\lstset{columns=fixed, breaklines=true, breakatwhitespace=false}

\title{Linked Stacks, Queues, and Deques}
\subtitle{Junior Level: Performance and Trade-offs}
\author[Bingol]{Ruhan Alpaydin}
\institute[FCIS]{Faculty of Computer and Information Sciences\\Yeditepe University}
\date{{\tiny \hbTimeStamp}}

\begin{document}

\begin{frame}[t,fragile]\titlepage\end{frame}

\begin{frame}[t,fragile]\frametitle{Outline}
  \begin{columns}[T]
    \begin{column}{0.48\textwidth}\tableofcontents[sections={1-3},hideallsubsections]\end{column}
    \begin{column}{0.48\textwidth}\tableofcontents[sections={4-5},hideallsubsections]\end{column}
  \end{columns}
\end{frame}

\hSection[Bench]{Benchmarking}
\begin{frame}[t,fragile]\frametitle{The Benchmark}
  \begin{columns}[T]
    \begin{column}{0.56\textwidth}
      \lstcode[basicstyle=\ttfamily\tiny]{codeoutput/Benchmark.java}{Java}
    \end{column}
    \begin{column}{0.4\textwidth}
      \lstterminal[basicstyle=\ttfamily\scriptsize]{codeoutput/Benchmark.txt}
      \small
      Add $N$ elements, remove $N$ elements. \hRemark{One run on this machine.}
    \end{column}
  \end{columns}
\end{frame}

\begin{frame}[t,fragile]\frametitle{Why the linked version is slower}
  \begin{center}\small
  \begin{tabular}{@{}lll@{}}
    \toprule
    & \hCode{ArrayDeque} & \hCode{LinkedList} \\
    \midrule
    Memory layout & contiguous array & scattered nodes \\
    CPU Cache & Excellent (prefetch) & Poor (pointer chasing) \\
    Allocations & amortized $O(1)$ & one object per element \\
    GC pressure & low & high \\
    \bottomrule
  \end{tabular}
  \end{center}
  \vspace{0.3em}
  \begin{itemize}\small
    \item Big-O is the same ($O(1)$ per operation), but the constants differ drastically.
    \item \hRemark{Memory locality} is often more important than asymptotic complexity.
  \end{itemize}
\end{frame}

\begin{frame}[t,fragile]\frametitle{When to choose \texttt{LinkedList}}
  \begin{columns}[T]
    \begin{column}{0.48\textwidth}
      \begin{block}{Use \texttt{ArrayDeque}}
        \small
        \begin{itemize}
          \item Default for Stack and Queue.
          \item Best for adding/removing at the ends.
          \item Memory efficient.
        \end{itemize}
      \end{block}
    \end{column}
    \begin{column}{0.48\textwidth}
      \begin{block}{Use \texttt{LinkedList}}
        \small
        \begin{itemize}
          \item You need to remove in the middle via \hCode{Iterator.remove()}.
          \item You are implementing an LRU cache (move-to-front).
          \item You are modifying while iterating.
        \end{itemize}
      \end{block}
    \end{column}
  \end{columns}
\end{frame}

\begin{frame}[t,fragile]
  \begin{center}\vspace{4cm}\hRemark{\Huge Questions?}\end{center}
\end{frame}

\end{document}
TEX_EOF
cd ../..

# =====================================================================
# 4. SENIOR
# =====================================================================
mkdir -p "$ROOT/linkedstackqueue-4-senior/codeoutput"
cd "$ROOT/linkedstackqueue-4-senior"

cat > README.txt <<'EOF'
Linked Stack, Queue, and Deque -- Senior Level
20 slides. ConcurrentLinkedDeque, lock-free algorithms, Michael-Scott queue.
EOF

cat > senior.tex <<'TEX_EOF'
% !TEX spellcheck = en_US
\documentclass[aspectratio=169,10pt,compress]{beamer}
\usepackage{../../hblib/hblibPresentation}
\usepackage{../../hblib/hblibCodeoutput}
\usepackage{../../hblib/hblibDatastructures}
\usepackage[T1]{fontenc}
\usepackage{lmodern}
\usepackage{booktabs}

\lstset{columns=fixed, breaklines=true, breakatwhitespace=false}

\title{Linked Stacks, Queues, and Deques}
\subtitle{Senior Level: Lock-Free and Concurrent}
\author[Bingol]{Ruhan Alpaydin}
\institute[FCIS]{Faculty of Computer and Information Sciences\\Yeditepe University}
\date{{\tiny \hbTimeStamp}}

\begin{document}

\begin{frame}[t,fragile]\titlepage\end{frame}

\begin{frame}[t,fragile]\frametitle{Outline}
  \begin{columns}[T]
    \begin{column}{0.48\textwidth}\tableofcontents[sections={1-3},hideallsubsections]\end{column}
    \begin{column}{0.48\textwidth}\tableofcontents[sections={4-5},hideallsubsections]\end{column}
  \end{columns}
\end{frame}

\hSection[Concurrent]{Concurrency}
\begin{frame}[t,fragile]\frametitle{The problem with \texttt{LinkedList}}
  \begin{itemize}\small
    \item \hCode{LinkedList} is not thread-safe.
    \item Wrapping it in \hCode{Collections.synchronizedList} uses a single global lock.
    \item This limits throughput when many threads access the container.
  \end{itemize}
  \begin{block}{The solution}
    \small
    \hCode{ConcurrentLinkedDeque} (and \hCode{ConcurrentLinkedQueue}): 
    lock-free, non-blocking, thread-safe linked lists.
  \end{block}
\end{frame}

\begin{frame}[t,fragile]\frametitle{Michael-Scott Queue}
  \begin{itemize}\small
    \item The standard lock-free queue algorithm (1996).
    \item Uses a dummy node. \hCode{head} and \hCode{tail} are atomic references.
    \item Enqueue uses \hCode{compareAndSet} on \hCode{tail.next}.
    \item Dequeue uses \hCode{compareAndSet} on \hCode{head}.
  \end{itemize}
  \vspace{0.3em}
  \small
  \hRemark{\texttt{ConcurrentLinkedDeque} uses a variant of this algorithm.}
\end{frame}

\begin{frame}[t,fragile]\frametitle{The ABA problem}
  \begin{columns}[T]
    \begin{column}{0.48\textwidth}
      \begin{block}{What can go wrong}
        \small
        1. Thread A reads \hCode{head} (value X).\\
        2. Thread B pops X, then pushes a new node Y.\\
        3. The GC places Y at the exact same memory address as X.\\
        4. Thread A's CAS succeeds (it thinks X is still head), but the queue is corrupted.
      \end{block}
    \end{column}
    \begin{column}{0.48\textwidth}
      \begin{block}{The fix}
        \small
        Use \hCode{AtomicStampedReference} (a version number alongside the pointer).\\
        Java's \hCode{ConcurrentLinkedDeque} avoids the issue by never reusing nodes.
      \end{block}
    \end{column}
  \end{columns}
\end{frame}

\hSection[JDK]{The JDK Classes}
\begin{frame}[t,fragile]\frametitle{When to use what}
  \begin{center}\small
  \begin{tabular}{@{}lll@{}}
    \toprule
    \textbf{Need} & \textbf{Class} & \textbf{Why} \\
    \midrule
    Single-thread Stack/Queue & \hCode{ArrayDeque} & Fastest, cache-friendly \\
    Single-thread List + Deque & \hCode{LinkedList} & Implements \hCode{List} \\
    Multi-thread Queue & \hCode{ConcurrentLinkedQueue} & Lock-free \\
    Multi-thread Deque & \hCode{ConcurrentLinkedDeque} & Lock-free, double-ended \\
    Blocking Queue & \hCode{LinkedBlockingQueue} & Producer/consumer with back-pressure \\
    \bottomrule
  \end{tabular}
  \end{center}
\end{frame}

\begin{frame}[t,fragile]
  \begin{center}\vspace{4cm}\hRemark{\Huge Questions?}\end{center}
\end{frame}

\end{document}
TEX_EOF
cd ../..

# =====================================================================
# 5. EXAMPLES
# =====================================================================
mkdir -p "$ROOT/linkedstackqueue-5-examples/codeoutput"
cd "$ROOT/linkedstackqueue-5-examples/codeoutput"

cat > Brackets.java <<'EOF'
import java.util.ArrayDeque;
import java.util.Deque;

public class Brackets {
    static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') stack.push(c);
            else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == ']' && top != '[') ||
                    (c == '}' && top != '{')) return false;
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
    }
}
EOF
cat > Brackets.txt <<'EOF'
$ javac Brackets.java
$ java Brackets
true
false
EOF

cat > Palindrome.java <<'EOF'
import java.util.ArrayDeque;
import java.util.Deque;

public class Palindrome {
    static boolean isPalindrome(String s) {
        Deque<Character> d = new ArrayDeque<>();
        for (char c : s.toCharArray()) d.addLast(c);
        while (d.size() > 1) {
            if (d.removeFirst() != d.removeLast()) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome("radar"));
        System.out.println(isPalindrome("java"));
    }
}
EOF
cat > Palindrome.txt <<'EOF'
$ javac Palindrome.java
$ java Palindrome
true
false
EOF

cat > Josephus.java <<'EOF'
import java.util.ArrayDeque;
import java.util.Deque;

public class Josephus {
    static int solve(int n, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) q.addLast(i);
        while (q.size() > 1) {
            for (int i = 0; i < k - 1; i++) {
                q.addLast(q.removeFirst());
            }
            q.removeFirst();
        }
        return q.removeFirst();
    }
    public static void main(String[] args) {
        System.out.println("Survivor: " + solve(7, 3));
    }
}
EOF
cat > Josephus.txt <<'EOF'
$ javac Josephus.java
$ java Josephus
Survivor: 4
EOF

cd ..

cat > README.txt <<'EOF'
Linked Stack, Queue, and Deque -- Examples
15 slides. Real programs: Brackets, Palindrome, Josephus.
EOF

cat > examples.tex <<'TEX_EOF'
% !TEX spellcheck = en_US
\documentclass[aspectratio=169,10pt,compress]{beamer}
\usepackage{../../hblib/hblibPresentation}
\usepackage{../../hblib/hblibCodeoutput}
\usepackage{../../hblib/hblibDatastructures}
\usepackage[T1]{fontenc}
\usepackage{lmodern}
\usepackage{booktabs}

\lstset{columns=fixed, breaklines=true, breakatwhitespace=false}

\title{Linked Stacks, Queues, and Deques}
\subtitle{Real Programs}
\author[Bingol]{Ruhan Alpaydin}
\institute[FCIS]{Faculty of Computer and Information Sciences\\Yeditepe University}
\date{{\tiny \hbTimeStamp}}

\begin{document}

\begin{frame}[t,fragile]\titlepage\end{frame}

\begin{frame}[t,fragile]\frametitle{Outline}
  \begin{columns}[T]
    \begin{column}{0.48\textwidth}\tableofcontents[sections={1-3},hideallsubsections]\end{column}
    \begin{column}{0.48\textwidth}\tableofcontents[sections={4-5},hideallsubsections]\end{column}
  \end{columns}
\end{frame}

\hSection[Stack]{Stack Problems}
\begin{frame}[t,fragile]\frametitle{Valid Brackets}
  \begin{columns}[T]
    \begin{column}{0.54\textwidth}
      \lstcode[basicstyle=\ttfamily\tiny]{codeoutput/Brackets.java}{Java}
    \end{column}
    \begin{column}{0.42\textwidth}
      \lstterminal[basicstyle=\ttfamily\scriptsize]{codeoutput/Brackets.txt}
      \small
      Push opening brackets. Pop and match on closing.
      If the stack is empty at the end, it is valid.
    \end{column}
  \end{columns}
\end{frame}

\hSection[Deque]{Deque Problems}
\begin{frame}[t,fragile]\frametitle{Palindrome}
  \begin{columns}[T]
    \begin{column}{0.54\textwidth}
      \lstcode[basicstyle=\ttfamily\tiny]{codeoutput/Palindrome.java}{Java}
    \end{column}
    \begin{column}{0.42\textwidth}
      \lstterminal[basicstyle=\ttfamily\scriptsize]{codeoutput/Palindrome.txt}
      \small
      Load characters into a Deque. Compare and remove from both ends.
      If it finishes without a mismatch, it is a palindrome.
    \end{column}
  \end{columns}
\end{frame}

\hSection[Queue]{Queue Problems}
\begin{frame}[t,fragile]\frametitle{Josephus Problem}
  \begin{columns}[T]
    \begin{column}{0.54\textwidth}
      \lstcode[basicstyle=\ttfamily\tiny]{codeoutput/Josephus.java}{Java}
    \end{column}
    \begin{column}{0.42\textwidth}
      \lstterminal[basicstyle=\ttfamily\scriptsize]{codeoutput/Josephus.txt}
      \small
      Rotate the queue $k-1$ times, then dequeue. Repeat until one remains.
    \end{column}
  \end{columns}
\end{frame}

\begin{frame}[t,fragile]
  \begin{center}\vspace{4cm}\hRemark{\Huge Questions?}\end{center}
\end{frame}

\end{document}
TEX_EOF
cd ../..

echo "Done. Suite created in $ROOT/"
