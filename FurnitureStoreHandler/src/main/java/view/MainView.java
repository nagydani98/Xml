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
			System.out.println("1. Keresés kulcs alapján\n"
					+ "2. Felvétel\n"
					+ "3. Kilép");
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
					+ "2. Bútor\n"
					+ "3. Eladás\n"
					+ "4. Eladás keresése alkalmazott alapján\n"
					+ "5. Eladás keresése bútor alapján\n"
					+ "6. Vissza\n");
			int choice = ConsoleReader.readIntInRange(1, 6);
			
			switch (choice) {
			case 1:
				System.out.println("Alkalmazott id: ");
				String eid = ConsoleReader.readString();
				System.out.println(MainController.getEmpById(eid).toString());
				break;
			case 2:
				System.out.println("Bútor id: ");
				String fid = ConsoleReader.readString();
				System.out.println(MainController.getFurnitureById(fid).toString());
				break;
				
			case 3:
				System.out.println("Eladás id: ");
				String sid = ConsoleReader.readString();
				System.out.println(MainController.getSalepById(sid).toString());
				break;
				
			case 4:
				System.out.println("Alkalmazott id: ");
				String eid2 = ConsoleReader.readString();
				System.out.println(MainController.getSaleByEmpId(eid2).toString());
				break;
			case 5:
				System.out.println("Bútor id: ");
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
					+ "2. Bútor\n"
					+ "3. Eladás\n"
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
		System.out.println("Az új alkalmazott azonosítója: ");
		String id = ConsoleReader.readString();
		System.out.println("Neve: ");
		String name = ConsoleReader.readString();
		
		return new Employee(id, name);
	}
	
	public Furniture newFurn() {
		System.out.println("Az új bútor azonosítója: ");
		String id = ConsoleReader.readString();
		System.out.println("Neve: ");
		String name = ConsoleReader.readString();
		System.out.println("Színe: ");
		String colour = ConsoleReader.readString();
		System.out.println("Méreteti: ");
		String dim = ConsoleReader.readString();
		
		return new Furniture(id, name, colour, dim);
	}
	
	public Sale newSale() {
		System.out.println("Új eladás azonosítója: ");
		String id = ConsoleReader.readString();
		System.out.println("Az eladó azonosítója: ");
		String empid = ConsoleReader.readString();
		System.out.println("A bútor azonosítója: ");
		String fid = ConsoleReader.readString();
		System.out.println("Mennyiség: ");
		int amount = ConsoleReader.readIntInRange(1, Integer.MAX_VALUE);
		return new Sale(id, empid, fid, amount);
	}
}
