package dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.IDAOAlbum;
import model.Album;

public class DAOAlbumJDBC implements IDAOAlbum {

	String lien="jdbc:mysql://localhost:3306/";
	String db="bibliotheque";
	String login="root";
	String password="";
	public void insert(Album t) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection(lien+db, login, password);
			PreparedStatement ps= conn.prepareStatement("INSERT INTO album VALUES(?,?,?)");
			ps.setInt(1, t.getId());
			ps.setInt(2,t.getNombreMorceaux());
			ps.setString(3, t.getArtiste());
			
			ps.executeUpdate();
			
			ps.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	 
	public void update(Album t) {
		
		try {	
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection(lien+db, login, password );
			
			PreparedStatement ps= conn.prepareStatement("Update album set  nombreMorceaux=?, artiste=? where id=?");
			
			ps.setInt(1,t.getNombreMorceaux());
			ps.setString(2, t.getArtiste());
			ps.setInt(3, t.getId());
			
			ps.executeUpdate();
			
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	 
	public void deleteById(Integer id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection(lien+db, login, password );

			PreparedStatement ps=conn.prepareStatement("DELETE FROM album where id=?");
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	 
	public Album selectById(Integer id) {
		Album a=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection(lien+db, login, password );
			
			PreparedStatement ps=conn.prepareStatement("SELECT * FROM album JOIN oeuvre on album.id=oeuvre.id where album.id=?");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) 
			{
				a=new Album(rs.getString("titre"), rs.getString("descriptif"), rs.getString("nomFichierImage"),rs.getInt("annee"), 
						rs.getString("editeur"),LocalDate.parse(rs.getString("creeA")),LocalDate.parse(rs.getString("modifieeA")), 
						rs.getBoolean("moderationEffectuee"), rs.getInt("nombreMorceaux"),rs.getString("artiste") );			
			}
			
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	 
	public List<Album> findAll() {
		List<Album> albums  = new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection(lien+db, login, password );
			
			PreparedStatement ps=conn.prepareStatement("SELECT * FROM album JOIN oeuvre on album.id=oeuvre.id");
			
			ResultSet rs = ps.executeQuery();
			
			Album a=null;
			while(rs.next()) 
			{
				a=new Album(rs.getString("titre"), rs.getString("descriptif"), rs.getString("nomFichierImage"),rs.getInt("annee"), 
						rs.getString("editeur"),LocalDate.parse(rs.getString("creeA")),LocalDate.parse(rs.getString("modifieeA")), 
						rs.getBoolean("moderationEffectuee"), rs.getInt("nombreMorceaux"),rs.getString("artiste") );
				albums.add(a);
			}
				
			
			
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return albums;
	}

}
