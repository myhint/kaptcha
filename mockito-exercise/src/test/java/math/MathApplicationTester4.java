package math;

import application.math.MathApplication;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import service.math.CalculatorService;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Blake on 2018/8/31
 */
@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester4 {

    private MathApplication mathApplication;
    private CalculatorService calculatorService;

    @Before
    public void setUp() {
        mathApplication = new MathApplication();
        calculatorService = mock(CalculatorService.class);
        mathApplication.setCalculatorService(calculatorService);
    }

    @Test
    public void testAdd() {

        when(calculatorService.add(20.0, 10.0)).thenAnswer(new Answer<Double>() {
            @Override
            public Double answer(InvocationOnMock invocation) {

                Object[] args = invocation.getArguments();

                Object mock = invocation.getMock();

                return 30.0;
            }
        });

        Assert.assertEquals(mathApplication.add(20.0, 10.0), 30.0, 0);
    }

}
