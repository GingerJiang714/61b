import org.junit.Test;
import static org.junit.Assert.*;


public class TestOffByN {
    static CharacterComparator offByN = new OffByN(5);

    // Your tests go here.
    @Test
    public void testequalChars() {
        assertTrue(offByN.equalChars('a', 'f'));
        assertTrue(offByN.equalChars('f', 'a'));
        assertFalse(offByN.equalChars('a', 'e'));
        assertFalse(offByN.equalChars('z', 'a'));
        assertFalse(offByN.equalChars('a', 'B'));
    }

}
