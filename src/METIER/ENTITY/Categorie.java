package METIER.ENTITY;

public class Categorie {
private int code;
private String nom;
public Categorie(int code, String nom) {
	super();
	this.code = code;
	this.nom = nom;
}
public Categorie() {}
public Categorie( String nom) {
	super();
	this.nom = nom;
}
public int getCode() {
	return code;
}
public void setCode(int code) {
	this.code = code;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
@Override
public String toString() {
	return nom;
}


}
