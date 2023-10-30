public class Main {

    public static void main(String[] args) {
        CriticalThread[] ths;

        WaitingRoom lobby = new WaitingRoom();

        ths = new CriticalThread[10];

        for (int i = 0; i < ths.length; i++) {
            ths[i] = new CriticalThread(lobby, 200, i);
        }

        new Window(ths, "Thread States");
    }

}