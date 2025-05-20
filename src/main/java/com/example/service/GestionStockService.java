package com.example.service;

import com.example.model.Produit;
import com.example.utils.ConnexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GestionStockService {


    public void ajouterProduit(Produit produit) {
        String sql = "INSERT INTO produits (nom, quantite, prix) VALUES (?, ?, ?)";
        try (Connection conn = ConnexionBD.getConnection();
             PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            st.setString(1, produit.getNom());
            st.setInt(2, produit.getQuantite());
            st.setDouble(3, produit.getPrix());
            st.executeUpdate();

            // Récupérer l'ID auto généré et le mettre dans l'objet produit
            ResultSet generatedKeys = st.getGeneratedKeys();
            if (generatedKeys.next()) {
                produit.setId(generatedKeys.getInt(1));
            }

            System.out.println("Produit ajouté avec ID : " + produit.getId());
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout : " + e.getMessage());
        }
    }


    public void supprimerProduit(int id) {
        String sql = "DELETE FROM produits WHERE id = ?";
        try (Connection conn = ConnexionBD.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, id);
            int rows = st.executeUpdate();
            if (rows > 0) {
                System.out.println("Produit supprimé.");
            } else {
                System.out.println("Produit non trouvé.");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression : " + e.getMessage());
        }
    }


    public void modifierProduit(Produit produit) {
        String sql = "UPDATE produits SET nom = ?, quantite = ?, prix = ? WHERE id = ?";
        try (Connection conn = ConnexionBD.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, produit.getNom());
            st.setInt(2, produit.getQuantite());
            st.setDouble(3, produit.getPrix());
            st.setInt(4, produit.getId());
            int rows = st.executeUpdate();
            if (rows > 0) {
                System.out.println("Produit mis à jour.");
            } else {
                System.out.println("Produit non trouvé.");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la modification : " + e.getMessage());
        }
    }

    public void afficherProduit() {
        String sql = "SELECT * FROM produits";
        try (Connection conn = ConnexionBD.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Produit p = new Produit(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getInt("quantite"),
                        rs.getDouble("prix")
                );
                System.out.println(p);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'affichage : " + e.getMessage());
        }
    }


    public Produit rechercherProduit(int id) {
        String sql = "SELECT * FROM produits WHERE id = ?";
        try (Connection conn = ConnexionBD.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, id);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    Produit p = new Produit(
                            rs.getInt("id"),
                            rs.getString("nom"),
                            rs.getInt("quantite"),
                            rs.getDouble("prix")
                    );
                    System.out.println(p);
                    return p;
                } else {
                    System.out.println("Produit non trouvé.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la recherche : " + e.getMessage());
        }
        return null;
    }
}
