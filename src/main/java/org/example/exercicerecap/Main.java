package org.example.exercicerecap;

import org.example.exercicerecap.entity.*;

//public class Main {
//    public static void main(String[] args) {
//
//        //création d'un client
//        ClientRepository clientRepository = new ClientRepository();
//        Client client = Client.builder().name("Tata").surname("Toto").age(12).build();
//        clientRepository.create(client);
//        //création d'un article nourriture
//        NourritureArticleRepository nourritureArticleRepository = new NourritureArticleRepository();
//        NourritureArticle nourritureArticle = NourritureArticle.builder().name("burger").description("trop bon")
//                .price(13.99).quantity(15).restock(ofEpochDay(13-02-2024)).datePeremption(ofEpochDay(16-03-2024)).build();
//        nourritureArticleRepository.create(nourritureArticle);
//        //création d'un article mode
//        ModeArticleRepository modeArticleRepository = new ModeArticleRepository();
//        ModeArticle modeArticle = ModeArticle.builder().name("robe").description("rouge").price(200)
//                .quantity(20).restock(ofEpochDay(13-2-2023)).typeArticle(GenreModeArticle.FEMININ).build();
//        modeArticleRepository.create(modeArticle);
//        //Création d'un article electronique
//        ElectronicArticleRepository electronicArticleRepository = new ElectronicArticleRepository();
//        ElectronicArticle electronicArticle = ElectronicArticle.builder().name("trotinette").description("xps13").price(300)
//                .quantity(23).restock(ofEpochDay(15-8-2000)).pourcentBattery(100).build();
//        electronicArticleRepository.create(electronicArticle);
//
//    }
//}
