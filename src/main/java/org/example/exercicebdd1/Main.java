package org.example.exercicebdd1;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=appli";
        String username = "postgres";
        String password = "root";

        Connection connection;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez vos informations: ");
        System.out.println("Numéro de classe : ");
        int numeroClass = scanner.nextInt();
        System.out.println("Votre prénom : ");
        String prenom = scanner.next();
        System.out.println("Votre nom : ");
        String nom = scanner.next();
        System.out.println("Votre date d'obtention : année, mois, jour : ");
        LocalDate date = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());


        try {
            connection = DriverManager.getConnection(url, username, password);

            if (connection != null) {
                System.out.println("La connexion est ok");
            } else {
                System.out.println("Connexion échoué");
            }

            User user = User.builder()
                    .name(nom)
                    .surname(prenom)
                    .numberClasse(numeroClass)
                    .DateDiplome(LocalDate.now())
                    .build();

//            ajouterEtudiant(connection, user);
//
//            getAll(connection);
//
//            getAllByNumClass(connection);

            String request4 = "DELETE FROM etudiant WHERE id_etudiant = ?";
            PreparedStatement prepared = connection.prepareStatement(request4);
            prepared.setInt(1, user.getId());


        }

        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Méthodes créés

    private static void getAll(Connection connection) throws SQLException {
        Statement stmt = connection.createStatement();
        String request2 = "SELECT * FROM etudiant";
        ResultSet resultat = stmt.executeQuery(request2);
        List<User> users = new ArrayList<>();

        while(resultat.next()){
            User user1 = User.builder()
                    //.getInt nous permet de recuperer la valeur numique qui se trouve a la colone "id"
                    .id(resultat.getInt("id_etudiant"))
                    .numberClasse(resultat.getInt("numero_de_classe"))
                    //.getString nous permet de recuperer la valeur textuelle qui se trouve a la colone "titre"
                    .name(resultat.getString("nom"))
                    .surname(resultat.getString("prenom"))
                    .DateDiplome(resultat.getDate("date_de_diplome").toLocalDate())
                    .build();
                    users.add(user1);
        }
        System.out.println(users);
    }

    private static void getAllByNumClass(Connection connection) throws SQLException {
        ResultSet resultat;
        Statement stmt;
        stmt = connection.createStatement();
        String request3 = "SELECT * FROM etudiant WHERE numero_de_classe = 12";
        resultat = stmt.executeQuery(request3);
        List<User> students = new ArrayList<>();

        while (resultat.next()) {
            User student = User.builder()
                    //.getInt nous permet de recuperer la valeur numique qui se trouve a la colone "id"
                    .id(resultat.getInt("id_etudiant"))
                    .numberClasse(resultat.getInt("numero_de_classe"))
                    //.getString nous permet de recuperer la valeur textuelle qui se trouve a la colone "titre"
                    .name(resultat.getString("nom"))
                    .surname(resultat.getString("prenom"))
                    .DateDiplome(resultat.getDate("date_de_diplome").toLocalDate())
                    .build();
            System.out.println(student);
            students.add(student);
        }
    }

    private static void ajouterEtudiant(Connection connection, User user) throws SQLException {
        String request1 = "INSERT INTO etudiant (numero_de_classe, prenom, nom, date_de_diplome) VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(request1);
        preparedStatement.setInt(1, user.getNumberClasse());
        preparedStatement.setString(2, user.getSurname());
        preparedStatement.setString(3, user.getName());
        preparedStatement.setDate(4, Date.valueOf(user.getDateDiplome()));

        int nbrRows = preparedStatement.executeUpdate();
        if (nbrRows == 1) {
            System.out.println("Requête effectuée");
        } else {
            System.out.println("Erreur de requête");
        }
    }
}
