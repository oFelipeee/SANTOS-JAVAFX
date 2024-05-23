package controller;

import javafx.fxml.FXML;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import repository.SantosRepository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SantosController {
	
	@FXML
	private ObservableList<Object> tableView;
	
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
		cDia.setCellValueFactory(new PropertyValueFactory<>("nome"));                  
		cHorario.setCellValueFactory(new PropertyValueFactory<>("horario"));
		
		tableView = FXCollections.observableArrayList();
		
//		tableView.setItems(tableView);
		
		
		
		
		santos = new SantosRepository();
	}
	
	public void carregarDadosSalvos() {
		try(BufferedReader br = new BufferedReader(new FileReader("database-santao.txt"))){
			String line;
			while((line = br.readLine()) != null){
				String[] parts = line.split(";");
				if(parts.length >= 4) {
			 SantosRepository santao= new SantosRepository();
			 
			 santao.setId(Integer.parseInt(parts[0]));
			 santao.setNome(parts[1]);
			 santao.setInicioSantos(parts[2]);
			 santao.setFimSantos(parts[3]);
			 
			 ((List<Object>) dia).add(santao);
			 
				}
				
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	
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
