public class CarDeveloperThread extends Thread {

    private final long DELAY_CAR_DEVELOP = 100;
    private final int MAXNUMCAR = 6;

    Store store;
    //ReentrantLock locker;

    CarDeveloperThread(Store store) {
        this.store = store;
    }

    public void run() {
        for (int i = 1; i < MAXNUMCAR; i++) {
            store.put();
            try {
                Thread.sleep(DELAY_CAR_DEVELOP);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

