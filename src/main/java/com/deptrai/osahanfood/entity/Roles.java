package com.deptrai.osahanfood.entity;


import java.util.Set;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "roles")
public class Roles {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "role_name")
	private String roleName;

	@Column(name = "created_date")
	private String createDate;
	
	@OneToMany(mappedBy = "roles")
	private Set<Users> userlist;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public Set<Users> getUserlist() {
		return userlist;
	}

	public void setUserlist(Set<Users> userlist) {
		this.userlist = userlist;
	}

	

	
	
	
}
