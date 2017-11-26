package com.aminfo.model.usermanagement;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({
		@NamedQuery(name="getUserByEmailID",query="from Users where emailId = :email") 
	})
@Entity
@Table(name = "users")
public class Users implements Serializable {

	private static final long serialVersionUID = -3009157732242241606L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String userName;
	
	private String emailId;

	protected Users() {	}

	public Users(String emailId, String userName) {
		this.userName = userName;
		this.emailId = emailId;
	}

	public Users(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", userName=" + userName + ", emailId=" + emailId + "]";
	}
	
}