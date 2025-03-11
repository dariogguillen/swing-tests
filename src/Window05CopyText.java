import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window05CopyText extends JFrame {

    JTextField fieldValue, result;

    public Window05CopyText() throws HeadlessException {
        super("Ejemplo de copiar texto");
        Container panel = this.getContentPane();
        panel.setLayout(new FlowLayout());
        panel.add(new JLabel("Valor: "));
        panel.add(fieldValue = new JTextField(5));

        JButton button = new JButton("Copiar");
        button.addActionListener(new CopyTextActionListener());
        panel.add(button);
        panel.add(result = new JTextField(5));

        setSize(400, 150);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
       JFrame frame = new Window05CopyText();
    }

    private class CopyTextActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String value = fieldValue.getText();
            result.setText(value);
        }
    }
}
