package resutse;

import java.util.ResourceBundle;

public class MyRes {
    public static void main(String[] args) {
        ResourceBundle res =  ResourceBundle.getBundle(MyRes.class.getPackage().getName().replace("/",
                ".") + ".res");
        System.out.println(res.getString("before"));
        System.out.println(res.containsKey("5"));
    }
}
