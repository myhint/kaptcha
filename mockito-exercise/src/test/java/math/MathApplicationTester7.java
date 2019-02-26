package math;

import application.math.MathApplication;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import service.math.CalculatorService;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

/**
 * Created by Blake on 2018/8/31
 */
@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester7 {

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

        // Given > When > Then

        // Given
        given(calculatorService.add(20.0, 10.0)).willReturn(30.0);

        given(calculatorService.add(20.0, 20.0)).willReturn(30.0);

        // When
        double result = calculatorService.add(20.0, 20.0);


        // Then
        Assert.assertEquals(result, 30.0, 0);
    }

}
