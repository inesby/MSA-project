package model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PostBean {
	
	@Id
	@GeneratedValue
	private int id ;
	private int idUser;
	private String postt ;

	public PostBean(int id, int idUser, String post) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.postt = post;
	}
	
	public PostBean()
	{	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getPostt() {
		return postt;
	}

	public void setPostt(String post) {
		postt = post;
	}

	@Override
	public String toString() {
		return "PostBean [id=" + id + ", idUser=" + idUser + ", postt=" + postt + "]";
	}
	
	
	
}
