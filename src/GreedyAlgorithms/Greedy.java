package GreedyAlgorithms;


import java.util.*;

public class Greedy {


    static HashMap<Integer, Integer> cush = new HashMap<>();
    static {

        cush.put(5, 150);
//        cush.put(10, 2);
//        cush.put(25, 8);
//        cush.put(50, 2);
//        cush.put(100, 6);
//        cush.put(250, 3);
        cush.put(500, 3);
    }

    public static void main(String[] args) {
        int allSum = 550;
        int allCoint = 0;
        boolean flag = false;
        boolean flagAdd = false;
        boolean itter = true;
        prinf(cush);
        TreeMap<Integer,Integer> sortCush = new TreeMap<>(Comparator.reverseOrder());
        sortCush.putAll(cush);
        System.out.println("-----------");
       // prinf(sortCush);

       //---------------------------
        TreeMap<Integer,Integer> sortCushRes = new TreeMap<>(Comparator.reverseOrder());
        Iterator<Map.Entry<Integer, Integer>> iterator = sortCush.entrySet().iterator();
        Map.Entry<Integer ,Integer> entry = null;

        while (iterator.hasNext()){
          //  if(!flagAdd )  entry = iterator.next();
            entry = iterator.next();
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
                    sortCush.put(coint, qualCoint - 1);
                    if(sortCushRes.containsKey(coint)){
                        sortCushRes.put(coint,sortCushRes.get(coint) + 1);
                    }
                    else{
                    sortCushRes.put(coint,1);
                    }
                    flag = true;
                    System.out.println(sortCushRes);
                    break;
                }
                //-------если результат вычитания больше нуля то есть ещё нужно денег
                else if(sub > 0){
                    //-------кладём монетку в мапу отавляем уже набраное число
                    // и нужно ещё раз взять туже бумажку
                    // и нужно удалить бумажку из манипулятора
                    if(sortCushRes.containsKey(coint)){
                    sortCushRes.put(coint,sortCushRes.get(coint) + 1);
                    }
                    else{
                        sortCushRes.put(coint,1);
                    }
                    sortCush.put(coint, qualCoint - 1);
                  //  flagAdd = true;
                    iterator = sortCush.entrySet().iterator();// это получаеться не на это место вернуться  с начала

                }
                //---------если результат вычитания меньше нуля то есть перебор
                else {
                    //----------из общей суммы уже набранных монет вычитаем эту монету то есть возвращаем назад
                    // и нужно взять следущию бумажку наминалом поменьше
                      // flagAdd = false;
                       allCoint -= coint;
                }

            }
            //if(qualCoint == 0) flagAdd = false;
            //if(flagAdd) continue;
        }

        //----------всю мапу пробежали если сумма набалось тогда ок если нет исключение
        if(flag) {
            System.out.println("Получилось!!");
            prinf(sortCushRes);
            System.out.println("Осталось");
            prinf(sortCush);

        }
        else {
            System.out.println("лажа не набролось выкинуть прерывание");
        }




        }







    static void prinf(Map<Integer,Integer> map){
        for (Map.Entry<Integer,Integer> el: map.entrySet()){
            System.out.print(el.getKey() + " " + el.getValue());
            System.out.println();
        }
    }
}
