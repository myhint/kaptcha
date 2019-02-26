package runner;

import math.MathApplicationTester4;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by Blake on 2018/8/31
 */
public class TestRunner4 {

    public static void main(String[] args) {

        Result result = JUnitCore.runClasses(MathApplicationTester4.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());

    }
}
