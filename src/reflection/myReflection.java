package reflection;

import javax.crypto.MacSpi;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;

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
        System.out.println(Arrays.toString(arrayListClass.getInterfaces()));

        // ---------информация о классе
        //-----------------------------

         //--------взять публичные поля класса и суперкласса
        System.out.println(Arrays.toString(arrayListClass.getFields()));
        //--------взять все поля но только своего класс
        System.out.println(Arrays.toString(arrayListClass.getDeclaredFields()));
         //---вернёт конкретное поле с конкретным именем или метод  но бросает исклюение если имя не найдено
         //arrayListClass.getField("name field");
        // arrayListClass.getDeclaredField("name field");
        //--------------------------------------------------------

        //------взять публичные методы класса и суперкласса
        System.out.println(Arrays.toString(arrayListClass.getMethods()));
        //------взять все методы но только своего класс
        System.out.println(Arrays.toString(arrayListClass.getDeclaredMethods()));
        //-------------------------------------------------------------

        //--------------конструкторы



    }



}



