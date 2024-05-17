package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import repository.SantosRepository;

public class SantosController {
	
	@FXML
	private TableView<SantosRepository> tableview;
	
	@FXML
	private TableColumn<SantosRepository, String> cDia;
	
	@FXML
	private TableColumn<SantosRepository, String> cHorario;
	
	@FXML
	private TextField nomeSantos;
	
	@FXML
	private TextField  dia;
	
	@FXML
	private TextField  horario;
	
	private SantosRepository santos;
	
	public void initialize( ) {
		santos = new SantosRepository();                                
	}
	
	public void reservar () {
		SantosRepository ingresso = new SantosRepository();
		ingresso.setNome(nomeSantos);
		ingresso.setInicioSantos(dia.getText());
		ingresso.setFimSantos(horario.getText());
		santos.addSantosRepository(ingresso);
		clearFields();
		
	}
	
	public void clearFields() {
		nomeSantos.clear();
		dia.clear();
		horario.clear();
		
	}
	
	public void limpar() {
		clearFields();
	}
	
	public void clear() {
		System.out.println("Clicou no botão limpar");
	}

}
