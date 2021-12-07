package JUnit;

public class Doit {
    public static void main(String[] args) {
        new Persons("Евгений", 35, Sex.MALE);
        new Persons("Марина", 34, Sex.FEMALE);
        new Persons("Алина", 7, Sex.FEMALE);


        System.out.println("Все пользователи:");
        Persons.getAllUsers().forEach(System.out::println);
        System.out.println("Все пользователи: MALE");
        Persons.getAllUsers(Sex.MALE).forEach(System.out::println);
        System.out.println("Все пользователи: FEMALE");
        Persons.getAllUsers(Sex.FEMALE).forEach(System.out::println);
        System.out.println("================================================");
        System.out.println("       всех пользователей: " + Persons.getHowManyUsers());
        System.out.println("  всех пользователей MALE: " + Persons.getHowManyUsers(Sex.MALE));
        System.out.println("всех пользователей FEMALE: " + Persons.getHowManyUsers(Sex.FEMALE));
        System.out.println("================================================");
        System.out.println("       общий возраст всех пользователей: " + Persons.getAllAgeUsers());
        System.out.println("  общий возраст всех пользователей MALE: " + Persons.getAllAgeUsers(Sex.MALE));
        System.out.println("общий возраст всех пользователей FEMALE: " + Persons.getAllAgeUsers(Sex.FEMALE));
        System.out.println("================================================");
        System.out.println("       средний возраст всех пользователей: " + Persons.getAverageAgeOfAllUsers());
        System.out.println("  средний возраст всех пользователей MALE: " + Persons.getAverageAgeOfAllUsers(Sex.MALE));
        System.out.println("средний возраст всех пользователей FEMALE: " + Persons.getAverageAgeOfAllUsers(Sex.FEMALE));
        System.out.println("================================================");
    }
}
