import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();
    static OffByOne offbyone = new OffByOne();

    // Your tests go here.
    @Test
    public void testequalschar() {
        assertTrue(offbyone.equalChars('s', 's'));
        assertFalse(offbyone.equalChars('s', 'b'));
        assertTrue(offbyone.equalChars('&', '%'));
        assertTrue(offbyone.equalChars('f', 'e'));
    }


}
