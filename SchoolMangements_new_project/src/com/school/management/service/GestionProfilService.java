package com.school.management.service;

import java.util.Arrays;

import javax.ejb.EJB;

import javax.json.JsonObject;
import javax.mail.MessagingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.school.management.entities.Directeur;
import com.school.management.entities.Eleve;
import com.school.management.entities.Enseignant;
import com.school.management.entities.Membre;
import com.school.management.metier.MetierImplementationEJBLocal;

@Path("/profile")
//@Stateless
@Consumes({ MediaType.APPLICATION_JSON })
public class GestionProfilService {
	@EJB
	private MetierImplementationEJBLocal metier;

	private String htmlMessage;
	private String object = "[plateforme - School Management] changer votre mot de passe";

	@POST
	@Path("/gestionProfil")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response saveMembre(JsonObject membre_json) throws Exception {
		
		
//		if (metier.updateResetPasswordToken(membre_json.getString("loginMembre")) != null) 
//			return Response.status(200).header("Access-Control-Allow-Origin", "*")
//					.header("Access-Control-Allow-Headers", "Content-type")
//					.header("Access-Control-Allow-Credentials", "true").header("Access-Control-Allow-Method", "POST")
//					.header("Access-Control-Max-Age", "1209600").entity("OK").allow("OPTIONS").build();
////		else
//
//		return Response.status(200).header("Access-Control-Allow-Origin", "*")
//				.header("Access-Control-Allow-Headers", "Content-type")
//				.header("Access-Control-Allow-Credentials", "true").header("Access-Control-Allow-Method", "POST")
//				.header("Access-Control-Max-Age", "1209600").entity(null).allow("OPTIONS").build();
		

			if (membre_json.getString("statutMembre").equals("ENS")) {
				String crypto = metier.generate(100);
				htmlMessage = "<p>Bonjour " + " " + ",<br><br>"
						+ "Suite a votre inscription a la plateforme SchoolManagement <br> "
						+ "Vous devez initialiser votre mot de passe, en cliquant sur ce <a href='localhoste4200/Confirmation/Inscription/"
						+ crypto + "'>lien</a> <br>.</p>";
				//metier.send(Arrays.asList(membre.getLoginMembre()), object, htmlMessage);
				return Response.status(200).header("Access-Control-Allow-Origin", "*")
						.header("Access-Control-Allow-Headers", "Content-type")
						.header("Access-Control-Allow-Credentials", "true")
						.header("Access-Control-Allow-Method", "POST").header("Access-Control-Max-Age", "1209600")
						.entity((Enseignant) metier.addmembre((Enseignant)membre_json)).allow("OPTIONS").build();
			} else if (membre_json.getString("statutMembre").equals("DIR")) {
				Directeur membre = new Directeur();
				String crypto = metier.generate(100);
				membre.setAdresseMembre(membre_json.getString("adresseMembre"));
				membre.setAgeMembre(membre_json.getInt("ageMembre"));
				membre.setLoginMembre(membre_json.getString("loginMembre"));
				membre.setNomMembre(membre_json.getString("nomMembre"));
				membre.setPrenomMembre(membre_json.getString("prenomMembre"));
				membre.setSexeMembre(membre_json.getString("sexeMembre"));
				membre.setCrypto(crypto);
				membre.setSalaire(membre_json.getInt("salaire"));
				membre.setStatutMembre(membre_json.getString("statutMembre"));
				htmlMessage = "<p>Bonjour " + " " + ",<br><br>"
						+ "Suite a votre inscription a la plateforme SchoolManagement <br> "
						+ "Vous devez initialiser votre mot de passe, en cliquant sur ce <a href='localhoste4200/Confirmation/Inscription/"
						+ crypto + "'>lien</a> <br>.</p>";
				//metier.send(Arrays.asList(membre.getLoginMembre()), object, htmlMessage);
				return Response.status(200).header("Access-Control-Allow-Origin", "*")
						.header("Access-Control-Allow-Headers", "Content-type")
						.header("Access-Control-Allow-Credentials", "true")
						.header("Access-Control-Allow-Method", "POST").header("Access-Control-Max-Age", "1209600")
						.entity((Directeur) metier.addmembre(membre)).allow("OPTIONS").build();
			} else {
				Eleve membre = new Eleve();
				String crypto = metier.generate(100);
				membre.setAdresseMembre(membre_json.getString("adresseMembre"));
				membre.setAgeMembre(membre_json.getInt("ageMembre"));
				membre.setLoginMembre(membre_json.getString("loginMembre"));
				membre.setNomMembre(membre_json.getString("nomMembre"));
				membre.setPrenomMembre(membre_json.getString("prenomMembre"));
				membre.setSexeMembre(membre_json.getString("sexeMembre"));
				membre.setCrypto(crypto);
				membre.setStatutMembre(membre_json.getString("statutMembre"));
				htmlMessage = "<p>Bonjour " + " " + ",<br><br>"
						+ "Suite a votre inscription a la plateforme SchoolManagement <br> "
						+ "Vous devez initialiser votre mot de passe, en cliquant sur ce <a href='localhoste4200/Confirmation/Inscription/"
						+ crypto + "'>lien</a> <br>.</p>";
				metier.send(Arrays.asList(membre.getLoginMembre()), object, htmlMessage);
				return Response.status(200).header("Access-Control-Allow-Origin", "*")
						.header("Access-Control-Allow-Headers", "Content-type")
						.header("Access-Control-Allow-Credentials", "true")
						.header("Access-Control-Allow-Method", "POST").header("Access-Control-Max-Age", "1209600")
						.entity((Eleve) metier.addmembre(membre)).allow("OPTIONS").build();
			}
			
			
		
					
	}

