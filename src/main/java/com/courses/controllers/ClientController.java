package com.courses.controllers;

import com.courses.models.Client;
import com.courses.models.Comptable;
import com.courses.services.ClientService;
import com.courses.services.ComptableService;

import javax.naming.ldap.Control;
import java.util.Scanner;

public class ClientController implements ControllerInterface {

    private ClientService service;
    private Scanner scanner;

    public ClientController() {
        this.service = new ClientService();
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void create() {
        System.out.println("-------------------------------------------------------------------");
        System.out.println("--                      Create Client                            --");
        System.out.println("-------------------------------------------------------------------");
        System.out.print("Entrer le nom du client: ");
        String nom = scanner.nextLine();
        System.out.print("Entrer le siret du client: ");
        String siret = scanner.nextLine();
        System.out.print("Entrer l'adresse du client: ");
        String adresse = scanner.nextLine();
        System.out.print("Entrer l'id du comptable du client: ");
        Long comptableId = scanner.nextLong();

        service.create(nom,siret, adresse, comptableId);
    }

    @Override
    public void update() {
        System.out.println("-------------------------------------------------------------------");
        System.out.println("--                   Mise à jour Client                          --");
        System.out.println("-------------------------------------------------------------------");
        System.out.print("Entrer l'id du client: ");
        Long id = scanner.nextLong();
        Client c = service.findById(id);
        if(c == null){
            System.out.println("Client introuvable !");
            return;
        }
        System.out.print("Entrer le nom du client: ");
        String nom = scanner.nextLine();
        System.out.print("Entrer le siret du client: ");
        String siret = scanner.nextLine();
        System.out.print("Entrer l'adresse du client: ");
        String adresse = scanner.nextLine();
        System.out.print("Entrer l'id du comptable du client: ");
        Long comptableId = scanner.nextLong();

        service.update(id,nom,siret, adresse, comptableId);
    }

    @Override
    public void delete(){
        System.out.println("-------------------------------------------------------------------");
        System.out.println("--                   Suppression Client                          --");
        System.out.println("-------------------------------------------------------------------");
        System.out.print("Entrer l'id du client: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        Client c = service.findById(id);
        if(c == null){
            System.out.println("Client introuvable !");
            return;
        }

        service.delete(id);
    }

    @Override
    public void find(){
        System.out.println("-------------------------------------------------------------------");
        System.out.println("--                   Voir un Client                              --");
        System.out.println("-------------------------------------------------------------------");
        System.out.print("Entrer l'id du client: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        Client c = service.findById(id);
        if(c == null){
            System.out.println("Client introuvable !");
            return;
        }
        System.out.println(c.getId() + " | " + c.getNom() +" | " + c.getSiret() + " | " + c.getAdresse() + " | " + c.getComptable().getId() +" - "+ c.getComptable().getNom());

    }

    @Override
    public void findAll(){
        System.out.println("-------------------------------------------------------------------");
        System.out.println("--                   Liste des Clients                           --");
        System.out.println("-------------------------------------------------------------------");
        for (Client c : service.findAll()) {
            System.out.println(c.getId() + " | " + c.getNom() +" | " + c.getSiret() + " | " + c.getAdresse() + " | " + c.getComptable().getId() +" - "+ c.getComptable().getNom());
        }
    }


}
