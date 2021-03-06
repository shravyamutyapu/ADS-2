/**
 * TrieST class.
 * @param <Value> tag.
 */
public class TrieST<Value> {
    /**
     * extended ASCII.
     */
    private static final int R = 256;
    /**
     * root of trie.
     */
    private Node root;
    /**
     * number of keys in trie.
     */
    private int n;
    /**
     * R-way trie node.
     */
    private static class Node {
        /**
         * variable val of Object type.
         */
        private Object val;
        /**
         * array of node type.
         */
        private Node[] next = new Node[R];
    }
    /**
      * Initializes an empty
      * string symbol table.
      */
    public TrieST() {
        //empty.
    }


    /**
     * Returns the value associated with.
     * the given key.
     * @param key the key
     * @return the value associated with.
     * the given key if the key is in the
     * symbol table
     * and {@code null} if the key
     * is not in the symbol table
     * @throws IllegalArgumentException i
     * if {@code key} is {@code null}
     */
    public Value get(final String key) {
        if (key == null) {
            throw new IllegalArgumentException(
                "argument to get() is null");
        }
        Node x = get(root, key, 0);
        if (x == null) {
            return null;
        }
        return (Value) x.val;
    }

    /**
     * Does this symbol table contain.
     * the given key?
     * @param key the key
     * @return {@code true} if this
     * symbol table contains {@code key} and
     *     {@code false} otherwise
     * @throws IllegalArgumentException i
     * f {@code key} is {@code null}
     */
    public boolean contains(final String key) {
        if (key == null) {
            throw new IllegalArgumentException(
                "argument to contains() is null");
        }
        return get(key) != null;
    }
    /**
     * get method.
     * @param x Node.
     * @param key key.
     * @param d int.
     * @return Node.
     */
    private Node get(final Node x,
        final String key, final int d) {
        if (x == null) {
            return null;
        }
        if (d == key.length()) {
            return x;
        }
        char c = key.charAt(d);
        return get(x.next[c], key, d + 1);
    }

