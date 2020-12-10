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
//import dao.IDAOFollowing;
//import model.Bibliotheque;
//import model.Followers;
//import model.Following;
//
//public class DAOFollowingJDBC implements IDAOFollowing{
//
//	String lien="jdbc:mysql://localhost:3306/";
//	String db="bibliotheque";
//	String login="root";
//	String password="";
//	public void insert(Following t) {
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			
//			Connection conn=DriverManager.getConnection(lien+db, login, password);
//			PreparedStatement ps= conn.prepareStatement("INSERT INTO following VALUES(?,?,?)");
//			ps.setInt(1, t.getId());//pour l'utilisateur
//			ps.setInt(2, t.getId_following());
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
//	public void update(Following t) {
//		try {	
//			Class.forName("com.mysql.jdbc.Driver");
//			
//			Connection conn=DriverManager.getConnection(lien+db, login, password );
//			
//			PreparedStatement ps= conn.prepareStatement("Update following set  id_following=?, rejectOrAcceptOption=? where id=?");//following or id user?
//			
//			ps.setInt(1, t.getId_following());
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
//			PreparedStatement ps=conn.prepareStatement("DELETE FROM following where id_following=?");
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
//	public Following selectById(Integer id) {
//
//		Following f=null;
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			
//			Connection conn=DriverManager.getConnection(lien+db, login, password );
//			
//			PreparedStatement ps=conn.prepareStatement("SELECT * FROM following Join utilisateur on id_following=utilisateur.id where id_following=?");
//			ps.setInt(1, id);
//			
//			ResultSet rs = ps.executeQuery();
//			
//			while(rs.next()) 
//			{
//				Bibliotheque b = Context.getInstance().getDaoBibliotheque().findById(rs.getInt("idBiblio"));
//				f = new Following(rs.getString("mail"), rs.getString("password"), rs.getString("pseudo"), b, 
//						rs.getInt("id"), rs.getInt("id_following"), rs.getBoolean("rejectOrAcceptOption"));
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
//	public List<Following> findAll() {
//		List<Following> followings  = new ArrayList();
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			
//			Connection conn=DriverManager.getConnection(lien+db, login, password );
//			
//			PreparedStatement ps=conn.prepareStatement("SELECT * FROM following JOIN utilisateur on id_following=utilisateur.id Join bibliotheque on idBiblio=bibliotheque.id where id_following=?");
//			
//			ResultSet rs = ps.executeQuery();
//			
//			Following f=null;
//			while(rs.next()) 
//			{
//				Bibliotheque b = Context.getInstance().getDaoBibliotheque().findById(rs.getInt("idBiblio"));
//				f = new Following(rs.getString("mail"), rs.getString("password"), rs.getString("pseudo"), b, 
//						rs.getInt("id"), rs.getInt("id_following"), rs.getBoolean("rejectOrAcceptOption"));	
//				followings.add(f);
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
//		return followings;
//	}
//	
//
//}
