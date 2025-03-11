import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window08Calculator extends JFrame implements ActionListener {
    Container container;
    JTextField numA, numB, result;

    public static final String ADD = "Add";
    public static final String SUBTRACT = "Subtract";
    public static final String DIVIDE = "Divide";
    public static final String MULTIPLY = "Multiply";
    public static final String EXIT = "Exit";

    public Window08Calculator() throws HeadlessException {
        super("Calculator");
        container = getContentPane();
        container.setLayout(new BorderLayout());
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu menu = new JMenu("Operations");
        JMenu closeMenu = new JMenu("Close");

        JMenuItem itemAdd = new JMenuItem(ADD);
        JMenuItem itemSubst = new JMenuItem(SUBTRACT);
        JMenuItem itemDiv = new JMenuItem(DIVIDE);
        JMenuItem itemMulti = new JMenuItem(MULTIPLY);
        JMenuItem itemExit = new JMenuItem(EXIT);

        menu.add(itemAdd);
        menu.add(itemSubst);
        menu.add(itemDiv);
        menu.add(itemMulti);
        closeMenu.add(itemExit);

        menuBar.add(menu);
        menuBar.add(closeMenu);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(new JLabel("Number A: "));
        panel.add(numA = new JTextField(5));
        panel.add(new JLabel("Number B: "));
        panel.add(numB = new JTextField(5));
        panel.add(new JLabel("Result: "));
        panel.add(result = new JTextField(10));
        result.setEditable(false);

        container.add(panel, BorderLayout.CENTER);

        itemAdd.addActionListener(this);
        itemSubst.addActionListener(this);
        itemDiv.addActionListener(this);
        itemMulti.addActionListener(this);
        itemExit.addActionListener(actionEvent -> System.exit(0));
        setVisible(true);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Window08Calculator();
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        float a = Float.parseFloat(numA.getText());
        float b = Float.parseFloat(numB.getText());
        String operation = actionEvent.getActionCommand();
        switch (operation) {
            case ADD:
                result.setText(String.valueOf(a + b));
                break;
            case SUBTRACT:
                result.setText(String.valueOf(a - b));
                break;
            case DIVIDE:
                if(b == 0) {
                    result.setText("Error: Division by zero");
                    throw new ArithmeticException("Division by zero");
                }
                result.setText(String.valueOf(a / b));
                break;
            case MULTIPLY:
                result.setText(String.valueOf(a * b));
                break;
        }
    }
}
