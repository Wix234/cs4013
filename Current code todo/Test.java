public class Test {

	public static void main(String[] args) {
		Property p1 = new Property("23 limerick", "12423", 3221974.00, 2, true);
		Property p2 = new Property("3 limerick", "1213423", 3221972144.00, 2, false);
		System.out.println(p1.toString());
		TaxCal tax1 = new TaxCal(p1);
		System.out.println(tax1.totalTax());

		System.out.println("\nNow printing Conors stuff\n");
		Owner o1 = new Owner("Troy Barnes", "4 Maple Road", "H4T5");
		o1.addProperties(p1);
		o1.addProperties(p2);
		System.out.println(Owners.getOwnersProperties(o1));
	}

}
