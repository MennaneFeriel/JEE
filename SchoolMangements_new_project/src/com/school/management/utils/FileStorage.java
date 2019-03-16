package com.school.management.utils;

import java.io.InputStream;

public interface FileStorage {

	// Se connecter au serveur de fichiers
	public void connecterClientFTP() throws Exception;

	// Se déconnecter du serveur de fichiers
	public void deconnecterClientFTP() throws Exception;

	public void creerRepertoire(String cheminRepertoire) throws Exception;

	public void supprimerRepertoire(String cheminRepertoire) throws Exception;

	public void supprimerFichier(String cheminFichier) throws Exception;

	public String upload(String repertoire, String nomFichier, InputStream local) throws Exception;

	public InputStream download(String cheminFichier) throws Exception;

}
