import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window07CurrencyConverter extends JFrame implements ActionListener {
    Container panel;
    JButton buttonEuros, buttonUsd, buttonReset;
    JTextField amount;

    public static final String USD = "USD";
    public static final String EUROS = "Euros";
    public Window07CurrencyConverter() throws HeadlessException {
        super("Currency Converter");
        panel = this.getContentPane();
        panel.setLayout(new FlowLayout());
        panel.add(amount = new JTextField(5));
        panel.add(buttonEuros = new JButton(EUROS));
        panel.add(buttonUsd = new JButton(USD));
        panel.add(buttonReset = new JButton("Reset"));
        buttonEuros.addActionListener(this);
        buttonUsd.addActionListener(this);
        buttonReset.addActionListener(actionEvent -> {
            amount.setText("");
            panel.setBackground(Color.WHITE);
        });
        setSize(400, 150);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        float value = Float.parseFloat(amount.getText());
        String textCurrency = actionEvent.getActionCommand();
        if (textCurrency.equals(USD)) {
            amount.setText(String.valueOf((float)(value * 0.049)));
            panel.setBackground(Color.GREEN);
        } else if (textCurrency.equals(EUROS)) {
            amount.setText(String.valueOf((float)(value * 0.071)));
            panel.setBackground(Color.BLUE);
        }
    }

    public static void main(String[] args) {
        new Window07CurrencyConverter();
    }
}
