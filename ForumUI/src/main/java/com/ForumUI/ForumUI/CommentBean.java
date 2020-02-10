package com.ForumUI.ForumUI;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class CommentBean {
	@Id
	@GeneratedValue
	private int id ;
	private int iduser ;
	private int idpost ;
	private String comment ;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CommentBean(int iduser, int idpost, String comment) {
		super();
		this.iduser = iduser;
		this.idpost = idpost;
		this.comment = comment;
	}
	
	public CommentBean() {}

	public int getIduser() {
		return iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

	public int getIdpost() {
		return idpost;
	}

	public void setIdpost(int idpost) {
		this.idpost = idpost;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "CommentBean [iduser=" + iduser + ", idpost=" + idpost + ", comment=" + comment + "]";
	}
	
	
}
