package fr.efrei.Interimaire;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity  
@Table(name = "competences")
@NamedQueries({
    @NamedQuery(name = "Competence.findAll", query = "SELECT c FROM Competence c"), 
	@NamedQuery(name = "Competence.findById", query = "SELECT c FROM Competence c WHERE c.id = :competenceid ")})

public class Competence implements Serializable {

    private static final long serialVersionUID = -6136945690486619001L;

    @Id  
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "competenceid")  
    private int id;
    
    @Column(name = "nom")
    private String nom;

    public int getId() {
            return id;
    }
    public void setId(int id) {
            this.id = id;
    }

    public String getNom() {
            return nom;
    }
    public void setNom(String nom) {
            this.nom = nom;
    }
}
