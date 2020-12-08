package project;

import java.util.ArrayList;

public class Properties {
	public String ownerName;//temp so i can test it
	private ArrayList<Property> properties = new ArrayList<Property>();
	
	public Properties(String name){
		this.ownerName = name;
	}
	//needs to check for owners name as well as address
	public void addProperty(String address, String eircode, double estMarketVal,int location, boolean privateResidence){
        boolean found = false;
        for (int i = 0; i < properties.size(); i++){
            if (address == properties.get(i).getAddress()){
                found = true;
            }
        }
        if(found == false){
            Property property = new Property(address, eircode, estMarketVal,
            		location, privateResidence);
            properties.add(property);
        }else{
        	 Property property = new Property(address, eircode, estMarketVal,
             		location, privateResidence);
        	System.out.println("Property" + property.getAddress() + " already in database. \n");
        }
        
    }
	
	public ArrayList<Property> getProperties(){
		return properties;
	}
	//this needs to actually get stuff from owner
	public String getOwnerName(){
		return ownerName;
	}
	public String toString() {
        return (("Property owner: "+ ownerName  +  "\n" + properties).replace("[", "").replace("]", "").replace(",", "") +"\n");
    }
}
