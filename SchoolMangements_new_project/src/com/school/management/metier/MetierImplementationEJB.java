package com.school.management.metier;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.school.management.dao.DaoImplementationGestionProfil;
import com.school.management.entities.Membre;
import com.school.management.entities.ParentEleve;
import com.school.management.entities.ResetPasswordToken;

/**
 * Session Bean implementation class MetierImplementationEJB
 */
@Stateless
@LocalBean
public class MetierImplementationEJB implements MetierImplementationEJBRemote, MetierImplementationEJBLocal {
	@Inject
	private DaoImplementationGestionProfil dao;
	@PersistenceContext(name = "SchoolMangements_new_project")
	private EntityManager e;
	private final String username = "upec.m2.java@gmail.com";
	private final String password = "Upec1010";
	private static final String daoExceptionMessage = "Une érreur interne est survenue sur le serveur";

	public MetierImplementationEJB() {
		// TODO Auto-generated constructor stub
	}

	public String generate(int length) {
		String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"; // Tu
		// pas
		String pass = "";
		for (int x = 0; x < length; x++) {
			int i = (int) Math.floor(Math.random() * 62); // Si tu supprimes des lettres tu diminues ce nb
			pass += chars.charAt(i);
		}
		System.out.println(pass);
		return pass;
	}

//	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Membre addmembre(Membre m) {
		// TODO Auto-generated method stub
		return dao.addMembre(m);
	}

	@Override
	public List<Membre> findAllMembre() {
		// try {

		return e.createNamedQuery("findAllMembres", Membre.class).getResultList();

//		} finally {
//			if (e.isOpen()) {
//				e.close();
//			}
//		}
	}

	@Override
	public boolean deleteMembre(Long id) {
		return dao.deleteMembre(id);
	}

	@Override
	public List<Membre> getAllgetMembr() {
		// TODO Auto-generated method stub
		return dao.getAllgetMembr();
	}

	@Override
	public Membre getMembreByEmail(String findMembreByEmail) {
		return dao.getMembreByEmail(findMembreByEmail);
	}

	@Override
	public Membre rechercherMemebre(String motclet1,String motclet2,String motclet3) {
		// TODO Auto-generated method stub
		return dao.rechercherMemebre(motclet1,motclet2,motclet3);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Membre modifierProfil(Membre m) {
		Object result = null;

//		e.getTransaction().begin();
		result = dao.updateMembre(m);
//		e.getTransaction().commit();
		return (Membre) result;

	}

	@Override
	public Membre connexionProfil(String email, String Password) {
		// TODO Auto-generated method stub
		return dao.connexionProfil(email, Password);
	}

	@Override
	public Long addParant(ParentEleve p) {
		// TODO Auto-generated method stub
		return dao.addParant(p);
	}

	@Override
	public boolean findResetPasswordToken(String login, String token,String password) throws Exception {
		Membre m = (Membre) dao.findResetPasswordToken(login, token);
		if (m != null) {
			m.setCrypto(generate(100));
			m.setPassewordMembre(password);
			dao.saveOrUpdateResetPasswordToken(m);
			return true;
		}
		else
			return false;

	}


	// Permet de supprimer tous les jetons de réinitialisation de mot de passe
	// expirés
	@Override
	public void supprimerAllExpiredResetPasswordTokens() throws Exception {
		List<ResetPasswordToken> liste = dao.findAllResetPasswordTokens();
		for (ResetPasswordToken resPassToken : liste) {
			long diffHeures = (new Date().getTime() - resPassToken.getDateCreation().getTime()) / 3600000;
			if (diffHeures > 1) {
				//dao.deleteResetPasswordToken(resPassToken.getId_user());
			}
		}
	}

	@Override
	public void send(List<String> to, String title, String htmlMessage) throws MessagingException {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress("upec.m2.java@gmail.com"));
		if (to != null) {
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(String.join(",", to)));
		}

		message.setSubject(title);
		// message.setText(htmlMessage);
		message.setContent(htmlMessage, "text/html");
		Transport.send(message);

	}

	@Override
	public void saveOrUpdateResetPasswordToken(Membre m) throws Exception {
		dao.saveOrUpdateResetPasswordToken(m);

	}

	@Override
	public void supprimerResetPasswordToken(Long id_user) throws Exception {
		// TODO Auto-generated method stub
		
	}

	// Permet  de réinitialisation de mot de passe
	@Override
	public Membre updateResetPasswordToken(String login) throws Exception {
		
			return dao.updateResetPasswordToken(login);

	}

}
