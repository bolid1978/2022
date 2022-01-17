package reflection;

import javax.crypto.MacSpi;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class myReflection {
    public static void main(String[] args) {
        ArrayList<Integer> myListInteger = new ArrayList<>();
        myListInteger.add(15);
        myListInteger.add(25);
        myListInteger.add(35);

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
        int modifucation = arrayListClass.getModifiers();
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
        Constructor[] constructor = arrayListClass.getConstructors();
        Constructor[] constructorDecl = arrayListClass.getDeclaredConstructors();
        try {
            Constructor<?> constructorParam = arrayListClass.getConstructor(int.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        //--------- анотоции к методам------------------
        Method[] method = arrayListClass.getMethods();
        for (Method el : method) {
            System.out.print("аннотация метода " + el.getName() + " ");
            System.out.println(Arrays.toString(el.getAnnotations()));
        }
        System.out.println("************");
        //---------вызов метода ----------------------
        try {

            Method methodGet = arrayListClass.getDeclaredMethod("get", int.class);
            Method methodAdd = arrayListClass.getDeclaredMethod("add",Object.class);

            System.out.println(methodGet.invoke(myListInteger, 1));
             methodAdd.invoke(myListInteger, 100);
            System.out.println(myListInteger);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

       //--------------------------------------------------------------------------------------
       //-----------------создание обЪукта класса что бы вызывать его методы-----------------------
       // ---------снвчала надо получить какой нибудь констрктор
        Constructor constructorWhioutParametr = null;
        Constructor constructorParametr = null;

    {
        try {
            constructorWhioutParametr = arrayListClass.getConstructor();
            constructorParametr = arrayListClass.getConstructor(int.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
           //----------- newinstans  на конструктор  параметров
           //----------это заранее подготовленые обЪекты
            Object object;
            Object ObjectConstructorWhithParametr;

    {
        try {
            object = constructorWhioutParametr.newInstance();
            ObjectConstructorWhithParametr = constructorParametr.newInstance(44);
            ArrayList<Integer> test = (ArrayList<Integer>) object;
            test.add(67);
            System.out.println(test);

            ArrayList<Integer> testTwo = (ArrayList<Integer>) ObjectConstructorWhithParametr;
            testTwo.add(458);

            Class testClassTwo = testTwo.getClass();


           Class [] classes = testClassTwo.getDeclaredClasses();
            System.out.println("--------------------------------------");
           for (Class el:classes){
               System.out.println(el.getName());
               if(el.getName().contains("SubList")){
                   Class subList = el.getClass();
                   System.out.println("класс найден");
                   Method [] method1 = subList.getDeclaredMethods();
                  for (Method element:method1){
                      System.out.println(element.getName());
                  }

               }

           }
            System.out.println("-----------------------------");
            System.out.println(testTwo);
            //"estimateSize"

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        }
    }
        }


    //---------------------------------------------------------------------












