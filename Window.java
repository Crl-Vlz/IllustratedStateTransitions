import javax.swing.JFrame;

public class Window extends JFrame {

    private CriticalThread[] ths;

    public Window(CriticalThread[] threads, String name) {
        ths = threads;
        this.setTitle(name);
        this.setVisible(true);
        this.setSize(800, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        Table table = new Table();
        this.getContentPane().add(table);
        for (int i = 0; i < ths.length; i++) {
            table.addThread(ths[i]);
            ths[i].setTable(table);
            ths[i].start();
        }

    }

}
