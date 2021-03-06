public class CarBuyerThread extends Thread {

    private final int idBayer;

    private Store store;

    CarBuyerThread(Store store, int idBayer) {
        this.store = store;
        this.idBayer = idBayer;
    }

    public void run() {
        store.get(idBayer);
    }
}
