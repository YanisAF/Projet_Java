package org.example.demostreams;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("###########  Demo Java API Stream #############");

        List<String> names = Arrays.asList(
                "Luke",
                "Leia",
                "Han",
                "Anakin",
                "Anakin",
                "Obi-Wan",
                "Yoda",
                "Chewbacca",
                "R2-D2",
                "C-3PO",
                "Padmé"
        );


        System.out.println();
        System.out.println(" Filter : "); // intermédiaire
        names.stream()
                .filter(p -> p.startsWith("A"))
                .forEach(System.out::println);

        System.out.println();

        System.out.println("Count : "); // terminale

        System.out.println("Le nombre de personnage dont le prenom commence par 'A' : "
                + names.stream()
                .filter(p -> p.startsWith("A"))
                .count());

        long compte = names.stream()
                .filter(p -> p.startsWith("A"))
                .count();

        long compte2 = 0;
        for (String p : names){
            if (p.startsWith("A")){
                compte2++;
            }
        }

        System.out.println();

        System.out.println(" Distinct : "); // intermédiaire
        names.stream()
                .distinct()
                .forEach(System.out::println);


        System.out.println();

        System.out.println(" Limit : ");// intermédiaire
        names.stream().limit(4).forEach(System.out::println);

        System.out.println();

        System.out.println(" Sorted :");// intermédiaire
        names.stream().sorted().forEach(System.out::println);

        System.out.println();

        names.stream()
                .sorted()
                .distinct()
                .limit(3)
                .forEach(System.out::println);

        System.out.println();

        System.out.println(" Sorted inverse : ");// intermédiaire
        names.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);


        // Création d'une liste de Person
        List<Person> personList = Arrays.asList(
                new Person("Luke Skywalker", "Luke", 30),
                new Person("Leia Organa", "Leia", 28),
                new Person("Han Solo", "Han", 35),
                new Person("Darth Vader", "Anakin", 45),
                new Person("Obi-Wan Kenobi", "Obi-Wan", 60),
                new Person("Yoda", "Yoda", 900),
                new Person("Chewbacca", "Chewbacca", 200),
                new Person("R2-D2", "R2-D2", 40),
                new Person("C-3PO", "C-3PO", 50),
                new Person("Padmé Amidala", "Padmé", 25)
        );


        System.out.println();

        System.out.println("######## mapToDouble & sum() demo  #######");

        double totalAge = personList.stream()
                .mapToDouble(p -> p.getAge())
                .sum();

        System.out.println("Total age des personnages : " +totalAge);


        System.out.println();

        Optional<Person> person = personList.stream()
                .filter(p -> p.getAge() >= 4000)
                .findFirst(); // terminale

        if(person.isPresent()){ //null ou non (non trouvé?)
            System.out.println("Le premier personnage qui a au moins 40 ans : "
                    + person.get()); // récupérer la personne
        }else {
            System.out.println("Aucun personnage d'au moins cette age !!!");
        }


        System.out.println("#########  toMap ############");

        Map<UUID,String> personMap = personList.stream()
//                .collect(Collectors.toList());
                .collect(Collectors.toMap(p -> UUID.randomUUID(),Person::getNom));
        System.out.println(personMap);


        System.out.println(" Demo : filter, map, collect");
        System.out.println("Nouvelle collection");

        List<Person> listModifie = personList.stream()
                .filter(p -> p.getAge() > 35)
                .map(p -> {
                    p.setAge(p.getAge() - 20);
                    return  p;
                })
                .toList();
        // .collect(Collectors.toList());

        listModifie.forEach(System.out::println);
//        listModifie.stream().forEach(System.out::println);

        System.out.println();


        System.out.println("Nouveau tableau");

        Person[] people = personList.stream()
                .filter(p -> p.getAge() > 40)
                .map(p -> {
                    p.setAge(p.getAge() -20);
                    return p;
                })
                .toArray(Person[]::new);

        Arrays.stream(people).forEach(System.out::println);
    }
}