    /**
     * Inserts the key-value pair into.
     * the symbol table, overwriting the old value
     * with the new value if the key is
     * already in the symbol table.
     * If the value is {@code null}, this
     * effectively deletes the key from
     * the symbol table.
     * @param key the key
     * @param val the value
     * @throws IllegalArgumentException i
     * f {@code key} is {@code null}
     */
    public void put(final String key, final Value val) {
        if (key == null) {
            throw new IllegalArgumentException(
                "first argument to put() is null");
        }
        if (val == null) {
            delete(key);
        } else {
            root = put(root, key, val, 0);
        }
    }
    /**
     * put method.
     * @param t Node.
     * @param key key.
     * @param val val.
     * @param d int.
     * @return Node.
     */
    private Node put(final Node t, final String key,
        final Value val, final int d) {
        Node x = t;
        if (x == null) {
            x = new Node();
        }
        if (d == key.length()) {
            if (x.val == null) {
                n++;
            }
            x.val = val;
            return x;
        }
        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, val, d + 1);
        return x;
    }

    /**
     * Returns the number of key-value.
     * pairs in this symbol table.
     * @return the number of key-value.
     * pairs in this symbol table
     */
    public int size() {
        return n;
    }

    /**
     * Is this symbol table empty?
     * @return {@code true} if this
     * symbol table is empty and
     * {@code false} otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns all keys in the
     * symbol table as an {@code Iterable}.
     * To iterate over all of the keys
     * in the symbol table named {@code st},
     * use the foreach notation:
     * {@code for (Key key : st.keys())}.
     * @return all keys in the symbol
     * table as an {@code Iterable}
     */
    public Iterable<String> keys() {
        return keysWithPrefix("");
    }

    /**
     * Returns all of the keys in the.
     * set that start with {@code prefix}.
     * @param prefix the prefix
     * @return all of the keys in the
     * set that start with {@code prefix},
     *     as an iterable
     */
    public Iterable<String> keysWithPrefix(final String prefix) {
        Queue<String> results = new Queue<String>();
        Node x = get(root, prefix, 0);
        collect(x, new StringBuilder(prefix), results);
        return results;
    }
    /**
     * collect.
     * @param x [description]
     * @param prefix [description]
     * @param results [description]
     */
    private void collect(final Node x,
final StringBuilder prefix, final Queue<String> results) {
        if (x == null) {
            return;
        }
        if (x.val != null) {
            results.enqueue(prefix.toString());
        }
        for (char c = 0; c < R; c++) {
            prefix.append(c);
            collect(x.next[c], prefix, results);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    /**
     * Returns all of the keys in the.
     * symbol table that match {@code pattern},
     * where . symbol is treated as a wildcard character.
     * @param pattern the pattern
     * @return all of the keys in the
     * symbol table that match {@code pattern},
     *     as an iterable, where . is
     *     treated as a wildcard character.
     */
    public Iterable<String> keysThatMatch(final String pattern) {
        Queue<String> results = new Queue<String>();
        collect(root, new StringBuilder(), pattern, results);
        return results;
    }
    /**
     * collect.
     * @param x [description]
     * @param prefix [description]
     * @param pattern [description]
     * @param results [description]
     */
    private void collect(final Node x, final StringBuilder prefix,
        final String pattern, final Queue<String> results) {
        if (x == null) {
            return;
        }
        int d = prefix.length();
        if (d == pattern.length() && x.val != null) {
            results.enqueue(prefix.toString());
        }
        if (d == pattern.length()) {
            return;
        }
        char c = pattern.charAt(d);
        if (c == '.') {
            for (char ch = 0; ch < R; ch++) {
                prefix.append(ch);
                collect(x.next[ch], prefix, pattern, results);
                prefix.deleteCharAt(prefix.length() - 1);
            }
        } else {
            prefix.append(c);
            collect(x.next[c], prefix, pattern, results);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }
    /**
     * bool.
     * @param prefix pre.
     * @return boolean.
     */
    public boolean contains1(final String prefix) {
        Node x = get(root, prefix, 0);
        return !(x == null);
    }

    /**
     * Returns the string in the symbol.
     * table that is the longest prefix of {@code query},
     * or {@code null}, if no such string.
     * @param query the query string
     * @return the string in the symbol.
     * table that is the longest prefix of {@code query},
     *     or {@code null} if no such string
     * @throws IllegalArgumentException i
     * f {@code query} is {@code null}
     */
    public String longestPrefixOf(final String query) {
        if (query == null) {
            throw new IllegalArgumentException(
        "argument to longestPrefixOf() is null");
        }
        int length = longestPrefixOf(root, query, 0, -1);
        if (length == -1) {
            return null;
        } else {
            return query.substring(0, length);
        }
    }

    /**.
     * returns the length of the longest.
     * string key in the subtrie
    // rooted at x that is a prefix
    of the query string,
    // assuming the first d character
    match and we have already
    // found a prefix match of given
    length (-1 if no such match)
     * @param x [description]
     * @param query [description]
     * @param d [description]
     * @param len [description]
     * @return [description]
     */
    private int longestPrefixOf(final Node x,
final String query, final int d, final int len) {
        int length = len;
        if (x == null) {
            return length;
        }
        if (x.val != null) {
            length = d;
        }
        if (d == query.length()) {
            return length;
        }
        char c = query.charAt(d);
        return longestPrefixOf(x.next[c], query, d + 1, length);
    }

    /**
     * Removes the key from the set if the key is present.
     * @param key the key
     * @throws IllegalArgumentException i
     * f {@code key} is {@code null}
     */
    public void delete(final String key) {
        if (key == null) {
            throw new IllegalArgumentException(
                "argument to delete() is null");
        }
        root = delete(root, key, 0);
    }
    /**
     * delete.
     * @param x [description]
     * @param key [description]
     * @param d [description]
     * @return [description]
     */
    private Node delete(final Node x,
        final String key, final int d) {
        if (x == null) {
            return null;
        }
        if (d == key.length()) {
            if (x.val != null) {
                n--;
            }
            x.val = null;
        } else {
            char c = key.charAt(d);
            x.next[c] = delete(x.next[c], key, d + 1);
        }

        // remove subtrie rooted at x if it is completely empty
        if (x.val != null) {
            return x;
        }
        for (int c = 0; c < R; c++) {
            if (x.next[c] != null) {
                return x;
            }
        }
        return null;
    }

    // /**
    //  * Unit tests the {@code TrieST} data type.
    //  *
    //  * @param args the command-line arguments
    //  */
    // public static void main(String[] args) {

    //     // build symbol table from standard input
    //     TrieST<Integer> st = new TrieST<Integer>();
    //     for (int i = 0; !StdIn.isEmpty(); i++) {
    //         String key = StdIn.readString();
    //         st.put(key, i);
    //     }

    //     // print results
    //     if (st.size() < 100) {
    //         StdOut.println("keys(\"\"):");
    //         for (String key : st.keys()) {
    //             StdOut.println(key + " " + st.get(key));
    //         }
    //         StdOut.println();
    //     }

    //     StdOut.println("longestPrefixOf(\"shellsort\"):");
    //     StdOut.println(st.longestPrefixOf("shellsort"));
    //     StdOut.println();

    //     StdOut.println("longestPrefixOf(\"quicksort\"):");
    //     StdOut.println(st.longestPrefixOf("quicksort"));
    //     StdOut.println();

    //     StdOut.println("keysWithPrefix(\"shor\"):");
    //     for (String s : st.keysWithPrefix("shor"))
    //         StdOut.println(s);
    //     StdOut.println();

    //     StdOut.println("keysThatMatch(\".he.l.\"):");
    //     for (String s : st.keysThatMatch(".he.l."))
    //         StdOut.println(s);
    // }
}
