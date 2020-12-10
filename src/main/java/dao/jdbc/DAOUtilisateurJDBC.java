//package dao.jdbc;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.List;
//
//import config.Context;
//import dao.IDAOUtilisateur;
//import model.Bibliotheque;
//import model.Compte;
//import model.Utilisateur;
//
//public class DAOUtilisateurJDBC implements IDAOUtilisateur{
//
//	String lien="jdbc:mysql://localhost:3306/";
//	String db="bibliotheque";
//	String login="root";
//	String password="";
//	public void insert(Utilisateur t) {
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			
//			Connection conn=DriverManager.getConnection(lien+db, login, password);
//			PreparedStatement ps= conn.prepareStatement("INSERT INTO utilisateur VALUES(?,?,?,?,?)");
//			ps.setInt(1, t.getId());
//			ps.setString(2, t.getMail());
//			ps.setString(3,t.getPseudo());
//			ps.setString(4, t.getPassword());
//			ps.setInt(5, t.getBibliotheque().getId());
//			
//			ps.executeUpdate();
//			
//			ps.close();
//			conn.close();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	
//	public void update(Utilisateur t) {
//		try {	
//			Class.forName("com.mysql.jdbc.Driver");
//			
//			Connection conn=DriverManager.getConnection(lien+db, login, password );
//			
//			PreparedStatement ps= conn.prepareStatement("Update utilisateur Join bibliotheque on utilisateur.idBiblio=bibliotheque.id set  mail=?, pseudo=? , password=?, idBiblio=?, where id=?");
//			
//			ps.setString(1,t.getMail());
//			ps.setString(2, t.getPseudo());
//			ps.setString(3, t.getPassword());
//			ps.setInt(4, t.getId());
//			
//			ps.executeUpdate();
//			
//			ps.close();
//			conn.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	
//	public void selectById(Integer id) {
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			
//			Connection conn=DriverManager.getConnection(lien+db, login, password );
//
//			PreparedStatement ps=conn.prepareStatement("DELETE FROM utilisateur where id=?");
//			ps.setInt(1, id);
//			
//			ps.executeUpdate();
//			
//			ps.close();
//			conn.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	
//	public Utilisateur selectById(Integer id) {
//		Utilisateur u=null;
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			
//			Connection conn=DriverManager.getConnection(lien+db, login, password );
//			
//			PreparedStatement ps=conn.prepareStatement("SELECT * FROM utilisateur where id=?");
//			ps.setInt(1, id);
//			
//			ResultSet rs = ps.executeQuery();
//			
//			while(rs.next()) 
//			{
//				Bibliotheque b = Context.getInstance().getDaoBibliotheque().findById(rs.getInt("idBiblio"));
//				u = new Utilisateur(rs.getString("mail"),rs.getString("password"),rs.getString("pseudo"),b);
//			}
//			
//			rs.close();
//			ps.close();
//			conn.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return u;
//	}
//
//	
//	public List<Utilisateur> findAll() {
//		List<Utilisateur> utilisateurs  = new ArrayList();
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			
//			Connection conn=DriverManager.getConnection(lien+db, login, password );
//			
//			PreparedStatement ps=conn.prepareStatement("SELECT * FROM utilisateur");
//			
//			ResultSet rs = ps.executeQuery();
//			
//			Utilisateur u=null;
//			while(rs.next()) 
//			{
//				Bibliotheque b = Context.getInstance().getDaoBibliotheque().findById(rs.getInt("idBiblio"));
//				u = new Utilisateur(rs.getString("mail"),rs.getString("password"),rs.getString("pseudo"),b);
//				utilisateurs.add(u);
//			}
//				
//			
//			
//			rs.close();
//			ps.close();
//			conn.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return utilisateurs;
//	}
//
//}
