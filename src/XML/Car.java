package XML;

import javax.xml.bind.annotation.*;


@XmlRootElement(name = "yamaha")
public class Car {

     String name;
      int model;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }


}
