
public class Property {
	private String address;
	private String eircode;
	private double estMarketVal;
	private int location;
	private boolean privateResidence;
	private int yearBought;
	
	public Property(String address, String eircode, double estMarketVal,int location, boolean privateResidence, int yearBought){
		setAddress(address);
		setEircode(eircode);
		setEstMarketVal(estMarketVal);
		setLocation(location); 
		setPrivateResidence(privateResidence);
		setYearBought(yearBought);
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getEircode() {
		return eircode;
	}
	
	public void setEircode(String eircode) {
		this.eircode = eircode;
	}
	
	public double getEstMarketVal() {
		return estMarketVal;
	}
	
	public void setEstMarketVal(double estMarketVal) {
		this.estMarketVal = estMarketVal;
	}
	
	public int getLocation() {
		return location;
	}
	
	public void setLocation(int location) {
		this.location = location;
	}
	
	public boolean isPrivateResidence() {
		return privateResidence;
	}
	
	public void setPrivateResidence(boolean privateResidence) {
		this.privateResidence = privateResidence;
	}
	

	public int getYearBought() {
		return yearBought;
	}

	public void setYearBought(int yearBought) {
		this.yearBought = yearBought;
	}
	
	public String toString(){
		String temp;
		if (privateResidence == true){
			temp = "Yes";
		}else {
			temp = "No";
		}
		String temp2 = null;
		if(location == 1){
			temp2 = "City";
		}else if(location == 2){
			temp2 = "Large town";
		}else if(location == 3){
			temp2 = "Small town";
		}else if(location == 4){
			temp2 = "Village";
		}else if(location == 5){
			temp2 = "Countryside";
		}
		return ("Address:\n" + address + "\n" + eircode + "\n\nEstimated market value: " + estMarketVal

				+ "\nLocation type: " + temp2 + "\nYear Bought:  " + yearBought + "\nPrinciple private Residence: " + temp + "\n\n");
	}
}
