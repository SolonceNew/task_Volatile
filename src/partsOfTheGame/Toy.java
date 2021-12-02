package partsOfTheGame;

public class Toy extends Thread{
    private final Box box;

    public Toy(String name, Box box) {
        super(name);
        this.box = box;
    }

    @Override
    public void run() {
        box.off();
    }
}
