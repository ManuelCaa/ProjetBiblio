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
//import config.Context;
//import dao.IDAOFollowers;
//import model.Album;
//import model.Bibliotheque;
//import model.Compte;
//import model.Followers;
//
//public class DAOFollowersJDBC implements IDAOFollowers{
//	String lien="jdbc:mysql://localhost:3306/";
//	String db="bibliotheque";
//	String login="root";
//	String password="";
//	
//	public void insert(Followers t) {
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			
//			Connection conn=DriverManager.getConnection(lien+db, login, password);
//			PreparedStatement ps= conn.prepareStatement("INSERT INTO followers VALUES(?,?,?)");
//			ps.setInt(1, t.getId());//pour l'utilisateur
//			ps.setInt(2, t.getId_follower());
//			ps.setBoolean(3,t.isRejectOrAcceptOption());
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
//	public void update(Followers t) {
//		try {	
//			Class.forName("com.mysql.jdbc.Driver");
//			
//			Connection conn=DriverManager.getConnection(lien+db, login, password );
//			
//			PreparedStatement ps= conn.prepareStatement("Update followers set  id_follower=?, rejectOrAcceptOption=? where id=?");//follower or id user?
//			
//			ps.setInt(1, t.getId_follower());
//			ps.setBoolean(2,t.isRejectOrAcceptOption());
//			ps.setInt(3, t.getId());
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
//			PreparedStatement ps=conn.prepareStatement("DELETE FROM followers where id_follower=?");
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
//	public Followers selectById(Integer id) {
//
//		Followers f=null;
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			
//			Connection conn=DriverManager.getConnection(lien+db, login, password );
//			
//			PreparedStatement ps=conn.prepareStatement("SELECT * FROM followers Join utilisateur on id_follower=utilisateur.id where id_follower=?");
//			ps.setInt(1, id);
//			
//			ResultSet rs = ps.executeQuery();
//			
//			while(rs.next()) 
//			{
//				Bibliotheque b = Context.getInstance().getDaoBibliotheque().findById(rs.getInt("idBiblio"));
//				f = new Followers(rs.getString("mail"), rs.getString("password"), rs.getString("pseudo"), b, 
//						rs.getInt("id"), rs.getInt("id_follower"), rs.getBoolean("rejectOrAcceptOption"));
//			}
//			
//			rs.close();
//			ps.close();
//			conn.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return f;
//	}
//
//	
//	public List<Followers> findAll() {
//		List<Followers> followers  = new ArrayList();
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			
//			Connection conn=DriverManager.getConnection(lien+db, login, password );
//			
//			PreparedStatement ps=conn.prepareStatement("SELECT * FROM followers JOIN utilisateur on id_follower=utilisateur.id where id_follower=?");
//			
//			ResultSet rs = ps.executeQuery();
//			
//			Followers f=null;
//			while(rs.next()) 
//			{
//				Bibliotheque b = Context.getInstance().getDaoBibliotheque().findById(rs.getInt("idBiblio"));
//				f = new Followers(rs.getString("mail"), rs.getString("password"), rs.getString("pseudo"), b, 
//						rs.getInt("id"), rs.getInt("id_follower"), rs.getBoolean("rejectOrAcceptOption"));
//				followers.add(f);
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
//		return followers;
//	}
//	
//
//}
