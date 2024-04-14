package Logic;

import java.util.Collections;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {

    String source;

    public Polynomial(String source) {
        this.source = source;
    }

    public TreeMap<Integer, Double> parsePolynomial() {
        TreeMap<Integer, Double> parsedPolynomial = new TreeMap<>();
        String input = this.source.replaceAll("\\s", "");
        Pattern pattern = Pattern.compile("([+-]?\\d*\\.?\\d*)x(\\^([+-]?\\d+))?|([+-]?\\d+)");
        Matcher matcher = pattern.matcher(input);
        StringBuilder parsedString = new StringBuilder();
        boolean isFirstTerm = true;
        while (matcher.find()) {
            String coefficientString = matcher.group(1);
            String degreeString = matcher.group(3);
            String constantString = matcher.group(4);
            double coefficient;
            int degree;
            if (coefficientString != null) {
                if (coefficientString.isEmpty() || coefficientString.equals("+")) {
                    coefficient = 1;
                } else if (coefficientString.equals("-")) {
                    coefficient = -1;
                } else {
                    coefficient = Double.parseDouble(coefficientString);
                }
            } else if (constantString != null) {
                coefficient = Double.parseDouble(constantString);
            } else {
                coefficient = 1;
            }
            if (degreeString != null) {

                degree = Integer.parseInt(degreeString);
            } else if (coefficientString != null) {
                degree = 1;
            } else {
                degree = 0;
            }
            if (!isFirstTerm) {
                parsedString.append(coefficient >= 0 ? " + " : " - ");
            } else {
                isFirstTerm = false;
            }
            if (degree > 0) {
                parsedString.append(coefficient == 1 ? "x" : (coefficient == -1 ? "-x" : coefficient + "x"));
                if (degree > 1) {
                    parsedString.append("^").append(degree);
                }
            } else {
                parsedString.append(coefficient);
            }

            parsedPolynomial.put(degree, coefficient);
        }
        return parsedPolynomial;
    }

    public boolean checkPolynomial() {

        for (char c : this.source.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                if (c != 'x') {
                    return false;
                }
            }
        }
        return true;
    }

    public static String prettyPrintPolynomial(TreeMap<Integer, Double> sourcePolynomial) {
        TreeMap<Integer, Double> reversedPolynomial = new TreeMap<>(Collections.reverseOrder());
        reversedPolynomial.putAll(sourcePolynomial);
        String printPolynomial = "";
        for (var entry : reversedPolynomial.entrySet()) {
            if (entry.getKey() == 0) {
                if (entry.getValue() > 0) {
                    printPolynomial += "+" + entry.getValue().toString();
                } else if (entry.getValue() < 0) {
                    printPolynomial += entry.getValue().toString();
                }
            } else if (entry.getKey() == 1) {
                if (entry.getValue() > 0) {
                    printPolynomial += "+" + entry.getValue().toString() + "x";
                } else if (entry.getValue() < 0) {
                    printPolynomial += entry.getValue().toString() + "x";
                }
            } else {
                if (entry.getValue() > 0) {
                    printPolynomial += "+" + entry.getValue().toString() + "x^" + entry.getKey().toString();
                } else if (entry.getValue() < 0) {
                    printPolynomial += entry.getValue().toString() + "x^" + entry.getKey().toString();
                }
            }
        }
        return printPolynomial;

    }

    public static TreeMap<Integer, Double> sortDescendingByDegree(TreeMap<Integer, Double> source) {
        TreeMap<Integer, Double> reversed = new TreeMap<>(Collections.reverseOrder());
        reversed.putAll(source);
        return reversed;
    }

    public static TreeMap<Integer, Double> removeZeroValues(TreeMap<Integer, Double> source) {
        TreeMap<Integer, Double> result = new TreeMap<>();
        for (var entry : source.entrySet()) {
            if (entry.getValue() != 0) {
                result.put(entry.getKey(), entry.getValue());
            }
        }
        return result;
    }

}
