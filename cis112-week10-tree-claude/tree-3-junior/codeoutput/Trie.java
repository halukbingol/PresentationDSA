import java.util.TreeMap;

/** A trie: an N-ary tree with one child per next letter. */
public class Trie {
    final TreeMap<Character, Trie> children = new TreeMap<>();   // sorted by letter
    boolean isWord;

    void insert(String w) {
        Trie t = this;
        for (char c : w.toCharArray()) t = t.children.computeIfAbsent(c, k -> new Trie());
        t.isWord = true;
    }

    int countWithPrefix(String p) {
        Trie t = this;
        for (char c : p.toCharArray()) {
            t = t.children.get(c);
            if (t == null) return 0;
        }
        return t.count();
    }

    int count() {                                       // words in this subtree
        int n = isWord ? 1 : 0;
        for (Trie c : children.values()) n += c.count();
        return n;
    }

    void print(String prefix) {                         // preorder: sorted words
        if (isWord) System.out.print(prefix + " ");
        children.forEach((c, t) -> t.print(prefix + c));
    }

    public static void main(String[] args) {
        Trie t = new Trie();
        for (String w : "ağaç ağır ağız al ala alan elma el elif".split(" ")) t.insert(w);
        t.print("");
        System.out.println();
        for (String p : new String[] {"ağ", "al", "el", "x"})
            System.out.println("words starting with \"" + p + "\": " + t.countWithPrefix(p));
    }
}
