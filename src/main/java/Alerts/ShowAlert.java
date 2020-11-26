package Alerts;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ShowAlert {
	public void validaAlert() {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Atenção");
		alert.setHeaderText(null);
		alert.setContentText("Preencha todos os campos!");
		alert.showAndWait();
	}
	
	public void SelecionarPessoa() {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Atenção");
		alert.setHeaderText(null);
		alert.setContentText("Selecione um cadastro para deletar!");
		alert.showAndWait();
	}
	
	public void SelecionarPessoaEditar() {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Atenção");
		alert.setHeaderText(null);
		alert.setContentText("Selecione um cadastro para editar!");
		alert.showAndWait();
	}
}

