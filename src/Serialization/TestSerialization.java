package Serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TestSerialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {



        FileOutputStream fileOut = new FileOutputStream("c:\\1\\serializ.txt");
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

        MyClass myClass = new MyClass(43,"Sergey",250000);

        System.out.println(myClass);
        objectOut.writeObject(myClass);

        objectOut.flush();
        objectOut.close();
        MyClass.myTestStatic = 10;
        FileInputStream fileIn =  new FileInputStream("c:\\1\\serializ.txt");
        ObjectInputStream objectIn =  new ObjectInputStream(fileIn);

         MyClass in = (MyClass) objectIn.readObject();
        // myClass = (MyClass) objectIn.readObject();

         System.out.println(in);
        // System.out.println(myClass);
        Set<Integer> temp = new HashSet<>();
        temp.add(12);
        temp.add(9);
        temp.add(23);
       // temp.add(123);
        System.out.println(temp);
        ArrayList<Integer> ar = new ArrayList<>(temp);
        System.out.println(ar);


    }
}
