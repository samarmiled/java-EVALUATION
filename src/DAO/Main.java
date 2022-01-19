package DAO;

import METIER.ENTITY.Categorie;
import METIER.ENTITY.Produit;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
CatalogueImpl catalogue = new CatalogueImpl();

//catalogue.addCategorie(new Categorie(3, "Clothes"));
System.out.println(catalogue.getAllCategories());
System.out.println(catalogue.getAllProduit());
System.out.println(catalogue.getProduit(new Categorie(4, "Informatique")));
	}

}
