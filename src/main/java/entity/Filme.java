package entity;

import java.sql.Date;

public class Filme extends Obra  {
	
	private int idFilme;
	private Date dataLancamento;
	private String duracaoFilme;
	
	
	public Filme(String nome, String diretor, String genero) {
		super(nome, diretor, genero);
	}
	
	public Filme(String nome, String diretor, String genero, int idFilme, Date dataLancamento,
			String duracaoFilme) {
		super(nome, diretor, genero);
		this.idFilme = idFilme;
		this.dataLancamento = dataLancamento;
		this.duracaoFilme = duracaoFilme;
		
	}
	

	public Filme(String nome, String diretor, String genero, Date dataLancamento,
			String duracaoFilme) {
		super(nome, diretor, genero);
		this.idFilme = idFilme;
		this.dataLancamento = dataLancamento;
		this.duracaoFilme = duracaoFilme;
		
	}
	

	

//get e set

public int getIdFilme() {
		return idFilme;
	}
	public void setIdFilme(int idFilme) {
		this.idFilme = idFilme;
	}
	public Date getDataLançamento() {
		return dataLancamento;
	}
	public void setDataLançamento(Date dataLançamento) {
		this.dataLancamento = dataLançamento;
	}
	public String getDuracaoFilme() {
		return duracaoFilme;
	}
	public void setDuracaoFilme(String duracaoFilme) {
		this.duracaoFilme = duracaoFilme;
	}




	//hashcode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dataLancamento == null) ? 0 : dataLancamento.hashCode());
		result = prime * result + ((duracaoFilme == null) ? 0 : duracaoFilme.hashCode());
		result = prime * result + idFilme;
		return result;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filme other = (Filme) obj;
		if (dataLancamento == null) {
			if (other.dataLancamento != null)
				return false;
		} else if (!dataLancamento.equals(other.dataLancamento))
			return false;
		if (duracaoFilme == null) {
			if (other.duracaoFilme != null)
				return false;
		} else if (!duracaoFilme.equals(other.duracaoFilme))
			return false;
		if (idFilme != other.idFilme)
			return false;
		return true;
	}




	



	public Filme() {
		super();
		
	}

}
