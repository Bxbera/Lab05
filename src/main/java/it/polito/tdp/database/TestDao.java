package it.polito.tdp.database;

public class TestDao {

	public static void main(String[] args) {
		
		AnagrammaDAO anDao = new AnagrammaDAO();
		System.out.println(anDao.isCorrect("akflhv haf"));
	}

}
