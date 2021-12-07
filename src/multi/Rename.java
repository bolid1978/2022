package multi;

public class Rename implements Runnable {

    volatile    static    int z = 0;

    public int getZ() {
        return z;
    }

    @Override
    public void run() {
        z = 25;
    }

    public static void main(String[] args) {
        Rename rename = new Rename();
        out o = new out();

        Thread one = new Thread(rename);
        Thread two = new Thread(o);
        two.start();
        one.start();






    }




}
