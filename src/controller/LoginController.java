package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
	
	@FXML
	private TextField usuario;
	
	@FXML
	private PasswordField senha;
	
	public void entrar() {
		System.out.println("Tentaiva de entrar!");
		
		if (usuario.getText().equals("admin") && senha.getText().equals("admin")) {
			System.out.println("Realizando Login");
		}else {
			mensagemDeErro();
		}
	}
	
	public void mensagemDeErro() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Sua senha esta errada");
		alert.setContentText("Senha Correta");
		alert.setHeaderText(null);
		alert.showAndWait();
	}

}
