public class CarDeveloperThread extends Thread {

    private static final long DELAY_CAR_DEVELOP = 100;
    private static final int MAXNUM_CAR = 6;

    private Store store;
    //ReentrantLock locker;

    CarDeveloperThread(Store store) {
        this.store = store;
    }

    public void run() {
        for (int i = 1; i < MAXNUM_CAR; i++) {
            store.put();
            try {
                Thread.sleep(DELAY_CAR_DEVELOP);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

