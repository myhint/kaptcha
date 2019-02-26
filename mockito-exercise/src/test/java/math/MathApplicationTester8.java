package math;

import application.math.MathApplication;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import service.math.CalculatorService;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Blake on 2018/8/31
 */
@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester8 {

    private MathApplication mathApplication;
    private CalculatorService calcService;

    @Before
    public void setUp() {
        mathApplication = new MathApplication();
        calcService = mock(CalculatorService.class);
        mathApplication.setCalculatorService(calcService);
    }

    @Test
    public void testAddAndSub() throws InterruptedException {

        //add the behavior to add numbers
        when(calcService.add(20.0, 10.0)).thenReturn(30.0);

        //subtract the behavior to subtract numbers
        when(calcService.subtract(20.0, 10.0)).thenReturn(10.0);

        //test the add functionality
        Assert.assertEquals(mathApplication.add(20.0, 10.0), 30.0, 0);

        //verify call to add method to be completed within 100 ms
        verify(calcService, timeout(1)).add(20.0, 10.0);

        //test the subtract functionality
//        Assert.assertEquals(mathApplication.subtract(20.0, 10.0), 10.0, 0);

        //invocation count can be added to ensure multiplication invocations
        //can be checked within given
        // timeout:100ms invoked times:2
//        verify(calcService, timeout(100).times(1)).subtract(20.0, 10.0);
    }

}
