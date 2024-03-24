package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "User") // to specify table name
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseEntity{
	
	
    //successfully added!
	@Column(name = "first_name", length = 20) // varchar(20)
	private String firstName;
	
	@Column(name = "last_name", length = 20)
	private String lastName;
	
	
	@Email(message = "Invalid email format!!")
	@Column(length = 30, unique = true) // unique constraint
	private String email;
	
	@Column(length = 250, nullable = false) // NOT NULL constraint
	private String password;
	
	@Column(name="role")
	private String role="ROLE_USER";
	
	@OneToMany(mappedBy = "user", 
			cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
	private List<Blog> blog = new ArrayList<>();
	

	public User(String firstName, String lastName, String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	// helper method : to add blog
		public void addBlog(Blog b) {
			this.blog.add(b);// can navigate from parent --> child
			b.setUser(this);// can navigate from child --> parent
		}

		// helper method : to remove blog
		public void removeBlog(Blog b) {
			this.blog.remove(b);
			b.setUser(null);
		}
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password=" + password
				+ "]";
	}
	
	

}
