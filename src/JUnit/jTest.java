package JUnit;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class jTest {
    Assertions Assert = null;
    @BeforeEach
    public void setUp() throws Exception {
        System.out.println("Старт второго теста");
//            user1 = new Persons("Марина", 34, Sex.FEMALE);
//            user2= new Persons("Евгений", 35, Sex.MALE);
//            user3 = new Persons("Алина", 7, Sex.FEMALE);
    }///
    @Test
    void testGetAllUsers() {




            Persons user1 =  new Persons("Маша", 23, Sex.FEMALE);
        Persons user2 =  new Persons("Cаша", 23, Sex.MALE);
        Persons user3 =  new Persons("Lаша", 23, Sex.FEMALE);

        List<Persons> expectedMale = Persons.getAllUsers(Sex.MALE);
        List<Persons> expectedFemale = Persons.getAllUsers(Sex.FEMALE);
        List<Persons> actual = new ArrayList<>();
        actual.add(user2);
        List<Persons> actual2 = new ArrayList<>();
        actual2.add(user1);
        actual2.add(user3);
        Assert.assertEquals(expectedMale,actual );
        Assert.assertEquals(expectedFemale,actual2 );

    }
}
