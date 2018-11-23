/**
 * LinearProbingHashST class.
 * @param <Key> key.
 * @param <Value> value.
 */
public class LinearProbingHashST<Key, Value> {
    /**
     * init_capacity var.
     */
    private static final int INIT_CAPACITY = 4;
    /**
     * number of key-value pairs.
     * in the symbol table
     */
    private int n;
    /**
     *size of linear probing table.
     */
    private int m;
    /**
     * the keys.
     */
    private Key[] keys;
    /**
     * the values.
     */
    private Value[] vals;
    /**
     * Initializes an empty.
     * symbol table.
     */
    public LinearProbingHashST() {
        this(INIT_CAPACITY);
    }

    /**
     * Initializes an empty symbol
     * table with the specified initial
     * capacity.
     * @param capacity the initial capacity
     */
    public LinearProbingHashST(int capacity) {
        m = capacity;
        n = 0;
        keys = (Key[])   new Object[m];
        vals = (Value[]) new Object[m];
    }

    /**
     * Returns the number of key-value
     * pairs in this symbol table.
     * Time complexity is O(1).
     * @return the number of key-value
     * pairs in this symbol table
     */
    public int size() {
        return n;
    }

    /**
     * Returns true if this symbol
     * table is empty.
     * Time complexity is O(1).
     * @return {@code true} if this
     * symbol table is empty;
     * {@code false} otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns true if this symbol table.
     * contains the specified key.
     * Time complexity is O(1).
     * @param  key the key
     * @return {@code true} if this symbol
     * table contains {@code key};
     * {@code false} otherwise
     * @throws IllegalArgumentException i
     * f {@code key} is {@code null}
     */
    public boolean contains(Key key) {
        if (key == null) {
            throw new IllegalArgumentException(
        "argument to contains() is null");
        }
        return get(key) != null;
    }
    /**
     * Time complexity is O(1).
     * hash function for keys - returns.
     * value between 0 and M-1
     * @param key tag.
     */

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }
    /**
     * Time complexity is O(m).
     * where m is size of linear probing table.
     * resizes the hash table to the given
     * capacity by re-hashing all of the keys
     * @param capacity tag.
     */

    private void resize(int capacity) {
        LinearProbingHashST<Key, Value> temp = new
        LinearProbingHashST<Key, Value>(capacity);
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], vals[i]);
            }
        }
        keys = temp.keys;
        vals = temp.vals;
        m    = temp.m;
    }

    /**
     * Inserts the specified key-value pair.
     * into the symbol table, overwriting the old
     * value with the new value if the symbol
     * table already contains the specified key.
     * Deletes the specified key (and its
     * associated value) from this symbol table
     * if the specified value is {@code null}.
     *
     * Time complexity is O(1).
     * @param  key the key
     * @param  val the value
     * @throws IllegalArgumentException i
     * f {@code key} is {@code null}
     */
    public void put(Key key, Value val) {
        if (key == null) {
            throw new IllegalArgumentException(
        "first argument to put() is null");
        }

        if (val == null) {
            delete(key);
            return;
        }

        // double table size if 50% full
        if (n >= m / 2) resize(2 * m);

        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        n++;
    }

    /**
     * Returns the value associated with
     * the specified key.
     * Time complexity is O(1).
     * @param key the key
     * @return the value associated with {@code key};
     *       {@code null} if no such value
     * @throws IllegalArgumentException if
     * {@code key} is {@code null}
     */
    public Value get(Key key) {
        if (key == null) {
    throw new IllegalArgumentException(
        "argument to get() is null");
     }
    for (int i = hash(key); keys[i] != null; i = (i + 1) % m)
            if (keys[i].equals(key)) {
                return vals[i];
            }
        return null;
    }

    /**
     * Removes the specified key and its.
     * associated value from this symbol table
     * (if the key is in this symbol table).
     * Time complexity is O(1).
     * @param  key the key
     * @throws IllegalArgumentException i
     * f {@code key} is {@code null}
     */
    public void delete(Key key) {
        if (key == null) {
            throw new IllegalArgumentException(
                "argument to delete() is null");
        }
        if (!contains(key)) {
            return;
        }

        // find position i of key
        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % m;
        }

        // delete key and associated value
        keys[i] = null;
        vals[i] = null;

        // rehash all keys in same cluster
        i = (i + 1) % m;
        while (keys[i] != null) {
            // delete keys[i] an vals[i] and reinsert
            Key   keyToRehash = keys[i];
            Value valToRehash = vals[i];
            keys[i] = null;
            vals[i] = null;
            n--;
            put(keyToRehash, valToRehash);
            i = (i + 1) % m;
        }

        n--;

        // halves size of array if it's 12.5% full or less
        if (n > 0 && n <= m / 8) resize(m / 2);

        // assert check();
    }

    /**
     * Returns all keys in this symbol.
     * table as an {@code Iterable}.
     * To iterate over all of the keys.
     * in the symbol table named {@code st},
     * use the foreach notation:
     * {@code for (Key key : st.keys())}.
     *
     * Time complexity is O(m).
     * where m is the size of the
     * linear hashing table.
     * @return all keys in this symbol table
     */
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < m; i++)
            if (keys[i] != null) {
                queue.enqueue(keys[i]);
            }
        return queue;
    }


    // /**
    //  * Unit tests the {@code LinearProbingHashST} data type.
    //  *
    //  * @param args the command-line arguments
    //  */
    // public static void main(String[] args) {
    //     // LinearProbingHashST<String, Integer> st = new LinearProbingHashST<String, Integer>();
    //     // for (int i = 0; !StdIn.isEmpty(); i++) {
    //     //     String key = StdIn.readString();
    //     //     st.put(key, i);
        // }

        // // print keys
        // for (String s : st.keys())
        //     StdOut.println(s + " " + st.get(s));
    }
// }