public class UnionFind {

    private int[] set;  // root store the negative size of the tree, others store their parents

    public UnionFind(int n) {
        set = new int[6];
        for (int i = 0; i < n; i += 1) {
            set[i] = -1;
        }
    }

    // Throws an exception if v1 is not a valid index.
    public void validate(int v1) {
        if (v1 < 0 || v1 >= set.length) {
            throw new IllegalArgumentException("invalid input");
        }
    }

    // Returns the size of the set v1 belongs to
    public int sizeOf(int v1) {
        validate(v1);
        return -set[find(v1)];
    }

    // Returns the parent of v1. If v1 is root, returns the negative size of the tree
    public int parent(int v1) {
        validate(v1);
        return set[v1];
    }

    // Returns true if nodes v1 and v2 are connected.
    public boolean connected(int v1, int v2) {
        validate(v1);
        validate(v2);
        return find(v1) == find(v2);
    }

    // Connects two elements v1 and v2 together
    //If sizes are equal, tie break by connecting v1’s root to v2’s root.
    public void union(int v1, int v2) {
        validate(v1);
        validate(v2);
        int size1 = sizeOf(v1);
        int size2 = sizeOf(v2);

        // v2's root should connect to v1's
        if (size1 > size2) {
            set[find(v1)] -= size2;
            set[find(v2)] = find(v1);
        } else {
            set[find(v2)] -= size1;
            set[find(v1)] = find(v2);
        }
    }

    // Returns the root of the set v1 belongs to
    public int find(int v1) {
        validate(v1);
        while (set[v1] > 0) {
            v1 = set[v1];
        }

        return v1;
    }

}
