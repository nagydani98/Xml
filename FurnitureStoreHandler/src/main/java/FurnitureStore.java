import org.w3c.dom.Document;

import controller.MainController;
import io.ConsoleReader;
import io.XMLParser;

public class FurnitureStore {
	public static Document store;
	public static final String PATH = "src/main/resources/store.xml";
	
	public static void main(String[] args) {
		store = XMLParser.parseDocument(PATH);
		if(store != null) {
			MainController.store = store;
			MainController.processDocument();
			MainController.displayMainView();
			
			System.out.println("Akarod menteni az esetleges változtatásokat?(y)");
			String yn = ConsoleReader.readStringBetweenLength(1, 1);
			
			if(yn.toLowerCase().equals("y")) {
				XMLParser.saveDocument(store, PATH);
			}
			
		}
		
	}

}
