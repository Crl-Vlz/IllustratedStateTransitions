import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Info extends JFrame {

    public Info() {

        this.setSize(800, 800);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        panel.add(new JLabel("Universidad Panamericana"));
        panel.add(new JLabel("Fundamentos de Programación en Paralelo"));
        panel.add(new JLabel("Carlos Manuel Vélez - 0240599"));
        panel.add(new JLabel("Miguel Angel Tovar - 0213524"));
        panel.add(new JLabel("Profesor: Juan Carlos Lopez Pimentel"));

        JScrollPane pane = new JScrollPane(panel);
        pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        this.getContentPane().add(pane);
    }

}
