package com.courses.services;

import com.courses.models.Client;
import com.courses.models.Comptable;
import com.courses.repositories.ClientRepository;
import com.courses.repositories.ComptableRepository;

import java.util.ArrayList;

public class ComptableService {

    private ComptableRepository repository;
    private ClientRepository clientRepository;

    public ComptableService() {
        this.repository = new ComptableRepository();
        this.clientRepository = new ClientRepository();
    }

    public void create(String nom, String prenom, String email, String telephone) {
        Comptable c = new Comptable(null, nom, prenom, email, telephone);
        repository.create(c);
    }

    public Comptable findById(Long id) {

        Comptable c = repository.findById(id);

        if(c == null){
            System.out.println("Comptable introuvable !");
            return null;
        }

        clientRepository.findAllByComptable(c.getId()).forEach(client -> {
            c.addClient(client);
        });
        //Fonction lamda ? programmation fonctionnelle ?
        //clientService.findAllByComptable(c.getId()).forEach(c::addClient);


        return c;
    }

    public void update(Long id, String nom, String prenom, String email, String telephone) {
        Comptable c = new Comptable(id, nom, prenom, email, telephone);
        repository.update(c);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

    public ArrayList<Comptable> findAll() {

        ArrayList<Comptable> comptables = repository.findAll();

        comptables.forEach(c -> {
            clientRepository.findAllByComptable(c.getId()).forEach(client -> {
                c.addClient(client);
            });
            //Fonction lamda ? programmation fonctionnelle ?
            //clientService.findAllByComptable(comptable.getId()).forEach(comptable::addClient);
        });


        return comptables;
    }

}
