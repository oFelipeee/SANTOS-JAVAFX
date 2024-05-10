package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LoginController {
	
	@FXML
	private TextField usuario;
	
	@FXML
	private PasswordField senha;
	
	public Stage primaryStage;
	
	public void entrar() {
		System.out.println("Tentaiva de entrar!");
		
		if (usuario.getText().equals("admin") && senha.getText().equals("admin")) {
		
			try {
				
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/dashboard.fxml"));
				
			StackPane root = new StackPane();
			
			loader.setRoot(root);
			loader.load();
				
				Scene scene = new Scene(root, 600, 400);
				
				Stage currentStage = (Stage) usuario.getScene().getWindow();
				currentStage.close();
				
				currentStage.setScene(scene);
				currentStage.setTitle("dashboard");
				currentStage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
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
