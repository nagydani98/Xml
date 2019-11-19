package model;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Employee {
	String id;
	String name;
	
	public Employee() {
		super();
	}
	
	public Employee(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public static ArrayList<Employee> processTeam(Node node) {
		ArrayList<Employee> arrayList = new ArrayList<>();
		NodeList nodeList = node.getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node current = nodeList.item(i);
			
			if(current.hasAttributes()) {
				arrayList.add(create(current));
			}
		}
		
		return arrayList;
	}

	public static Employee create(Node node) {
		Element element = (Element) node;
		return new Employee(element.getAttribute("id"), element.getAttribute("name")); 
	}
	
	public static Element create(Employee employee, Document doc) {
		Element element = doc.createElement("employee");
		element.setAttribute("id", employee.id);
		element.setAttribute("name", employee.name);
		return element;
	}
	
	public static boolean checkEmployee(Employee employee) {
		if(employee != null && !employee.name.equals("") && !employee.id.equals("")) {
			return true;
		}
		
		return false;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
