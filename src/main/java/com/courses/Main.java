package com.courses;

import com.courses.controllers.ClientController;
import com.courses.controllers.ComptableController;
import com.courses.models.Client;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayMainMenu();
    }

    private static void displayMainMenu(){
        while (true) {
            System.out.println("###################################################################");
            System.out.println("##                   Gestion Taxe Apprentissage                  ##");
            System.out.println("###################################################################");
            System.out.println("\n1. Gestion Comptables");
            System.out.println("2. Gestion Clients");
            System.out.println("0. Exit");
            System.out.println("\n-------------------------------------------------------------------");
            System.out.print("Entrer votre choix: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1: displayComptablesMenu(); break;
                case 2: displayClientsMenu(); break;

                case 0: System.exit(0); break;
                default: System.out.println("Choix invalide!"); break;
            }
        }
    }

    private static void displayComptablesMenu(){

        ComptableController comptableController = new ComptableController();

        while (true) {
            System.out.println("###################################################################");
            System.out.println("##                     Gestion Comptables                        ##");
            System.out.println("###################################################################");
            System.out.println("\n1. Créer un comptable");
            System.out.println("2. Mettre à jour un comptable");
            System.out.println("3. Supprimer un comptable");
            System.out.println("4. Voir un comptable");
            System.out.println("5. Visualiser le portefeuille clients d'un comptable");
            System.out.println("6. Voir la liste des comptables");
            System.out.println("0. Retour");
            System.out.println("\n-------------------------------------------------------------------");
            System.out.print("Entrer votre choix: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1: comptableController.create(); ; break;
                case 2: comptableController.update(); break;
                case 3: comptableController.delete(); break;
                case 4: comptableController.find(); break;
                case 5: comptableController.showClientsPortfolio(); break;
                case 6: comptableController.findAll(); break;
                case 0: displayMainMenu(); break;
                default: System.out.println("Choix invalide!"); break;
            }
        }
    }

    private static void displayClientsMenu(){
        ClientController clientController = new ClientController();

        while (true) {
            System.out.println("###################################################################");
            System.out.println("##                     Gestion Clients                        ##");
            System.out.println("###################################################################");
            System.out.println("\n1. Créer un client");
            System.out.println("2. Mettre à jour un client");
            System.out.println("3. Supprimer un client");
            System.out.println("4. Voir un client");
            System.out.println("5. Voir la liste des client");
            System.out.println("6. Calculer la taxe d'un client");
            System.out.println("7. Calculer la taxe pour client");
            System.out.println("0. Retour");
            System.out.println("\n-------------------------------------------------------------------");
            System.out.print("Entrer votre choix: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1: clientController.create(); break;
                case 2:clientController.update(); break;
                case 3:clientController.delete(); break;
                case 4:clientController.find(); break;
                case 5:clientController.findAll(); break;
                case 6:
                    System.out.println("Démarrage Calcul TA unique"); ; break;
                case 7:
                    System.out.println("Démarrage Calcul TA multiple"); ; break;

                case 0: System.exit(0); break;
                default: System.out.println("Choix invalide!"); break;
            }
        }
    }
}