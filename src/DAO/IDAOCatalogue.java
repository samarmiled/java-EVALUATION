package DAO;

import java.util.List;

import METIER.ENTITY.Categorie;
import METIER.ENTITY.Produit;

public interface IDAOCatalogue {
	public Categorie addCategorie(Categorie c);
	public Produit addProduit(Produit p, Categorie c);
	public List<Produit> getAllProduit();
	public List<Categorie> getAllCategories();
	public List<Produit> getProduit(Categorie c);
	public void supprimerProduit(int code);

}
