package com.courses.controllers;

import com.courses.models.Client;
import com.courses.models.Comptable;
import com.courses.services.ComptableService;

import java.util.Scanner;

public class ComptableController implements ControllerInterface {

    private ComptableService service;
    private Scanner scanner;

    public ComptableController() {
        this.service = new ComptableService();
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void create() {
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

    @Override
    public void update() {
        System.out.println("-------------------------------------------------------------------");
        System.out.println("--                   Mise à jour Comptable                        --");
        System.out.println("-------------------------------------------------------------------");
        System.out.print("Entrer l'id du comptable: ");
        Long id = scanner.nextLong();
        Comptable c = service.findById(id);
        if(c == null){
            System.out.println("Comptable introuvable !");
            return;
        }
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

    @Override
    public void delete(){
        System.out.println("-------------------------------------------------------------------");
        System.out.println("--                   Suppression Comptable                       --");
        System.out.println("-------------------------------------------------------------------");
        System.out.print("Entrer l'id du comptable: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline
        Comptable c = service.findById(id);
        if(c == null){
            System.out.println("Comptable introuvable !");
            return;
        }

        service.delete(id);
    }

    @Override
    public void find(){
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
        System.out.println(c.getId() + " | " + c.getNom() +" "+ c.getPrenom()+ " | " + c.getEmail() + " | " + c.getTelephone() + " | " + c.getClients().size() + " client(s)");

    }

    @Override
    public void findAll(){
        System.out.println("-------------------------------------------------------------------");
        System.out.println("--                   Liste des Comptables                        --");
        System.out.println("-------------------------------------------------------------------");
        for (Comptable c : service.findAll()) {
            System.out.println(c.getId() + " | " + c.getNom() +" "+ c.getPrenom()+ " | " + c.getEmail() + " | " + c.getTelephone() + " | " + c.getClients().size() + " client(s)");
        }
    }

    public void showClientsPortfolio(){
        System.out.println("-------------------------------------------------------------------");
        System.out.println("--          Visualisation portefeuille clients                   --");
        System.out.println("-------------------------------------------------------------------");
        System.out.print("Entrer l'id du comptable: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        Comptable c = service.findById(id);
        if(c == null){
            System.out.println("Comptable introuvable !");
            return;
        }
        c.getClients().forEach(client -> {
            System.out.println(client.getId() + " | " + client.getNom() +" | " + client.getSiret() + " | " + client.getAdresse() );
        });

    }

}
