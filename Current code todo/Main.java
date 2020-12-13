


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;



public class Main {
	static List<Owner> owners = new ArrayList<>();
	static List<Property> properties = new ArrayList<>();
	static List<Tax> taxes = new ArrayList<>();
	private static Owners owner; 
	public static void main(String[] args) throws IOException {
	        owner = new Owners();
	        readOwnersFromCSV();
	        readPropertiesFromCSV();
	        readTaxesFromCSV();
	        addProperties();
	        addTaxes();
	        
	        //System.out.println(owner.toString());
	        //System.out.println(properties.toString());
	        OwnersScreen menu = new OwnersScreen();
			menu.run(owner);
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
	    
	    private static void readTaxesFromCSV() {
	        String csvFile = "taxes.csv";
	        Path pathToFile = Paths.get(csvFile);
	        try (BufferedReader br = Files.newBufferedReader(pathToFile)) {
	            String line = br.readLine();
	            while (line != null) {
	                String[] attributes = line.split(",");
	                Tax temp = createTax(attributes);
	                taxes.add(temp);
	                line = br.readLine();
	            }
	        } catch (IOException ioe) {
	            ioe.printStackTrace();
	        }
	    }
	    public static void addTaxes(){
	    	for (int i = 0; i < properties.size(); i ++ ){
    			for (int j = 0; j < taxes.size(); j ++ ){
    				if (properties.get(i) == taxes.get(j).getP()){
    					properties.get(i).addTax(taxes.get(j));
    				}	
    			}
    		}
	    }
	    private static Tax createTax(String[] details) {
	    	String name = details[0];
	    	int year = Integer.parseInt(details[1]);
	    	int yearPaid;
	        if (Integer.parseInt(details[2]) != 0){
	        	yearPaid = Integer.parseInt(details[2]);
	        }else{
	        	yearPaid = 0;
	        }
	        Property p = null;
	        for (int i = 0; i <properties.size(); i++){
	        	if (properties.get(i).getAddress().equalsIgnoreCase(name)){
	        		p = properties.get(i);
	        	}
	        }
	        return new Tax(p, year, yearPaid);
	    }    

}
