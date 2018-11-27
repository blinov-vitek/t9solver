package space.blinov;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import space.blinov.exception.ValidationError;

public class T9SolverTest {
    T9Solver solver = new T9Solver();

    @Test
    public void test1() {
        assertEquals("44 444", solver.solve("hi"));
    }

    @Test
    public void test2() {
        assertEquals("999337777", solver.solve("yes"));
    }

    @Test
    public void test3() {
        assertEquals("333666 6660 022 2777", solver.solve("foo  bar"));
    }

    @Test
    public void test4() {
        assertEquals("4433555 555666096667775553", solver.solve("hello world"));
    }

    @Test(expected = ValidationError.class)
    public void testEmpty() {
        solver.solve("");
    }

    @Test(expected = ValidationError.class)
    public void testNull() {
        solver.solve(null);
    }

    @Test(expected = ValidationError.class)
    public void testIllegalChar() {
        solver.solve("aaazzz123");
    }
}