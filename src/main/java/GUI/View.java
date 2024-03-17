package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

import java.awt.Color;


public class View extends JFrame {
    public JPanel panel;
    public JTextField firstPolynomialTextField;
    public JTextField secondPolynomialTextField;
    public JTextField resultPolynomialTextField;
    public JLabel titleLabel;
    public JLabel firstPolynomialLabel;
    public JLabel secondPolynomialLabel;
    public JLabel resultPolynomialLabel;
    public JButton sumButton;
    public JButton differenceButton;
    public JButton multiplicationButton;
    public JButton divisionButton;
    public JButton integrateButton;
    public JButton derivateButton;


    public View() {
        setTitle("Polynomial Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 550));


        panel = new JPanel();
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.setLayout(null);

        firstPolynomialTextField = new JTextField();
        firstPolynomialTextField.setBounds(150, 100, 200, 30);
        firstPolynomialTextField.setFont(new Font("Arial", Font.BOLD, 18));
        firstPolynomialTextField.setBackground(new Color(144, 238, 144));

        secondPolynomialTextField = new JTextField();
        secondPolynomialTextField.setBounds(150, 160, 200, 30);
        secondPolynomialTextField.setFont(new Font("Arial", Font.BOLD, 18));
        secondPolynomialTextField.setBackground(new Color(144, 238, 144));

        resultPolynomialTextField = new JTextField();
        resultPolynomialTextField.setBounds(150, 220, 200, 30);
        resultPolynomialTextField.setFont(new Font("Arial", Font.BOLD, 18));
        resultPolynomialTextField.setBackground(new Color(144, 238, 144));

        titleLabel = new JLabel("Polynomial Calculator");
        titleLabel.setBounds(120, 0, 400, 30);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 25));

        firstPolynomialLabel = new JLabel("First Polynomial (mandatory)");
        firstPolynomialLabel.setBounds(110, 70, 400, 30);
        firstPolynomialLabel.setFont(new Font("Arial", Font.BOLD, 20));

        secondPolynomialLabel = new JLabel("Second Polynomial (optional)");
        secondPolynomialLabel.setBounds(110, 130, 400, 30);
        secondPolynomialLabel.setFont(new Font("Arial", Font.BOLD, 20));

        resultPolynomialLabel = new JLabel("Polynomial after computing");
        resultPolynomialLabel.setBounds(115, 190, 400, 30);
        resultPolynomialLabel.setFont(new Font("Arial", Font.BOLD, 20));

        sumButton = new JButton("+");
        sumButton.setBounds(177, 300, 50, 50);
        sumButton.setFont(new Font("Arial", Font.BOLD, 20));
        sumButton.setBackground(new Color(144, 238, 144));

        differenceButton = new JButton("-");
        differenceButton.setBounds(227, 300, 50, 50);
        differenceButton.setFont(new Font("Arial", Font.BOLD, 20));
        differenceButton.setBackground(new Color(144, 238, 144));

        multiplicationButton = new JButton("*");
        multiplicationButton.setBounds(277, 300, 50, 50);
        multiplicationButton.setFont(new Font("Arial", Font.BOLD, 20));
        multiplicationButton.setBackground(new Color(144, 238, 144));

        divisionButton = new JButton("/");
        divisionButton.setBounds(177, 350, 50, 50);
        divisionButton.setFont(new Font("Arial", Font.BOLD, 20));
        divisionButton.setBackground(new Color(144, 238, 144));

        derivateButton = new JButton("dp1/dx");
        derivateButton.setBounds(227, 350, 100, 50);
        derivateButton.setFont(new Font("Arial", Font.BOLD, 20));
        derivateButton.setBackground(new Color(144, 238, 144));

        integrateButton = new JButton("∫(p1)dx");
        integrateButton.setBounds(177, 400, 150, 50);
        integrateButton.setFont(new Font("Arial", Font.BOLD, 20));
        integrateButton.setBackground(new Color(144, 238, 144));

        panel.add(firstPolynomialTextField);
        panel.add(secondPolynomialTextField);
        panel.add(resultPolynomialTextField);
        panel.add(titleLabel);
        panel.add(firstPolynomialLabel);
        panel.add(secondPolynomialLabel);
        panel.add(resultPolynomialLabel);
        panel.add(sumButton);
        panel.add(differenceButton);
        panel.add(multiplicationButton);
        panel.add(divisionButton);
        panel.add(derivateButton);
        panel.add(integrateButton);
        panel.setBackground(Color.LIGHT_GRAY);
        getContentPane().add(panel);

        Image icon = Toolkit.getDefaultToolkit().getImage("src/main/java/GUI/calculator.png");
        setIconImage(icon);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    public void sumButtonListener(ActionListener actionListener) {
        sumButton.addActionListener(actionListener);
    }

    public void difButtonListener(ActionListener actionListener) {
        differenceButton.addActionListener(actionListener);
    }

    public void multiplicationButtonListener(ActionListener actionListener) {
        multiplicationButton.addActionListener(actionListener);
    }

    public void divisonButtonListener(ActionListener actionListener) {
        divisionButton.addActionListener(actionListener);
    }

    public void derivateButtonListener(ActionListener actionListener) {
        derivateButton.addActionListener(actionListener);
    }

    public void integrateButtonListener(ActionListener actionListener) {
        integrateButton.addActionListener(actionListener);
    }


}
