package JUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static JUnit.Persons.allUsers;

class PersonsTest {
//     Persons user = new Persons("Евгений", 35, Sex.MALE);
//     Persons user1 = new Persons("Марина", 34, Sex.FEMALE);
//     Persons user2 = new Persons("Алина", 7, Sex.FEMALE);
     Persons user1 ;
     Persons user2 ;
     Persons user3 ;
    Assertions Assert = null;
////    List<Persons> expected = new ArrayList<>();
    @BeforeEach
    public void setUp() throws Exception {
        System.out.println("Старт теста");
        user1 = new Persons("Марина", 34, Sex.FEMALE);
        user2= new Persons("Евгений", 35, Sex.MALE);
        user3 = new Persons("Алина", 7, Sex.FEMALE);


    }
    @AfterEach
    public void reset(){
        allUsers.clear();
//       allUsers = null;
//       allUsers = new HashMap<>();
    }
 //   @Test
//    public void getAllUsers() {
//
//        //создаем тестовые данные
//        Persons user = new Persons("Евгений", 35, Sex.MALE);
//        Persons user1 = new Persons("Марина", 34, Sex.FEMALE);
//        Persons user2 = new Persons("Алина", 7, Sex.FEMALE);
//
//        //создаем список expected и заполняем его данными нашего метода
//        List<Persons> expected = Persons.getAllUsers();
//
//        //создаем список actual в него помещаем данные для сравнения
//        //то что мы предпологиаем метод должен вернуть
//        List<Persons> actual = new ArrayList<>();
//        actual.add(user);
//        actual.add(user1);
//        actual.add(user2);
//
//        //запускаем тест, в случае если список expected и actual не будут равны
//        //тест будет провален, о результатах теста читаем в консоли
//        Assert.assertEquals(expected, actual);
//    }
//    @Test
//    public void getAllUsers_NO_NULL() {
//        //добавим проверку на null
//        List<Persons> expected = Persons.getAllUsers();
//        Assert.assertNotNull(expected);
//    }


    @Test
    void testGetAllUsers() {
//        Persons user1 =  new Persons("Маша", 23, Sex.FEMALE);
//        Persons user2 =  new Persons("Cаша", 23, Sex.MALE);
//        Persons user3 =  new Persons("Lаша", 23, Sex.FEMALE);

        List<Persons> expectedMale = Persons.getAllUsers(Sex.MALE);
        List<Persons> expectedFemale = Persons.getAllUsers(Sex.FEMALE);
        List<Persons> actual = new ArrayList<>();
        actual.add(user2);
        List<Persons> actual2 = new ArrayList<>();
        actual2.add(user1);
        actual2.add(user3);
        Assertions Assert = null;
        Assert.assertEquals(expectedMale,actual );
        Assert.assertEquals(expectedFemale,actual2 );

    }
    @Test
    void testGetAllUsers_Zero(){
//        Persons user1 =  new Persons("Маша", 23, Sex.FEMALE);
//        Persons user2 =  new Persons("Cаша", 45, Sex.MALE);
//        Persons user3 =  new Persons("Lаша", 23, Sex.FEMALE);

        List<Persons> expectedMale = Persons.getAllUsers();
        Assertions Assert = null;
        Assert.assertNotNull(expectedMale);

    }



    @Test
    void testGetHowManyUsers() { //создаем тестовые данные
//        Persons user1 = new Persons("Евгений", 35, Sex.MALE);
//        Persons user2 = new Persons("Марина", 34, Sex.FEMALE);
//        Persons user3 = new Persons("Алина", 7, Sex.FEMALE);

        List<Persons> expected = new ArrayList<>();
        expected = Persons.getAllUsers();
        int actual  = 3;
        Assert.assertEquals( expected.size(),actual );
    }


    @Test
    void testGetAllAgeUsers() {
//        Persons user1 = new Persons("Евгений", 35, Sex.MALE);
//        Persons user2 = new Persons("Марина", 34, Sex.FEMALE);
//        Persons user3 = new Persons("Алина", 7, Sex.FEMALE);

        int actual = user1.getAge() + user2.getAge() + user3.getAge();
        Assert.assertEquals(Persons.getAllAgeUsers(), actual);
    }

    @Test
    void getAverageAgeOfAllUsers() {
    }

    @Test
    void testGetAverageAgeOfAllUsers() {
    }
}