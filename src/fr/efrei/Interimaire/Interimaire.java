package fr.efrei.Interimaire;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import fr.efrei.Security.User;

@Entity  
@Table(name = "interimaires")
@NamedQueries({
	@NamedQuery(name = "Interimaire.findAll", query = "SELECT i FROM Interimaire i"),
	@NamedQuery(name = "Interimaire.findById", query = "SELECT i FROM Interimaire i WHERE i.id = :interimaireid")})
public class Interimaire implements Serializable {
        
    /**
     * 
     */
    private static final long serialVersionUID = 1117153561140463391L;

    
    @Id  
    @Column(name = "interimaireid")  
    private int id;
    
    
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn        
    private User user;
    
    @Column(name = "formation")  
    private String formation;
    
    @Column(name = "naissance")  
    @Temporal(TemporalType.DATE) private Date naissance;
        
    @OneToMany
    @JoinTable(
            name="qualification",
            joinColumns = @JoinColumn(name = "interimaireid"),
            inverseJoinColumns = @JoinColumn(name = "competenceid")
    )
    private Set<Competence> qualification = new HashSet<Competence>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFormation() {
		return formation;
	}

	public void setFormation(String formation) {
		this.formation = formation;
	}

	public Date getNaissance() {
		return naissance;
	}

	public void setNaissance(Date naissance) {
		this.naissance = naissance;
	}

	public Set<Competence> getQualification() {
		return qualification;
	}

	public void setQualification(Set<Competence> qualification) {
		this.qualification = qualification;
	}
	
	public void addQualification(Competence qualification) {
		if(qualification == null)
			return;
		
		this.qualification.add(qualification);
	}
	
	public String getFirstname() {
		if(user == null)
			return null;
		
		return user.getFirstname();
	}
	
	public String getLastname() {
		if(user == null)
			return null;
		
		return user.getLastname();
	}
    
   
}
