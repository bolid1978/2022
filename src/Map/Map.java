package Map;

import java.util.HashMap;

public class Map {

    public static void main(String[] args) {
        HashMap <Integer,String> map = new HashMap<>();
        System.out.println(map.put(1, "одни"));
        System.out.println(map.put(2, "два"));
        System.out.println(map.put(3, "три"));
        System.out.println(map.put(2, "второй раз два"));
        System.out.println(map);

    }
}
