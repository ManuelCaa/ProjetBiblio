package dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import config.Context;
import dao.IDAOFiche;
import model.Bibliotheque;
import model.Fiche;
import model.Oeuvre;

public class DAOFicheJDBC implements IDAOFiche{

	
	public void ajouter(Fiche t) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn=DriverManager.getConnection(lien+db, login, password);
			PreparedStatement ps= conn.prepareStatement("INSERT INTO fiche VALUES(?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, t.getId());
			ps.setInt(2,t.getNote());
			if(t.getPretee()!=null) ps.setString(3, t.getPretee());
			else ps.setString(3,null);
			ps.setInt(4, t.getLu());
			
			if(t.getAvis()!=null) ps.setString(5, t.getAvis());
			else ps.setString(5, null);
			
			ps.setDouble(6, t.getDuree());
			ps.setString(7, t.getCreeA().toString());
			ps.setString(8, t.getModifieA().toString());
			
			ps.setObject(9, t.getOeuvre().getId());
			ps.setObject(10, t.getBiblio().getId());
			ps.executeUpdate();
			
			ps.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public void modifier(Fiche t) {
		
		try {	
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection(lien+db, login, password );
			
			PreparedStatement ps= conn.prepareStatement("Update fiche set note=?, pretee=?, luVisionee=?, avis=?, duree=?, creeA=?,modifieA=?,oeuvreId=?, biblioId=? where id=?");

			ps.setInt(1,t.getNote());
			if(t.getPretee()!=null) ps.setString(2, t.getPretee());
			else ps.setString(2,null);
			ps.setInt(3, t.getLu());
			
			if(t.getAvis()!=null) ps.setString(4, t.getAvis());
			else ps.setString(4, null);
			
			ps.setDouble(5, t.getDuree());
			ps.setString(6, t.getCreeA().toString());
			ps.setString(7, t.getModifieA().toString());
			ps.setObject(8, t.getOeuvre().getId());
			
			ps.setInt(9, t.getId());
			ps.setObject(10, t.getBiblio().getId());
			
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

			PreparedStatement ps=conn.prepareStatement("DELETE FROM fiche where oeuvreId=?");
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public Fiche selectById(Integer id) {
		Fiche f=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection(lien+db, login, password );
			
			PreparedStatement ps=conn.prepareStatement("SELECT * from fiche JOIN oeuvre on fiche.oeuvreId=oeuvre.id where ouvreId=?");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) 
			{
				Oeuvre o = Context.getInstance().getDaoOeuvre().selectById(rs.getInt("oeuvreId"));
				Bibliotheque b = Context.getInstance().getDaoBibliotheque().selectById(rs.getInt("idBiblio"));
				f=new Fiche(rs.getInt("note"), rs.getString("pretee"),rs.getInt("luVisionnee"),rs.getString("avis"), rs.getInt("duree"), LocalDate.parse(rs.getString("creeA")), LocalDate.parse(rs.getString("modifieA")),o,b);		
			}
			
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	
	public List<Fiche> selectAll() {
		
		List<Fiche> fiches  = new ArrayList();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection(lien+db, login, password );
			
			PreparedStatement ps=conn.prepareStatement("SELECT * from fiche JOIN oeuvre on fiche.oeuvreId=oeuvre.id");
			
			ResultSet rs = ps.executeQuery();
			
			Fiche f=null;
			while(rs.next()) 
			{
				Oeuvre o = Context.getInstance().getDaoOeuvre().selectById(rs.getInt("oeuvreId"));
				Bibliotheque b = Context.getInstance().getDaoBibliotheque().selectById(rs.getInt("idBiblio"));
				f=new Fiche(rs.getInt("note"), rs.getString("pretee"),rs.getInt("luVisionnee"),rs.getString("avis"), rs.getInt("duree"), LocalDate.parse(rs.getString("creeA")), LocalDate.parse(rs.getString("modifieA")), o,b);		
				fiches.add(f);
			}
				
			
			
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fiches;
	}

}
