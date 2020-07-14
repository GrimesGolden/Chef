package chef;


public class Counter {
    private boolean mushrooms = false;
    private boolean ham = false;
    private boolean cheese = false;
    private boolean cookOneCanServe = false;
    private boolean cookTwoCanServe = false;
    private boolean cookThreeCanServe = false;
    private String ingredientName = null;
    private int count = 1;

    //@param integer corresponding to the ingredient specified by the agent
    public synchronized void place(Object i){
        while(hasContents()|| count == 21){
            try{
                wait();
            }
            catch(InterruptedException e){
                return;
            }
        }

        placeIngredients((int)i);
        System.out.println(Thread.currentThread().getName() + " has placed " + ingredientName +" on the counter");
        if(hasContents()){
            notifyAll();
        }
    }

    public synchronized void cookOneServe(){
        while (!hasContents()|| !cookOneCanServe) {
            try {
                wait();
            } catch (InterruptedException e) {
                return;
            }
        }
        System.out.println("Cook Two made and served an omelette");
        System.out.println("End of ticket: " + count++ + "\n");
        clearCounter();
        notifyAll();
    }

    public synchronized void cookTwoServe(){
        while (!hasContents()|| !cookTwoCanServe) {
            try {
                wait();
            } catch (InterruptedException e) {
                return;
            }
        }
        System.out.println("Cook Two made and served an omelette");
        System.out.println("End of ticket: " + count+++ "\n");
        clearCounter();
        notifyAll();
    }

    public synchronized void cookThreeServe(){
        while (!hasContents()|| !cookThreeCanServe) {
            try {
                wait();
            } catch (InterruptedException e) {
                return;
            }
        }
        System.out.println("Cook Three made and served an omelette");
        System.out.println("End of ticket: " + count++ + "\n");

        clearCounter();
        notifyAll();
    }


    private boolean hasContents(){
        if(mushrooms&&ham){
            cookOneCanServe = true;
            return true;
        }
        if(mushrooms&&cheese){
            cookTwoCanServe = true;
            return true;
        }
        if(ham&&cheese){
            cookThreeCanServe = true; // debug
            return true;
        }
        return false;
    }

    //matches the int with the ingredient and checks if an input is valid.
    private boolean placeIngredients(int i){
        if(i==1){
            mushrooms = true;
            ingredientName = "Mushrooms";
            return true;
        }
        if(i==2){
            ham = true;
            ingredientName = "Ham";
            return true;
        }
        if(i==3){
            cheese = true;
            ingredientName = "Cheese";
            return true;
        }
        return false;
    }
    private void clearCounter(){
        mushrooms = false;
        ham = false;
        cheese = false;

        cookOneCanServe = false;
        cookTwoCanServe = false;
        cookThreeCanServe = false;
    }
}