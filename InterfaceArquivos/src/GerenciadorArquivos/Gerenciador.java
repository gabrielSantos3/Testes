package GerenciadorArquivos;

import java.io.*;
import java.util.Scanner;

public class Gerenciador{
	public String nomeExtensao;
	
	public Gerenciador(String fileName, String formato) {
		this.nomeExtensao = fileName+"."+formato;
	}
	
	public Gerenciador() {
		
	}
	
	
	public String getNomeExtensao() {return this.nomeExtensao;}
    public void setNomeExtensao(String nomeExtensao) {this.nomeExtensao = nomeExtensao;}
    
	
	public boolean verificaSeExiste() {

		String caminho = "src/Arquivos/"+nomeExtensao;
		File file = new File(caminho);
		
		if(file.exists()) {
			return true;
		}
			
		else {
			return false;
		}
			
	}
	
	public boolean criarArquivo(){

		String caminho = "src/Arquivos/"+nomeExtensao;
		File file = new File(caminho);
		
		try {

            FileWriter escritor = new FileWriter(file);
            escritor.write("");
            escritor.close();
            
            return true;
            
        } catch (IOException e) {
            System.out.println("Erro ao criar o arquivo: " + e.getMessage());
            return false;
        }
			
	}
	
	public void lerArquivo() {
		
	}
	
	public void escrever() {
		
	}
	
	public void apagar() {
		
	}
	
	
}
