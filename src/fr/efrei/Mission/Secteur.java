package fr.efrei.Mission;

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
@Table(name = "secteurs")
@NamedQueries({
    @NamedQuery(name = "Secteurs.findAll", query = "SELECT s FROM Secteur s")})
public class Secteur implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -5839919407002033840L;

    @Id  
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "secteurid")  
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
