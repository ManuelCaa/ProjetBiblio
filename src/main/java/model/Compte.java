package model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

@Entity
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_compte")
public class Compte {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	protected String mail;
	protected String password;
	protected String pseudo;
	@OneToOne
	private Bibliotheque biblio;

	public Compte() {
		// TODO Auto-generated constructor stub
	}

	public Compte(String mail, String password, String pseudo) {
		this.mail = mail;
		this.password = password;
		this.pseudo = pseudo;
	}

	public void setId(int id) {
		this.id = id;
	}




	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public int getId() {
		return id;
	}
	public Bibliotheque getBiblio() {
		return biblio;
	}
	public void setBiblio(Bibliotheque biblio) {
		this.biblio = biblio;
	}



	/*public static Compte checkConnect(String pseudo,String password)
{
for(Compte c : Testbiblio.comptes)
{
if
(c.getPseudo().equals(pseudo) && c.getPassword().equals(password))
{
return c;
}}
return null;

}*/






}