import static org.junit.Assert.*;
import org.junit.Test;

public class UnionFindTest {
    UnionFind uf = new UnionFind(6);

    @Test
    public void testunion() {
        uf.union(0, 1);
        uf.union(2, 3);
        uf.union(1, 2);
        assertEquals(4, uf.sizeOf(0));
        assertEquals(4, uf.sizeOf(1));
        assertEquals(4, uf.sizeOf(2));
        assertEquals(4, uf.sizeOf(3));

        assertTrue(uf.connected(1, 3));

        assertEquals(1, uf.parent(0));
        assertEquals(3, uf.find(0));
    }

}
