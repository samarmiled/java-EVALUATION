package PRESENTATION;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.table.TableModel;

import DAO.CatalogueImpl;
import DAO.SingletonConnection;
import METIER.ENTITY.Categorie;
import METIER.ENTITY.Produit;
import PRESENTATION.TableModele;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;

public class Model extends JFrame {
	JPanel titlePanel = new JPanel();
	JPanel quitter = new JPanel();
	JPanel detailsbody = new JPanel(new BorderLayout());
	JPanel formPanel = new JPanel(new BorderLayout());
	JPanel categoriesPanel = new JPanel(new BorderLayout());
	JPanel p_Bas = new JPanel(new FlowLayout());

	JPanel ptable = new JPanel(new GridLayout(1, 1));
	JPanel pRecherche = new JPanel(new FlowLayout());
	JPanel detailsPanel = new JPanel(new BorderLayout());
	JPanel tablebody = new JPanel();
	JPanel pForm = new JPanel(new GridLayout(5, 2,10,10));
	JPanel pFormCat = new JPanel(new GridLayout(3, 2,10,10));
	CatalogueImpl catalogue = new CatalogueImpl();
	TableModele tm = new TableModele();
	JTable table = new JTable(tm);
	JScrollPane jsp = new JScrollPane(table);

	JLabel jLabel1 = new JLabel();
	JLabel jLabeltxt = new JLabel();
	JLabel selectionner = new JLabel();
	JLabel lblName = new JLabel("NOM");
	JLabel lblPrix = new JLabel("PRIX");
	JLabel lblQte = new JLabel("QUANTITE");
	JLabel lblCat = new JLabel("Categories");
	JLabel lblNameCat = new JLabel("NOM CATEGORIE");

	JTextField txtName = new JTextField();
	JTextField txtPrix = new JTextField();
	JTextField txtQte = new JTextField();
	JTextField txtCat = new JTextField();

	JButton B_quitter = new JButton("QUITTER");
	JButton B_supprimer = new JButton("SUPPRIMER");
	JButton b1 = new JButton("AJOUTER");
	JButton b2 = new JButton("QUITTER");
	JButton b3 = new JButton("AJOUTER CATEGORIE");

	JComboBox<Categorie> categories = new JComboBox<Categorie>();
	JComboBox<Categorie> categories2 = new JComboBox<Categorie>();
	
	int n =-1;


