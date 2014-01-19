package fr.efrei.Account;

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
@Table(name = "accounts")
@NamedQueries({
	 @NamedQuery(name = "Account.findAll", query = "SELECT e FROM Account e"),
	 @NamedQuery(name = "Account.findById", query = "SELECT e FROM Account e WHERE e.id = :accountid ")})

public class Account implements Serializable {

        /**
         * 
         */
        private static final long serialVersionUID = 1007714354846028651L;

        @Id  
        @GeneratedValue( strategy = GenerationType.IDENTITY )
        @Column(name = "accountid")  
        private int id;
        
        @Column(name = "nom")
        private String nom;
        
        @Column(name = "siret")
        private String siret;
        
        @Column(name = "adresse")
        private String adresse;

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

        public String getSiret() {
                return siret;
        }
        public void setSiret(String siret) {
                this.siret = siret;
        }

        public String getAdresse() {
                return adresse;
        }
        public void setAdresse(String adresse) {
                this.adresse = adresse;
        }
}