package Serialization;

import java.io.Serializable;

public class People implements Serializable {
    String sex;

    public People(String sex) {
        this.sex = sex;
    }
}
