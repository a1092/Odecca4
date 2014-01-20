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
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import fr.efrei.Interimaire.Interimaire;

@Entity  
@Table(name = "postulations")
@NamedQueries({
	@NamedQuery(name = "Postulation.findAll", query = "SELECT p FROM Postulation p"),
	@NamedQuery(name = "Postulation.findByMission", query = "SELECT p FROM Postulation p WHERE p.mission = :mission"),
	@NamedQuery(name = "Postulation.findByMissionInterimaire", query = "SELECT p FROM Postulation p WHERE p.mission = :mission AND p.interimaire = :interimaire")})


public class Postulation {

	@Id  
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "postulationid")  
    private int id;

	@ManyToOne (cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn(name="interimaireid", referencedColumnName="ID")
    private Interimaire interimaire;
	
	@ManyToOne (cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn(name="missionid", referencedColumnName="ID")
    private Mission mission;
	
	@Column(name = "statut")
    private String statut;
	
	@Column(name = "inscription")
    @Temporal(TemporalType.DATE) private Date inscription;
	
	public Date getInscription() {
		return inscription;
	}

	public void setInscription(Date inscription) {
		this.inscription = inscription;
	}

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
