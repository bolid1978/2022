package Serialization;



import javax.net.ssl.HandshakeCompletedEvent;
import java.io.Serializable;
import java.util.*;

public class MyClass extends People implements Serializable {
    int age  = 43;
    String name = "Sergey";
    double cast = 150.000;
    Warion myCar = new Warion("Mercedes");
    public static int myTestStatic = 12;
    HashMap <String,String> myMap = new HashMap<>();



    public MyClass(int age, String name, double cast) {
        super("Man");
        this.age = age;
        this.name = name;
        this.cast = cast;
        setMyCar();
    }

    public void setMyCar() {
        myMap.put("BMV", "2");
        myMap.put("Mercedes", "4");
        myMap.put("Volvo", "1");

    }

    public void move(){
        System.out.println("goood");
    }
    @Override
    public String toString() {

        return age + "  " + name + "  " + cast + " " + super.sex + " " + myCar.car + " " + myMap.toString() + " " + myTestStatic;
    }
}
