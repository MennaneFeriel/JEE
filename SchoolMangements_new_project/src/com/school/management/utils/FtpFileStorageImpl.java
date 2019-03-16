//package com.school.management.utils;
//
//import java.io.IOException;
//import java.io.InputStream;
//
//import javax.servlet.annotation.WebListener;
//
//import org.apache.commons.net.ftp.FTP;
//import org.apache.commons.net.ftp.FTPClient;
//import org.apache.commons.net.ftp.FTPFile;
//import org.apache.commons.net.ftp.FTPReply;
//
//import sun.net.ftp.FtpClient;
//
//@WebListener
//public class FtpFileStorageImpl implements FileStorage {
//
//	// Paramètres de connexion au serveur de fichiers
//	private static String serveur;
//	private static int port;
//	private static String user;
//	private static String password;
//
//	// Client FTP qui va s'occuper du stockage et de la récupération des fichiers sur le serveur
//	private FtpClient clientFTP;
//
//	public FtpFileStorageImpl()
//	{
//	}
//
//	public static void initialiserParametresFTP(String serverAdress, int portNumber, String userName, String pass)
//	{
//		serveur = serverAdress;
//		port = portNumber;
//		user = userName;
//		password = pass;
//	}
//
//	// Connexions au serveurs FTP
//
//	// Permet de se connecter au serveur de fichiers
//	public void connecterClientFTP() throws Exception
//	{
//		try
//		{
//			clientFTP = new FTPClient();
//			clientFTP.connect(serveur, port);
//			int reply = clientFTP.getReplyCode();
//			// FTPReply stocke un ensemble de constantes pour les codes de réponses aux connexions.
//			if (!FTPReply.isPositiveCompletion(reply))
//			{
//				clientFTP.disconnect();
//				throw new FileStorageException("La connexion au serveur de fichiers n'a pas pu être établie");
//			}
//			if (!clientFTP.login(user, password))
//			{
//				((Object) clientFTP).logout();
//				throw new FileStorageException("La connexion au serveur de fichiers n'a pas pu être établie");
//			}
//			clientFTP.setFileType(FTP.BINARY_FILE_TYPE);
//			((Object) clientFTP).enterLocalPassiveMode();
//
//		} catch (Exception ex)
//		{
//			throw ex;
//		}
//	}
//
//	// Permet de se déconnecter du serveur de fichiers
//	public void deconnecterClientFTP() throws Exception
//	{
//		try
//		{
//			if (clientFTP != null)
//			{
//				if (clientFTP.isConnected())
//				{
//					clientFTP.logout();
//					clientFTP.disconnect();
//				}
//
//			}
//		} catch (Exception ex)
//		{
//			throw ex;
//		}
//	}
//
//	// Gestion des des repertoires et des fichiers
//
//	// Permet de créer un nouveau répertoire de fichiers lorsqu'un cours est créé
//	@Override
//	public void creerRepertoire(String cheminRepertoire) throws Exception
//	{
//		try
//		{
//			connecterClientFTP();
//			if (!clientFTP.makeDirectory(cheminRepertoire))
//			{
//				throw new FileStorageException("Une érreur est survenue sur le serveur de fichiers");
//			}
//		} catch (Exception ex)
//		{
//			throw ex;
//		} finally
//		{
//			deconnecterClientFTP();
//		}
//	}
//
//	// Permet de supprimer le répertoire de fichiers de cours lorsque le cours est supprimé
//	@Override
//	public void supprimerRepertoire(String cheminRepertoire) throws Exception
//	{
//		try
//		{
//			connecterClientFTP();
//			supprimerDossier(cheminRepertoire, cheminRepertoire);
//		} catch (Exception ex)
//		{
//			throw new FileStorageException("Une érreur est survenue sur le serveur de fichiers");
//		} finally
//		{
//			deconnecterClientFTP();
//		}
//	}
//
//	// Méthode qui supprime toute l'arborescence d'un dossier
//	private void supprimerDossier(String repertoireInitial, String repertoire) throws IOException
//	{
//		// Si le dossier n'est pas supprimé, alors il contient d'autres dossiers et dans ce cas on supprime d'abord les
//		// sous-dossiers
//		if (!clientFTP.removeDirectory(repertoireInitial))
//		{
//			String[] files = clientFTP.listNames(repertoire);
//			if (files != null)
//			{
//				for (int i = 0; i < files.length; i++)
//				{
//					String sousRepertoire = repertoire + "/" + files[i];
//
//					if (!clientFTP.removeDirectory(sousRepertoire))
//					{
//						// Si le sous-dossier n'est pas supprimé, alors il contient d'autres dossiers et dans ce cas on
//						// supprime d'abord les sous-dossiers
//						supprimerDossier(repertoireInitial, sousRepertoire);
//					} else
//					{
//						supprimerDossier(repertoireInitial, repertoireInitial);
//					}
//				}
//			}
//		}
//	}
//
//	// Permet de supprimer un fichier
//	@Override
//	public void supprimerFichier(String cheminFichier) throws Exception
//	{
//		try
//		{
//			connecterClientFTP();
//			clientFTP.deleteFile(cheminFichier);
//		} catch (Exception ex)
//		{
//			throw ex;
//		} finally
//		{
//			deconnecterClientFTP();
//		}
//	}
//
//	// Téléchargement et envoi des fichiers
//
//	// Permet de déposer un fichier sur le serveur
//	// renvoit le chemind'accès du fichier déposé
//	@Override
//	public String upload(String repertoire, String nomFichier, InputStream local) throws Exception
//	{
//		try
//		{
//			connecterClientFTP();
//
//			// Si le répertoire n'existe pas encore, on le crée
//			clientFTP.makeDirectory(repertoire);
//
//			if (local == null)
//			{
//				return null;
//			}
//
//			int nb = 1;
//			FTPFile[] ftpFiles = clientFTP.listFiles(repertoire);
//
//			// On doit s'assurer que le fichier qu'on va stocker n'ait pas le même nom qu'un fichier existant
//			// dans le même répertoire
//			// Par exemple si un fichier nommé "nomFichier.zip" existe déjà, on change nomFichier en "nomFichier(1)".zip
//			// Ainsi de suite
//
//			int index = nomFichier.lastIndexOf(".");
//			for (FTPFile file : ftpFiles)
//			{
//				if (file.getName().equalsIgnoreCase(nomFichier))
//				{
//					// On calcule la position de l'extension sur le nom du fichier
//
//					if (index > 0)
//					{
//						// Récupération de l'extension avant renommage
//						String extension = nomFichier.substring(index);
//						nomFichier.replace(extension, "");
//						nomFichier = nomFichier + nb + extension;
//					} else
//					{
//						nomFichier = nomFichier + nb;
//					}
//				}
//			}
//
//			boolean uploaded = clientFTP.storeFile(repertoire + nomFichier, local);
//			if (!uploaded)
//			{
//				throw new FileStorageException("Une érreur est survenue lors de l'envoi des fichiers");
//			}
//			return repertoire + nomFichier;
//		} catch (Exception ex)
//		{
//			throw ex;
//		} finally
//		{
//			if (local != null)
//			{
//				local.close();
//			}
//			deconnecterClientFTP();
//		}
//	}
//
//	// Permet de récupérer un fichier du serveur
//	@Override
//	public InputStream download(String cheminFichier) throws Exception
//	{
//		try
//		{
//			connecterClientFTP();
//			InputStream is = clientFTP.retrieveFileStream(cheminFichier);
//			if (is == null)
//			{
//				throw new FileStorageException("Une érreur est survenue lors du téléchargement des fichiers");
//			}
//
//			return is;
//		} catch (Exception ex)
//		{
//			throw ex;
//		} finally
//		{
//			// deconnecterClientFTP();
//		}
//	}
//
//}
