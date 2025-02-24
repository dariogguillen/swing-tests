import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window01Button extends JFrame {
    public Window01Button() {
        super("Button Window");
        setSize(200, 100);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JButton button = new JButton("Click me!");
        button.setSize(100, 50);
        button.addActionListener(e -> System.out.println("Button clicked!"));
        button.addActionListener(new BActionListener());
        getContentPane().add(button);
    }
    public static void main(String[] args) {
        new Window01Button();
    }

    private static class BActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            System.out.println("Button clicked2!");
            Toolkit.getDefaultToolkit().beep();
        }
    }
}
