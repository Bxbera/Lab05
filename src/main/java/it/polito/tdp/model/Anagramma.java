package it.polito.tdp.model;

import java.util.LinkedList;
import java.util.List;


public class Anagramma {
	public List<String> anagrammi (String parola){
		
		if(parola.length()==1) {
			List<String> risultato = new LinkedList<String>() ;
			risultato.add(parola) ;
			return risultato ;
		}
		else {
			
			List<String> risultato = new LinkedList<>() ;
			
			for(int pos=0; pos<parola.length(); pos++) {
				// queste due righe si occupano di dividere il problema in sottoproblemi
				char lettera = parola.charAt(pos) ;
				String restanti = parola.substring(0, pos) + parola.substring(pos+1, parola.length()) ;
				
				List<String> anagrammiRestanti = anagrammi(restanti) ;
				for(String sol: anagrammiRestanti) {
					risultato.add(lettera+sol) ;
				}
			}
			
			return risultato ;
		}
		
	}
	
}
