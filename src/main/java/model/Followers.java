package model;


public class Followers extends Utilisateur{
	
	private int id;
	private int id_follower;
	private boolean rejectOrAcceptOption;
	
	public Followers(String mail, String password, String pseudo, Bibliotheque b, int id, int id_follower,
			boolean rejectOrAcceptOption) {
		super(mail, password, pseudo, b);
		this.id = id;
		this.id_follower = id_follower;
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

	public int getId_follower() {
		return id_follower;
	}

	@Override
	public String toString() {
		return "Followers [id=" + id + ", id_follower=" + id_follower + ", rejectOrAcceptOption=" + rejectOrAcceptOption
				+ "]";
	}
	

}
