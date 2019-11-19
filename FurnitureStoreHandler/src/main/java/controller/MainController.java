package controller;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import model.Employee;
import model.Furniture;
import model.Sale;
import view.MainView;

public class MainController {
	private static ArrayList<Employee> employees = new ArrayList<>();
	private static ArrayList<Furniture> furniture = new ArrayList<>();
	private static ArrayList<Sale> sales = new ArrayList<>();
	private static MainView mainView = new MainView();
	public static Document store;
	
	public static void displayMainView() {
		mainView.Menu();
	}
	
	public static void processDocument() {
		Element root = store.getDocumentElement();
		Node team = root.getElementsByTagName("team").item(0);
		Node wares = root.getElementsByTagName("wares").item(0);
		Node saleHistory = root.getElementsByTagName("saleHistory").item(0);
		employees = Employee.processTeam(team);
		root.appendChild(team);
		furniture = Furniture.processWares(wares);
		root.appendChild(wares);
		sales = Sale.processSaleHistory(saleHistory);
		root.appendChild(saleHistory);
	}
	
	public static void insertEmpp(Employee employee) {
		Node team = store.getDocumentElement().getElementsByTagName("team").item(0);		
		employees.add(employee);
		Element element = Employee.create(employee, store);
		team.appendChild(element);
		
	}
	
	public static void insertFurn(Furniture furn) {
		Node wares = store.getDocumentElement().getElementsByTagName("wares").item(0);	
		furniture.add(furn);
		Element element = Furniture.create(furn, store);
		wares.appendChild(element);
		
	}
	
	public static void insertSale(Sale sale) {
		Node saleHistory = store.getDocumentElement().getElementsByTagName("saleHistory").item(0);	
		sales.add(sale);
		Element element = Sale.create(sale, store);
		saleHistory.appendChild(element);
		
	}
	
	public static Employee getEmpById(String id) {
		return employees.stream().filter(employee -> employee.getId().equals(id)).findFirst().orElse(new Employee());
	}
	
	public static Furniture getFurnitureById(String id) {
		return furniture.stream().filter(furn -> furn.getId().equals(id)).findFirst().orElse(new Furniture());
	}
	
	public static Sale getSalepById(String id) {
		return sales.stream().filter(sale -> sale.getId().equals(id)).findFirst().orElse(new Sale());
	}
	
	public static Sale getSaleByEmpId(String id) {
		return sales.stream().filter(sale -> sale.getEmpId().equals(id)).findFirst().orElse(new Sale());
	}
	
	public static Sale getSaleByFurnId(String id) {
		return sales.stream().filter(sale -> sale.getFurnitureId().equals(id)).findFirst().orElse(new Sale());
	}

	public static ArrayList<Employee> getEmployees() {
		return employees;
	}

	public static void setEmployees(ArrayList<Employee> employees) {
		MainController.employees = employees;
	}

	public static ArrayList<Furniture> getFurniture() {
		return furniture;
	}

	public static void setFurniture(ArrayList<Furniture> furniture) {
		MainController.furniture = furniture;
	}

	public static ArrayList<Sale> getSales() {
		return sales;
	}

	public static void setSales(ArrayList<Sale> sales) {
		MainController.sales = sales;
	}
	
	
}
