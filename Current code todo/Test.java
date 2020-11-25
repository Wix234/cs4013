public class Test {

	public static void main(String[] args) {
		Property p1 = new Property("23 limerick", "12423", 3221974.00, 2, true);
		System.out.println(p1.toString());
		TaxCal tax1 = new TaxCal(p1);
		System.out.println(tax1.totalTax());
		
	}

}
