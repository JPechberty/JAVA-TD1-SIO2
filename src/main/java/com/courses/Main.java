package com.courses;

import com.courses.controllers.ComptableController;

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
            System.out.println("5. Voir la liste des comptables");
            System.out.println("0. Retour");
            System.out.println("\n-------------------------------------------------------------------");
            System.out.print("Entrer votre choix: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1: comptableController.createComptable(); ; break;
                case 2: comptableController.updateComptable(); break;
                case 3: comptableController.deleteComptable(); break;
                case 4: comptableController.findComptable(); break;
                case 5:comptableController.listComptables(); break;
                case 0: displayMainMenu(); break;
                default: System.out.println("Choix invalide!"); break;
            }
        }
    }

    private static void displayClientsMenu(){
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
                case 1:
                    System.out.println("Démarrage Creation client");; break;
                case 2:
                    System.out.println("Démarrage Mise à jour client"); ; break;
                case 3:
                    System.out.println("Démarrage suppression client"); ; break;
                case 4:
                    System.out.println("Démarrage detail client"); ; break;
                case 5:
                    System.out.println("Démarrage Liste clients"); ; break;
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