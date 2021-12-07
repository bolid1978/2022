package JUnit;

import java.util.*;

public class Persons {

         static Map<Integer,Persons > allUsers =  new HashMap<>();

        private static int countId = 0;

    private int id;
    private String name;
    private int age;
    private  Sex sex;




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persons user = (Persons) o;
        return age == user.age &&
                Objects.equals(name, user.name) &&
                sex == user.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, sex);
    }

    private boolean hasUser(){
        for (Persons persons:allUsers.values() ){
            if (persons.equals(this)&&persons.hashCode() == this.hashCode())
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
    public Persons(String name,int age,Sex sex) {
      //  if(allUsers == null){

       // }
        this.name = name;
        this.age = age;
        this.sex = sex;
        if(!hasUser()){
           countId++;
           this.id = countId;
           allUsers.put(id, this);
        }
    }

    public static List<Persons> getAllUsers(){
        return new ArrayList<>(allUsers.values());
    }
    public static List<Persons> getAllUsers(Sex sex){
        List<Persons> listAllUsers = new ArrayList<>();
        for (Persons user : allUsers.values()){
            if (user.sex == sex){
                listAllUsers.add(user);
            }
        }
        return listAllUsers;
    }
    public static int getHowManyUsers(){
        return allUsers.size();
    }
    public static int getHowManyUsers(Sex sex){
        return getAllUsers(sex).size();
    }
    public static int getAllAgeUsers(){
        int countAge = 0;
        for (Persons user : allUsers.values()){
            countAge += user.age;
        }
        return countAge;
    }

    public static int getAllAgeUsers(Sex sex){
        int countAge = 0;
        for (Persons user : getAllUsers(sex)){
            countAge += user.age;
        }
        return countAge;
    }

    public static int getAverageAgeOfAllUsers(){
        return getAllAgeUsers() / getHowManyUsers();
    }

    public static int getAverageAgeOfAllUsers(Sex sex){
        return getAllAgeUsers(sex) / getHowManyUsers(sex);
    }


}
