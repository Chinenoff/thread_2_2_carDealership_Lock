import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Store {

    private final int SIZECARSHOP = 3;
    private int product = 0;
    final Lock lock = new ReentrantLock();
    final Condition condition = lock.newCondition();

    //метод покупки авто
    public void get(int idBayer) {
        try {
            lock.lock();
            while (product < 1) {
                System.out.println("Машин нет");
                condition.await();
            }
            product--;
            System.out.println("Покупатель " + idBayer + " уехал на новеньком авто");
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    //метод производства авто
    public synchronized void put() {
        try {
            lock.lock();
            while (product >= SIZECARSHOP) {
                condition.wait();
            }
            product++;
            System.out.println("Производитель Toyota выпустил 1 авто");
            System.out.println("Машин на складе: " + product);
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}