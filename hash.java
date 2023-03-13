import java.util.ArrayList;
import javax.swing.JOptionPane;

public class hash {
	//Declarando as listas que receberão os nomes
	public static ArrayList<String> names0 = new ArrayList<>();
	public static ArrayList<String> names1 = new ArrayList<>();
	public static ArrayList<String> names2 = new ArrayList<>();
	public static ArrayList<String> names3 = new ArrayList<>();
	public static ArrayList<String> names4 = new ArrayList<>();
	
	//A lista que receberá as listas dos nomes
	public static ArrayList<Object> parentList = new ArrayList<>();

	//Menu que recebe a operação que o usuário deseja executar
	private static void menu() {
		try {
			String panel = JOptionPane.showInputDialog(
					"O que deseja fazer? \n" + "1- Inserir \n" + "2- Listar \n" + "3- Deletar \n" + "4- Sair");
			
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

	//Função que retorna o valor da soma do código hash de cada caractere de uma string
	private static int hashValue(String name) {
		
		int acumulado = 0;

		for (int i = 0; i < name.length(); i++) {

			char aux = name.charAt(i);
			String caracter = aux + ""; 
			acumulado += caracter.hashCode();

		}
		return acumulado;
	}

	private static void create() {
		//String que receberá o valor que o usuário digitou
		String NameIn = JOptionPane.showInputDialog("Digite um nome...");

		//Mostrando o resultado da chave (hash total) e em qual lista o nome será inserido  
		JOptionPane.showMessageDialog(null, "Nome : " + NameIn + "\nChave  : " + hashValue(NameIn)
				+ "\nHash Total : " + hashValue(NameIn) % 5);

		//Switch para inserir o nome com base no mod da chave em alguma lista
		switch (hashValue(NameIn) % 5) {
			case 0:
				names0.add(NameIn);
				break;

			case 1:
				names1.add(NameIn);
				break;

			case 2:
				names2.add(NameIn);
				break;

			case 3:
				names3.add(NameIn);
				break;

			case 4:
				names4.add(NameIn);
				break;
		}

		menu();
	}

	//Leitura de todas as listas e seus valores	
	private static void read() {
		JOptionPane.showMessageDialog(null, 
			"Leitura:" + 
					"\n[0] = " + names0 + 
					"\n[1] = " + names1 + 
					"\n[2] = " + names2 +
					"\n[3] = " + names3 + 
					"\n[4] = " + names4);

		menu();
	}

	//Função para excluir o nome inserido de sua respectiva lista
	private static void delete() {
		String nameIn = JOptionPane.showInputDialog("Digite o nome que deseja excluir...");

		int hashOfNameIn = hashValue(nameIn);

		switch (hashOfNameIn % 5) {
		case 0:
			names0.remove(nameIn);
			break;
		case 1:
			names1.remove(nameIn);
			break;
		case 2:
			names2.remove(nameIn);
			break;
		case 3:
			names3.remove(nameIn);
			break;
		case 4:
			names4.remove(nameIn);
			break;
		}

		menu();
	}

	public static void main(String[] args) {
		parentList.add(0, names0);
		parentList.add(1, names1);
		parentList.add(2, names2);
		parentList.add(3, names3);
		parentList.add(4, names4);
		
		menu();
	}

}
