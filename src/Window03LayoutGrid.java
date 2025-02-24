import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window03LayoutGrid extends JFrame {
    public Window03LayoutGrid() {
        super("Button Window");

        JPanel panel = new JPanel(new GridLayout(4,3, 8, 4));

        for (int i = 0; i < 10; i++) {
            JButton button = new JButton("Click me! " + i);
//            button.setPreferredSize(new Dimension(200, 100));
            button.setSize(200, 100);
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
        new Window03LayoutGrid();
    }

    private static class BActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            System.out.println("Button clicked2!");
            Toolkit.getDefaultToolkit().beep();
        }
    }
}
