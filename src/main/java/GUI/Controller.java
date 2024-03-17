package GUI;

import Logic.Polynomial;
import Model.Model;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeMap;

public class Controller {
    View view;

    public Controller(View view) {
        this.view = view;
        view.sumButtonListener(new SumActionOfButton());
        view.difButtonListener(new DiffActionOfButton());
        view.multiplicationButtonListener(new MultiplicationActionOfButton());
        view.divisonButtonListener(new DivisionActionOfButton());
        view.derivateButtonListener(new DerivateActionOfButton());
        view.integrateButtonListener(new IntegrateActionOfButton());

    }

    public class SumActionOfButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String first = view.firstPolynomialTextField.getText();
            String second = view.secondPolynomialTextField.getText();
            if (first.isEmpty() || second.isEmpty()) {
                view.resultPolynomialTextField.setText("  Missing some input");
                view.resultPolynomialTextField.setForeground(new Color(194, 15, 2));
            } else {
                Polynomial polynomialFirst = new Polynomial(first);
                Polynomial polynomialSecond = new Polynomial(second);
                if (polynomialSecond.checkPolynomial() && polynomialFirst.checkPolynomial()) {
                    TreeMap<Integer, Double> resultOfSum = Model.sumOfPolynomials(polynomialFirst, polynomialSecond);
                    view.resultPolynomialTextField.setForeground(Color.BLACK);
                        view.resultPolynomialTextField.setText(Polynomial.prettyPrintPolynomial(resultOfSum));
                } else {
                    view.resultPolynomialTextField.setText("Use only x as variable");
                    view.resultPolynomialTextField.setForeground(new Color(194, 15, 2));
                }
            }
        }
    }

    public class DiffActionOfButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String first = view.firstPolynomialTextField.getText();
            String second = view.secondPolynomialTextField.getText();
            if (first.isEmpty() || second.isEmpty()) {
                view.resultPolynomialTextField.setText("  Missing some input");
                view.resultPolynomialTextField.setForeground(new Color(194, 15, 2));
            } else {
                Polynomial polynomialFirst = new Polynomial(first);
                Polynomial polynomialSecond = new Polynomial(second);
                if (polynomialSecond.checkPolynomial() && polynomialFirst.checkPolynomial()) {
                    TreeMap<Integer, Double> resultOfSum = Model.difOfPolynomials(polynomialFirst, polynomialSecond);
                    view.resultPolynomialTextField.setForeground(Color.BLACK);
                    view.resultPolynomialTextField.setText(Polynomial.prettyPrintPolynomial(resultOfSum));
                } else {
                    view.resultPolynomialTextField.setText("Use only x as variable");
                    view.resultPolynomialTextField.setForeground(new Color(194, 15, 2));
                }
            }
        }
    }

    public class MultiplicationActionOfButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String first = view.firstPolynomialTextField.getText();
            String second = view.secondPolynomialTextField.getText();
            if (first.isEmpty() || second.isEmpty()) {
                view.resultPolynomialTextField.setText("  Missing some input");
                view.resultPolynomialTextField.setForeground(new Color(194, 15, 2));
            } else {
                Polynomial polynomialFirst = new Polynomial(first);
                Polynomial polynomialSecond = new Polynomial(second);
                if (polynomialSecond.checkPolynomial() && polynomialFirst.checkPolynomial()) {
                    TreeMap<Integer, Double> resultOfSum = Model.multiplicationOfPolynomials(polynomialFirst, polynomialSecond);
                    view.resultPolynomialTextField.setForeground(Color.BLACK);
                    view.resultPolynomialTextField.setText(Polynomial.prettyPrintPolynomial(resultOfSum));
                } else {
                    view.resultPolynomialTextField.setText("Use only x as variable");
                    view.resultPolynomialTextField.setForeground(new Color(194, 15, 2));
                }
            }
        }
    }

    public class DivisionActionOfButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String first = view.firstPolynomialTextField.getText();
            String second = view.secondPolynomialTextField.getText();
            if (!second.equals("0")) {
                if (first.isEmpty() || second.isEmpty()) {
                    view.resultPolynomialTextField.setText("  Missing some input");
                    view.resultPolynomialTextField.setForeground(new Color(194, 15, 2));
                } else {
                    Polynomial polynomialFirst = new Polynomial(first);
                    Polynomial polynomialSecond = new Polynomial(second);
                    if (polynomialSecond.checkPolynomial() && polynomialFirst.checkPolynomial()) {
                        Model.PolynomialDivisionResult result = Model.divisionOfPolynomial(polynomialFirst, polynomialSecond);
                        view.resultPolynomialTextField.setForeground(Color.BLACK);
                        view.resultPolynomialTextField.setText("Q:" + Polynomial.prettyPrintPolynomial(result.getQuotient()) + "  R:" +
                                Polynomial.prettyPrintPolynomial(result.getRemainder()));
                    } else {
                        view.resultPolynomialTextField.setText("Use only x as variable");
                        view.resultPolynomialTextField.setForeground(new Color(194, 15, 2));
                    }
                }
            } else if (second.equals("0")) {
                view.resultPolynomialTextField.setText("     Can't divide by 0");
                view.resultPolynomialTextField.setForeground(new Color(194, 15, 2));
            }
        }
    }

    public class DerivateActionOfButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String first = view.firstPolynomialTextField.getText();
            if (first.isEmpty()) {
                view.secondPolynomialLabel.setText("Mandatory the first polynomial");
                view.secondPolynomialLabel.setForeground(new Color(194, 15, 2));
                view.resultPolynomialTextField.setText("  Missing some input");
                view.resultPolynomialTextField.setForeground(new Color(194, 15, 2));
            } else {
                Polynomial polynomialFirst = new Polynomial(first);
                if (polynomialFirst.checkPolynomial()) {
                    TreeMap<Integer, Double> result = Model.derivateOfPolynomial(polynomialFirst);
                    view.resultPolynomialTextField.setForeground(Color.BLACK);
                    view.resultPolynomialTextField.setText(Polynomial.prettyPrintPolynomial(result));
                } else {
                    view.resultPolynomialTextField.setText("Use only x as variable");
                    view.resultPolynomialTextField.setForeground(new Color(194, 15, 2));
                }
            }
        }
    }

    public class IntegrateActionOfButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String first = view.firstPolynomialTextField.getText();
            if (first.isEmpty()) {
                view.secondPolynomialLabel.setText("Mandatory the first polynomial");
                view.secondPolynomialLabel.setForeground(new Color(194, 15, 2));
                view.resultPolynomialTextField.setText("  Missing some input");
                view.resultPolynomialTextField.setForeground(new Color(194, 15, 2));
            } else {
                Polynomial polynomialFirst = new Polynomial(first);
                if (polynomialFirst.checkPolynomial()) {
                    TreeMap<Integer, Double> result = Model.integrationOfPolynomial(polynomialFirst);
                    view.resultPolynomialTextField.setForeground(Color.BLACK);
                    view.resultPolynomialTextField.setText(Polynomial.prettyPrintPolynomial(result));
                } else {
                    view.resultPolynomialTextField.setText("Use only x as variable");
                    view.resultPolynomialTextField.setForeground(new Color(194, 15, 2));
                }
            }
        }
    }


}
