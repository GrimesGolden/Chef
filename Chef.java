package chef;

import java.util.*;

public class Chef implements Runnable {
    // Simulates a chef placing ingredients on a counter.

    private Set<Integer> selected; //Make sure duplicate ingredients do not end up on counter.
    private Counter counter;

    public Chef(Counter counter) {
        this.counter = counter;
        selected = new HashSet<Integer>();
    }

    private void selectIngredients() {
        // Takes two ingredients at random and places in selected set.
        while(selected.size() < 3) {
            // Choose number at random between 1 and 3.
            int select = 1 + (int)(Math.random() * 3);
            selected.add(select);
        }
    }

    public void run() {
        System.out.println("The tickets are pouring in...get ready lads!\n");
        System.out.println(Thread.currentThread().getName() + " places the Eggs on the counter");

        // Places ingredient on counter 20 times.
        for(int j = 0; j <= 20; j++) {
            selectIngredients();
            for(int i:selected) {
                counter.place(i);
            }
        }
    }
}
