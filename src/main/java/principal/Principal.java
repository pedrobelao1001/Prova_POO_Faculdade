package principal;

import entity.Filme;
import Dao.FilmeDao;
import View.Filme.ControllerFilme;

public class Principal {

	public static void main(String[] args) {
		new ControllerFilme().execute();
		//System.out.println(new FilmeDao().listAll());
	}
}
