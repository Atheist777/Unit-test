import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Collection<Person> persons = getRandomPersonsList();

    }

//        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
//        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
     Collection<Person> persons = new ArrayList<>();

    public static Collection<Person> getRandomPersonsList() {
        Collection<Person> persons = new ArrayList<>();

        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");

        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );


        }


//        for (int i = 0; i < 10_000_000; i++) {
//            persons.add(new Person(
//                    names.get(new Random().nextInt(names.size())),
//                    families.get(new Random().nextInt(families.size())),
//                    new Random().nextInt(100),
//                    Sex.values()[new Random().nextInt(Sex.values().length)],
//                    Education.values()[new Random().nextInt(Education.values().length)]));
//        }


        int agePeople = (int) persons.stream()
                .filter(x -> x.getAge() > 18)
                .count();
        System.out.println(agePeople);

//        List<String> military = persons.stream()
//                .filter(x -> x.getAge() >= 18 && x.getAge() < 28 && x.getSex() == Sex.MAN)
//                .map(Person -> Person.getFamily())
//                .collect(Collectors.toList());

        List<Person> highEducationPeople = persons.stream()
                .filter(x -> x.getAge() >= 18 && x.getAge() < 61 && x.getEducation() == Education.HIGHER && x.getSex() == Sex.WOMAN
                        || x.getAge() >= 18 && x.getAge() < 66 && x.getEducation() == Education.HIGHER && x.getSex() == Sex.MAN)
                .sorted(Comparator.comparing(Person -> Person.getFamily()))
                .collect(Collectors.toList());


        return persons;
    }
}
