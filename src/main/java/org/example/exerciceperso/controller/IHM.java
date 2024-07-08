import org.example.jpa.persistence.AnimalRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
//import java.util.Scanner;
//
//public class IHM {
//    private EntityManagerFactory emf;
//    private EntityManager em;
//    private Scanner sc;
//    private AnimalRepository animalRepository;
//
//    public IHM (){
//        emf = Persistence.createEntityManagerFactory("jpa_project");
//        em = emf.createEntityManager();
//        animalRepository = new AnimalRepository(em);
//        sc = new Scanner(System.in);
//    }
//
//    public void start (){
//        String entry;
//        while(true){
//            System.out.println(" ---- Zoo Menu -----");
//            System.out.println("1/ create Animal");
//            System.out.println("2/ get animal by id");
//            System.out.println("3/ get animal by name");
//            System.out.println("4/ get animal by diet");
//            entry = sc.nextLine();
//            switch(entry){
//                case "1"-> createAnimal();
//                case "2"-> getAnimalById();
//                case "3"-> getAnimalByName();
//                case "4"-> getAnimalByDiet();
//                default -> {
//                    return;
//                }
//            }
//        }
//    }
//}
