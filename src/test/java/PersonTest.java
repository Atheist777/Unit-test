import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class PersonTest {

    public static Collection<Person> personCollection = new ArrayList<>();

    @BeforeAll

    public static void CreatePersons() {
        Person person1 = new Person("Maxim","Zhiltsov", 25, Sex.MAN, Education.HIGHER);
        Person person2 = new Person("Petya","Ivanov", 27, Sex.MAN, Education.HIGHER);
        Person person3 = new Person("Olya","Vasilyeva", 12, Sex.WOMAN, Education.HIGHER);
        Person person4 = new Person("Igor","Petrov", 16, Sex.MAN, Education.HIGHER);
        personCollection.add(person1);
        personCollection.add(person2);
        personCollection.add(person3);
        personCollection.add(person4);
    }

    @Test
    public void Test1() {
        Collection<Person> persons =  Main.getRandomPersonsList();
        assertThat(persons, is(not(empty())));
    }
    @Test
    public void Test2(){
        Collection<Person> persons =  Main.getRandomPersonsList();
        assertThat(persons,notNullValue());
    }


}
