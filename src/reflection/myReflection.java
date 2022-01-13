package reflection;

import javax.crypto.MacSpi;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class myReflection {
    public static void main(String[] args)  {
        ArrayList<Integer> myListInteger = new ArrayList<>();

        // первый способ получения обЪекта класс
        Class<ArrayList> arrayListClass = ArrayList.class;
        //-----------------------

        // второй способ  получения обЪекта класс
        Class<? extends ArrayList> arrayListClassTwo = myListInteger.getClass();
        //------------------

        // третий способ  получения обЪекта класс

        try {
            Class<?> arrayListClassThree = Class.forName("java.util.ArrayList");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //-------------------------------------------------------
        //-------------------------------------------------------
        //взять модификатор доступа
         int  modifucation = arrayListClass.getModifiers();
         System.out.println(modifucation);
        // модифильтр класс для отображения модификаторов доступа в рефлексии
        System.out.println(Modifier.constructorModifiers());
        System.out.println(Modifier.isPublic(modifucation));
        //----------------------
        //------взять родителей
        System.out.println(arrayListClass.getSuperclass());
        //------взять инткрфейса
        System.out.println(arrayListClass.getInterfaces());



    }



}



