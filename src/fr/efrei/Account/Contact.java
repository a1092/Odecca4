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

import fr.efrei.Security.User;

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
	
	
	@Column(name = "phone")
    private String phone;


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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
