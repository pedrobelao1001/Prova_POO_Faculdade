package View.Filme;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import com.sun.javafx.application.LauncherImpl;

import Alerts.ShowAlert;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.sql.Date;


import Dao.FilmeDao;
import entity.Filme;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ControllerFilme extends Application {

	  @FXML
	    private TableView<Filme> TableFilme;

	    @FXML
	    private TableColumn<Filme, String> ColumaNome;

	    @FXML
	    private TableColumn<Filme, String> ColunaDiretor;

	    @FXML
	    private TableColumn<Filme, String> ColunaGenero;

	    @FXML
	    private TableColumn<Filme, String> ColunaDuracao;

	    @FXML
	    private TableColumn<Filme, Date> ColunaLancamento;

	    @FXML
	    private TableColumn<Filme, Integer> ColunaId;

	    @FXML
	    private TextField TXTNome;

	    @FXML
	    private TextField TXTDiretor;

	    @FXML
	    private TextField TXTGenero;

	    @FXML
	    private TextField TXTDuracao;

	    @FXML
	    private DatePicker TXTData;

	    @FXML
	    private TextField TXTBuscarID;

	    @FXML
	    private Button BTNSalvar;

	    @FXML
	    private Button BTNEditar;

	    @FXML
	    private Button BTNDeletar;
	    
	    @FXML
	    private Label Labelid;

	    @FXML
	    private Label LabelLabel;


    @FXML
    void BuscarID(ActionEvent event) {
    	String idString = TXTBuscarID.getText();
    	Filme filme = null;
    	if(!idString.equals("")) {
    		try {
    			int id = Integer.valueOf(idString);
    			filme = new FilmeDao().findByID(id);
    		} catch (Exception e) {
    	
    		}
    		if(filme != null) {
    			Labelid.setVisible(true);
    			LabelLabel.setVisible(true);
    			LabelLabel.setText(filme.getIdFilme()+  "");
    			TXTNome.setText(filme.getNome());
    			TXTDiretor.setText(filme.getDiretor() + "");
    			TXTGenero.setText(filme.getGenero());
    			TXTData.setValue(filme.getDataLançamento().toLocalDate());
    			TXTDuracao.setText(filme.getDuracaoFilme());
    			
    		}
    	}
    	TXTBuscarID.clear();
    }

    @FXML
    void DeletarFilme(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
     	 alert.setTitle("ATENÇÃO");
   	 alert.setHeaderText("EXCLUSÃO DE DADOS");
   	 alert.setContentText("VOCÊ TEM CERTEZA QUE DESEJA EXCLUIR O FILME");
          Optional<ButtonType> result = alert.showAndWait();
          
           if (result.get() == ButtonType.OK){
               Filme filme = obtemDadosID();
               int qtde = new FilmeDao().deletar(filme.getIdFilme());
               limpaCampo();
               listarFilme();
               StartTable();
           }
    }

    @FXML
    void EditarFilme(ActionEvent event) {
    	Filme filme = obtemDadosID();
    	limpaCampo();
    	int qtde = new FilmeDao().alterar(filme);
    	listarFilme();
    	StartTable();
    }

	@FXML
    void SalvarFilme(ActionEvent event) throws IOException {
    	if(validaCampos()) {
    		Filme filme = obtemDados();
    		limpaCampo();
    		int qtde = new FilmeDao().inserir(filme);
    		listarFilme();
    		StartTable();
    		Filme fim = new Filme();
    		System.out.println(fim);
  
    	}
    }
    
    private void limpaCampo() {
    	TXTNome.clear();
    	TXTDiretor.clear();
    	TXTGenero.clear();
    	TXTData.setValue(null);
    	TXTDuracao.clear();
    	
    	
    	LabelLabel.setVisible(false);
    	LabelLabel.setText("");
    }
    
    private void listarFilme() {
//    	textAreaLista.clear();
//    	List<Pedido> listapedido = new PedidoDAO().listAll();
//    	listapedido.forEach(pedido -> {
//    	textAreaLista.appendText(pedido.toString() +"\n");
//    });
    }

    private Filme obtemDados() {
    	Filme fim = new Filme();
    	fim.setNome(TXTNome.getText());
    	fim.setDiretor(TXTDiretor.getText());
    	fim.setGenero(TXTGenero.getText());
    	fim.setDataLançamento(java.sql.Date.valueOf(TXTData.getValue()));
    	fim.setDuracaoFilme(TXTDuracao.getText());
    	
    	return fim;
    }

    private Filme obtemDadosID() {
    	Filme fim = new Filme();
    	fim.setIdFilme(Integer.valueOf(LabelLabel.getText()));
    	fim.setNome(TXTNome.getText());
    	fim.setDiretor(TXTDiretor.getText());
    	fim.setGenero(TXTGenero.getText());
    	fim.setDataLançamento(java.sql.Date.valueOf(TXTData.getValue()));
    	fim.setDuracaoFilme(TXTDuracao.getText());
    	
    	return fim;
	}
    
    public boolean validaCampos() {
		if (TXTNome.getText().isEmpty() | TXTDiretor.getText().isEmpty() | TXTGenero.getText().isEmpty()
				 | TXTDuracao.getText().isEmpty()) {
			return false;
		}
		return true;
	}
    
	// Listar cadastros na TableView
	public void StartTable() {
		List<Filme> list = new FilmeDao().listAll();
		ColunaId.setCellValueFactory(new PropertyValueFactory<Filme, Integer>("idFilme"));
		ColumaNome.setCellValueFactory(new PropertyValueFactory<Filme, String>("nome"));
		ColunaDiretor.setCellValueFactory(new PropertyValueFactory<Filme, String>("diretor"));
		ColunaGenero.setCellValueFactory(new PropertyValueFactory<Filme, String>("genero"));
		ColunaLancamento.setCellValueFactory(new PropertyValueFactory<Filme, Date>("dataLançamento"));
		ColunaDuracao.setCellValueFactory(new PropertyValueFactory<Filme, String>("duracaoFilme"));
		TableFilme.setItems(atualizaTabela());
	}
	 
	// Converter para Collections
	public ObservableList<Filme> atualizaTabela() {
		FilmeDao dao = new FilmeDao();
		return FXCollections.observableArrayList(dao.listAll());
	}
    
//////////////////////////////////////////////////MÉTODO DE INICIALIZAÇÃO//////////////////////////////////////////////////////////
	public void execute() {
		launch();
	}

	public void start(Stage stage) {

		try {
			AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("FrontFilme.fxml"));
			Scene sc = new Scene(pane);
			stage.setScene(sc);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
