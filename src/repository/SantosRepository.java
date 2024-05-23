package repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javafx.scene.control.TextField;

public class SantosRepository {
		private List<SantosRepository> santao;
		private File database;
		
		
		public SantosRepository () {
			this.database = new File("database-santao.txt");
			this.santao = new ArrayList<>();
			loadSantos();
		}
		
		
		public void updateSantos(SantosRepository uptadedSantao) {
			for (int i = 0; i < santao.size(); i++) {
				if (santao.get(i).getId() == uptadedSantao.getId()) {
					santao.set(i, uptadedSantao);
					saveSantao();
					break;
					
				}
			}
		}
		
		
		public SantosRepository getSantaoById(int id) {
			for (SantosRepository santao : santao){
				if(santao.getId() == id) {
					return santao;
				}
			}
			return null;
			
		}
		
		
		
		private void loadSantos() {
			try (Scanner sc = new Scanner(database)) {
				while (sc.hasNextLine() ) {
					
					String[] data = sc.nextLine() .split(";");
					if(data.length >= 4) {
						
						SantosRepository santao = new SantosRepository();
						santao.setId(Integer.parseInt(data[0]));
						santao.setNome(data[1]);
						santao.setInicioSantos(data[2]);
						santao.setFimSantos(data[3]);
						
						santao.add(santao);
						
					}
					
				}
			} catch (FileNotFoundException e) {
				// TODO: handle exception
				System.out.println("Arquivo nao encontrado, criando um novo!");
			}
		}
		
		



		public void setNome(String string) {
			// TODO Auto-generated method stub
			
		}


		private static void add(SantosRepository santao2) {
			// TODO Auto-generated method stub
			
		}



		public void setFimSantos(String string) {
			// TODO Auto-generated method stub
			
		}



		public void setInicioSantos(String string) {
			// TODO Auto-generated method stub
			
		}



		public void setNome(TextField nomeSantos) {
			// TODO Auto-generated method stub
			
		}



		public List<SantosRepository> buscarTodos() {
			return new ArrayList<>(santao);
		}

		
		public void deleteSanto(int id) {
//			percorre todo o array, caso seja igual ele vai remover
			santao.removeIf(SantosRepository -> SantosRepository.getId() == id);
			saveSantao();
		}
		
		private int getId() {
			// TODO Auto-generated method stub
			return 0;
		}


		public void addSanto(SantosRepository SantosRepository) {
			SantosRepository.setId(getNextId());
			santao.add(SantosRepository);
			
			
			saveSantao();
			
		}


		public static void setId(int i) {
			// TODO Auto-generated method stub
			
		}
		
		
//		sobrescrever o arquivo
		private void saveSantao() {
			try (PrintWriter writer = new PrintWriter(new FileOutputStream(database, false))) {
				for (SantosRepository santao : santao) {
					String data = santao.getId() + ";" + santao.getNome() + ";" + santao.getInicioSantos() + ";" + santao.getFimSantos();
					writer.println(data);
				}
			} catch (FileNotFoundException e) {
				// TODO: handle exception
				System.out.println("Arquivo database não encontrado! Deu merda em");
			}
		}
		



		private int getFimSantos() {
			// TODO Auto-generated method stub
			return 0;
		}


		private int getInicioSantos() {
			// TODO Auto-generated method stub
			return 0;
		}


		private int getNome() {
	// TODO Auto-generated method stub
	return 0;
}


		private int getNextId() {
			int maxId = 0;
			for(SantosRepository santao : santao) {
				if(santao.getId() > maxId) {
					maxId = santao.getId();
				}
			}
			return maxId + 1;
		}


		public void addSantosRepository(SantosRepository ingresso) {
			// TODO Auto-generated method stub
			
		}


		
		
		
	}

