package Packing;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class exec {

	public static String[] vet = new String[5];

	public static ArrayList<Object> papae = new ArrayList<>();

	public static ArrayList<String> nomes0 = new ArrayList<>();
	public static ArrayList<String> nomes1 = new ArrayList<>();
	public static ArrayList<String> nomes2 = new ArrayList<>();
	public static ArrayList<String> nomes3 = new ArrayList<>();
	public static ArrayList<String> nomes4 = new ArrayList<>();
	

	private static int posicao(String name) {
		
		int acumulado = 0;

		for (int i = 0; i < name.length(); i++) {

			char aux = name.charAt(i);
			String caracter = aux + ""; 
			acumulado += caracter.hashCode();

		}
		return acumulado;
	}

	private static void menu() {
		try {
			String panel = JOptionPane.showInputDialog(
					"O que deseja fazer? \n " + " 1- Inserir \n  " + " 2- Listar \n " + " 3- Deletar \n " + " 4- Sair");
			
			int op = Integer.parseInt(panel);
			
			if (op > 0 & op < 5) {

				switch (op) {
				case 1:
					create();
					break;
				case 2:
					read();
					break;
				case 3:
					delete();
					break;
				case 4:
					System.exit(0);
					break;
				}
			} else {
				JOptionPane.showMessageDialog(null, "Escolha uma opção válida...");
				menu();
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Escolha uma opção válida...");
			menu();
		}
	}

	private static void delete() {
		String nomeDigitado = JOptionPane.showInputDialog("Digite o nome para excluir");

		int resultadohash = posicao(nomeDigitado);

		switch (resultadohash % 5) {
		case 0:
			nomes0.remove(nomeDigitado);
			break;
		case 1:
			nomes1.remove(nomeDigitado);
			break;
		case 2:
			nomes2.remove(nomeDigitado);
			break;
		case 3:
			nomes3.remove(nomeDigitado);
			break;
		case 4:
			nomes4.remove(nomeDigitado);
			break;
		}

		menu();
	}

	private static void read() {

		JOptionPane.showMessageDialog(null, 
			"Leitura:" + 
					"\n[0] = " + nomes0 + 
					"\n[1] = " + nomes1 + 
					"\n[2] = " + nomes2 +
					"\n[3] = " + nomes3 + 
					"\n[4] = " + nomes4);

		System.out.println(papae);

		menu();
	}

	private static void create() {

		String nomeDigitado = JOptionPane.showInputDialog("Digite um nome");

		JOptionPane.showMessageDialog(null, "Nome : " + nomeDigitado + "\nChave  : " + posicao(nomeDigitado)
				+ "\nHash Total : " + posicao(nomeDigitado) % 5);

		switch (posicao(nomeDigitado) % 5) {
		case 0:
			nomes0.add(nomeDigitado);
			break;

		case 1:
			nomes1.add(nomeDigitado);
			break;

		case 2:
			nomes2.add(nomeDigitado);
			break;

		case 3:
			nomes3.add(nomeDigitado);
			break;

		case 4:
			nomes4.add(nomeDigitado);
			break;
		}

		menu();
	}

	public static void main(String[] args) {
		papae.add(0, nomes0);
		papae.add(1, nomes1);
		papae.add(2, nomes2);
		papae.add(3, nomes3);
		papae.add(4, nomes4);
		
		menu();
	}

}
