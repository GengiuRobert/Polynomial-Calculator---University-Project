import Logic.Polynomial;
import org.junit.Test;

import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationsTest {
    @Test
    public void testSum1() {
        Polynomial polynomialFirst = new Polynomial("2x^2 + 3x + 1");
        Polynomial polynomialSecond = new Polynomial("x^2 - 2x + 4");

        TreeMap<Integer, Double> sum = Model.Model.sumOfPolynomials(polynomialFirst, polynomialSecond);
        TreeMap<Integer, Double> expectedResult = new TreeMap<>();
        expectedResult.put(2, 3.0);
        expectedResult.put(1, 1.0);
        expectedResult.put(0, 5.0);

        assertEquals(expectedResult, sum);
    }

    @Test
    public void testSum2() {
        Polynomial polynomialFirst = new Polynomial("3x + 1");
        Polynomial polynomialSecond = new Polynomial("x^2");

        TreeMap<Integer,Double> sum = Model.Model.sumOfPolynomials(polynomialFirst, polynomialSecond);
        TreeMap<Integer,Double> expectedResult = new TreeMap<>();
        expectedResult.put(2, 1.0);
        expectedResult.put(1, 3.0);
        expectedResult.put(0, 1.0);

        assertEquals(expectedResult, sum);
    }

    @Test
    public void testDiff1() {
        Polynomial polynomialFirst = new Polynomial("2x^2 + 3x + 1");
        Polynomial polynomialSecond = new Polynomial("x^2 - 2x + 4");

        TreeMap<Integer, Double> difference = Model.Model.difOfPolynomials(polynomialFirst, polynomialSecond);
        TreeMap<Integer, Double> expectedResult = new TreeMap<>();
        expectedResult.put(2, 1.0);
        expectedResult.put(1, 5.0);
        expectedResult.put(0, -3.0);

        assertEquals(expectedResult, difference);
    }

    @Test
    public void testDiff2() {
        Polynomial polynomialFirst = new Polynomial("3x + 1");
        Polynomial polynomialSecond = new Polynomial("x^2");

        TreeMap<Integer, Double> difference = Model.Model.difOfPolynomials(polynomialFirst, polynomialSecond);
        TreeMap<Integer, Double> expectedResult = new TreeMap<>();
        expectedResult.put(2, -1.0);
        expectedResult.put(1, 3.0);
        expectedResult.put(0, 1.0);

        assertEquals(expectedResult, difference);
    }

    @Test
    public void testMultiply1() {
        Polynomial polynomialFirst = new Polynomial("2");
        Polynomial polynomialSecond = new Polynomial("x^2 - 2x + 4");

        TreeMap<Integer, Double> product = Model.Model.multiplicationOfPolynomials(polynomialFirst, polynomialSecond);
        TreeMap<Integer, Double> expectedResult = new TreeMap<>();
        expectedResult.put(2, 2.0);
        expectedResult.put(1, -4.0);
        expectedResult.put(0, 8.0);

        assertEquals(expectedResult, product);
    }

    @Test
    public void testMultiply2() {
        Polynomial polynomialFirst = new Polynomial("3x + 1");
        Polynomial polynomialSecond = new Polynomial("x^2");

        TreeMap<Integer, Double> product = Model.Model.multiplicationOfPolynomials(polynomialFirst, polynomialSecond);
        TreeMap<Integer, Double> expectedResult = new TreeMap<>();
        expectedResult.put(3, 3.0);
        expectedResult.put(2, 1.0);

        assertEquals(expectedResult, product);
    }

    @Test
    public void testDerivative1() {
        Polynomial polynomial = new Polynomial("2x^2+3x+1");

        TreeMap<Integer, Double> derivative = Model.Model.derivateOfPolynomial(polynomial);
        TreeMap<Integer, Double> expectedResult = new TreeMap<>();
        expectedResult.put(1, 4.0);
        expectedResult.put(0, 3.0);

        assertEquals(expectedResult, derivative);
    }

    @Test
    public void testDerivative2() {
        Polynomial polynomial = new Polynomial("3x + 1");

        TreeMap<Integer, Double> derivative = Model.Model.derivateOfPolynomial(polynomial);
        TreeMap<Integer, Double> expectedResult = new TreeMap<>();
        expectedResult.put(0, 3.0);

        assertEquals(expectedResult, derivative);
    }

    @Test
    public void testIntegration1() {
        Polynomial polynomial = new Polynomial("2x^2 + 3x + 1");

        TreeMap<Integer, Double> integration = Model.Model.integrationOfPolynomial(polynomial);
        TreeMap<Integer, Double> expectedResult = new TreeMap<>();
        expectedResult.put(3, 0.67);
        expectedResult.put(2, 1.5);
        expectedResult.put(1, 1.0);

        assertEquals(expectedResult, integration);
    }

    @Test
    public void testIntegration2() {
        Polynomial polynomial = new Polynomial("3x + 1");

        TreeMap<Integer, Double> integration = Model.Model.integrationOfPolynomial(polynomial);
        TreeMap<Integer, Double> expectedResult = new TreeMap<>();
        expectedResult.put(2, 1.5);
        expectedResult.put(1, 1.0);

        assertEquals(expectedResult, integration);
    }

    @Test
    public void testDivision1() {
        Polynomial polynomialFirst = new Polynomial("x^2-1");
        Polynomial polynomialSecond = new Polynomial("x + 1");

        Model.Model.PolynomialDivisionResult divisionResult = Model.Model.divisionOfPolynomial(polynomialFirst, polynomialSecond);
        TreeMap<Integer, Double> expectedQuotient = new TreeMap<>();
        expectedQuotient.put(1, 1.0);
        expectedQuotient.put(0, -1.0);

        TreeMap<Integer, Double> expectedRemainder = new TreeMap<>();

        //no value for expectedRemainder because when it is dividing equally so the map is empty
        assertEquals(expectedQuotient, divisionResult.getQuotient());
        assertEquals(expectedRemainder, divisionResult.getRemainder());
    }

    @Test
    public void testDivision2() {
        Polynomial polynomialFirst = new Polynomial("x^3 - 2x^2 + 6x - 5");
        Polynomial polynomialSecond = new Polynomial("x^2 - 1");

        Model.Model.PolynomialDivisionResult divisionResult = Model.Model.divisionOfPolynomial(polynomialFirst, polynomialSecond);
        TreeMap<Integer, Double> expectedQuotient = new TreeMap<>();
        expectedQuotient.put(1, 1.0);
        expectedQuotient.put(0, -2.0);

        TreeMap<Integer, Double> expectedRemainder = new TreeMap<>();
        expectedRemainder.put(1, 7.0);
        expectedRemainder.put(0, -7.0);

        assertEquals(expectedQuotient, divisionResult.getQuotient());
        assertEquals(expectedRemainder, divisionResult.getRemainder());
    }
}

