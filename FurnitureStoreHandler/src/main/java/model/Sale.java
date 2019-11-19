package model;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Sale {
	String id;
	String empId;
	String furnitureId;
	int amount;
	
	
	public Sale() {
		super();
	}

	public Sale(String id, String empId, String furnitureId, int amount) {
		super();
		this.id = id;
		this.empId = empId;
		this.furnitureId = furnitureId;
		this.amount = amount;
	}
	
	public Sale(String id, String empId, String furnitureId, String amount) {
		// TODO Auto-generated constructor stub
		super();
		this.id = id;
		this.empId = empId;
		this.furnitureId = furnitureId;
		this.amount = Integer.parseInt(amount);
	}

	public static ArrayList<Sale> processSaleHistory(Node node) {
		ArrayList<Sale> arrayList = new ArrayList<>();
		NodeList nodeList = node.getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node current = nodeList.item(i);
			
			if(current.hasAttributes()) {
				arrayList.add(create(current));
			}
		}
		
		return arrayList;
	}
	
	public static boolean checkSale(Sale sale) {
		if(sale != null && !sale.id.equals("") && !sale.empId.equals("") && !sale.furnitureId.equals("") && sale.amount > 0) {
			return true;
		}
		
		return false;
	}
	
	public static Sale create(Node node) {
		Element element = (Element) node;
		return new Sale(element.getAttribute("id"), element.getAttribute("employeeId"), element.getAttribute("furnitureId"), element.getAttribute("amount"));
	}
	
	public static Element create(Sale sale, Document doc) {
		Element element = doc.createElement("sale");
		element.setAttribute("id", sale.id);
		element.setAttribute("employeeId", sale.empId);
		element.setAttribute("furnitureId", sale.furnitureId);
		element.setAttribute("amount", "" + sale.amount);
		return element;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getFurnitureId() {
		return furnitureId;
	}
	public void setFurnitureId(String furnitureId) {
		this.furnitureId = furnitureId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Sale [id=" + id + ", empId=" + empId + ", furnitureId=" + furnitureId + ", amount=" + amount + "]";
	}
	
	
}
