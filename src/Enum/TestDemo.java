package Enum;

public class TestDemo {

    public static void main(String[] args) {
       Demo.valueOf("a");
        for (Demo el:Demo.values()
             ) {
            System.out.println(el);
        }
    }
}
