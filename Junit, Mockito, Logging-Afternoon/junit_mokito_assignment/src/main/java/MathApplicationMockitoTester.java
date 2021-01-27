import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MathApplicationMockitoTester {
    @InjectMocks
    MathApplicationMockito mockitoApplication = new MathApplicationMockito();

    @Mock
    CalculatorService calcService;

    @Test
    public void testAdd() {
        when(calcService.add(10.0,20.0)).thenReturn(30.0);
        assertEquals(mockitoApplication.add(10.0, 20.0),30.0,0);
    }

    @Test
    public void testSubtract() {
        when(calcService.subtract(30.0,20.0)).thenReturn(10.0);
        assertEquals(mockitoApplication.subtract(30.0, 20.0),10.0,0);
    }

    @Test
    public void testMultiply(){
        when(calcService.multiply(10.0,20.0)).thenReturn(200.0);
        assertEquals(mockitoApplication.multiply(10.0, 20.0),200.0,0);
    }

    @Test
    public void testDivide() {
        when(calcService.divide(20.0,10.0)).thenReturn(2.0);
        assertEquals(mockitoApplication.divide(20.0, 10.0),2.0,0);
    }
}
