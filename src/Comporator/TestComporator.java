package Comporator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeMap;

public class TestComporator {
    public ArrayList<Avto> SetAvtos() {
        ArrayList<Avto> avtosOne = new ArrayList<Avto>();
        avtosOne.add(new Avto("mersedec", 200, 2, 1000));
        avtosOne.add(new Avto("volvo", 180, 1, 800));
        avtosOne.add(new Avto("bmw", 240, 2, 1200));
        avtosOne.add(new Avto("tayota", 210, 1, 9000));
        avtosOne.add(new Avto("mersedec", 230, 4, 7000));

        return avtosOne;
    }

    static {
        class ComparableName implements Comparator<Avto>{
            @Override
            public int compare(Avto o1, Avto o2) {
                return o1.name.compareTo(o2.name);
            }
        }
        ComparableName comparableName = new ComparableName();
        class ComparableSpeed implements Comparator<Avto>{
            @Override
            public int compare(Avto o1, Avto o2) {
                if(o1.speed == o2.speed) return 0;
                if(o1.speed > o2.speed) return -1;
                else return 1;
            }
        }
        ComparableSpeed comparableSpeed =  new ComparableSpeed();

        TreeMap<Avto,String> treeMap = new TreeMap<>(comparableName.thenComparing(comparableSpeed));

        treeMap.put(new Avto("mersedec", 200, 2, 1000),"one");
        treeMap.put(new Avto("volvo", 180, 1, 800),"two");
        treeMap.put(new Avto("bmw", 240, 2, 1200),"free");
        treeMap.put(new Avto("tayota", 210, 1, 9000),"four");
        treeMap.put(new Avto("mersedec", 230, 4, 7000),"five");

        System.out.println(treeMap);

    }


    public static void main(String[] args) {

        TestComporator testComporator = new TestComporator();
        ArrayList <Avto> avtos = testComporator.SetAvtos();



     //   for (Avto element: avtos
      //       ) {
      //      System.out.println(element);
      //  }
        avtos.sort(new Comparator<Avto>() {
            @Override
            public int compare(Avto o1, Avto o2) {

                return o1.name.compareTo(o2.name);
            }
        }.thenComparing(new Comparator<Avto>() {
            @Override
            public int compare(Avto o1, Avto o2) {
                if(o1.speed == o2.speed) return 0;
                if(o1.speed > o2.speed) return -1;
                else return 1;
            }
        }));
      System.out.println("*****************************");
     //   for (Avto element: avtos
      //  ) {
      //      System.out.println(element);
      //  }


    }





}
