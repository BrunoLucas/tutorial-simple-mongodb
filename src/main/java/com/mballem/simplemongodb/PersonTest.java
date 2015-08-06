package com.mballem.simplemongodb;

import com.mballem.simplemongodb.dao.PersonDao;
import com.mballem.simplemongodb.entity.Person;
import com.mballem.simplemongodb.entity.Phone;
import org.bson.types.ObjectId;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Marcio Ballem
 * Date: 09/07/12
 * Time: 17:06
 * http://mballem.com/
 */
public class PersonTest {

    public static void main(String[] args) {
        save();
        //update();
        //delete();
        //saveIndex();
    }
    private static void saveIndex() {
        Phone ph1 = new Phone("021-3112.6191", "021-9111.9911");
        Person p1 = new Person("Marcus Luiz", "de Cabral", 26, ph1);
        new PersonDao().saveWithIndex(p1);

        Phone ph2 = new Phone("011-3502.0555", "011-9155.9056");
        Person p2 = new Person("Pedro Luiz", "de Oliveira", 33, ph2);
        new PersonDao().saveWithIndex(p2);

        Phone ph3 = new Phone("055-3525.2552", "055-9525.4454");
        Person p3 = new Person("Pedro Luiz", "Pires de Almeida", 38, ph3);
        new PersonDao().saveWithIndex(p3);

        List<Person> persons = new PersonDao().findPersons();
        for (Person person : persons) {
            System.out.println(person.toString());
        }
    }

    private static void save() {
        Phone ph1 = new Phone("021-3424.6494", "021-9144.9446");
        Person p1 = new Person("João Otávio", "de Souza", 22, ph1);
        new PersonDao().save(p1);

        Phone ph2 = new Phone("011-3332.4490", "011-9440.9044");
        Person p2 = new Person("João Mauricio", "Pereira", 29, ph2);
        new PersonDao().save(p2);

        Phone ph3 = new Phone("055-3222.2599", "055-9995.9494");
        Person p3 = new Person("Patricia", "Fagundes de Almeida", 33, ph3);
        new PersonDao().save(p3);

        List<Person> persons = new PersonDao().findPersons();
        for (Person person : persons) {
            System.out.println(person.toString());
        }
    }

    private static void update() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("firstName", "Anita");
        Person query = new PersonDao().findPerson(map);

        Phone phone = new Phone("048-3222.2522", "048-9225.4464");
        Person person = new Person("Anita", "Pires de Almeida", 30, phone);
        new PersonDao().update(query, person);

        Person newPerson = new PersonDao().findPerson(map);
        System.out.println("Old:> " + query + "\nNew:> " + newPerson.toString());
    }

    private static void delete() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("firstName", new ObjectId("João Luiz"));
        List<Person> query = new PersonDao().findPersons(map);

        for (Person person : query) {
            new PersonDao().delete(person);
        }

        List<Person> persons = new PersonDao().findPersons();
        for (Person person : persons) {
            System.out.println(person.toString());
        }
    }  // new org.bson.types.ObjectId("4ffb431f6b70d45d7679e87f")
}
