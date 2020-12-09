
public class Tax {
	private String taxInfo;
	private double total;
	
	public Tax() {
	}
	public Tax(String info, double total) {
		setTaxInfo(info);
		setTotal(total);
	}
	
	public String getTaxInfo() {
		return taxInfo;
	}

	public void setTaxInfo(String taxInfo) {
		this.taxInfo = taxInfo;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String taxInfo(Property p) {
		TaxCal tax = new TaxCal(p);
		return (tax.taxInformation() + " | Total tax is:" + tax.getTotalTax(p));
	}
	
	public String toString() {
		return (taxInfo + total + "\n" );
	}
	
}

