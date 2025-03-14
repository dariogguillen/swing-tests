import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window09Calculator extends JFrame implements ActionListener {

    String total = "";
    String operator = "";
    int aux;
    JLabel result, view;

    public Window09Calculator() throws HeadlessException {
        super("Calculator");
        Container container = getContentPane();
        container.setLayout(new BorderLayout(5, 5));
        JPanel panelTop = new JPanel(new GridLayout(2, 1, 5, 5));
        JPanel panelCenter = new JPanel(new GridLayout(5, 3, 5, 5));
        JPanel panelRight = new JPanel(new GridLayout(5, 1, 5, 5));

        container.add(panelTop, BorderLayout.NORTH);
        container.add(panelCenter, BorderLayout.CENTER);
        container.add(panelRight, BorderLayout.EAST);

        panelTop.add(this.view = new JLabel("", SwingConstants.RIGHT));
        panelTop.add(this.result = new JLabel("0", SwingConstants.RIGHT));

        this.view.setFont(new Font("Serif", Font.PLAIN, 16));
        this.result.setFont(new Font("Serif", Font.BOLD, 20));

        Border border = panelTop.getBorder();
        Border margin = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        panelTop.setBorder(new CompoundBorder(border, margin));

        JButton buttonAdd = new JButton("+");
        JButton buttonSubtract = new JButton("-");
        JButton buttonMultiply = new JButton("*");
        JButton buttonDivide = new JButton("/");
        JButton buttonEquals = new JButton("=");
        JButton buttonClear = new JButton("C");

        panelCenter.add(buttonClear);
        panelCenter.add(new JLabel());
        panelCenter.add(new JLabel());

        for (int i = 9; i >= 0; i--) {
            JButton button = new JButton(String.valueOf(i));
            panelCenter.add(button);
            button.addActionListener(event -> {
                String value = event.getActionCommand();
                total += value;
                this.view.setText(this.view.getText().concat(value));
                System.out.println("Total: " + total);

            });
        }

        panelRight.add(buttonAdd);
        panelRight.add(buttonSubtract);
        panelRight.add(buttonMultiply);
        panelRight.add(buttonDivide);
        panelRight.add(buttonEquals);

        buttonAdd.addActionListener(this);
        buttonSubtract.addActionListener(this);
        buttonMultiply.addActionListener(this);
        buttonDivide.addActionListener(this);

        buttonEquals.addActionListener(event -> {
            int value = 0;
            int numA = this.aux;
            int numB = Integer.parseInt(this.total);
            value = switch (this.operator) {
                case "+" -> numA + numB;
                case "-" -> numA - numB;
                case "*" -> numA * numB;
                case "/" -> numA / numB;
                default -> value;
            };
            this.total = String.valueOf(value);
            this.result.setText(this.total);
        });

        buttonClear.addActionListener(event -> {
            this.total = "";
            this.operator = "";
            this.aux = 0;
            this.view.setText("");
            this.result.setText("0");
        });

        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Window09Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.operator = actionEvent.getActionCommand();
        this.aux = Integer.parseInt(this.total);
        this.total = "";
        this.view.setText(this.view.getText().concat(this.operator));
    }

}
