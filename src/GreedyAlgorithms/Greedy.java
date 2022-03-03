package GreedyAlgorithms;

import javax.swing.text.html.parser.Entity;
import java.util.*;

public class Greedy {
    static int a = 12;

    static HashMap<Integer, Integer> cush = new HashMap<>();
    static {

        cush.put(5, 20);
        cush.put(10, 2);
        cush.put(25, 8);
        cush.put(50, 2);
        cush.put(100, 6);
        cush.put(250, 3);
        cush.put(500, 7);
    }

    public static void main(String[] args) {
        int allSum = 700;
        int allCoint = 0;
        boolean flag = false;
        prinf(cush);
        TreeMap<Integer,Integer> sortCush = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                return o2.compareTo(o1);
            }
        });
        sortCush.putAll(cush);
        System.out.println("-----------");
        prinf(sortCush);

       //---------------------------
        TreeMap<Integer,Integer> sortCushRes = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                return o2.compareTo(o1);
            }
        });
        Iterator iterator = sortCush.entrySet().iterator();

        while (iterator.hasNext()){
            Map.Entry<Integer ,Integer> entry = (Map.Entry<Integer ,Integer>)iterator.next();
            //-------берём бумажку
            int coint = entry.getKey();
            //-------берём количество бумажек данного номинала
            int qualCoint = entry.getValue();
            //------если бумажки есть
            if(qualCoint > 0){
                //----------складываем с общим числом монет
                allCoint += coint;
                int sub = allSum - allCoint;
                //-------если результать вычитания из общей суммы 0
                if(sub == 0){
                    //  ---- кладём монетку и выходим то есть отдём мэпу ставим флаг что всё получилось сумма набрана
                    sortCushRes.put(coint,qualCoint + 1);
                    flag = true;
                    System.out.println(sortCushRes);
                }
                //-------если результат вычитания больше нуля то есть ещё нужно денег
                else if(sub > 0){
                    //-------кладём монетку в мапу вычитаем из необходимой суммы уже набраное число
                    sortCushRes.put(coint,qualCoint + 1);
                    allSum -= allCoint;
                }
                //---------если результат вычитания меньше нуля то есть перебор
                else {
                    //----------из общей суммы уже набранных монет вычитаем эту монету то есть возвращаем назад
                       allCoint -= coint;
                }

            }

        }

        //----------всю мапу пробежали если сумма набалось тогда ок если нет исключение
        if(flag) {
            System.out.println("Получилось!!");
            prinf(sortCushRes);

        }
        else {
            System.out.println("лажа");
        }




        }







    static void prinf(Map<Integer,Integer> map){
        for (Map.Entry<Integer,Integer> el: map.entrySet()){
            System.out.print(el.getKey() + " " + el.getValue());
            System.out.println();
        }
    }
}
