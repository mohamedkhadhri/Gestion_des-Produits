package com.tekup.produits.controller;

import com.tekup.produits.view.ProductView;
import com.tekup.produits.view.ProductDisplayWindow;
import com.tekup.produits.dao.ProductDAO;
import com.tekup.produits.model.Product;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductController {
    private ProductView view;
    private ProductDAO productDAO = new ProductDAO();

    public ProductController(ProductView view) {
        this.view = view;

        // Ajouter les écouteurs pour les boutons
        this.view.addButton.addActionListener(new AddProductListener());
        this.view.deleteButton.addActionListener(new DeleteProductListener());
        this.view.modifyButton.addActionListener(new ModifyProductListener());
        this.view.displayButton.addActionListener(new DisplayProductsListener());
    }

    // Ajouter un produit
    class AddProductListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int id = Integer.parseInt(view.idField.getText());
            String name = view.nameField.getText();
            double price = Double.parseDouble(view.priceField.getText());

            Product product = new Product(id, name, price);
            productDAO.addProduct(product);
        }
    }
    

    // Supprimer un produit
    class DeleteProductListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int id = Integer.parseInt(view.idField.getText());
            productDAO.deleteProduct(id);
        }
    }

    // Modifier un produit
    class ModifyProductListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int id = Integer.parseInt(view.idField.getText());
            String newName = view.nameField.getText();
            double newPrice = Double.parseDouble(view.priceField.getText());

            Product product = new Product(id, newName, newPrice);
            productDAO.modifyProduct(product);
        }
    }

    // Afficher tous les produits dans une nouvelle fenêtre
    class DisplayProductsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Ouvrir la nouvelle fenêtre avec les produits
            new ProductDisplayWindow().setVisible(true);
        }
    }
}