	public Model() {
		tm.charger(catalogue.getAllProduit());
		this.setLayout(new BorderLayout());
		JTabbedPane jTabbedPane = new JTabbedPane() {
			public Color getForegroundAt(int index) {
				if (getSelectedIndex() == index)
					return Color.BLACK;
				return Color.BLACK;
			}

			public Color getBackgroundAt(int index) {
				if (getSelectedIndex() == index)
					return new java.awt.Color(0, 102, 153);
				return new java.awt.Color(0, 102, 153);
			}
		};
		jLabeltxt.setFont(new Font("Times New Roman", 1, 24));
		jLabeltxt.setForeground(new Color(255, 255, 255));
		jLabeltxt.setText(" GESTION DE CATALOGUE DE PRODUIT");

		titlePanel.setBackground(new Color(0, 102, 102));
		titlePanel.setLayout(new GridBagLayout());
		titlePanel.add(jLabeltxt);

		selectionner.setFont(new Font("Tahoma", 0, 20));
		selectionner.setText("Séléctionner une catégorie      ");

		categories.setFont(new Font("Tahoma", 0, 18));

		pRecherche.setBackground(new Color(0, 102, 102));

		jLabel1.setBackground(new Color(0, 102, 153));
		jLabel1.setFont(new Font("Tahoma", 1, 24));
		jLabel1.setForeground(new Color(255, 255, 255));
		jLabel1.setText("CATALOGUE DE PRODUITS");

		pRecherche.add(selectionner);
		pRecherche.add(categories);

		jTabbedPane.setFont(new Font("Tahoma", 0, 14));
		jTabbedPane.addTab("CATALOGUE DE PRODUITS", detailsPanel);
		jTabbedPane.addTab("AJOUTER PRODUIT", formPanel);
		jTabbedPane.addTab("AJOUTER CATEGORIE ", categoriesPanel);

		detailsPanel.setBackground(new Color(0, 102, 102));
		detailsbody.setBackground(new Color(0, 102, 102));
		formPanel.setBackground(new Color(0, 102, 102));
		pForm.setBackground(new Color(0, 102, 102));
		pFormCat.setBackground(new Color(0, 102, 102));
		categoriesPanel.setBackground(new Color(0, 102, 102));
		detailsPanel.add(jLabel1, BorderLayout.NORTH);

		detailsbody.add(pRecherche, BorderLayout.NORTH);
		detailsbody.add(ptable, BorderLayout.CENTER);
		detailsbody.add(quitter, BorderLayout.SOUTH);
		detailsPanel.add(detailsbody, BorderLayout.CENTER);

		ptable.add(jsp);

		B_quitter.setFont(new Font("Tahoma", 0, 14));
		B_quitter.setPreferredSize(new DimensionUIResource(150, 40));
		p_Bas.add(B_quitter);
		p_Bas.add(B_supprimer);
		quitter.add(p_Bas);
		
		
		B_supprimer.setFont(new Font("Tahoma", 0, 14));
		B_supprimer.setPreferredSize(new DimensionUIResource(150, 40));

		JLabel lblRegister = new JLabel("AJOUTER UN NOUVEAU PRODUIT");
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setForeground(new Color(219, 189, 250  ));
		lblRegister.setFont(new Font("Tahoma", Font.PLAIN, 14));

		pForm.add(lblName);
		pForm.add(txtName);
		pForm.add(lblPrix);
		pForm.add(txtPrix);
		pForm.add(lblQte);
		pForm.add(txtQte);
		pForm.add(lblCat);
		pForm.add(categories2);
		pForm.add(b1);
		pForm.add(b2);

		JPanel pCenter = new JPanel(new FlowLayout(FlowLayout.CENTER));
		pCenter.setBackground(new Color(0, 102, 102));
		pCenter.add(pForm);
		formPanel.setLayout(new BorderLayout());
		formPanel.add("North", lblRegister);
		formPanel.add("Center", pCenter);

		JLabel lblRegisterCat = new JLabel("AJOUTER UN NOUVEAU CATEGORIE");
		lblRegisterCat.setForeground(new Color(219, 189, 250  ));
		lblRegisterCat.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblRegisterCat.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblNameCat.setFont(new Font("Tahoma", Font.PLAIN, 14));

		pFormCat.add(lblNameCat);
		pFormCat.add(txtCat);
		pFormCat.add(b3);

		JPanel pCenterCat = new JPanel(new FlowLayout(FlowLayout.CENTER));
		pCenterCat.setBackground(new Color(0, 102, 102));
		pCenterCat.add(pFormCat);
		categoriesPanel.setLayout(new BorderLayout());
		categoriesPanel.add("North", lblRegisterCat);
		categoriesPanel.add("Center", pCenterCat);

		try {
			Connection cnx = SingletonConnection.getConnection();
			categories.addItem(new Categorie(0,"All"));
			PreparedStatement St = cnx.prepareStatement("select * from categorie");
			ResultSet rs = St.executeQuery();
			while (rs.next()) {
				categories2.addItem(new Categorie(rs.getInt(1), rs.getString(2)));
				categories.addItem(new Categorie(rs.getInt(1), rs.getString(2)));
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
 
	
	   categories.addActionListener(new ActionListener(){
		    
			@Override
			public void actionPerformed(ActionEvent e) {
				if(categories.getSelectedItem().toString() != null) {
					System.out.println(((Categorie)categories.getSelectedItem()).getCode());
					Categorie c=new Categorie();
					c.setCode(((Categorie)categories.getSelectedItem()).getCode());
					if (c.getCode()==0) {
						tm.charger(catalogue.getAllProduit());
					}else {
						tm.charger(catalogue.getProduit(c));

					}
				}
				
				    
			}
		});

		b1.addActionListener(e -> {
			Categorie cat = (Categorie) categories2.getSelectedItem();
			System.out.println(cat.getCode());

			int res = JOptionPane.showConfirmDialog(this,
					txtName.getText() + "\n" + "\n\nVoulez vous ajouter ce produit?", "Ajouter produit",
					JOptionPane.YES_NO_OPTION);
			if (res == 0) {
				Produit produit;
				Double price = Double.parseDouble(txtPrix.getText());
				int qte = Integer.parseInt(txtQte.getText());
				produit = catalogue.addProduit(new Produit(txtName.getText(), price, qte, cat.getCode()), cat);
				tm.charger(catalogue.getAllProduit());

			}

		});
		b2.addActionListener(e->{
			System.exit(0);
		});
		b3.addActionListener(e -> {
			int res = JOptionPane.showConfirmDialog(this,
					txtCat.getText() + "\n" + "\n\nVoulez vous ajouter cette categorie?", "Ajouter Categorie",
					JOptionPane.YES_NO_OPTION);
			if (res == 0) {
				Categorie cate;
			
				cate = catalogue.addCategorie(new Categorie(txtCat.getText()));

			}

		});

		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				n= table.getSelectedRow();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		B_supprimer.addActionListener(e->{
			if(n==-1)
				JOptionPane.showMessageDialog(null,"selectioner un produit");
			else {
				int res=JOptionPane.showConfirmDialog(null, "voulez-vous supprimer ce produit");
				if(res==0) {
				int id = (int) tm.getValueAt(n, 0);
				catalogue.supprimerProduit(id);
				tm.charger(catalogue.getAllProduit());
				n=-1;}
				
			}
		});
		B_quitter.addActionListener(e->{
		System.exit(0);
	    });
		this.add(jTabbedPane);
		this.add(titlePanel, BorderLayout.NORTH);
		this.setSize(1700, 800);
		this.setVisible(true);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Model();
	}

}
