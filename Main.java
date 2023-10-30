import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        String strThreads = JOptionPane.showInputDialog("Number of threads:");
        int nThreads = Integer.parseInt(strThreads);

        String strWait = JOptionPane.showInputDialog("How many millis will it wait:");
        int nWait = Integer.parseInt(strWait);

        CriticalThread[] ths;

        WaitingRoom lobby = new WaitingRoom();

        ths = new CriticalThread[nThreads];

        for (int i = 0; i < ths.length; i++) {
            ths[i] = new CriticalThread(lobby, nWait, i);
        }

        new Window(ths, "Thread States");
    }

}