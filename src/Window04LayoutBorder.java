import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window04LayoutBorder extends JFrame {
    public Window04LayoutBorder() {
        super("Button Window");

        JPanel panel = new JPanel(new BorderLayout(8, 4));

        JButton button = new JButton("Click me! ");
        button.setSize(200, 100);
        button.addActionListener(e -> System.out.println("Button clicked!"));
        button.addActionListener(new BActionListener());
        panel.add(button, BorderLayout.CENTER);
        panel.add(new Button("North"), BorderLayout.NORTH);
        panel.add(new Button("South"), BorderLayout.SOUTH);
        panel.add(new Button("West"), BorderLayout.WEST);
        panel.add(new Button("East"), BorderLayout.EAST);

        setContentPane(panel);

        setSize(600, 200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new Window04LayoutBorder();
    }

    private static class BActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            System.out.println("Button clicked2!");
            Toolkit.getDefaultToolkit().beep();
        }
    }
}
