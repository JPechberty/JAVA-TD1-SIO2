package com.courses.repositories;

import com.courses.models.Comptable;
import com.courses.tools.DataSourceProvider;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ComptableRepository implements RepositoryInterface<Comptable, Long> {

    private DataSource dataSource;
    private Connection connection;

    public ComptableRepository() {
        this.dataSource = DataSourceProvider.getDataSourceInstance();
        this.connection = null;
    }

    @Override
    public void create(Comptable entity) {
        try {
            this.connection = this.dataSource.getConnection();
            PreparedStatement pSt = this.connection.prepareStatement("INSERT INTO comptables (nom, prenom, email, telephone) VALUES (?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            pSt.setString(1, entity.getNom());
            pSt.setString(2, entity.getPrenom());
            pSt.setString(3, entity.getEmail());
            pSt.setString(4, entity.getTelephone());
            pSt.executeUpdate();
            ResultSet rs =  pSt.getGeneratedKeys();
            if(rs.next()){
                entity.setId(rs.getLong(1));
            }
            System.out.println("Comptable créé avec l'id : " + entity.getId());
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
    public void update(Comptable entity) {
        try{
            this.connection = this.dataSource.getConnection();
            PreparedStatement pSt = this.connection.prepareStatement("UPDATE comptables SET nom = ?, prenom = ?, email = ?, telephone = ? WHERE comptable_id = ?");
            pSt.setString(1, entity.getNom());
            pSt.setString(2, entity.getPrenom());
            pSt.setString(3, entity.getEmail());
            pSt.setString(4, entity.getEmail());
            pSt.setLong(5, entity.getId());
            pSt.executeUpdate();
            System.out.println("Comptable comportant l'id "+entity.getId()+" mis à jour !");
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
            PreparedStatement pSt = this.connection.prepareStatement("DELETE FROM comptables WHERE comptable_id = ?");
            pSt.setLong(1, aLong);
            pSt.executeUpdate();
            System.out.println("Comptable avec l'id " + aLong + "supprimé !");
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
    public Comptable findById(Long aLong) {
        try {
            this.connection = this.dataSource.getConnection();
            PreparedStatement pSt = this.connection.prepareStatement("SELECT * FROM comptables WHERE comptable_id = ?");
            pSt.setLong(1, aLong);
            ResultSet rs = pSt.executeQuery();
            if(rs.next()){
                return new Comptable(rs.getLong("comptable_id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"));
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
    public ArrayList<Comptable> findAll() {
        ArrayList<Comptable> comptables = new ArrayList<>();
        try {
            this.connection = this.dataSource.getConnection();
            PreparedStatement pSt = this.connection.prepareStatement("SELECT * FROM comptables");
            ResultSet rs = pSt.executeQuery();
            while(rs.next()){
                comptables.add(new Comptable(rs.getLong("comptable_id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("telephone")));
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
        return comptables;
    }
}
