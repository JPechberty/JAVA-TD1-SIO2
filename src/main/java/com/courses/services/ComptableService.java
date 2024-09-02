package com.courses.services;

import com.courses.models.Comptable;
import com.courses.repositories.ComptableRepository;

import java.util.ArrayList;

public class ComptableService {

    private ComptableRepository repository;

    public ComptableService() {
        this.repository = new ComptableRepository();
    }

    public void create(String nom, String prenom, String email, String telephone) {
        Comptable c = new Comptable(null, nom, prenom, email, telephone);
        repository.create(c);
    }

    public Comptable findById(Long id) {
        return repository.findById(id);
    }

    public void update(Long id, String nom, String prenom, String email, String telephone) {
        Comptable c = new Comptable(id, nom, prenom, email, telephone);
        repository.update(c);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

    public ArrayList<Comptable> findAll() {
        return repository.findAll();
    }
}
