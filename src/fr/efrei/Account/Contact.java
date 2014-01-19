package fr.efrei.Account;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity  
@Table(name = "contacts")
@NamedQueries({
    @NamedQuery(name = "Contact.findAll", query = "SELECT e FROM Contact e")})
public class Contact {

	@Id  
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "contactid")  
    private int id;
	
	@OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Contact contact;
	
	@Column(name = "firstname")
    private String firstname;
	
	@Column(name = "lastname")
    private String lastname;
	
	@Column(name = "phone")
    private String phone;
	
	@Column(name = "email")
    private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
