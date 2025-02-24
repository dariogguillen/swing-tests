import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window02LayoutFlow extends JFrame {
    public Window02LayoutFlow() {
        super("Button Window");

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 20));

        for (int i = 0; i < 10; i++) {
            JButton button = new JButton("Click me! " + i);
            button.setPreferredSize(new Dimension(200, 100));
            button.addActionListener(e -> System.out.println("Button clicked!"));
            button.addActionListener(new BActionListener());
            panel.add(button);
        }

        setContentPane(panel);

        setSize(600, 200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    public static void main(String[] args) {
        new Window02LayoutFlow();
    }

    private static class BActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            System.out.println("Button clicked2!");
            Toolkit.getDefaultToolkit().beep();
        }
    }
}
