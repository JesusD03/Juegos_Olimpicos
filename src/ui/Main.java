package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import model.Pais;
import model.PaisesOroPlataBronceNombre;

public class Main {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static List<Pais> paises;
	public static List<Pais> paisesCombinados;
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException{
		paises = new ArrayList<Pais>();
		paisesCombinados = new ArrayList<Pais>();
		menu();
	}
	
	public static void menu() throws IOException {
		System.out.println("Ingrese la cantidad de paises:");
		int amount = sc.nextInt();
		sc.nextLine();
		System.out.println("Ingrese los datos de los paies en el siguiente orden:\n"+
				"Nombre;OroMasculino;PlataMasculino;BronceMasculino;OroFemenino;PlataFemenino;BronceFemenino\n"+
				"Recuerde separar cada valor con ;");	
		
		for(int i=0; i<amount;i++) {
			System.out.println("ingrese un pais");
			String pais = br.readLine();
			addPais(pais);
		}
		
		printMasculino();
		printFemenino();
		combinarMedallas();
		printCombinadoBySelectionSort();
		printCombinadoByInsertionSort();
		
		
	}
	
	
		
	public static void addPais(String a) {
		String[] parts = a.split(";");
		paises.add(new Pais( parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), Integer.parseInt(parts[5]), Integer.parseInt(parts[6])));
	}

	public static void sortByComparator(){
		Comparator<Pais> p1 = new PaisesOroPlataBronceNombre();
		
		Collections.sort(paises, p1);
		
	}
	
	public static void combinarMedallas() {
		for(int i=0; i < paises.size(); i++) {
			paisesCombinados.add(new Pais(paises.get(i).getName(), (paises.get(i).getmOro()+paises.get(i).getfOro()), (paises.get(i).getmPlata()+paises.get(i).getfPlata()), (paises.get(i).getmBronce()+paises.get(i).getfBronce())));
		}
	}
	
	public static void selectSort() {
		
		int pos =0;
		while(pos < paisesCombinados.size()) {
			Pais max= paisesCombinados.get(pos);
			for(int i=pos; i<paisesCombinados.size(); i++) {

				if(paisesCombinados.get(i).getcOro()>max.getcOro()) {
					Pais temp = paisesCombinados.get(i);
					paisesCombinados.set(i, max);
					max = temp;
				}
			}
			paisesCombinados.set(pos, max);
			pos++;
		}
		
	}
	
	public static void insertionSort() {

		int j;
		Pais aux;
		for (int i=1; i<paisesCombinados.size(); i++) {
			aux = paisesCombinados.get(i);
			j = i-1;
			while((j>=0) && (aux.getcOro()>paisesCombinados.get(j).getcOro())) {
				paisesCombinados.set(j+1, paisesCombinados.get(j));
				j--;
			}
			paisesCombinados.set(j+1, aux);
		}

	}
	
	public static void printMasculino() {
		System.out.println("Masculino");
		sortByComparator();
		for(int i=0; i<paises.size(); i++) {
			System.out.println(paises.get(i).getName()+" "+paises.get(i).getmOro()+" "+paises.get(i).getmPlata()+" "+paises.get(i).getmBronce());
		}
		System.out.println("----------");
	}
	
	public static void printFemenino() {
		Collections.sort(paises);
		System.out.println("Femenino");
		for(int i=0; i<paises.size(); i++) {
			System.out.println(paises.get(i).getName()+" "+paises.get(i).getfOro()+" "+paises.get(i).getfPlata()+" "+paises.get(i).getfBronce());
		}
		System.out.println("----------");
	}
	
	public static void printCombinadoBySelectionSort() {
		System.out.println("Combinado por SelectionSort");
		selectSort();
		for(int i=0; i<paisesCombinados.size(); i++) {
			System.out.println(paisesCombinados.get(i).getName()+" "+paisesCombinados.get(i).getcOro()+" "+paisesCombinados.get(i).getcPlata()+" "+paisesCombinados.get(i).getcBronce());
		}
		System.out.println("----------");
	}
	
	public static void printCombinadoByInsertionSort() {
		System.out.println("Combinado por InsertionSort");
		insertionSort();
		for(int i=0; i<paisesCombinados.size(); i++) {
			System.out.println(paisesCombinados.get(i).getName()+" "+paisesCombinados.get(i).getcOro()+" "+paisesCombinados.get(i).getcPlata()+" "+paisesCombinados.get(i).getcBronce());
		}
	}
}
