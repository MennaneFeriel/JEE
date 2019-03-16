//package com.school.management.utils;
//
//import org.wildfly.security.password.interfaces.BCryptPassword;
//
//public class Cryptage {
//
//	// Objet qui se charge du cryptage
//	private static BCryptPassword passwordEncoder;
//
//	static
//	{
//		if (passwordEncoder == null)
//		{
//			passwordEncoder = new BCryptPasswordEncoder();
//		}
//	}
//
//	// Crypte le mot passé en paramètre
//	public static String crypter(String nonCrypte)
//	{
//		return passwordEncoder.get;
//	}
//
//	// Teste si le mot non crypté correspond au mot crypté
//	public static boolean matches(String nonCrypte, String crypte)
//	{
//		return passwordEncoder.matches(nonCrypte, crypte);
//	}
//
//}
