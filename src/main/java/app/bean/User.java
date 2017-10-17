package app.bean;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/** Déclaration de l'Objet */

//Utilise la collection Users dans la base Mongo
@Document(collection="Users")
public class User implements Serializable{
	
	/** Autogénéré */
	private static final long serialVersionUID = 1L;

	/** Id du message */
	@Id
	private String id;
	
	/** Nom du User */
	private String nom;
	
	/** Prenom du User */
	private String prenom;
	
	/** Constructeur */
	public User() {
		super();
	}
	
	/**
	 * Constructeur
	 * @param id du message, peut être null
	 */
	public User(String id) {
		this.id = id;
	}

	/**
	 * Constructeur
	 * @param id du user
	 * @param nom du user
	 * @param prenom du user
	 */
	public User(String id, String nom, String prenom) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
	}

}
