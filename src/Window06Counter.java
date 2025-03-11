import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window06Counter extends JFrame implements ActionListener {
    private int counter;
    private final JLabel label = new JLabel("Counter: 0");
    public Window06Counter() throws HeadlessException {
        super("Counter");

        Container panel = this.getContentPane();
        JButton button = new JButton("Increment");
        JButton button1 = new JButton("Decrement");
        JButton button2 = new JButton("Reset");
        panel.add(button);
        panel.add(label);
        panel.add(button1);
        panel.add(button2);
        panel.setLayout(new FlowLayout());
        button.addActionListener(this);
        button1.addActionListener(actionEvent -> {
            counter--;
            label.setText("Counter: " + counter);
        });
        button2.addActionListener(actionEvent -> {
            counter = 0;
            label.setText("Counter: " + counter);
        });
        setVisible(true);
        setSize(400, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Window06Counter();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        counter++;
        label.setText("Counter: " + counter);
    }
}
