package com.courses.controllers;

import com.courses.models.Comptable;
import com.courses.services.ComptableService;

import java.util.Scanner;

public class ComptableController {

    private ComptableService service;
    private Scanner scanner;

    public ComptableController() {
        this.service = new ComptableService();
        this.scanner = new Scanner(System.in);
    }

    public void createComptable() {
        System.out.println("-------------------------------------------------------------------");
        System.out.println("--                   Create Comptable                            --");
        System.out.println("-------------------------------------------------------------------");
        System.out.print("Entrer le nom du comptable: ");
        String nom = scanner.nextLine();
        System.out.print("Entrer le prénom du comptable: ");
        String prenom = scanner.nextLine();
        System.out.print("Entrer l'email du comptable: ");
        String email = scanner.nextLine();
        System.out.print("Entrer le numéro de téléphone du comptable: ");
        String tel = scanner.nextLine();

        service.create(nom,prenom, email, tel);
    }

    public void updateComptable() {
        System.out.println("-------------------------------------------------------------------");
        System.out.println("--                   Mise à jour Comptable                        --");
        System.out.println("-------------------------------------------------------------------");
        System.out.print("Entrer l'id du comptable: ");
        Long id = scanner.nextLong();
        System.out.print("Entrer le nom du comptable: ");
        String nom = scanner.nextLine();
        System.out.print("Entrer le prénom du comptable: ");
        String prenom = scanner.nextLine();
        System.out.print("Entrer l'email du comptable: ");
        String email = scanner.nextLine();
        System.out.print("Entrer le numéro de téléphone du comptable: ");
        String tel = scanner.nextLine();

        service.update(id,nom,prenom, email, tel);
    }

    public void deleteComptable(){
        System.out.println("-------------------------------------------------------------------");
        System.out.println("--                   Suppression Comptable                       --");
        System.out.println("-------------------------------------------------------------------");
        System.out.print("Entrer l'id du comptable: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        service.delete(id);
    }

    public void findComptable(){
        System.out.println("-------------------------------------------------------------------");
        System.out.println("--                   Voir un Comptable                           --");
        System.out.println("-------------------------------------------------------------------");
        System.out.print("Entrer l'id du comptable: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        Comptable c = service.findById(id);
        if(c == null){
            System.out.println("Comptable introuvable !");
            return;
        }
        System.out.println(c.getId() + " | " + c.getNom() +" "+ c.getPrenom()+ " | " + c.getEmail() + " | " + c.getTelephone());

    }

    public void listComptables(){
        System.out.println("-------------------------------------------------------------------");
        System.out.println("--                   Liste des Comptables                        --");
        System.out.println("-------------------------------------------------------------------");
        for (Comptable c : service.findAll()) {
            System.out.println(c.getId() + " | " + c.getNom() +" "+ c.getPrenom()+ " | " + c.getEmail() + " | " + c.getTelephone());
        }
    }

}
