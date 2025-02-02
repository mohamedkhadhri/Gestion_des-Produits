package com.tekup.produits.view;

import javax.swing.*;
import java.awt.*;

public class ProductView extends JFrame {
    private static final long serialVersionUID = 1L;

    public JTextField idField = new JTextField(10);
    public JTextField nameField = new JTextField(10);
    public JTextField priceField = new JTextField(10);
    public JButton addButton = new JButton("Ajouter");
    public JButton deleteButton = new JButton("Supprimer");
    public JButton modifyButton = new JButton("Modifier");
    public JButton displayButton = new JButton("Afficher");

    public ProductView() {
        setTitle("Gestion des Produits");
        setSize(450, 400);
        setLocationRelativeTo(null);  // Centrer la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Créer un panneau principal avec GridBagLayout pour plus de flexibilité
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);  // Espacement autour des composants

        // Ajouter des labels et des champs de texte avec une disposition plus élégante
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("ID:"), gbc);

        gbc.gridx = 1;
        panel.add(idField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Nom:"), gbc);

        gbc.gridx = 1;
        panel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Prix:"), gbc);

        gbc.gridx = 1;
        panel.add(priceField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        addButton.setPreferredSize(new Dimension(200, 40));  // Agrandir le bouton
        panel.add(addButton, gbc);

        // Ajouter les boutons supplémentaires
        gbc.gridy = 4;
        panel.add(deleteButton, gbc);
        gbc.gridy = 5;
        panel.add(modifyButton, gbc);
        gbc.gridy = 6;
        panel.add(displayButton, gbc);

        // Disposition générale
        add(panel, BorderLayout.NORTH);

        // Personnalisation des couleurs et des polices
        panel.setBackground(new Color(240, 240, 240));
        addButton.setBackground(new Color(0, 123, 255));  // Bleu
        addButton.setForeground(Color.WHITE);
        addButton.setFont(new Font("Arial", Font.BOLD, 14));

        deleteButton.setBackground(new Color(255, 69, 0));  // Rouge
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setFont(new Font("Arial", Font.BOLD, 14));

        modifyButton.setBackground(new Color(255, 165, 0));  // Orange
        modifyButton.setForeground(Color.WHITE);
        modifyButton.setFont(new Font("Arial", Font.BOLD, 14));

        displayButton.setBackground(new Color(34, 139, 34));  // Vert
        displayButton.setForeground(Color.WHITE);
        displayButton.setFont(new Font("Arial", Font.BOLD, 14));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ProductView().setVisible(true);
        });
    }
}
