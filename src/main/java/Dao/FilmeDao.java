package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.ConexaoHSQLDB;
import entity.interFilme;
import entity.Filme;
             ///////////////////MEXEEEEEEEEER NO BANCOOOOOOOOOOOOOOOO + PATHBASE CONEXAOHSQLDB////

public class FilmeDao extends ConexaoHSQLDB implements interFilme{
	final String SQL_INSERT_FILMEE = "INSERT INTO FILMEE(NOME, DIRETOR, GENERO, DATALANCAMENTO, DURACAOFILME)VALUES (?,?,?,?,?)";
	final String SQL_SELECT_FILMEE = "SELECT * FROM FILMEE";
	final String SQL_SELECT_FILMEE_ID = "SELECT * FROM FILMEE WHERE IDFILME = ?";
	final String SQL_ALTERA_FILMEE = "UPDATE FILMEE SET NOME=?, DIRETOR=?, GENERO=?, DATALANCAMENTO=?, DURACAOFILME=?  WHERE IDFILME = ?";
	final String SQL_DELETA_FILMEE = "DELETE FROM FILMEE WHERE IDFILME = ?";
	final String SQL_SELECT_FILMEE_NOME = "SELECT * FROM FILMEE WHERE NOME = ?";
	
	public Filme BuscarDados(String nome) {
		Filme filme = new Filme();
		try (Connection connection = this.conectar();
				PreparedStatement pst = connection.prepareStatement(SQL_SELECT_FILMEE_NOME);) {

			pst.setString(1, nome);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				filme.setIdFilme(rs.getInt("IDFILME"));
				filme.setNome(rs.getString("NOME"));
				filme.setDiretor(rs.getString("DIRETOR"));
				filme.setGenero(rs.getString("GENERO"));
				filme.setDataLançamento(java.sql.Date.valueOf((rs.getString("DATALANCAMENTO"))));
				filme.setDuracaoFilme(rs.getString("DURACAOFILME"));
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return filme;
	}
	
public int inserir(Filme filmee) {
	int quantidade = 0;

	//INSERIR
	try (Connection connection = this.conectar();
			PreparedStatement pst = connection.prepareStatement(SQL_INSERT_FILMEE);) {
		pst.setString(1, filmee.getNome()); 
		pst.setString(2, filmee.getDiretor()); 
		pst.setString(3, filmee.getGenero()); 
		pst.setDate(4, java.sql.Date.valueOf(filmee.getDataLançamento().toString()));
		pst.setString(5, filmee.getDuracaoFilme());
		
		quantidade = pst.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}

	return quantidade;
	}

	//LISTAR
public List<Filme> listAll(){
	List<Filme> listaFilme= new ArrayList<Filme>();
	
	try (Connection connection = this.conectar();
			PreparedStatement pst = connection.prepareStatement(SQL_SELECT_FILMEE);){

		ResultSet rs = pst.executeQuery();
		
		while(rs.next()) {
			Filme filme = new Filme();
	
			
			filme.setIdFilme(rs.getInt("IDFILME"));
			filme.setNome(rs.getString("NOME"));
			filme.setDiretor(rs.getString("DIRETOR"));
			filme.setGenero(rs.getString("GENERO"));
			filme.setDataLançamento(java.sql.Date.valueOf((rs.getString("DATALANCAMENTO"))));
			filme.setDuracaoFilme(rs.getString("DURACAOFILME"));
			
			listaFilme.add(filme);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return listaFilme;
	}
	
	//BUSCAR PELO ID
public Filme findByID(int idFilme) {
	Filme filmee = null;
	try (Connection connection = this.conectar();
			PreparedStatement pst = connection.prepareStatement(SQL_SELECT_FILMEE_ID);){

		pst.setInt(1, idFilme);
		ResultSet rs = pst.executeQuery();
		
		while(rs.next()) {
			filmee = new Filme();
			
			filmee.setIdFilme(rs.getInt("IDFILME"));
			filmee.setNome(rs.getString("NOME"));
			filmee.setDiretor(rs.getString("DIRETOR"));
			filmee.setGenero(rs.getString("GENERO"));
			filmee.setDataLançamento(java.sql.Date.valueOf(rs.getDate("DATALANCAMENTO").toString()));
			filmee.setDuracaoFilme(rs.getString("DURACAOFILME"));
			
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return filmee;
	}

	//ALTERAR FILME
public int alterar(Filme filme) {
	int quantidade = 0;

	try (Connection connection = this.conectar();
			PreparedStatement pst = connection.prepareStatement(SQL_ALTERA_FILMEE);) {

		pst.setString(1, filme.getNome()); //COM HERANÇA DA CLASSE MATERIAL
		pst.setString(2, filme.getDiretor()); //COM HERANÇA DA CLASSE MATERIAL
		pst.setString(3, filme.getGenero()); //COM HERANÇA DA CLASSE MATERIAL
		pst.setDate(4, java.sql.Date.valueOf(filme.getDataLançamento().toString()));
		pst.setString(5, filme.getDuracaoFilme());
		pst.setInt(6, filme.getIdFilme());
		

		quantidade = pst.executeUpdate();

	} catch (SQLException e) {
		e.printStackTrace();
	}

	return quantidade; 
	}

	//DELETAR FILME
public int deletar(int idFilme) {
        int quantidade = 0;
        try (Connection connection = this.conectar();
                PreparedStatement pst = connection.prepareStatement(SQL_DELETA_FILMEE);) {
            pst.setInt(1, idFilme);
            
            quantidade = pst.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return quantidade;
    }

	@Override
	public void ClassInter() {
		// TODO Auto-generated method stub

	}
}
