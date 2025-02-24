import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window01Button extends JFrame implements ActionListener {
    public Window01Button() {
        super("Button Window");
        setSize(200, 100);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JButton button = new JButton("Click me!");
        button.setSize(100, 50);
        button.addActionListener(this);
        getContentPane().add(button);
    }
    public static void main(String[] args) {
        new Window01Button();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println("Button clicked!");
    }
}
