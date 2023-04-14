package it.polito.tdp.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.database.AnagrammaDAO;

public class Model {
	AnagrammaDAO anagrammaDao = new AnagrammaDAO();
	Anagramma anagramma = new Anagramma();
	
	public List<String> getAnagrammi(String parola){
		return anagramma.anagrammi(parola);
	}
	
	public List<RichWord> getRichWord(List<String> parole) {
		List<RichWord> ret = new ArrayList<>();
		
		for(String s : parole) {
			boolean find = anagrammaDao.isCorrect(s);
			ret.add(new RichWord(s, find));
		}
		return ret;
	}
}
