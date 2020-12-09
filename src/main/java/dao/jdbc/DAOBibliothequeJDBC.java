package dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.IDAOBibliotheque;
import model.Bibliotheque;
import model.Visibilite;

public class DAOBibliothequeJDBC implements IDAOBibliotheque{

	
	public void ajouter(Bibliotheque t) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn=DriverManager.getConnection(lien+db, login, password);
			PreparedStatement ps= conn.prepareStatement("INSERT INTO bibliotheque VALUES(?,?,?)");
			ps.setInt(1, t.getId());
			ps.setString(2,t.getNom());
			ps.setString(3, t.getVisibilite().toString());
			ps.executeUpdate();

			ps.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void modifier(Bibliotheque t) {

		try {	
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn=DriverManager.getConnection(lien+db, login, password );

			PreparedStatement ps= conn.prepareStatement("Update bibliotheque set  nom=?, visibilite=? where id=?");

			ps.setString(1,t.getNom());
			ps.setString(2, t.getVisibilite().toString());
			ps.setInt(3, t.getId());

			ps.executeUpdate();

			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

	
	public void supprimer(Integer id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn=DriverManager.getConnection(lien+db, login, password );

			PreparedStatement ps=conn.prepareStatement("DELETE FROM bibliotheque where id=?");
			ps.setInt(1, id);

			ps.executeUpdate();

			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public Bibliotheque selectById(Integer id) {
		Bibliotheque b=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn=DriverManager.getConnection(lien+db, login, password );

			PreparedStatement ps=conn.prepareStatement("SELECT * FROM bibliotheque JOIN fiche on fiche.id=bibliotheque.id where bibliotheque.id=?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{

				b=new Bibliotheque(Visibilite.valueOf(rs.getString("visibilite")), rs.getString("nom")); 			
			}

			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	
	public List<Bibliotheque> selectAll() {
		List<Bibliotheque> bibliotheques  = new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn=DriverManager.getConnection(lien+db, login, password );

			PreparedStatement ps=conn.prepareStatement("SELECT * FROM bibliotheque JOIN fiche on bibliotheque.id=fiche.biblioId JOIN oeuvre on oeuvre.id=fiche.oeuvreId ");

			ResultSet rs = ps.executeQuery();

			Bibliotheque b=null;
			while(rs.next()) 
			{
				b=new Bibliotheque(Visibilite.valueOf(rs.getString("visibilite")), rs.getString("nom")); 	
				bibliotheques.add(b);
			}
			


			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bibliotheques;
	}
	public Bibliotheque selectByIdCompte(Integer id) {
		Bibliotheque b=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn=DriverManager.getConnection(lien+db, login, password );

			PreparedStatement ps=conn.prepareStatement("SELECT * FROM bibliotheque where idCompte=?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{

				b=new Bibliotheque(Visibilite.valueOf(rs.getString("visibilite")), rs.getString("nom")); 
				b.setId(rs.getInt("id"));

			}

			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
}



