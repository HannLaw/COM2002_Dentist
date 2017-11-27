//package com2002;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validation {

	public static boolean bookappointment(String PatientID, String date, String t1, String t2, String t, String p)  {
		if ( isNumeric(PatientID) && isDate(date) && inTimeFrame(t1,t2) && timeFree(t1)
				&& validTreatment(t) && validPartner(p)) {	
		    return false;
	    }
		return true;	
	}
	
	public static boolean isNumeric(String str)  {  
	    try {  
	        Double.parseDouble(str);  
	    }  
	    catch(NumberFormatException nfe) {  
	        return false;  
	    }  
	    return true;  
    }
	
	public static boolean isDate(String str)  {  
		try {
		    DateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		    sdf.parse(str);  
		} 
		catch ( ParseException e){
			return false;
		}
	    return true;  
    }
	
	public static boolean timeFree(String str) {
		return true;
	}
	
	public static boolean inTimeFrame(String str,String str2)  {
		try {
		    DateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		    sdf.parse(str);
		    Integer firstChar = Integer.parseInt(str.substring(0,1));
		    Integer secondChar = Integer.parseInt(str.substring(1,2));
		    Integer secondChar2 = Integer.parseInt(str2.substring(1,2));
		    Integer fourthChar2 = Integer.parseInt(str2.substring(3,4));
		    if ((firstChar == 0 && secondChar < 9) ||
		    	(firstChar == 1 && secondChar > 6) ||
		    	(firstChar > 1) || (firstChar < 0) ||
		    	(secondChar2 == 7) || (fourthChar2 > 0) ) {
		    	return false;
		    }  
		} 
		catch ( NumberFormatException | ParseException ex){
			return false;
		}
	    return true;  
    }
	
	public static boolean validTreatment(String str)  {  
		for (int i=0; i<5; i++) {
	        if ((Treatment.values()[i].name()==str.toUpperCase())) {
	            return true;
	        }
		}
		return false;
    }
	
	public static boolean validPartner(String str)  {  
	    if ((Prtner.values()[1].name()==str.toUpperCase()) || 
	        (Prtner.values()[0].name()==str.toUpperCase())) {
	        return true;
	    }
	    else { 
	    	return false;
	    } 
    }
	
}
