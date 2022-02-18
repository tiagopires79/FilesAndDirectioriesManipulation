package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entities.ItensVendidos;
import entities.Product;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		File readerPath = new File("C:\\temp\\ExercManipArquivos\\in.csv");
		
		// Lendo arquivo e instanciando objetos na memória
		try (BufferedReader br = new BufferedReader(new FileReader(readerPath))){			
			String[] line;
			//List<Product> products = new ArrayList<>();
			List<ItensVendidos> vendas = new ArrayList<>();
			String prod = br.readLine();
			while (prod != null) {
				line = prod.split(",");
				String name = line[0];
				Double unitPrice = Double.parseDouble(line[1]);
				Integer quantity = Integer.parseInt(line[2]);
				
				Product product = new Product(name, unitPrice, quantity);
				vendas.add(new ItensVendidos(product));				
				//products.add(product);
				prod = br.readLine();
			}
			
			//Criando diretorio caso nao exista 
			boolean exists = new File(readerPath.getParent() + "\\out").exists(); 
			if (exists == false) { 
				boolean success = new File(readerPath.getParent() + "\\out").mkdir();
				System.out.println("Directory Created Success: " + success); 
			}	

			// criando arquivo e inserindo dados dos objetos "Product"
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(readerPath.getParent() + "\\out\\summery.csv", true))){
				//for (Product p : products) { 
					//bw.write(p.getName()+ "," + String.format("%.2f",p.totalValue()));
					//System.out.println("Objeto : "+ p + "  =====>>>>>>  Arquivo out.csv: " + p.getName()+ "," + String.format("%.2f",p.totalValue()));
					//bw.newLine(); 
				//} 
				for (ItensVendidos item : vendas) { 
					bw.write(item.getProduct().getName() + "," + String.format("%.2f",item.fullPrice()));
					System.out.println("Objeto : "+ item.getProduct().toString() + "  =====>>>>>>  Arquivo out.csv: " + item.getProduct().getName() + "," + String.format("%.2f",item.fullPrice()));
					bw.newLine(); 
				}
			} 
			catch(IOException e){ 
				System.out.println("I/O Error: " + e.getMessage());
				e.printStackTrace(); 
			}
		}
		catch(IOException e){
			System.out.println("I/O Error: " + e.getMessage());
			e.printStackTrace(); 
		}		
	}
}

