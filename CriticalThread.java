public class CriticalThread extends Thread {

    public WaitingRoom lobby;
    public long millis;
    public int nThread;
    private int accesses;
    private boolean isAlive;
    private Table table;

    public CriticalThread(WaitingRoom sharedLobby, long timeToWait) {
        this.lobby = sharedLobby;
        this.millis = timeToWait;
        this.isAlive = true;
        this.accesses = 0;
    }

    public CriticalThread(WaitingRoom sharedLobby, long timeToWait, int thread) {
        this.lobby = sharedLobby;
        this.millis = timeToWait;
        this.isAlive = true;
        this.nThread = thread;
        this.accesses = 0;
    }

    @Override
    public void run() {
        while (isAlive) {

            table.changeState(nThread + 1, 3);

            synchronized (lobby) {
                this.accesses++;
                table.changeState(nThread, "" + this.accesses);
                table.changeState(nThread + 1, 4);
                lobby.enter(millis);
            }

            if (!isAlive) {
                break;
            }

        }
        table.changeState(nThread + 1, 5);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        table.changeState(nThread + 1, 6);
    }

    public void kill() {
        this.isAlive = false;
    }

    public void setTable(Table table) {
        this.table = table;
    }

}