	@PUT
	@Path("/gestionProfil")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response modifierProfilEnseignant(JsonObject membre_json) throws Exception {
		if (metier.getMembreByEmail(membre_json.getString("loginMembre")) != null) {
			if (membre_json.getString("statutMembre").equals("ENS")) {
				Enseignant membre = new Enseignant();
				String crypto = metier.generate(100);
				membre.setAdresseMembre(membre_json.getString("adresseMembre"));
				membre.setAgeMembre(membre_json.getInt("ageMembre"));
				membre.setLoginMembre(membre_json.getString("loginMembre"));
				membre.setNomMembre(membre_json.getString("nomMembre"));
				membre.setPrenomMembre(membre_json.getString("prenomMembre"));
				membre.setSexeMembre(membre_json.getString("sexeMembre"));
				membre.setCrypto(crypto);
				membre.setGrade(membre_json.getString("grade"));
				membre.setSalaire(membre_json.getInt("salaire"));
				membre.setStatutMembre(membre_json.getString("statutMembre"));
				return Response.status(200).header("Access-Control-Allow-Origin", "*")
						.header("Access-Control-Allow-Headers", "Content-type")
						.header("Access-Control-Allow-Credentials", "true")
						.header("Access-Control-Allow-Method", "POST").header("Access-Control-Max-Age", "1209600")
						.entity((Enseignant) metier.modifierProfil(membre)).allow("OPTIONS").build();
			} else if (membre_json.getString("statutMembre").equals("DIR")) {
				Directeur membre = new Directeur();
				String crypto = metier.generate(100);
				membre.setAdresseMembre(membre_json.getString("adresseMembre"));
				membre.setAgeMembre(membre_json.getInt("ageMembre"));
				membre.setLoginMembre(membre_json.getString("loginMembre"));
				membre.setNomMembre(membre_json.getString("nomMembre"));
				membre.setPrenomMembre(membre_json.getString("prenomMembre"));
				membre.setSexeMembre(membre_json.getString("sexeMembre"));
				membre.setCrypto(crypto);
				membre.setSalaire(membre_json.getInt("salaire"));
				membre.setStatutMembre(membre_json.getString("statutMembre"));
				return Response.status(200).header("Access-Control-Allow-Origin", "*")
						.header("Access-Control-Allow-Headers", "Content-type")
						.header("Access-Control-Allow-Credentials", "true").header("Access-Control-Allow-Method", "PUT")
						.header("Access-Control-Max-Age", "1209600").entity((Directeur) metier.modifierProfil(membre))
						.allow("OPTIONS").build();
			} else {
				Eleve membre = new Eleve();
				String crypto = metier.generate(100);
				membre.setAdresseMembre(membre_json.getString("adresseMembre"));
				membre.setAgeMembre(membre_json.getInt("ageMembre"));
				membre.setLoginMembre(membre_json.getString("loginMembre"));
				membre.setNomMembre(membre_json.getString("nomMembre"));
				membre.setPrenomMembre(membre_json.getString("prenomMembre"));
				membre.setSexeMembre(membre_json.getString("sexeMembre"));
				membre.setCrypto(crypto);
				membre.setStatutMembre(membre_json.getString("statutMembre"));
				return Response.status(200).header("Access-Control-Allow-Origin", "*")
						.header("Access-Control-Allow-Headers", "Content-type")
						.header("Access-Control-Allow-Credentials", "true").header("Access-Control-Allow-Method", "PUT")
						.header("Access-Control-Max-Age", "1209600").entity((Eleve) metier.modifierProfil(membre))
						.allow("OPTIONS").build();
			}
		} else
			return Response.status(200).header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Headers", "Content-type")
					.header("Access-Control-Allow-Credentials", "true").header("Access-Control-Allow-Method", "PUT")
					.header("Access-Control-Max-Age", "1209600").entity(null).allow("OPTIONS").build();

	}

