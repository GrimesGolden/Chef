package chef;

public class CookOne implements Runnable{
    private Counter counter;

    public CookOne(Counter counter) throws InterruptedException {
        this.counter = counter;
    }

    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " is ready to prepare omelette. Thread One Activated!");
            counter.cookOneServe();

            try {
                Thread.sleep(1000); // change to 100 to see changes.
            } catch (InterruptedException e) {
            }
        }
    }
}
