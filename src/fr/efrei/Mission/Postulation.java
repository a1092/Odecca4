package fr.efrei.Mission;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import fr.efrei.Interimaire.Interimaire;

@Entity  
@Table(name = "postulations")
@NamedQueries({
	@NamedQuery(name = "Postulation.findAll", query = "SELECT p FROM Postulation p")})
public class Postulation {

	@Id  
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "postulationid")  
    private int id;

	@ManyToOne (cascade = CascadeType.ALL)
    private Interimaire interimaire;
	
	@ManyToOne (cascade = CascadeType.ALL)
    private Mission mission;
	
	@Column(name = "statut")
    private String statut;
	
	@Column(name = "inscription")
    @Temporal(TemporalType.DATE) private Date inscription;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Interimaire getInterimaire() {
		return interimaire;
	}

	public void setInterimaire(Interimaire interimaire) {
		this.interimaire = interimaire;
	}

	public Mission getMission() {
		return mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	
}
