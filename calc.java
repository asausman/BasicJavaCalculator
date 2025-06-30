import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class calc1 extends JFrame implements ActionListener {
    JTextField textField;
    double num1, num2, result;
    char operator;

    calc1() {
        setTitle("Basic Java Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 30));
        textField.setEditable(false);
        add(textField, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "CLEAR", "=", "+"
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.BOLD, 24));
            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String input = e.getActionCommand();

        if (input.charAt(0) >= '0' && input.charAt(0) <= '9') {
            textField.setText(textField.getText() + input);
        } else if (input.equals("C")) {
            textField.setText("");
        } else if (input.equals("=")) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/': 
                    if (num2 == 0) {
                        textField.setText("Error: Divide by 0");
                        return;
                    }
                    result = num1 / num2; break;
            }
            textField.setText(String.valueOf(result));
        } else {
          
            num1 = Double.parseDouble(textField.getText());
            operator = input.charAt(0);
            textField.setText("");
        }
    }

    public static void main(String[] args) {
        new calc1();
    }
}
