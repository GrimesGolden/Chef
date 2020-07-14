package chef;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        Thread chef,cookOne,cookTwo,cookThree;

        Counter counter = new Counter();

        chef = new Thread(new Chef(counter),"Chef");
        cookOne = new Thread(new CookOne(counter),"Cook One");
        cookTwo = new Thread(new CookTwo(counter),"Cook Two");
        cookThree = new Thread(new CookThree(counter),"Cook Three");
        chef.start();
        cookOne.start();
        cookTwo.start();
        cookThree.start();
    }
}


