package com.school.management.metier;

import java.util.List;

import javax.ejb.Remote;
import javax.mail.MessagingException;

import com.school.management.entities.Membre;
import com.school.management.entities.ParentEleve;
import com.school.management.entities.ResetPasswordToken;


@Remote
public interface MetierImplementationEJBRemote {

	public Membre addmembre(Membre m);

	public String generate(int length);

	Long addParant(ParentEleve p);

	public void send(List<String> to, String title, String htmlMessage) throws MessagingException;

	boolean deleteMembre(Long id);

	List<Membre> getAllgetMembr();

	Membre getMembreByEmail(String findMembreByEmail);

	public Membre rechercherMemebre(String motclet1,String motclet2,String motclet3);

	public Membre modifierProfil(Membre m) throws Exception;

	public List<Membre> findAllMembre();

	public Membre connexionProfil(String email, String Password);

	// Enregistrer le jeton de réinitialisation du mot de passe
	public void saveOrUpdateResetPasswordToken(Membre m) throws Exception;

	// Récupérer le jeton de réinitialisation du mot de passe
	public boolean findResetPasswordToken(String login,String token,String password) throws Exception;

	// Supprimer un jeton de réinitialisation de mot de passe
	public Membre updateResetPasswordToken(String login) throws Exception;

	// Supprimer tous les jetons de réinitialisation du mot de passe expirés
	public void supprimerAllExpiredResetPasswordTokens() throws Exception;

}
