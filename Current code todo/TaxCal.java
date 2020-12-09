
public class TaxCal {
	private double fixedTax = 100;
	private double marketVal;
	private double location;
	private boolean privateResidence;
	private double totalTax;
	
	
	public TaxCal(Property p){
		marketVal = p.getEstMarketVal();
		location = p.getLocation();
		privateResidence = p.isPrivateResidence();
	}

	public double estMarketValTax(){
		double taxMarketVal = 0;
		if(marketVal < 150000){
				taxMarketVal = 0;
			}else if (marketVal >= 150000 && marketVal <= 400000){
				taxMarketVal = (marketVal * 0.01);
			}else if (marketVal >= 400001 && marketVal <= 650000){
				taxMarketVal = (marketVal * 0.02);
			}else if (marketVal > 650001){
				taxMarketVal = (marketVal * 0.04);
			}
		return taxMarketVal;
	}
	
	public double taxLocation(){
		double taxLocation = 0;	
		if(location == 1){
				taxLocation = 100;
			}else if(location == 2){
				taxLocation = 80;
			}else if(location == 3){
				taxLocation = 60;
			}else if(location == 4){
				taxLocation = 50;
			}else if(location == 5){
				taxLocation = 25;
			}
		return taxLocation;
	}
	
	public double residenceTax(){

		double privateResTax;	
		if (privateResidence == true){
				privateResTax = 100;
			}else {
				privateResTax = 0;
			}	
		
		return privateResTax;
	}
	
	public double getTotalTax(Property p){
		totalTax = (fixedTax + taxLocation() + estMarketValTax()  + residenceTax());
		return totalTax;
	}
	
	
	public String taxInformation(){
		return ("FT:" + fixedTax  + " | MT:" + marketVal + " | TL:" + location + " | PR:" + privateResidence);
	}
	
}
