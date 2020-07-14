package chef;

public class CookThree implements Runnable{
    private Counter counter;

    public CookThree(Counter counter) throws InterruptedException {
        this.counter = counter;
    }

    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " is ready to prepare omelette. Thread Three Activated!");
            counter.cookThreeServe();

            try {
                Thread.sleep(1000); // change to 100 to see changes.
            } catch (InterruptedException e) {
            }
        }
    }
}
