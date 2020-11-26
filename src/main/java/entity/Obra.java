package entity;

public abstract class Obra {
private String nome;
private String diretor;
private String genero;

 
//GET E SET
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getDiretor() {
	return diretor;
}
public void setDiretor(String diretor) {
	this.diretor = diretor;
}
public String getGenero() {
	return genero;
}
public void setGenero(String genero) {
	this.genero = genero;
}


//TO STRING
@Override
public String toString() {
	return "Obra [nome=" + nome + ", diretor=" + diretor + ", genero=" + genero + "]";
}


//HASH CODE
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((diretor == null) ? 0 : diretor.hashCode());
	result = prime * result + ((genero == null) ? 0 : genero.hashCode());
	result = prime * result + ((nome == null) ? 0 : nome.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Obra other = (Obra) obj;
	if (diretor == null) {
		if (other.diretor != null)
			return false;
	} else if (!diretor.equals(other.diretor))
		return false;
	if (genero == null) {
		if (other.genero != null)
			return false;
	} else if (!genero.equals(other.genero))
		return false;
	if (nome == null) {
		if (other.nome != null)
			return false;
	} else if (!nome.equals(other.nome))
		return false;
	return true;
}

// CONSTRUCTOR POVOADO
public Obra(String nome, String diretor, String genero) {
	super();
	this.nome = nome;
	this.diretor = diretor;
	this.genero = genero;
}


//CONSTRUCTOR VAZIO
public Obra() {
	super();
	
}
 











}
