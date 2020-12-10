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
//import dao.IDAOLivre;
//import model.Livre;
//
//public class DAOLivreJDBC implements IDAOLivre{
//
//	String lien="jdbc:mysql://localhost:3306/";
//	String db="bibliotheque";
//	String login="root";
//	String password="";
//    public void insert(Livre t) {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//
//            Connection conn=DriverManager.getConnection(lien+db, login, password);
//            PreparedStatement ps= conn.prepareStatement("INSERT INTO livre VALUES(?,?,?)");
//            ps.setInt(1, t.getId());
//            ps.setInt(2,t.getDureeLecture());
//            ps.setString(3, t.getAuteur());
//
//            ps.executeUpdate();
//
//            ps.close();
//            conn.close();
//        } catch (Exception e) {
//
//            e.printStackTrace();
//        }
//
//
//    }
//
//    
//    public void update(Livre t) {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//
//            Connection conn=DriverManager.getConnection(lien+db, login, password );
//
//            PreparedStatement ps= conn.prepareStatement("Update livre set  dureeLecture=?, auteur=? where id=?");
//
//            ps.setInt(1,t.getDureeLecture());
//            ps.setString(2, t.getAuteur());
//            ps.setInt(3, t.getId());
//
//            ps.executeUpdate();
//
//            ps.close();
//            conn.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//
//    }
//	
//	public void selectById(Integer id) {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//
//            Connection conn=DriverManager.getConnection(lien+db, login, password );
//
//            PreparedStatement ps=conn.prepareStatement("DELETE FROM livre where id=?");
//            ps.setInt(1, id);
//
//            ps.executeUpdate();
//
//            ps.close();
//            conn.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    
//    public Livre selectById(Integer id) {
//        Livre l=null;
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//
//            Connection conn=DriverManager.getConnection(lien+db, login, password );
//
//            PreparedStatement ps=conn.prepareStatement("SELECT * FROM livre JOIN oeuvre on livre.id=oeuvre.id where livre.id=?");
//            ps.setInt(1, id);
//
//            ResultSet rs = ps.executeQuery();
//
//            while(rs.next()) 
//            {
//                l=new Livre(rs.getString("titre"), rs.getString("descriptif"), rs.getString("nomFichierImage"),rs.getInt("annee"), 
//                        rs.getString("editeur"),LocalDate.parse(rs.getString("creeA")),LocalDate.parse(rs.getString("modifieeA")), 
//                        rs.getBoolean("moderationEffectuee"), rs.getInt("duree"),rs.getString("auteur") );
//            }
//
//            rs.close();
//            ps.close();
//            conn.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return l;
//
//    }
//
//	
//	public List<Livre> findAll() {
//
//        List<Livre> livres  = new ArrayList();
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//
//            Connection conn=DriverManager.getConnection(lien+db, login, password );
//
//            PreparedStatement ps=conn.prepareStatement("SELECT * FROM livre JOIN oeuvre on livre.id=oeuvre.id where livre.id=?");
//
//            ResultSet rs = ps.executeQuery();
//
//            Livre l=null;
//            while(rs.next()) 
//            {
//                l=new Livre(rs.getString("titre"), rs.getString("descriptif"), rs.getString("nomFichierImage"),rs.getInt("annee"), 
//                        rs.getString("editeur"),LocalDate.parse(rs.getString("creeA")),LocalDate.parse(rs.getString("modifieeA")), 
//                        rs.getBoolean("moderationEffectuee"), rs.getInt("annee"),rs.getString("auteur") );
//                livres.add(l);
//            }
//                
//
//
//            rs.close();
//            ps.close();
//            conn.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return livres;
//    }
//
//}
