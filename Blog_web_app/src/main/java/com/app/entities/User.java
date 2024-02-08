package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
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
	
	@Column(length = 30, unique = true) // unique constraint
	private String email;
	
	@Column(length = 15, nullable = false) // NOT NULL constraint
	private String password;
	//testing comment!!!!
	public User(String firstName, String lastName, String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password=" + password
				+ "]";
	}
	
	

}
