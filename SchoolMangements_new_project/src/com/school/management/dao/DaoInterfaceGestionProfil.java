package com.school.management.dao;

import java.util.List;

import com.school.management.entities.Membre;
import com.school.management.entities.ParentEleve;
import com.school.management.entities.ResetPasswordToken;

public interface DaoInterfaceGestionProfil<P, E> {

	Membre addMembre(Membre o);

	Long addParant(ParentEleve p);

	boolean deleteMembre(Long id);

	List<Membre> getAllgetMembr();

	Membre getMembreByEmail(String findMembreByEmail);

	Membre updateMembre(Membre m);
	
	public Membre rechercherMemebre(String motclet1,String motclet2,String motclet3);

	public Membre connexionProfil(String email, String Password);

	// Enregistrer le jeton de réinitialisation du mot de passe
	public void saveOrUpdateResetPasswordToken(Membre m) throws Exception;

	// Récupérer le jeton de réinitialisation du mot de passe
	public Membre findResetPasswordToken(String login,String token) throws Exception;

	// Supprimer tous les jetons de réinitialisation de mot de passe
	public List<ResetPasswordToken> findAllResetPasswordTokens() throws Exception;

	// Supprimer le jeton de réinitialisation du mot de passe
	public Membre updateResetPasswordToken(String login) throws Exception;

}
