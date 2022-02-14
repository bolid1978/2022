package anotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Myanotation {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
         inspectiv(SimpleService.class);
         inspectiv(LazyService.class);
         inspectiv(String.class);


    }

    static void inspectiv(Class<?> service ) throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
       java.lang.annotation.Annotation [] fg = service.getDeclaredAnnotations();
      for (Annotation el : fg){
          System.out.println(el.getClass().getName());
      }
       if(service.isAnnotationPresent(Service.class)){
           Service ann = service.getAnnotation(Service.class);
           System.out.println(ann.name());

          //---берём все методы
           Method [] methodservice = service.getDeclaredMethods();
           System.out.println(Arrays.toString(methodservice));
           Method need = null;
           //--------находим только методы с инотацией инит
           for (Method el : methodservice){
               if(el.isAnnotationPresent(Init.class)){
                   need = el;
               }
           }
           //-------создаём конструктор
           Constructor<?> myConstructor = service.getConstructor();
           //---------создаём объект с помощью конструктора
           Object obj = myConstructor.newInstance();
           //---------запускаем метод----------------------
           need.invoke(obj);

           System.out.println(need + " наш метод");



       }

    }

}
