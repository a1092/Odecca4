package fr.efrei.Mission;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import fr.efrei.Account.Account;
import fr.efrei.Interimaire.Competence;

@Entity  
@Table(name = "missions")
@NamedQueries({
	@NamedQuery(name = "Mission.findAll", query = "SELECT m FROM Mission m"),
	@NamedQuery(name = "Mission.findById", query = "SELECT m FROM Mission m WHERE m.id = :missionid"),
	@NamedQuery(name = "Mission.findByStatut", query = "SELECT m FROM Mission m WHERE m.statut = :statut")})
public class Mission implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -4619810630797245503L;

    @Id  
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "missionid")  
    private int id;

    @ManyToOne (cascade = CascadeType.ALL)
    private Account account;

    @ManyToOne(cascade = CascadeType.ALL)
    private Secteur secteur;
    
    @Column(name = "intitule")
    private String intitule;
    
    @Column(name = "debut")
    @Temporal(TemporalType.DATE) private Date debut;
    
    @Column(name = "fin")
    @Temporal(TemporalType.DATE) private Date fin;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "lieu")
    private String lieu;
    
    @Column(name = "tarif")
    private int tarif;

    @Column(name = "statut")
    private String statut;

   

	@OneToMany
    @JoinTable(
            name="competence_mission",
            joinColumns = @JoinColumn(name = "missionid"),
            inverseJoinColumns = @JoinColumn(name = "competenceid")
    )
    private Set<Competence> competences = new HashSet<Competence>();

    @OneToMany(mappedBy="mission") private Set<Postulation> postulations = new HashSet<Postulation>();
    
	public int getId() {
		return id;
	}


	public Set<Postulation> getPostulations() {
		return postulations;
	}


	public void setPostulations(Set<Postulation> postulations) {
		this.postulations = postulations;
	}


	public void setId(int id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Secteur getSecteur() {
		return secteur;
	}

	public void setSecteur(Secteur secteur) {
		this.secteur = secteur;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public Date getDebut() {
		return debut;
	}

	public void setDebut(Date debut) {
		this.debut = debut;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public int getTarif() {
		return tarif;
	}

	public void setTarif(int tarif) {
		this.tarif = tarif;
	}

	public Set<Competence> getCompetences() {
		return competences;
	}

	public void setCompetences(Set<Competence> competences) {
		this.competences = competences;
	}
	
	public void addQualification(Competence qualification) {
		if(qualification == null)
			return;
		
		this.competences.add(qualification);
	}
	
	 public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}
    
}
