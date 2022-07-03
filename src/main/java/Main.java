public class Main {

    private static final int NUMBERBAYER = 4;
    private static final int DELAY_CAR_BAYER = 45;

    public static void main(String[] args) throws Exception {
        //создаём склад
        Store store = new Store();

        //генерируем покупателей
        for (int i = 1; i <= NUMBERBAYER; i++) {
            CarBuyerThread carBuyerThread = new CarBuyerThread(store, i);
            System.out.println("Покупатель " + i + " зашел в автосалон");
            carBuyerThread.start();
            Thread.sleep(DELAY_CAR_BAYER);
        }

        //запускаем производство машин
        CarDeveloperThread carDeveloperThread = new CarDeveloperThread(store);
        carDeveloperThread.setName("Производитель");
        carDeveloperThread.start();

    }
}