	@POST
	@Path("/gestionProfil/rechercherMemebre")
	@Produces({ MediaType.APPLICATION_JSON })
	public Membre rechercherMemebre(JsonObject rechercher_json) {
		return metier.rechercherMemebre(rechercher_json.getString("nom"), rechercher_json.getString("prenom"),
				rechercher_json.getString("statut"));

	}

	@POST
	@Path("/gestionProfil/connexion")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response connexionProfil(JsonObject membre_json) {
		Membre user = metier.connexionProfil(membre_json.getString("loginMembre"),
				membre_json.getString("passewordMembre"));

		if (user != null)
			return Response.status(200).header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Headers", "Content-type")
					.header("Access-Control-Allow-Credentials", "true").header("Access-Control-Allow-Method", "GET")
					.header("Access-Control-Max-Age", "1209600").entity(user).allow("OPTIONS").build();
		else
			return Response.status(200).header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Headers", "Content-type")
					.header("Access-Control-Allow-Credentials", "true").header("Access-Control-Allow-Method", "GET")
					.header("Access-Control-Max-Age", "1209600").entity(null).allow("OPTIONS").build();
	}

	@GET
	@Path("/gestionProfil")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getAllgetMembr() {
		return Response.status(200).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "Content-type")
				.header("Access-Control-Allow-Credentials", "true").header("Access-Control-Allow-Method", "GET")
				.header("Access-Control-Max-Age", "1209600").entity(metier.getAllgetMembr()).allow("OPTIONS").build();
	}

	@GET
	@Path("/gestionProfil")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getMembreById(JsonObject membre_json) {
		return Response.status(200).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "Content-type")
				.header("Access-Control-Allow-Credentials", "true").header("Access-Control-Allow-Method", "GET")
				.header("Access-Control-Max-Age", "1209600")
				.entity(metier.getMembreByEmail(membre_json.getString("loginMembre"))).allow("OPTIONS").build();
	}

	@DELETE
	@Path("/gestionProfil/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public boolean deleteMembre(@PathParam(value = "id") Long id) {
		return (metier.deleteMembre(id));

	}

	@POST
	@Path("/gestionProfil/reset-password") // confirmation de reunitialisation de mot de passe
	public Response findResetPasswordToken(JsonObject membre_json) throws Exception {

		return Response.status(200).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "Content-type")
				.header("Access-Control-Allow-Credentials", "true").header("Access-Control-Allow-Method", "POST")
				.header("Access-Control-Max-Age", "1209600")
				.entity(metier.findResetPasswordToken(membre_json.getString("loginMembre"),
						membre_json.getString("crypto"), membre_json.getString("password")))
				.allow("OPTIONS").build();

	}

	@POST
	@Path("/gestionProfil/update-password") // reunitialisation de mot de passe
	public Response updatePasswordToken(JsonObject membre_json) throws Exception {
		Membre m = metier.updateResetPasswordToken(membre_json.getString("loginMembre"));
		if (m != null) {
			m.getLoginMembre();
			m.getCrypto();
			htmlMessage = "<p>Bonjour " + " " + ",<br><br>"
					+ "Suite a votre inscription a la plateforme SchoolManagement <br> "
					+ "Vous devez initialiser votre mot de passe, en cliquant sur ce <a href='localhoste4200/Confirmation/Inscription/"
					+ m.getCrypto() + "'>lien</a> <br>.</p>";
			metier.send(Arrays.asList(m.getLoginMembre()), object, htmlMessage);
			return Response.status(200).header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Headers", "Content-type")
					.header("Access-Control-Allow-Credentials", "true").header("Access-Control-Allow-Method", "POST")
					.header("Access-Control-Max-Age", "1209600").entity("OK").allow("OPTIONS").build();
		}
		return Response.status(200).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "Content-type")
				.header("Access-Control-Allow-Credentials", "true").header("Access-Control-Allow-Method", "POST")
				.header("Access-Control-Max-Age", "1209600").entity("KO").allow("OPTIONS").build();

	}
}
