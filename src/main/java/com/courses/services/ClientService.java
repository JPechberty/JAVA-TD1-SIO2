package com.courses.services;

import com.courses.models.Client;
import com.courses.models.Comptable;
import com.courses.repositories.ClientRepository;
import com.courses.repositories.ComptableRepository;

import java.util.ArrayList;

public class ClientService {

    private ClientRepository repository;
    private ComptableRepository comptableRepository;

    public ClientService() {
        this.repository = new ClientRepository();
        this.comptableRepository = new ComptableRepository();
    }

    public void create(String nom, String siret, String adresse, Long comptableId) {
        Client c = new Client(null,nom, siret, adresse, new Comptable(comptableId));
        repository.create(c);
    }

    public Client findById(Long id) {

        Client c = repository.findById(id);
        if(c == null){
            System.out.println("Client introuvable !");
            return null;
        }

        Comptable comptable = comptableRepository.findById(c.getComptable().getId());

        if(comptable == null){
            System.out.println("Le comptable du client est introuvable !");
            return null;
        }

        c.setComptable(comptable);

        return c;
    }

    public void update(Long id, String nom, String siret, String adresse, Long comptableId) {

        Client c = new Client(null,nom, siret, adresse, new Comptable(comptableId));
        repository.update(c);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

    public ArrayList<Client> findAll() {

        ArrayList<Client> clients = repository.findAll();

        clients.forEach(client -> {
            Comptable comptable = comptableRepository.findById(client.getComptable().getId());
            if(comptable == null){
                System.out.println("Le comptable du client est introuvable !");
            }
            client.setComptable(comptable);

        });


        return clients;
    }

    public ArrayList<Client> findAllByComptable(Long comptableId) {
        return repository.findAllByComptable(comptableId);
    }
}
