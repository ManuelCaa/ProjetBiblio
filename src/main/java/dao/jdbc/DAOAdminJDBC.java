package dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.IDAOAdmin;
import model.Admin;

public class DAOAdminJDBC implements IDAOAdmin {

	String lien="jdbc:mysql://localhost:3306/";
	String db="bibliotheque";
	String login="root";
	String password="";
	public void insert(Admin t) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection(lien+db, login, password);
			PreparedStatement ps= conn.prepareStatement("INSERT INTO admin VALUES(?,?,?,?)");
			ps.setInt(1, t.getId());
			ps.setString(2, t.getMail());
			ps.setString(3,t.getPseudo());
			ps.setString(4, t.getPassword());
			
			ps.executeUpdate();
			
			ps.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void update(Admin t) {
		try {	
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection(lien+db, login, password );
			
			PreparedStatement ps= conn.prepareStatement("Update admin set  mail=?, pseudo=? , password=?, where id=?");
			
			ps.setString(1,t.getMail());
			ps.setString(2, t.getPseudo());
			ps.setString(3, t.getPassword());
			ps.setInt(4, t.getId());
			
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

			PreparedStatement ps=conn.prepareStatement("DELETE FROM admin where id=?");
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public Admin selectById(Integer id) {
		Admin a=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection(lien+db, login, password );
			
			PreparedStatement ps=conn.prepareStatement("SELECT * FROM admin where id=?");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) 
			{
				a = new Admin(rs.getString("mail"),rs.getString("password"),rs.getString("pseudo"));
			}
			
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}
	public List<Admin> findAll() {
		List<Admin> admins  = new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection(lien+db, login, password );
			
			PreparedStatement ps=conn.prepareStatement("SELECT * FROM admin");
			
			ResultSet rs = ps.executeQuery();
			
			Admin a=null;
			while(rs.next()) 
			{
				a = new Admin(rs.getString("mail"),rs.getString("password"),rs.getString("pseudo"));	
				admins.add(a);
			}
				
			
			
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return admins;
	}



}
