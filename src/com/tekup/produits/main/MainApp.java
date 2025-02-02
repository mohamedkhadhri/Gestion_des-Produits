package com.tekup.produits.main;
import com.tekup.produits.view.ProductView;
import com.tekup.produits.controller.ProductController;

public class MainApp {
	public static void main(String[] args) {
        ProductView view = new ProductView();
        new ProductController(view);
        view.setVisible(true);
    }

}
