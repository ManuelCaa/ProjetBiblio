//package dao.jdbc;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//import dao.IDAOCompte;
//import model.Album;
//import model.Compte;
//
//public class DAOCompteJDBC implements IDAOCompte {
//
//	String lien="jdbc:mysql://localhost:3306/";
//	String db="bibliotheque";
//	String login="root";
//	String password="";
//	public void insert(Compte t) {
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			
//			Connection conn=DriverManager.getConnection(lien+db, login, password);
//			PreparedStatement ps= conn.prepareStatement("INSERT INTO compte VALUES(?,?,?,?)");
//			ps.setInt(1, t.getId());
//			ps.setString(2, t.getMail());
//			ps.setString(3,t.getPseudo());
//			ps.setString(4, t.getPassword());
//			
//			ps.executeUpdate();
//
//			ps.close();
//			conn.close();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
//
//	
//	public void update(Compte t) {
//		try {	
//			Class.forName("com.mysql.jdbc.Driver");
//			
//			Connection conn=DriverManager.getConnection(lien+db, login, password );
//			
//			PreparedStatement ps= conn.prepareStatement("Update compte set  mail=?, pseudo=? , password=?, where id=?");
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
//		
//	}
//
//	
//	public void selectById(Integer id) {
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			
//			Connection conn=DriverManager.getConnection(lien+db, login, password );
//
//			PreparedStatement ps=conn.prepareStatement("DELETE FROM compte where id=?");
//			ps.setInt(1, id);
//			
//			ps.executeUpdate();
//			
//			ps.close();
//			conn.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
//
//	
//	public Compte selectById(Integer id) {
//		Compte c=null;
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			
//			Connection conn=DriverManager.getConnection(lien+db, login, password );
//			
//			PreparedStatement ps=conn.prepareStatement("SELECT * FROM compte where id=?");
//			ps.setInt(1, id);
//			
//			ResultSet rs = ps.executeQuery();
//			
//			while(rs.next()) 
//			{
//				c = new Compte(rs.getString("mail"),rs.getString("password"),rs.getString("pseudo"));
//			}
//			
//			rs.close();
//			ps.close();
//			conn.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return c;
//	}
//
//	
//	public List<Compte> findAll() {
//		List<Compte> comptes  = new ArrayList();
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			
//			Connection conn=DriverManager.getConnection(lien+db, login, password );
//			
//			PreparedStatement ps=conn.prepareStatement("SELECT * FROM compte");
//			
//			ResultSet rs = ps.executeQuery();
//			
//			Compte c=null;
//			while(rs.next()) 
//			{
//				c = new Compte(rs.getString("mail"),rs.getString("password"),rs.getString("pseudo"));
//				comptes.add(c);
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
//		return comptes;
//	}
//
//
//}
