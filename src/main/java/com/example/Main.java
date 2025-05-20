package com.example;

import com.example.service.GestionStockService;
import com.example.model.Produit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestionStockService service = new GestionStockService();
        Scanner scanner = new Scanner(System.in);

        int option;
        do {
            System.out.println("\nMENU:");
            System.out.println("1. Ajouter un produit");
            System.out.println("2. Supprimer un produit");
            System.out.println("3. Mettre à jour les informations d'un produit");
            System.out.println("4. Afficher la liste des produits");
            System.out.println("5. Rechercher un produit");
            System.out.println("6. Quitter l'application");
            System.out.print("Choix : ");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Nom : ");
                    String nom = scanner.nextLine();
                    System.out.print("Quantité : ");
                    int quantite = scanner.nextInt();
                    System.out.print("Prix : ");
                    double prix = scanner.nextDouble();
                    scanner.nextLine();
                    Produit nouveau = new Produit(0, nom, quantite, prix); // id = 0 car auto-incrémenté
                    service.ajouterProduit(nouveau);
                    break;

                case 2:
                    System.out.print("ID du produit à supprimer : ");
                    int idSupprimer = scanner.nextInt();
                    scanner.nextLine();
                    service.supprimerProduit(idSupprimer);
                    break;

                case 3:
                    System.out.print("ID du produit à modifier : ");
                    int idModif = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nouveau nom : ");
                    String nomModif = scanner.nextLine();
                    System.out.print("Nouvelle quantité : ");
                    int quantiteModif = scanner.nextInt();
                    System.out.print("Nouveau prix : ");
                    double prixModif = scanner.nextDouble();
                    scanner.nextLine();
                    Produit modif = new Produit(idModif, nomModif, quantiteModif, prixModif);
                    service.modifierProduit(modif);
                    break;

                case 4:
                    service.afficherProduit();
                    break;

                case 5:
                    System.out.print("ID du produit à rechercher : ");
                    int idRecherche = scanner.nextInt();
                    scanner.nextLine();
                    service.rechercherProduit(idRecherche);
                    break;

                case 6:
                    System.out.println("👋 Vous avez quitté l'application.");
                    break;

                default:
                    System.out.println("Option invalide, veuillez réessayer.");
            }

        } while (option != 6);

        scanner.close();
    }
}
