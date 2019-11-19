package model;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Furniture {
	String id;
	String name;
	String colour;
	String dim;
	
	public Furniture() {
		super();
	}

	public Furniture(String id, String name, String colour, String dim) {
		super();
		this.id = id;
		this.name = name;
		this.colour = colour;
		this.dim = dim;
	}
	
	public static ArrayList<Furniture> processWares(Node node) {
		ArrayList<Furniture> arrayList = new ArrayList<>();
		NodeList nodeList = node.getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node current = nodeList.item(i);
			
			if(current.hasAttributes()) {
				arrayList.add(create(current));
			}
		}
		
		return arrayList;
	}
	
	public static Furniture create(Node node) {
		Element element = (Element) node;
		
		return new Furniture(element.getAttribute("id"),
				element.getAttribute("name"),
				element.getAttribute("colour"),
				element.getAttribute("dimensions"));
	}
	
	public static Element create(Furniture furniture, Document doc) {
		Element element = doc.createElement("product");
		element.setAttribute("id", furniture.id);
		element.setAttribute("name", furniture.name);
		element.setAttribute("colour", furniture.colour);
		element.setAttribute("dimensions", furniture.dim);

		return element;
	}
	
	public static boolean checkFurn(Furniture furniture) {
		if(furniture != null && !furniture.id.equals("") && !furniture.name.equals("")) {
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
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getDim() {
		return dim;
	}
	public void setDim(String dim) {
		this.dim = dim;
	}
	@Override
	public String toString() {
		return "Furniture [id=" + id + ", name=" + name + ", colour=" + colour + ", dim=" + dim + "]";
	}
	
	
}
