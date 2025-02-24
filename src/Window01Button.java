import javax.swing.*;

public class Window01Button extends JFrame {
    public Window01Button() {
        super("Button Window");
        setSize(200, 100);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JButton button = new JButton("Click me!");
        button.setSize(100, 50);
        button.addActionListener(e -> System.out.println("Button clicked!"));
        getContentPane().add(button);
    }
    public static void main(String[] args) {
        new Window01Button();
    }
}
