package com.tekup.produits.view;

import com.tekup.produits.model.Product;
import com.tekup.produits.dao.ProductDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ProductDisplayWindow extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTable table;
    private DefaultTableModel tableModel;

    public ProductDisplayWindow() {
        setTitle("Affichage des Produits");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Créer le modèle de tableau avec les colonnes
        tableModel = new DefaultTableModel(new Object[] { "ID", "Nom", "Prix" }, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);
        loadProductData();
    }

    // Charger les données de la base de données dans le tableau
    private void loadProductData() {
        ProductDAO productDAO = new ProductDAO();
        List<Product> products = productDAO.getAllProducts();

        // Effacer les anciennes lignes
        tableModel.setRowCount(0);

        // Ajouter les produits au modèle du tableau
        for (Product p : products) {
            Object[] row = { p.getId(), p.getName(), p.getPrice() };
            tableModel.addRow(row);
        }
    }
}
