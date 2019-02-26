package math;

import application.math.MathApplication;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import service.math.CalculatorService;

import static org.mockito.Mockito.spy;

/**
 * Created by Blake on 2018/8/31
 */
@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester5 {

    private MathApplication mathApplication;
    private CalculatorService calculatorService;

    @Before
    public void setUp() {
        mathApplication = new MathApplication();
        Calculator calculator = new Calculator();

        calculatorService = spy(calculator);
        mathApplication.setCalculatorService(calculatorService);

    }

    @Test
    public void testAdd() {

        Assert.assertEquals(mathApplication.add(20.0, 10.0), 30.0, 0);
    }

    class Calculator implements CalculatorService {

        @Override
        public double add(double input1, double input2) {
            return input1 + input2;
        }

        @Override
        public double subtract(double input1, double input2) {
            throw new UnsupportedOperationException("Method not implemented yet!");
        }

        @Override
        public double multiply(double input1, double input2) {
            throw new UnsupportedOperationException("Method not implemented yet!");
        }

        @Override
        public double divide(double input1, double input2) {
            throw new UnsupportedOperationException("Method not implemented yet!");
        }
    }


}
