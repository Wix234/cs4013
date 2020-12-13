import java.time.LocalDate;
import java.time.Year;
//new class
public class Payments {
	
	private double toPay;
	private double paid;
	private int yearPaid;
	private int curYear = Year.now().getValue();
	private String address;
	private int year;
	
	public Payments(String address, double toPay){
		 setAddress(address);
		 setToPay(toPay);
		 setPaid(0);
		 setYearPaid(0);
		 setYear(0);
	}
	public Payments(String address, int year, double toPay, double paid, int yearPaid){
		 setAddress(address);
		 setToPay(toPay);
		 setPaid(paid);
		 if (yearPaid == 0){
			 setYearPaid(curYear);
		 }else{
			 setYearPaid(yearPaid);
		 }
		 setYear(year);
	}
	public double getToPay() {
		return toPay;
	}
	public void setToPay(double toPay) {
		this.toPay = toPay;
	}
	public double getPaid() {
		return paid;
	}
	public void setPaid(double paid) {
		this.paid = paid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getYearPaid() {
		return yearPaid;
	}
	public void setYearPaid(int yearPaid) {
		this.yearPaid = yearPaid;
	}
	
	public String toString(){
		return (address + " " + year + " " + toPay + " " +paid + " "+ yearPaid +"\n");
	}
	
}
