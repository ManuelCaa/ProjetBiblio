package dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.IDAOAlbum;
import dao.IDAOOeuvre;
import model.Album;
import model.Oeuvre;

public class DAOOeuvreJDBC implements IDAOOeuvre {

	
	public void ajouter(Oeuvre t) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection(lien+db, login, password);
			PreparedStatement ps= conn.prepareStatement("INSERT INTO oeuvre VALUES(?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, t.getId());
			ps.setString(2,t.getTitre());
			ps.setString(3, t.getDescriptif());
			ps.setString(4,t.getNomFichierImage());
			ps.setInt(5, t.getAnnee());
			ps.setString(6, t.getEditeur());
			ps.setString(7, t.getCreeA().toString());
			ps.setString(8, t.getModifieeA().toString());
			ps.setBoolean(9, t.isModerationEffectuee());
			
			ps.executeUpdate();
			
			ps.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public void modifier(Oeuvre t) {
		try {	
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn=DriverManager.getConnection(lien+db, login, password );

			PreparedStatement ps= conn.prepareStatement("Update oeuvre set  titre=?, descriptif=?, nomFichierImage=?,"
					+ "annee=?, editeur=?, creeA=?, modifieeA=?, moderationEffectuee = ?"
					+ " where id=?");


			ps.setString(1,t.getTitre());
			ps.setString(2, t.getDescriptif());
			ps.setString(3,t.getNomFichierImage());
			ps.setInt(4, t.getAnnee());
			ps.setString(5, t.getEditeur());
			ps.setString(6, t.getCreeA().toString());
			ps.setString(7, t.getModifieeA().toString());
			ps.setBoolean(8, t.isModerationEffectuee());
			ps.setInt(9, t.getId());

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

            PreparedStatement ps=conn.prepareStatement("DELETE FROM oeuvre where id=?");
            ps.setInt(1, id);

            ps.executeUpdate();

            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

	}

	
	public Oeuvre selectById(Integer id) {
	    Oeuvre o=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn=DriverManager.getConnection(lien+db, login, password );

            PreparedStatement ps=conn.prepareStatement("SELECT * FROM oeuvre  where Id=?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) 
            {
                o=new Oeuvre(rs.getString("titre"), rs.getString("descriptif"), rs.getString("nomFichierImage"),rs.getInt("annee"), 
                        rs.getString("editeur"),LocalDate.parse(rs.getString("creeA")),LocalDate.parse(rs.getString("modifieeA")), 
                        rs.getBoolean("moderationEffectuee") );
            }

            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;
	}

	
	public List<Oeuvre> selectAll() {

        List<Oeuvre> oeuvres  = new ArrayList();
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn=DriverManager.getConnection(lien+db, login, password );

            PreparedStatement ps=conn.prepareStatement("SELECT * FROM Oeuvre");

            ResultSet rs = ps.executeQuery();

            Oeuvre o=null;
            while(rs.next()) 
            {
                o=new Oeuvre(rs.getString("titre"), rs.getString("descriptif"), rs.getString("nomFichierImage"),rs.getInt("annee"), 
                        rs.getString("editeur"),LocalDate.parse(rs.getString("creeA")),LocalDate.parse(rs.getString("modifieeA")), 
                        rs.getBoolean("moderationEffectuee") );
                oeuvres.add(o);
            }
            


            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return oeuvres;

    }
	

}




