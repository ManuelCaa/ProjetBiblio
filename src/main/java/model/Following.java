package model;

public class Following extends Utilisateur {
	
	private int id;
	private int id_following;
	private boolean rejectOrAcceptOption;
	
	public Following(String mail, String password, String pseudo, Bibliotheque b, int id, int id_following,
			boolean rejectOrAcceptOption) {
		super(mail, password, pseudo, b);
		this.id = id;
		this.id_following = id_following;
		if(b.getVisibilite()!= Visibilite.Public) this.rejectOrAcceptOption = rejectOrAcceptOption;
		else this.rejectOrAcceptOption = true;
	}

	public boolean isRejectOrAcceptOption() {
		return rejectOrAcceptOption;
	}

	public void setRejectOrAcceptOption(boolean rejectOrAcceptOption) {
		this.rejectOrAcceptOption = rejectOrAcceptOption;
	}

	public int getId() {
		return id;
	}

	public int getId_following() {
		return id_following;
	}

	@Override
	public String toString() {
		return "Following [id=" + id + ", id_following=" + id_following + ", rejectOrAcceptOption="
				+ rejectOrAcceptOption + "]";
	}
	
	
	
}
