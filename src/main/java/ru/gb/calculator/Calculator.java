package ru.gb.calculator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Calculator extends JFrame {

    private final JLabel display;
    private Double leftOperand;
    private Double rightOperand;
    private String operation;

    public static void main(String[] args) {
        new Calculator();
    }

    public Calculator() {
        setTitle("Hello world");
        setBounds(300, 300, 500, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        final ActionListener numberActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final JButton source = (JButton) e.getSource();
                final String text = source.getText();
                String displayText = display.getText();

                if (".".equals(text) && displayText.contains(".")) {
                    return;
                }
                if ("0".equals(displayText)) {
                    displayText = "";
                }
                displayText += text;
                display.setText(displayText);
            }
        };

        final JPanel numberPanel = new JPanel();
        final GridLayout numberLayout = new GridLayout(4, 3, 10, 10);
        numberPanel.setLayout(numberLayout);

        final JPanel buttonPanel = new JPanel();
        final GridLayout buttonLayout = new GridLayout(4, 3, 10, 10);
        buttonPanel.setLayout(buttonLayout);

//        final JPanel buttonPanel1 = new JPanel();
//        final GridLayout buttonLayout1 = new GridLayout(4, 1, 10, 10);
//        buttonPanel.setLayout(buttonLayout1);

        for (int i = 1; i <= 10; i++) {
            if (i ==10) {
                JButton button = new JButton(String.valueOf(0));
                button.addActionListener(numberActionListener);
                numberPanel.add(button);
            } else{
                JButton button = new JButton(String.valueOf(i));
                button.addActionListener(numberActionListener);
                numberPanel.add(button);
            }
        }

        final ActionListener plusMinActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final JButton source = (JButton) e.getSource();
                final String text = source.getText();
                String displayText = display.getText();
                if ("+/-".equals(text)) {
                    double displayText1 = Double.parseDouble(displayText);
                    display.setText(String.valueOf(displayText1 *(-1)));
                }else if("П".equals(text)){
                    display.setText(String.valueOf(Math.PI));
                }
            }
        };

        final JButton pointButton = new JButton(".");
        numberPanel.add(pointButton);
        pointButton.addActionListener(numberActionListener);
        final JButton plusMin = new JButton("+/-");
        numberPanel.add(plusMin);
        plusMin.addActionListener(plusMinActionListener);

        final ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final JButton source = (JButton) e.getSource();
                final String text = source.getText();
                if ("=".equals(text)) {
                    rightOperand = Double.parseDouble(display.getText());
                    if (leftOperand != null) {
                        switch (operation) {
                            case "+":
                                display.setText(String.valueOf(leftOperand + rightOperand));
                                break;
                            case "-":
                                display.setText(String.valueOf(leftOperand - rightOperand));
                                break;
                            case "*":
                                display.setText(String.valueOf(leftOperand * rightOperand));
                                break;
                            case "/":
                                display.setText(String.valueOf(leftOperand / rightOperand));
                                break;
                            case "x^n":
                                display.setText(String.valueOf(Math.pow(leftOperand,rightOperand)));
                                break;
                            case "log(x)n":
                                display.setText(String.valueOf(Math.log(rightOperand)/Math.log(leftOperand)));
                                break;
                            case "n-sqrt(x)":
                                display.setText(String.valueOf(Math.pow(leftOperand, 1/rightOperand)));
                                break;
                        }
                        leftOperand = Double.parseDouble(display.getText());
                        rightOperand = null;
                        operation = null;
                        numberPanel.disable();
                    }
                    return;
                }
                leftOperand = Double.parseDouble(display.getText());
                display.setText("0");
                operation = text;
            }
        };

        for (char c : "C+-*/=".toCharArray()) {
            final JButton button = new JButton(String.valueOf(c));
            button.addActionListener(actionListener);
            buttonPanel.add(button);
        }
        final JButton degree= new JButton("x^n");
        buttonPanel.add(degree);
        degree.addActionListener(actionListener);

        final JButton log= new JButton("log(x)n");
        buttonPanel.add(log);
        log.addActionListener(actionListener);

        final JButton sqrt = new JButton("n-sqrt(x)");
        buttonPanel.add(sqrt);
        sqrt.addActionListener(actionListener);

        final JButton pi = new JButton("П");
        buttonPanel.add(pi);
        pi.addActionListener(actionListener);

        display = new JLabel("0");
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setFont(new Font("Arial", Font.BOLD, 17));
        add(display, BorderLayout.NORTH);
        add(numberPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.EAST);
        //add(buttonPanel1, BorderLayout.WEST);

        setVisible(true);
    }
}
