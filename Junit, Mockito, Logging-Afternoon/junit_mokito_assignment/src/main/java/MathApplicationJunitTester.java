import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MathApplicationJunitTester {
    MathApplicationJunit junitApplication = new MathApplicationJunit();;

    @Test
    public void testAdd() {
        assertEquals(300.0, junitApplication.add(100.0,200.0), 0);
    }

    @Test
    public void testSubtract() {
        assertEquals(50.0, junitApplication.subtract(100.0,50.0), 0);
    }

    @Test
    public void testMultiply() {
        assertEquals(20000, junitApplication.multiply(100.0, 200.0), 0);
    }

    @Test
    public void testDivide() {
        assertEquals(20, junitApplication.multiply(200.0, 10.0), 0);
    }

}
