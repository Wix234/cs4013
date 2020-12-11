
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class TestProperties {
	static List<Owner> owners = new ArrayList<>();
	static List<Property> properties = new ArrayList<>();
	private static Owners owner;
	public static void main(String[] args) {
	        owner = new Owners();
	        readOwnersFromCSV();
	        readPropertiesFromCSV();
	        addProperties();
	        
	        System.out.println(owner.toString());
	        //System.out.println(properties.toString());
	    }
    
	    private static void readOwnersFromCSV() {
	        String csvFile = "Owners.csv";
	        Path pathToFile = Paths.get(csvFile);
	        try (BufferedReader br = Files.newBufferedReader(pathToFile)) {
	            String line = br.readLine();
	            while (line != null) {
	                String[] attributes = line.split(",");
	                Owner temp = createOwner(attributes);
	                owners.add(temp);
	                owner.addOwner(temp);
	                line = br.readLine();
	            }
	        } catch (IOException ioe) {
	            ioe.printStackTrace();
	        }
	    }
	    
	    private static Owner createOwner(String[] details) {
	    	String name = details[0];
	    	String address = details[1];
	        String eircode = details[2];
	        return new Owner(name, address, eircode);
	    }
	    
	    private static void readPropertiesFromCSV() {
	        String csvFile = "Properties.csv";
	        Path pathToFile = Paths.get(csvFile);
	        try (BufferedReader br = Files.newBufferedReader(pathToFile)) {
	            String line = br.readLine();
	            while (line != null) {
	                String[] attributes = line.split(",");
	                Property temp = createProperty(attributes);
	                properties.add(temp);
	                line = br.readLine();
	            }
	        } catch (IOException ioe) {
	            ioe.printStackTrace();
	        }
	    }
	    public static void addProperties(){
	    	for (int i = 0; i < owners.size(); i ++ ){
    			for (int j = 0; j < properties.size(); j ++ ){
    				if (owners.get(i).getName().equalsIgnoreCase(properties.get(j).getName())){
    					owners.get(i).addProperty(properties.get(j));
    				}	
    			}
    		}
	    }
	    private static Property createProperty(String[] details) {
	    	String name = details[0];
	    	String address = details[1];
	        String eircode = details[2];
	        double price = Double.parseDouble(details[3]);
	        String location = details[4];
	        String PR = details[5];
	        int year = Integer.parseInt(details[6]);
	        return new Property(name, address, eircode, price, location, PR, year);
	    }    

}

