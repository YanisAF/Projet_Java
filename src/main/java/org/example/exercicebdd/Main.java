package org.example.exercicebdd;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=entreprise_demo2";
        String username = "postgres";
        String password = "root";

        Connection conn;

        try {
             conn = DriverManager.getConnection(url, username, password);

            if (conn != null){
                System.out.println("La connexion est ok");
            } else{
                System.out.println("Connexion échouhé");
            }
            Statement stmt = conn.createStatement();
            String request = "SELECT * FROM livre";
            ResultSet resultat = stmt.executeQuery(request);

            while(resultat.next()){
                System.out.println(resultat.getString("titre")+" /");
            }
//            .close permet de fermer nos objet statement resultat et conn puis éviter
            stmt.close();
            resultat.close();

            String request2 = "SELECT * FROM livre WHERE id_livre = 1";
            stmt = conn.createStatement();
            resultat = stmt.executeQuery(request2);

            if (resultat.next()){
                System.out.println(resultat.getString("titre")+" /"+ resultat.getInt(1));
            }
            stmt.close();
            resultat.close();

            stmt = conn.createStatement();
            String request3 = "SELECT * FROM livre";
            resultat = stmt.executeQuery(request3);
            List<Book> books = new ArrayList<>();
            while(resultat.next()){
                books.add(Book.builder()
                        .id(resultat.getInt("id_livre"))
                        .title(resultat.getString("titre"))
                        .author(resultat.getString("auteur"))
                        .build());
            }
            System.out.println(books);

        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

}
