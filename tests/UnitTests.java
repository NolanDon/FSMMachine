import main.FSMMachineController;
import main.StartEngine;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class UnitTests {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    StartEngine startEngine;

    FSMMachineController fsm = new FSMMachineController();
    private static final double DELTA = 1e-15;

    /** START STATE */
    @Test
    public void testStartStateResultTrue_1() {
        Assert.assertEquals(1, fsm.startState("1010"), DELTA);
    }

    @Test
    public void testStartStateResultTrue_2() {
        Assert.assertEquals(0, fsm.startState("110"), DELTA);
    }

    @Test
    public void testStartStateResultTrue_3() {
        Assert.assertEquals(2, fsm.startState("11010100101010"), DELTA);
    }

    @Test
    public void testStartStateResultTrue_4() {
        Assert.assertEquals(0, fsm.startState("1101001010101"), DELTA);
    }

    /** EXCEPTIONS */
    @Test
    public void testInvalidBinaryCharsThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> fsm.startState("hello"));
    }

    /** START ENGINE */
    @Test
    public void assertEmptyStringThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> startEngine = new StartEngine(""));
    }
}