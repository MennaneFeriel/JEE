package com.school.management.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Membre
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_Membre", discriminatorType = DiscriminatorType.STRING, length = 3)

@NamedQueries(value = {
		@NamedQuery(name = "findAllMembrees", query = "SELECT x FROM Membre x"),
		@NamedQuery(name = "findMembreByEmail", query = "SELECT x FROM Membre x WHERE x.loginMembre= :nomparam"),
		@NamedQuery(name = "Membre.findAll", query = "select x from Membre x order by x.nomMembre"),
		@NamedQuery(name = "Membre.connexion", query = "select x from Membre x where x.loginMembre = :loginMembre and x.passewordMembre=:passewordMembre"),
		@NamedQuery(name = "Membre.findByEnseignant", query = "select x from Membre x where x.statutMembre = 'ENS'"),
		@NamedQuery(name = "Membre.findByDirecteur", query = "select x from Membre x where x.statutMembre = 'DIR' order by x.nomMembre"),
		@NamedQuery(name = "Membre.findByEleve", query = "select x from Membre x where x.statutMembre = 'ELE'"),
		//@NamedQuery(name = "Membre.rechercherMemebre.motclet", query = "select x from Membre x where x.nomMembre LIKE \"%motcle1%\" OR x.prenomMembre LIKE \"%motcle2%\" OR x.statutMembre=\"motcle3\" "),
		@NamedQuery(name = "Membre.findOneById", query = "select x from Membre x where x.idMembre = ?1 order by x.nomMembre"),
		@NamedQuery(name = "Membre.ResetPasswordToken.find", query = "select x from Membre x where x.crypto = :token and x.loginMembre=:login"),
		@NamedQuery(name = "Membre.fogetPasswordToken.find", query = "select x from Membre x where x.loginMembre=:login"),
		@NamedQuery(name = "Membre.updatePasswordToken.find", query = "select x from Membre x where x.crypto = :token and x.loginMembre=:login"),
		@NamedQuery(name = "Membre.searchByQuery", query = "select x from Membre x where lower(x.nomMembre) like ?1 order by x.nomMembre"),
        @NamedQuery(name = "Membre.ResetPasswordToken.findAll", query = "select x from Membre x")
		
     })

public abstract class Membre implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMembre;
	private String nomMembre;
	private String crypto;
	private int annee;
	private String prenomMembre;
	private String sexeMembre;
	private int ageMembre;
	private String adresseMembre;
	private String statutMembre;
	private String loginMembre;
	private String passewordMembre;
	private Date dateEmbauche;
	private static final long serialVersionUID = 1L;
	/// **/@ManyToOne // plusieurs membres pr une mssg
	// @JoinColumn(name="idMessage")
	// private Message message;
	// un seul memmbre pour +sieurs messages
	@OneToMany(mappedBy = "membre1", fetch = FetchType.LAZY)
	private Collection<Message> messageenvoyes;

	@OneToMany(mappedBy = "membre2", fetch = FetchType.LAZY)
	private Collection<Message> messagerecus;

	

	
	public Membre(String nomMembre, String prenomMembre, String sexeMembre, int ageMembre, String adresseMembre,
			String statutMembre, String loginMembre, String passewordMembre, Date dateEmbauche) {
		super();
		this.nomMembre = nomMembre;
		this.prenomMembre = prenomMembre;
		this.sexeMembre = sexeMembre;
		this.ageMembre = ageMembre;
		this.adresseMembre = adresseMembre;
		this.statutMembre = statutMembre;
		this.loginMembre = loginMembre;
		this.passewordMembre = passewordMembre;
		this.dateEmbauche = dateEmbauche;
	}
	public Membre() {
		super();
	}
	public Date getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}
  
//	public Collection<Message> getMessageenvoyes() {
//		return messageenvoyes;
//	}
//
	public void setMessageenvoyes(Collection<Message> messageenvoyes) {
		this.messageenvoyes = messageenvoyes;
	}

//	public Collection<Message> getMessagerecus() {
//		return messagerecus;
//	}
//
	public void setMessagerecus(Collection<Message> messagerecus) {
		this.messagerecus = messagerecus;
	}

	public Long getIdMembre() {
		return this.idMembre;
	}

	public void setIdMembre(Long idMembre) {
		this.idMembre = idMembre;
	}

	public String getNomMembre() {
		return this.nomMembre;
	}

	public void setNomMembre(String nomMembre) {
		this.nomMembre = nomMembre;
	}

	public String getPrenomMembre() {
		return this.prenomMembre;
	}

	public void setPrenomMembre(String prenomMembre) {
		this.prenomMembre = prenomMembre;
	}

	public String getSexeMembre() {
		return this.sexeMembre;
	}

	public void setSexeMembre(String sexeidMembre) {
		this.sexeMembre = sexeidMembre;
	}

	public int getAgeMembre() {
		return this.ageMembre;
	}

	public void setAgeMembre(int ageMembre) {
		this.ageMembre = ageMembre;
	}

	public String getAdresseMembre() {
		return this.adresseMembre;
	}

	public void setAdresseMembre(String adresseMembre) {
		this.adresseMembre = adresseMembre;
	}

	public String getStatutMembre() {
		return this.statutMembre;
	}

	public void setStatutMembre(String statutMembre) {
		this.statutMembre = statutMembre;
	}

	public String getLoginMembre() {
		return this.loginMembre;
	}

	public void setLoginMembre(String loginMembre) {
		this.loginMembre = loginMembre;
	}

	public String getPassewordMembre() {
		return this.passewordMembre;
	}

	public void setPassewordMembre(String passewordMembre) {
		this.passewordMembre = passewordMembre;
	}
	public String getCrypto() {
		return crypto;
	}
	public void setCrypto(String crypto) {
		this.crypto = crypto;
	}
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}

}