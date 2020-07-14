package chef;

public class CookTwo implements Runnable {
    private Counter counter;

    public CookTwo(Counter counter) throws InterruptedException {
        this.counter = counter;
    }

    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " is ready to prepare omelette. Thread Two Activated!");
            counter.cookTwoServe();

            try {
                Thread.sleep(1000); // change to 100 to see changes.
            } catch (InterruptedException e) {
            }
        }
    }
}

