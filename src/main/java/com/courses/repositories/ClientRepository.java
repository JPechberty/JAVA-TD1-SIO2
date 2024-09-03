package com.courses.repositories;

import com.courses.models.Client;
import com.courses.models.Comptable;
import com.courses.tools.DataSourceProvider;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientRepository implements RepositoryInterface<Client, Long> {

    private DataSource dataSource;
    private Connection connection;

    public ClientRepository() {
        this.dataSource = DataSourceProvider.getDataSourceInstance();
        this.connection = null;
    }

    @Override
    public void create(Client entity) {
        try {
            this.connection = this.dataSource.getConnection();
            PreparedStatement pSt = this.connection.prepareStatement("INSERT INTO clients (nom_entreprise, siret, adresse, comptable_id) VALUES (?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            pSt.setString(1, entity.getNom());
            pSt.setString(2, entity.getSiret());
            pSt.setString(3, entity.getAdresse());
            pSt.setLong(4, entity.getComptable().getId());
            pSt.executeUpdate();
            ResultSet rs =  pSt.getGeneratedKeys();
            if(rs.next()){
                entity.setId(rs.getLong(1));
            }
            System.out.println("Client créé avec l'id : " + entity.getId());
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            try {
                if (this.connection != null) {
                    this.connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }

    @Override
    public void update(Client entity) {
        try {
            this.connection = this.dataSource.getConnection();
            PreparedStatement pSt = this.connection.prepareStatement("UPDATE clients SET nom_entreprise = ?, siret = ?, adresse = ?, comptable_id = ? WHERE client_id = ?");
            pSt.setString(1, entity.getNom());
            pSt.setString(2, entity.getSiret());
            pSt.setString(3, entity.getAdresse());
            pSt.setLong(4, entity.getComptable().getId());
            pSt.setLong(5, entity.getId());
            pSt.executeUpdate();
            System.out.println("Client modifié avec l'id : " + entity.getId());
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            try {
                if (this.connection != null) {
                    this.connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }

    @Override
    public void delete(Long aLong) {
        try {
            this.connection = this.dataSource.getConnection();
            PreparedStatement pSt = this.connection.prepareStatement("DELETE FROM clients WHERE client_id = ?");
            pSt.setLong(1, aLong);
            pSt.executeUpdate();
            System.out.println("Client supprimé avec l'id : " + aLong);
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            try {
                if (this.connection != null) {
                    this.connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }

    @Override
    public Client findById(Long aLong) {
        try{
            this.connection = this.dataSource.getConnection();
            PreparedStatement pSt = this.connection.prepareStatement("SELECT * FROM clients WHERE client_id = ?");
            pSt.setLong(1, aLong);
            ResultSet rs = pSt.executeQuery();
            if(rs.next()){
                return new Client(
                        rs.getLong("client_id"),
                        rs.getString("nom_entreprise"),
                        rs.getString("siret"),
                        rs.getString("adresse"),
                        new Comptable(rs.getLong("comptable_id")));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            try {
                if (this.connection != null) {
                    this.connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
        return null;
    }

    @Override
    public ArrayList<Client> findAll() {
        ArrayList<Client> clients = new ArrayList<>();
        try{
            this.connection = this.dataSource.getConnection();
            PreparedStatement pSt = this.connection.prepareStatement("SELECT * FROM clients");
            ResultSet rs = pSt.executeQuery();

            while(rs.next()){
                clients.add(
                        new Client(
                                rs.getLong("client_id"),
                                rs.getString("nom_entreprise"),
                                rs.getString("siret"),
                                rs.getString("adresse"),
                                new Comptable(rs.getLong("comptable_id")))
                );
            }
            return clients;
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            try {
                if (this.connection != null) {
                    this.connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
        return clients;
    }

    public ArrayList<Client> findAllByComptable(Long comptableId) {
        ArrayList<Client> clients = new ArrayList<>();
        try{
            this.connection = this.dataSource.getConnection();
            PreparedStatement pSt = this.connection.prepareStatement("SELECT * FROM clients WHERE comptable_id = ?");
            pSt.setLong(1, comptableId);
            ResultSet rs = pSt.executeQuery();

            while(rs.next()){
                clients.add(
                        new Client(
                                rs.getLong("client_id"),
                                rs.getString("nom_entreprise"),
                                rs.getString("siret"),
                                rs.getString("adresse"),
                                new Comptable(rs.getLong("comptable_id")))
                );
            }
            return clients;
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            try {
                if (this.connection != null) {
                    this.connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
        return clients;
    }
}
