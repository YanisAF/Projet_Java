package org.example.exercicerecap.java;

import org.example.exercicerecap.java.entity.Client;
import org.example.exercicerecap.java.entity.GenreModeArticle;
import org.example.exercicerecap.java.entity.ModeArticle;
import org.example.exercicerecap.java.entity.NourritureArticle;
import org.example.exercicerecap.java.repository.ClientRepository;
import org.example.exercicerecap.java.repository.ModeArticleRepository;
import org.example.exercicerecap.java.repository.NourritureArticleRepository;

import java.time.LocalDate;

import static java.time.LocalDate.ofEpochDay;

public class Main {
    public static void main(String[] args) {

        //création d'un client
        ClientRepository clientRepository = new ClientRepository();
        Client client = Client.builder().name("Tata").surname("Toto").age(12).build();
        clientRepository.create(client);
        //création d'un article nourriture
        NourritureArticleRepository nourritureArticleRepository = new NourritureArticleRepository();
        NourritureArticle nourritureArticle = NourritureArticle.builder().name("burger").description("trop bon")
                .price(13.99).quantity(15).restock(ofEpochDay(13-02-2024)).datePeremption(ofEpochDay(16-03-2024)).build();
        nourritureArticleRepository.create(nourritureArticle);
        //création d'un article mode
        ModeArticleRepository modeArticleRepository = new ModeArticleRepository();
        ModeArticle modeArticle = ModeArticle.builder().name("robe").description("rouge").price(200)
                .quantity(20).restock(ofEpochDay(13-02-2023)).typeArticle(GenreModeArticle.FEMININ).build();
        modeArticleRepository.create(modeArticle);


    }
}
