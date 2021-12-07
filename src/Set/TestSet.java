package Set;

import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class TestSet {
    public static void main(String[] args) {
        NavigableSet set =  new TreeSet();
        set.add(1);
        set.add(2);
        set.add(1);
        Set one =  set.descendingSet();
        System.out.println(set);
        System.out.println(one);

    }
}
