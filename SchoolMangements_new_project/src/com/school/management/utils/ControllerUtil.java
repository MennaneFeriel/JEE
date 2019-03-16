package com.school.management.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.enterprise.inject.Model;

public class ControllerUtil {

	// Méthodes de validation des paramètres de formulaires

	public static boolean validerParam(String paramName, String paramValue, String message, Model model)
	{
		return validerParam(paramName, paramValue, true, message, model);
	}

	// Le paramètre saveParam permet de spécifier si le paramètre doit être sauvegardé pour être retourné si la
	// validation globale ne reussit pas, par défaut le paramètre est sauvegardé
	public static boolean validerParam(String paramName, String paramValue, boolean saveParam, String message, Model model)
	{
		message = message == null || message.equals("") ? "Veuillez renseigner ce champ" : message;
		if (paramValue == null || paramValue.isEmpty())
		{
			//model.addAttribute("error_" + paramName, message);
			return false;
		} else if (saveParam)
		{
			// Si la validation du paramètre a reussi on enregistre le paramètre au cas où la validation globale ne
			// reussit pas et qu'ils doivent être retournés
			//model.addAttribute(paramName, paramValue);
		}
		return true;
	}

	public static boolean validerParamValues(String paramName, String[] paramValues, String message, Model model)
	{
		return validerParamValues(paramName, paramValues, true, message, model);
	}

	// Idem que validerParams mais pour les paramètres à valeurs multiples par ex les checkbox
	public static boolean validerParamValues(String paramName, String[] paramValues, boolean saveParam, String message,
			Model model)
	{
		message = message == null || message.equals("") ? "Veuillez renseigner ce champ" : message;
		if (paramValues == null || paramValues.length == 0)
		{
			//model.addAttribute("error_" + paramName, message);
			return false;
		} else if (saveParam)
		{
			//model.addAttribute(paramName, paramValues);
		}
		return true;
	}

	// Validation et conversion des strings en dates
	public static Date validerEtConvertirEnDate(String dateStr)
	{
		try
		{
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date convertedDate = formatter.parse(dateStr);
			return convertedDate;
		} catch (Exception e)
		{
			return null;
		}
	}

}
