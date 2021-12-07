package Comporator;

public class Avto /*implements Comparable<Avto>*/{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getMassa() {
        return massa;
    }

    public void setMassa(int massa) {
        this.massa = massa;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Avto(String name, double speed, int massa, double cost) {
        this.name = name;
        this.speed = speed;
        this.massa = massa;
        this.cost = cost;
    }

    String name = "";
    double speed = 0;
    int massa = 0;
    double cost = 0;

    @Override
    public String toString() {
        return "name = " + name +
                " speed = " + speed +
                " massa = " + massa +
                " cost = " + cost ;
    }



  //  @Override
   // public int compareTo(Avto o) {
    //    return this.name.compareTo(o.getName());
   // }
}
