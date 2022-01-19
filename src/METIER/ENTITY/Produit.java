package METIER.ENTITY;

public class Produit {
	private int reference;
	private String nom;
	private Double prix;
	private int quantite;
	private int code_cat;
	public Produit(int reference, String nom, Double prix, int quantite,int code_cat) {
		super();
		this.reference = reference;
		this.nom = nom;
		this.prix = prix;
		this.quantite = quantite;
		this.code_cat=code_cat;
	}
	public Produit( String nom, Double prix, int quantite,int code_cat) {
		super();
	
		this.nom = nom;
		this.prix = prix;
		this.quantite = quantite;
		this.code_cat=code_cat;
	}
	public Produit() {
		super();
	}
	public int getReference() {
		return reference;
	}
	public void setReference(int reference) {
		this.reference = reference;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public int getCode_cat() {
		return code_cat;
	}
	public void setCode_cat(int code_cat) {
		this.code_cat = code_cat;
	}
	@Override
	public String toString() {
		return " [ nom=" + nom + ", prix=" + prix + ", quantite=" + quantite
				+ ", code_cat=" + code_cat + "]";
	}
	
	

}
