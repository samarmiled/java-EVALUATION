package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import METIER.ENTITY.Categorie;

import METIER.ENTITY.Produit;

public class CatalogueImpl implements IDAOCatalogue{
	Connection cnx = SingletonConnection.getConnection();
List <Produit> liste = new ArrayList<>();
	@Override
	public Categorie addCategorie(Categorie c) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement stmt = cnx.prepareStatement("insert into categorie (nom) values(?)");
			stmt.setString(1, c.getNom());
		
			stmt.executeUpdate();
		}catch(SQLException e1) {
			e1.printStackTrace();
		}
		return c;
	}
	@Override
	public Produit addProduit(Produit p,Categorie c) {
		// TODO Auto-generated method stub
		Connection cnx = SingletonConnection.getConnection();
		try {
			PreparedStatement stmt = cnx.prepareStatement("insert into produit (nom,prix,quantite,code_cat) values(?,?,?,?) ");
			stmt.setString(1, p.getNom());
			stmt.setDouble(2, p.getPrix());
			stmt.setInt(3, p.getQuantite());
			
			stmt.setInt(4, c.getCode());
		
			stmt.executeUpdate();
		}catch(SQLException e1) {
			e1.printStackTrace();
		}
		return p;
	}

	@Override
	public List<Produit> getAllProduit() {
		// TODO Auto-generated method stub
		List<Produit> liste = new ArrayList<>();
		try {
			PreparedStatement ps = cnx.prepareStatement("select * from produit");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Produit p =new Produit(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4),rs.getInt(5));
				liste.add(p);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return liste;
	}

	@Override
	public List<Categorie> getAllCategories() {
		// TODO Auto-generated method stub
		List<Categorie> liste = new ArrayList<>();
		try {
			PreparedStatement ps = cnx.prepareStatement("select * from categorie");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Categorie c = new Categorie(
				rs.getInt(1),
				rs.getString(2));
				liste.add(c);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return liste;
	}



	@Override
	public List<Produit> getProduit(Categorie c) {
		// TODO Auto-generated method stub
		List<Produit> liste = new ArrayList<>();
		try {
			PreparedStatement ps = cnx.prepareStatement("select * from produit where code_cat=?");
			ps.setInt(1, c.getCode());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				Produit p =new Produit(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4),rs.getInt(5));
				liste.add(p);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return liste;
	}
	@Override
	public void supprimerProduit(int c) {
		// TODO Auto-generated method stub
		Connection cnx = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = cnx.prepareStatement("delete from produit where reference=?");
			ps.setInt(1, c);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	}



