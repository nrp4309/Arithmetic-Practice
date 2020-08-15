import javax.swing.*;

public class System {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Arithmetic Practice");
        frame.setContentPane(new Display().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
