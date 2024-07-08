//package org.example.exerciceperso.controller;
//
//import org.example.exerciceperso.entity.comptesbancaires.CompteBancaire;
//
//import java.util.Scanner;
//
//public class IHMProduct {
//    private final Scanner sc;
//
//    private final int compteBancaire;
//
//    public IHMProduct(Scanner sc, int compteBancaire) {
//        this.sc = sc;
//        this.compteBancaire = compteBancaire;
//    }
//
//    public void start (){
//        String entry;
//        while (true){
//            System.out.println(" --- Création d'un compte bancaire ---");
//            System.out.println("1/ create account");
//            System.out.println("2/ update account");
//            System.out.println("3/ delete account");
//            System.out.println("4/ find account by id");
//            System.out.println("5/ find all account");
//            entry = sc.nextLine();
//            switch (entry){
//                case "1"-> create();
//                case "2"-> update();
//                case "3"-> delete();
//                case "4"-> findById();
//                case "5"-> findAll();
//                default -> {return;}
//            }
//        }
//    }
//
//    private void create (){
//        System.out.println(" --- create account ---");
//        System.out.println("1/ ProductCloth");
//        System.out.println("1/ ProductFood");
//        System.out.println("1/ ProductElectronic");
//        String productSelect;
//        productSelect = sc.nextLine();
//
//        switch (productSelect){
//            case "1"-> createProductCloth();
//            case "2"-> createProductFood();
//            case "3"-> createProductElectronic();
//            default -> {return;}
//        }
//
//    }

//    private void createProductCloth (){
//        System.out.println("""
//                --- create a productCloth
//                "Description :"
//                """);
//        String description = sc.nextLine();
//
//        System.out.println("price :");
//        float price = sc.nextFloat();
//
//        System.out.println("stock");
//        int stock = sc.nextInt();
//
//        System.out.println("size : (xs, s ,m , l xl");
//        String size = sc.nextLine();
//
//        int i = 1;
//        System.out.println("Categories :");
//        for (Categories categories : Categories.values()){
//            System.out.println(categories);
//        }
//        Categories categories = Categories.valueOf(sc.nextLine().toUpperCase());
//
//        productService.createProductCloth(description,categories,size,price,stock);
//    }
//    private void createProductFood (){
//        System.out.println("--- create a productFood");
//        System.out.println("Description");
//        String description = sc.nextLine();
//
//        System.out.println("price :");
//        float price = sc.nextFloat();
//
//        System.out.println("stock");
//        int stock = sc.nextInt();
//
//
//        productService.createProductFood(description,price,stock, LocalDate.ofEpochDay(LocalDate.now().toEpochDay() + 604800000));
//    }
//    private void createProductElectronic (){
//        System.out.println("--- create a productElectronic");
//        System.out.println("Description");
//        String description = sc.nextLine();
//
//        System.out.println("price :");
//        float price = sc.nextFloat();
//
//        System.out.println("stock");
//        int stock = sc.nextInt();
//
//        System.out.println("battery duration :");
//        int batteryDuration = sc.nextInt();
//
//
//        productService.createElectronic(description,price,stock, batteryDuration);
//
//    }


//    private void update (){
//
//    }
//
//    private void delete (){
//
//    }
//
//    private void findById (){
//
//    }
//
//    private void findAll (){
//
//    }
//}
