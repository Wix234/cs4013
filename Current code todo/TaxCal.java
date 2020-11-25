
import java.util.ArrayList;

public class TaxCal {
	private ArrayList<Property> properties;
	private double fixedTax = 100;
	private double taxMarketVal;
	private double taxLocation;
	private double privateResidence;
	
	public TaxCal(Property p){
		properties = new ArrayList<Property>();
		properties.add(p);
	}
	
	public void addProperty(Property p){
		properties.add(p);
	}
	
	public double estMarketValTax(){
		Property p;
		for(int i = 0; i < properties.size(); i++){
			p = properties.get(i);
			if(p.getEstMarketVal() < 150000){
				taxMarketVal = 0;
			}else if (p.getEstMarketVal() >= 150000 && p.getEstMarketVal() <= 400000){
				taxMarketVal = (p.getEstMarketVal() * 0.01);
			}else if (p.getEstMarketVal() >= 400001 && p.getEstMarketVal() <= 650000){
				taxMarketVal = (p.getEstMarketVal() * 0.02);
			}else if (p.getEstMarketVal() > 650001){
				taxMarketVal = (p.getEstMarketVal() * 0.04);
			}
		}
		return taxMarketVal;
	}
	
	public double taxLocation(){
		Property p;
		for(int i = 0; i < properties.size(); i++){
			p = properties.get(i);
			if(p.getLocation() == 1){
				taxLocation = 100;
			}else if(p.getLocation() == 2){
				taxLocation = 80;
			}else if(p.getLocation() == 3){
				taxLocation = 60;
			}else if(p.getLocation() == 4){
				taxLocation = 50;
			}else if(p.getLocation() == 5){
				taxLocation = 25;
			}
		}
		return taxLocation;
	}
	
	public double residenceTax(){
		Property p;
		for(int i = 0; i < properties.size(); i++){
			p = properties.get(i);
			if (p.isPrivateResidence() == true){
				privateResidence = 100;
			}else {
				privateResidence = 0;
			}	
		}
		return privateResidence;
	}
	
	public String totalTax(){
		return ("\nFT:" + fixedTax  + "\nMT:" + taxMarketVal + "\nTL:" + taxLocation + "\nPR:" + privateResidence);
	}
}
