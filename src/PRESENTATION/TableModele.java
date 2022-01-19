package PRESENTATION;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import DAO.CatalogueImpl;
import METIER.ENTITY.Categorie;
import METIER.ENTITY.Produit;



public class TableModele extends AbstractTableModel{
	private List<Produit> liste;
	private String colonnes[]=  {"Id","Nom","Prix","Quantité","Categorie"};
	
public TableModele () {
	liste = new ArrayList<>();
}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return liste.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return colonnes.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		switch(columnIndex) {
		case 0:
			return liste.get(rowIndex).getReference();
		case 1:
			return liste.get(rowIndex).getNom();
		case 2:
			return liste.get(rowIndex).getPrix();
		case 3:
			return liste.get(rowIndex).getQuantite();
		case 4:
			return toCategory(liste.get(rowIndex).getCode_cat());
		}
		
		return null;
	}
	
	public String toCategory(int code) {
		List<Categorie> categories=(new CatalogueImpl()).getAllCategories();
		for (Categorie c : categories) {
			if (code == c.getCode())
				return c.getNom();
		}
		return "";
	}
	@Override
public String getColumnName(int column) {
	return colonnes[column];
}
	public void charger(List<Produit> l) {
		this.liste=l;
		fireTableDataChanged();
	}
	
}
