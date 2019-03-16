//package com.school.management.utils;
//
//import javax.servlet.http.HttpSession;
//
//public class ApplicationSecurityManager {
//
//	/* Cette classe permet de stocker et de récupérer les données de l'utilisateur de sa session */
//
//	public ApplicationSecurityManager()
//	{
//	}
//
//	private static final String USER = "user";
//	private static final String ENSEIGNANT = "enseignant";
//	private static final String ETUDIANT = "etudiant";
//
//	public static Object getUser(HttpSession session)
//	{
//		return session.getAttribute(USER);
//	}
//
//	public static void setUser(HttpSession session, Object user)
//	{
//		session.setAttribute(USER, user);
//	}
//
//	public static void removeUser(HttpSession session)
//	{
//		session.removeAttribute(USER);
//	}
//
//	public static Object getEnseignant(HttpSession session)
//	{
//		return session.getAttribute(ENSEIGNANT);
//	}
//
//	public static void setEnseignant(HttpSession session, Object enseignant)
//	{
//		session.setAttribute(ENSEIGNANT, enseignant);
//	}
//
//	public static void removeEnseignant(HttpSession session)
//	{
//		session.removeAttribute(ENSEIGNANT);
//	}
//
//	public static Object getEtudiant(HttpSession session)
//	{
//		return session.getAttribute(ETUDIANT);
//	}
//
//	public static void setEtudiant(HttpSession session, Object etudiant)
//	{
//		session.setAttribute(ETUDIANT, etudiant);
//	}
//
//	public static void removeEtudiant(HttpSession session)
//	{
//		session.removeAttribute(ETUDIANT);
//	}
//
//}
