package Model;

import Logic.Polynomial;
import com.sun.source.tree.Tree;

import java.util.TreeMap;

import java.text.DecimalFormat;

public class Model {

    public static TreeMap<Integer, Double> sumOfPolynomials(Polynomial polyFirst, Polynomial polySecond) {
        TreeMap<Integer, Double> polynomialResult = new TreeMap<>();
        polynomialResult.putAll(polyFirst.parsePolynomial());
        for (var entry : polySecond.parsePolynomial().entrySet()) {
            polynomialResult.merge(entry.getKey(), entry.getValue(), Double::sum);
        }
        return polynomialResult;
    }

    public static TreeMap<Integer, Double> difOfPolynomials(Polynomial polyFirst, Polynomial polySecond) {
        TreeMap<Integer, Double> polynomialResult = new TreeMap<>();
        polynomialResult.putAll(polyFirst.parsePolynomial());
        for (var entry : polySecond.parsePolynomial().entrySet()) {
            polynomialResult.merge(entry.getKey(), -entry.getValue(), Double::sum);
        }
        return polynomialResult;
    }

    public static TreeMap<Integer, Double> difOfPolynomials(TreeMap<Integer, Double> polyFirst, TreeMap<Integer, Double> polySecond) {
        TreeMap<Integer, Double> polynomialResult = new TreeMap<>();
        polynomialResult.putAll(polyFirst);
        for (var entry : polySecond.entrySet()) {
            polynomialResult.merge(entry.getKey(), -entry.getValue(), Double::sum);
        }
        return polynomialResult;
    }

    public static TreeMap<Integer, Double> multiplicationOfPolynomials(Polynomial polyFirst, Polynomial polySecond) {
        TreeMap<Integer, Double> polynomialResult = new TreeMap<>();
        for (var entry1 : polyFirst.parsePolynomial().entrySet()) {
            for (var entry2 : polySecond.parsePolynomial().entrySet()) {
                int degree = entry1.getKey() + entry2.getKey();
                double coefficient = entry1.getValue() * entry2.getValue();
                polynomialResult.merge(degree, coefficient, Double::sum);
            }
        }

        return polynomialResult;
    }

    public static TreeMap<Integer, Double> multiplicationOfPolynomials(TreeMap<Integer, Double> polyFirst, TreeMap<Integer, Double> polySecond) {
        TreeMap<Integer, Double> polynomialResult = new TreeMap<>();
        for (var entry1 : polyFirst.entrySet()) {
            for (var entry2 : polySecond.entrySet()) {
                int degree = entry1.getKey() + entry2.getKey();
                double coefficient = entry1.getValue() * entry2.getValue();
                polynomialResult.merge(degree, coefficient, Double::sum);
            }
        }

        return polynomialResult;
    }

    public static class PolynomialDivisionResult {
        private final TreeMap<Integer, Double> quotient;
        private final TreeMap<Integer, Double> remainder;

        public PolynomialDivisionResult(TreeMap<Integer, Double> quotient, TreeMap<Integer, Double> remainder) {
            this.quotient = quotient;
            this.remainder = remainder;
        }

        public TreeMap<Integer, Double> getQuotient() {
            return quotient;
        }

        public TreeMap<Integer, Double> getRemainder() {
            return remainder;
        }
    }
    
    public static PolynomialDivisionResult divisionOfPolynomial(Polynomial polyFirst, Polynomial polySecond) {
        TreeMap<Integer, Double> first = polyFirst.parsePolynomial();
        TreeMap<Integer, Double> second = polySecond.parsePolynomial();

        TreeMap<Integer,Double> secondPolyOrdered = Polynomial.sortDescendingByDegree(second);

        TreeMap<Integer, Double> quotient = new TreeMap<>();
        TreeMap<Integer,Double> remainder = Polynomial.sortDescendingByDegree(first);

        while (!remainder.isEmpty() && remainder.firstKey()>= secondPolyOrdered.firstKey()){
            int degreeLeadingRemainder = remainder.firstKey();
            double coefficientLeadingRemainder = remainder.firstEntry().getValue();

            int degreeLeadingSecond = secondPolyOrdered.firstKey();
            double coefficientLeadingSecond = secondPolyOrdered.firstEntry().getValue();

            int degreeNewMonomial = degreeLeadingRemainder-degreeLeadingSecond;
            double coefficientNewMonomial = coefficientLeadingRemainder/coefficientLeadingSecond;

            TreeMap<Integer,Double> auxPoly = new TreeMap<>();
            auxPoly.put(degreeNewMonomial,coefficientNewMonomial);
            quotient.put(degreeNewMonomial,coefficientNewMonomial);

            TreeMap<Integer,Double> productHelp = Model.multiplicationOfPolynomials(secondPolyOrdered,auxPoly);
            remainder = Model.difOfPolynomials(remainder,productHelp);
            remainder = Polynomial.removeZeroValues(remainder);
            remainder = Polynomial.sortDescendingByDegree(remainder);
        }
        return new PolynomialDivisionResult(quotient,remainder);
    }

    public static TreeMap<Integer, Double> derivateOfPolynomial(Polynomial source) {
        TreeMap<Integer, Double> result = new TreeMap<>();
        TreeMap<Integer, Double> sourcePolynomial = source.parsePolynomial();
        for (var entry : sourcePolynomial.entrySet()) {
            if (entry.getKey() == 0) {
                result.put(0, 0.0);
            } else {
                result.put(entry.getKey() - 1, entry.getKey() * entry.getValue());
            }
        }
        return result;
    }

    public static TreeMap<Integer, Double> integrationOfPolynomial(Polynomial source) {
        TreeMap<Integer, Double> result = new TreeMap<>();
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        for (var entry : source.parsePolynomial().entrySet()) {
            double integratedValue = entry.getValue() / (entry.getKey() + 1);
            integratedValue = Double.parseDouble(decimalFormat.format(integratedValue));
            result.put(entry.getKey() + 1, integratedValue);
        }
        return result;
    }
}
