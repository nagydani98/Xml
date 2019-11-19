package view;

import controller.MainController;
import io.ConsoleReader;
import model.Employee;
import model.Furniture;
import model.Sale;

public class MainView {
	public void Menu() {
		boolean exit = false;
		
		while (!exit) {
			System.out.println("1. Keres�s kulcs alapj�n\n"
					+ "2. Felv�tel\n"
					+ "3. Kil�p");
			int choice = ConsoleReader.readIntInRange(1, 3);
			
			switch (choice) {
			case 1:
				searchMenu();
				break;
			case 2:
				newItemMenu();
				break;
			case 3:
				exit = true;
				break;
			default:
				break;
			}
		}
	}
	
	public void searchMenu() {
		boolean exit = false;
		
		while (!exit) {
			System.out.println("1. Alkalmazott\n"
					+ "2. B�tor\n"
					+ "3. Elad�s\n"
					+ "4. Elad�s keres�se alkalmazott alapj�n\n"
					+ "5. Elad�s keres�se b�tor alapj�n\n"
					+ "6. Vissza\n");
			int choice = ConsoleReader.readIntInRange(1, 6);
			
			switch (choice) {
			case 1:
				System.out.println("Alkalmazott id: ");
				String eid = ConsoleReader.readString();
				System.out.println(MainController.getEmpById(eid).toString());
				break;
			case 2:
				System.out.println("B�tor id: ");
				String fid = ConsoleReader.readString();
				System.out.println(MainController.getFurnitureById(fid).toString());
				break;
				
			case 3:
				System.out.println("Elad�s id: ");
				String sid = ConsoleReader.readString();
				System.out.println(MainController.getSalepById(sid).toString());
				break;
				
			case 4:
				System.out.println("Alkalmazott id: ");
				String eid2 = ConsoleReader.readString();
				System.out.println(MainController.getSaleByEmpId(eid2).toString());
				break;
			case 5:
				System.out.println("B�tor id: ");
				String fid2 = ConsoleReader.readString();
				System.out.println(MainController.getSaleByFurnId(fid2).toString());
				break;
			case 6:
				exit = true;
				break;
			default:
				break;
			}
		}
	}
	
	public void newItemMenu() {
		boolean exit = false;
		
		while (!exit) {
			System.out.println("1. Alkalmazott\n"
					+ "2. B�tor\n"
					+ "3. Elad�s\n"
					+ "4. Vissza");
			int choice = ConsoleReader.readIntInRange(1, 4);
			
			switch (choice) {
			case 1:
				MainController.insertEmpp(newEmp());
				break;
			case 2:
				MainController.insertFurn(newFurn());
				break;
			case 3:
				MainController.insertSale(newSale());
				break;
			case 4:
				exit = true;
				break;
			default:
				break;
			}
		}
	}
	
	public Employee newEmp() {
		System.out.println("Az �j alkalmazott azonos�t�ja: ");
		String id = ConsoleReader.readString();
		System.out.println("Neve: ");
		String name = ConsoleReader.readString();
		
		return new Employee(id, name);
	}
	
	public Furniture newFurn() {
		System.out.println("Az �j b�tor azonos�t�ja: ");
		String id = ConsoleReader.readString();
		System.out.println("Neve: ");
		String name = ConsoleReader.readString();
		System.out.println("Sz�ne: ");
		String colour = ConsoleReader.readString();
		System.out.println("M�reteti: ");
		String dim = ConsoleReader.readString();
		
		return new Furniture(id, name, colour, dim);
	}
	
	public Sale newSale() {
		System.out.println("�j elad�s azonos�t�ja: ");
		String id = ConsoleReader.readString();
		System.out.println("Az elad� azonos�t�ja: ");
		String empid = ConsoleReader.readString();
		System.out.println("A b�tor azonos�t�ja: ");
		String fid = ConsoleReader.readString();
		System.out.println("Mennyis�g: ");
		int amount = ConsoleReader.readIntInRange(1, Integer.MAX_VALUE);
		return new Sale(id, empid, fid, amount);
	}
}
