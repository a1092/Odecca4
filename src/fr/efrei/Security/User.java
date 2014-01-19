package fr.efrei.Security;

import java.io.Serializable;

import javax.persistence.*;

@Entity  
@Table(name = "users")  

@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT a FROM User a"),    
    @NamedQuery(name = "User.Authenticate", query = "SELECT a FROM User a WHERE a.login = :login AND a.password = :password"),
})
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id  
	@GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "userid")  
    private int id;  
    
	@Column(name = "firstname")  
    private String firstname; 
	
	@Column(name = "lastname")  
    private String lastname; 
	
	@Column(name = "login")  
    private String login; 
	
	@Column(name = "password")  
    private String password; 
	
	@Column(name = "email")  
    private String email; 
	
	@Column(name = "role")  
    private String role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	} 
	
}
